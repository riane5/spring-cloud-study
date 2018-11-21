package com.riane.spchystrix.service;

import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class MyCommandService extends HystrixCommand<String> {

    private String key;

    private RestTemplate restTemplate;

    private static final String appName = "http://eureka-client/hello/";

    public MyCommandService(String key, RestTemplate restTemplate) {
        //super(group);
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("groupKey" + key))
                .andCommandKey(HystrixCommandKey.Factory.asKey(key))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("threadKey" + key)));
        this.key = key;
        this.restTemplate = restTemplate;
    }

    /**
     * Implement this method with code to be executed when {@link #execute()} or {@link #queue()} are invoked.
     *
     * @return R response type
     * @throws Exception if command execution fails
     */
    @Override
    protected String run() throws Exception {
        String object = restTemplate.getForObject(appName + this.key, String.class);
        return object;
        //return null;
    }


    @Override
    protected String getFallback() {
        Throwable throwable = getExecutionException();
        return "command error" + this.key + "," + throwable.toString();
    }

    /**
     * 开启缓存，返回缓存的key值
     */
    @Override
    protected String getCacheKey() {
        return this.key;
    }

    /**
     * 刷新缓存信息，对失效缓存的一种清理
     * 应用场景：当对已经缓存的信息进行过修改等变化之后，需要对当前缓存的信息进行清除以便下次请求可以得到最新的信息
     *
     * @param id
     */
    public void flushCache(String id) {
        HystrixRequestCache.getInstance(HystrixCommandKey.Factory.asKey(this.key),
                HystrixConcurrencyStrategyDefault.getInstance())
                .clear(id);
    }

}
