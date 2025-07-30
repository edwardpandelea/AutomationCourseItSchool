package Course12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    WebDriver driver;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void openBrowser() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        logIn(); // apelam functia de log in
    }
    @Test
    public void addToFavorite() throws InterruptedException { // verifica daca un produs cu un id random poate fii adaugat la favorite
        int randomId = (int)(Math.random() * 25) + 1; // id random de la 1 la 25
        driver.findElement(By.xpath("//*[@id='" + randomId + "']/div[@class='shelf-stopper']")).click(); // click pe inimioara acelui produs
        driver.findElement(By.id("favourites")).click();
        Thread.sleep(Duration.ofSeconds(2));
        assertTrue(driver.findElement(By.xpath("//*[@id='"+ randomId +"']")).isDisplayed()); // verifica daca acel produs este vizibil in pagina de favorite
        System.out.println( "Produsul cu id-ul " + randomId + " a fost adaugat la favorite");
    }

    @Test
    public void verificareFiltre() throws InterruptedException {
        List<String> filtru = List.of("Apple", "Samsung", "Google", "OnePlus"); // lista cu filtrele disponibile
        for (String elem : filtru) {
            verificareFiltruSpecific(elem); // apeleaza functia de verificareFiltruSpecifica cu fiecare din filtrele de mai sus
        }
    }

    public void verificareFiltruSpecific(String filtru) throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='"+ filtru + "' and @class='checkmark']")).click(); // click pe filtrul ales
        Thread.sleep(Duration.ofSeconds(2));
        List<WebElement> produse = driver.findElements(By.xpath("//*[@class='shelf-item']/p[@class= class='shelf-item__title']")); // ia toate produsele vizibile
        // verifica fiecare produs in parte in functie de filtru
        for (WebElement produs : produse) {
            String sku = produs.getText().toLowerCase();
            System.out.println(sku);
            if(filtru.equals("Apple")) {
                assertTrue(sku.contains("iphone"));
            } else if(filtru.equals("Samsung")){
                assertTrue(sku.contains("galaxy"));
            } else if(filtru.equals("Google")){
                assertTrue(sku.contains("pixel"));
            } else if(filtru.equals("OnePlus")){
                assertTrue(sku.contains("one plus"));
            }
        }
        driver.findElement(By.xpath("//*[text()='"+ filtru + "' and @class='checkmark']")).click(); // pentru a scoate filtrul anterior
    }


    // functie log in apelata in beforeeach

    public void logIn() throws InterruptedException {
        driver.get("https://bstackdemo.com");
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.id("signin")).click();
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.id("username")).click();
        driver.findElement(By.xpath("//*[text()='demouser']")).click();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.xpath("//*[text()='testingisfun99']")).click();
        driver.findElement(By.id("login-btn")).click();
        Thread.sleep(Duration.ofSeconds(2));
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}
