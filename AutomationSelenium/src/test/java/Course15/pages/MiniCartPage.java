package Course15.pages;

import org.openqa.selenium.*;
import Course15.utils.ElementHelper;

/**
 * Clasa reprezintă mini-coșul de cumpărături care apare
 * atunci când utilizatorul apasă pe pictograma coșului.
 * De aici se poate merge mai departe la pagina de checkout.
 */
public class MiniCartPage {

    // Helper pentru acțiuni comune pe elemente (click, scriere text, așteptare)
    private final ElementHelper helper;

    // Selector pentru butonul „Proceed to Checkout” din mini-cart
    private final By checkoutBtn = By.id("top-cart-btn-checkout");

    /**
     * Constructorul primește WebDriver-ul și creează obiectul helper.
     * @param driver instanța WebDriver folosită în test
     */
    public MiniCartPage(WebDriver driver){
        helper = new ElementHelper(driver);
    }

    /**
     * Apasă butonul „Proceed to Checkout” din mini-cart
     * pentru a merge la pagina de checkout.
     */
    public void proceedToCheckout(){
        helper.click(checkoutBtn);
    }
}