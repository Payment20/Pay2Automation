package listeners;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import automationPayment20.MonitoringMail;
import automationPayment20.Utilities;
import pagebase.Page;

/**
 * @author Yary Perez <yfraga@revopay.com>
 * @version 1.2.0
 */
public class listeners extends Page implements ITestListener, ISuiteListener {

	public String messageBody;

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

		Page.log.debug(arg0.getName() + " Test Completed");
		Reporter.log(arg0.getName() + " Test Completed");

		// Utilities.zip(System.getProperty("user.dir") +
		// "\\target\\surefire-reports\\html");
		/*
		 * MonitoringMail mail = new MonitoringMail(); try {
		 * mail.sendMail(MonitoringMail.server, MonitoringMail.from, MonitoringMail.to,
		 * MonitoringMail.subject, MonitoringMail.messageBody,
		 * MonitoringMail.attachmentPath,MonitoringMail.attachmentName ); } catch
		 * (AddressException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (MessagingException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

		Page.log.debug(arg0.getName() + " Test Start");
		Reporter.log(arg0.getName() + " Test Start");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ISuite arg0) {

		emailMessage.add("Test Started: " + d.toString());
		totalSuitsExecuted++;
		Page.log.debug(arg0.getName() + " Start");
		Reporter.log(arg0.getName() + " Start");

	}

	public void onFinish(ISuite suite) {

		emailMessage.add(suite.getName() + " Execution Completed");
		Page.log.debug(suite.getName() + " Completed");
		Reporter.log(suite.getName() + " Completed");
		// Send email
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		MonitoringMail mail = new MonitoringMail();
		try {
			mail.sendMail(MonitoringMail.server, MonitoringMail.from, MonitoringMail.to, MonitoringMail.subject,
					MonitoringMail.messageBody, MonitoringMail.attachmentPath, MonitoringMail.attachmentName);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestStart(ITestResult result) {

		totalTestExecuted++;
		emailMessage.add(result.getName() + " Run");
		Page.log.debug(result.getName() + "  Started");
		Reporter.log(result.getName() + "  Started");

		test = report.startTest(result.getName().toUpperCase());

	}

	public void onTestSuccess(ITestResult result) {

		totalTestPassed++;
		emailMessage.add(result.getName() + " Successfully passed");
		Page.log.debug(result.getName() + "  Successfully passed");
		Reporter.log(result.getName() + " Successfully passed");
		test.log(LogStatus.PASS, result.getName().toUpperCase() + " PASS");
		report.endTest(test);
		report.flush();

	}

	public void onTestFailure(ITestResult result) {

		totalTestFailed++;
		emailMessage.add(result.getName() + " Failed");
		Page.log.debug(result.getName() + "  Failed");
		Reporter.log(result.getName() + "  Failed");

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.log(LogStatus.FAIL, result.getName().toUpperCase() + " Failed with exception : " + result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));

		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName
				+ " height=200 width=200></img></a>");

		report.endTest(test);
		report.flush();
	}

	public void onTestSkipped(ITestResult result) {

		emailMessage.add(result.getName() + " Skkiped");
		Page.log.debug(result.getName() + " Skkiped");
		Reporter.log(result.getName() + " Skkiped");
		test.log(LogStatus.SKIP, result.getName().toUpperCase() + " Skipped the test");
		report.endTest(test);
		report.flush();

	}

}
