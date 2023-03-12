package Day04_JUnitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C04_BeforAfterClass {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void teardown() {
        driver.close();
        System.out.println("Teardown calisti");

    }

    @Test
    public void Test01() {

        driver.get("https://amazon.com");
        String expectedIcerik = "Amazon";
        String actualIcerik = driver.getCurrentUrl();

        if (actualIcerik.contains(expectedIcerik)) {
            System.out.println("url amazon icererir Test PASSED");
        } else
            System.out.println("url amazon icermez Test FAILED");

        driver.close();
    }

    @Test
    public void Test02() {
        // Nutella aratip arama sonuclarinda nutella icerdigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        WebElement aramaSonucElementi = driver.findElement(By.xpath("//h1[@class=‘a-size-base s-desktop-toolbar a-text-normal’]"));
        String expectedSonuc = "nutella";
        String actualSonuc = aramaSonucElementi.getText();

    }

}
