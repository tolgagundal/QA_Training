package Day07_ActionClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitize.TestBase;

public class C01_MoveToElement extends TestBase {

    @Test
    public void test01() {

        driver.get("https://amazon.com");
        bekle(2);

        Actions actions = new Actions(driver);
        WebElement moveElement = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(moveElement).perform();
        bekle(5);

        driver.findElement(By.xpath("(//span[@class=\"nav-text\"])[1]")).click();


        // Acilan sayfada "Your Lists" yazisi oldugunu test edin.

        String actualListElement = driver.findElement(By.xpath("//div[@role ='heading']")).getText();
        String expectedListElement = "Your Lists";
        Assert.assertEquals(expectedListElement,actualListElement);

        bekle(2);


    }


}
