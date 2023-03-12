package Day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethodlari {

    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Amazon ana sayfaya gidin
        driver.get("https://www.amazon.com/");

        //Tittle ve URL'i yazdirin

        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());

        //Amazon anasayfaya gittigini test edin

        // Test expected result ile actual result'ın karsilasi
        // ör: url amazon içeriyorsa

        String expectedIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedIcerik)) {
            System.out.println("Test PASSED - My First Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

 //
    }
}
