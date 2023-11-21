package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.*;

public class Selenium_JUnit_08_Assertions_Test {
    WebDriver driver;
    @Before
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();

        //kullanici Teknosa sitesine gider
        driver.get("http://www.teknosa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void assertions() throws InterruptedException {
        WebElement reklam= driver.findElement(By.id("ins-editable-button-1580496494"));
        reklam.click();
        Thread.sleep(2000);

        //shadow root yapisini searchContext objesine yukler
        SearchContext searchContext=driver.findElement(By.xpath("//efilli-layout-dynamic")).getShadowRoot();

        //searchContext objesi uzerinden element tekrar locate edilir
        WebElement kabultEt= searchContext.findElement(By.cssSelector("div[data-name='Accept Button']"));
        kabultEt.click();
        Thread.sleep(2000);

        WebElement kampanyalar= driver.findElement(By.cssSelector("a[title='Kampanyalar']"));

        //assertTrue
        assertTrue(kampanyalar.isDisplayed());

        //assertFalse
        String expectedKampanyalarText= "Kampanya";
        String actualKampanyalarText= kampanyalar.getText();
        System.out.println("actualKampanyalarText = " + actualKampanyalarText);
        assertFalse(expectedKampanyalarText.equals(actualKampanyalarText)); //expectedKampanyalarText esit degildir actualKampanyalarText'e

        //assertEquals()
        String expectedTelefonText="Telefon & Aksesuar";
        String actualTelefonText=driver.findElement(By.cssSelector("a[title='Telefon & Aksesuar']")).getText();
        System.out.println("actualTelefonText = " + actualTelefonText);
        assertEquals(expectedTelefonText, actualTelefonText);

    }
}
