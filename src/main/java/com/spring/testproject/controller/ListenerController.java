package com.spring.testproject.controller;

import com.spring.testproject.data.entity.ListenerEntity;
import com.spring.testproject.data.service.ListenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listener")
public class ListenerController {
    private ListenerService listenerService;

    @Autowired
    public ListenerController(ListenerService listenerService) {
        this.listenerService = listenerService;
    }

    @GetMapping
    public String getListener(Long id) {
        listenerService.getEntity(id);

        return "ok";
    }

    @PostMapping
    public void saveListener(Long id, String name) {
        ListenerEntity listenerEntity = new ListenerEntity();
        listenerEntity.setId(id);
        listenerEntity.setName(name);

        listenerService.saveEntity(listenerEntity);
    }

    @PutMapping
    public void updateListener(Long id, String name) {
        ListenerEntity listenerEntity = new ListenerEntity();
        listenerEntity.setId(id);
        listenerEntity.setName(name);

        listenerService.updateEntity(listenerEntity);
    }

    @DeleteMapping
    public void deleteListener(Long id) {
        ListenerEntity listenerEntity = listenerService.getEntity(id);

        listenerService.removeEntity(listenerEntity);
    }
}
