package Topics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import static org.junit.Assert.*;

public class Selenium_JUnit_08_Assertions {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        //Kullanici Youtube sitesine gider
        driver.get("https://www.youtube.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        // driver.close();
    }

    @Test
    public void assertions() throws InterruptedException {
        //assertTrue ==> Dogru mu?
        WebElement youtubeIcon = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        assertTrue(youtubeIcon.isDisplayed());

        //assertTrue ==> Dogru mu?
        WebElement tumu = driver.findElement(By.cssSelector("yt-chip-cloud-chip-renderer[class='style-scope ytd-feed-filter-chip-bar-renderer iron-selected']"));
        assertTrue(tumu.isEnabled()); //kullanilabilir mi - aktif mi?

        //isSelected ==> secili mi?
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        Thread.sleep(2000);
        WebElement checkbox= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        assertFalse(checkbox.isSelected());
        checkbox.click(); //checkbox sec
        Thread.sleep(2000);
        assertTrue(checkbox.isSelected());

        //assertFalse ==> Yanlis mi?
        driver.navigate().back();
        String expectedTitle = "Burası YouTube Ana Sayfasıdır";
        String actualTitle= driver.getTitle(); //YouTube
        assertFalse(expectedTitle.equals(actualTitle));

        //assertEquals(); ==> esit mi?
        expectedTitle= "YouTube"; //yukaridaki variable icini degistirdim, yeni deger atadim
        actualTitle=driver.getTitle();
        assertEquals(expectedTitle, actualTitle);

    }
}