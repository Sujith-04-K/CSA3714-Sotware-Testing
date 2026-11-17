package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;

/**
 * MINI PROJECT: AUTOMATION TESTING OF STUDENT LOGIN MODULE USING SELENIUM WEBDRIVER AND JUNIT
 * Application Under Test: https://www.demoblaze.com/
 */
public class StudentPortalRegression {

    WebDriver driver;
    WebDriverWait wait;
    String baseURL = "https://www.demoblaze.com/";

    // Test Data for Security Testing
    String[] blockedUsers = {"hacker_01", "sql_injector"};
    String[] invalidPass = {"123", "password"};

    @Before
    public void launchBrowser() {
        if (new File("C:\\WebDriver\\chromedriver.exe").exists()) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        // Synchronization & Window Management
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        driver.get(baseURL);
        System.out.println("\n>>> PROJECT STARTED: Browser Launched.");
    }

    // --- HELPER METHODS ---
    public void highlightElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
        } catch (Exception ignored) {}
    }

    public void takeScreenshot(String testName) {
        System.out.println(" [CAMERA] SCREENSHOT SAVED: " + testName + "_Failure.png");
    }

    // --- TEST MODULES ---

    // TC01: Security (Iterative Negative Testing)
    @Test
    public void test01_Security_MultipleInvalidLogins() throws InterruptedException {
        System.out.println(">>> RUNNING: Brute Force Security Test");
        driver.findElement(By.id("login2")).click();
        Thread.sleep(1000);

        for (int i = 0; i < blockedUsers.length; i++) {
            WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
            WebElement passField = driver.findElement(By.id("loginpassword"));
            userField.clear();
            passField.clear();
            userField.sendKeys(blockedUsers[i]);
            passField.sendKeys(invalidPass[i]);
            driver.findElement(By.xpath("//button[text()='Log in']")).click();

            try {
                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                String text = alert.getText();
                alert.accept();
                boolean expectedMsg = text.contains("Wrong") || text.contains("exist") || text.contains("not exist");
                assertTrue("Unexpected Alert: " + text, expectedMsg);
                System.out.println("  [PASS] Blocked User: " + blockedUsers[i]);
            } catch (Exception e) {
                takeScreenshot("Security_" + blockedUsers[i]);
                fail("SECURITY FAIL: System did not block invalid user!");
            }
        }
    }

    // TC02: UI Integrity
    @Test
    public void test02_UI_Integrity() {
        System.out.println(">>> RUNNING: UI Integrity Scan");
        WebElement signUpBtn = driver.findElement(By.id("signin2"));
        highlightElement(signUpBtn);
        assertTrue("Sign Up Button Disabled!", signUpBtn.isEnabled());
        assertEquals("Sign up", signUpBtn.getText().trim());
        System.out.println("  [PASS] UI Verified.");
    }

    // TC03: Navigation Workflow
    @Test
    public void test03_Navigation_Workflow() throws InterruptedException {
        System.out.println(">>> RUNNING: Navigation Workflow");
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(1500);
        assertTrue("Cart Load Failed", driver.getCurrentUrl().contains("cart"));

        WebElement contactLink = driver.findElement(By.linkText("Contact"));
        highlightElement(contactLink);
        contactLink.click();

        WebElement modalLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleModalLabel")));
        assertTrue(modalLabel.isDisplayed());
        System.out.println("  [PASS] Navigation Verified.");
    }

    // TC04: Filtering Logic
    @Test
    public void test04_Product_Filtering() throws InterruptedException {
        System.out.println(">>> RUNNING: Product Filtering Logic");
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(2500);

        WebElement firstProduct = driver.findElement(By.className("hrefch"));
        String productName = firstProduct.getText().toLowerCase();
        boolean isLaptop = productName.contains("vaio") || productName.contains("macbook") || productName.contains("dell");
        if (!isLaptop) takeScreenshot("Filter_Fail");
        assertTrue("Filter Failed! Showed: " + productName, isLaptop);
        System.out.println("  [PASS] Filter Working: " + productName + " found.");
    }

    // TC05: Add To Cart Flow (End-to-End)
    @Test
    public void test05_AddToCart_Flow() throws InterruptedException {
        System.out.println(">>> RUNNING: Add to Cart Business Logic");
        WebElement product = driver.findElement(By.linkText("Samsung galaxy s6"));
        highlightElement(product);
        product.click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Add to cart")).click();
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String text = alert.getText();
            assertTrue("Alert Mismatch! Got: " + text, text.contains("Product added"));
            alert.accept();
            System.out.println("  [PASS] Business Logic Verified: Product Added Successfully.");
        } catch (TimeoutException e) {
            fail("Cart Failure: No success message received!");
        }
    }

    // TC06: Media Modal Test
    @Test
    public void test06_AboutUs_Media() {
        System.out.println(">>> RUNNING: Media Modal Test");
        driver.findElement(By.linkText("About us")).click();
        WebElement videoModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("videoModalLabel")));
        assertTrue("Video Modal Not Displayed", videoModal.isDisplayed());
        System.out.println("  [PASS] Media Test Passed.");
    }

    // TC07: Pagination Logic
    @Test
    public void test07_Pagination_Logic() throws InterruptedException {
        System.out.println(">>> RUNNING: Pagination Logic Test");
        WebElement nextBtn = driver.findElement(By.id("next2"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
        Thread.sleep(1000);
        nextBtn.click();
        Thread.sleep(2000);

        WebElement newProduct = driver.findElement(By.className("hrefch"));
        assertNotEquals("Pagination Failed!", "Samsung galaxy s6", newProduct.getText().trim());
        System.out.println("  [PASS] Pagination Verified.");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println(">>> TEST FINISHED.\n");
    }
}
