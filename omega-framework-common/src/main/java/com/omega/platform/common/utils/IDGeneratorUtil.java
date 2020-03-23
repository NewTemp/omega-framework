package com.omega.platform.common.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description Happy!
 * @Author Allen.Lv
 * @Date 3/23/2020
 * @Time 11:59 PM
 */
public class IDGeneratorUtil {
    public static long getId() {
        return new IdWorker(
                ThreadLocalRandom.current().nextLong(IdWorker.maxWorkerId),
                ThreadLocalRandom.current().nextLong(IdWorker.maxDatacenterId)
        ).nextId();
    }
}
