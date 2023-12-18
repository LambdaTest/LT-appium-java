
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class smartui_androidweb {
    public static String userName = System.getenv("LT_USERNAME") == null ? "Your LT Username" // Add username here
            : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" // Add accessKey here
            : System.getenv("LT_ACCESS_KEY");
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("deviceName", "Galaxy S21+ 5G");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("platformVersion", "12");
        ltOptions.put("platformName", "Android");
        ltOptions.put("deviceOrientation", "PORTRAIT");
        ltOptions.put("build", "Java - Android-Web");
        ltOptions.put("name", "Sample Test Java-Android");
        ltOptions.put("w3c", true);
        ltOptions.put("video", true);
        ltOptions.put("visual", true);
        ltOptions.put("network", true);
        ltOptions.put("project", "Appium-Java-Real-Device");  // Enter your project name   
        ltOptions.put("smartUI.project", "Real_Device_Project");  // Enter your smartUI Project name 
        capabilities.setCapability("lt:options", ltOptions);


        AppiumDriver driver = new AppiumDriver(
                new URL("https://"+userName+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub"),
                capabilities);
        try {
            driver.get("https://www.lambdatest.com/");
            Thread.sleep(10000);
            driver.executeScript("smartui.takeScreenshot=<Name of your Screenshot>");
            System.out.println("Screenshot Captured");

            driver.quit();
        } catch (AssertionError a) {
         //  ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
            a.printStackTrace();
        }
    }
}


