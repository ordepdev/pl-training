package com.ordepdev.proxy;

public class ProxyDemo {

    public static void main(String[] args) {
        TwitterService service = (TwitterService) SecurityProxy.newInstance(new TwitterServiceStub());

        System.out.println(service.getTimeline("foo"));

        service.postToTimeline("foo", "this should not be allowed");
    }
}
