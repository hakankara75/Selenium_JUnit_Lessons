package Topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium04_WebelElements_Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.ebebek.com/"); //istenen sayfaya gider

        Thread.sleep(2000);
        driver.manage().window().maximize();

        WebElement id_SearchBox= driver.findElement(By.id("nav-search-bar-form")); //id

        WebElement xpath_SearchButton= driver.findElement(By.xpath("//input[@value='Go']")); //xpath

        WebElement cssSelector_English= driver.findElement(By.cssSelector("span[class='icp-nav-flag icp-nav-flag-us icp-nav-flag-lop']")); //cssSelector

        WebElement name_SearchBox= driver.findElement(By.name("site-search")); //name

        WebElement className_SearchBox= driver.findElement(By.className("nav-input nav-progressive-attribute")); //className

        WebElement tagName_Header= driver.findElement(By.tagName("header")); //tagName

        WebElement linkText_English= driver.findElement(By.linkText("EN")); //linkText

        WebElement partialLinkText_English= driver.findElement(By.partialLinkText("customer-preferences/edit?ie=UTF8&preferencesReturnUrl=")); //partialLinkText


        //Nosuchelementexeption
    }
}
