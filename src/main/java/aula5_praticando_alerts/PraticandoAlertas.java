package aula5_praticando_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class PraticandoAlertas {

    public static String URL = "https://igorsmasc.github.io/alertas_atividade_selenium/";
    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
        //driver.close(); //fecha apenas uma janela
    }

    @BeforeEach
    public void beforeEach() {
        driver.get(URL);
    }

    @Test
    public void alertSimples() {
        Assertions.assertFalse(existeAlertaAberto());

        WebElement element = driver.findElement(By.xpath("/html/body/div/button[1]"));
        element.click();

        Assertions.assertTrue(existeAlertaAberto());

        Alert alerta = driver.switchTo().alert();
        Assertions.assertEquals("Este é um alerta simples!", alerta.getText());
        alerta.accept();
    }

    @Test
    public void alertaConfirmacaoTeste() {
        WebElement element = driver.findElement(By.xpath("/html/body/div/button[2]"));
        element.click();

        Alert alerta = driver.switchTo().alert();

        Assertions.assertEquals("Tem certeza que deseja excluir este item?", alerta.getText());
        alerta.accept();
        Assertions.assertEquals("Item excluído com sucesso!", alerta.getText());
        alerta.accept();
    }

    @Test
    public void alertaConfirmacaoCanceladaTeste() {
        WebElement element = driver.findElement(By.xpath("/html/body/div/button[2]"));
        element.click();

        Alert alerta = driver.switchTo().alert();

        Assertions.assertEquals("Tem certeza que deseja excluir este item?", alerta.getText());
        alerta.dismiss();
        Assertions.assertEquals("A exclusão foi cancelada.", alerta.getText());
        alerta.accept();
    }

    @Test
    public void alertadeEntradaTeste() {
        WebElement element = driver.findElement(By.xpath("/html/body/div/button[3]"));
        element.click();

        Alert alerta = driver.switchTo().alert();

        Assertions.assertEquals("Por favor, insira seu nome:", alerta.getText());
        String nome = "JucA";

        alerta.sendKeys(nome);
        alerta.accept();

        Assertions.assertEquals("Bem-vindo, " + nome + "!", alerta.getText());
    }

    @Test
    public void alertadeEntradaSemNomeTeste() {
        WebElement element = driver.findElement(By.xpath("/html/body/div/button[3]"));
        element.click();

        Alert alerta = driver.switchTo().alert();

        Assertions.assertEquals("Por favor, insira seu nome:", alerta.getText());

        alerta.accept();

        Assertions.assertEquals("Você não inseriu um nome válido.", alerta.getText());
    }

    @Test
    public void alertadeEntradaDismissTeste() {
        WebElement element = driver.findElement(By.xpath("/html/body/div/button[3]"));
        element.click();

        Alert alerta = driver.switchTo().alert();

        Assertions.assertEquals("Por favor, insira seu nome:", alerta.getText());
        alerta.dismiss();

        Assertions.assertEquals("Você não inseriu um nome válido.", alerta.getText());
    }

    @Test
    public void naoFaznadaTeste() {
        Assertions.assertFalse(existeAlertaAberto());
    }


//    @Test
//    public void alertaNaoFoiAbertoTeste() {
//        try {
//            Alert alerta = driver.switchTo().alert();
//            Assertions.fail();
//        } catch (NoAlertPresentException e) {
//            Assertions.assertEquals("no such alert", e.getRawMessage().);
//        }
//    }

    private boolean existeAlertaAberto() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
