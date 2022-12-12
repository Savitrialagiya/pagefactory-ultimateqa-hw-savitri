package com.ultimateqa.testsuite;

import com.ultimateqa.customlisteners.CustomListeners;
import com.ultimateqa.pages.LoginPage;
import com.ultimateqa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun=true)
    public void inIt(){
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldNavigateToLoginPageSuccessfully(){
        loginPage.clickOnSignInLink();
        Assert.assertEquals(loginPage.getWelcomeText(),"Welcome Back!","Message not displayed");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyTheErrorMessage(){
        loginPage.clickOnSignInLink();
        loginPage.enterTextInUsernameFiled("admin1234@gmail.com");
        loginPage.enterTextInPasswordField("admin1234");
        loginPage.clickOnSignInButton();
        Assert.assertEquals(loginPage.getInvalidEmailOrPassword(),"Invalid email or password.","Message not displayed");
    }
}
