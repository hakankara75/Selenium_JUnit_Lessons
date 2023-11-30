package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Selenium_JUnit_12_WindowHandle_Test extends TestBase {
    /*
Kullanici demoqa sitesine gider "https://demoqa.com/browser-windows"
kullanici sayfa handle alir
kullanici  New Tab butonuna basar, yeni pencereye gecer
kullanici "This is a sample page" textini gordugunu dogrular
kullanici ilk pencereye doner
kullanici New Window butonuna basar, yeni pencereye gecer ve handle degerini yazidir
kullanici ilk pencereye doner
kullanici New Window Message butonuna basar
kullanici yeni acilan pencereye gecer ve handle degerini yazidir
kullanici ana pencereye gecer ve ana pencerede oldugunu dogrular
 */

    @Test
    public void windowHandle() throws InterruptedException {
        //Kullanici demoqa sitesine gider
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //kullanici sayfa handle alir
        String windowHandle1 = driver.getWindowHandle();
        wait(2);

        //kullanici  New Tab butonuna basar, yeni pencereye gecer
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();

        Set<String> windowHandles = driver.getWindowHandles();

        String windowHandle2 = "";
        for (String str : windowHandles) {
            if (!str.equals(windowHandle1)) {
                driver.switchTo().window(str); //2. pencereye gecti
                windowHandle2 = driver.getWindowHandle(); //2. pencerenin handle degerini aldi
            }

        }
        wait(2);

        //kullanici "This is a sample page" textini gordugunu dogrular
        String expextedSamplePageText = "This is a sample page";
        String actualSamplePageText = driver.findElement(By.id("sampleHeading")).getText();
        assertEquals(expextedSamplePageText, actualSamplePageText);

        //kullanici ilk pencereye doner
        driver.switchTo().window(windowHandle1);

        //kullanici New Window butonuna basar, yeni pencereye gecer ve handle degerini yazidir
        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        newWindowButton.click();

        windowHandles = driver.getWindowHandles(); //3 pencere oldugu icin yeniden windowHandles degiskenine pencere handlelarını atadim.
        String windowHandle3 = "";
        for (String str : windowHandles) {
            if (!str.equals(windowHandle1) || !str.equals(windowHandle2)) {
                driver.switchTo().window(str); //3. pencereye gecti
                windowHandle3 = driver.getWindowHandle(); //3. pencerenin handle degerini aldi
                System.out.println("windowHandle3 = " + windowHandle3);
            }

        }
        wait(2);

        //kullanici ilk pencereye doner
        driver.switchTo().window(windowHandle1);

//        kullanici New Window Message butonuna basar
        WebElement newMessageButton = driver.findElement(By.id("messageWindowButton"));
        newMessageButton.click();

//        kullanici yeni acilan pencereye gecer ve handle degerini yazidir
        windowHandles = driver.getWindowHandles(); //4 pencere oldugu icin yeniden windowHandles degiskenine pencere handlelarını atadim.
        String windowHandle4 = "";
        for (String str : windowHandles) {
            if (!str.equals(windowHandle1) || !str.equals(windowHandle2) || !str.equals(windowHandle3)) {
                driver.switchTo().window(str); //4. pencereye gecti
                windowHandle4 = driver.getWindowHandle(); //4. pencerenin handle degerini aldi
                System.out.println("windowHandle4 = " + windowHandle4);
            }

        }
        wait(2);


//        kullanici ana pencereye gecer ve ana pencerede oldugunu dogrular
        driver.switchTo().window(windowHandle1);

        String expectedUrl = "https://demoqa.com/browser-windows";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);

    }

    @Test
    public void windowHandle2() throws InterruptedException {
        extentTest.info("Test Basladi");
        //Kullanici demoqa sitesine gider
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        extentTest.info("Kullanici demoqa sitesine gitti");

        //kullanici sayfa handle alir
        String windowHandle1 = driver.getWindowHandle();
        wait(2);
        extentTest.info("kullanici sayfa handle aldi");

        //kullanici  New Tab butonuna basar, yeni pencereye gecer
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();
        extentTest.info("kullanici  New Tab butonuna basti, yeni pencereye gecti");

        switchToWindow(1); //yeni acilan pencereye gecis yaptik

        String windowHandle2 = driver.getWindowHandle();
        assertFalse(windowHandle1.equals(windowHandle2));
        extentTest.info("kullanici yeni acilan pencereye gectigini dogruladi");
        extentTest.info("Test bitti");
    }
}