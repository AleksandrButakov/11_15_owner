package ru.anbn.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${properties}.properties")
public interface ProjectConfig extends Config {

    @Key("baseurl")
    @DefaultValue("https://github.com")
    String webUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browser.version")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("remoteDriverUrl")
    @DefaultValue("")
    String remoteDriverUrl();

    @Key("browser.size")
    @DefaultValue("900x800")
    String browserSize();


}