package aula7_praticando_waits.exercicio_class;

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

import java.time.Duration;

public class WaitImplicitoTestClass {
    public final String URL = "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";
    public WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.get(URL);
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    @Test
    public void button1Test() {
        WebElement element = driver.findElement(By.id("alert"));
        element.click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("I got opened after 5 secods", alert.getText());
    }

    @Test
    public void button2Test() {
        WebElement element = driver.findElement(By.id("populate-text"));
        WebElement h2Element = driver.findElement(By.id("h2"));
        Assertions.assertEquals("site", h2Element.getText());
        element.click();
        Assertions.assertEquals("Selenium Webdriver", h2Element.getText());
    }

    @Test
    public void button3Test() {
        WebElement element = driver.findElement(By.id("display-other-button"));
        element.click();
        WebElement hiddenElement = driver.findElement(By.id("hidden"));
        hiddenElement.click();
        Assertions.assertTrue(hiddenElement.isDisplayed());
    }

    @Test
    public void button4Test() {
        WebElement element = driver.findElement(By.id("enable-button"));
        element.click();
        WebElement disableElement = driver.findElement(By.id("disable"));
        disableElement.click();
        Assertions.assertTrue(disableElement.isEnabled());
    }

    @Test
    public void button5Test(){
        WebElement element = driver.findElement(By.id("checkbox"));
        element.click();
        WebElement chElement = driver.findElement(By.id("ch"));
        Assertions.assertTrue(chElement.isSelected());
    }
}
