package Topics;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.time.Duration;

public class Selenium03_Manage_02 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.trendyol.com/"); //istenen sayfaya gider

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //implicitlyWait bir ögenin yuklenmesini bekler
        driver.manage().deleteAllCookies(); //browser daki tum cerezleri siler

        Thread.sleep(2000);
        Cookie cookie = new Cookie("cookieName", "Bazi cookieler iyidir, bazilari kotudur");
        driver.manage().addCookie(cookie); //cookie ekler

        Thread.sleep(2000);
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry : logs) {
            System.out.println("Log: "+logEntry.getMessage());
        }
        String cookieName= String.valueOf(driver.manage().getCookieNamed("cookieName"));
        System.out.println("cookieName = " + cookieName);

        driver.quit();
    }
}
