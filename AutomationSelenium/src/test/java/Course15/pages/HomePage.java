package Course15.pages;

import org.openqa.selenium.*;
import Course15.utils.ElementHelper;

/**
 * Clasa reprezintă pagina principală (Home) a magazinului online.
 * Conține metode pentru a naviga pe site și a interacționa cu elementele vizibile din această pagină.
 */
public class HomePage {

    // Obiectul WebDriver folosit pentru a controla browserul
    private final WebDriver driver;

    // Helper pentru acțiuni comune pe elemente (click, scriere text, așteptare)
    private final ElementHelper helper;

    // Selectori pentru elementele din pagina principală
    private final By consentBtn = By.cssSelector("button[aria-label='Consent']"); // buton Accept Cookies
    private final By createAccountLink = By.cssSelector("header .panel .authorization-link + li a"); // link „Create Account”
    private final By breatheEasyTank = By.cssSelector("a[title='Breathe-Easy Tank']"); // produsul „Breathe-Easy Tank”
    private final By cartIcon = By.cssSelector("a.action.showcart"); // pictograma coșului de cumpărături

    /**
     * Constructorul primește WebDriver-ul și creează obiectul helper.
     * @param driver instanța WebDriver folosită în test
     */
    public HomePage(WebDriver driver){
        this.driver = driver;
        helper = new ElementHelper(driver);
    }

    /**
     * Deschide pagina principală a magazinului online.
     */
    public void open(){
        String url = "https://magento.softwaretestingboard.com/";
        driver.get(url);
    }

    /**
     * Acceptă cookie-urile dacă este afișat mesajul de consimțământ.
     */
    public void acceptCookiesIfPresent(){
        if (helper.isPresent(consentBtn)) {
            helper.click(consentBtn);
        }
    }

    /**
     * Navighează către pagina de creare a unui cont nou.
     */
    public void goToCreateAccount(){
        helper.click(createAccountLink);
    }

    /**
     * Deschide pagina produsului „Breathe-Easy Tank”.
     * Face scroll până la produs și îl apasă.
     */
    public void openBreatheEasyTank(){
        WebElement el = helper.waitVisible(breatheEasyTank);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    /**
     * Deschide coșul de cumpărături mini (mini-cart).
     */
    public void openMiniCart(){
        helper.click(cartIcon);
    }
}