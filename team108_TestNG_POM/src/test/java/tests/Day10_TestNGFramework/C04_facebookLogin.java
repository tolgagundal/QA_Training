package tests.Day10_TestNGFramework;

import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C04_facebookLogin {

    @Test
    public void facebookTesti() {

        FacebookPage facebookPage = new FacebookPage();


        Driver.getDriver().get("https://www.facebook.com/");
        //POM'a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin

        Faker faker = new Faker();







    }


}
