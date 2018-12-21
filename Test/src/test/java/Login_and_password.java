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

public class Login_and_password extends Start{

    @Test
    public void login() throws InterruptedException {

        WebElement log = driver.findElement(By.className("n-passport-suggest-popup-opener")).findElement(By.tagName("a"));
        log.click();

        Thread.sleep(4000);

        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));

        /*!!!!!!!!!тест работает, когда логин и пароль предлагаются одновременно!!!!!!!!!!!!!!*/

        WebElement login = driver.findElement(By.name("login"));
        login.sendKeys("testovcharova");


        WebElement password = driver.findElement(By.name("passwd"));
        password.sendKeys("testtesttest");

        log = driver.findElement(By.className("passport-Button"));
        log.click();

        driver.switchTo().window(oldTab);

        Thread.sleep(6000);

        WebElement clickSpace = driver.findElement(By.id("header-search"));
        clickSpace.click();

        Thread.sleep(6000);


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
