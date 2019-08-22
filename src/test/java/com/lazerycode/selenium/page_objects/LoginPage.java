package com.lazerycode.selenium.page_objects;

public class LoginPage extends BasePage {

    private String userNameBoxXpath = "/html/body/div/div/div[2]/div/div/div/div/form/div[1]/input";
    private String pwdBoxXpath = "/html/body/div/div/div[2]/div/div/div/div/form/div[2]/input";
    private String submitButtonXpath = "/html/body/div/div/div[2]/div/div/div/div/form/button";

    public LoginPage() throws Exception {
    }

    public void enterUserName(String userName) {
        sendKeys(userNameBoxXpath, userName);
    }

    public void enterPwd(String pwd) {
        sendKeys(pwdBoxXpath, pwd);
    }

    public void submit() {
        click(submitButtonXpath);
    }

}
