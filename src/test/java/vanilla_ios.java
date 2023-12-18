
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
public class vanilla_ios {

    public static String userName = System.getenv("LT_USERNAME") == null ? "Your LT Username" // Add username here
            : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" // Add accessKey here
            : System.getenv("LT_ACCESS_KEY");


    public static void main(String[] args) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("app", "APP"); // Enter your app url
        ltOptions.put("deviceName", "iPhone 14");
        ltOptions.put("platformVersion", "16");
        ltOptions.put("platformName", "iOS");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("deviceOrientation", "PORTRAIT");
        ltOptions.put("build", "Java Test - iOS");
        ltOptions.put("name", "Sample Test Java-iOS");
        ltOptions.put("devicelog", true);
        ltOptions.put("w3c", true);
        ltOptions.put("video", true);
        ltOptions.put("visual", true);
        ltOptions.put("network", true);
        ltOptions.put("tunnel", false);
        ltOptions.put("project", "");  //Enter Project name here
        ltOptions.put("smartUI.project", "");  //Enter smartUI Project name here
        capabilities.setCapability("lt:options", ltOptions);

        AppiumDriver driver = new AppiumDriver(
                new URL("https://" + userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"),
                capabilities);

        try {

            Thread.sleep(2000);
            // Changes color
            driver.findElement(AppiumBy.id("color")).click();
            Thread.sleep(1000);

            //Back to black color
            driver.navigate().back();

            Thread.sleep(1000);

            //Changes the text to proverbial
            driver.findElement(AppiumBy.id("Text")).click();
            Thread.sleep(1000);

            //toast is visible
            driver.findElement(AppiumBy.id("toast")).click();
            Thread.sleep(1000);

            //notification is visible
            driver.findElement(AppiumBy.id("notification")).click();
            Thread.sleep(2000);

            driver.executeScript("smartui.takeScreenshot=<Name of your Screenshot>");
            System.out.println("Screenshot Captured");


            // ((JavascriptExecutor) driver).executeScript("lambda-status=passed");
            driver.quit();

        } catch (Exception t) {
            System.out.println(t);
            driver.quit();
        }
    }
}