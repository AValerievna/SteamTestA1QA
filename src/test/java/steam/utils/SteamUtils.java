package steam.utils;

import steam.forms.SecondAgeCheckPage;

public class SteamUtils {
    public  static void doFirstAgePageCheck(){

    }
    public static void doSecondAgePageCheck(){
        SecondAgeCheckPage objSecAgePage = new SecondAgeCheckPage();
        objSecAgePage.submitAge();
    }
}
