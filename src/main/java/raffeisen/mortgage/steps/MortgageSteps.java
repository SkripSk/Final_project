package raffeisen.mortgage.steps;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import raffeisen.mortgage.pages.MortgagePage;

public class MortgageSteps {

    MortgagePage mortgagePage = new MortgagePage();

    @When("выпадающий список \"(.*)\" заполняется значением \"(.*)\"")
    public void selectInput(String field, String value) throws Exception {

        WebElement element = mortgagePage.getField(field);
        mortgagePage.selectInput(element, value);
    }

    @When("Отмечен чекбокс - \"(.*)\"")
    public void selectCheckbox(String field) throws Exception {
        mortgagePage.click(field);
    }
}
