package Topics;

import org.junit.*;

public class Selenium_JUnit_06_Annotations {
    //1. Test Method

    @Test
    public void test() {
        System.out.println("Merhaba JUnit severler. Test basladi.");


    }
    //2. Before Method
    @Before
    public void before() {
        System.out.println("Bir  @Test metoduna baslamadan once burasi calisir.");
    }

    //3. After Method
    @After
    public void after() {
        System.out.println("Bir  @Test metodundan sonra burasi calisir.");
    }

    //4. Before Class
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Bu Classtaki methodlardan once calisti. Basliyoruz.");
    }

    //5. After Class
    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Bu Classtaki methodlardan sonra calisti. Kapatiyoruz.");
    }
    //6. Ignore
    @Ignore
    public static void calismayacakTest(){
        System.out.println("Bu test calismayacak");
    }
}
