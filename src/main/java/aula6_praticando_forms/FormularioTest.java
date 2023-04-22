package aula6_praticando_forms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormularioTest {
    private static final String URL = "https://igorsmasc.github.io/formularios_atividade_selenium/";
    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void beforeEach() {
        driver.get(URL);
    }

    @AfterAll
    public static void afterAll() {
        //driver.quit();
    }

    @Test
    public void campoTexto (){
        WebElement element = driver.findElement(By.id("campoTexto"));
        element.sendKeys("Raphael");
    }

    @Test
    public void campoData(){
        WebElement element = driver.findElement(By.id("campoData"));
        //element.sendKeys("17042023");
        //element.sendKeys("17/04/2023");
        element.sendKeys("17-04-2023");
    }

    @Test
    public void campoHora(){
        WebElement element = driver.findElement(By.id("campoHora"));
        //element.sendKeys("2000");
        element.sendKeys("20:00");

    }

}
