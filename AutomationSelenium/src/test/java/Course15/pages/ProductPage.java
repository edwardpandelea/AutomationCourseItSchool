package Course15.pages;

import org.openqa.selenium.*;
import Course15.utils.ElementHelper;

/**
 * Clasa reprezintă pagina unui produs individual din magazinul online.
 * Aici putem alege mărimea, culoarea și putem adăuga produsul în coș.
 */
public class ProductPage {

    // Obiect WebDriver pentru a controla browserul
    private final WebDriver driver;

    // Helper pentru acțiuni comune pe elemente (click, scriere text, așteptare)
    private final ElementHelper helper;

    // Selectori pentru opțiunile și butonul produsului
    private final By sizeM = By.id("option-label-size-143-item-168");
    private final By colorBlue = By.id("option-label-color-93-item-60");
    private final By addToCart = By.id("product-addtocart-button");

    /**
     * Constructorul primește WebDriver-ul și creează obiectul helper.
     * @param driver instanța WebDriver folosită în test
     */
    public ProductPage(WebDriver driver){
        this.driver = driver;
        helper = new ElementHelper(driver);
    }

    /**
     * Selectează mărimea M a produsului.
     */
    public void selectSize(){
        helper.click(sizeM);
    }

    /**
     * Selectează culoarea Albastru a produsului.
     */
    public void selectColor(){
        helper.click(colorBlue);
    }

    /**
     * Adaugă produsul în coș folosind JavaScriptExecutor.
     *
     * <p>JavaScriptExecutor permite rularea de cod JavaScript direct în contextul paginii încărcate.
     * Este util atunci când:
     * <ul>
     *   <li>Click-ul clasic Selenium (`element.click()`) eșuează din cauza animațiilor sau
     *       a elementelor suprapuse (overlay-uri).</li>
     *   <li>Vrei să faci scroll precis până la element, într-o anumită poziție pe ecran.</li>
     * </ul>
     *
     * <p>Ce face metoda:
     * <ol>
     *   <li>Așteaptă până când butonul „Add to Cart” devine clicabil.</li>
     *   <li>Folosește `scrollIntoView({block: 'center'})` pentru a muta viewport-ul astfel încât butonul să fie centrat pe ecran.</li>
     *   <li>Folosește `click()` din JavaScript pentru a simula apăsarea butonului direct în DOM.</li>
     * </ol>
     *
     * <p>⚠ Atenție: Click-ul prin JavaScript poate ocoli verificările Selenium
     * și poate apăsa pe elemente care, vizual, nu sunt accesibile utilizatorului (ex. acoperite de un overlay).
     */
    public void addToCart(){
        // 1) Așteaptă până când butonul devine clicabil
        WebElement btn = helper.waitClickable(addToCart);

        // 2) Scroll cu JavaScript până când butonul e în centrul ecranului
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", btn
        );

        // 3) Click direct pe element cu JavaScript
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", btn
        );
    }
}