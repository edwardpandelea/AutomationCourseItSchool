package Course15.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Clasă utilitară care conține metode comune pentru interacțiunea cu elementele din pagină.
 * Folosește WebDriverWait pentru așteptări explicite, astfel încât testele să fie mai stabile.
 */
public class ElementHelper {

    // Instanța de WebDriver folosită pentru interacțiunea cu browserul
    private final WebDriver driver;

    // Obiect pentru așteptări explicite (maxim 15 secunde în acest caz)
    private final WebDriverWait wait;

    /**
     * Constructorul primește WebDriver-ul și inițializează WebDriverWait.
     * @param driver instanța WebDriver folosită în test
     */
    public ElementHelper(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /**
     * Așteaptă până când elementul indicat este vizibil pe pagină.
     * @param locator selectorul elementului
     * @return elementul găsit și vizibil
     */
    public WebElement waitVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Așteaptă până când elementul indicat poate fi apăsat (este „clickable”).
     * @param locator selectorul elementului
     * @return elementul pregătit pentru click
     */
    public WebElement waitClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Face click pe elementul specificat.
     * Așteaptă mai întâi să devină clicabil.
     * @param locator selectorul elementului
     */
    public void click(By locator){
        waitClickable(locator).click();
    }

    /**
     * Introduce text într-un câmp.
     * Așteaptă mai întâi ca elementul să fie vizibil, îl golește (clear),
     * apoi scrie textul dorit.
     * @param locator selectorul elementului
     * @param text textul de introdus
     */
    public void insertText(By locator, String text){
        WebElement el = waitVisible(locator);
        el.clear();
        el.sendKeys(text);
    }

    /**
     * Verifică dacă un element există în pagină (fără a aștepta explicit).
     * @param locator selectorul elementului
     * @return true dacă există cel puțin un element cu acest locator, altfel false
     */
    public boolean isPresent(By locator){
        return !driver.findElements(locator).isEmpty();
    }
}