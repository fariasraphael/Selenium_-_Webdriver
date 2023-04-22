package aula4_exercicio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculadoraTeste {
    private static String URL = "https://igorsmasc.github.io/calculadora_atividade_selenium/";
    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterEach
    public void clearEach() {
        WebElement clear = driver.findElement(By.cssSelector("button.btn.btn-secondary"));
        clear.click();
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }

    @Test
    public void adicaoTeste() {
        WebElement digito1 = driver.findElement(By.id("one"));
        WebElement display = driver.findElement(By.id("display"));
        WebElement soma = driver.findElement(By.id("add"));
        WebElement digito7 = driver.findElement(By.id("seven"));
        WebElement igual = driver.findElement(By.id("equals"));

        digito1.click();
        Assertions.assertEquals("1", display.getAttribute("value"));

        soma.click();
        Assertions.assertEquals("1+", display.getAttribute("value"));

        digito7.click();
        Assertions.assertEquals("1+7", display.getAttribute("value"));

        igual.click();
        Assertions.assertEquals("8", display.getAttribute("value"));
    }

    @Test
    public void adicaoComPrimeiroDigitoNegativosTeste() {
        WebElement digito1 = driver.findElement(By.id("one"));
        WebElement display = driver.findElement(By.id("display"));
        WebElement soma = driver.findElement(By.id("add"));
        WebElement digito7 = driver.findElement(By.id("seven"));
        WebElement igual = driver.findElement(By.id("equals"));
        WebElement subtracao = driver.findElement(By.id("subtract"));

        subtracao.click();
        Assertions.assertEquals("-", display.getAttribute("value"));

        digito1.click();
        Assertions.assertEquals("-1", display.getAttribute("value"));

        soma.click();
        Assertions.assertEquals("-1+", display.getAttribute("value"));

        digito7.click();
        Assertions.assertEquals("-1+7", display.getAttribute("value"));

        igual.click();
        Assertions.assertEquals("6", display.getAttribute("value"));
    }

    @Test
    public void adicaoComSegundoDigitoNegativosTeste() {
        WebElement digito1 = driver.findElement(By.id("one"));
        WebElement display = driver.findElement(By.id("display"));
        WebElement soma = driver.findElement(By.id("add"));
        WebElement digito7 = driver.findElement(By.id("seven"));
        WebElement igual = driver.findElement(By.id("equals"));
        WebElement subtracao = driver.findElement(By.id("subtract"));

        digito1.click();
        Assertions.assertEquals("1", display.getAttribute("value"));

        soma.click();
        Assertions.assertEquals("1+", display.getAttribute("value"));

        subtracao.click();
        Assertions.assertEquals("1+-", display.getAttribute("value"));

        digito7.click();
        Assertions.assertEquals("1+-7", display.getAttribute("value"));

        igual.click();
        Assertions.assertEquals("-6", display.getAttribute("value"));
    }

    @Test
    public void adicaoComDoisDigitosNegativosTeste() {
        WebElement digito1 = driver.findElement(By.id("one"));
        WebElement display = driver.findElement(By.id("display"));
        WebElement soma = driver.findElement(By.id("add"));
        WebElement digito7 = driver.findElement(By.id("seven"));
        WebElement igual = driver.findElement(By.id("equals"));
        WebElement subtracao = driver.findElement(By.id("subtract"));

        subtracao.click();
        Assertions.assertEquals("-", display.getAttribute("value"));

        digito1.click();
        Assertions.assertEquals("-1", display.getAttribute("value"));

        soma.click();
        Assertions.assertEquals("-1+", display.getAttribute("value"));

        subtracao.click();
        Assertions.assertEquals("-1+-", display.getAttribute("value"));

        digito7.click();
        Assertions.assertEquals("-1+-7", display.getAttribute("value"));

        igual.click();
        Assertions.assertEquals("-8", display.getAttribute("value"));
    }

    @Test
    public void subtracaoTeste() {
        WebElement digito2 = driver.findElement(By.xpath("//*[@id=\"two\"]"));
        WebElement display = driver.findElement(By.xpath("//*[@id=\"display\"]"));
        WebElement subtracao = driver.findElement(By.xpath("//*[@id=\"subtract\"]"));
        WebElement digito8 = driver.findElement(By.xpath("//*[@id=\"eight\"]"));
        WebElement igual = driver.findElement(By.xpath("//*[@id=\"equals\"]"));

        digito8.click();
        Assertions.assertEquals("8", display.getAttribute("value"));

        subtracao.click();

        Assertions.assertEquals("8-", display.getAttribute("value"));

        digito2.click();
        Assertions.assertEquals("8-2", display.getAttribute("value"));

        igual.click();
        Assertions.assertEquals("6", display.getAttribute("value"));
    }

    @Test
    public void subtracaoComPrimeiroDigitoNegativosTeste() {
        WebElement digito2 = driver.findElement(By.xpath("//*[@id=\"two\"]"));
        WebElement display = driver.findElement(By.xpath("//*[@id=\"display\"]"));
        WebElement subtracao = driver.findElement(By.xpath("//*[@id=\"subtract\"]"));
        WebElement digito8 = driver.findElement(By.xpath("//*[@id=\"eight\"]"));
        WebElement igual = driver.findElement(By.xpath("//*[@id=\"equals\"]"));

        subtracao.click();
        Assertions.assertEquals("-", display.getAttribute("value"));

        digito8.click();
        Assertions.assertEquals("-8", display.getAttribute("value"));

        subtracao.click();
        Assertions.assertEquals("-8-", display.getAttribute("value"));

        digito2.click();
        Assertions.assertEquals("-8-2", display.getAttribute("value"));

        igual.click();
        Assertions.assertEquals("-10", display.getAttribute("value"));
    }

    @Test
    public void subtracaoComSegundoDigitoNegativosTeste() {
        WebElement digito2 = driver.findElement(By.xpath("//*[@id=\"two\"]"));
        WebElement display = driver.findElement(By.xpath("//*[@id=\"display\"]"));
        WebElement subtracao = driver.findElement(By.xpath("//*[@id=\"subtract\"]"));
        WebElement digito8 = driver.findElement(By.xpath("//*[@id=\"eight\"]"));
        WebElement igual = driver.findElement(By.xpath("//*[@id=\"equals\"]"));

        digito8.click();
        Assertions.assertEquals("8", display.getAttribute("value"));

        subtracao.click();
        Assertions.assertEquals("8-", display.getAttribute("value"));

        subtracao.click();
        Assertions.assertEquals("8--", display.getAttribute("value"));

        digito2.click();
        Assertions.assertEquals("8--2", display.getAttribute("value"));

        igual.click();
        Assertions.assertEquals("10", display.getAttribute("value"));
    }

    @Test
    public void subtracaoDoisDigitoNegativosTeste() {
        WebElement digito2 = driver.findElement(By.xpath("//*[@id=\"two\"]"));
        WebElement display = driver.findElement(By.xpath("//*[@id=\"display\"]"));
        WebElement subtracao = driver.findElement(By.xpath("//*[@id=\"subtract\"]"));
        WebElement digito8 = driver.findElement(By.xpath("//*[@id=\"eight\"]"));
        WebElement igual = driver.findElement(By.xpath("//*[@id=\"equals\"]"));

        subtracao.click();
        Assertions.assertEquals("-", display.getAttribute("value"));

        digito8.click();
        Assertions.assertEquals("-8", display.getAttribute("value"));

        subtracao.click();
        Assertions.assertEquals("-8-", display.getAttribute("value"));

        subtracao.click();
        Assertions.assertEquals("-8--", display.getAttribute("value"));

        digito2.click();
        Assertions.assertEquals("-8--2", display.getAttribute("value"));

        igual.click();
        Assertions.assertEquals("-6", display.getAttribute("value"));
    }

    @Test
    public void multiplicacaoTeste() {
        WebElement digito9 = driver.findElement(By.cssSelector("button#nine"));
        WebElement display = driver.findElement(By.cssSelector("input#display"));
        WebElement multiplicacao = driver.findElement(By.cssSelector("button#multiply"));
        WebElement digito3 = driver.findElement(By.cssSelector("button#three"));
        WebElement igual = driver.findElement(By.cssSelector("button#equals"));

        digito9.click();
        Assertions.assertEquals("9", display.getAttribute("value"));
        multiplicacao.click();
        Assertions.assertEquals("9*", display.getAttribute("value"));
        digito3.click();
        Assertions.assertEquals("9*3", display.getAttribute("value"));
        igual.click();
        Assertions.assertEquals("27", display.getAttribute("value"));
    }

    @Test
    public void multiplicacaoComPrimeiroDigitoNegativoTeste() {
        WebElement digito9 = driver.findElement(By.cssSelector("button#nine"));
        WebElement display = driver.findElement(By.cssSelector("input#display"));
        WebElement multiplicacao = driver.findElement(By.cssSelector("button#multiply"));
        WebElement digito3 = driver.findElement(By.cssSelector("button#three"));
        WebElement igual = driver.findElement(By.cssSelector("button#equals"));
        WebElement subtracao = driver.findElement(By.xpath("//*[@id=\"subtract\"]"));

        subtracao.click();
        Assertions.assertEquals("-", display.getAttribute("value"));

        digito9.click();
        Assertions.assertEquals("-9", display.getAttribute("value"));

        multiplicacao.click();
        Assertions.assertEquals("-9*", display.getAttribute("value"));

        digito3.click();
        Assertions.assertEquals("-9*3", display.getAttribute("value"));

        igual.click();
        Assertions.assertEquals("-27", display.getAttribute("value"));
    }

    @Test
    public void multiplicacaoComSegunoDigitoNegativoTeste() {
        WebElement digito9 = driver.findElement(By.cssSelector("button#nine"));
        WebElement display = driver.findElement(By.cssSelector("input#display"));
        WebElement multiplicacao = driver.findElement(By.cssSelector("button#multiply"));
        WebElement digito3 = driver.findElement(By.cssSelector("button#three"));
        WebElement igual = driver.findElement(By.cssSelector("button#equals"));
        WebElement subtracao = driver.findElement(By.xpath("//*[@id=\"subtract\"]"));

        digito9.click();
        Assertions.assertEquals("9", display.getAttribute("value"));

        multiplicacao.click();
        Assertions.assertEquals("9*", display.getAttribute("value"));

        subtracao.click();
        Assertions.assertEquals("9*-", display.getAttribute("value"));

        digito3.click();
        Assertions.assertEquals("9*-3", display.getAttribute("value"));

        igual.click();
        Assertions.assertEquals("-27", display.getAttribute("value"));
    }

    @Test
    public void multiplicacaoDoisDigitoNegativoTeste() {
        WebElement digito9 = driver.findElement(By.cssSelector("button#nine"));
        WebElement display = driver.findElement(By.cssSelector("input#display"));
        WebElement multiplicacao = driver.findElement(By.cssSelector("button#multiply"));
        WebElement digito3 = driver.findElement(By.cssSelector("button#three"));
        WebElement igual = driver.findElement(By.cssSelector("button#equals"));
        WebElement subtracao = driver.findElement(By.xpath("//*[@id=\"subtract\"]"));

        subtracao.click();
        Assertions.assertEquals("-", display.getAttribute("value"));

        digito9.click();
        Assertions.assertEquals("-9", display.getAttribute("value"));

        multiplicacao.click();
        Assertions.assertEquals("-9*", display.getAttribute("value"));

        subtracao.click();
        Assertions.assertEquals("-9*-", display.getAttribute("value"));

        digito3.click();
        Assertions.assertEquals("-9*-3", display.getAttribute("value"));

        igual.click();
        Assertions.assertEquals("27", display.getAttribute("value"));
    }

    @Test
    public void divisaoTeste() {
        WebElement digito4 = driver.findElement(By.id("four"));
        WebElement display = driver.findElement(By.xpath("//*[@id=\"display\"]"));
        WebElement digito0 = driver.findElement(By.id("zero"));
        WebElement divisao = driver.findElement(By.xpath("//*[@id=\"divide\"]"));
        WebElement digito5 = driver.findElement(By.id("five"));
        WebElement igual = driver.findElement(By.id("equals"));

        digito4.click();
        Assertions.assertEquals("4", display.getAttribute("value"));
        digito0.click();
        Assertions.assertEquals("40", display.getAttribute("value"));
        divisao.click();
        Assertions.assertEquals("40/", display.getAttribute("value"));
        digito5.click();
        Assertions.assertEquals("40/5", display.getAttribute("value"));
        igual.click();
        Assertions.assertEquals("8", display.getAttribute("value"));
        ;
    }

    @Test
    public void divisaoPorZeroTeste() {
        WebElement digito6 = driver.findElement(By.id("six"));
        WebElement display = driver.findElement(By.xpath("//*[@id=\"display\"]"));
        WebElement digito0 = driver.findElement(By.id("zero"));
        WebElement divisao = driver.findElement(By.xpath("//*[@id=\"divide\"]"));
        WebElement igual = driver.findElement(By.id("equals"));

        digito6.click();
        Assertions.assertEquals("6", display.getAttribute("value"));
        divisao.click();
        Assertions.assertEquals("6/", display.getAttribute("value"));
        digito0.click();
        Assertions.assertEquals("6/0", display.getAttribute("value"));
        igual.click();
        Assertions.assertEquals("Infinity", display.getAttribute("value"));

    }

    @Test
    public void divisaoPrimeiroDigitoNegativoTeste() {
        WebElement digito4 = driver.findElement(By.id("four"));
        WebElement display = driver.findElement(By.xpath("//*[@id=\"display\"]"));
        WebElement digito0 = driver.findElement(By.id("zero"));
        WebElement divisao = driver.findElement(By.xpath("//*[@id=\"divide\"]"));
        WebElement digito5 = driver.findElement(By.id("five"));
        WebElement igual = driver.findElement(By.id("equals"));
        WebElement subtracao = driver.findElement(By.xpath("//*[@id=\"subtract\"]"));

        subtracao.click();
        Assertions.assertEquals("-", display.getAttribute("value"));

        digito4.click();
        Assertions.assertEquals("-4", display.getAttribute("value"));

        digito0.click();
        Assertions.assertEquals("-40", display.getAttribute("value"));

        divisao.click();
        Assertions.assertEquals("-40/", display.getAttribute("value"));

        digito5.click();
        Assertions.assertEquals("-40/5", display.getAttribute("value"));

        igual.click();
        Assertions.assertEquals("-8", display.getAttribute("value"));
        ;
    }

    @Test
    public void divisaoSegundoDigitoNegativoTeste() {
        WebElement digito4 = driver.findElement(By.id("four"));
        WebElement display = driver.findElement(By.xpath("//*[@id=\"display\"]"));
        WebElement digito0 = driver.findElement(By.id("zero"));
        WebElement divisao = driver.findElement(By.xpath("//*[@id=\"divide\"]"));
        WebElement digito5 = driver.findElement(By.id("five"));
        WebElement igual = driver.findElement(By.id("equals"));
        WebElement subtracao = driver.findElement(By.xpath("//*[@id=\"subtract\"]"));

        digito4.click();
        Assertions.assertEquals("4", display.getAttribute("value"));

        digito0.click();
        Assertions.assertEquals("40", display.getAttribute("value"));

        divisao.click();
        Assertions.assertEquals("40/", display.getAttribute("value"));

        subtracao.click();
        Assertions.assertEquals("40/-", display.getAttribute("value"));

        digito5.click();
        Assertions.assertEquals("40/-5", display.getAttribute("value"));

        igual.click();
        Assertions.assertEquals("-8", display.getAttribute("value"));
        ;
    }

    @Test
    public void divisaoDoisDigitoNegativoTeste() {
        WebElement digito4 = driver.findElement(By.id("four"));
        WebElement display = driver.findElement(By.xpath("//*[@id=\"display\"]"));
        WebElement digito0 = driver.findElement(By.id("zero"));
        WebElement divisao = driver.findElement(By.xpath("//*[@id=\"divide\"]"));
        WebElement digito5 = driver.findElement(By.id("five"));
        WebElement igual = driver.findElement(By.id("equals"));
        WebElement subtracao = driver.findElement(By.xpath("//*[@id=\"subtract\"]"));

        subtracao.click();
        Assertions.assertEquals("-", display.getAttribute("value"));

        digito4.click();
        Assertions.assertEquals("-4", display.getAttribute("value"));

        digito0.click();
        Assertions.assertEquals("-40", display.getAttribute("value"));

        divisao.click();
        Assertions.assertEquals("-40/", display.getAttribute("value"));

        subtracao.click();
        Assertions.assertEquals("-40/-", display.getAttribute("value"));

        digito5.click();
        Assertions.assertEquals("-40/-5", display.getAttribute("value"));

        igual.click();
        Assertions.assertEquals("8", display.getAttribute("value"));
        ;
    }
}
