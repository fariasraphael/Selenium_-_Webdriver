package aula6_praticando_frames_popup_abas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesPopupAba {
    private static final String URL = "https://igorsmasc.github.io/praticando_frames_popups_abas/";
    private static WebDriver driver;

    @BeforeEach
    public void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterAll
    public static void afterAll() {
        //driver.quit();
    }

    @Test
    public void clicaBotaoFrame() {
        driver.switchTo().frame("meu-frame");
        WebElement element = driver.findElement(By.id("frame-btn"));
        element.click();

        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Isso é raro", alert.getText());
        alert.dismiss();

        driver.switchTo().defaultContent();
        WebElement tituloElement = driver.findElement(By.id("titulo"));
        Assertions.assertEquals("Praticando Frames, Popups e Abas", tituloElement.getText());

    }

    @Test
    public void clicaBotaoPopupComID() {
        driver.findElement(By.id("alert-btn")).click();
        driver.switchTo().window("meu-lindo-popup");
        driver.findElement(By.xpath("/html/body/button")).click();
        driver.switchTo().alert().dismiss();
        driver.switchTo().defaultContent();
    }
    @Test
    public void clicaBotaoPopupComHendle() {
        driver.findElement(By.id("alert-btn")).click();
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        driver.findElement(By.xpath("/html/body/button")).click();
        driver.switchTo().alert().dismiss();
        driver.close();
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        WebElement tituloElement = driver.findElement(By.id("titulo"));
        Assertions.assertEquals("Praticando Frames, Popups e Abas", tituloElement.getText());

    }
    @Test
    public void clicaBotaoNovaAba() {
        driver.findElement(By.linkText("Abrir nova aba")).click();
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        Assertions.assertEquals("https://www.google.com/", driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        WebElement tituloElement = driver.findElement(By.id("titulo"));
        Assertions.assertEquals("Praticando Frames, Popups e Abas", tituloElement.getText());

    }
}
