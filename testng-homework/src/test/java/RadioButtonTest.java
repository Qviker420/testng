import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

@Listeners({SoftAssert.class})
public class RadioButtonTest extends ConfigTest{

    SoftAssert softAssert;

    @BeforeTest
    public void setup()
    {
        softAssert = new SoftAssert();
        Configuration.reportsFolder ="testng-homework/src/test/java/CheckboxFailedTests";
        Configuration.savePageSource = false;
        Configuration.baseUrl = "https://demoqa.com/radio-button";
    }
    @Test
    public void radioYesTest()
    {
        open("");
        selectYes();
    }
    @Test
    public void radioNoTest()
    {
        open("");
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
    }
}
