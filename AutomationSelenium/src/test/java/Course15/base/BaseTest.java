package Course15.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Course15.utils.EmailUtils;

import java.time.Duration;

/**
 * Clasa de bază pentru testele automate.
 * Conține logica de inițializare și închidere a browserului,
 * astfel încât să nu fie nevoie să fie repetată în fiecare test.
 */
public class BaseTest {

    // Driver-ul protejat, accesibil în clasele de test care extind BaseTest
    protected WebDriver driver;
    protected static String EMAIL;
    protected static final String PASSWORD = "Pa$$w0rd";

    /**
     * Metodă statică ce se execută o singură dată înainte de toate testele.
     * Configurează automat driver-ul pentru Chrome folosind WebDriverManager,
     * astfel încât să nu fie nevoie să descărcăm manual chromedriver.exe.
     */
    @BeforeAll
    public static void setupDriver(){
        WebDriverManager.chromedriver().setup();
        EMAIL = EmailUtils.randomEmail();
    }

    /**
     * Metodă ce se execută înaintea fiecărui test.
     * Deschide browserul Chrome în modul incognito și îl maximizează.
     * De asemenea, setează implicit wait la 0 secunde (folosim doar explicit waits în ElementHelper).
     */
    @BeforeEach
    public void openBrowser(){
        // Opțiuni suplimentare pentru Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        // Inițializează driver-ul Chrome cu opțiunile setate
        driver = new ChromeDriver(options);

        // Maximizează fereastra browserului
        driver.manage().window().maximize();

        // Setează timpul de așteptare implicit la 0 (folosim explicit waits)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }

    /**
     * Metodă ce se execută după fiecare test.
     * Închide browserul dacă driver-ul este activ.
     */
    @AfterEach
    public void closeBrowser(){
        if (driver != null) {
            driver.quit();
        }
    }
}