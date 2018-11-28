package framework;


import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.logging.Logger;

/**
 * Common for tests
 */
public class BaseTest {
    public static Configuration conf;
    public static LangConfiguration langConf;
    protected static Logger log;

    @BeforeTest
    public void setupTest() throws Exception {
        log = Logger.getGlobal();
        conf = new Configuration();
        langConf = new LangConfiguration(conf.getProperty("locale"));
        Browser.getWebDriverInstance();
        System.out.println(new File(conf.getProperty("downloads.dir.path") + conf.getProperty("SteamSetup.exe")).delete());
//        FileUtils.cleanDirectory(new File(conf.getProperty("downloads.dir.path")));
    }

    @AfterTest
    public void teardownTest() {
        Browser.stopBrowser();
    }
}
