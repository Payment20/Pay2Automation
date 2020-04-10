package automationPayment20;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.relevantcodes.extentreports.LogStatus;

import pagebase.Page;

/**
 * @author Yary Perez <yfraga@revopay.com>
 * @version 1.2.0
 */
public class MonitoringMail extends Page {

	public static String server = "smtp.gmail.com";
	public static String from = "revopayautomation@gmail.com";
	public static String password = "Automation2018$";
//	public static String[] to ={"dsilveira@revopay.com", "dberman@revopay.com", "danielaberman@gmail.com", "tmaas@revopay.com","jshiqder@revopay.com", "saguilar@revopay.com", "hmusturi@revopay.com", "scrivello@revopay.com"};
	public static String[] to = { "test@revopay.com"};
	public static String subject = "Test Report " + d.toString();
	public static String currentDate = System.getProperty("current.date");
	public static String messageBody = "";
	public static String attachmentPath = System.getProperty("user.dir")
			+ "//src//test//resources//logs//Application.log";
	// public static String
	// attachmentPath=System.getProperty("user.dir")+"//src//test//resources//logs//Application_"+
	// currentDate +"_log.log";
	public static String attachmentName = "Application_" + currentDate + "_log.log";

	// public static void sendMail(String mailServer, String from,String username,
	// String password,String port, String[] to, String subject, String messageBody,
	// String attachmentPath, String attachmentName) throws MessagingException,
	// AddressException
	public void sendMail(String mailServer, String from, String[] to, String subject, String messageBody,
			String attachmentPath, String attachmentName) throws MessagingException, AddressException {

		boolean debug = false;
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.host", mailServer);
		props.put("mail.debug", "true");

		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");

		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, auth);

		session.setDebug(debug);

		try {

			Transport bus = session.getTransport("smtp");
			bus.connect();
			Message message = new MimeMessage(session);

			// X-Priority values are generally numbers like 1 (for highest priority), 3
			// (normal) and 5 (lowest).

			message.addHeader("X-Priority", "1");
			message.setFrom(new InternetAddress(from));
			InternetAddress[] addressTo = new InternetAddress[to.length];
			for (int i = 0; i < to.length; i++)
				addressTo[i] = new InternetAddress(to[i]);
			message.setRecipients(Message.RecipientType.TO, addressTo);
			message.setSubject(subject);

			for (int i = 0; i < emailMessage.size(); i++) {

				messageBody = messageBody + emailMessage.get(i) + "<br>";
			}

			messageBody += "<br>----------------------------------------------------<br>";
			messageBody += "Total Suits Executed: " + totalSuitsExecuted + "<br>";
			messageBody += "Total Test Executed: " + totalTestExecuted + "<br>";
			messageBody += "Total Test Failed: " + totalTestFailed + "<br>";
			messageBody += "Total Test Passed: " + totalTestPassed + "<br>";

			BodyPart body = new MimeBodyPart();
			body.setText(messageBody);
			body.setContent(messageBody, "text/html");

			BodyPart attachment = new MimeBodyPart();
			DataSource source = new FileDataSource(attachmentPath);
			attachment.setDataHandler(new DataHandler(source));
			attachment.setFileName(attachmentName);
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(body);
			multipart.addBodyPart(attachment);
			message.setContent(multipart);
			Transport.send(message);
			// System.out.println("Sucessfully Sent mail to All Users");
			log.debug("Sucessfully Sent mail to All Users");
			test.log(LogStatus.INFO, "Sucessfully Sent mail to All Users");
			bus.close();

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {

		public PasswordAuthentication getPasswordAuthentication() {
			String username = from;
			String pass = password;
			return new PasswordAuthentication(username, pass);
		}
	}

}
