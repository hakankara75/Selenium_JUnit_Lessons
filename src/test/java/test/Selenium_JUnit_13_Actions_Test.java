package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Selenium_JUnit_13_Actions_Test extends TestBase {
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
        Actions actions=new Actions(driver);
//        kullanici "https://www.migros.com.tr/" sitesine gider
        driver.get("https://www.migros.com.tr/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


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

    @Test
    public void contextClick() {
        Actions actions=new Actions(driver);
                /*
          kullanici "https://the-internet.herokuapp.com/context_menu" sitesine gider
          kullanici sayfadaki kutuya sag klik yapar
         kullanici acilan alerti kapatir
         */

        //kullanici "https://the-internet.herokuapp.com/context_menu" sitesine gider
    driver.get("https://the-internet.herokuapp.com/context_menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //  kullanici sayfadaki kutuya sag klik yapar
        WebElement rectangle=driver.findElement(By.id("hot-spot"));
        actions.contextClick(rectangle).perform();
        wait(2);

        //kullanici acilan alerti kapatir
        driver.switchTo().alert().accept();

    }

    @Test
    public void moveToElement() {
        /*
         kullanici "https://www.etstur.com/" sitesine gider
         kullanici sayfadaki otel linkinin ustunde bekler
 */
        Actions actions=new Actions(driver);

        //kullanici "https://www.etstur.com/" sitesine gider
        driver.get("https://www.etstur.com/");

        //kullanici sayfadaki otel linkinin ustunde bekler
        WebElement otel=driver.findElement(By.xpath("(//a[@href='javascript:;'])[1]"));
        actions.moveToElement(otel).perform();
        wait(2);
    }

    @Test
    public void dragDrop() {
        /*
        // kullanici "https://jqueryui.com/droppable/" sitesine gider
        // kullanici drag nesnesini drop ustune goturur
 */

        Actions actions=new Actions(driver);

        // kullanici "https://jqueryui.com/droppable/" sitesine gider
        driver.get("https://jqueryui.com/droppable/");

//        WebElement frame=driver.findElement(By.cssSelector("iframe[class='demo-frame']"));
//        driver.switchTo().frame(frame);
        driver.switchTo().frame(0);

        // kullanici drag nesnesini drop ustune goturur
        WebElement drag= driver.findElement(By.id("draggable"));
        WebElement drop= driver.findElement(By.id("droppable"));

        actions.dragAndDrop(drag,drop).perform();

    }
}
