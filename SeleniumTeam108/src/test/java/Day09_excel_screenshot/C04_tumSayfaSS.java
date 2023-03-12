package Day09_excel_screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilitize.TestBase;

import java.io.File;
import java.io.IOException;

import static utilitize.TestBaseClass.driver;

public class C04_tumSayfaSS extends TestBase {

    @Test
    public void test01() throws IOException {

        driver.get("https://amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        String actualSonucYazisi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
        String expectedSonuc = "Nutella";
        Assert.assertEquals(expectedSonuc,actualSonucYazisi);

        // 1- ve rapora eklenmek icin tum sayfanin fotografini cekin

        TakesScreenshot ts = (TakesScreenshot) driver;

        // 2- SS kaydedecegimiz bir dosya olusturalim.

        File tumSayfaSs = new File("target/ss.png");

        // 3- gecici bir file olusuturup ts objesi ile cekilen fotonun dosyaya kaydediyoruz.

        File geciciResim = ts.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi, tumSayfaSs dosyasina kopyalayalim

        FileUtils.copyFile(geciciResim, tumSayfaSs);
        bekle(3);


    }
}
