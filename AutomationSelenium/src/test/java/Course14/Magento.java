package Course14;

import com.github.javafaker.Faker;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Magento {
    // pentru a functiona toate testele trebuie rulate
    WebDriver driver;
    String globalPassword = "asfasdf1234@@@";
    static String firstName;
    static String lastName;
    static String email;
    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
    }

    @BeforeEach
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }


    @Test
    public void createAccount() throws InterruptedException {

        driver.get("https://magento.softwaretestingboard.com");
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@aria-label='Consent']")).click();
        driver.findElement(By.xpath("//a[text()='Create an Account']")).click();
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("email_address")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(globalPassword);
        driver.findElement(By.id("password-confirmation")).sendKeys(globalPassword);
        driver.findElement(By.xpath("//button[contains(@title, 'an')]")).click();
        assertTrue(driver.findElement(By.xpath("//*[text()='Thank you for registering with Main Website Store.']")).isDisplayed(), "Message is not correct");

    }

    @Test
    public void placeOrder() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com");
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@aria-label='Consent']")).click();
        // ===========================================
        // Luam toate elementele din pagina cu clasa product-item (astea fiind produsele)
        List<WebElement> items = driver.findElements(By.xpath("//*[@class='product-item']"));
        // pentru fiecare actiune selectam primul produs (items.getFirst())
        items.getFirst().findElement(By.id("option-label-size-143-item-166")).click(); // click pe marimea primului produs
        items.getFirst().findElement(By.id("option-label-color-93-item-57")).click(); // click pe culoarea primului produs
        Actions actions = new Actions(driver);
        actions.moveToElement(items.getFirst()); // hover pe produs
        items.getFirst().findElement(By.cssSelector("button")).click(); // click pe butonul de adaugare in cos
        // ===========================================
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.className("authorization-link")).click();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(globalPassword);
        driver.findElement(By.id("send2")).click();
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//a[@class='action showcart']")).click();
        driver.findElement(By.id("top-cart-btn-checkout")).click();
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//input[@name=\"street[0]\"]")).sendKeys("str fermei");
        driver.findElement(By.xpath("//input[@name=\"city\"]")).sendKeys("Bucuresti");
        Select select = new Select(driver.findElement(By.xpath("//select[@name=\"region_id\"]")));
        select.selectByValue("43");
        driver.findElement(By.xpath("//input[@name=\"postcode\"]")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name=\"telephone\"]")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@name='ko_unique_1']")).click();
        driver.findElement(By.xpath("//button[@data-role=\"opc-continue\"]")).click();
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//button[@title='Place Order']")).click();
        Thread.sleep(Duration.ofSeconds(3));
        WebElement text = driver.findElement(By.xpath("//span[@class='base']"));
        assertTrue(text.getText().contains("Thank you for your purchase!"), "Message is not correct");
    }


    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

}
