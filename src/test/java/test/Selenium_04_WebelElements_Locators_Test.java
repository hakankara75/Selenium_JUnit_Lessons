package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium_04_WebelElements_Locators_Test {

    @Test
    public void locators() throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        //amazon sitesine gidilir
        driver.get("https://www.amazon.com/"); //istenen sayfaya gider

        Thread.sleep(2000);
        driver.manage().window().maximize();



    }
}
