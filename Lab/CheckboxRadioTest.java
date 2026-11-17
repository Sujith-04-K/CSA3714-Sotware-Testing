package selenium;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;

/**
 * EXP NO: 42
 * Aim: To automate checkbox and radio button selection using Selenium WebDriver.
 */
public class CheckboxRadioTest {

    @Test
    public void checkboxRadioSelection() throws InterruptedException {
        if (new File("C:\\WebDriver\\chromedriver.exe").exists()) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        try {
            driver.manage().window().maximize();
            driver.get("https://demo.guru99.com/test/radio.html");

            // --- PART A: CHECKBOX ---
            System.out.println(">>> Clicking Checkbox 1...");
            WebElement checkbox = driver.findElement(By.id("vfb-6-0"));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
            Thread.sleep(2000);

            // --- PART B: RADIO BUTTON ---
            System.out.println(">>> Clicking Radio Button 1...");
            WebElement radioButton = driver.findElement(By.id("vfb-7-1"));
            radioButton.click();
            Thread.sleep(2000);

            // Final Assertions
            assertTrue("Checkbox should be selected", checkbox.isSelected());
            assertTrue("Radio Button should be selected", radioButton.isSelected());
            System.out.println("Checkbox and Radio Button selections verified successfully.");
        } finally {
            driver.quit();
        }
    }
}
