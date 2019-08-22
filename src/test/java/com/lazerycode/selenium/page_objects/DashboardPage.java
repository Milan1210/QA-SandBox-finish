package com.lazerycode.selenium.page_objects;

public class DashboardPage extends BasePage {

    private String useCases = "//*[@id='root']/div/div[2]/div/div/div[2]/div[2]/div/a/div/span/img";

    public DashboardPage() throws Exception {
    }

    public void clickUseCasesBox() {
        click(useCases);
    }

}
