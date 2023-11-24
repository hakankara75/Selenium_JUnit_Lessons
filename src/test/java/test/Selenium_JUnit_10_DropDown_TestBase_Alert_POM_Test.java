package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Selenium_JUnit_10_DropDown_TestBase_Alert_POM_Test extends TestBase {

    @Test
    public void alert() {
        driver.get("https://letcode.in/waits");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement simpleAlert=driver.findElement(By.id("accept"));
        simpleAlert.click();

        //tek bir elementi beklemek icin
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(7));
//        wait.until(ExpectedConditions.alertIsPresent());
        alertWait(7);

        driver.switchTo().alert().accept();
        TestBase.wait(2);

    }

    @Test
    public void dropDown() {

        //kullanici "https://demo.automationtesting.in/Register.html" sitesine gider
        driver.get("https://demo.automationtesting.in/Register.html");

        //skills dropdowndan indexe gore secim yapar
        WebElement skills= driver.findElement(By.cssSelector("select[id='Skills']"));

        Select select= new Select(skills);
        select.selectByIndex(1);
        TestBase.wait(2);

        select.selectByValue("Analytics");
        TestBase.wait(2);

        //sayfayi element gorunene kadar asagi kaydirir (scroll)
        WebElement secondPass= driver.findElement(By.id("secondpassword"));
        Actions actions=new Actions(driver);
        actions.scrollToElement(secondPass).perform();
        TestBase.wait(2);

        //date of birth den value gore secim yapar
        WebElement year=driver.findElement(By.id("yearbox"));
        select=new Select(year);
        select.selectByValue("1920");
        TestBase.wait(2);

        //month den visible text gore secim yapar
        WebElement month=driver.findElement(By.cssSelector("select[placeholder='Month']"));
        select=new Select(month);
        select.selectByVisibleText("April");
        TestBase.wait(2);

        //day den index e gore secim yapar
        WebElement day=driver.findElement(By.id("daybox"));
        select=new Select(day);
        select.selectByIndex(5);
        TestBase.wait(2);
    }
}
