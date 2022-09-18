package com.wenwan.service.util;

import com.wenwan.common.exception.BusinessException;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AsyncExecutor {

    public static void wait(List<Future<?>> futures) {
        futures.forEach(AsyncExecutor::wait);
    }

    public static void wait(List<Future<?>> futures, int sec) {
        futures.forEach(future -> {
            wait(future, sec);
        });
    }

    public static void wait(Future<?> future) {
        try{
            future.get();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }

    public static void wait(Future<?> future, int sec) {
        try{
            future.get(sec, TimeUnit.SECONDS);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }
}
