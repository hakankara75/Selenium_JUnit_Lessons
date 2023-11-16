package Topics;

import org.junit.Ignore;
import org.junit.Test;

public class Selenium_05_JUnit {
    /*
    Test AnatAnnotationlari bizim test yapapilecegimiz
    Testimizin gecip kaldigini gosteren
    Main metoda ihtiyac birakmayan kod bloklaridir
    @Before  ==> Her bir @Test'ten once calisir
    @After   ==> Her bir @Test'ten sonre calisir
    @BeforeClass ==> Her bir classdan once calisir
    @AfterClass  ==> Her bir classdan sonra calisir
    @Ignore    ==> Calismasini istemedigimiz kodlarin kodlarin basina koyulur
    @Test   ==> Test kodlarinin basina koyulur.
    Annotation: Bir veri hakkinda bilgi barindiran meta datalardir.
    Javadaki compiler gibi gorev yapar.
     */
    public static void main(String[] args) {

    }

    @Test
    public void name() {
        System.out.println("Bu test metodudur");
    }
    @Ignore
    public void ignore() {
        System.out.println("Bu test metodudur");
    }
}
