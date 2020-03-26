package com.example.coursecommunity.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    //告诉SpringBoot这是一个异步任务，SpringBoot会自动开启一个线程去执行
    @Async
    public void testAsyncService(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行异步成功");
    }
}