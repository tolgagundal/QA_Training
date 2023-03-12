package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitize.TestBase;

import java.sql.Driver;

public class Practice01 extends TestBase {

    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
bekle(2);
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfa = driver.findElement(By.tagName("h3"));
        String expectedText = "Opening a new window";
        String actualText = sayfa.getText();

        Assert.assertEquals(expectedText, actualText);
        bekle(2);
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);

        String handle = driver.getWindowHandle();
        bekle(2);
        //● Click Here butonuna basın.

        driver.findElement(By.linkText("Click Here")).click();  // tag'i "a" ile baslayan.
        bekle(2);
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        String expectedTitle2 = "New Window";
        String actualTitle2 = driver.getTitle();

        Assert.assertEquals(expectedTitle2, actualTitle2);
        bekle(2);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        String actual =driver.findElement(By.tagName("h3")).getText();
        String expected = "New Window";

        Assert.assertEquals(actual, expected);
        bekle(2);
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(handle);
        String expectedTitle3 = "The Internet";
        String actualTitle3 = driver.getTitle();

        Assert.assertEquals(expectedTitle3, actualTitle3);
        bekle(2);


    }


}
