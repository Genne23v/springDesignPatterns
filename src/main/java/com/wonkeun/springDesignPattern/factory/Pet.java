package com.wonkeun.springDesignPattern.factory;

public interface Pet {
    void setName(String name);
    String getName();
    String getType();
    boolean isHungry();
    void feed();
}
