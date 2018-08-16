package DemoSitePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage {
    @FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
    WebElement usernameBox;

    @FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
    WebElement passwordBox;

    @FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
    WebElement submitButton;

    @FindBy (xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
    WebElement loginButton;

    public void enterDetails(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);

    }

    public void registerUser(){
        submitButton.click();
        loginButton.click();
    }
}
