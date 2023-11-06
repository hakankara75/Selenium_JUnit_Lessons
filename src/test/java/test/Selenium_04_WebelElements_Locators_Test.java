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

        WebElement id_SearchBox= driver.findElement(By.id("twotabsearchtextbox"));
        id_SearchBox.click();

        WebElement xpath_SearchBox= driver.findElement(By.xpath("//input[@placeholder='Search Amazon']"));

        WebElement cssSelector_English= driver.findElement(By.cssSelector("span[class='icp-nav-link-inner']"));

        WebElement name_SearchBox= driver.findElement(By.name("field-keywords"));

        WebElement className_SearchBox=driver.findElement(By.className("nav-progressive-attribute"));

        WebElement tagName_Header= driver.findElement(By.tagName("header"));

        WebElement linkText_English= driver.findElement(By.linkText("EN"));
        linkText_English.click();

        WebElement partialLinkText_English=driver.findElement(By.partialLinkText("Hello, sign in"));
        Thread.sleep(2000);

        driver.close();
    }
}
