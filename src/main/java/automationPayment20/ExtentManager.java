package automationPayment20;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

/**
 * @author Yary Perez <yfraga@revopay.com>
 * @version 1.2.0
 */
public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {

			extent = new ExtentReports(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\extent.html",
					true, DisplayOrder.OLDEST_FIRST);

			extent.loadConfig(new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));

		}

		return extent;

	}

}
