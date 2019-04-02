package com.example.demo.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: YanLong
 * @Description:
 * @Date: Created in 11:02 2018/11/20
 */
//@Component
//@EnableAsync
public class task {

    @Async("myExecutor")
    @Scheduled(cron = "0 0/1 * * * ? ")
    public void task1(){
        System.out.println(Thread.currentThread().getName()+"||1");
    }

    @Async("myExecutor")
    @Scheduled(cron = "0 0/2 * * * ? ")
    public void task2(){
        System.out.println(Thread.currentThread().getName()+"||2");
    }
    @Async("myExecutor")
    @Scheduled(cron = "0 0/1 * * * ? ")
    public void task3(){
        System.out.println(Thread.currentThread().getName()+"||3");
    }

    @Async("myExecutor")
    @Scheduled(cron = "0 0/2 * * * ? ")
    public void task4(){
        System.out.println(Thread.currentThread().getName()+"||4");
    }
    @Async("myExecutor")
    @Scheduled(cron = "0 0/1 * * * ? ")
    public void task5(){
        System.out.println(Thread.currentThread().getName()+"||5");
    }

    @Async("myExecutor")
    @Scheduled(cron = "0 0/2 * * * ? ")
    public void task6(){
        System.out.println(Thread.currentThread().getName()+"||6");
    }
}
