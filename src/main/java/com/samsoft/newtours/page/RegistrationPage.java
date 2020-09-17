package com.samsoft.newtours.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="firstName")
    private WebElement firstNameText;

    @FindBy(name="lastName")
    private WebElement lastNameText;

    @FindBy(name = "email")
    private WebElement userNameText;

    @FindBy(name="password")
    private WebElement passwordText;

    @FindBy(name="confirmPassword")
    private WebElement confirmPasswordText;

    @FindBy(name="register")
    private WebElement submit;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this. wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("http://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameText));
    }

    public void enterUserDetails(String firstName, String lastName){
        this.firstNameText.sendKeys(firstName);
        this.lastNameText.sendKeys(lastName);
    }

    public void enterUserCredentials(String username, String password){
        this.userNameText.sendKeys(username);
        this.passwordText.sendKeys(password);
        this.confirmPasswordText.sendKeys(password);
    }

    public void submit(){
        this.submit.click();
    }

}
