package Day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_DriverManage {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");

        System.out.println("maximize size: " + driver.manage().window().getPosition());
        System.out.println("maximize position: " + driver.manage().window().getPosition());


    }

}
