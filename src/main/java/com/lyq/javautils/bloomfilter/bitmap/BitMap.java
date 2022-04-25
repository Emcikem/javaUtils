package com.lyq.javautils.bloomfilter.bitmap;

/**
 * int和long类型的bitmap接口定义
 */
public interface BitMap {

    void add(long value);

    boolean contains(long value);

    void remove(long value);
}
