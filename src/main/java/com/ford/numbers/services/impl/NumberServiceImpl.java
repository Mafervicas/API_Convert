package com.ford.numbers.services.impl;

import com.ford.numbers.entities.NumberToConvert;
import com.ford.numbers.services.INumberService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NumberServiceImpl implements INumberService {
    @Override
    public Integer returnRomanNumber(NumberToConvert numberToConvert) {
        //Map with possibilities
        Map<Character, Integer> romanMapping = new HashMap<>();
        romanMapping.put('I', 1);
        romanMapping.put('V', 5);
        romanMapping.put('X',10);
        romanMapping.put('L', 50);
        romanMapping.put('C', 100);

        //Variables that will be used
        int stringLengthPrevious = 0;
        int intConverted = 0;

        String romanString = numberToConvert.getNumberUser();

        try {
        //For that will be covering all string
        for(int i = romanString.length() -1; i >= 0; i--){

            int valueString = romanMapping.get(romanString.charAt(i));
            //Validate length
            if(valueString < stringLengthPrevious){
                //If less then substract
                intConverted-= valueString;
            } else {
                //If more then add
                intConverted += valueString;
            }

            stringLengthPrevious = valueString;
        }
        } catch (Exception e){
            return null;
        }
        return intConverted;

    }
}
