import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.Screenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;


import java.util.List;

import static com.codeborne.selenide.Selenide.*;


@Listeners({ConfigTest.class})
public class CheckBoxTest extends ConfigTest
{
    SoftAssert softAssert;
    @BeforeTest
    public void setup()
    {
        softAssert = new SoftAssert();
        Configuration.baseUrl = "http://the-internet.herokuapp.com/checkboxes ";
        //ar inaxavs screenshotebs
        Configuration.reportsFolder ="C:\\Users\\chali\\TBC\\testng-homework\\testng-homework\\src\\test\\java\\CheckboxFailedTests";
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
    }
    @Test(priority = 0)
    public void uncheckBoxTest(){
        open("");
        Uncheck();
    }
    @Test(priority = 1)
    public void CheckBoxTest()
    {
        check();
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
