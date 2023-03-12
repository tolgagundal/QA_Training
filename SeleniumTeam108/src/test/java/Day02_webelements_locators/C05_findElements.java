package Day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.print.DocFlavor;
import java.time.Duration;
import java.util.List;

public class C05_findElements {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Amazon's git

        driver.get("https://www.amazon.com");

        // Arama kutusuna Java yazalım

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java");
        aramaKutusu.submit();

        // arama sonuclarında cikan resimlerdeki yazilari yazdirin

        List<WebElement> aramaSonuclariElementList=driver.findElements(By.className("sq-col-inner"));

        System.out.println(aramaSonuclariElementList.size());

        // Bu 86 elementi yazdir

        int elementNo=1;
        for (WebElement eachElement:aramaSonuclariElementList
             ) {

            System.out.println(elementNo + " - - - " + eachElement.getText());

        }


    }
}
