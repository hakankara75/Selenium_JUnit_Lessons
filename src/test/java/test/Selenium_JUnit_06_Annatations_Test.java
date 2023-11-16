package test;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_JUnit_06_Annatations_Test {
    WebDriver driver;
    @BeforeClass
    public static void beforeClass(){

        System.out.println("Before class calisti");
    }
    @AfterClass
    public static void afterClass(){

        System.out.println("After class calisti");
    }

    @Before
    public void before() throws InterruptedException {

        driver=new ChromeDriver(); //chrome acilacak
        driver.manage().window().maximize(); //chrome penceresi maximum boyuta gelecek
        Thread.sleep(2000);
    }

    @Test
    public void test() throws InterruptedException {
        //kullanici https://www.evidea.com/ sayfasna gidilir
        driver.get("https://www.evidea.com/");
        Thread.sleep(2000);
    }

    @Test
    public void test2() throws InterruptedException {
        //kullanici https://www.teknosa.com/ sayfasina gidilir
        driver.get("https://www.teknosa.com/");
        Thread.sleep(2000);
    }
    @After
    public void tearDown(){

        driver.close();
    }
}
