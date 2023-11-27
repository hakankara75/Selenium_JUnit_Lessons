package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.*;

public class Selenium_JUnit_11_Ifram_ExtentReport_Test extends TestBase {


    @Test
    public void iframe() {
        /*
        Kullanici herokuapp sitesine gider
        LEFT kelimesinin gorunur oldugunu dogrular
         */
        extentTest.info("Test Basladi");
        //kullanici herokuapp sitesine gider
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        extentTest.info("herokuapp sitesine gidildi");

        //frame gecis yapilir
        driver.switchTo().frame(0);
        extentTest.info("frame e gecis yapildi");

        //left frame e gecti
        WebElement leftFrame= driver.findElement(By.xpath("//frame[@src='/frame_left']"));
        driver.switchTo().frame(leftFrame);

        extentTest.info("left frame e gecis yapildi");

        WebElement leftText= driver.findElement(By.xpath("//body[normalize-space()='LEFT']"));
        assertTrue(leftText.isDisplayed());
        extentTest.info("left kelimesinin gorunur oldugu dogrulandi");
        extentTest.info("Test bitti");

    }

    @Test
    public void iframe2() {
         /*
        Kullanici testkru sitesine gider
        "Parent frame" yazisinin oldugunu dogrular
                "child frame" yazinin gorunur oldugunu dogrular
         */

        extentTest.info("Test Basladi");
        //kullanici testkru sitesine gider
        driver.get("https://testkru.com/Interactions/Frames");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        extentTest.info("testkru sitesine gidildi");

        //parent frame e gecis yapilir
        driver.switchTo().frame(1);
        extentTest.info("parent frame e gecis yapildi");

        //parent textinin oldugu dogrulandi
        String expectedText= "Parent frame";
        String actualText=driver.findElement(By.xpath("//h2[text()='Parent frame']")).getText();
        assertEquals(expectedText, actualText);
        extentTest.info("parent textinin oldugu dogrulandi");

        //child frame e gecis yapilir
        WebElement child = driver.findElement(By.xpath("//iframe[@srcdoc='<h3>Child frame</h3>']"));
        driver.switchTo().frame(child);

        // "child frame" yazinin gorunur oldugunu dogrular
        WebElement childText=driver.findElement(By.xpath("//h3[text()='Child frame']"));
        assertTrue(childText.isDisplayed());
        extentTest.info("child frame yazinin gorunur oldugunu dogrular");
        extentTest.info("Test bitti");
    }
}
