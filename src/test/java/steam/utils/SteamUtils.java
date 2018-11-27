package steam.utils;

import steam.forms.FirstAgeCheckPage;
import steam.forms.SecondAgeCheckPage;

import static framework.BaseTest.conf;

public class SteamUtils {
    public  static void doFirstAgePageCheck(){
        FirstAgeCheckPage objAgeCheck = new FirstAgeCheckPage();
        objAgeCheck.inputValidData(conf.getProperty("day"), conf.getProperty("month"), conf.getProperty("year"));
    }
    public static void doSecondAgePageCheck(){
        SecondAgeCheckPage objSecAgePage = new SecondAgeCheckPage();
        objSecAgePage.submitAge();
    }
}
