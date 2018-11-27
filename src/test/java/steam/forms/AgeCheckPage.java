package steam.forms;

import framework.BasePage;

import static framework.BaseTest.conf;

public class AgeCheckPage extends BasePage {
    public AgeCheckPage() {
        super(conf.getProperty("responsive.page.class.ident"));
    }
}
