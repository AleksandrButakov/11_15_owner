package ru.anbn.owner.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;
import java.util.function.Supplier;

import static java.lang.Thread.sleep;

public class WebDriverProvider implements Supplier<WebDriver> {

    // private WebDriverConfig config = new WebDriverConfig();
    // вместо такого подхода лучше писать так:
    private final WebDriverConfig config;

    public WebDriverProvider() {
        this.config = new WebDriverConfig();
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driver.get(config.getBaseUrl());

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private WebDriver createWebDriver() {
        if (Objects.nonNull(config.getBrowser())) {
            switch (config.getBrowser()) {
                case CHROME: {
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                    return new ChromeDriver();
                }
                case FIREFOX: {
                    System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                    return new FirefoxDriver();
                }
                default: {
                    throw new RuntimeException("The browser typeis not supported");
                }
            }
        }
        throw new RuntimeException("The browser type cannot be null");

    }

}