package aula5_desafio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Desafio {
    private static String URL = "https://rachacuca.com.br/logica/problemas/show-de-talentos/";
    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    public void test1() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/div[2]/ul/li[1]/select"));
        Select select = new Select(element);

        select.selectByVisibleText("azul");
        Assertions.assertEquals("azul", select.getFirstSelectedOption().getText());

    }
}
