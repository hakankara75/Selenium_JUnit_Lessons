package test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium03_Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.saucedemo.com/"); //istenen sayfaya gider

        Point position= driver.manage().window().getPosition(); //sayfanin konumunu verir
        System.out.println("position = " + position);

        Dimension size= driver.manage().window().getSize(); //sayfanin olculerini verir
        System.out.println("size = " + size);

        Thread.sleep(2000);
       driver.manage().window().maximize(); //sayfayi mini buyukluge alir

        Thread.sleep(2000);
        driver.manage().window().minimize(); //sayfayi maximum buyukluge alir

        Thread.sleep(2000);
        driver.manage().window().fullscreen(); //sayfayi tam ekran yapar

        Thread.sleep(2000);
        driver.close(); //pencereyi kapatir



    }
}
