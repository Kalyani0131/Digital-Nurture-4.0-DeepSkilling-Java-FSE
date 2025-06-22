package com.pattern.di;

public class Client {
    private Service service;

    public Client(Service service) {
        this.service = service;
    }

    public void doSomething() {
        service.serve();
    }
}
