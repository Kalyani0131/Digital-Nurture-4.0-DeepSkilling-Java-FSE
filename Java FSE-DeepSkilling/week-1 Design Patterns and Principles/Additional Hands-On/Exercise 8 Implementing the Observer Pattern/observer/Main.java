package com.pattern.observer;

public class Main {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        NewsChannel channel = new NewsChannel();

        agency.addObserver(channel);
        agency.setNews("Breaking News: Design Patterns are awesome!");
    }
}
