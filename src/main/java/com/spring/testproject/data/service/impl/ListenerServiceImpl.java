package com.spring.testproject.data.service.impl;

import com.spring.testproject.data.entity.ListenerEntity;
import com.spring.testproject.data.service.ListenerService;
import com.spring.testproject.repository.ListenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListenerServiceImpl implements ListenerService {

    ListenerRepository listenerRepository;

    @Autowired
    public ListenerServiceImpl(ListenerRepository listenerRepository) {
        this.listenerRepository = listenerRepository;
    }

    @Override
    public ListenerEntity getEntity(Long id) {
        return listenerRepository.findById(id).get();
    }

    @Override
    public void saveEntity(ListenerEntity listenerEntity) {
        listenerRepository.save(listenerEntity);
    }

    @Override
    public void updateEntity(ListenerEntity listenerEntity) {
        // 데이터베이스에서 해당 값을 찾고
        ListenerEntity foundListener = listenerRepository.findById(listenerEntity.getId()).get();
        // Entity의 name값을 변경 후
        foundListener.setName(listenerEntity.getName());
        
        // 변경 된 name값을 데이터베이스에 반영
        listenerRepository.save(foundListener);
    }

    @Override
    public void removeEntity(ListenerEntity listenerEntity) {
        listenerRepository.delete(listenerEntity);
    }
}
