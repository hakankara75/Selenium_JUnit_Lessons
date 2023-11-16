package Topics;

import org.junit.Ignore;
import org.junit.Test;

public class Selenium_05_Junit {
    @Test
    public void name() {
        System.out.println("Bu bir test metodudur");
    }
/*
    main ==> Java'da kod koşturabileceğimiz yapı
    Annotations:
    @Before ==> her bir @Test'ten once calistirir
    @After  ==> her bir @Test'ten sonra calistirir
    @BeforeClass ==> her bir class'dan once calistirir
    @AfterClass ==> her bir class'dan sonra calistirir
    @Ignore  ==> kosturmak istemedigimiz @Test'lerin basina koyulur
    @Test  ==> otomasyon testi yapmamizi saglayan kodlardir.
     Annotations: Bir veri hakkinda bilgi barindirir bir yapidir. Buna metadata denebilir.
     Java'da compiler gibi bu Annotations da gorev yapar.
     */
}
