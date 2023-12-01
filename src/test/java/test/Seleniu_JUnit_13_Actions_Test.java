package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Seleniu_JUnit_13_Actions_Test extends TestBase {
        /*
            kullanici "https://www.migros.com.tr/" sitesine gider
            kullanici coocies kabul eder
            kullanici uyariyi kabul eder
            kullanici sayfa altindaki migros logosunu gorur
            kullanici searchBox'in gorundugunu dogrular
            kullanici searchBox'a tiklar
            kullanici searchBox'a "RİZE ÇAYIVVV" yazar ardindan duzeltip arama yapar
            kullanici"RİZE ÇAYI" yazan urunlerin goruntulendigini dogrular
     */

    @Test
    public void actions() {
//        kullanici "https://www.migros.com.tr/" sitesine gider
        driver.get("https://www.migros.com.tr/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        Actions actions=new Actions(driver);
//        kullanici coocies kabul eder
        WebElement cookies= driver.findElement(By.id("accept-all"));
        cookies.click();

        //        kullanici uyariyi kabul eder
        WebElement uyari= driver.findElement(By.xpath("(//fa-icon[@class='ng-fa-icon'])[1]"));
        uyari.click();
        wait(2);

        WebElement siparis= driver.findElement(By.cssSelector("fa-icon[class='ng-fa-icon text-color-grey close-button']"));
        if (siparis.isDisplayed()) {
            siparis.click();
            wait(2);
        }



//        kullanici sayfa altindaki migros logosunu gorur
        WebElement logo= driver.findElement(By.cssSelector("img[alt='migros-logo']"));
        actions.scrollToElement(logo).perform();
        assertTrue(logo.isDisplayed());
        wait(2);

//        kullanici searchBox'in gorundugunu dogrular
        WebElement searchBox= driver.findElement(By.id("product-search-combobox--trigger"));
        actions.scrollToElement(searchBox).perform();
        assertTrue(searchBox.isDisplayed());

//        kullanici searchBox'a tiklar
        searchBox.click();
        wait(2);

//        kullanici searchBox'a "RİZE ÇAYIVVV" yazar ardindan duzeltip arama yapar
        actions.keyDown(searchBox, Keys.SHIFT)
                .sendKeys("RİZE ÇAYIVVV")
                .sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE)
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        wait(2);

//        kullanici"RİZE ÇAYI" yazan urunlerin goruntulendigini dogrular
        WebElement urun= driver.findElement(By.xpath("(//a[@id='product-name'])[1]"));
        String expectedText1= "Rize";
        String expectedText2= "Çay";
        String actualText= urun.getText();
        assertTrue(actualText.contains(expectedText1) && actualText.contains(expectedText2));

    }


}
