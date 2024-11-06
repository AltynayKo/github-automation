package com.epam.ta.page;

import com.epam.ta.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage extends AbstractPage{

    private final String PAGE_URL = "https://github.com/login";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "login_field")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonSubmit;
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Login page opened");
        return this;
    }

    public MainPage login(User testUser){
        inputLogin.sendKeys(testUser.getUserName());
        inputPassword.sendKeys(testUser.getUserPassword());
        buttonSubmit.click();
        logger.info("Login performed");
        return new MainPage(driver);
    }
}
