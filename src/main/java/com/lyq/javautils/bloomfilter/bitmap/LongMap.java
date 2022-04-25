package com.lyq.javautils.bloomfilter.bitmap;

import java.io.Serializable;

public class LongMap implements BitMap, Serializable {

    private final long[] longs;

    public LongMap() {
        this.longs = new long[93750000];
    }

    public LongMap(int size) {
        this.longs = new long[size];
    }

    @Override
    public void add(long value) {
        int r = (int)(value / 64L);
        int c = (int)(value % 64L);
        this.longs[r] |= 1L << c;
    }

    @Override
    public boolean contains(long value) {
        int r = (int)(value / 64L);
        int c = (int)(value % 64L);
        return (this.longs[r] >>> c & 1L) == 1L;
    }

    /**
     * 不用longs[r] ^= (1L << c)的原因是因为取补码+和取操作更快一点
     */
    @Override
    public void remove(long value) {
        int r = (int)(value / 64L);
        int c = (int)(value % 64L);
        this.longs[r] &= ~(1L << c);
    }
}
