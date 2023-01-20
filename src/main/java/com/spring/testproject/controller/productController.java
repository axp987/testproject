package com.spring.testproject.controller;

import com.spring.testproject.data.dto.ProductDto;
import com.spring.testproject.data.entity.ProductEntity;
import com.spring.testproject.data.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/product-api")
public class productController {
    private ProductService productService;

    // logback 설정
    //getLogger(pattern 태그에 %logger)
    private final Logger LOGGER = LoggerFactory.getLogger(productController.class);

    @Autowired
    public productController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public ProductDto getHaveDto(@PathVariable("productId") String productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/product/productAll")
    public List<ProductDto> getAllDto() {
        return productService.getAllProduct();
    }

    @PostMapping("/product")
    public ProductDto postSaveDto(@RequestBody ProductDto productDto) {
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }

    @PostMapping("/product/save")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        ProductDto response = productService.saveEntityProduct(productId, productName, productPrice, productStock);

        // 가독성 저하로 인해 되도록 지향하고 어노테이션을 이용한 Logger를 사용하자
        if(productDto.getProductId().equals("") || productDto.getProductId().isEmpty()) {
            LOGGER.error("[createProduct] failed Response :: productId is Empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productDto);
            // HttpStatus.BAD_REQUEST를 통해 HTTP 에러반환 코드 생성, DTO 오류값 반환
        }

        LOGGER.info(
                "[createProduct] Response >> productId: {}, productName: {}, productPrice: {}, productStock: {}",
                response.getProductId(), response.getProductName(), response.getProductPrice(), response.getProductStock()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 로그백 처리
    @GetMapping(value = "/log-test/{productId}")
    public ProductDto logTest(@PathVariable String productId) {
        // 로그 레벨 출력
        LOGGER.trace("Trace Log");
        LOGGER.debug("Debug Log");
        LOGGER.info("Info Log");
        LOGGER.warn("Warn Log");
        LOGGER.error("Error Log");

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController] perform {} of Lee Test Project.", "getProduct");

        ProductDto productDto = productService.getProduct(productId);
        // LOGGER는 {} 중괄호를 통해 뒤에 값을 채워 넣어줄 수 있다.
        LOGGER.info("[ProductController] Response :: productId = {}," +
                "productName = {}, " +
                "productPrice = {}, " +
                "productStock = {}, " +
                "Response Time = {}ms",
                productDto.getProductId(),
                productDto.getProductName(),
                productDto.getProductPrice(),
                productDto.getProductStock(),
                (System.currentTimeMillis() -startTime)
        );

        return productDto;
    }

    /** 예외 처리 시작 */
    @PostMapping("/exception")
    public void exceptionTest() throws Exception {
        throw new Exception();
    }

/*
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
        HttpHeaders responseHeaders = new HttpHeaders();

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;


        //LOGGER.info(e.getLocalizedMessage());
        LOGGER.info(e.getMessage());
        LOGGER.info("Controller 내 ExceptionHandler 호출");

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("massage", "에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);

    }
*/
    /* 예외 처리 시작 끝 */
}
