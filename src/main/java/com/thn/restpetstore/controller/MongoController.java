package com.thn.restpetstore.controller;

import com.thn.restpetstore.entity.Car;
import com.thn.restpetstore.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/test")
public class MongoController {

    private final MongoService mongoService;

    @Autowired
    public MongoController(MongoService mongoService) {
        this.mongoService = mongoService;
    }

    @PostMapping
    public ResponseEntity<?> saveCarInMongo(@RequestBody Car newCar){
        mongoService.save(newCar);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/img", consumes = "multipart/form-data")
    public ResponseEntity<String> saveImageInMongo(@RequestParam(value = "image") MultipartFile image){
        String fileName = mongoService.save(image);
        return new ResponseEntity<>(fileName, HttpStatus.CREATED);
    }
}
