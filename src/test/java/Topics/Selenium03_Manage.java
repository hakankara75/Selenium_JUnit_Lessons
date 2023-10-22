package Topics;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.*;

public class Selenium03_Manage {
    @Test
    public void name() throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        driver.get("https://www.saucedemo.com/"); //istenen sayfaya gider

        Point expectedPosition = driver.manage().window().getPosition(); //sayfanin konumunu verir
        Point actualPosition = driver.manage().window().getPosition(); //sayfanin konumunu verir
        assertEquals(expectedPosition, actualPosition);

        Dimension expectedSize = driver.manage().window().getSize(); //sayfanin olculerini verir
        Dimension actualSize = driver.manage().window().getSize(); //sayfanin olculerini verir
        assertTrue(expectedPosition.equals(actualPosition));

        Thread.sleep(2000);
        driver.manage().window().setPosition(new Point(500, 1000)); //sayfaya yeni pozisyon verir

        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(400, 500));

        Thread.sleep(2000);
        driver.manage().window().maximize(); //sayfayi mini buyukluge alir
        driver.manage().window().maximize(); //sayfayi mini buyukluge alir

        Thread.sleep(2000);
        driver.manage().window().minimize(); //sayfayi maximum buyukluge alir

        Thread.sleep(2000);
        driver.manage().window().fullscreen(); //sayfayi tam ekran yapar

        Thread.sleep(2000);
        driver.close(); //pencereyi kapatir


    }
}
