package ru.anbn.owner.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    @Override
    public WebDriver get() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driver.get("https://github.com");

        return driver;
    }

}