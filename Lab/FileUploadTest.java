package selenium;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.FileWriter;

/**
 * EXP NO: 44
 * Aim: To automate file upload functionality on a web application using Selenium WebDriver.
 */
public class FileUploadTest {

    @Test
    public void fileUploadAutomation() throws Exception {
        if (new File("C:\\WebDriver\\chromedriver.exe").exists()) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        }

        // Ensure sample.txt exists so the test runs on any machine
        File sampleFile = new File("C:\\Users\\Public\\Documents\\sample.txt");
        if (!sampleFile.exists()) {
            sampleFile.getParentFile().mkdirs();
            try (FileWriter writer = new FileWriter(sampleFile)) {
                writer.write("Sample test content for file upload.");
            }
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        try {
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/upload");
            driver.findElement(By.id("file-upload")).sendKeys(sampleFile.getAbsolutePath());
            driver.findElement(By.id("file-submit")).click();
            Thread.sleep(2000);
            String uploaded = driver.findElement(By.id("uploaded-files")).getText();
            System.out.println("Uploaded file name: " + uploaded);
            assertTrue(uploaded.contains("sample.txt"));
        } finally {
            driver.quit();
        }
    }
}
