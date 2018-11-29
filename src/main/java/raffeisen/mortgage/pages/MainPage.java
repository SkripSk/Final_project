package raffeisen.mortgage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//ul[@class='main-menu']//li")
    public List<WebElement> mainMenu;

    @FindBy(xpath = "//a[@class='menu-link main-menu__link'][@href]")
    public List<WebElement> subMenu;

    @FindBy(xpath = "//*[text()='Да']")
    public WebElement acceptRegion;
}

