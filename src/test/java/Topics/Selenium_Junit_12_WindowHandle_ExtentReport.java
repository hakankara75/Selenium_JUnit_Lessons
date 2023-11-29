package Topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Selenium_Junit_12_WindowHandle_ExtentReport extends TestBase {

    @Test
    public void windowHandle() throws InterruptedException {

        extentTest.info("Test Basladi");
        //kullanici demoqa sitesine gider
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        extentTest.info("kullanici demoqa sitesine gitti");

        //sayfa handle alinir
        String mainPageHandel= driver.getWindowHandle();

        //kullanici New Tab butonuna basar
        WebElement newButton= driver.findElement(By.id("tabButton"));
        newButton.click();
        extentTest.info("kullanici New Tab butonuna basti");

        //yeni pencereye gecis islemi icin butun pencerelerin handle degerleri alindi
        Set<String> windowHandles= driver.getWindowHandles();
        for (String handle: windowHandles){
            if(!handle.equals(mainPageHandel)){
                driver.switchTo().window(handle);
                Thread.sleep(2000);
            }
        }
        extentTest.info("kullanici yeni acilan pencereye gecis yapti");

        //kullanici "This is a sample page" metninin gorundugunu dogrular
        WebElement text= driver.findElement(By.id("sampleHeading"));
        assertTrue(text.isDisplayed());
        String expectedText= "This is a sample page";
        String actualText= text.getText();
        assertEquals(expectedText, actualText);
        extentTest.info("kullanici 'This is a sample page' metninin gorundugunu dogruladi");

        //kullanici ilk pencereye gecer
        driver.switchTo().window(mainPageHandel);
        Thread.sleep(2000);
        extentTest.info("kullanici ilk pencereye gecti");
        extentTest.info("Test Bitti");


    }
}
