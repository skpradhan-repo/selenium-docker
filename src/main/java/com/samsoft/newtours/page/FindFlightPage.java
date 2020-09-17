package com.samsoft.newtours.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "reserveFlights")
    private WebElement firstSubmitBtn;

    @FindBy(name = "buyFlights")
    private WebElement secondSubmitBtn;

    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void submitFindFlightPage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.firstSubmitBtn));
        this.firstSubmitBtn.click();
    }

    public void gotoFlightConfirmationPage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.secondSubmitBtn));
        this.secondSubmitBtn.click();
    }
}
