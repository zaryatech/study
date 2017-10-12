package ru.zaryatech.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.zaryatech.study.entity.TestEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Простой сервис
 */
@RestController
@RequestMapping(value = "/testService")
public class TestService {

    @Value("${TestProperty:3}")
    private Integer value;

    private Logger logger = LoggerFactory.getLogger(TestService.class);

    @PersistenceContext
    private EntityManager em;



    @ResponseBody
    @RequestMapping(value = "/hello", method= RequestMethod.POST)
    public String hello(@RequestBody String hello) {
        logger.debug("hello {} {}",hello, value);
        helloPersist(hello);
        return "hello from server " + hello;
    }


    @Autowired
    TestService self;


    // означает что метод в транзакции
    // ( создается обертка с tx.start ... tx.commit )
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/helloPersist", method= RequestMethod.POST)
    public String helloPersist(@RequestBody String hello) {
        try {
            TestEntity testEntity = new TestEntity();
            testEntity.setHello(hello);
            em.persist(testEntity);
            return "hello from server " + hello;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
