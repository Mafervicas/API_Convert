package com.ford.numbers.controller;

import com.ford.numbers.entities.NumberToConvert;
import com.ford.numbers.services.INumberService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/number")
@Slf4j
public class ConversionNumbers {

    private final INumberService iNumberService;

    public ConversionNumbers(INumberService iNumberService) {
        this.iNumberService = iNumberService;
    }

    @PostMapping(value = "/send")
    public ResponseEntity<Integer> SendPetition (@Valid @RequestBody NumberToConvert numberToConvert) {
        log.debug("Start process");
        Integer result = iNumberService.returnRomanNumber(numberToConvert);
        log.debug("Process ended");
        if(Objects.isNull(result)){
            throw new IllegalArgumentException("Invalid Input");
        }
        return ResponseEntity.ok(result);
    }
}
