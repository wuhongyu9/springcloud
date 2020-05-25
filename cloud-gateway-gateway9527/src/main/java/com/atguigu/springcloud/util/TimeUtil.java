package com.atguigu.springcloud.util;

import java.time.ZonedDateTime;

public class TimeUtil {
    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt.toString());
    }
}
