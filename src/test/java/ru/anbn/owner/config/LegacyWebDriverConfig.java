package ru.anbn.owner.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class LegacyWebDriverConfig {

    public String getBaseUrl() {
        String baseUrl = System.getProperty("baseUrl");  // reading the value
        if (Objects.isNull(baseUrl)) {  // default value processing
            baseUrl = "https://github.com";
        }
        return baseUrl;  // converting the result
    }

    public Browser getBrowser() {
        String browser = System.getProperty("browser");
        if (Objects.isNull(browser)) {
            return Browser.CHROME;
        }
        return Browser.valueOf(browser);
    }

    public boolean isRemote() {
        String isRemote = System.getProperty("isRemote");
        if (Objects.isNull(isRemote)) {
            return false;
        }
        return Boolean.parseBoolean(isRemote);
    }

    public URL getRemote() throws MalformedURLException {
        String remoteUrl = System.getProperty("remoteUrl");
        if (Objects.isNull(remoteUrl)) {
            return null;
        }
            return new URL(remoteUrl);
    }

}
