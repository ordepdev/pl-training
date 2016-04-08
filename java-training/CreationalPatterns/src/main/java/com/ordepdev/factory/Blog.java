package com.ordepdev.factory;

public class Blog extends Website {

    @Override
    protected void createWebsite() {
        pages.add(new PostPage());
        pages.add(new ContactPage());
    }
}
