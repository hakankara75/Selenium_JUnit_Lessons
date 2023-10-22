package Topics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_01_Driver_Title_Url_Pagesources_Hash {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com"); //istenen sayfaya gider

        String title= driver.getTitle(); //sayfa title verir
        System.out.println("title = " + title);

        String url=driver.getCurrentUrl(); //sayfa url'ini verir
        System.out.println("url = " + url);

        String pageSources= driver.getPageSource(); //sayfa html kodlarini verir
        System.out.println("pageSources = " + pageSources);

        String handle= driver.getWindowHandle(); //sayfanin hash degerini verir, sayfalar arasi gecis icin kullanilir
        System.out.println("handle = " + handle);
    }
}