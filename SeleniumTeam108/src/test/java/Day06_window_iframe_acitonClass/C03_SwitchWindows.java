package Day06_window_iframe_acitonClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilitize.TestBase;

public class C03_SwitchWindows extends TestBase {

    @Test
    public void test01() {

        // Amazon git, arama kutusunun erisebilir oldugunu test et.

        driver.get("https://amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        String amazonWindowHandleDegeri = driver.getWindowHandle();
        bekle(2);

        // yeni bir tab olarak youtube'a gidin
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://youtube.com");

        // url'in wisequarter icerdigini test edin
        String expectedIcerik = "you";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedIcerik));
        bekle(2);
        String youtubeWindowHandleDegeri = driver.getWindowHandle();

        // amazon'un acik oldugu tab'a geri donup

         /*
            Daha once acilmis olan bir window'a gecis yapmak icin
            O sayfanin windowHandle degerine ihtiyacimiz var
            Testimiz boyle bir gorevi iceriyorsa
            o sayfada iken windowHandle degerini alip kayit yapmaliyiz
         */

        driver.switchTo().window(amazonWindowHandleDegeri);

        // nutella ara
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);
        // Sonuclarin Nutella icerdigini test edin

        String expectedSonuc = "nutella";
        String actualSonuc = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"))
                .getText();
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));

        // yeni bir window olarak youtube.com'a gidin

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://youtube.com");

        // Url'in youtube icerdigini test edin

        String actualUrl = driver.getTitle();
        String expectedUrl = "youtube";

        Assert.assertTrue(actualURL.contains(expectedUrl));
        bekle(2);

        // wisequarter'in acik oldugu sayfaya donun
        driver.switchTo().window(youtubeWindowHandleDegeri);

        // Title'in Wise Quarter icerdigini test edin
        String expectedTitle = "You";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        bekle(3);

    }

}
