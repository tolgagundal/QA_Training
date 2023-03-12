package Day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_cssSelector {
    public static void main(String[] args) {

        // 1- bir class olusturun
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2- https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com");
        // 3- Browseri tam sayfa yapin
        // 4- Sayfayi “refresh” yapin
        // 5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedIcerik = "Spent less";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedIcerik)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }


        // 6- Gift Cards sekmesine basin (Bas dedigi icin locate etmeye gerek yok!)
        driver.findElement(By.cssSelector("a[data-csa-c-content-id='nav_cs_gc']")).click();

        // 7- Birthday butonuna basin
        driver.findElement(By.cssSelector("\"//a[@aria-label='Birthday']\"")).click();

        // 8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("\"//a[@aria-label='Birthday']\"")).click();

        // 9- Gift card details’den 25 $’i secin
        driver.findElement(By.cssSelector("#id=\"gc-mini-picker-amount-1\"")).click();

        // 10-Urun ucretinin 25$ oldugunu test edin
        WebElement ucretElementi = driver.findElement(By.cssSelector("#gc-live-preview-amount"));

        String expectedPrice = "25";
        String actualPrice = ucretElementi.getText();

        if (expectedPrice.equals(actualPrice)) {
            System.out.println("Price Test PASSED");
        } else {
            System.out.println("Price Test FAILED");
        }

        // 11-Sayfayi kapatin
        driver.close();





    }
}
