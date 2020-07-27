//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.demo.serveice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    public HelloService() {
    }

    //降级方法名为同类下的fallback，并且RuntimeException出现时不会触发降级处理
    @HystrixCommand(
            fallbackMethod = "fallback",ignoreExceptions = {RuntimeException.class}
    )
    public String helloService() {
        return (String)this.restTemplate.getForEntity("http://hello-service/hello", String.class, new Object[0]).getBody();
    }


    //在降级方法中处理异常
    public String fallback(Throwable e) {
        return "error"+e.getMessage();
    }
}
