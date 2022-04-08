package ru.anbn.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import ru.anbn.owner.config.IOSConfig;
import ru.anbn.owner.config.MobileConfig;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IOSTest {

    @Test
    public void testPhone() {
        IOSConfig config = ConfigFactory.create(IOSConfig.class, System.getProperties());

        assertThat(config.deviceName()).isEqualTo("iPhone Last");
        assertThat(config.platformName()).isEqualTo("IOS");
        assertThat(config.platformVersion()).isEqualTo("11");


    }

}
