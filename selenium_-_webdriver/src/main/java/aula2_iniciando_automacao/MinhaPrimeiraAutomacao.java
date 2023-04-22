package aula2_iniciando_automacao;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinhaPrimeiraAutomacao {
    private static final String URL = "https://google.com.br";

    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    @Test
    public void test_google_chrome() {
        assertEquals("Google", driver.getTitle());

    }

    @Test
    public void test_google_firefox() {


        assertEquals("Google", driver.getTitle());

    }

    @Test
    public void test_google_edge() {


        assertEquals("Google", driver.getTitle());

    }

    @Test
    public void test_google_janela() {


        driver.manage().window().setPosition(new Point(150, 20));
        driver.manage().window().minimize();
        driver.manage().window().maximize();

    }

}
