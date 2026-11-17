package selenium;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;

/**
 * EXP NO: 43
 * Aim: To handle JavaScript alert pop-ups using Selenium WebDriver.
 */
public class JavaScriptAlertTest {

    @Test
    public void alertHandlingTest() throws InterruptedException {
        if (new File("C:\\WebDriver\\chromedriver.exe").exists()) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        try {
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
            Thread.sleep(1500);
            driver.switchTo().alert().accept();
            String result = driver.findElement(By.id("result")).getText();
            System.out.println("Result text: " + result);
            assertTrue(result.contains("You successfully clicked an alert"));
        } finally {
            driver.quit();
        }
    }
}
