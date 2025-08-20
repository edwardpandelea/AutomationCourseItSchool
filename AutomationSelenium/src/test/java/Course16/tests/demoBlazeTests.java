package Course16.tests;

import Course15.base.BaseTest;
import Course16.pages.CartPage;
import Course16.pages.CheckoutPage;
import Course16.pages.HomePage;
import Course16.pages.ProductDetailsPage;
import org.junit.jupiter.api.Test;

public class demoBlazeTests extends BaseTest {

    @Test
    public void demoBlazeTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.clickOnSpecificProduct("Nexus 6");
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.addToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.open();
        cartPage.clickPlaceOrder();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.placeOrder();
        checkoutPage.verifyOrderSuccess();
    }
}
