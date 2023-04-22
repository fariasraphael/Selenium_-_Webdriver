package aula6_praticando_forms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class formularioDesafio {
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
    public void formulárioCompletoTeste(){
        WebElement campoNomeElement = driver.findElement(By.id("campoTexto"));
        campoNomeElement.sendKeys("Raphael");
        Assertions.assertEquals("Raphael", campoNomeElement.getAttribute("value"));

        WebElement campoSenhaElement = driver.findElement(By.id("campoSenha"));
        campoSenhaElement.sendKeys("AB123");
        Assertions.assertEquals("AB123", campoSenhaElement.getAttribute("value"));

        WebElement campoNumeroElement = driver.findElement(By.id("campoNumero"));
        campoNumeroElement.sendKeys("123");
        Assertions.assertEquals("123",campoNumeroElement.getAttribute("value"));

        WebElement campoTextoLongoElement = driver.findElement(By.id("campoTextoLongo"));
        campoTextoLongoElement.sendKeys("Texto looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooongo");
        Assertions.assertEquals("Texto looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooongo",campoTextoLongoElement.getAttribute("value"));

        WebElement campoDataElement = driver.findElement(By.id("campoData"));
        //campoDataElement.sendKeys("17042023");
        //campoDataElement.sendKeys("17/04/2023");
        campoDataElement.sendKeys("17-04-2023");
        Assertions.assertEquals("2023-04-17",campoDataElement.getAttribute("value"));

        WebElement CampoHoraElement = driver.findElement(By.id("campoHora"));
        CampoHoraElement.sendKeys("2000");
        //CampoHoraElement.sendKeys("20:00");
        Assertions.assertEquals("20:00",CampoHoraElement.getAttribute("value"));
        System.out.println(CampoHoraElement.getAttribute("value"));

        WebElement campoEmailElement = driver.findElement(By.id("campoEmail"));
        campoEmailElement.sendKeys("raphael@emal.com");
        Assertions.assertEquals("raphael@emal.com",campoEmailElement.getAttribute("value"));

        WebElement campoURLElement = driver.findElement(By.id("campoUrl"));
        campoURLElement.sendKeys("https://www.google.com/");
        Assertions.assertEquals("https://www.google.com/",campoURLElement.getAttribute("value"));

//        campoURLElement.sendKeys(Keys.ENTER);
        WebElement button = driver.findElement(By.cssSelector("button.btn.btn-primary"));
        button.click();
//        WebElement form = driver.findElement(By.id("formulario"));
//        form.submit();
    }
    @Test
    public void formulárioEmailIncorretoTeste(){
        WebElement campoNomeElement = driver.findElement(By.id("campoTexto"));
        campoNomeElement.sendKeys("Raphael");
        Assertions.assertEquals("Raphael", campoNomeElement.getAttribute("value"));

        WebElement campoSenhaElement = driver.findElement(By.id("campoSenha"));
        campoSenhaElement.sendKeys("AB123");
        Assertions.assertEquals("AB123", campoSenhaElement.getAttribute("value"));

        WebElement campoNumeroElement = driver.findElement(By.id("campoNumero"));
        campoNumeroElement.sendKeys("123");
        Assertions.assertEquals("123",campoNumeroElement.getAttribute("value"));

        WebElement campoTextoLongoElement = driver.findElement(By.id("campoTextoLongo"));
        campoTextoLongoElement.sendKeys("Texto looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooongo");
        Assertions.assertEquals("Texto looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooongo",campoTextoLongoElement.getAttribute("value"));

        WebElement campoDataElement = driver.findElement(By.id("campoData"));
        //campoDataElement.sendKeys("17042023");
        //campoDataElement.sendKeys("17/04/2023");
        campoDataElement.sendKeys("17-04-2023");
        Assertions.assertEquals("2023-04-17",campoDataElement.getAttribute("value"));

        WebElement CampoHoraElement = driver.findElement(By.id("campoHora"));
        CampoHoraElement.sendKeys("2000");
        //CampoHoraElement.sendKeys("20:00");
        Assertions.assertEquals("20:00",CampoHoraElement.getAttribute("value"));

        WebElement campoEmailElement = driver.findElement(By.id("campoEmail"));
        campoEmailElement.sendKeys("raphaelemail.com");
        Assertions.assertEquals("raphaelemail.com",campoEmailElement.getAttribute("value"));

        WebElement campoURLElement = driver.findElement(By.id("campoUrl"));
        campoURLElement.sendKeys("https://www.google.com/");
        Assertions.assertEquals("https://www.google.com/",campoURLElement.getAttribute("value"));

//        campoURLElement.sendKeys(Keys.ENTER);
        WebElement button = driver.findElement(By.cssSelector("button.btn.btn-primary"));
        button.click();
//        WebElement form = driver.findElement(By.id("formulario"));
//        form.submit();

        String validationMassageEmail = campoEmailElement.getAttribute("validationMessage");
        Assertions.assertEquals("Inclua um \"@\" no endereço de e-mail. \"raphaelemail.com\" está com um \"@\" faltando.", validationMassageEmail);
        }
}
