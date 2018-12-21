import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeTest;

public class Start
{
    protected static WebDriver driver;

    @BeforeTest
    public void start()
    {
        System.setProperty("webdriver.gecko.driver", "D:\\test\\test\\src\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://market.yandex.ru/");
    }

    /*@AfterTest
    public void finish()
    {
        driver.quit();
    }*/
}
