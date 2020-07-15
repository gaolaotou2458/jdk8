package com.higer.jvm;

import org.junit.Test;

public class test1 {

    public static void 打印(){
        System.out.println("中文方法");
    }

    //打印整数的二进制表示
    /*
    0x80000000的值为 -2^31
    1后面的31位表示序号位，0...0【类似于数组中的0号位】，表示负数中的最小的一位。由于int的最小值为-2^31,排在负数从小到大的第0位，所以int i = 0x80000000 为 -（2^31）+ 0 = -2^31
    */
    @Test
    public void test2(){
        int a = -6;
        for(int i=0;i<32;i++) {
            int t = (a & 0x80000000 >>> i) >>> (31 -i); {
                System.out.print(t);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf(0x80000000));

        System.out.println();
    }
}

