package ru.anbn.owner.config;

import java.net.URL;

public class WebDriverConfig {

    public String getBaseUrl() {
        return "https://github.com";
    }

    public Browser getBrowser() {
        return Browser.FIREFOX;
    }

    public boolean isRemote() {
        return false;
    }

    public URL getRemote() {
        return null;
    }

}
