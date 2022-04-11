package ru.anbn.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.anbn.owner.config.ApiConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiTests {

    @Test
    @DisplayName("Assert API token/url test")
    void apiTokenTest() {
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        assertThat(apiConfig.apiToken()).isEqualTo("new_token");
        assertThat(apiConfig.apiBaseUrl()).isEqualTo("https://github.com");
    }
}