package DemoSiteCTests;

import DemoSitePages.AddUserPage;
import DemoSitePages.HomePage;
import DemoSitePages.LogInPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    private String username;
    private String password;

    WebDriver driver = null;
    static ExtentReports reports;
    ExtentTest test;

    HomePage home;
    AddUserPage addUser;
    LogInPage logIn;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:/Development/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        reports = new ExtentReports("C:\\Users\\Admin\\Desktop\\Automation\\BDD.html",false);
        test = reports.startTest("Test Login");

    }
    @After
    public void tearDown(){
        driver.quit();
        reports.endTest(test);
        reports.flush();
    }

    @Given("^correctly formatted details$")
    public void correctly_formatted_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        username = "testUser";
        password = "password";
    }

    @When("^I navigate to thedemosite\\.co\\.uk$")
    public void i_navigate_to_thedemosite_co_uk() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://thedemosite.co.uk/index.php");
        test.log(LogStatus.INFO,"The Demo Site page loaded");


    }

    @When("^I click Add a User$")
    public void i_click_Add_a_User() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        home = PageFactory.initElements(driver,HomePage.class);
        home.clickRegister();
        test.log(LogStatus.INFO, "Register User button clicked");
    }

    @When("^I fill in the details$")
    public void i_fill_in_the_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        addUser = PageFactory.initElements(driver,AddUserPage.class);
        addUser.enterDetails(username,password);
        test.log(LogStatus.INFO, "Details entered");
    }

    @When("^I click register$")
    public void i_click_register() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        addUser.registerUser();
        test.log(LogStatus.INFO, "User registered and navigated to login");
    }

    @When("^I try to login$")
    public void i_try_to_login() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logIn = PageFactory.initElements(driver,LogInPage.class);
        logIn.signIn(username,password);
    }

    @Then("^I am successfully logged in$")
    public void i_am_successfully_logged_in() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if(logIn.loggedInSuccess()){
            test.log(LogStatus.PASS, "Log in successful");
        }else{
            test.log(LogStatus.FAIL, "Log in failed");
        }
        assertTrue(logIn.loggedInSuccess());
    }
}
