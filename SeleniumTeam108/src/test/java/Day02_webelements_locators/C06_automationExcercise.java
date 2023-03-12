package Day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_automationExcercise {
    public static void main(String[] args) throws InterruptedException {


       // 1- Bir test class'i olusturun, ilgili ayarlari yapin

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- https://automationexercise.com/ adresine git
        driver.get("https://automationexercise.com/");

        // 3- Sayfada 147 adet link bulundugunu test et.
        List<WebElement> linkElementleriList = driver.findElements(By.tagName("a"));

        int expectedLinkSayisi = 147;
        int actualLinkSayisi = linkElementleriList.size();

        if ((expectedLinkSayisi==actualLinkSayisi)) {
            System.out.println("Link sayisi testi PASSED");
        } else {
            System.out.println("FAILED" +
                    "\nSayfada var olan link sayisi + " + actualLinkSayisi);
        }

        // 4- Products linkine tikla
        driver.findElement(By.partialLinkText("Products")).click(); // partialLinkText yaptigimizda bosluk birakmaya gerek yok.

        // 5- special offer yazisininin gorundugunu test et
        WebElement specialOfferElementi = driver.findElement(By.id("sale_image"));

        if (specialOfferElementi.isDisplayed()) {
            System.out.println("Test PASSED");
        } else  {
            System.out.println("FAILED");
        }

        // 6- Sayfayi kapat.


        Thread.sleep(3000);
        driver.close();





    }
}
