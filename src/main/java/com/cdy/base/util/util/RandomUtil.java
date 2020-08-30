package com.cdy.base.util.util;

import java.util.Random;
import java.util.UUID;

public class RandomUtil {

    private static final Random random = new Random();

    private RandomUtil() {
    }

    /**
     * [lowerLimit,upperLimit)
     */
    public static int nextInt(int lowerLimit, int upperLimit) {
        if (lowerLimit >= upperLimit) {
            throw new IllegalArgumentException("lowerLimit >= upperLimit");
        }
        // [0+,+)
        if (lowerLimit >= 0) {
            return random.nextInt(upperLimit - lowerLimit) + lowerLimit;
        }
        // [-,+)
        if (upperLimit > 0) {
            return random.nextInt(upperLimit + Math.abs(lowerLimit)) + lowerLimit;
        }
        // [-,-0)
        return random.nextInt(Math.abs(lowerLimit) + upperLimit) + lowerLimit;
    }

    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    public static String shortUUID() {
        return UUID.randomUUID().toString().split("-")[4];
    }

}
