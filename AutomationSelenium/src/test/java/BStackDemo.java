import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BStackDemo {
    WebDriver driver;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://bstackdemo.com");
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.id("signin")).click();
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.id("username")).click();
        driver.findElement(By.xpath("//*[text()='demouser']")).click();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.xpath("//*[text()='testingisfun99']")).click();
        driver.findElement(By.id("login-btn")).click();
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@id=\"1\"]/div[4]")).click();
        WebElement prod = driver.findElement(By.xpath("//p[text()='iPhone 12']"));
        assertTrue(prod.isDisplayed());
        driver.findElement(By.className("buy-btn")).click();
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.id("firstNameInput")).sendKeys("Eduard");
        driver.findElement(By.id("lastNameInput")).sendKeys("Pandelea");
        driver.findElement(By.id("addressLine1Input")).sendKeys("Calea Marii");
        driver.findElement(By.id("provinceInput")).sendKeys("Bucharest");
        driver.findElement(By.id("postCodeInput")).sendKeys("123456");
        driver.findElement(By.id("checkout-shipping-continue")).click();
        Thread.sleep(Duration.ofSeconds(2));
        WebElement message = driver.findElement(By.id("confirmation-message"));
        String actualMessage = message.getText();
        String expectedMessage = "Your Order has been successfully placed.";
        assertEquals(expectedMessage, actualMessage, "Message is not correct");

        WebElement orderText = driver.findElement(By.xpath("//*[@id=\"checkout-app\"]/div/div/div/ol/li/div/div/div[2]"));
        String actualOrderText = orderText.getText();
        assertTrue(actualOrderText.contains("Your order number is"));

        WebElement totalPrice = driver.findElement(By.xpath("//*[@id=\"checkout-app\"]/div/div/aside/article/section[2]/div/div/span[2]/span"));
        String actualTotalPrice = totalPrice.getText();
        assertEquals("$799.00", actualTotalPrice, "Total price is not correct");

        driver.findElement(By.xpath("//*[@id=\"checkout-app\"]/div/div/div/div/a/button")).click();
        Thread.sleep(Duration.ofSeconds(2));

    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}
