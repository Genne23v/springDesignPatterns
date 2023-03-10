package com.wonkeun.springDesignPattern.adapter;

import org.junit.Test;

public class AppleAdapterTest {

    @Test
    public void testAdapter() {
        Orange orange = new MoroOrange();
        Apple apple = new AppleAdapter(orange);
        System.out.println(apple.getVarierty());
        apple.eat();
    }
}
