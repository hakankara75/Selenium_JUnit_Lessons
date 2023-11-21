package Topics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.*;

public class Selenium_JUnit_09_CheckBox_RadioButton {

    WebDriver driver;

    @Before
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        //kullanici Rubywatir sitesine gider
        driver.get("http://test.rubywatir.com/checkboxes.php");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void name() throws InterruptedException {
        WebElement soccer = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        assertTrue(soccer.isSelected());

        WebElement football = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        assertFalse(football.isSelected());

        if(!soccer.isSelected()) {
            Thread.sleep(2000);
            soccer.click();
        }

        if(!football.isSelected()) {
            Thread.sleep(2000);
            football.click();
        }

        //Radio Button
        driver.get("http://test.rubywatir.com/radios.php");

        WebElement radio1= driver.findElement(By.cssSelector("input[checked='checked']"));
        if(!radio1.isSelected()){
            Thread.sleep(2000);
            radio1.click();
        }

        WebElement radio2= driver.findElement(By.cssSelector("input[value='Nope']"));
        if(!radio2.isSelected()){
            Thread.sleep(2000);
            radio2.click();
        }
    }
}
