package ru.anbn.owner.helpers;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.anbn.owner.config.Project;

public class DriverSettings {

    public static void configure() {

        System.getProperty("properties", "local");
        Configuration.browser = Project.projectConfig.browser();
        Configuration.browserVersion = Project.projectConfig.browserVersion();
        Configuration.browserSize = Project.projectConfig.browserSize();
        Configuration.baseUrl = Project.projectConfig.webUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        if (Project.isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = Project.projectConfig.remoteDriverUrl();
        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}