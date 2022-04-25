package com.lyq.javautils.bloomfilter;

import java.io.Serializable;

/**
 * BloomFilter基本方法接口定义
 */
public interface BloomFilter extends Serializable {

    boolean contains(String str);

    boolean add(String str);
}
