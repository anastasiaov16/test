import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Change_city extends Start
{
    @Test
    public void Change_City() {

        WebElement change_region = driver.findElement(By.cssSelector("span.header2-menu__text"));
        change_region.click();

        WebElement region = driver.findElement(By.className("header2-region-popup")).findElement(By.className("input__control"));
        region.sendKeys("Саратов");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement new_region = driver.findElement(By.className("header2-region-popup")).findElement(By.className("region-suggest__list")).findElement(By.tagName("div"));
        new_region.click();
        new_region.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement click_region_save = driver.findElement(By.cssSelector(".button"));
        click_region_save.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



        String City = "Саратов";
        String currentCity = remove(driver.findElement(By.className("header2-menu__text")).getText());
        System.out.println(currentCity);

        WebElement buttonReturnCity = driver.findElement(By.cssSelector(".n-region-notification__back-to"));
        buttonReturnCity.click();
    }

    private String remove(String price)
    {
        StringBuffer newPrice = new StringBuffer(price);
        for (int i = 0; i < newPrice.length(); i++)
        {
            if(newPrice.charAt(i) == ' ')
            {
                newPrice.deleteCharAt(i);
            }
        }
        return new String(newPrice);
    }
}
