import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SmartuiAndroid {
    public static String userName = System.getenv("LT_USERNAME") == null ? "YOUR_LT_USERNAME" // Add username here
            : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "YOUR_LT_ACCESS_KEY" // Add accessKey here
            : System.getenv("LT_ACCESS_KEY");
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
       
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("deviceName", "Galaxy S21+ 5G");
        ltOptions.put("app", "lt://proverbial-android");  // Enter your app url
        ltOptions.put("isRealMobile", true);
        ltOptions.put("platformName", "Android");
        ltOptions.put("build", "Java - Android");
        ltOptions.put("name", "Sample Test Java-Android");
        ltOptions.put("w3c", true);
        ltOptions.put("video", true);
        ltOptions.put("visual", true);
        ltOptions.put("smartUI.project", "Real-Device-Project-Android");  // Enter your smartUI Project name
        capabilities.setCapability("lt:options", ltOptions);

        AppiumDriver driver = new AppiumDriver(
                new URL("https://"+userName+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub"), capabilities);
        try {
            driver.findElement(AppiumBy.id("com.lambdatest.proverbial:id/color")).click();

            //Changes the text to proverbial
            driver.findElement(AppiumBy.id("com.lambdatest.proverbial:id/Text")).click();

            //toast is visible
            driver.findElement(AppiumBy.id("com.lambdatest.proverbial:id/toast")).click();

            //notification is visible
            driver.findElement(AppiumBy.id("com.lambdatest.proverbial:id/notification")).click();

            //takes back to home page
            driver.findElement(AppiumBy.accessibilityId("Home")).click();
            driver.navigate().back();
            Thread.sleep(2000);

            //Takes to speed test page
            driver.findElement(AppiumBy.id("com.lambdatest.proverbial:id/speedTest")).click();
            Thread.sleep(5000);
            driver.navigate().back();

            driver.executeScript("smartui.takeScreenshot=<Name of your Screenshot>");
            System.out.println("Screenshot Captured");
            driver.quit();
            
        } catch (AssertionError a) {
         //  ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
            a.printStackTrace();
        }
    }
}


