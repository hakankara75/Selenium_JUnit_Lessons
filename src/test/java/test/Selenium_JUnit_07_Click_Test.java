package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Selenium_JUnit_07_Click_Test {
    /*
    kullanici https://www.englishhome.com/ sayfasina gider
    kullanici Yeni Urunler linkini tiklar
    kullanici Ilk sayfaya geri doner
    kullanici Dekorasyon linkini tiklar
    kullanici İlk urunu tiklar
    kullanici Sepete Ekle butonunu tiklar
    kullanici Sepetim linkinini tiklar
    kullanici ekledigi urunun sepette oldugunu dogrular
    kullanici sayfayi kapatir
     */
    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //kullanici https://www.englishhome.com/ sayfasina gider
        driver.get("https://www.englishhome.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //sitedeki elementlerin yuklenmesini en fazla 15 saniye bekleyecek

    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void name() {
        // kullanici Yeni Urunler linkini tiklar
        WebElement yeniUrunler = driver.findElement(By.xpath("//span[text()=' YENİ ÜRÜNLER']"));
        yeniUrunler.click();

        //kullanici Ilk sayfaya geri doner
        driver.navigate().back();

        //    kullanici Dekorasyon linkini tiklar
        WebElement dekorasyon = driver.findElement(By.xpath("//span[text()='DEKORASYON']"));
        dekorasyon.click();

        //    kullanici İlk urunu tiklar
        WebElement ilkUrun = driver.findElement(By.xpath("(//h3[@class='product-name analytics-sub-product-click'])[1]"));
        ilkUrun.click();

        //    kullanici Sepete Ekle butonunu tiklar
        String expectedProduct = driver.findElement(By.xpath("//h1[text()='Floret Cam Dekoratif Tepsi 22x37 Cm Mavi']")).getText();
        WebElement sepeteEkle = driver.findElement(By.cssSelector("a[class='js-add-basket-from-list hero-button add-basket-btn add-basket hidden-xs']"));
        sepeteEkle.click();

        //    kullanici Sepetim linkinini tiklar
        WebElement sepetim = driver.findElement(By.cssSelector("i[class='icon-shopping-cart']"));
        sepetim.click();

        //    kullanici ekledigi urunun sepette oldugunu dogrular
        String actualProduct = driver.findElement(By.xpath("//h5[text()='Floret Cam Dekoratif Tepsi 22x37 Cm Mavi']")).getText();
        assertEquals(expectedProduct, actualProduct);


    }
}
