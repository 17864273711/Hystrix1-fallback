//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.demo.controller;

import com.example.demo.serveice.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloConsumer {
    @Autowired
    HelloService helloService;

    public helloConsumer() {
    }

    @GetMapping({"/ribbon-consumer"})
    public String helloConsumer() {
       return this.helloService.helloService();
    }
}
