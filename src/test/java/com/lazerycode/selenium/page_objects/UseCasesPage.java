package com.lazerycode.selenium.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UseCasesPage extends BasePage {

    private String caseXpath = "//a[@class='list-group-item list-group-item-action']";

    public UseCasesPage() throws Exception {
    }

    public void clickUseCase(int index) {
        click(caseXpath + "[" + String.valueOf(index) + "]");
    }

    public int countCases() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(caseXpath)));
        
        return driver.findElements(By.xpath(caseXpath)).size();
    } 

}
