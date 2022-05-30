package com.baeldung.dirtiescontext;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringDataRestApplication.class)
@EnableWebMvc
class DirtiesContextPerMethodIT {

    @Autowired
    protected UserCache userCache;

    @BeforeAll
    static void startOfTestClass() {
        System.out.println();
        System.out.println("Starting with tests in class DirtiesContextPerMethodIT");
        System.out.println();
    }

    @Test
    @Order(1)
    void addJaneDoeAndPrintCache() {
        userCache.addUser("Jane Doe1");
        userCache.printUserList("addJaneDoeAndPrintCache");
    }

    @Test
    @Order(2)
    void printCache() {
        userCache.printUserList("printCache");
    }

    @DirtiesContext
    @Test
    @Order(3)
    void addJohnDoeAndPrintCache() {
        userCache.addUser("John Doe2");
        userCache.printUserList("addJohnDoeAndPrintCache");
    }

    @Test
    @Order(4)
    void printCacheAgain() {
        userCache.printUserList("printCacheAgain");
    }

}

