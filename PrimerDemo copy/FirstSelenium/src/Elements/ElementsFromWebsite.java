package Elements;

import org.openqa.selenium.By;

public class ElementsFromWebsite {

	//this is the page https://codepen.io/bbodine1/pen/DqdMRy
	
	public static String checkbox2() {
		String Checkbox2 = "//div[contains(@class, 'ondisplay')]/section[2]/div/label";
		return Checkbox2;
	}
	
	public static String estadoCheckBox2() {
		String estadocheckbox = "//div[contains(@class, 'ondisplay')]/section[2]/div/input";
		return estadocheckbox;
	}
	
}
