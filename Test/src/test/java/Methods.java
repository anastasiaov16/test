import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Methods extends Start {

    public static String delSpace(String price)
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

    public static void changePrice(WebElement allElements) throws InterruptedException
    {
        String amountElements = cutAmountElements(allElements.getText());

        while(amountElements.equals(cutAmountElements(driver.findElement(By.className("n-search-preciser__results-count")).getText())))
        {
            Thread.sleep(4000);
            System.out.println("Wait 40 seconds");
        }
    }

    public static String cutAmountElements(String str)
    {
        String amountElements = str.substring(8, str.length() - 12);
        System.out.println(amountElements);
        return amountElements;
    }

    public static int transformPrice(String price)
    {
        int intPrice = Integer.parseInt(delSpace(price.substring(0, price.length() - 1)));
        return intPrice;
    }

    public static void delete_elem(List<WebElement> mouses)
    {
        for (WebElement mouse : mouses)
        {
            if(mouse.getText().equals(""))
            {
                mouses.remove(mouse);
            }
        }
    }

}
