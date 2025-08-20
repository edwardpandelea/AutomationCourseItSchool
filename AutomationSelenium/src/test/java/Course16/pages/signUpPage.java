package Course16.pages;

import Course16.utils.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signUpPage extends basePage {

    private final By usernameInput = By.id("sign-username");
    private final By passwordInput = By.id("sign-password");
    private final By loginButton = By.cssSelector("button[onclick='register()']");
    private final By closeButton = By.xpath("/html/body/div[4]/div/div/div[3]/button[1]");
    public signUpPage(WebDriver driver) {
        super(driver);
    }

    public void signUp(){
        clickSignUpButton();
        driver.findElement(usernameInput).sendKeys("demouser");
        driver.findElement(passwordInput).sendKeys("asdf123");
        driver.findElement(loginButton).click();
    }
}
