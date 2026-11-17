package selenium;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

/**
 * EXP NO: 45
 * Aim: To capture a screenshot of a web page and store it in the local system using Selenium WebDriver.
 */
public class ScreenshotCaptureTest {

    @Test
    public void captureScreenshot() throws Exception {
        if (new File("C:\\WebDriver\\chromedriver.exe").exists()) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        try {
            driver.manage().window().maximize();
            try {
                driver.get("http://arms.sse.saveetha.com/");
            } catch (Exception e) {
                // If off campus, fallback to Google or demo page to capture screenshot reliably
                driver.get("https://www.google.com");
            }
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("C:\\Users\\Public\\Pictures\\arms_screenshot.png");
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot captured at: " + dest.getAbsolutePath());
            assertTrue("Screenshot file should exist", dest.exists());
        } finally {
            driver.quit();
        }
    }
}
