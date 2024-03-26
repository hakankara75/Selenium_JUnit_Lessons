package Topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Selenium_JUnit_14_Disable_Elements extends TestBase {

    @Test
    public void textValu() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=jquery-ui-menus");
        WebElement enable = driver.findElement(By.xpath("//a[@id='ui-id-3']"));
        WebElement disable = driver.findElement(By.xpath("//a[@id='ui-id-1']"));

        String expectedText="Enabled";
        String actualEnableElementText= enable.getAttribute("text");
        System.out.println("actualEnableElementText = " + actualEnableElementText);
        String actualDisableElementText= disable.getAttribute("text");

        assertEquals(expectedText,actualEnableElementText);
        assertEquals(expectedText,actualDisableElementText);

    }

    @Test
    public void pointerTest() {

        driver.get("https://testkru.com/Elements/Buttons");

        WebElement leftClick= driver.findElement(By.xpath("//button[@id='leftClick']"));
        WebElement disabledClick= driver.findElement(By.xpath("//button[@id='disabledButton']"));
        moveToElementWithAction(leftClick);

        isPointerChanged(leftClick);

        moveToElementWithAction(disabledClick);

        isPointerChanged(disabledClick);

    }

    @Test
    public void clickTest() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=jquery-ui-menus");
        WebElement enable = driver.findElement(By.xpath("//a[@id='ui-id-3']"));
        WebElement disable = driver.findElement(By.xpath("//a[@id='ui-id-1']"));

        Boolean expected= true;
        Boolean actualEnabled= isClickable(enable);
        assertEquals(expected, actualEnabled);
        wait(2);
        driver.navigate().refresh();

        Boolean actualDisabled= isClickable(enable);
        assertEquals(expected, actualDisabled);

    }

    public boolean isClickable(WebElement element) {
        try {
            element.click();
            System.out.println("Elemente klik yapma islemi basarili oldu");
            return true;
        }catch (Exception e) {
            System.out.println("Elemente klik yapma islemi BASARISIZ oldu");
            return false;
        }


    }

    public static void moveToElementWithAction(WebElement element){
        Actions action = new Actions(driver);

        try {
            action.moveToElement(element).perform();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void isPointerChanged(WebElement element){
        String expectedCursorStyle="pointer";
        String actualCursorStyle=element.getCssValue("cursor");
        System.out.println("actualCursorStyle = " + actualCursorStyle);

        Boolean expectedBoolean=true;
        Boolean actualBoolean=null;
        if(expectedCursorStyle.equals(actualCursorStyle)){
            System.out.println("Element clickable ve Enable");
            actualBoolean=true;
        }else{
            System.out.println("Element clickable DEĞİL ve DISABLED");
            actualBoolean=false;
        }
        assertEquals(expectedBoolean, actualBoolean);
    }
}
