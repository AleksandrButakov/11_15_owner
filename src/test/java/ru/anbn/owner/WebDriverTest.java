package ru.anbn.owner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ru.anbn.owner.config.WebDriverProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

/* readme
   для подключения библиотеки owner owner необходимо выполнить следующие шаги:
   - подключить в build.gradle
   test {
     systemProperties(System.getProperties())
   }
   - добавиль библиотеку owner:
   'org.aeonbits.owner:owner:1.0.12'
   - создаем WebDriverConfig.java и прокидываем туда ключи
   дальше организуем логику и библиотека все делает за нас. Функциональность библиотеки будет соответствовать
   классу LegacyWebDriverConfig.java
 */

/* варианты запуска теста из консоли:
   ./gradlew clean test
   ./gradlew clean test -Dbrowser=FireFox
   ./gradlew clean test -DbaseUrl=https://github.com
   ./gradlew clean test -Dbrowser=FIREFOX -DbaseUrl=https://github.com
   ./gradlew clean test -Dbrowser=FIREFOX -DbaseUrl=https://google.com
 */

public class WebDriverTest {
    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
         driver = new WebDriverProvider().get();
    }

    @Test
    public void testGitHubTitle() {
        assertEquals(driver.getTitle(), "GitHub: Where the world builds software · GitHub");
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }

}