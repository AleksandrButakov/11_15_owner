package ru.anbn.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.anbn.owner.config.Browser;
import ru.anbn.owner.config.TypeConfig;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TypeConfigTest {

    @Test
    @Disabled
    public void testInteger() {
        System.setProperty("double", "10.10");
        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getDouble()).isEqualTo(10.10);
    }

    @Test
    public void testEnum() {
        System.setProperty("enum", "FIREFOX");
        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getEnum()).isEqualTo(Browser.FIREFOX);
    }

    @Test
    public void testUrl() throws Exception {
        System.setProperty("url", "https://github.com");
        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getUrl()).isEqualTo(new URL("https://github.com"));
    }

}
