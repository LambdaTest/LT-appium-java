import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
public class smartui_iosweb {

    public static String userName = System.getenv("LT_USERNAME") == null ? "YOUR_USERNAME" // Add username here
            : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "YOUR_ACCESS_KEY" // Add accessKey here
            : System.getenv("LT_ACCESS_KEY");


    public static void main(String[] args) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("deviceName", "iPhone 12");
        ltOptions.put("platformName", "iOS");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("build", "Java - iOS-Web");
        ltOptions.put("name", "Sample Test Java-iOS");
        ltOptions.put("w3c", true);
        ltOptions.put("video", true);
        ltOptions.put("visual", true);
        ltOptions.put("smartUI.project", "Real-Device-Project-IOS-Web");  //Enter your smartUI Project name
        capabilities.setCapability("lt:options", ltOptions);

        AppiumDriver driver = new AppiumDriver(
                new URL("https://" + userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"),
                capabilities);

        try {

            driver.get("https://www.lambdatest.com/");
            Thread.sleep(10000);
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