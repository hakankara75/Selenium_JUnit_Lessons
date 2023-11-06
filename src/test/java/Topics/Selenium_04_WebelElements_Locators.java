package Topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium_04_WebelElements_Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();

        driver.get("https://tr.aliexpress.com/"); //istenen sayfaya gider
        driver.manage().window().maximize();

        WebElement izinVer= driver.findElement(By.xpath("//div[@class=' _1-SOk']")); //xpath
        izinVer.click();

        WebElement searchBox= driver.findElement(By.id("search-words")); //id

        WebElement alibabaUygulamaIndir= driver.findElement(By.cssSelector("b[class='down-load-app--longStr--1OJgHfl']")); //css

        Thread.sleep(2000);

        //http://www.automationpractice.pl/index.php sitesine git
        driver.navigate().to("http://www.automationpractice.pl/index.php");

        WebElement name_SearchBox= driver.findElement(By.name("search_query")); //name

        WebElement class_SearchBox= driver.findElement(By.className("search_query")); //class

        WebElement tagName_Header=driver.findElement(By.tagName("header"));

        WebElement linkText_ContactUs= driver.findElement(By.linkText("Contact us")); //linkText

        Thread.sleep(3000);

        driver.navigate().to("https://amazon.com");

        WebElement partialLinkText_TodaysDeals= driver.findElement(By.partialLinkText("Today's Deals")); //partialLinkText

        Thread.sleep(2000);
        driver.close();




    }
}
