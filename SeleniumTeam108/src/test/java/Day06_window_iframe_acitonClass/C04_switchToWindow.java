package Day06_window_iframe_acitonClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitize.TestBase;

import java.util.Set;

public class C04_switchToWindow extends TestBase {



@Test
    public void test01 () {
    // https://the-internet.herokuapp.com/windows adresine gidin.
    driver.get("https://the-internet.herokuapp.com/windows");
    bekle(3);

    // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    WebElement ilkSayfaYaziElementi = driver.findElement(By.tagName("h3"));
    String expectedText = "Opening a new window";
    String actualText = ilkSayfaYaziElementi.getText();
    Assert.assertEquals(expectedText, actualText);
    bekle(2);

    // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    String expectedsayfaBaslik = "The Internet";
    String actualsayfaBaslik = driver.getTitle();
    Assert.assertEquals(expectedsayfaBaslik, actualsayfaBaslik);
    bekle(2);

    String ilkSayfaWHD = driver.getWindowHandle();

    // Click Here butonuna basın.
    driver.findElement(By.linkText("Click Here")).click();
    bekle(2);

    // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

       /*
            Linke click yaptigimizda acik 2 sayfamiz oluyor.
            Eger switchToNewWindow() method'u kullanilirsa
            driver yeni acilan sayfaya gecis yapar
            Ancak bu method kullanilmadan
            bir link tiklandiginda, yeni bir sayfa aciliyorsa
            driver yeni sayfaya gecis yapmaz
            bizim yeni acilan sayfanin
            windowHandle degerini bulup
            driver'i o sayfaya gecirmemiz GEREKLIDIR
            link'e click yaptigimizda acik 2 sayfamiz oluyor
            bunlardan bir tanesi windowHandle degerini kaydettigimiz ILK SAYFA
            digeri ise windowHandle degerini bilmedigimiz IKINCI SAYFA
            biz getWindowHandles() method'u ile
            bir SET olarak iki sayfanin windowHandle degerlerini alabiliyoruz

            O SET icerisinde
            ilkSayfaWHD'ine esit olmayan String'i ikinciSayfaWHD olarak atayabiliriz.
         */

    Set<String > tumSayfalarWHDSeti = driver.getWindowHandles(); // set'te index yok, sirali getirmek zorunda degil

    // for ile yapmak icin index lazim burada index yok o yüzden foreach ile yapacağız

    String ikinciSayfaWHD="";
    for (String each :tumSayfalarWHDSeti
         ) {
        if (!each.equals(ilkSayfaWHD)) {
            ikinciSayfaWHD=each;
        }

    }

    driver.switchTo().window(ikinciSayfaWHD);
    String expextedNewPageTitle = "New Window";
    String actaulNewPageTitle = driver.getTitle();
    bekle(2);

    Assert.assertEquals(expextedNewPageTitle,actaulNewPageTitle);

    // Sayfadaki textin “New Window” olduğunu doğrulayın.

    String expectedNewPageText = "New Window";
    String actualNewPageText = driver.findElement(By.tagName("h3")).getText();
    Assert.assertEquals(expectedNewPageText, actualNewPageText);
    bekle(3);

    // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    driver.switchTo().window(ilkSayfaWHD);
    String expectedTitle = "The Internet";
    String actualTitle = driver.getTitle();
    Assert.assertEquals(expectedTitle,actualTitle);
    bekle(2);




}


}
