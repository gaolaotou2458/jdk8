package com.higer.jvm;

import org.junit.Test;
import org.omg.SendingContext.RunTime;

/**
 * 线程A本地内存共享变量副本改变,让线程B共享内存直接得到改变
 * 需要用volatile关键字 一个线程修改了变量,其他线程可以立即知道
 */
public class VolatileTest extends Thread{
    //private volatile boolean stop = false;
    private boolean stop = false;  //这么写下面代码不会停止,因为没有更新内存中的stop
    public void stopMe(){
        stop = true;
    }

    public void run(){
        int i = 0;
        while(!stop){
            i++;
            //System.out.println(i);
        }
        System.out.println("Stop thread");
    }

    @Test
    public void test1() throws InterruptedException {
        VolatileTest t = new VolatileTest();
        t.start();
        Thread.sleep(1000);
        t.stopMe();
        Thread.sleep(1000);
    }


    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
    }


}
