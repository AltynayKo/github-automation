package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage{

    private final String BASE_URL = "https://github.com/";

    //@FindBy(xpath = "//button[@id='global-create-menu-anchor']")
    private final By createNewBtnLocator = By.xpath("//button[@id='global-create-menu-anchor']");
    private final By linkNewRepositoryLocator = By.xpath("//a[@id=':r6:']");

    private final By linkLoggedInUserLocator = By.xpath("//meta[@name='user-login']");

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CreateNewRepositoryPage invokeNewRepositoryCreation() throws InterruptedException {

        WebElement buttonCreateNew = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(createNewBtnLocator));
        buttonCreateNew.click();
        Thread.sleep(3000); //without this sleep the code does not work
        WebElement linkNewRepository = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(linkNewRepositoryLocator));
        linkNewRepository.click();
        Thread.sleep(3000);
        return new CreateNewRepositoryPage(driver);
    }

    @Override
    protected MainPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getLoggedInUserName(){
        WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(linkLoggedInUserLocator));
        return linkLoggedInUser.getAttribute("content");
    }
}
