package com.pattern.builder;

public class PhoneBuilder {
    private String os;
    private int ram;
    private String processor;

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public Phone build() {
        return new Phone(os, ram, processor);
    }
}
