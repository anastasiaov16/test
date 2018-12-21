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

public class Choose_thing extends Start{

    @Test
    public void vacuum_cleaner()
    {
        WebElement searchField = driver.findElement(By.id("header-search"));
        searchField.sendKeys("робот пылесос");

        WebElement searchButton = driver.findElement(By.className("search2__button")).findElement(By.tagName("button"));
        searchButton.click();

        WebElement cleaner = driver.findElement(By.linkText("Пылесос Polaris PVCR 0920WV"));
        cleaner.click();

        WebElement addToBasket = driver.findElement
                (By.cssSelector("i.image.image_name_favorite"));
        addToBasket.click();

        WebElement goToBasket = driver.findElement(By.linkText("Перейти к отложенным"));
        goToBasket.click();

        WebElement deleteCleaner = driver.findElement(By.cssSelector(".wishlist-control > .n-product-toolbar__item-label"));
        deleteCleaner.click();
    }
}
