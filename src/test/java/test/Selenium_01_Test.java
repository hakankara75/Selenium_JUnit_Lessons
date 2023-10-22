package test;

import com.google.common.annotations.VisibleForTesting;
import dev.failsafe.internal.util.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Selenium_01_Test {
    @Test
    public void name() {


        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com"); //istenen sayfaya gider
        String expectedTitle = "Google";
        String expectedUrl = driver.getCurrentUrl(); //sayfa url'ini verir
        String expectedPageSources = driver.getPageSource(); //sayfa html kodlarini verir
        String expectedHandle = driver.getWindowHandle(); //sayfanin hash degerini verir, sayfalar arasi gecis icin kullanilir


        //sayfaya gittigini dogrular
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();
        String actualPageSources = driver.getPageSource();
        String actualHandle = driver.getWindowHandle();

        assertEquals(expectedTitle,actualTitle);
        assertEquals(expectedUrl,actualUrl);
        assertEquals(expectedPageSources,actualPageSources);
        assertEquals(expectedHandle,actualHandle);






    }

}
