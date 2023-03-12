package Day02_webelements_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_driverMethodlari {

    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
        // basliginin (title) "amazon" oldugunu dogrulayin (verify)
        String expectedTitle = "amazon";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equalsIgnoreCase(actualTitle)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED" +
                    "\nGercekelesen title: " + actualTitle);
        }

        String expectedIcerik = "amazon";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedIcerik)) {
            System.out.println("Test PASSED");
        } else{
            System.out.println("Amazon URL test FAILED" +
                    "\nGerceklesen url: " + actualURL);
        }

        driver.close();


    }


}
