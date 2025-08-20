package Course15.pages;

import Course15.utils.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

/**
 * Clasa reprezintă pagina de checkout din magazinul online.
 * Aici sunt localizate elementele și sunt definite metodele
 * pentru a finaliza procesul de comandă.
 */
public class CheckoutPage {

    // Helper pentru acțiuni comune pe elemente (click, scriere text, așteptare)
    private final ElementHelper helper;

    // Selectori pentru câmpurile și butoanele din pagina de checkout
    private final By email = By.id("customer-email");
    private final By password = By.id("customer-password");
    private final By signInBtn = By.cssSelector("#customer-email-fieldset button");

    private final By street = By.cssSelector("input[name='street[0]']");
    private final By city = By.cssSelector("input[name='city']");
    private final By region = By.cssSelector("select[name='region_id']");
    private final By postcode = By.cssSelector("input[name='postcode']");
    private final By country = By.cssSelector("select[name='country_id']");
    private final By phone = By.cssSelector("input[name='telephone']");

    private final By shippingMethod15 = By.xpath("//span[@class='price' and contains(text(),'$15.00')]");
    private final By continueBtn = By.cssSelector("button[data-role='opc-continue']");

    private final By orderTotal = By.cssSelector("td[data-th='Order Total'] .price");
    private final By placeOrder = By.cssSelector("button[title='Place Order']");
    private final By thankYou = By.cssSelector("span.base");

    /**
     * Constructorul primește WebDriver-ul și creează obiectul helper.
     * @param driver instanța WebDriver folosită în test
     */
    public CheckoutPage(WebDriver driver){
        helper = new ElementHelper(driver);
    }

    /**
     * Autentificare în timpul procesului de checkout.
     * @param emailStr adresa de email a utilizatorului
     * @param pwd parola utilizatorului
     */
    public void signInDuringCheckout(String emailStr, String pwd){
        helper.insertText(email, emailStr);
        helper.insertText(password, pwd);
        helper.click(signInBtn);
    }

    /**
     * Completează formularul de adresă pentru livrare.
     * Valorile sunt predefinite pentru test.
     */
    public void fillAddress(){
        new Select(helper.waitVisible(region)).selectByValue("43"); // Selectează regiunea după value
        helper.insertText(street, "Calea Martirilor");
        helper.insertText(city, "Oradea");
        helper.insertText(postcode, "12345-6789");
        new Select(helper.waitVisible(country)).selectByValue("US"); // Selectează țara
        helper.insertText(phone, "0700000000");
    }

    /**
     * Alege metoda de livrare de $15 și trece la pasul următor.
     */
    public void chooseShippingAndContinue(){
        helper.click(shippingMethod15);
        helper.click(continueBtn);
    }

    /**
     * Returnează valoarea totală a comenzii afișată în pagina de checkout.
     * @return prețul total ca text
     */
    public String getTotal(){
        return helper.waitVisible(orderTotal).getText();
    }

    /**
     * Plasează comanda apăsând butonul „Place Order”.
     */
    public void placeOrder(){
        helper.click(placeOrder);
    }

    /**
     * Returnează mesajul de confirmare după plasarea comenzii.
     * @return textul de confirmare
     */
    public String getConfirmation(){
        return helper.waitVisible(thankYou).getText();
    }
}