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
    protected static Logger log;

    @BeforeTest
    public void setupTest() throws Exception {
        log = Logger.getGlobal();
        conf = new Configuration();
        Browser.getWebDriverInstance();
        FileUtils.cleanDirectory(new File(conf.getProperty("downloads.dir.path")));
    }

    @AfterTest
    public void teardownTest() {
        Browser.stopBrowser();
    }
}
