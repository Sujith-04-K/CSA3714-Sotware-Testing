package selenium;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import java.io.File;

/**
 * EXP NO: 41
 * Aim: To automate dropdown selection using selectByVisibleText() in Selenium WebDriver.
 */
public class DropdownSelectionTest {

    @Test
    public void dropdownTest() {
        if (new File("C:\\WebDriver\\chromedriver.exe").exists()) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        try {
            driver.manage().window().maximize();
            driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
            driver.switchTo().frame("iframeResult");
            WebElement dropdown = driver.findElement(By.name("cars"));
            Select select = new Select(dropdown);
            select.selectByVisibleText("Saab");
            String selected = select.getFirstSelectedOption().getText();
            System.out.println("Selected Option: " + selected);
            assertEquals("Saab", selected);
        } finally {
            driver.quit();
        }
    }
}
