import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

@Listeners({ScreenShooter.class})
public class RadioButtonTest extends ConfigTest{

    SoftAssert softAssert;

    @BeforeTest
    public void setup()
    {
        softAssert = new SoftAssert();
        Configuration.savePageSource = false;

    }
    @Test(priority = 0, groups = "FrontEnd", threadPoolSize = 1)
    public void radioYesTest()
    {
        open("https://demoqa.com/radio-button");
        selectYes();
    }
    @Test(priority = 1, groups = "BackEnd", threadPoolSize = 2)
    public void radioNoTest()
    {
        selectNo();
    }

    public void selectYes()
    {
        $("input[type='radio'][id='yesRadio']").click();
        softAssert.fail();
    }
    public void selectNo()
    {
        $("input[type='radio'][id='noRadio']").shouldBe(Condition.interactable);
        softAssert.fail();
    }
}
