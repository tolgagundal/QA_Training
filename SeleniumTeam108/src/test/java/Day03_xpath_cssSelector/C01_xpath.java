package Day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static sun.plugin.javascript.navig.JSType.Element;

public class C01_xpath {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://the-internet.herokuapp.com/add_remove_elements/ adrese git
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Add element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        // Delete butonunun gorunur oldugunu test edin
        WebElement deleteTusu= driver.findElement(By.xpath("//button[@class='added-manually']"));

        // Delete tusuna basin
        WebElement deleteButonElementi = driver.findElement(By.xpath("//button[@class='added-manually']"));

        // Add/Remove Elements yazisinin gorunur oldugunu test et
        if (deleteTusu.isDisplayed()) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }
        driver.close();

    }
}
