package ru.anbn.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:src/test/resources/tmp/rm.properties",
        "classpath:auth.properties"
})
public interface AuthConfig extends Config {

    @Key("username")
    String username();

    @Key("password")
    String password();

}