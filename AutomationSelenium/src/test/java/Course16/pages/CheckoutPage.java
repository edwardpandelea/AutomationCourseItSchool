package Course16.pages;

import Course16.utils.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutPage extends basePage {

    private final By nameInput = By.id("name");
    private final By countryInput = By.id("country");
    private final By cityInput = By.id("city");
    private final By cardInput = By.id("card");
    private final By monthInput = By.id("month");
    private final By yearInput = By.id("year");
    private final By purchaseButton = By.cssSelector("button[onclick='purchaseOrder()']");
    private final By closeButton = By.xpath("/html/body/div[4]/div/div/div[3]/button[1]");
    private final By okButton = By.xpath("//button[text()='OK']");
    private final By messageElem = By.xpath("/html/body/div[10]/h2");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void placeOrder(){
        driver.findElement(nameInput).sendKeys("TestName");
        driver.findElement(countryInput).sendKeys("Romania");
        driver.findElement(cityInput).sendKeys("Bucharest");
        driver.findElement(cardInput).sendKeys("4111111111111111");
        driver.findElement(monthInput).sendKeys("01");
        driver.findElement(yearInput).sendKeys("2022");
        driver.findElement(purchaseButton).click();
    }

    public void verifyOrderSuccess() throws InterruptedException {
        String message = driver.findElement(messageElem).getText();
        assertTrue(message.contains("Thank you"), "Message is not correct");
    }


}
