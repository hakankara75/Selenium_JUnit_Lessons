package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.*;

public class Selenium_JUnit_09_CheckBox_RadioButton_Test {
    WebDriver driver;

    @Before
    public void setup() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();

        //    kullanici https://demo.automationtesting.in/Register.html sayfasina gider
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void name() throws InterruptedException {
        WebElement male=driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        assertFalse(male.isSelected());
        male.click();
        Thread.sleep(2000);
       assertTrue(male.isSelected());

        WebElement female=driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        female.click();
        assertTrue(female.isSelected());
        Thread.sleep(2000);

        WebElement cricket=driver.findElement(By.id("checkbox1"));
        assertFalse(cricket.isSelected());

        WebElement movies=driver.findElement(By.id("checkbox2"));
        movies.click();
        assertTrue(movies.isSelected());



    }
}
