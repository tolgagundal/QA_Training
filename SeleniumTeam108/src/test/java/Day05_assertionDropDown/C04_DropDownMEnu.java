package Day05_assertionDropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;

public class C04_DropDownMEnu {
    //● https://www.amazon.com/ adresine gidin.
    //- Test 1
    //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    //-Test 2
    //  1. Kategori menusunden Books secenegini  secin
    //  2. Arama kutusuna Java yazin ve aratin
    //  3. Bulunan sonuc sayisini yazdirin
    //  4. Sonucun Java kelimesini icerdigini test edin

    static WebDriver driver;

    @AfterClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    public void test01() {
        //  1- Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select = new Select(ddm);

        int expectedOptions = 45;
        int actualOptions = select.getOptions().size();

        Assert.assertEquals(expectedOptions,actualOptions);
    }

    @Test
    public void test02() {

        //  1. Kategori menusunden Books secenegini  secin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Books");

        //  2. Arama kutusuna Java yazin ve aratin


        //  3. Bulunan sonuc sayisini yazdirin
        //  4. Sonucun Java kelimesini icerdigini test edin
    }



}
