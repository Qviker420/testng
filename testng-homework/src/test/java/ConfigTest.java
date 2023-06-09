import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Listeners({ScreenShooter.class})
public class ConfigTest implements ITestListener {
    @BeforeSuite
    public void Setup()
    {
        Configuration.browserSize = "1200x980";
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
    }

}
