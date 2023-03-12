package Day02_webelements_locators;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_drivermanageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        System.out.println("İlk size" + driver.manage().window().getSize());
        System.out.println("İlk position" + driver.manage().window().getPosition());

        // olculeri ve konumu degistirelim

        driver.manage().window().setSize(new Dimension(500, 500));
        driver.manage().window().setPosition(new Point(50,90));

        System.out.println("size" +  driver.manage().window().getSize());
        System.out.println("position" +  driver.manage().window().getPosition());



        Thread.sleep(2000);
        driver.close();



    }
}
