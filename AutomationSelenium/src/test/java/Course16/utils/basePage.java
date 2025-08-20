package Course16.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class basePage {
    public WebDriver driver = null;
    private final By homeButton = By.cssSelector("li[class='nav-item active'] a");
    private final By contactButton = By.cssSelector("a[data-target='exampleModal']");
    private final By aboutUsButton = By.cssSelector("a[data-target='videoModal']");
    private final By cartButton = By.id("cartur");
    private final By loginButton = By.id("login2");
    private final By signUpButton = By.id("signin2");
    private final By navBarLogoButton = By.id("nava");

    public basePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.get("https://demoblaze.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void clickSignUpButton(){
        driver.findElement(signUpButton).click();
    }
    public void clickHomeButton(){
        driver.findElement(homeButton).click();
    }
    public void clickContactButton(){
        driver.findElement(contactButton).click();
    }
    public void clickAboutUsButton(){
        driver.findElement(aboutUsButton).click();
    }
    public void clickCartButton(){
        driver.findElement(cartButton).click();
    }
    public void clickNavBarLogoButton(){
        driver.findElement(navBarLogoButton).click();
    }
}

