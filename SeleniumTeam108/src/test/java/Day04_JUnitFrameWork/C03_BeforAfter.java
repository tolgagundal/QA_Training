package Day04_JUnitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforAfter {
    WebDriver driver;

    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void teardown() {
        driver.close();
        System.out.println("teardown calisti");
    }

    @Test
    public void test01() {
        driver.get("https://amazon.com");
        driver.close();
    }

    @Test
    public void test02() {
        driver.get("https://youtube.com");
        driver.close();


    }


}