package Day04_JUnitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class C01_TestNotasyonu {

    // JUnit Framework'u en temel test framework'udur.
    // En onemli ozelligi Test Annotaiton (Notasyon)'dur.
    // Test notasyonu sayesinde her bir method bagimsiz bir sekilde calistirilabilir.


    @Test
    public void test01() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");
        driver.close();
    }
    @Test
    public void test02() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://youtube.com");
        driver.close();
    }

}
