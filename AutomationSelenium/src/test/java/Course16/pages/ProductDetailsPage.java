package Course16.pages;

import Course16.utils.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends basePage {

    private final By addToCardButton = By.xpath("//a[text()='Add to cart']");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(){
        driver.findElement(addToCardButton).click();
    }
}
