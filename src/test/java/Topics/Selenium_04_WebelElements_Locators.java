package Topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium_04_WebelElements_Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();

        driver.get("https://tr.aliexpress.com/"); //istenen sayfaya gider

        Thread.sleep(2000);
        driver.manage().window().maximize();

        WebElement id_SearchBox= driver.findElement(By.id("search-words")); //id

        WebElement xpath_Bildirim_Izin_Ver= driver.findElement(By.xpath("//div[@class=' _1-SOk']")); //xpath

        WebElement cssSelector_Alibaba_Uygulama_Indir= driver.findElement(By.cssSelector("b[class='down-load-app--longStr--1OJgHfl")); //cssSelector

        //http://www.automationpractice.pl/index.php sitesine git
        driver.navigate().to("http://www.automationpractice.pl/index.php");
        WebElement name_SearchBox= driver.findElement(By.name("search_query")); //name

        WebElement className_SearchBox= driver.findElement(By.className("search_query")); //className

        WebElement tagName_Header= driver.findElement(By.tagName("header")); //tagName

        WebElement linkText_Contact_Us= driver.findElement(By.linkText("Contact us")); //linkText
        Thread.sleep(3000);

        driver.navigate().to("https://amazon.com");

        Thread.sleep(3000);
        WebElement partialLinkText_Today_Deals= driver.findElement(By.partialLinkText("Today's Deals")); //partialLinkText href attribute uzerinde kullanilir
        Thread.sleep(2000);
        driver.close();
    }
}
