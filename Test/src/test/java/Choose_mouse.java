import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Choose_mouse extends Start{
    @Test
    public void findMouse() throws InterruptedException {
        WebElement searchField = driver.findElement(By.id("header-search"));
        searchField.sendKeys("компьютерные мыши");

        WebElement click_button = driver.findElement(By.cssSelector(".button2_size_ml"));
        click_button.click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement elements = driver.findElement(By.className("n-search-preciser__results-count"));

        WebElement MinPrice = driver.findElement(By.id("glpricefrom"));
        MinPrice.sendKeys("1000");

        WebElement MaxPrice = driver.findElement(By.id("glpriceto"));
        MaxPrice.sendKeys("2000");
        Methods.changePrice(elements);

        List<WebElement> comp_mouses = driver.findElement(By.className("n-snippet-list")).findElements(By.xpath("//div[@class = 'price']"));
        Methods.delete_elem(comp_mouses);
        List<Integer> prices = new LinkedList<Integer>();

        for (WebElement mousePrice : comp_mouses)
        {
            int price = Methods.transformPrice(mousePrice.getText());
            prices.add(price);
        }

        for (Integer price : prices)
        {

            Assert.assertTrue(price <= 2000 && price >= 1000);
        }

    }





}
