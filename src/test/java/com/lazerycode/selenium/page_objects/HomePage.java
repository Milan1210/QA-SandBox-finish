package com.lazerycode.selenium.page_objects;

public class HomePage extends BasePage {

    private String loginButtonXpath = "/html/body/div/div/div[2]/div/div/div/div/div/a[2]";

    public HomePage() throws Exception {
    }

    public void clickLogin() {
        click(loginButtonXpath);
    }
}
