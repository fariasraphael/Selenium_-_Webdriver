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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitExplicitoTestClass {
    private final String URL = "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(11));
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    @Test
    public void button1Test() {
        WebElement element = driver.findElement(By.id("alert"));
        element.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("I got opened after 5 secods", alert.getText());
    }

    @Test
    public void button2Test() {
        WebElement element = driver.findElement(By.id("populate-text"));
        element.click();
        wait.until(ExpectedConditions.textToBe(By.id("h2"), "site"));
        wait.until(ExpectedConditions.textToBe(By.id("h2"), "Selenium Webdriver"));
    }

    @Test
    public void button3Test() {
        WebElement element = driver.findElement(By.id("display-other-button"));
        element.click();
        WebElement hiddenElement = driver.findElement(By.id("hidden"));
        wait.until(ExpectedConditions.visibilityOf(hiddenElement));
    }
    @Test
    public void button4Test(){
        WebElement element = driver.findElement(By.id("enable-button"));
        element.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("disable")));
//        WebElement buttonElement = driver.findElement(By.id("disable"));
//        wait.until(ExpectedConditions.elementToBeClickable(buttonElement));
    }

    @Test
    public void button5Test(){
        WebElement element = driver.findElement(By.id("checkbox"));
        element.click();
        wait.until(ExpectedConditions.elementSelectionStateToBe(By.id("ch"), true));
//        WebElement chElement = driver.findElement(By.id("ch"));
//        wait.until(ExpectedConditions.elementSelectionStateToBe(chElement, true));
    }
}
