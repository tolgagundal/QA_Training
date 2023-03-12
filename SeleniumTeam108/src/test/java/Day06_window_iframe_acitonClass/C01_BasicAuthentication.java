package Day06_window_iframe_acitonClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static utilitize.TestBaseClass.driver;

public class C01_BasicAuthentication { //BasicAuth varsa username ve password bize verilmeli

    @Test
    public  void test01() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        String actualGirisYazisi = driver.findElement(By.tagName("p")).getText();
        String expectedIcerik = "Congratulation";

        Assert.assertTrue(actualGirisYazisi.contains(expectedIcerik));
    }

}
