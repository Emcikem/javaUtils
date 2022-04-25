package com.lyq.javautils.bloomfilter.filter;

import com.lyq.javautils.bloomfilter.BloomFilter;


/**
 *  布隆过滤器的hash算法
 */
public abstract class AbstractFilter implements BloomFilter {


    @Override
    public boolean contains(String str) {
        return false;
    }

    @Override
    public boolean add(String str) {
        return false;
    }

    public abstract long hash(String str);
}
