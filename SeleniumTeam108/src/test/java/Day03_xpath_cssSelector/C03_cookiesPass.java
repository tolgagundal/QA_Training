package Day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_cookiesPass {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://google.com");
        // cookies accepts and close
        driver.findElement(By.xpath("//div[text()=‘Accept all’]"));

        // Arama Java yaz ve arat
        WebElement aramaCubuk = driver.findElement(By.xpath("//div[text()=‘Accept all’]"));
        aramaCubuk.sendKeys("Java" + Keys.ENTER);

        // bulunan sonuc sayisinin 100.000'den fazla oldugunu TEST et.
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@id=‘result-stats’]"));
        System.out.println(sonucSayisi.getText());


    }
}
