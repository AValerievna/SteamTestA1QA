package framework;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import framework.enums.BrowserTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static framework.BaseTest.conf;


public class Browser {
    private static WebDriverWait browserWait;
    private static WebDriver browser;

    public static synchronized WebDriver getWebDriverInstance() {
        if (null == browser) {
            switch (BrowserTypes
                    .valueOf(conf
                            .getProperty("browser"))) {
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", conf.getProperty("gecko.driver.path"));
                    FirefoxOptions opts = new FirefoxOptions();
                    opts.addPreference("browser.download.folderList", 2);
                    opts.addPreference("browser.download.manager.showWhenStarting", false);
                    opts.addPreference("browser.download.dir", conf.getProperty("download.dir"));
                    opts.addPreference("browser.helperApps.neverAsk.saveToDisk", conf.getProperty("firefox.never.ask.type"));
                    browser = new FirefoxDriver(opts);
                    break;
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", conf.getProperty("chrome.driver.path"));
                    ChromeOptions chromeOpts = new ChromeOptions();
                    Map<String, Object> chromePrefs = new HashMap<>();
                    chromePrefs.put("download.default_directory", conf.getProperty("download.dir"));
                    chromePrefs.put("download.prompt_for_download", false);
                    chromePrefs.put("download.directory_upgrade", true);
                    chromePrefs.put("safebrowsing.enabled", true);
                    chromeOpts.setExperimentalOption(  "prefs", chromePrefs);
                    browser = new ChromeDriver();
                    break;
                default:
                    break;
            }
            browser.manage().timeouts().implicitlyWait(conf.getIntProperty("timeouts"), TimeUnit.SECONDS);
            browser.manage().window().maximize();
            browserWait = new WebDriverWait(browser, conf.getIntProperty("default.time.out"));

        }
        return browser;
    }

    public static WebDriverWait getWebDriverWaitInstance() {
        if (browserWait == null || null == browser) {
            throw new IllegalStateException();
        } else {
            return browserWait;
        }
    }

    static synchronized void stopBrowser() {
        if (null != browser) {
            browser.quit();
        }
        browser = null;
        browserWait = null;
    }

    public static void getPage(String url) {
        browser.get(url);
    }

    public static void refreshBr() {
        browser.navigate().refresh();
    }

    protected static <V> void waitElement(java.util.function.Function<? super WebDriver, V> isTrue) {
        getWebDriverWaitInstance().until(isTrue);
    }

    public static <T> Wait<T> getFluentWait(T t) {
        if (null == browser) {
            throw new IllegalStateException();
        }
        return new FluentWait<>(t)
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofMillis(conf.getIntProperty("duration")))
                .withTimeout(Duration.ofSeconds(conf.getIntProperty("duration.per")));
    }

    public static Wait<WebDriver> getFluentWait() {
        return getFluentWait(browser);
    }
}