package com.epam.ta.test;

import com.epam.ta.page.LoginPage;
import com.epam.ta.service.UserCreator;
import com.epam.ta.util.StringUtils;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class RepositoryManagementTests extends BaseClass{
    protected static final int REPOSITORY_NAME_POSTFIX_LENGTH = 6;
    protected static final String REPOSITORY_DESCRIPTION = "auto-generated test repo";


    @Test(description = "JIRA-7566")
    public void oneCanCreateProject() throws InterruptedException {
        String expectedRepositoryName = StringUtils.generateRandomRepositoryNameWithPostfixLength(REPOSITORY_NAME_POSTFIX_LENGTH);
        String createRepositoryName = new LoginPage(driver)
                .openPage()
                .login(UserCreator.withCredentialsFromProperty())
                .invokeNewRepositoryCreation()
                .createNewRepository(expectedRepositoryName, REPOSITORY_DESCRIPTION)
                .getCurrentRepositoryName();
        assertThat(createRepositoryName, is(equalTo(expectedRepositoryName)));
    }

    /*@Test(description = "JIRA-7567")
    public void newProjectsAreEmpty() throws InterruptedException {
        String testRepositoryName = Service.generateRandomRepositoryNameWithPostfixLength(REPOSITORY_NAME_POSTFIX_LENGTH);
        boolean isCurrentRepositoryEmpty = new LoginPage(driver)
                .openPage()
                .login(UserCreator.withCredentialsFromProperty())
                .invokeNewRepositoryCreation()
                .createNewRepository(testRepositoryName, REPOSITORY_DESCRIPTION)
                .isCurrentRepositoryEmpty();
        Assert.assertTrue(isCurrentRepositoryEmpty, "newly created repository is not empty");
    }*/


}
