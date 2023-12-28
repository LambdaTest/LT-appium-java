
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
public class smartui_ios {

    public static String userName = System.getenv("LT_USERNAME") == null ? "YOUR_USERNAME" // Add username here
            : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "YOUR_USERNAME" // Add accessKey here
            : System.getenv("LT_ACCESS_KEY");


    public static void main(String[] args) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("app", "lt://proverbial-ios"); // Enter your app url
        ltOptions.put("deviceName", "iPhone 14");
         ltOptions.put("platformName", "iOS");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("build", "Java Test - iOS");
        ltOptions.put("name", "Sample Test Java-iOS");
        ltOptions.put("w3c", true);
        ltOptions.put("video", true);
        ltOptions.put("visual", true);
        ltOptions.put("smartUI.project", "Real-Device-Project-IOS");  //Enter your smartUI Project name
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