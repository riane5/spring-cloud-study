package com.riane.spcsleuthclient11.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
public class MyController {

    /**
     * 从上一级过来的请求可能包含一下字段：
     * x-b3-traceid 一条请求链路的唯一标志
     * x-b3-spanid 一个工作单元的唯一标识
     * x-b3-parentspanid 标识当前工作单元所属的上一个工作单元，Root Span（链路的第一个工作单元）的该值为空
     * x-b3-sampled 是否被抽样输出烦人标识，1标识需要被输出，0标识不需要被输出，表示是否要被后续的跟踪信息收集器获取和存储
     * x-span-name 工作单元的名称
     *
     * @param servletRequest
     * @return
     */
    @GetMapping("/test1")
    public String test1(HttpServletRequest servletRequest) {
        Enumeration<String> headerNames = servletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String nextElement = headerNames.nextElement();
            System.out.println("header info is " + nextElement + ": " + servletRequest.getHeader(nextElement));
        }
        return "this is test1 in sleuth-clirnt-1.1";
    }


}
