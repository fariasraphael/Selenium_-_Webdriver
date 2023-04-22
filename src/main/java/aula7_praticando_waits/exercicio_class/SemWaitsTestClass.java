package aula7_praticando_waits.exercicio_class;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SemWaitsTestClass {
    public final String URL = "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";
    public WebDriver driver;

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
    public void button1Test() throws InterruptedException {
        WebElement element = driver.findElement(By.id("alert"));
        element.click();
        Thread.sleep(5500);
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("I got opened after 5 secods", alert.getText());
    }

    @Test
    public void button2Test() throws InterruptedException {
        WebElement element = driver.findElement(By.id("populate-text"));
        element.click();
        WebElement h2Element = driver.findElement(By.id("h2"));
        Assertions.assertEquals("site", h2Element.getText());
        Thread.sleep(10500);
        Assertions.assertEquals("Selenium Webdriver", h2Element.getText());
    }

    @Test
    public void button3Test() throws InterruptedException {
        WebElement element = driver.findElement(By.id("display-other-button"));
        element.click();
        Thread.sleep(10500);
        WebElement hiddenElement = driver.findElement(By.id("hidden"));
        hiddenElement.click();
        Assertions.assertEquals("Enabled", hiddenElement.getText());
        Assertions.assertTrue(hiddenElement.isDisplayed());
    }

    @Test
    public void button4Test() throws InterruptedException {
        WebElement element = driver.findElement(By.id("enable-button"));
        element.click();
        Thread.sleep(10500);
        WebElement disableElement = driver.findElement(By.id("disable"));
        disableElement.click();
        Assertions.assertTrue(disableElement.isEnabled());
    }

    @Test
    public void button5Test() throws InterruptedException {
        WebElement element = driver.findElement(By.id("checkbox"));
        element.click();
        Thread.sleep(10500);
        WebElement checkboxElement = driver.findElement(By.id("ch"));
        Assertions.assertTrue(checkboxElement.isSelected());
    }
}
