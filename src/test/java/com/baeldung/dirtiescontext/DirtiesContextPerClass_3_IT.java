package com.baeldung.dirtiescontext;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringDataRestApplication.class)
@EnableWebMvc
@DirtiesContext
class DirtiesContextPerClass_3_IT {

    @Autowired
    protected UserCache userCache;

    @BeforeAll
    static void startOfTestClass() {
        System.out.println();
        System.out.println("Starting with tests in class DirtiesContextPerClass_3_IT");
        System.out.println();
    }

    @Test
    void addJohnDoeAndPrintCache() {
        userCache.addUser("John Doe2");
        userCache.printUserList("addJohnDoeAndPrintCache");
    }
}
