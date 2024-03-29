package com.example.logging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${numbers.first}")
    private Integer num1;

    @Value("${numbers.second}")
    private Integer num2;

    public String power() {
        logger.info("Start calculation");
        int power1 = num1 * num1;
        int power2 = num2 * num2;

        logger.info("finished calculation ");
        return power1 + " - " + power2;
    }
}
