package Course16.pages;

import Course16.utils.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends basePage {

    private final By phonesCategory= By.xpath("//a[@onclick=\"byCat('phone')\"]");
    private final By laptopsCategory = By.xpath("//a[@onclick=\"byCat('notebook')\"]");
    private final By monitorsCategory = By.xpath("//a[@onclick=\"byCat('monitor')\"]");
    private final By nextCarouselButton = By.xpath("//a[@class='carousel-control-next']");
    private final By prevCarouselButton = By.xpath("//a[@class='carousel-control-prev']");
    private final By nextPageButton = By.id("next2");
    private final By prevPageButton = By.id("prev2");
    private List<WebElement> products = null;

    public HomePage(WebDriver driver){
        super(driver);
    }
    @Override
    public void open(){
        super.open();
        products = driver.findElements(By.xpath("//div[@class='card-block']"));
    }

    public void clickOnSpecificProduct(int index){
        products.get(index).click();
    }

    public void clickOnSpecificProduct(String name){
        for(WebElement product : products){
            System.out.println(product.findElement(By.className("card-title")).getText());
            if(product.findElement(By.className("card-title")).getText().contains(name)){
                product.findElement(By.className("card-title")).findElement(By.tagName("a")).click();
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    public List<WebElement> getProducts() {
        return products;
    }
    public void clickNextCarouselButton() {
        driver.findElement(nextCarouselButton).click();
    }

    public void clickPrevCarouselButton() {
        driver.findElement(prevCarouselButton).click();
    }

    public void clickNextPageButton() {
        driver.findElement(nextPageButton).click();
    }

    public void clickPrevPageButton() {
        driver.findElement(prevPageButton).click();
    }

    public void clickPhonesCategory() {
        driver.findElement(phonesCategory).click();
    }
    public void clickLaptopsCategory() {
        driver.findElement(laptopsCategory).click();
    }
    public void clickMonitorsCategory() {
        driver.findElement(monitorsCategory).click();
    }


}
