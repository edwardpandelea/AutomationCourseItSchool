package Course15.tests;

import Course15.base.BaseTest;
import org.junit.jupiter.api.*;
import Course15.pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clasa conține două teste automate pentru site-ul Magento demo.
 * - Se folosește Page Object Model (POM) → fiecare pagină are propria clasă cu metode specifice.
 * - Extinde BaseTest → primește automat inițializarea și închiderea browserului,
 *   dar și variabilele comune EMAIL și PASSWORD.
 *
 * IMPORTANT: EMAIL este generat o singură dată în @BeforeAll din BaseTest
 * și folosit în ambele teste (primul test creează contul, al doilea îl folosește pentru autentificare).
 *
 * @TestMethodOrder → asigură rularea testelor într-o ordine prestabilită
 * (important aici pentru că testul 2 folosește contul creat în testul 1).
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MagentoTests extends BaseTest {

    /**
     * Test 1: Creează un cont nou în site.
     *  - Se rulează primul (Order = 1).
     *  - Folosește EMAIL și PASSWORD definite în BaseTest.
     */
    @Test
    @Order(1)
    public void testCreateAccount(){
        // 1. Deschide pagina principală și navighează la formularul de creare cont
        HomePage home = new HomePage(driver);
        home.open();
        home.acceptCookiesIfPresent();
        home.goToCreateAccount();

        // 2. Completează formularul de înregistrare
        RegisterPage register = new RegisterPage(driver);
        register.fillName("ion", "marius");
        register.fillCredentials(EMAIL, PASSWORD); // EMAIL generat o singură dată în BaseTest
        register.submit();

        // 3. Verifică mesajul de confirmare
        String msg = register.getSuccessMessage();
        assertEquals("Thank you for registering with Main Website Store.", msg);
    }

    /**
     * Test 2: Plasează o comandă folosind contul creat la Test 1.
     *  - Se rulează după testul de creare cont (Order = 2).
     *  - Refolosește EMAIL și PASSWORD din BaseTest.
     */
    @Test
    @Order(2)
    public void testOrder(){
        // 1. Deschide pagina produsului
        HomePage home = new HomePage(driver);
        home.open();
        home.acceptCookiesIfPresent();
        home.openBreatheEasyTank();

        // 2. Selectează opțiunile produsului și îl adaugă în coș
        ProductPage product = new ProductPage(driver);
        product.selectSize();
        product.selectColor();
        product.addToCart();

        // 3. Accesează mini-coșul și merge la checkout
        home.openMiniCart();
        MiniCartPage mini = new MiniCartPage(driver);
        mini.proceedToCheckout();

        // 4. Completează procesul de checkout folosind contul creat în testul 1
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.signInDuringCheckout(EMAIL, PASSWORD); // EMAIL reutilizat
        checkout.fillAddress();
        checkout.chooseShippingAndContinue();

        // 5. Verifică prețul total
        assertEquals("$49.00", checkout.getTotal());

        // 6. Plasează comanda și verifică mesajul de confirmare
        checkout.placeOrder();
        String confirm = checkout.getConfirmation();
        assertEquals("Thank you for your purchase!", confirm);
    }
}