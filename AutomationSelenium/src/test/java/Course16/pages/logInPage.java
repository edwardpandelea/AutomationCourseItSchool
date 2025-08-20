package Course16.pages;

import Course16.utils.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logInPage extends basePage {

    private final By usernameInput = By.id("loginusername");
    private final By passwordInput = By.id("loginpassword");
    private final By loginButton = By.cssSelector("button[onclick='logIn()']");
    private final By closeButton = By.xpath("/html/body/div[4]/div/div/div[3]/button[1]");
    public logInPage(WebDriver driver) {
        super(driver);
    }

    public void logIn(){
        clickLoginButton();
        driver.findElement(usernameInput).sendKeys("demouser");
        driver.findElement(passwordInput).sendKeys("asdf123");
        driver.findElement(loginButton).click();
    }
}
