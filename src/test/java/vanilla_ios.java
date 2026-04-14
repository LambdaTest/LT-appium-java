import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class vanilla_ios {

    public static String userName = System.getenv("LT_USERNAME") == null ? "YOUR_USERNAME" : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "YOUR_ACCESS_KEY" : System.getenv("LT_ACCESS_KEY");

    public static IOSDriver driver = null;

    public static void main(String[] args) throws Exception {

        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();

            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "iOS");
            ltOptions.put("deviceName", "iPhone.*"); // Updated to a newer model for better stability
            ltOptions.put("platformVersion", "17");
            ltOptions.put("isRealMobile", true);
            ltOptions.put("app", "<your_app_id>"); // Use your iOS App URL
            ltOptions.put("build", "Java Vanilla - iOS");
            ltOptions.put("name", "Sample Test Java iOS");
            ltOptions.put("devicelog", true);
            ltOptions.put("autoAcceptAlerts", true);
            ltOptions.put("network", false);
            ltOptions.put("visual", true);

            caps.setCapability("lt:options", ltOptions);

            driver = new IOSDriver(
                    new URL("https://" + userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"),
                    caps);

            // Wait utility
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // 1. Changes color
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("color"))).click();

            // 2. Changes the text
            driver.findElement(AppiumBy.id("Text")).click();

            // 3. Toast
            driver.findElement(AppiumBy.id("toast")).click();

            // 4. Notification
            driver.findElement(AppiumBy.id("notification")).click();
//            Thread.sleep(2000);

            // 5. Geolocation
            driver.findElement(AppiumBy.id("geoLocation")).click();
            Thread.sleep(5000);
            driver.navigate().back();





        } catch (Exception t) {
            System.out.println("Test Failed: " + t.getMessage());
            t.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}