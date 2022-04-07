package ru.anbn.owner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ru.anbn.owner.config.WebDriverProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {
    private WebDriver driver = new WebDriverProvider().get();

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    @Test
    public void testGitHubTitle1() {
        assertEquals(driver.getTitle(), "GitHub: Where the world builds software · GitHub");
    }

}