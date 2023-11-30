package Topics;

import com.aventstack.extentreports.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Selenium_JUnit_13_Actions_CreateMethods extends TestBase {
    /*
    kullanici "https://www.pazarama.com/" sitesine gider
    karsisina cikan reklami handle eder
    ilk urunun ustune gidince "Sepete Ekle" butonunun aktif oldugunu dogrular
    arama cubuguna "KEDİ kumu" yazarak arama yapar
    kullanici sayfa altindaki pazarama logosunu gorur
    kullanici sayfa basindaki "Bize Ulaşın" linkini tiklar


     */
    @Test
    public void actions() {
        Actions actions=new Actions(driver);

        //kullanici "https://www.pazarama.com/" sitesine gider
        driver.get("https://www.pazarama.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    karsisina cikan reklami handle eder
        WebElement indirim = driver.findElement(By.xpath("(//button[text()='Evet'])[1]"));
        indirim.click();

        WebElement coocies = driver.findElement(By.xpath("//button[@class='btn btn-xs btn-primary !h-auto leading-snug py-1']"));
        coocies.click();

        //ilk urunun ustune gidince "Sepete Ekle" butonunun aktif oldugunu dogrular
        WebElement firstProduct = driver.findElement(By.xpath("(//button[normalize-space()='Sepete Ekle'])[1]"));

        //pencereyi asagi indirdik
        actions.scrollToElement(firstProduct).perform(); //perform() verilen gorevi yapmasini sagliyor
        wait(2);

        //urunun ustune geldik
        actions.moveToElement(firstProduct).perform();
        wait(2);

        assertTrue(firstProduct.isDisplayed());
        assertTrue(firstProduct.isEnabled());

        //arama cubuguna "KEDİ kumu" yazarak arama yapar
        WebElement searchBox= driver.findElement(By.cssSelector("input[placeholder='Marka, ürün veya hizmet ara...']"));
        actions.moveToElement(searchBox).perform();
        wait(2);

        actions.keyDown(searchBox, Keys.SHIFT)//shift butonuna bastim
                .sendKeys("kedim") //kedim kelimesini büyük harfle gönderdim
                .sendKeys(Keys.BACK_SPACE)// m harfini sildim
                .keyUp(Keys.SHIFT)//küçük harfe gectim
                .sendKeys(" kumu", Keys.ENTER)// " kumu" metnini diğerinin yanina ekledim.
                .build() //tum komutlari birlestirdim
                .perform();// emri verdim
        wait(2);

        //kullanici sayfa altindaki pazarama logosunu gorur
        WebElement pazaramaBrand=driver.findElement(By.xpath("(//span[@name='pazarama-isbank-logo'])[2]"));
        actions.scrollToElement(pazaramaBrand).perform();
        assertTrue(pazaramaBrand.isDisplayed());
        tumSayfaScreenShoot();
        wait(2);

        //kullanici sayfa basindaki "Bize Ulaşın" linkini tiklar

        WebElement bizeUlasin=driver.findElement(By.xpath("(//a[@href='/hesabim/musteri-hizmetleri'])[1]"));
        actions.scrollToElement(bizeUlasin).perform();
        webElementScreenShoot(bizeUlasin);
        bizeUlasin.click();

    }

}
