package ru.anbn.owner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {
    WebDriver driver;

    @AfterEach
    public void afterEach() {
        driver.quit();
    }


    @Test
    public void testGitHubTitle() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driver.get("https://github.com");

        System.out.println("Title:");
        String s;
        s = driver.getTitle();

        assertEquals(s, "GitHub: Where the world builds software · GitHub");
        System.out.println(s);



    }

}
