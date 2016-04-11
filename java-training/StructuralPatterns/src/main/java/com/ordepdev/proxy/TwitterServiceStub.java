package com.ordepdev.proxy;

public class TwitterServiceStub implements TwitterService {

    @Override
    public String getTimeline(String screenName) {
        return "my twitter feed";
    }

    @Override
    public void postToTimeline(String screenName, String message) {

    }
}
