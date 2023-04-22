package aula4_praticando_clicks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class clicks {
    private static WebDriver driver;
    private static String URL = "https://igorsmasc.github.io/botoes_atividade_selenium/";

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
//        driver = new ChromeDriver(options);


    }

    @BeforeEach
    public void beforeEach() {
        driver.get(URL);
    }


    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void clicandoComID() {
        WebElement element = driver.findElement(By.id("button1"));
        element.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O botão 1 foi selecionado.", alert.getText());

        alert.accept();
    }

    @Test
    public void clicandoComClassName() {
        WebElement element = driver.findElement(By.className("button-2"));
        element.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O botão 2 foi selecionado.", alert.getText());

        alert.accept();
    }

    @Test
    public void clicandoComName() {
        WebElement element = driver.findElement(By.name("button3"));
        element.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O botão 3 foi selecionado.", alert.getText());

        alert.accept();
    }

    @Test
    public void clicandoCSS() {
        WebElement element = driver.findElement(By.cssSelector("div .btn.btn-primary.btn-lg.btn-block.button-4"));
        element.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O botão 4 foi selecionado.", alert.getText());

        alert.accept();
    }

    @Test
    public void clicandoXPATH() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"button5\"]"));
        element.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O botão 5 foi selecionado.", alert.getText());

        alert.accept();
    }

    @Test
    public void clicandoLivre1() {
        WebElement element1 = driver.findElement(By.id("button6-switch"));
        element1.click();

        WebElement element2 = driver.findElement(By.cssSelector(".btn.btn-primary.btn-lg.btn-block.button6"));
        element2.click();


        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O botão 6 foi selecionado.", alert.getText());

        alert.accept();
    }

    @Test
    public void clicandoLinkText() {
        WebElement element = driver.findElement(By.linkText("Link 1"));
        element.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O link 1 foi selecionado.", alert.getText());

        alert.accept();
    }

    @Test
    public void clicandoLinkPartial() {
        WebElement element = driver.findElement(By.partialLinkText("nk 2"));
        element.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O link 2 foi selecionado.", alert.getText());

        alert.accept();
    }

    @Test
    public void clicandoComLivre2() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"link3\"]"));
        element.click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("O link 3 foi selecionado.", alert.getText());

        alert.accept();
    }
}
