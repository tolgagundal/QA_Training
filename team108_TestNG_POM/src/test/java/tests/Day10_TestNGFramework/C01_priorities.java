package tests.Day10_TestNGFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_priorities {

    // TestNG test metodlarinin standart olarak harf siralamasina gore yapar.
    // ancak TestNG siralamayi manuel ayarlamaya imkan tanir. (priority)

    @Test (priority = 10)
    public void amazonTesti() {
        // wise ana sayfaya gidip WiseQuarter'a gittigimizi test edelim
        Driver.getDriver().get("https://amazon.com");

        String expextedIcerik = "amazon";
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expextedIcerik));
        Driver.closeDriver();

    }

    @Test (priority = 5)
    public void wiseTesti() {
        // wise ana sayfaya gidip WiseQuarter'a gittigimizi test edelim

        Driver.getDriver().get("https://youtube.com");

        String expextedIcerik = "youtube";
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expextedIcerik));
        Driver.closeDriver();

    }

    @Test
    public void youtubeTesti() {
        // youtube ana sayfaya gidip youtube gittigimizi test edelim

    }


}
