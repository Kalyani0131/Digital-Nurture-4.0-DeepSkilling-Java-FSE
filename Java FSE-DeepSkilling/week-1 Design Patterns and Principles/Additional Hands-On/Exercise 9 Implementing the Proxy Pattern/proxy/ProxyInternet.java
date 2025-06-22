package com.pattern.proxy;

import java.util.Arrays;
import java.util.List;

public class ProxyInternet implements Internet {
    private RealInternet realInternet = new RealInternet();
    private static List<String> bannedSites = Arrays.asList("banned.com", "blocked.com");

    public void connectTo(String site) {
        if (bannedSites.contains(site.toLowerCase())) {
            System.out.println("Access Denied to " + site);
        } else {
            realInternet.connectTo(site);
        }
    }
}
