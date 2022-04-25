package com.lyq.javautils.bloomfilter.bitmap;

import java.io.Serializable;

public class IntMap implements BitMap, Serializable {

    private final int[] ints;

    public IntMap() {
        this.ints = new int[93750000];
    }

    public IntMap(int size) {
        this.ints = new int[size];
    }

    @Override
    public void add(long value) {
        int r = (int)(value / 32);
        int c = (int)(value % 32);
        this.ints[r] |= 1 << c;
    }

    @Override
    public boolean contains(long value) {
        int r = (int)(value / 32);
        int c = (int)(value % 32);
        return (this.ints[r] >>> c & 1) == 1;
    }

    /**
     * 不用ints[r] ^= (1 << c)的原因是因为取补码+和取操作更快一点
     */
    @Override
    public void remove(long value) {
        int r = (int)(value / 32);
        int c = (int)(value % 32);
        this.ints[r] &= ~(1 << c);
    }
}
