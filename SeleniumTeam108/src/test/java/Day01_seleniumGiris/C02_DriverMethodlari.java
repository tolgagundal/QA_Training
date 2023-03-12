package Day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodlari {

    public static void main(String[] args) throws InterruptedException {

        /*
        jar dosyalarini yukleyerek Selenium'u kurduk
        ancak her bir Class'in hangi browser ile calismasini istiyorsak,
        o browser ile ilgili driver class'i tanimlamamiz lazim

        Browser ile tercihimiz dogrultusunda ilgili ayarlari yapmak icin Java'daki System calss'indan
        setProperty() kullanilir.

        methoda 2 parametre eklenir
        1. Parametre herkes icin aynidir.
        2. Parametre bu driver'in dosya yolu
        herkesin pc farkli olabilir. MAC'lerde .exe olmaz.
         */

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // istenen sayfaya gitmek icin

        driver.get("https://www.amazon.com");

        Thread.sleep(200);

        driver.close();


    }
}
