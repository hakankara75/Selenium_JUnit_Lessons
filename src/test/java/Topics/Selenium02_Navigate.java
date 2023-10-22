package Topics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium02_Navigate {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://parabank.parasoft.com/parabank/index.htm"); //1. sayfa

        driver.navigate().to("https://demo.applitools.com/"); //2. sayfa. yukaridaki sayfadan sonra bu sayfaya gitme komutu

        Thread.sleep(2000); //2 sayfa arasinda gecisleri gormek icin bekleme kodu. Normalde olmaz. Gozle gormek icin koyduk. HARD WAIT
        driver.navigate().back(); // 1. sayfaya donme, geri donme komutu

        Thread.sleep(2000); //HARD WAIT
        driver.navigate().forward(); //2. sayfaya gitme, ileri git komutu

        Thread.sleep(2000); //HARD WAIT
        driver.navigate().refresh(); //sayfayi yeniler.

        driver.close(); //acik sayfayi kapatir
    }
}
