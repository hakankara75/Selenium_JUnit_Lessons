package test;

import com.google.common.annotations.VisibleForTesting;
import dev.failsafe.internal.util.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Selenium_01_Test {
    @Test
    public void name() {


        WebDriver driver = new ChromeDriver();

        driver.get("https://www.tesbihkonagi.com/"); //istenen sayfaya gider
        String expectedTitle = "TESBİH KONAĞI";
        String expectedUrl = "https://www.tesbihkonagi.com/";
        System.out.println("expectedUrl = " + expectedUrl);
        String expectedPageSources = driver.getPageSource();
        System.out.println("expectedPageSources = " + expectedPageSources);
        String expectedHandle = "F5C84A123D049878F9E4DEC109EE4A3A";
        System.out.println("expectedHandle = " + expectedHandle);


        //sayfaya gittigini dogrular
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl(); //sayfa url'ini verir
        String actualPageSources = driver.getPageSource(); //sayfa html kodlarini verir
        String actualHandle = driver.getWindowHandle(); //sayfanin hash degerini verir, sayfalar arasi gecis icin kullanilir


        assertEquals(expectedTitle,actualTitle);
        assertEquals(expectedUrl,actualUrl);
        assertTrue(actualPageSources.contains("<meta property=\"og:site_name\" content=\"TESBİH KONAĞI \">"));


    }

}
