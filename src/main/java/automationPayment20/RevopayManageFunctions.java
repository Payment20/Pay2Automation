package automationPayment20;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.relevantcodes.extentreports.LogStatus;

import pagebase.Page;

/**
 * @author Yary Perez <yfraga@revopay.com>
 * @version 1.2.0
 */
public class RevopayManageFunctions extends Page {

	ResultSet resultSet1;
	String query1;
	String property_id = config.getProperty("property_id");
	String settings_key = config.getProperty("settings_key");
	String web_user_id = config.getProperty("active_trans_web_user_id");
	String web_user_account = config.getProperty("activeaccnumber");

	// -------------------CREDENTIALS------------------------------------------

	/**
	 * Auxiliary Method. Get the credentials for the property.
	 * <p>
	 * Query the merchant credentials taking in account the payment method and
	 * payment type.
	 * </p>
	 * 
	 * @param Numeric value for recurring payment. Expected values: 0,1. String
	 *                value for payment method. Expected values: cc,ec,amex.
	 * @return True if found merchant credentials, otherwise false.
	 * @author Yary.Perez
	 */
	public boolean getCredentials(String payment_method, int is_recurring) throws SQLException {

		boolean credentials = false;
		query1 = "SELECT * FROM merchant_account where property_id = '" + property_id + "' and payment_method = '"
				+ payment_method + "' and is_recurring = " + is_recurring + ";";
		// System.out.println(query1);
		// Page.connectionDB.openConnection();
		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);
		// System.out.println(resultSet1.first());

		if (resultSet1.first()) {

			// System.out.println("Entre al if");

			Page.log.debug("Credentials found for Web: " + payment_method + ", recurring: " + is_recurring);
			// Page.connectionDB.closeConnection();
			return credentials = true;

		} else {
			// System.out.println("Entre al else");

			Page.log.debug("No credentials found for: " + payment_method + ", recurring: " + is_recurring);
			// Page.connectionDB.closeConnection();
			return credentials;
		}

	}

	/**
	 * Auxiliary Method. Get the payments limits for the property.
	 * <p>
	 * Query the merchant credentials to find the payments limits taking in account
	 * the payment type.
	 * </p>
	 * 
	 * @param Numeric value for recurring payment. Expected values: 0,1. String
	 *                value for payment method, expected value CC/EC
	 * @return String array with the credentials limits. Expected values: lowpay
	 *         range in [0], highpay range in [1]
	 * @author Yary.Perez
	 */
	public String[] getLimits(int recurring, String paymentMethod) throws SQLException {

		// lowpay range in [0]
		// highpay range in [1]
		// recurring 0 or 1

		String limits[] = new String[2];

		query1 = "SELECT low_pay_range FROM revopay_manage.merchant_account WHERE property_id = '" + property_id
				+ "' and is_recurring = '" + recurring + "' and payment_method = '" + paymentMethod
				+ "'  and  low_pay_range = (SELECT MIN(low_pay_range) FROM revopay_manage.merchant_account WHERE property_id = '"
				+ property_id + "' and is_recurring = '" + recurring + "' and payment_method = '" + paymentMethod
				+ "');";

		// Page.connectionDB.openConnection();

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		resultSet1.next();

		limits[0] = resultSet1.getString("low_pay_range");

		query1 = "SELECT high_pay_range FROM revopay_manage.merchant_account WHERE property_id = '" + property_id
				+ "' and is_recurring = '" + recurring + "' and payment_method = '" + paymentMethod
				+ "' and  high_pay_range = (SELECT MAX(high_pay_range) FROM revopay_manage.merchant_account WHERE property_id = '"
				+ property_id + "' and is_recurring = '" + recurring + "' and payment_method = '" + paymentMethod
				+ "');";

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		resultSet1.next();

		limits[1] = resultSet1.getString("high_pay_range");

		// System.out.println(limits[0]);
		// System.out.println(limits[1]);

		// Page.connectionDB.closeConnection();

		return limits;

	}

	/**
	 * Auxiliary Method. Remove the merchant credentials.
	 * <p>
	 * This function doesn't remove the just change the property id to 13045111,
	 * then system "understand" that 13045 doesn't have credentials
	 * </p>
	 * 
	 * @author Dayana.Silveira
	 */
	public void removeCredentials() throws SQLException {

		/*
		 * this function doesn't remove the just change the property id to 13045111 then
		 * system "understand" that 13045 doesn't have credentials this property_id
		 * 13045111 doesn't exist
		 */

		query1 = "SELECT property_id FROM merchant_account where property_id = '" + property_id + "';";

		// Page.connectionDB.openConnection();

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.next()) {

			query1 = "UPDATE merchant_account SET property_id = 13045111 WHERE (property_id = '" + property_id + "');";
			Page.connectionDB.getStatement().executeUpdate(query1);
			// Page.connectionDB.closeConnection();
			Page.log.debug("Removed credentials for merchant with property_id: " + property_id);

		} else {

			// Page.connectionDB.closeConnection();
			Page.log.debug("property_id: " + property_id + " doesn't have any creadetials");

		}

	}

	/**
	 * Auxiliary Method. Restore the merchant credentials.
	 * <p>
	 * This function restore the credentials to property id 13045 / 13008.
	 * </p>
	 * 
	 * @author Dayana.Silveira
	 */
	public void restoreCredentials() throws SQLException {

		query1 = "SELECT property_id FROM merchant_account where property_id = 13045111;";

	

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.next()) {

			query1 = "UPDATE merchant_account SET property_id = '" + property_id + "' WHERE (property_id = 13045111);";
			Page.connectionDB.getStatement().executeUpdate(query1);
			Page.log.debug("Restored credentials for merchant with property_id: " + property_id);

		} else {

			Page.log.debug("property_id: " + property_id + " doesn't have any creadetials");

		}
	}

	/**
	 * Auxiliary Method. Show the credentials used to test convenience fee for a
	 * payment.
	 * <p>
	 * Method restore the credentials to property 13045 from the cfee credentials
	 * changing property_id 13045222 to 13045.
	 * </p>
	 * 
	 * @author Yary.Perez
	 */
	public void showCfeeCredentials() throws SQLException {

		query1 = "SELECT property_id FROM merchant_account where property_id = 13045222;";

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.next()) {

			query1 = "UPDATE merchant_account SET property_id = '" + property_id + "' WHERE (property_id = 13045222);";
			Page.connectionDB.getStatement().executeUpdate(query1);

			Page.log.debug("Using cfee credentials for test for merchant with property_id: " + property_id);

		} else {

			Page.log.debug("property_id: " + property_id + " doesn't have cfee credentials to be restored");

		}

		query1 = "UPDATE card_type_fee SET id_property = '" + property_id + "' WHERE (id_property = 13045222);";
		Page.connectionDB.getStatement().executeUpdate(query1);

	}

	/**
	 * Auxiliary Method. Hide the credentials used to test convenience fee for a
	 * payment.
	 * <p>
	 * Method hide the credentials to property 13045 from the cfee credentials
	 * changing property_id 13045 to 13045222.
	 * </p>
	 * 
	 * @author Yary.Perez
	 */
	public void hideCfeeCredentials() throws SQLException {

		query1 = "SELECT property_id FROM merchant_account where property_id = '" + property_id + "';";

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.next()) {

			query1 = "UPDATE merchant_account SET property_id = 13045222 WHERE (property_id = '" + property_id + "');";
			Page.connectionDB.getStatement().executeUpdate(query1);
			Page.log.debug("Hidden cfee credentials for test for merchant with property_id: " + property_id);

		} else {

			Page.log.debug("property_id: " + property_id + " doesn't have cfee credentials to be hiden.");

		}

		query1 = "UPDATE card_type_fee SET id_property = 13045222 WHERE (id_property = '" + property_id + "');";
		Page.connectionDB.getStatement().executeUpdate(query1);

	}

	/**
	 * Auxiliary Method. Generate a random value for cfee.
	 * <p>
	 * </p>
	 * 
	 * @author Yary.Perez
	 */
	public double generateCfee() {

		double cfee = Math.random() * 2;
		String str = String.format("%1.2f", cfee);
		cfee = Double.valueOf(str.replace(",", "."));

		return cfee;
	}

	/**
	 * Auxiliary Method. Generate a random value for cfee.
	 * <p>
	 * </p>
	 * 
	 * @author Yary.Perez
	 */
	public double generateFloatCfee() {

		double cfee = (int) (Math.random() * 10 + 1);
		String str = String.format("%1.2f", cfee);
		double floatfee = Double.valueOf(str.replace(",", "."));

		return floatfee;
	}

	/**
	 * Auxiliary Method. Get the convenience fee for a payment Amount from config file.
	 * <p>
	 * Method query the database to get the cfee value for a payment taking in
	 * account the payment method and type.
	 * </p>
	 * 
	 * @param String value for payment method and payment type. Numeric value for
	 *               recurring. Valid Card Types
	 * 
	 *               Master Card Debit----mcdb Master Card Credit---mcc Visa
	 *               Debit----vdb Visa Credit---vc Discover Debit----ddb Discover
	 *               Credit---dc
	 * 
	 *               Valid Payment Methods
	 * 
	 *               Amex---amex Credit Card---cc Echeck----ec
	 * 
	 *               Recurring 0 Recurring 1 (Fixed and DRP)
	 * 
	 * @return Double with the convenience fee value.
	 * @author Yary.Perez
	 */
	public double getConvenienceFee(String paymentMethod, int recurring, String cardType) throws SQLException {

		/*
		 * Valid Card Types
		 * 
		 * Master Card Debit----mcdb Master Card Credit---mcc Visa Debit----vdb Visa
		 * Credit---vc Discover Debit----ddb Discover Credit---dc
		 * 
		 * Valid Payment Methods
		 * 
		 * Amex---amex Credit Card---cc Echeck----ec
		 * 
		 * Recurring 0 Recurring 1 (Fixed and DRP)
		 * 
		 */

		double cfee = 0;
		double cfeeFloat = 0;
		double cfeeTotal = 0;

		double low_pay_range = 0;
		double high_pay_range = 0;

		String merchantAccId = "";
		ResultSet cardTypecredentials;
		boolean is_cardType = false;

		double configAmount = Double.parseDouble(categoryAmount);
		System.out.println("Config amount in get convenience fee: " + configAmount);

		query1 = "SELECT * FROM merchant_account where property_id = '" + property_id + "' and payment_method = '"
				+ paymentMethod + "' and is_recurring = '" + recurring + "';";

		// Page.connectionDB.openConnection();
		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		// System.out.println(resultSet1.first());

		while (resultSet1.next()) {

			// System.out.println("Entre al while");
			low_pay_range = Double.parseDouble(resultSet1.getString("low_pay_range"));
			// System.out.println(low_pay_range);
			high_pay_range = Double.parseDouble(resultSet1.getString("high_pay_range"));
			// System.out.println(high_pay_range);

			if (configAmount >= low_pay_range && configAmount <= high_pay_range) {
				// System.out.println("Entre al if");
				log.debug("Payment amount between: " + low_pay_range + " and " + high_pay_range);
				test.log(LogStatus.INFO, "Payment amount between: " + low_pay_range + " and " + high_pay_range);

				merchantAccId = resultSet1.getString("merchant_account_id");
				// System.out.println(merchantAccId);
				String query2 = "SELECT * FROM card_type_fee where id_property = '" + property_id
						+ "' and id_merchant_account = '" + merchantAccId + "' and type = '" + cardType + "';";
				cardTypecredentials = Page.connectionDB.getStatement().executeQuery(query2);

				while (cardTypecredentials.next()) {

					is_cardType = true;
					log.debug("Found cfee per card type : " + cardType);
					test.log(LogStatus.INFO, "Found cfee per card type : " + cardType);
					cfee = Double.parseDouble(cardTypecredentials.getString("convenience_fee"));
					cfeeFloat = Double.parseDouble(cardTypecredentials.getString("convenience_fee_float"));

					if (cfeeFloat != 0) {

						cfeeTotal = cfee + ((configAmount * cfeeFloat) / 100);

					} else {

						cfeeTotal = cfee;
					}
				}

				if (!is_cardType) {

					cfee = Double.parseDouble(resultSet1.getString("convenience_fee"));
					cfeeFloat = Double.parseDouble(resultSet1.getString("convenience_fee_float"));

					if (cfeeFloat != 0) {

						cfeeTotal = cfee + ((configAmount * cfeeFloat) / 100);

					} else {

						cfeeTotal = cfee;
					}
				}

			}

		}

		// Page.connectionDB.closeConnection();
		log.debug("Convenience fee for " + paymentMethod + " recurring: " + recurring + " is: " + cfeeTotal);
		test.log(LogStatus.INFO,
				"Convenience fee for " + paymentMethod + " recurring: " + recurring + " is: " + cfeeTotal);

		DecimalFormat df2 = new DecimalFormat("0.00");
		// df2.setRoundingMode(RoundingMode.UP);
		cfeeTotal = Double.parseDouble(df2.format(cfeeTotal).replace(",", "."));
		System.out.println(cfeeTotal);
		return cfeeTotal;

	}

	/**
	 * Auxiliary Method. Set the convenience fee for a payment.
	 * <p>
	 * Method query the database to set the cfee value for a payment taking in
	 * account the payment method and type.
	 * </p>
	 * 
	 * @param String value for payment method and payment type. Numeric value for
	 *               recurring. Valid Card Types
	 * 
	 *               Master Card Debit----mcdb Master Card Credit---mcc Visa
	 *               Debit----vdb Visa Credit---vc Discover Debit----ddb Discover
	 *               Credit---dc
	 * 
	 *               Valid Payment Methods
	 * 
	 *               Amex---amex Credit Card---cc Echeck----ec
	 * 
	 *               Recurring 0 Recurring 1 (Fixed and DRP)
	 * 
	 * @author Yary.Perez
	 * @throws SQLException
	 */
	public void setConvenienceFee(String paymentMethod, int recurring, String cardType, int cFeeType)
			throws SQLException {

		// 1-convenience_fee
		// 2-convenience_fee_float
		// 3-convenience_fee + convenience_fee_float
		// 4-convenience_fee_drp
		// 5-convenience_fee_float_drp
		// 6-convenience_fee_drp + convenience_fee_float_drp

		double convenience_fee = 0;
		double convenience_fee_float = 0;
		double convenience_fee_drp = 0;
		double convenience_fee_float_drp = 0;
		String query = "";

		switch (cFeeType) {

		case 1:

			convenience_fee = generateCfee();
			// System.out.println(convenience_fee);

			if (!cardType.equalsIgnoreCase("n/a")) {

				query1 = "UPDATE card_type_fee SET convenience_fee = '" + convenience_fee
						+ "', convenience_fee_float = '" + convenience_fee_float + "' WHERE id_property = '"
						+ property_id + "' and type = '" + cardType + "';";

			} else {

				query = "UPDATE card_type_fee SET id_property = '13045222' WHERE id_property = '" + property_id + "';";
				Page.connectionDB.getStatement().executeUpdate(query);
				query1 = "UPDATE merchant_account SET convenience_fee = '" + convenience_fee
						+ "', convenience_fee_float = '" + convenience_fee_float + "' WHERE property_id = '"
						+ property_id + "' and payment_method = '" + paymentMethod + "' and is_recurring = '"
						+ recurring + "';";
				System.out.println(query1);

			}
			break;

		case 2:

			convenience_fee_float = generateFloatCfee();
			// System.out.println(convenience_fee_float);

			if (!cardType.equalsIgnoreCase("n/a")) {

				query1 = "UPDATE card_type_fee SET convenience_fee = '" + convenience_fee
						+ "', convenience_fee_float = '" + convenience_fee_float + "' WHERE id_property = '"
						+ property_id + "' and type = '" + cardType + "';";

			} else {

				query = "UPDATE card_type_fee SET id_property = '13045222' WHERE id_property = '" + property_id + "';";
				Page.connectionDB.getStatement().executeUpdate(query);
				query1 = "UPDATE merchant_account SET convenience_fee = '" + convenience_fee
						+ "', convenience_fee_float = '" + convenience_fee_float + "' WHERE property_id = '"
						+ property_id + "' and payment_method = '" + paymentMethod + "' and is_recurring = '"
						+ recurring + "';";
				System.out.println(query1);
			}
			break;

		case 3:

			convenience_fee = generateCfee();
			convenience_fee_float = generateCfee();
			// System.out.println(convenience_fee);
			// System.out.println(convenience_fee_float);

			if (!cardType.equalsIgnoreCase("n/a")) {

				query1 = "UPDATE card_type_fee SET convenience_fee = '" + convenience_fee
						+ "', convenience_fee_float = '" + convenience_fee_float + "' WHERE id_property = '"
						+ property_id + "' and type = '" + cardType + "';";

			} else {

				query = "UPDATE card_type_fee SET id_property = '13045222' WHERE id_property = '" + property_id + "';";
				Page.connectionDB.getStatement().executeUpdate(query);
				query1 = "UPDATE merchant_account SET convenience_fee = '" + convenience_fee
						+ "', convenience_fee_float = '" + convenience_fee_float + "' WHERE property_id = '"
						+ property_id + "' and payment_method = '" + paymentMethod + "' and is_recurring = '"
						+ recurring + "';";
				System.out.println(query1);
			}
			break;

		case 4:

			convenience_fee_drp = generateCfee();
			// System.out.println(convenience_fee_drp);

			if (!cardType.equalsIgnoreCase("n/a")) {

				query1 = "UPDATE card_type_fee SET convenience_fee_drp = '" + convenience_fee_drp
						+ "', convenience_fee_float_drp = '" + convenience_fee_float_drp + "' WHERE id_property = '"
						+ property_id + "' and type = '" + cardType + "';";

			} else {

				query = "UPDATE card_type_fee SET id_property = '13045222' WHERE id_property = '" + property_id + "';";
				Page.connectionDB.getStatement().executeUpdate(query);
				query1 = "UPDATE merchant_account SET convenience_fee_drp = '" + convenience_fee_drp
						+ "', convenience_fee_float_drp = '" + convenience_fee_float_drp + "' WHERE property_id = '"
						+ property_id + "' and payment_method = '" + paymentMethod + "' and is_recurring = '"
						+ recurring + "';";
				System.out.println(query1);
			}
			break;

		case 5:

			convenience_fee_float_drp = generateCfee();
			// System.out.println(convenience_fee_float_drp);

			if (!cardType.equalsIgnoreCase("n/a")) {

				query1 = "UPDATE card_type_fee SET convenience_fee_drp = '" + convenience_fee_drp
						+ "', convenience_fee_float_drp = '" + convenience_fee_float_drp + "' WHERE id_property = '"
						+ property_id + "' and type = '" + cardType + "';";

			} else {

				query = "UPDATE card_type_fee SET id_property = '13045222' WHERE id_property = '" + property_id + "';";
				Page.connectionDB.getStatement().executeUpdate(query);
				query1 = "UPDATE merchant_account SET convenience_fee_drp = '" + convenience_fee_drp
						+ "', convenience_fee_float_drp = '" + convenience_fee_float_drp + "' WHERE property_id = '"
						+ property_id + "' and payment_method = '" + paymentMethod + "' and is_recurring = '"
						+ recurring + "';";
				System.out.println(query1);
			}
			break;

		case 6:

			convenience_fee_drp = generateCfee();
			convenience_fee_float_drp = generateCfee();
			// System.out.println(convenience_fee_drp);
			// System.out.println(convenience_fee_float_drp);

			if (!cardType.equalsIgnoreCase("n/a")) {

				query1 = "UPDATE card_type_fee SET convenience_fee_drp = '" + convenience_fee_drp
						+ "', convenience_fee_float_drp = '" + convenience_fee_float_drp + "' WHERE id_property = '"
						+ property_id + "' and type = '" + cardType + "';";

			} else {

				query = "UPDATE card_type_fee SET id_property = '13045222' WHERE id_property = '" + property_id + "';";
				Page.connectionDB.getStatement().executeUpdate(query);
				query1 = "UPDATE merchant_account SET convenience_fee_drp = '" + convenience_fee_drp
						+ "', convenience_fee_float_drp = '" + convenience_fee_float_drp + "' WHERE property_id = '"
						+ property_id + "' and payment_method = '" + paymentMethod + "' and is_recurring = '"
						+ recurring + "';";
				System.out.println(query1);
			}
			break;

		}

		Page.connectionDB.getStatement().executeUpdate(query1);
		String testScenario = "Payment Method: " + paymentMethod + " Recurring: " + recurring + " CardType: " + cardType
				+ " Convenience fee combination:  " + cFeeType;
		System.out.println(testScenario);
		Page.log.debug("Updating cfee credentials for test scenario: " + testScenario);

	}

	// -------------------SETTINGS------------------------------------------
	/**
	 * Auxiliary Method. Get the value for a setting.
	 * <p>
	 * Query the merchant settings.
	 * </p>
	 * 
	 * @param Numeric value for recurring payment. Expected values: 0,1. String
	 *                value for payment method. Expected values: cc,ec,amex.
	 * @return True if found merchant credentials, otherwise false.
	 * @author Yary.Perez
	 */
	public String getSettingValue(String key) throws SQLException {
		
		String value = "";
		

		query1 = "SELECT value FROM settings_cache_values where settings_key = '" + settings_key
				+ "' and settings_cache_values.key = '" + key + "';";

		try {
			resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);
			if (resultSet1.first()) {
				value = resultSet1.getString(1);
				Page.log.debug("Setting value found for: " + key + ", value: " + value);
	
			} else {
				value = "No setting value found for: " + key;
				Page.log.debug("No setting value found for: " + key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;

	}

	/**
	 * Auxiliary Method. Set the value for a setting.
	 * <p>
	 * Set the merchant settings passed by parameters.
	 * </p>
	 * 
	 * @param String value for setting key. String value for the value of the
	 *               setting.
	 * @author Yary.Perez
	 */
	public void setSettingValue(String key, String value) throws SQLException {

		query1 = "SELECT value FROM settings_cache_values where settings_key = '" + settings_key
				+ "' and settings_cache_values.key = '" + key + "';";

		// Page.connectionDB.openConnection();

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.first()) {

			query1 = "UPDATE settings_cache_values SET value = '" + value + "' WHERE (`key` = '" + key
					+ "') and (`settings_key` = '" + settings_key + "');";
			Page.connectionDB.getStatement().executeUpdate(query1);
			// Page.connectionDB.closeConnection();
			Page.log.debug("Updated setting value for: " + key + " with value: " + value);

		} else {

			query1 = "INSERT INTO settings_cache_values (`key`, `value`, `settings_key`) VALUES ('" + key + "', '"
					+ value + "', '" + settings_key + "');";
			// System.out.println(query1);
			Page.connectionDB.getStatement().executeUpdate(query1);
			// Page.connectionDB.closeConnection();
			Page.log.debug("Inserted setting value for: " + key + " with value: " + value);

		}

	}

	/**
	 * Auxiliary Method. Return if a setting is present in the database.
	 * <p>
	 * Query the merchant settings passed by parameters and verify if is present for
	 * the merchant.
	 * </p>
	 * 
	 * @param String value for setting key.
	 * @return True if the setting is present and enabled, otherwise return false.
	 * @author Yary.Perez
	 */
	public boolean isSettingValue(String key) throws SQLException {

		boolean setting = true;

		query1 = "SELECT * FROM settings_cache_values where settings_key = '" + settings_key
				+ "' and settings_cache_values.key = '" + key + "';";

		// Page.connectionDB.openConnection();

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.first()) {

			// Page.connectionDB.closeConnection();
			Page.log.debug("Founded setting value for: " + key);
			return setting;

		} else {

			// Page.connectionDB.closeConnection();
			Page.log.debug("Not founded setting value for: " + key);
			return setting = false;

		}

	}

	// -------------------WEB USER------------------------------------------

	/**
	 * Auxiliary Method. Return the web user payments method stored in the database.
	 * <p>
	 * Return in an list the payments method stored in the database for a web user.
	 * </p>
	 * 
	 * @return Array List of String with all the payments profiles found for the
	 *         user.
	 * @author Yary.Perez
	 */
	public ArrayList<String> getWebserProfiles() throws SQLException {

		ArrayList<String> webUserProfile = new ArrayList<String>();

		query1 = "SELECT name,type FROM profiles where web_user_id = '" + web_user_id + "';";

		// Page.connectionDB.openConnection();

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.first()) {

			webUserProfile.add(resultSet1.getString("name") + " " + resultSet1.getString("type"));

			while (resultSet1.next()) {

				webUserProfile.add(resultSet1.getString("name") + " " + resultSet1.getString("type"));
			}

			// Page.connectionDB.closeConnection();
			Page.log.debug("Founded web user profile values for web_user_id: " + web_user_id);
			return webUserProfile;

		} else {

			// Page.connectionDB.closeConnection();
			Page.log.debug("Not founded web user profile values for web_user_id: " + web_user_id);
			return webUserProfile;
		}

	}

	/**
	 * Get Webuser status
	 * <p>
	 * check-in method. Get from database the webuser status. Search in: web_users
	 * table. The status can be: * 0: Inactive * 1: Active * 46: Locked * 998:
	 * Authorized * 999: Unauthorized * 9999: Deleted
	 * 
	 * </p>
	 *
	 * @author Dayana.Silveira
	 * @param accnumb Account number which will be searched in the database to get
	 *                the status
	 * @return int the webuser status is an Integer. The function will also returns
	 *         2: if not exist webuser. Not return 0 because 0 is a status. -1 if
	 *         the account number is empty
	 * @throws SQLException
	 */
	public int getWebuserStatus(String accnumb) throws SQLException {
		if ("".equals(accnumb)) {
			return -1;
		}

		int sizeresult = 0;

		/**
		 * by default 2 in case don't found the user below this merchant
		 */
		int status = 2;
		int aux = 9999;
		query1 = "SELECT web_status FROM web_users where account_number = '" + accnumb + "' AND property_id = '"
				+ property_id + "';";

		// Page.connectionDB.openConnection();

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.first()) {
			resultSet1.last();
			sizeresult = resultSet1.getRow();

			if (sizeresult > 1) {
				resultSet1.first();

				/** in case returns more than one records */
				do {

					/**
					 * Checking in case exist user deleted and other with "good" status. Very
					 * possible!!
					 */
					if (Integer.parseInt(resultSet1.getString("web_status")) == 9999) {
						continue;
					} else {
						aux = Integer.parseInt(resultSet1.getString("web_status"));
						break;
					}

				} while (resultSet1.next());

				status = aux;/**
								 * It's important because aux save 9999. In case don't found other "good" status
								 */

			} else {
				status = Integer.parseInt(resultSet1.getString("web_status"));
			}

			Page.log.debug("Found webuser by account number " + accnumb + "with status: " + status);
			// Page.connectionDB.closeConnection();

		} else {
			status = 2;
			// Page.connectionDB.closeConnection();
			Page.log.debug("Not founded web user with account number " + accnumb);
		}

		return status;

	}

	/**
	 * Get Webuser id
	 * <p>
	 * check-in method. Get the web_user_id for one account number given by
	 * parameter. Search in: web_users table. This function is useful to match with
	 * invoice.
	 * </p>
	 *
	 * @author Dayana.Silveira
	 * @param accnumb Account number which will be searched in the database to get
	 *                the web_user_id
	 * @return int the webuser id is an Integer. The function will also returns 0:
	 *         if not exist webuser by this account number, -1 if the account number
	 *         is empty
	 * @throws SQLException
	 */
	public int getWebuserId(String accnumb) throws SQLException {
		if ("".equals(accnumb)) {
			return -1;
		}

		int id = 0, aux = 0; /** by default 0 in case don't found the user below this merchant */

		query1 = "SELECT web_user_id FROM web_users where account_number = '" + accnumb + "' AND property_id = '"
				+ property_id + "';";

		// Page.connectionDB.openConnection();

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.first()) {
			aux = Integer.parseInt(resultSet1.getString("web_user_id"));
		}

		// in case return one or more records
		while (resultSet1.next()) {

			/**
			 * Checking in case exist user deleted and other with "good" status. Very
			 * possible!!
			 */
			if (Integer.parseInt(resultSet1.getString("web_status")) == 9999) {
				continue;
			} else {
				aux = Integer.parseInt(resultSet1.getString("web_user_id"));
				break;
			}

		}
		id = aux;

		if (id == 0) {
			// Page.connectionDB.closeConnection();
			Page.log.debug("Not founded web user with account number " + accnumb);
		} else {
			Page.log.debug("Found webuser by account number " + accnumb + "with web_user_id: " + id);
			// Page.connectionDB.closeConnection();
		}

		return id;

	}
	
	
	/**
	 * Get Webuser info
	 * <p>
	 * check-in method. Get all info assigned to a webuser for one account number given by
	 * parameter. Search in: web_users table. This function is useful to check the info shown in the view for the webuser specified.
	 * </p>
	 *
	 * @author Dayana.Silveira
	 * @param accnumb Account number which will be searched in the database to get
	 *                the web_user_id
	 * @return ResultSet the integer query result. In case accnumb is empty, function returns null
	 * @throws SQLException
	 */
	public ResultSet getWebuserInfo(String accnumb) throws SQLException {
		if ("".equals(accnumb)) {
			return null;
		}

		query1 = "SELECT * FROM web_users where account_number = '" + accnumb + "' AND web_status != 9999 AND property_id = '"
				+ property_id + "';";

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		
		if (resultSet1.first()) {
			Page.log.debug("Founded web user with account number: " + accnumb);
		} else {
			Page.log.debug("Not founded web user with account number: " + accnumb);
		}
		
		
		return resultSet1;	

	}
	
	
	/**
	 * Get Webuser account number
	 * <p>
	 * check-in method. Get web user account number assigned to a web_user_id given by parameter. 
	 * Search in: web_users table. This function is useful to check the info shown in the view for the invoice specified.
	 * </p>
	 *
	 * @author Dayana.Silveira
	 * @param userid web_user_id number which will be searched in the database to get the account number
	 * @return String account number for the web_user_id given
	 * @throws SQLException
	 */
	public String getWebuserAccNum(Integer userid) throws SQLException {
		String acc = null;
		
		if (userid == null) {
			return acc;
		}

		query1 = "SELECT * FROM web_users where web_user_id = '" + userid + "' AND property_id = '" + property_id + "';";

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		
		if (resultSet1.first()) {
			acc = resultSet1.getString("account_number");
			Page.log.debug("Founded web user id: " + userid);
		} else {
			Page.log.debug("Not founded web user id: " + userid);
		}
				
		return acc;	

	}
	
	
	/**
	 * Delete phone for an account number given
	 * <p>
	 * Restored method. This function is created to remove the phone number after it has been inserted.
	 * </p>
	 *
	 * @author Dayana.Silveira
	 * @param String account number
	 * @return void 
	 * @throws SQLException
	 */
	public void removePhone(String acc) throws SQLException {

		query1 = "Update web_users SET phone_number = '' WHERE account_number = '" + acc + "' AND property_id = '" + property_id + "';";

		Page.connectionDB.getStatement().executeUpdate(query1);
		
		Page.log.debug("Updated phone_number to value empty for the user with account number: " + acc);

	}
	
	/**
	 * Delete email for an account number given
	 * <p>
	 * Restored method. This function is created to remove the email after it has been inserted.
	 * </p>
	 *
	 * @author Dayana.Silveira
	 * @param String account number
	 * @return void 
	 * @throws SQLException
	 */
	public void removeEmail(String acc) throws SQLException {

		query1 = "Update web_users SET email_address = '' WHERE account_number = '" + acc + "' AND property_id = '" + property_id + "';";

		Page.connectionDB.getStatement().executeUpdate(query1);
		
		Page.log.debug("Updated email_address to value empty for the user with account number: " + acc);

	}
	
	/**
	 * User has or not phone number
	 * <p>
	 * Checking-method. Return if a giving user has or not phone number saved in database
	 * </p>
	 *
	 * @author Dayana.Silveira
	 * @param String account number
	 * @return boolean true: if user has phone number, false: if user doesn't have phone number
	 * @throws SQLException
	 */
	public boolean hasPhone(String acc) throws SQLException {

		String phone = "";
		
		query1 = "SELECT * FROM web_users where web_user_id = '" + acc + "' AND property_id = '" + property_id + "';";

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		
		if (resultSet1.first()) {
			phone = resultSet1.getString("phone_number");	
		
			Page.log.debug("Founded web user id: " + acc + " with phone: " + phone);		
		}
		System.out.println("\"\".contentEquals(phone): " + ("".contentEquals(phone)?false:true));
		System.out.println("phone: " + phone);
		System.out.println("phone empty: " + "".contentEquals(phone));
		
		return "".contentEquals(phone)?true:false;
	}
	
	/**
	 * User has or not email
	 * <p>
	 * Checking-method. Return if a giving user has or not email saved in database
	 * </p>
	 *
	 * @author Dayana.Silveira
	 * @param String account number
	 * @return boolean true: if user has email, false: if user doesn't have email
	 * @throws SQLException
	 */
	public boolean hasEmail(String acc) throws SQLException {

		String email = "";
		
		query1 = "SELECT * FROM web_users where web_user_id = '" + acc + "' AND property_id = '" + property_id + "';";

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		
		if (resultSet1.first()) {
			email = resultSet1.getString("email_address");	
		
			Page.log.debug("Founded web user id: " + acc + " with email: " + email);		
		}
		System.out.println("\"\".contentEquals(email): " + ("".contentEquals(email)?false:true));
		System.out.println("email: " + email);
		return "".contentEquals(email)?true:false;
	}

	// -------------------CATEGORIES------------------------------------------

	/**
	 * Auxiliary Method. Verify the web user payments categories stored in the
	 * database.
	 * <p>
	 * Query the database looking for web user payments categories.
	 * </p>
	 * 
	 * @return True if the web user has payment categories, otherwise return false.
	 * @author Yary.Perez
	 */
	public boolean isWebUsercategories() throws SQLException {

		boolean webuserCat = true;

		query1 = "SELECT * FROM web_users_category where web_user_id = '" + web_user_id + "';";

		// Page.connectionDB.openConnection();

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.first()) {

			// Page.connectionDB.closeConnection();
			Page.log.debug("Founded web user categories values for web_user_id: " + web_user_id);
			return webuserCat;

		} else {

			// Page.connectionDB.closeConnection();
			Page.log.debug("Not founded web user categories values for web_user_id: " + web_user_id);
			return webuserCat = false;

		}

	}

	/**
	 * Auxiliary Method. Return the web user payments categories stored in the
	 * database.
	 * <p>
	 * Query the database looking for web user payments categories and return its in
	 * an list.
	 * </p>
	 * 
	 * @return String List of the web user payments categories.
	 * @author Yary.Perez
	 */
	public ArrayList<String> getWebserCategories() throws SQLException {

		ArrayList<String> webUserCat = new ArrayList<String>();

		query1 = "SELECT description FROM web_users_category where web_user_id = '" + web_user_id + "';";

		// Page.connectionDB.openConnection();

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.first()) {

			webUserCat.add(resultSet1.getString("description"));

			while (resultSet1.next()) {

				webUserCat.add(resultSet1.getString("description"));
			}

			// Page.connectionDB.closeConnection();
			Page.log.debug("Founded web user categories values for web_user_id: " + web_user_id);
			return webUserCat;

		} else {

			// Page.connectionDB.closeConnection();
			Page.log.debug("Not founded web user categories values for web_user_id: " + web_user_id);
			return webUserCat;
		}

	}

	/**
	 * Auxiliary Method. Return the merchant payments categories stored in the
	 * database.
	 * <p>
	 * Query the database looking for merchant payments categories and return its in
	 * an list.
	 * </p>
	 * 
	 * @return String List of the merchant payments categories.
	 * @author Yary.Perez
	 */
	public ArrayList<String> getMerchantCategories() throws SQLException {

		ArrayList<String> merchantCat = new ArrayList<String>();

		query1 = "SELECT payment_type_name FROM payment_type where property_id = '" + property_id + "';";

		// Page.connectionDB.openConnection();

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.first()) {

			merchantCat.add(resultSet1.getString("payment_type_name"));

			while (resultSet1.next()) {

				merchantCat.add(resultSet1.getString("payment_type_name"));
			}

			// Page.connectionDB.closeConnection();
			Page.log.debug("Founded merchant categories values for property_id: " + property_id);
			return merchantCat;

		} else {

			// Page.connectionDB.closeConnection();
			Page.log.debug("Not founded merchant categories values for property_id: " + property_id);
			return merchantCat;
		}

	}

	// This function return the logo name in properties table, return by default
	// revopay logo
	public String getLogoName() throws SQLException {
		String logo = "revopay.svg"; // name of the logo by default in qa8 from ./public/img
		query1 = "SELECT logo FROM properties where id = '" + property_id + "';";

		// Page.connectionDB.openConnection();

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.first()) {
			logo = resultSet1.getString(1);

			Page.log.debug("Found logo name  " + logo);
			// Page.connectionDB.closeConnection();

		} else {
			Page.log.debug("No logo name found ");
			// Page.connectionDB.closeConnection();
		}
		return logo;

	}
	// -----------------------------QUICKPAY--------------------------------------

	/** <p>Get Quickpay combination Setting</p>
	 *  @return String Ex: 11, 12, 13, 14, 21, 22...
	 *  
	 *  @author Dayana.Silveira
	 *  @since 1.1.1
	 * 
	 * */
	public String getQPCombination() throws SQLException {

		String accsetting = getSettingValue("accsetting");
		String invsetting = getSettingValue("invsetting");

		return accsetting + invsetting;

	}

	// -----------------------------PAYMENTS--------------------------------------

	/**
	 * Auxiliary Method. Get the Transaction Id and the Auth Code for the latest
	 * transaction.
	 * <p>
	 * Query the database looking for the Transaction Id and the Auth Code for the
	 * latest transaction.
	 * </p>
	 * 
	 * @return String array with the values of the Trans Id and the Auth Code.
	 *         Expected values: [0] trans_id, [1] auth code.
	 * @author Yary.Perez
	 */
	public String[] getCurrentTransaction() throws SQLException {

		String currentTransaction[] = new String[2];
		query1 = "SELECT * FROM accounting_transactions where property_id = '" + property_id
				+ "' and trans_account_number = '" + web_user_account + "' and is_convenience_fee_trans = '" + 0 + "';";

		// Page.connectionDB.openConnection();
		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		resultSet1.last();
		currentTransaction[0] = resultSet1.getString("trans_id");
		currentTransaction[1] = resultSet1.getString("trans_result_auth_code");

		return currentTransaction;

	}

	// -----------------------------INVOICE--------------------------------------
	/**
	 * Get Invoice Status
	 * <p>
	 * Search an invoice by invoice number and returns invoice status. Invoice
	 * status can be: draft, paid, sent, cancelled, closed, open
	 * </p>
	 * 
	 * @param invoice: Invoice number
	 * @return String. Status is a string, if not exist this invoice number function
	 *         returns 0, if any invoice number was passed like parameter functions
	 *         returns -1
	 * @throws SQLException
	 */
	public String getInvoiceStatus(String invoice) throws SQLException {

		if ("".equals(invoice))
			return "-1";
		/**
		 * By default if not exist returns "0"
		 */
		String status = "0"; // by default if not exist

		query1 = "SELECT status FROM invoice where invoice_number = '" + invoice + "' and property_id = '" + property_id
				+ "';";

		// Page.connectionDB.openConnection();

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.first()) {
			status = resultSet1.getString(1);
			// System.out.println("Found invoice number: " + invoice + " with status value:
			// " + status);

			Page.log.debug("Found for the invoice: " + invoice + " status value:  " + status);
			// Page.connectionDB.closeConnection();

		} else {
			Page.log.debug("No logo name found ");
			// Page.connectionDB.closeConnection();
		}
		return status;

	}

	/**
	 * Set Invoice Status
	 * <p>
	 * Search an invoice by invoice number set the invoice status for a status
	 * given. Invoice status can be: draft, paid, sent, cancelled, closed, open.
	 * This function can be used to restore initial data used. When an Invoice is in
	 * status sent, then you write in the Quickpay this invoice number, the system
	 * change status automatically to "open". For that reason is necessary restore
	 * the initial data info.
	 * </p>
	 * 
	 * @param invoice invoice number
	 * @param status  status will receive the invoice given {@link invoice}
	 * @return String. Status is a string, if not exist this invoice number function
	 *         returns 0, if any invoice number was passed like parameter functions
	 *         returns -1
	 * @throws SQLException
	 */
	public void setInvoiceStatus(String invoice, String status) throws SQLException {

		query1 = "SELECT status FROM invoice where invoice_number = '" + invoice + "' and property_id = '" + property_id
				+ "';";

		Page.connectionDB.openConnection();

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.first()) {

			query1 = "UPDATE invoice SET status = '" + status + "' WHERE (`invoice_number` = '" + invoice
					+ "') and property_id = '" + property_id + "';";
			Page.connectionDB.getStatement().executeUpdate(query1);
	
			Page.log.debug("Updated sinvoice status for: " + invoice + " with status: " + status);

		}

	}

	/**
	 * <p> return the webuser_id for a given invoice number if invoice does not exist </p>
	 * @return int webuser id associated at this invoice number. 0 if invoice not exist, if invoice empty returns -1
	 * @author Dayana.Silveira
	 * @throws SQLException
	 */
	public int getInvoiceUser(String invNumber) throws SQLException {
		int userid = 0;
		if ("".equals(invNumber))
			return -1;

		query1 = "SELECT web_user_id FROM invoice where invoice_number = '" + invNumber + "' and property_id = '"
				+ property_id + "';";
	

		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.first()) {
			userid = Integer.parseInt(resultSet1.getString(1));

			// System.out.println("El valor del userid ahora es: " + userid);

			Page.log.debug("Found for the invoice: " + invNumber + " for the user with id: " + userid);	

		} else {
			userid = 0;
			Page.log.debug("No invoice number found ");
		}
		return userid;

	}
	
	/**
	 * <p> return all web user information associated to a given invoice number</p>
	 * 
	 * @param invNumber invoice number
	 * @return ResultSet whole web user row associated at this invoice number. null if invoice is empty
	 * @author Dayana.Silveira
	 * @throws SQLException
	 */
	public ResultSet getInvoiceUserInfo(String invNumber) throws SQLException {
				
		if ("".equals(invNumber))
			return resultSet1 = null;

		query1 = "SELECT * FROM web_users where web_user_id = "
				+ "(SELECT web_user_id FROM invoice where invoice_number = '" + invNumber + "' AND property_id = '" + property_id + "') "
						+ "AND property_id = '" + property_id + "';";


		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.first()) {
			Page.log.debug("Founded web user who has assigned invoice number: " + invNumber);
		} else {
			Page.log.debug("Not founded web user who has assigned invoice number: " + invNumber);
		}
		
		
		return resultSet1;

	}
	
	/**
	 * <p> return all  invoice information associated to a given invoice number</p>
	 * 
	 * @param invNumber invoice number
	 * @return ResultSet whole invoice row associated at this invoice number. null if invoice is empty
	 * @author Dayana.Silveira
	 * @throws SQLException
	 */
	public ResultSet getInvoiceInfo(String invNumber) throws SQLException {
				
		if ("".equals(invNumber))
			return resultSet1 = null;

		query1 = "SELECT * FROM invoice where invoice_number = '" + invNumber + "' AND property_id = '" + property_id + "';";


		resultSet1 = Page.connectionDB.getStatement().executeQuery(query1);

		if (resultSet1.first()) {
			Page.log.debug("Founded invoice number: " + invNumber);
		} else {
			Page.log.debug("Not founded invoice number: " + invNumber);
		}
		
		
		return resultSet1;

	}

}
