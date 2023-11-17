package Topics;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_JUnit_07_Click {
    WebDriver driver;
    @Before
    public void  setUp(){
        //kullanici "https:///www.decathlon.com.tr/" sitesine gider
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.decathlon.com.tr/"); //istenen sayfaya gider

    }

    @After
    public void  tearDown(){
        driver.close();
    }

    @Test
    public void test() {
        //kullanici bize ulasin linkine tiklar
    WebElement bizeUlasin= driver.findElement(By.xpath("(//a[@class='vtmn-navbar_link'])[1]"));
    bizeUlasin.click();

    //kullanici bir onceki sayfaya geri doner
    driver.navigate().back();

        //kullanici magaza linkine tiklar
    WebElement magazaBul= driver.findElement(By.xpath("(//span[@class='vtmn-truncate vtmn-hidden gt-small-desktop:vtmn-block svelte-1repvcj'])[2]"));
    magazaBul.click();

//kullanici bir onceki sayfaya geri doner
           driver.navigate().back();

           //kullnici hesabim linkini tiklar
        WebElement hesabim=driver.findElement(By.xpath("(//a[@class='vtmn-navbar_link'])[3]"));
        hesabim.click();

        //kullanici bir onceki sayfaya geri doner
        driver.navigate().back();

        //kullanici sepetim linkini tiklar
        WebElement sepetim= driver.findElement(By.xpath("//span[@class='vtmx-shopping-cart-line vtmn-icon-size svelte-17fg7l5']"));
        sepetim.click();
    }
}
