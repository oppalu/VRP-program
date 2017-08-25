package com.phoebe.service;

import com.phoebe.model.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by phoebegl on 2017/8/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MemberServiceTest {

    @Autowired
    private ServerService service;

    private Logger logger;

    @Before
    public void setUp() {
        logger = LogManager.getLogger("servicetest");
    }

    @Test
    public void testSelectAll() {
        try {
            List<Server> list = service.selectAll();
            if(list.isEmpty())
                logger.info("list is empty");
            for(Server m : list) {
                logger.info("name: "+m.getName());
            }
        } catch (Exception e) {
            logger.error(e.getStackTrace().toString());
        }
    }

}
