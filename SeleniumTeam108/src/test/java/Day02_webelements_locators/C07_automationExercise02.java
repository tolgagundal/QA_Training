package Day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_automationExercise02 {

    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // 1- Amazon'a git.
        driver.get("https://amazon.com");

        // 2- Arama sayfasina city bike yazip aratin.
       WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
       aramaKutusu.sendKeys("city bike");
       aramaKutusu.submit();
       aramaKutusu.getTagName();

        // 3- Görüntülenen sonuçlarının sayisini yazdirin.


        // 4- Listedeki ilk ürünün resmine tiklayin.




    }
}
