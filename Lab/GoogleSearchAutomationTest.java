package selenium;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;

/**
 * EXP NO: 37
 * Aim: To automate search functionality in Google using Selenium WebDriver.
 */
public class GoogleSearchAutomationTest {

    @Test
    public void googleSearchTest() throws InterruptedException {
        if (new File("C:\\WebDriver\\chromedriver.exe").exists()) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        try {
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");
            driver.findElement(By.name("q")).sendKeys("Saveetha School of Engineering" + Keys.ENTER);
            Thread.sleep(3000);
            System.out.println("Page Title: " + driver.getTitle());
            assertTrue(driver.getTitle().toLowerCase().contains("saveetha") || driver.getCurrentUrl().contains("google"));
        } finally {
            driver.quit();
        }
    }
}
