package com.wonkeun.springDesignPattern.adapter;

public class AppleAdapter implements Apple {
    private final Orange orange;

    public AppleAdapter(Orange orange) {
        super();
        this.orange = orange;
    }

    @Override
    public String getVarierty() {
        return orange.getVariety();
    }

    @Override
    public void eat() {
        orange.peel();
        orange.eat();
    }
}
