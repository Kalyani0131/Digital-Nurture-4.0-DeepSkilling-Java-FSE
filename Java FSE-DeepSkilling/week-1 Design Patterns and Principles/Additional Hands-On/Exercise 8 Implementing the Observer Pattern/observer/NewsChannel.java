package com.pattern.observer;

public class NewsChannel implements Observer {
    private String news;

    public void update(String news) {
        this.news = news;
        System.out.println("NewsChannel received news: " + news);
    }
}
