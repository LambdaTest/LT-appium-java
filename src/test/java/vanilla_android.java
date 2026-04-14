import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class vanilla_android {

    public static String userName = System.getenv("LT_USERNAME") == null ? "utkarshblambdatest" : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "YOUR_ACTUAL_KEY" : System.getenv("LT_ACCESS_KEY");

    public AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();

        ltOptions.put("deviceName", "Galaxy.*");
        ltOptions.put("platformVersion", "14");
        ltOptions.put("platformName", "Android");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("app", "<your_app_id>");
        ltOptions.put("deviceOrientation", "PORTRAIT");
        ltOptions.put("build", "Java Vanilla - Android");
        ltOptions.put("name", "Sample Test Java");
        ltOptions.put("console", true);
        ltOptions.put("autoGrantPermissions", true);
        ltOptions.put("visual", true);
        ltOptions.put("devicelog", true);

        capabilities.setCapability("lt:options", ltOptions);

        String hub = "https://" + userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub";
        driver = new AndroidDriver(new URL(hub), capabilities);
    }

    @Test
    public void basicTest() throws InterruptedException {
        try {
            // Updated to AppiumBy.id
            WebElement color = driver.findElement(AppiumBy.id("com.lambdatest.proverbial:id/color"));
            color.click();

            WebElement text = driver.findElement(AppiumBy.id("com.lambdatest.proverbial:id/Text"));
            text.click();

            WebElement toast = driver.findElement(AppiumBy.id("com.lambdatest.proverbial:id/toast"));
            toast.click();

            WebElement notification = driver.findElement(AppiumBy.id("com.lambdatest.proverbial:id/notification"));
            notification.click();

            WebElement geo = driver.findElement(AppiumBy.id("com.lambdatest.proverbial:id/geoLocation"));
            geo.click();
            Thread.sleep(5000);

            driver.navigate().back();
            Thread.sleep(2000);

            WebElement speedtest = driver.findElement(AppiumBy.id("com.lambdatest.proverbial:id/speedTest"));
            speedtest.click();
            Thread.sleep(5000);

            driver.navigate().back();

            // Updated to AppiumBy.accessibilityId (note the lowercase 'a')
            WebElement browser = driver.findElement(AppiumBy.accessibilityId("Browser"));
            browser.click();

            WebElement url = driver.findElement(AppiumBy.id("com.lambdatest.proverbial:id/url"));
            url.sendKeys("https://www.lambdatest.com");

            WebElement find = driver.findElement(AppiumBy.id("com.lambdatest.proverbial:id/find"));
            find.click();

            ((JavascriptExecutor) driver).executeScript("lambda-status=passed");
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}