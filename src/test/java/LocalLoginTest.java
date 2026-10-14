


import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocalLoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testLoginPage() {

        Path htmlFile = Paths.get("webpage", "login.html")
                             .toAbsolutePath();

        driver.get(htmlFile.toUri().toString());

        // Enter username
        driver.findElement(By.id("username"))
              .sendKeys("testuser");

        // Enter password
        driver.findElement(By.id("password"))
              .sendKeys("test123");

        // Click Login
        driver.findElement(By.id("loginButton")).click();

        // Verify the success message
        String message = driver.findElement(By.id("message"))
                               .getText();

        Assert.assertEquals(
            message,
            "Login submitted successfully"
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


