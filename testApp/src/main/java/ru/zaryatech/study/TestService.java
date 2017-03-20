package ru.zaryatech.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Простой сервис
 */
@RestController
@RequestMapping(value = "/testService")
public class TestService {

    @Value("${TestProperty:3}")
    private Integer value;

    private Logger logger = LoggerFactory.getLogger(TestService.class);

    @ResponseBody
    @RequestMapping(value = "/hello", method= RequestMethod.POST)
    public String hello(@RequestBody String hello) {
        logger.debug("hello {} {}",hello, value);
        return "hello from server " + hello;
    }



}
