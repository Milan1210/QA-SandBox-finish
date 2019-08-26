package com.lazerycode.selenium.tests;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.page_objects.HomePage;
import com.lazerycode.selenium.page_objects.LoginPage;
import com.lazerycode.selenium.page_objects.DashboardPage;
import com.lazerycode.selenium.page_objects.UseCasesPage;
import com.lazerycode.selenium.page_objects.TestCasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SandBoxIT extends DriverBase {

    private WebDriver driver;
    private String siteUrl = System.getProperty("site.url");
    private WebDriverWait wait;

    @Test(priority = 1)
    public void login() throws Exception {
        driver = getDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 20);

        driver.get(siteUrl);
        wait.until(ExpectedConditions.urlToBe(siteUrl));

        HomePage homePage = new HomePage();
        homePage.clickLogin();
        wait.until(ExpectedConditions.urlToBe(siteUrl + "login"));

        LoginPage loginPage = new LoginPage();

        String userName = System.getProperty("site.user.name");
        loginPage.enterUserName(userName);

        String userPwd = System.getProperty("site.user.pwd");
        loginPage.enterPwd(userPwd);

        loginPage.submit();
        wait.until(ExpectedConditions.urlToBe(siteUrl + "dashboard"));
    }

    @Test(priority = 2)
    public void deleteTestCase() throws Exception {
        DashboardPage dashboardPapage = new DashboardPage();
        TestCasePage testCasePage = new TestCasePage();

        // click on USeCase box
        dashboardPapage.clickUseCasesBox();
        wait.until(ExpectedConditions.urlToBe(siteUrl + "use-cases"));

        UseCasesPage useCasePage = new UseCasesPage();

        // Delete test cases
        int casesCount = useCasePage.countCases();
        for (int i = 0; i < casesCount; i++) {
            wait.until(ExpectedConditions.urlToBe(siteUrl + "use-cases"));
            // Click on UseCase
            useCasePage.clickUseCase(1);
            // Delete this UseCase
            testCasePage.deleteTestCase();
        }
    }

    @Test(priority = 3)
    public void validEmailPass() throws Exception {
        wait.until(ExpectedConditions.urlToBe(siteUrl + "use-cases"));
        TestCasePage testCasePage = new TestCasePage();

        // Click on Button Create UseCase
        testCasePage.clickCreateUseCase();

        // Add title of UseCase
        testCasePage.InsertTitle("QA Sandbox login test with valid email address and valid password");

        // Add Description of UseCase
        testCasePage
                .InsertDescription("Testing login functionality of QA Sandbox with valid email address and valid password");

        // Add Expected of UseCase
        testCasePage.InsertExpected("User is loged in QA Sandbox. We will see Dashboard page");

        // case step 1
        testCasePage.InsertStep_1("Open https://qa-sandbox.apps.htec.rs on web browser");

        // case step 2
        testCasePage.addStep();
        testCasePage.InsertStep_2("Click on button Login");

        // case step 3
        testCasePage.addStep();
        testCasePage.InsertStep_3("Insert valid email address in mail section");

        // case step 4
        testCasePage.addStep();
        testCasePage.InsertStep_4("Enter valid password");

        // case step 5
        testCasePage.addStep();
        testCasePage.InsertStep_5("Click Submit");

        testCasePage.submit();
    }

    @Test(priority = 4)
    public void invalidEmail() throws Exception {
        wait.until(ExpectedConditions.urlToBe(siteUrl + "use-cases"));
        TestCasePage testCasePage = new TestCasePage();

        // Click on Button Create UseCase
        testCasePage.clickCreateUseCase();
        // Add title of UseCase
        testCasePage.InsertTitle("QA Sandbox login test with invalid email address and valid password");

        // Add Description of UseCase
        testCasePage.InsertDescription(
                "Testing login functionality of QA Sandbox with invalid email address and valid password");

        // Add Expected of UseCase
        testCasePage.InsertExpected("User is not loged in, message: 'User not found' is shown");

        // case step 1
        testCasePage.InsertStep_1("Open https://qa-sandbox.apps.htec.rs on web browser");

        // case step 2
        testCasePage.addStep();
        testCasePage.InsertStep_2("Click on button Login");

        // case step 3
        testCasePage.addStep();
        testCasePage.InsertStep_3("Insert invalid email address in mail section");

        // case step 4
        testCasePage.addStep();
        testCasePage.InsertStep_4("Enter valid password");

        // case step 5
        testCasePage.addStep();
        testCasePage.InsertStep_5("Click Submit");

        // Submit
        testCasePage.submit();

    }

    @Test(priority = 5)
    public void incorrectPass() throws Exception {
        wait.until(ExpectedConditions.urlToBe(siteUrl + "use-cases"));
        TestCasePage testCasePage = new TestCasePage();

        // Click on Button Create UseCase
        testCasePage.clickCreateUseCase();
        // Add title of UseCase
        testCasePage.InsertTitle("QA Sandbox login test with valid email address and invalid password");

        // Add Description of UseCase
        testCasePage.InsertDescription(
                "Testing login functionality of QA Sandbox with valid email address and invalid password");

        // Add Expected of UseCase
        testCasePage.InsertExpected("User is not loged in, message: 'Password incorrect' is shown");

        // case step 1
        testCasePage.InsertStep_1("Open https://qa-sandbox.apps.htec.rs on web browser");

        // case step 2
        testCasePage.addStep();
        testCasePage.InsertStep_2("Click on button Login");

        // case step 3
        testCasePage.addStep();
        testCasePage.InsertStep_3("Insert valid email address in mail section");

        // case step 4
        testCasePage.addStep();
        testCasePage.InsertStep_4("Enter invalid password");

        // case step 5
        testCasePage.addStep();
        testCasePage.InsertStep_5("Click Submit");

        // Submit
        testCasePage.submit();
    }

    @Test(priority = 6)
    public void withoutEmail() throws Exception {
        wait.until(ExpectedConditions.urlToBe(siteUrl + "use-cases"));
        TestCasePage testCasePage = new TestCasePage();

        // Click on Button Create UseCase
        testCasePage.clickCreateUseCase();
        // Add title of UseCase
        testCasePage.InsertTitle("QA Sandbox login test without enetring email address and valid password");

        // Add Description of UseCase
        testCasePage.InsertDescription(
                "Testing login functionality of QA Sandbox without enetring email address (leave email filed empty) and valid password");

        // Add Expected of UseCase
        testCasePage.InsertExpected("USer is not logged in, message: 'Email filed is required' is shown");

        // case step 1
        testCasePage.InsertStep_1("Open https://qa-sandbox.apps.htec.rs on web browser");

        // case step 2
        testCasePage.addStep();
        testCasePage.InsertStep_2("Click on button Login");

        // case step 3
        testCasePage.addStep();
        testCasePage.InsertStep_3("Enter valid password");

        // case step 4
        testCasePage.addStep();
        testCasePage.InsertStep_4("Click Submit");

        // Submit
        testCasePage.submit();
    }

    @Test(priority = 7)
    public void withoutPass() throws Exception {
        wait.until(ExpectedConditions.urlToBe(siteUrl + "use-cases"));
        TestCasePage testCasePage = new TestCasePage();

        // Click on Button Create UseCase
        testCasePage.clickCreateUseCase();
        // Add title of UseCase
        testCasePage.InsertTitle("QA Sandbox login test without password");

        // Add Description of UseCase
        testCasePage.InsertDescription("Testing login functionality of QA Sandbox with valid email address and without entering password(leave password filed empty)");

        // Add Expected of UseCase
        testCasePage.InsertExpected("User is not logged in, message: 'Password filed is required' is shown.");

        // case step 1
        testCasePage.InsertStep_1("Open https://qa-sandbox.apps.htec.rs on web browser");

        // case step 2
        testCasePage.addStep();
        testCasePage.InsertStep_2("Click on button Login");

        // case step 3
        testCasePage.addStep();
        testCasePage.InsertStep_3("Enter valid email");

        // case step 4
        testCasePage.addStep();
        testCasePage.InsertStep_4("Click Submit");

        // Submit
        testCasePage.submit();
    }

    @Test(priority = 8)
    public void addEdit() throws Exception {
        wait.until(ExpectedConditions.urlToBe(siteUrl + "use-cases"));

        UseCasesPage useCasesPage = new UseCasesPage();
        int casesCount = useCasesPage.countCases();

        TestCasePage testCasePage = new TestCasePage();
        for (int i = 1; i <= casesCount; i++) {
            useCasesPage.clickUseCase(i);
            wait.until(ExpectedConditions.urlContains(siteUrl + "use-cases/"));

            testCasePage.apendToTitle(" edited");
            testCasePage.apendToDescription(" edited");
            testCasePage.apendToExpectResult(" edited");
            testCasePage.apendToSteps(" edited");

            // Submit
            testCasePage.submit();
        }
    }
    
    @Test(priority = 9)
    public void deleteEdit() throws Exception {
        wait.until(ExpectedConditions.urlToBe(siteUrl + "use-cases"));

        UseCasesPage useCasesPage = new UseCasesPage();
        int casesCount = useCasesPage.countCases();

        TestCasePage testCasePage = new TestCasePage();
        for (int i = 1; i <= casesCount; i++) {
            useCasesPage.clickUseCase(i);
            wait.until(ExpectedConditions.urlContains(siteUrl + "use-cases/"));

            testCasePage.deleteEdited("//input[@name='title']");
            testCasePage.deleteEdited("//textarea[@name='description']");
            testCasePage.deleteEdited("//input[@name='expected_result']");
            testCasePage.deleteSteps();
            

            // Submit
            testCasePage.submit();
        }
    }
}
