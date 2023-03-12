package tests.Day10_TestNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_dependsOnMethods {

    AmazonPage amazonPage = new AmazonPage();

    @Test
    public void amazonTesti() {

        Driver.getDriver().get("https://amazon.com");

        String expextedIcerik = "amazon";
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expextedIcerik));


    }

    @Test (dependsOnMethods = "amazonTesti")
    public void nutellaTesti() {

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("nutella", Keys.ENTER);

        String expectedIcerik = "nutella";
        String actualSonucYazisi = amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

    }

    @Test (dependsOnMethods = "nutellaTesti")
    public void ilkUrunTesti() {

        amazonPage.ilkUrun.click();

        String expectedIcerik = "nutella";
        String actualUrunIsmi = amazonPage.ilkUrunIsmiElementi.getText();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIcerik));

        Driver.closeDriver();


    }


}

