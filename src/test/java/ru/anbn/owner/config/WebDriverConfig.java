package ru.anbn.owner.config;

import org.aeonbits.owner.Config;

import java.net.URL;

public interface WebDriverConfig extends Config {

    @Key("baseUrl")   // reading the value
    @DefaultValue("https://github.com")  // default value processing
    String getBaseUrl();  // converting the result

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("remoteUrl")
    URL getRemoteUrl();


}
