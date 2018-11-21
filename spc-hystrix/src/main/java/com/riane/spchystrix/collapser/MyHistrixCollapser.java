package com.riane.spchystrix.collapser;

import com.netflix.hystrix.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MyHistrixCollapser extends HystrixCollapser<List<String>, String, Long> {

    private Long id;

    public MyHistrixCollapser(String id) {
        super(com.netflix.hystrix.HystrixCollapser.Setter.withCollapserKey(HystrixCollapserKey.Factory.asKey(id)).andCollapserPropertiesDefaults(
                HystrixCollapserProperties.Setter().withTimerDelayInMilliseconds(2000)
        ));
        this.id = Long.parseLong(id);
    }

    @Override
    public Long getRequestArgument() {
        return this.id;
    }

    @Override
    protected HystrixCommand<List<String>> createCommand(Collection<CollapsedRequest<String, Long>> collapsedRequests) {
        List<Long> ids = new ArrayList<>();
        //获取过去两秒钟收到的所有请求的请求参数的集合
        Iterator<CollapsedRequest<String, Long>> iterator = collapsedRequests.iterator();
        while (iterator.hasNext()) {
            CollapsedRequest<String, Long> next = iterator.next();
            Long argument = next.getArgument();
            ids.add(argument);
        }
        //此处可以返回一个可以进行批处理的command对象
        return null;
    }

    @Override
    protected void mapResponseToRequests(List<String> batchResponse, Collection<CollapsedRequest<String, Long>> collapsedRequests) {
        int index = 0;
        for (CollapsedRequest<String, Long> collapsedRequest : collapsedRequests) {
            collapsedRequest.setResponse(batchResponse.get(index++));
        }
    }
}
