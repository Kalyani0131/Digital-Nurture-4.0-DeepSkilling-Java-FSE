package com.pattern.observer;

public class ObserverTest {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        market.register(mobile);
        market.register(web);

        market.setStock("TCS", 3500);
        market.setStock("INFY", 1450);
    }
}
