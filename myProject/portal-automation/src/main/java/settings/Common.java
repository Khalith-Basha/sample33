package settings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common extends RunFeatures {

	public static void setText(WebElement element, String input) {
		Common.explicitWait_Clickable(element, 60).click();
		element.clear();
		element.sendKeys(input);
	}

	public static boolean isElementDisplayed(WebElement element) {
		boolean retValue = false;
		try {
			if (Common.explicitWait_Displayed(element, 60).isDisplayed()) {
				retValue = true;
			}
		} catch (Exception e) {
			retValue = false;
		}
		return retValue;
	}

	public static void simpleWait(int sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static WebElement explicitWait_Clickable(WebElement reqValue, int reqTime) {
		WebDriverWait wait = new WebDriverWait(driver, reqTime);
		return wait.until(ExpectedConditions.elementToBeClickable(reqValue));
	}

	public static WebElement explicitWait_Displayed(WebElement reqValue, int reqTime) {
		WebDriverWait wait = new WebDriverWait(driver, reqTime);
		return wait.until(ExpectedConditions.visibilityOf(reqValue));
	}

}
