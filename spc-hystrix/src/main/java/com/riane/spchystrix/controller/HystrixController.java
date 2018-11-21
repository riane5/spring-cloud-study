package com.riane.spchystrix.controller;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.riane.spchystrix.service.MyCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String appName = "http://eureka-client/eclient/";

    private volatile ConcurrentHashMap<String, MyCommandService> services = new ConcurrentHashMap<>();

    /**
     * 了解注解@DefaultProperties
     * commandProperties = {@HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY, value = "")}
     * <p>
     * 只能同步执行
     *
     * @param name
     * @return
     */
    //@CacheResult
    //@HystrixCollapser()
    @HystrixCommand(fallbackMethod = "errMethod")
    @RequestMapping("/hystrix-client/{name}")
    public String hello(@PathVariable("name") @CacheKey String name) {
        //HystrixRequestContext.initializeContext();
        //HystrixCircuitBreaker.Factory.getInstance().
        String object = restTemplate.getForObject(appName + name, String.class);
        return object;
    }

    /**
     * HystrixCollapser 用于合并请求，其中@HystrixProperty 可以配置的参数参考 HystrixCollapserProperties.java
     *
     * @param name
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */

    // @HystrixCollapser(batchMethod = "findAll",collapserProperties = {@HystrixProperty(name = "",value = "")})
    @RequestMapping("/command-client/{name}")
    public String commandHello(@PathVariable("name") String name) throws ExecutionException, InterruptedException {
        MyCommandService myCommandService = new MyCommandService(name, restTemplate);
        Future<String> future = myCommandService.queue();
        return future.get();
    }

    /**
     * 可以异步执行
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "errMethod")
    @RequestMapping("/async/hystrix-client/{name}")
    public Future<String> helloAsync(@PathVariable("name") String name) {
        return new AsyncResult<String>() {
            /**
             * {@inheritDoc}.
             */
            @Override
            public String invoke() {
                return restTemplate.getForObject(appName + name, String.class);
            }
        };
    }

    /**
     * 响应式执行,注意@HystrixCommand注解的参数observableExecutionMode来确定用observable方法还是toObservable方法来加载数据
     *
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "errMethod")
    @RequestMapping("/async/observe/hystrix-client/{name}")
    public Observable<String> helloAsyncObserve(@PathVariable("name") String name) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    if (!subscriber.isUnsubscribed()) {
                        String object = restTemplate.getForObject(appName + name, String.class);
                        subscriber.onNext(object);
                        subscriber.onCompleted();
                    }
                } catch (Exception ex) {
                    subscriber.onError(ex);
                }
            }
        });
    }


    //可以参形参里面用Throwable e来指定异常参数，根据异常的不同处理结果
    public String errMethod(String name, Throwable ex) {
        System.out.println(ex.toString());
        return "error " + name + "," + ex.toString();
    }
}
