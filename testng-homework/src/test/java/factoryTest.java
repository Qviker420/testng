import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class factoryTest {
    public String name;
    public String LastName;
    public Integer Gender;
    public String Number;
    public String Mail;

    public factoryTest(String name, String LastName, Integer Gender, String Mail, String Number)
    {
        this.name = name;
        this.LastName= LastName;
        this.Gender = Gender;
        this.Mail = Mail;
        this.Number = Number;
    }
    @Test
    public void Test()
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
        System.out.println(firstName.getValue());
    }
}
