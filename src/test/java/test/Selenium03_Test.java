package test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import javax.swing.text.Position;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Selenium03_Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.saucedemo.com/"); //istenen sayfaya gider

        //sayfanin simdiki konumunu dogrulanir
        Point expectedPosition= driver.manage().window().getPosition(); //sayfanin konumunu verir
        System.out.println("expectedPosition = " + expectedPosition);
        Point actualPosition= driver.manage().window().getPosition(); //sayfanin konumunu verir
        System.out.println("actualPosition ayardan once = " + actualPosition);
        assertEquals(expectedPosition, actualPosition);

        Thread.sleep(2000);
        //sayfanin konumunu degistirilir ardindan degisiklik dogrulanir
        driver.manage().window().setPosition(new Point(500,100)); //sayfaya yeni pozisyon verir
        actualPosition= driver.manage().window().getPosition(); //sayfanin konumunu verir
        System.out.println("actualPosition ayardan sonra= " + actualPosition);
        expectedPosition=new Point(500,100);
        assertEquals(expectedPosition, actualPosition);

        Thread.sleep(2000);
        //sayfanin buyuklugu degistirilir ardindan degisiklik dogrulanir
        driver.manage().window().setSize(new Dimension(600, 200));
        Dimension expectedSize= new Dimension(600, 200);
        System.out.println("expectedSize = " + expectedSize);

        int actualWidth= driver.manage().window().getSize().getWidth();
        System.out.println("actualWidth = " + actualWidth);
        int actualHeight= driver.manage().window().getSize().getHeight();
        System.out.println("actualHeight = " + actualHeight);

        assertEquals(expectedSize.getHeight(), actualHeight );
        assertEquals(expectedSize.getWidth(), actualWidth );


        driver.close(); //pencereyi kapatir



    }
}
