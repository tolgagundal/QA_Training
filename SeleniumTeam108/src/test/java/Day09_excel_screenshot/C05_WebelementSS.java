package Day09_excel_screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilitize.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_WebelementSS extends TestBase {

    @Test
    public void test01() throws IOException {

        driver.get("https://amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String actualSonucYazisi = sonucYazisiElementi.getText();
        String expectedSonuc = "Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonuc));

        // 1- ve rapora eklenmek icin sonuc elementinin fotografini cekin

        File elementSs = new File("/target/elementSS.png");

        File geciciDosya = sonucYazisiElementi.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya, elementSs);
        bekle(2);

    }

}
