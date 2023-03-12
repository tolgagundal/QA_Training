package Day09_excel_screenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilitize.ReusableMethods;
import utilitize.TestBase;

import java.io.IOException;

public class C06_reusableMethodsTumSayfa extends TestBase {
    @Test
    public void test01() throws IOException {

        driver.get("https://amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String actualSonucYazisi = sonucYazisiElementi.getText();
        String expectedSonuc = "Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonuc));

        ReusableMethods.tumSayfaSS(driver);
    }
}
