package com.bezkoder.spring.hibernate.onetomany.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TaskTests {

    @Autowired
    private CommentController commentController;

    @Test
    void contentLoads() throws Exception {
       assertThat(commentController).isNotNull();

    }
}
