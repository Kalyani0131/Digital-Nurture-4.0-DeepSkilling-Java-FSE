package com.pattern.builder;

public class Phone {
    private String os;
    private int ram;
    private String processor;

    public Phone(String os, int ram, String processor) {
        this.os = os;
        this.ram = ram;
        this.processor = processor;
    }

    @Override
    public String toString() {
        return "Phone [OS=" + os + ", RAM=" + ram + "GB, Processor=" + processor + "]";
    }
}
