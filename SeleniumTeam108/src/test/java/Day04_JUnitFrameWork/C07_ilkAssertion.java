package Day04_JUnitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_ilkAssertion {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://bestbuy.com");

    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    public void Test01() {

        String expectedUrl = "https://bestbuy.com";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Beklenen eslesme olmadi",expectedUrl,actualUrl);

    }

    @Test
    public void Test02() {
        //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test

        String expectedIcerik = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedIcerik));

    }

    @Test
    public void test03(){
        //      ○ logoTest => BestBuy logosunun görüntülendigini test edin

        WebElement logoElementi= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
    @Test
    public void test04(){
        //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement fransizcaLinki= driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(fransizcaLinki.isDisplayed());
    }
}




