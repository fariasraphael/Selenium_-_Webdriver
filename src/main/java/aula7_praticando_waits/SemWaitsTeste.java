package aula7_praticando_waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SemWaitsTeste {

    private WebDriver driver;
    private final String URL = "https://igorsmasc.github.io/praticando_waits/";

    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    @Test
    public void botaoEscondidoTest() throws InterruptedException {
        WebElement element = driver.findElement(By.id("botao-escondido"));
        Thread.sleep(3500);
        element.click();

        Alert alert = driver.switchTo().alert();

        Assertions.assertEquals("Você clicou no botão escondido!", alert.getText());
    }

    @Test
    public void botaoAlertTest() throws InterruptedException {
        WebElement element = driver.findElement(By.id("botao-alerta"));
        element.click();

        Thread.sleep(3500);

        Alert alert = driver.switchTo().alert();

        Assertions.assertEquals("Alerta após 3 segundos!", alert.getText());
    }

    @Test
    public void botaoTituloTest() throws InterruptedException {
        WebElement element = driver.findElement(By.id("titulo"));
        Assertions.assertEquals("Título da Página", element.getText());

        WebElement botaoTitulo = driver.findElement(By.id("botao-titulo"));
        botaoTitulo.click();

        Thread.sleep(3500);

        Assertions.assertEquals("Novo Título da Página", element.getText());
    }

    @Test
    public void botaoParagrafoTest() throws InterruptedException {
        WebElement element = driver.findElement(By.id("botao-paragrafo"));
        element.click();

        Thread.sleep(3500);

        WebElement pElement = driver.findElement(By.tagName("p"));

        Assertions.assertEquals("Este é um novo parágrafo adicionado após 3 segundos.", pElement.getText());
    }

    @Test
    public void botaoNovoTest() throws InterruptedException {
        Thread.sleep(5000);

        WebElement element = driver.findElement(By.id("botao-novo"));
        element.click();

        Alert alert = driver.switchTo().alert();

        Assertions.assertEquals("Botão clicado!", alert.getText());
    }
}
