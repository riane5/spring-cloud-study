package com.riane.spceurekaclient.controller;

import com.alibaba.fastjson.JSONObject;
import com.netflix.discovery.endpoint.EndpointUtils;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/test/rest")
    public String testRset(@RequestBody JSONObject object) throws Exception {
        System.out.println(object);
        byte[] bytes = object.getBytes("fileData");
        File file = new File("E:\\StudyCodes\\SpringCloud\\pic\\hello.jpg");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.flush();
        fos.close();
        return "200";
    }


    @RequestMapping("/hello")
    public String hello2() {
        return "hello this is client";
    }

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return "Hello " + name + ", this is clent";
    }

    @RequestMapping("/eclient/{name}")
    public String helloClient(@PathVariable("name") String name) {
        return "Hello " + name + ", this is clent";
    }

    @RequestMapping("/eclient2/{name}")
    public String hello2(@PathVariable("name") String name) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello" + name;
    }

    @GetMapping("/mete")
    public String metaData() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            if (service.equalsIgnoreCase("eureka-client")) {
                List<ServiceInstance> instances = discoveryClient.getInstances(service);
                for (ServiceInstance serviceInstance : instances) {
                    String name = serviceInstance.getMetadata().get("name");
                    String age = serviceInstance.getMetadata().get("age");
                    return "name: " + name + ",age: " + age;
                }
            }
        }
        return "";
    }

    @PostMapping("/test/rest2")
    public int testRset2(@RequestBody JSONObject object) throws Exception {
        System.out.println(object);

        return 200;
    }

    @PostMapping("/test/rest3")
    public HttpResponseStatus testRset3(@RequestBody JSONObject object) throws Exception {
        System.out.println(object);

        return HttpResponseStatus.OK;
    }

}
