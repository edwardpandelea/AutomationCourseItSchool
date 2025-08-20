package Course15.pages;

import org.openqa.selenium.*;
import Course15.utils.ElementHelper;

/**
 * Clasa reprezintă pagina de înregistrare a unui cont nou.
 * Conține metode pentru completarea formularului și trimiterea acestuia.
 */
public class RegisterPage {

    // Helper pentru acțiuni comune pe elemente (click, scriere text, așteptare)
    private final ElementHelper helper;

    // Selectori pentru câmpurile formularului de înregistrare
    private final By firstName = By.id("firstname");
    private final By lastName = By.id("lastname");
    private final By email = By.id("email_address");
    private final By password = By.id("password");
    private final By confirmPassword = By.id("password-confirmation");
    private final By submitBtn = By.cssSelector("#form-validate button[type='submit']");
    private final By successMsg = By.cssSelector("div[data-bind*='prepareMessageForHtml']");

    /**
     * Constructorul primește WebDriver-ul și creează obiectul helper.
     * @param driver instanța WebDriver folosită în test
     */
    public RegisterPage(WebDriver driver){
        helper = new ElementHelper(driver);
    }

    /**
     * Completează câmpurile cu prenume și nume.
     * @param first prenumele utilizatorului
     * @param last numele de familie al utilizatorului
     */
    public void fillName(String first, String last){
        helper.insertText(firstName, first);
        helper.insertText(lastName, last);
    }

    /**
     * Completează câmpurile pentru email și parolă (inclusiv confirmarea parolei).
     * @param emailStr adresa de email a utilizatorului
     * @param pass parola utilizatorului
     */
    public void fillCredentials(String emailStr, String pass){
        helper.insertText(email, emailStr);
        helper.insertText(password, pass);
        helper.insertText(confirmPassword, pass);
    }

    /**
     * Apasă butonul „Create an Account” pentru a trimite formularul.
     */
    public void submit(){
        helper.click(submitBtn);
    }

    /**
     * Returnează mesajul de succes afișat după crearea contului.
     * @return textul mesajului de succes
     */
    public String getSuccessMessage(){
        return helper.waitVisible(successMsg).getText();
    }
}