package com.ultimateqa.pages;

import com.aventstack.extentreports.Status;
import com.ultimateqa.customlisteners.CustomListeners;
import com.ultimateqa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    public LoginPage(){

    }
    @CacheLookup
    @FindBy(xpath = "//li[@class='header__nav-item header__nav-sign-in']")
    WebElement signIn;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome Back!')]")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(id = "user[email]")
    WebElement usernameField;

    @CacheLookup
    @FindBy(id = "user[password]")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement signInButton;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),\"Invalid email or password.\")]")
    WebElement invalidText;



    public void clickOnSignInLink() {
    Reporter.log("Click On Sign In Link" + signIn.toString());
        clickOnElement(signIn);
        CustomListeners.test.log(Status.PASS,"Click On Sign In Link" );
    }

    public String getWelcomeText() {
        Reporter.log(" Get welcome Text " + welcomeText.toString());
        CustomListeners.test.log(Status.PASS," Get welcome Text ");
        return getTextFromElement(welcomeText);
    }

    public void enterTextInUsernameFiled(String username) {
        Reporter.log(" Enter username " + username + " to username field " + usernameField.toString());
        sendTextToElement(usernameField, username);
        CustomListeners.test.log(Status.PASS,"Enter Text In Username Field " + username);
    }

    public void enterTextInPasswordField(String password) {
        Reporter.log(" Enter password " + password + " to password field " + passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Text in Password Field " + password);
    }

    public void clickOnSignInButton() {
        Reporter.log(" Click On Sign In Button " + signInButton.toString());
        clickOnElement(signInButton);
        CustomListeners.test.log(Status.PASS," click On Sign In Button ");
    }

    public String getInvalidEmailOrPassword() {
        Reporter.log(" Get Invalid Email Or Password " + invalidText.toString());
        CustomListeners.test.log(Status.PASS,"get Invalid Email Or Password ");
        return getTextFromElement(invalidText);
    }
}
