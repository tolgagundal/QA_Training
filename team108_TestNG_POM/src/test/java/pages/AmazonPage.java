package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    /*
    Pages class'lari surekli kullandigimiz locate'leri tekrar tekrar
    locate etme zorunlulugundan kurtulmak icin kullanilir.
    */

    // @FindBy notasyonunun Driver class'indaki webDriver'i kullanabilmesi icin bu classa tanıtmali

     public AmazonPage() {
         PageFactory.initElements(Driver.getDriver(),this);
     }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaKutusu;

     @FindBy(xpath = "//h1[@class=‘a-size-base s-desktop-toolbar a-text-normal’]")
     public WebElement aramaSonucElementi;

     @FindBy (xpath = "(//img[@class='s-image'])[1]")
    public WebElement ilkUrun;

     @FindBy (xpath = "//span[@id='productTitle']")
    public WebElement ilkUrunIsmiElementi;



}
