package Day06_window_iframe_acitonClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitize.TestBase;

public class C02_iframe extends TestBase {

    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/iframe  adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        // "Your content goes here." yazisinin gorunur oldugunu test edin
        /*
            Bazen locate islemimizden emin olmamiza ragmen
            Locator calismaz
            Bunun sebebi kullanmak istedigimiz webelement'in
            bir iframe'in child'i olmasi olabilir.
            Eger Kullanmak istedigimiz webelement
            anasayfa icine gomulen baska bir websayfasinin elementi ise
            once gomulu sayfaya gecmemiz gerekir
            HTML komutlarinda sayfa icerisine sayfa gomebilmek icin
            <iframe> kullanilir
            Biz de istedigimiz elementi kullanmak icin once
            o frame'e switch yapmaliyiz
            1- gecis yapmak istediginiz frame'i locate edin
            2- switchTo() ile o frame'e gecis yapin
            3- Sonra istediginiz element ile istediginiz islemi yapin
         */

        WebElement frameElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);

        WebElement yaziElementi = driver.findElement(By.tagName("p"));
        Assert.assertTrue(yaziElementi.isDisplayed());

        // driver.switchTo().parentFrame(); // ic icer framelerde bir uste cikar
        driver.switchTo().defaultContent(); // direkt ana sayfaya gecis.
        driver.findElement(By.linkText("Elemental Selenium")).click();




    }



}
