import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.Screenshot;
import com.codeborne.selenide.testng.ScreenShooter;
import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;


import java.util.List;

import static com.codeborne.selenide.Selenide.*;


@Listeners({ScreenShooter.class})
public class CheckBoxTest extends ConfigTest
{
    SoftAssert softAssert;
    @BeforeTest
    public void setup()
    {
        softAssert = new SoftAssert();

        Configuration.screenshots = true;
        Configuration.savePageSource = false;
    }
    @Test(priority = 3, groups = "FrontEnd", threadPoolSize = 4)
    public void uncheckBoxTest(){
        open("http://the-internet.herokuapp.com/checkboxes");
        Uncheck();
    }
    @Test(priority = 4, groups = "BackEnd", threadPoolSize = 4)
    public void CheckBoxTest()
    {
        check();
    }

    @Test(retryAnalyzer = Analyzer.RetryAnalyze.class)
    public void retryTest()
    {
        softAssert.fail();
    }



    public void Uncheck(){
        List<SelenideElement> checkBoxes = $$("input");
        for(SelenideElement element : checkBoxes)
        {
            if(element.isSelected())
            {
                element.click();
            }
        }
        softAssert.fail();
        softAssert.assertAll();
    }
    public void check()
    {
        List<SelenideElement> checkBoxes = $$("input");
        for(SelenideElement element : checkBoxes)
        {
            element.click();
        }
        softAssert.fail();
        softAssert.assertAll();
    }
}
