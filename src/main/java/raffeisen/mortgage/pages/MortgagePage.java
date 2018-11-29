package raffeisen.mortgage.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import raffeisen.mortgage.annotaiton.FieldName;
import raffeisen.mortgage.util.DriverManager;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MortgagePage extends BasePage{

    @FindBy(xpath ="//span[@id='form_city-button']/span[@class='ui-selectmenu-text']")
    @FieldName(name = "Город")
    public WebElement city;

    @FindBy(xpath = "//span[@id='form_program-button']/span[@class='ui-selectmenu-text']")
    @FieldName(name = "Вид ипотечной программы")
    public WebElement mortgageProgramType;

    @FindBy(xpath = "//span[@id='form_object-button']/span[@class='ui-selectmenu-text']")
    @FieldName(name = "Хочу")
    public WebElement mortgageObjectType;

    @FindBy(xpath = "//span[@id='form_category-button']/span[@class='ui-selectmenu-text']")
    @FieldName(name = "Я являюсь")
    public WebElement mortgageСategoryType;

    @FindBy(xpath = "//input[@id='form_credit_amount']")
    @FieldName(name = "В банке возьму")
    public WebElement creditAmount;

    @FindBy(xpath = "//input[@id='form_initial']")
    @FieldName(name = "Первоначальный взнос")
    public WebElement initial;

    @FindBy(xpath = "//input[@id='form_period']")
    @FieldName(name = "Срок кредита")
    public WebElement period;

    @FindBy(xpath = "//div[@class='b-block-row__item b-block-row__item--half']/input")
    @FieldName(name = "Рассчитать")
    public WebElement calc;

    @FindBy(xpath = "//div[@class='checkbox-block']/label")
    @FieldName(name = "Знаю свою ипотечную программу")
    public WebElement isProgram;

    @FindBy(xpath = "//h1[@class='e-title e-title--h2']")
    @FieldName(name = "Заголовок")
    public WebElement title;

    public void fillField(String name, String value) throws Exception {
        WebElement element = getField(name);
        fillField(element, value);
    }

    public void click(String name) throws Exception {
        WebElement element = getField(name);
        click(element);
    }

    public void scrollAndClick(String name) throws Exception {
        WebElement element = getField(name);
        scrollAndClick(element);
    }

    public WebElement getField(String name) throws Exception {
        Class example = Class.forName("raffeisen.mortgage.pages.MortgagePage");
        List<Field> fields = Arrays.asList(example.getFields());
        for (Field field : fields){
            if (field.getAnnotation(FieldName.class).name().equals(name)){
                return DriverManager.getDriver().findElement(By.xpath(field.getAnnotation(FindBy.class).xpath()));
            }
        }
        Assert.fail("Не объявлен элемент с наименованием " + name);
        return null;
    }

    public void assertText(String name, String value) throws Exception {
        WebElement element = getField(name);
        Assert.assertEquals(value, element.getText());
    }

}
