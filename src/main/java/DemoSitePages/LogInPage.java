package DemoSitePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class LogInPage {
    @FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
    WebElement usernameBox;

    @FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
    WebElement passwordBox;

    @FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
    WebElement loginButton;

    @FindBy (xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
    WebElement loggedInTest;

    public void signIn(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }

    public Boolean loggedInSuccess(){
        if(loggedInTest.getText().equals("**Successful Login**")){
            return true;
        }else{
            return false;
        }
    }
}
