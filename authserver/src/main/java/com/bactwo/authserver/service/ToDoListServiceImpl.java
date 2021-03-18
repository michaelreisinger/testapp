package com.bactwo.authserver.service;

import com.bactwo.authserver.client.ResourceAPI;
import com.bactwo.authserver.client.ResourceAPIImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoListServiceImpl implements ToDoListService {

    private final ResourceAPI resourceAPI;

    @Autowired
    public ToDoListServiceImpl(ResourceAPIImpl resourceAPI) {
        this.resourceAPI = resourceAPI;
    }


}
