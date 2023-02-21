
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

//@ExtendWith(TestWatcher.class)

public class WebTest {
    static WebDriver wd;
    static WebDriverWait waiter;
    @BeforeAll
    static void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        ChromeOptions opti = new ChromeOptions();
        opti.setAcceptInsecureCerts(true);              // irnore sertificate error
        wd = new ChromeDriver(opti);       // с выбранными опциями

        wd.navigate().to("http://tkso.ru/");
        wd.manage().window().fullscreen();
    }
    @Test
    void openHomePage() throws InterruptedException {
        Thread.sleep(1000);
        wd.findElement(By.id("mod-search-searchword")).sendKeys("Абсолютное зло");
        System.out.println("text was inpeted ");
        Thread.sleep(1000);
        wd.findElement(By.xpath("//button[contains(@class,'btn-primary')]")).click();
        System.out.println("button was pressed");
    }


    @AfterAll
    static void tearDown(){
//        wd.quit();
    }
}

