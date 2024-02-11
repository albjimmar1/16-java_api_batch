package com.example.batch.controllers;

import com.example.batch.BatchApplication;
import com.example.batch.builders.ResponseBuilder;
import com.example.batch.services.APIConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/backend/v1/")
public class BackendController {

    @Autowired
    APIConsumerService consumerService;

    @GetMapping("/consumeMarvelAPIGet")
    public ResponseEntity<Object> consumeAPI() {
        ResponseBuilder response = this.consumerService.consume(BatchApplication.URL_MARVEL + BatchApplication.AUTH_MARVEL, 100, 0);

        return new ResponseEntity<>(response, response.getStatus());
    }

}
