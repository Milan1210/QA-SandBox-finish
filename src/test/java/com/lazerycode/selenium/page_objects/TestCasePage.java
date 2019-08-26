package com.lazerycode.selenium.page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCasePage extends BasePage {

    private String buttonDeleteXpath = "//button[@class='btn btn-secondary ml-2 mb-3 btn-dark btn-lg pull-right']";
    private String buttonDeleteModalXpath = "//button[@class='btn btn-lg btn-danger ']";
    private String createUserCaseButtonXpath = "//a[text()='CREATE USE CASE']";
    private String titleXpath = "//input[@name='title']";
    private String descriptionXpath = "//textarea[@name='description']";
    private String expectedXpath = "//input[@name='expected_result']";

    private String caseStepsXpath = "//input[@id='stepId']";
    private String caseStepXpath_1 = "//input[@placeholder='* Use case step 1']";
    private String caseStepXpath_2 = "//input[@placeholder='* Use case step 2']";
    private String caseStepXpath_3 = "//input[@placeholder='* Use case step 3']";
    private String caseStepXpath_4 = "//input[@placeholder='* Use case step 4']";
    private String caseStepXpath_5 = "//input[@placeholder='* Use case step 5']"; 

    private String addStepButtonXPath = "//button[@data-testid='add_step_btn']";
    private String submitButtonXpath = "//button[@type='submit']";

    public TestCasePage() throws Exception {
    }

    public void deleteTestCase() {
        click(buttonDeleteXpath);
        click(buttonDeleteModalXpath);
    }

    public void clickCreateUseCase() {
        click(createUserCaseButtonXpath);
    }

    public void InsertTitle(String title) {
        sendKeys(titleXpath, title);
    }

    public void InsertDescription(String description) {
        sendKeys(descriptionXpath, description);
    }

    public void InsertExpected(String expected) {
        sendKeys(expectedXpath, expected);
    }

    public void InsertStep_1(String step) {
        sendKeys(caseStepXpath_1, step);
    }

    public void InsertStep_2(String step) {
        sendKeys(caseStepXpath_2, step);
    }

    public void InsertStep_3(String step) {
        sendKeys(caseStepXpath_3, step);
    }

    public void InsertStep_4(String step) {
        sendKeys(caseStepXpath_4, step);
    }

    public void InsertStep_5(String step) {
        sendKeys(caseStepXpath_5, step);
    }

    public void addStep() {
        click(addStepButtonXPath);
    }

    public void submit() {
        click(submitButtonXpath);
    }

    public void apendToTextBox(String xPath, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        WebElement textBox = driver.findElement(By.xpath(xPath));
        textBox.sendKeys(text);
    }

    public void apendToTextBox(WebElement webElement, String text) {
        webElement.sendKeys(text);
    }

    public void apendToTitle(String text) {
        apendToTextBox(titleXpath, text);
    }

    public void apendToDescription(String text) {
        apendToTextBox(descriptionXpath, text);
    }

    public void apendToExpectResult(String text) {
        apendToTextBox(expectedXpath, text);
    }

    public void apendToSteps(String text) {
        List<WebElement> caseSteps = driver.findElements(By.xpath(caseStepsXpath));
        for (WebElement caseStep : caseSteps) {
            apendToTextBox(caseStep, text);
        }
    }

    public int countStep(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(caseStepsXpath)));

        return driver.findElements(By.xpath(caseStepsXpath)).size();
    }
    
    public void deleteEdited(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement title = driver.findElement(By.xpath(xpath));
        title.sendKeys(Keys.CONTROL,Keys.SHIFT,Keys.ARROW_LEFT);
        title.sendKeys(Keys.BACK_SPACE);
    }
    
    public void deleteSteps() {
        List<WebElement> caseSteps = driver.findElements(By.xpath(caseStepsXpath));
        for (WebElement caseStep : caseSteps) {
            caseStep.sendKeys(Keys.CONTROL,Keys.SHIFT,Keys.ARROW_LEFT);
            caseStep.sendKeys(Keys.BACK_SPACE);
        }
    }

    
}
