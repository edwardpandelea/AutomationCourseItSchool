package Course16.pages;

import Course16.utils.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends basePage {

    private final By placeOrderButton = By.cssSelector("button[data-toggle='modal']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickPlaceOrder(){
        driver.findElement(placeOrderButton).click();
    }

    public void open(){
        clickCartButton();
    }
}
