package Topics;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Selenium03_Manage {
    @Test
    public void manage() throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        driver.get("https://www.saucedemo.com/"); //istenen sayfaya gider

        Point expectedPosition = driver.manage().window().getPosition(); //sayfanin konumunu verir

        Point actualPosition = driver.manage().window().getPosition(); //sayfanin konumunu verir
        assertEquals(expectedPosition, actualPosition);

        Dimension expectedSize = driver.manage().window().getSize(); //sayfanin olculerini verir


        Dimension actualSize = driver.manage().window().getSize(); //sayfanin olculerini verir
        assertTrue(expectedSize.equals(actualSize));

        Thread.sleep(2000);
        driver.manage().window().setPosition(new Point(100, 100)); //sayfaya yeni pozisyon verir

        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(400, 500));

        Thread.sleep(2000);
        driver.manage().window().maximize(); //sayfayi en buyuk boyuta getirir


        Thread.sleep(2000);
        driver.manage().window().minimize(); //sayfayi mini buyukluge alir

        Thread.sleep(2000);
        driver.manage().window().fullscreen(); //sayfayi tam ekran yapar

        Thread.sleep(2000);
        driver.close(); //pencereyi kapatir


    }
}
