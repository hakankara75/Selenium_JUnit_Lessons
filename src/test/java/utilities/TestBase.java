package utilities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class TestBase {

    protected static WebDriver driver;
    @Before
    public void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();


    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    public static void wait(int seconds) {

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * bu metot ile bir alert gorunene kadar kodlar bekletilir
     * @param saniye yerine beklenicek sure int degeri olarak atanmali
     */
    public static void alertWait(int saniye) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * alertten gelen texti dogrulamak icin kullanilir
     * @param str expected metindir
     * @param atr actual metindir
     */
    public static void assertTextContainsAssertTrue(String str, String atr){
        assertTrue(str.contains(atr));
        //assertEquals(str,atr);
    }

    /**
     * alerte text gondermek icin kullanilir
     * @param str alertin icine gonderilecek metindir
     */
    public static void sendKeyToAlert(String str){
        driver.switchTo().alert().sendKeys(str);

    }

    /**
     * alerti kabul edecek metot
     */
    public static void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    /**
     * alerti reddedecek edecek metot
     */
    public static void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
}
