package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateNewRepositoryPage extends AbstractPage{

    private final String BASE_URL = "https://github.com/new";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy (xpath = "//span/input[@data-testid='repository-name-input']")
    private WebElement inputRepositoryName;

    @FindBy (xpath = "//input[@name='Description']")
    private WebElement inputRepositoryDescription;


    private final By buttonCreateRepo = By.xpath("//button[@class='Box-sc-g0xbh4-0 jLvIcQ prc-Button-ButtonBase-c50BI']");

    private final By labelEmptyRepoSetupOptionLocator = By.xpath("//h3/strong[text()='Quick setup'");

    private final By linkCurrentRepository = By.xpath("//a[@class='d-block overflow-x-hidden color-fg-default']");
    protected CreateNewRepositoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean isCurrentRepositoryEmpty() throws InterruptedException {
        WebElement labelEmptyRepoSetupOption = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(labelEmptyRepoSetupOptionLocator));
        Thread.sleep(3000);
        return labelEmptyRepoSetupOption.isDisplayed();
    }
    public CreateNewRepositoryPage createNewRepository(String repositoryName, String repositoryDescription) throws InterruptedException {
        inputRepositoryName.sendKeys(repositoryName);
        inputRepositoryDescription.sendKeys(repositoryDescription);
        WebElement createBtn = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(buttonCreateRepo));
        Thread.sleep(1000);
        createBtn.click();
        logger.info("Created repository with name: [" + repositoryName +
                "] and description: [" + repositoryDescription + "]");
        return this;
    }

    public String getCurrentRepositoryName(){
        WebElement labelCurrentRepository = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(linkCurrentRepository));
        return labelCurrentRepository.getText();
    }

    @Override
    public CreateNewRepositoryPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
