package com.example.batch.controllers;

import com.example.batch.BatchApplication;
import com.example.batch.builders.ResponseBuilder;
import com.example.batch.models.Person;
import com.example.batch.services.APIConsumerService;
import com.example.batch.services.CSVHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/backend/v1/")
public class BackendController {

    @Autowired
    APIConsumerService consumerService;

    @Autowired
    CSVHandlerService csvHandlerService;

    @GetMapping("/consumeMarvelAPIGet")
    public ResponseEntity<Object> consumeAPI() {
        ResponseBuilder response = this.consumerService.consume(BatchApplication.URL_MARVEL + BatchApplication.AUTH_MARVEL, 100, 0);

        return new ResponseEntity<>(response, response.getStatus());
    }

    @PostMapping("/peopleCSV")
    public ResponseEntity<Object> addPersonToCSV(@RequestBody Person person) {
        ResponseBuilder response = this.csvHandlerService.addToCSV("people", person);

        return new ResponseEntity<>(response.getData(), response.getStatus());
    }

}
