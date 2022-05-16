package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import java.lang.reflect.Method;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listeners.TestListener;

import static utils.extentreports.ExtentTestManager.startTest;

@Listeners({TestListener.class})
@Epic("Make Up login Pop up")
@Feature("Login Tests")
public class LoginTest extends BaseTest {
    @Test(priority = 0, description = "Login pop up appear")
    @Severity(SeverityLevel.MINOR)
    public void verifyLoginPopUpAppears(Method method) {
        startTest(method.getName(), "Login pop up appear");
        homePage
                .goToMakeUp()
                .goToLoginPage()
                .verifyPopUpAppear();
    }
}