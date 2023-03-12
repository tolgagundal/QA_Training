package Day05_assertionDropDown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilitize.TestBase;

public class C05_TestBase01 extends TestBase {

    @Test
    public void amazonTest() {
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);
        // Sonuclarin Nutella icerdigini test edelim
        WebElement actualSonucYaziElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik= "Nutella";
        String actualSonucYazisi= actualSonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));



    }

}
