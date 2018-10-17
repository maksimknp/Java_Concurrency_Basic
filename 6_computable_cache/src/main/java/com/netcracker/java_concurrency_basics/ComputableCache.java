package com.netcracker.java_concurrency_basics;

import java.util.HashMap;
import java.util.Map;

public class ComputableCache<K, V> {
    private final Map<K, V> cache = new HashMap<>();

    public synchronized V compute(K key) {
        V res = cache.get(key);

        if (res == null) {
            res = computeExpensive(key);

            cache.put(key, res);

            System.out.println(Thread.currentThread().getName() + ": miss");
        } else {
            System.out.println(Thread.currentThread().getName() + ": hit");
        }

        return res;
    }

    private V computeExpensive(K key) {
        // Very expensive computation.
        return (V) new Object();
    }
}
