import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class dataProviderTest {
    @Test(dataProvider="myDataProvider")
    public void Test(String name, String LastName, Integer Gender, String Number, String Mail)
    {
        open("https://demoqa.com/automation-practice-form");
        SelenideElement firstName = $("input#firstName");
        SelenideElement lastName = $("input#lastName");
        List<SelenideElement> gender = $$(By.xpath("//div[@id ='genterWrapper']//label"));
        SelenideElement userNumber = $("input#userNumber");
        SelenideElement userEmail = $("input#userEmail");

        firstName.setValue(name);
        lastName.setValue(LastName);
        gender.get(Gender).click();
        userNumber.setValue(Number);
        userEmail.setValue(Mail);

        Assert.assertEquals(name, firstName.getValue());
    }
    @DataProvider(name = "myDataProvider")
    public Object[][] provideData() {
        return new Object[][]{
                {"Name 1", "Last Name 1", 1, "312312312", "sada@sakdm.com"},
                {"Name 2", "Last Name 2", 0, "123123445", "sa121232dsafda@qwqw.com"},
                {"Name 3", "Last Name 3", 2, "767567576", "sad12a@sakdsadm.com"}
        };
    }

}
