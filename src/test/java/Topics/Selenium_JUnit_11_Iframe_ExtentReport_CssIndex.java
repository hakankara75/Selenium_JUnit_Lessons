package Topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.*;

public class Selenium_JUnit_11_Iframe_ExtentReport_CssIndex extends TestBase {
    /*
EXTENTREPORT kullanabilmemiz icin;
1-pom.xml dosyasina extentreport dependency'si eklenir
2-ExtentReport class'indan bir obje olusturulur
3-HTML formatinda duzenlenecegi icin ExtentHtmlReporter class'indan obje olusturulur.
4-Rapora test ile ilgili bilgiler girebilmek icin ExtentTest class'indan bir obje olusturulur
*/

    @Test
    public void iframe() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        extentTest.info("Herokuapp sayfasina gidildi");

        WebElement format= driver.findElement(By.cssSelector("button[aria-haspopup='true']:nth-child(4)"));
        assertTrue(format.isDisplayed());
        extentTest.info("format butonunun goruldugu dogrulandi");
        format.click();
        extentTest.info("format butonu kliklendi");

        WebElement bold= driver.findElement(By.xpath("//div[text()='Bold']"));
        bold.click();
        extentTest.info("bold butonu kliklendi");


        /*
        iframe handel etme yontemleri
        1- locate alip locate ile gecis yapilir
        2- index verilerek gecis yapilir
         */

        WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        extentTest.info("iframe e gecis yapidi");

        WebElement textBox= driver.findElement(By.id("tinymce"));
        textBox.clear(); //textbox icindeki metin silinir
        textBox.sendKeys("Bu yazıyı Hakan yazdı. İmza Abdullah.");
        extentTest.info("textbox icine metin gonderildi");

        driver.switchTo().parentFrame();
        extentTest.info("ana sayfaya donuldu");

        WebElement seleniumElement= driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        assertTrue(seleniumElement.isEnabled());
        extentTest.info("selenium yazisinin aktif oldugu dogrulandi");
        Thread.sleep(2000);
    }
}
