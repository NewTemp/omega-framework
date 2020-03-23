package com.omega.platform.common.core;

/**
*@Description 持有器
*@Author Allen.Lv
*@Date 3/24/2020
*@Time 12:39 AM
*/
public class Holder<T> {
    private T object;

    public Holder() {
    }

    public Holder(T object) {
        this.object = object;
    }

    public T get() {
        return this.object;
    }

    public void set(T object) {
        this.object = object;
    }

    public boolean isEmpty() {
        return null == this.object;
    }
}
