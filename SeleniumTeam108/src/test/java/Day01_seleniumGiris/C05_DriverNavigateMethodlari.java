package Day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_DriverNavigateMethodlari {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1- Amazon anasayfaya git
        driver.get("https://amazon.com");

        // 2- Wisequarter anasayfaya git
        driver.get("https://wisequarter.com");

        // 3- Amazon anasayfaya git
        driver.navigate().back();

        // 4- Yeniden Wisequarter anasayfaya don
        driver.navigate().forward();

        driver.navigate().to("https://www.youtube.com");






    }

}
