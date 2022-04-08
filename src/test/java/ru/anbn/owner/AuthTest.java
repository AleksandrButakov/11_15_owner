package ru.anbn.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.anbn.owner.config.AuthConfig;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthTest {

    Path props = Paths.get("src/test/resources/tmp/rm.properties");

    @BeforeEach
    public void clearFile() throws Exception {
        Files.deleteIfExists(props);
    }

    @Test
    public void testLocalFile() {
        AuthConfig config = ConfigFactory
                .create(AuthConfig.class, System.getProperties());

        assertThat(config.username()).isEqualTo("ivan");
        assertThat(config.password()).isEqualTo("1234");
    }

    @Test
    public void testRemoteFile() throws Exception {
        String content = "username=super-admin\npassword=super-pass";

        Files.write(props, content.getBytes(StandardCharsets.UTF_8));

        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

        assertThat(config.username()).isEqualTo("super-admin");
        assertThat(config.password()).isEqualTo("super-pass");
    }

}
