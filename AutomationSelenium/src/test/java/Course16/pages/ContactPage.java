package Course16.pages;

import Course16.utils.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends basePage {

    private final By inputEmail = By.id("recipient-email");
    private final By inputName = By.id("recipient-name");
    private final By inputMessage = By.id("message-text");
    private final By submitButton = By.cssSelector("button[onclick='send()']");
    private final By closeButton = By.xpath("/html/body/div[4]/div/div/div[3]/button[1]");

    public ContactPage(WebDriver driver)
    {
        super(driver);
    }

    public void sendMessage()
    {
        driver.findElement(inputEmail).sendKeys("asdf@asf.com");
        driver.findElement(inputName).sendKeys("asdf");
        driver.findElement(inputMessage).sendKeys("Message to be written here");
        driver.findElement(submitButton).click();
    }
}
