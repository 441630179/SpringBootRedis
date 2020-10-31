package com.study.bean;

import com.study.service.ServiceRedis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.UnsupportedEncodingException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentTest {
    @Autowired
    private Student student;


    @Test
    public void testStudent() {
        try {
            student.setName("谭朋伟1r");
            System.out.println(student.getName().getBytes("UTF-8").length);
            System.out.println(student.getName().getBytes("GBK").length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}