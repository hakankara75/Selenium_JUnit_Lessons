package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium_04_WebelElements_Locators_Test {

    @Test
    public void name() throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        //amazon sitesine gidilir
        driver.get("https://www.amazon.com/"); //istenen sayfaya gider

        Thread.sleep(2000);
        driver.manage().window().maximize();

        //arama kutusunun locate'i alinir
        WebElement id_SearchBox= driver.findElement(By.id("twotabsearchtextbox")); //id


        WebElement xpath_SearchButton= driver.findElement(By.xpath("//input[@value='Go']")); //xpath

        WebElement cssSelector_English= driver.findElement(By.cssSelector("span[class='icp-nav-flag icp-nav-flag-us icp-nav-flag-lop']")); //cssSelector

        WebElement name_SearchBox= driver.findElement(By.name("site-search")); //name

        WebElement className_SearchBox= driver.findElement(By.className("nav-progressive-attribute")); //className

        WebElement tagName_Header= driver.findElement(By.tagName("header")); //tagName

        WebElement linkText_English= driver.findElement(By.linkText("EN")); //linkText

        WebElement partialLinkText_English= driver.findElement(By.partialLinkText("Hello, sign in")); //partialLinkText

    }
}
