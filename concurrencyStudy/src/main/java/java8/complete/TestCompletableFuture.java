package java8.complete;

import java.util.concurrent.CompletableFuture;

public class TestCompletableFuture {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {

        /**
         * 以Async结尾的方法都是可以异步执行的，如果指定了线程池，会在指定的线程池中执行，
         * 如果没有指定，默认会在ForkJoinPool.commonPool()中执行
         *
         * 方法表示进行值的变换。
         * thenApply:
         * thenApplyAsync:它们的入参是上一个阶段计算后的结果，返回值是经过转化后结果
         *
         * 方法表示进行值的消耗。
         * thenAccept:
         * thenAcceptAsync:针对结果进行消耗，因为他的入参是Consumer，有入参无返回值
         *
         */
        CompletableFuture.supplyAsync(() -> "hello").thenApplyAsync((s) -> s + " World").
                thenAcceptAsync(System.out::println);

    }


}
