package aula7_praticando_waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitFluenteTeste {
    private WebDriver driver;
    private final String URL = "https://igorsmasc.github.io/praticando_waits/";
    private Wait<WebDriver> wait;

    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(6))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        driver.get(URL);
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    @Test
    public void botaoEscondidoTest() throws InterruptedException {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("botao-escodido")));
        WebElement element = driver.findElement(By.id("botao-escondido"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Você clicou no botão escondido!", alert.getText());
    }

    @Test
    public void botaoAlertTest() throws InterruptedException {
        WebElement element = driver.findElement(By.id("botao-alerta"));
        element.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        Assertions.assertEquals("Alerta após 3 segundos!", alert.getText());
    }

    @Test
    public void botaoTituloTest() throws InterruptedException {
        WebElement element = driver.findElement(By.id("titulo"));
        Assertions.assertEquals("Título da Página", element.getText());

        WebElement botaoTitulo = driver.findElement(By.id("botao-titulo"));
        botaoTitulo.click();

        wait.until(ExpectedConditions.textToBe(By.id("titulo"), "Novo Título da Página"));
        Assertions.assertEquals("Novo Título da Página", element.getText());
    }

    @Test
    public void botaoParagrafoTest() throws InterruptedException {
        WebElement element = driver.findElement(By.id("botao-paragrafo"));
        element.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("p")));
        WebElement pElement = driver.findElement(By.tagName("p"));

        Assertions.assertEquals("Este é um novo parágrafo adicionado após 3 segundos.", pElement.getText());
    }

    @Test
    public void botaoNovoTest() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("botao-novo")));
        WebElement element = driver.findElement(By.id("botao-novo"));
        element.click();

        Alert alert = driver.switchTo().alert();

        Assertions.assertEquals("Botão clicado!", alert.getText());
    }
}
