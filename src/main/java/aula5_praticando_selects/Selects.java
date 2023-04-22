package aula5_praticando_selects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class Selects {

    public static String URL = "https://igorsmasc.github.io/praticando_selects_radio_checkbox/";
    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterAll
    public static void afterAll() {
        //driver.quit();
    }

    @BeforeEach
    public void beforeEach() {
        driver.get(URL);
    }

    @Test
    public void selectMenuDropDownTest() {
        WebElement MenuDropDown = driver.findElement(By.id("categoria"));
        Select selectCategoria = new Select(MenuDropDown);

        //selectCategoria.selectByVisibleText("Almoço e Janta");
        //selectCategoria.selectByValue("almoco_janta");
        selectCategoria.selectByIndex(1);

        //Assertions.assertEquals(1, 1); //selação por index
        Assertions.assertEquals(("Almoço e Janta"), selectCategoria.getFirstSelectedOption().getText());
    }

    @Test
    public void selectMultipleTest() {
        WebElement selectWebElement = driver.findElement(By.id("ingredientes"));
        Select selectIngredientes = new Select(selectWebElement);

        selectIngredientes.selectByVisibleText("Ovos");
        selectIngredientes.selectByVisibleText("Frango");

        List<WebElement> elementosSelecionados = selectIngredientes.getAllSelectedOptions();

        List<String> elementosSelecionadosString_avancado = elementosSelecionados.stream().map(WebElement::getText).collect(Collectors.toList());
        //List<String> elementosSelecionadosString = elementosSelecionados.stream().map(elemento -> elemento.getText()).collect(Collectors.toList());


        Assertions.assertArrayEquals(new String[]{"Ovos", "Frango"}, elementosSelecionadosString_avancado.toArray());
    }

    @Test
    public void checkboxTest() {
        WebElement checkForno = driver.findElement(By.id("forno"));
        WebElement checkAirFryer = driver.findElement(By.id("air-fryer"));
        WebElement checkGeladeira = driver.findElement(By.id("geladeira"));
        WebElement checkMicroondas = driver.findElement(By.id("microondas"));

        checkForno.click();
        checkAirFryer.click();

        Assertions.assertFalse(checkGeladeira.isSelected());
        Assertions.assertFalse(checkMicroondas.isSelected());

        Assertions.assertTrue(checkForno.isSelected());
        Assertions.assertTrue(checkAirFryer.isSelected());
    }

    @Test
    public void radioButtonTest() {
        WebElement facil = driver.findElement(By.id("facil"));
        WebElement medio = driver.findElement(By.id("medio"));
        WebElement dificil = driver.findElement(By.id("dificil"));

        //((JavascriptExecutor) driver).executeScript("arguments[0].click()", facil);
        facil.click();

        Assertions.assertTrue(facil.isSelected());
        Assertions.assertFalse(medio.isSelected());
        Assertions.assertFalse(dificil.isSelected());

        //((JavascriptExecutor) driver).executeScript("arguments[0].click()", medio);
        medio.click();
        Assertions.assertTrue(medio.isSelected());
        Assertions.assertFalse(facil.isSelected());
        Assertions.assertFalse(dificil.isSelected());

        //dificil.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", dificil);
        Assertions.assertTrue(dificil.isSelected());
        Assertions.assertFalse(facil.isSelected());
        Assertions.assertFalse(medio.isSelected());
    }
}
