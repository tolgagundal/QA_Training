package Day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_webElements {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Amazon anasayfay git
        driver.get("https://amazon.com");

        // Arama kutusuna locate edip bir webElement olarak kaydedin
        // id'si twotabsearchtextbox olan webElement seklinde locate edecegiz.

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox")); // locate işlemi

        /*
        LOCATOR
        -id
        -classname
        -name
        -tagname
        -linkText
        -partialLinkText
        Geriye kalan 2 locator ise her turlu webelementi locate etmek icin kullanilabilir
         */

        // Arama kutusuna "Nutella" yazip aratin.

        aramaKutusu.sendKeys("nutella");
        aramaKutusu.submit();



        Thread.sleep(2000);
        driver.close();





    }
}
