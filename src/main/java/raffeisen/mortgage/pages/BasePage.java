package raffeisen.mortgage.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import raffeisen.mortgage.util.DriverManager;

import java.util.List;

public class BasePage {

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 20);

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void fillField(WebElement field, String value) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("return arguments[0].style.border='1px solid magenta';", field);
        field.clear();
        field.sendKeys(value);
        js.executeScript("return arguments[0].style.border='1px solid black';", field);
    }


    public void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public void selectMenuItem(List<WebElement> menuItems, String itemName) {
        for (WebElement item : menuItems) {
            if (item.getText().equalsIgnoreCase(itemName)) {
                item.click();
                return;
            }
        }
        Assert.fail("Не найден элмент коллеции - " + itemName);
    }

    public void selectInput(WebElement element, String value) {
        element.click();
        element.findElement(By.xpath("//div[contains(@class,'ui-menu-item-wrapper')][contains(text(),'" + value + "')]")).click();
    }

    public void scrollAndClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("return arguments[0].scrollIntoView(false);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}

