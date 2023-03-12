package Day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverMethodlari {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wisequarter.com");
        driver.manage().window().maximize();
        System.out.println(driver.getWindowHandles());

        System.out.println(driver.getPageSource());

        // Sayfa kodlari iceriyor mu? Test et

        String expectedIcerik = "2 hours weekly";
        String actualSayfaKodlari = driver.getPageSource();

        if (actualSayfaKodlari.contains(expectedIcerik)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }



    }
}
