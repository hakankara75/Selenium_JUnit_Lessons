package Topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.*;

public class Selenium_JUnit_14_Enable_Disable_Elements extends TestBase {

    @Test
    public void isEnableTest() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=jquery-ui-menus");

        WebElement enable=driver.findElement(By.id("ui-id-3"));
        assertTrue(enable.isEnabled());

        WebElement disable=driver.findElement(By.id("ui-id-1"));
        assertTrue(disable.isEnabled());
    }

    @Test
    public void attributeValue() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=jquery-ui-menus");

        String expectedEnableCondition="Enabled";
        String expectedDisableCondition="Disabled";
        WebElement enable=driver.findElement(By.id("ui-id-3"));
        String actualEnabledCondition=enable.getAttribute("text");
        assertEquals(expectedEnableCondition, actualEnabledCondition);

        WebElement disable=driver.findElement(By.id("ui-id-1"));
        String actualDisabledCondition=disable.getAttribute("text");
        assertEquals(expectedDisableCondition, actualDisabledCondition);

    }

    @Test
    public void pointerTest() {
        driver.get("https://testkru.com/Elements/Buttons");
        WebElement enable=driver.findElement(By.cssSelector("#leftClick"));
        moveToElementWithActions(enable);
        isPointerChange(enable);


        WebElement disable=driver.findElement(By.cssSelector("#disabledButton"));
        moveToElementWithActions(disable);
        isPointerChange(disable);

    }
    @Test
    public void isEnableTest2() {
        driver.get("https://testkru.com/Elements/Buttons");
        WebElement enable=driver.findElement(By.cssSelector("#leftClick"));
        assertTrue(enable.isEnabled());

        WebElement disable=driver.findElement(By.cssSelector("#disabledButton"));
        assertFalse(disable.isEnabled());
    }
    @Test
    public void clickTest() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=jquery-ui-menus");

        Boolean expectedBoolean=true;
        WebElement enable=driver.findElement(By.id("ui-id-3"));
        Boolean actualEnableBoolean= isClickable(enable);
        assertEquals(expectedBoolean, actualEnableBoolean);

        driver.navigate().refresh();

        WebElement disable=driver.findElement(By.id("ui-id-1"));
        Boolean actualDisableBoolean= isClickable(disable);
        assertNotEquals(expectedBoolean, actualDisableBoolean);

    }

    public boolean isClickable(WebElement element){
        try {
            element.click();
            System.out.println("Element clickable");
            return true;
        } catch (Exception e){
            System.out.println("Element NOT clickable");
            return false;
        }
    }
    public static void moveToElementWithActions(WebElement element){
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();
        wait(2);
    }
    public void isPointerChange(WebElement element){
        String expectedCursorStyle="pointer";
        String actualCursorStyle=element.getCssValue("cursor");
        System.out.println("actualCursorStyle = " + actualCursorStyle);

        Boolean expectedBoolean=true;
        Boolean actualBoolean=null;

        if(expectedCursorStyle.equals(actualCursorStyle)){
            System.out.println("Element clickable");
            actualBoolean=true;
        }else {
            System.out.println("Element NOT clickable");
            actualBoolean=false;
        }
        assertEquals(expectedBoolean, actualBoolean);
    }
}
