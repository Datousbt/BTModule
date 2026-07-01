package com.datousbt.btautomation.util;

import java.util.HashMap;
import java.util.Map;

public class Debouncer {

    private static final Map<String, Long> map =
            new HashMap<>();

    public static boolean allow(
            String key,
            long delay) {

        long now =
                System.currentTimeMillis();

        Long last =
                map.get(key);

        if (last != null &&
                now - last < delay)
            return false;

        map.put(key, now);

        return true;
    }
}