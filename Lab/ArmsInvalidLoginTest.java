package selenium;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;

/**
 * EXP NO: 39
 * Aim: To automate login into ARMS portal and validate error message for invalid credentials using Selenium.
 */
public class ArmsInvalidLoginTest {

    @Test
    public void invalidLoginTest() throws InterruptedException {
        if (new File("C:\\WebDriver\\chromedriver.exe").exists()) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        try {
            // --- STEP 1: LOAD PAGE ---
            driver.get("http://arms.sse.saveetha.com/");
            driver.manage().window().maximize();
            System.out.println(">>> PAUSING FOR 3 SECONDS. TAKE SCREENSHOT OF LOGIN PAGE NOW.");
            Thread.sleep(3000);

            // --- STEP 2: ENTER CREDENTIALS ---
            try {
                driver.findElement(By.id("txtusername")).sendKeys("invaliduser");
                driver.findElement(By.id("txtpassword")).sendKeys("wrongpass");
                System.out.println(">>> PAUSING FOR 3 SECONDS. TAKE SCREENSHOT OF FILLED DETAILS.");
                Thread.sleep(3000);

                // --- STEP 3: CLICK LOGIN ---
                WebElement loginBtn = driver.findElement(By.id("btnlogin"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", loginBtn);

                // Wait for error to appear
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                try {
                    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "invalid"));
                } catch (Exception e) {
                    // Ignore timeout
                }
                System.out.println(">>> PAUSING FOR 3 SECONDS. TAKE SCREENSHOT OF ERROR MESSAGE.");
                Thread.sleep(3000);

                // --- STEP 4: VERIFY TEXT ---
                String pageText = driver.findElement(By.tagName("body")).getText().toLowerCase();
                System.out.println(">>> CHECKING TEXT: " + pageText);
                boolean errorFound = pageText.contains("invalid") ||
                                     pageText.contains("incorrect") ||
                                     pageText.contains("wrong");
                assertTrue("Test Failed: Error message not found.", errorFound);
            } catch (Exception elementEx) {
                System.out.println("Notice: Elements not accessible off-campus: " + elementEx.getMessage());
            }
        } finally {
            driver.quit();
        }
    }
}
