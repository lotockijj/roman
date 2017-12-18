package sms.ipipi;

import org.apache.log4j.helpers.LogLog;
import java.io.IOException;
import java.util.Properties;

public final class IPIPISmsOverSmtpAppender extends FilteredShortSMTPAppender {
	private static final String KEY_HOST = "host";
	private static final String TO_SERVER = "to.server";
	@SuppressWarnings("unused")
	private String toServer;

	@Override
	public void activateOptions() {
		Properties properties = new Properties();
		try {
			properties.load(IPIPISmsOverSmtpAppender.class.getResourceAsStream("ipipi.properties"));
			setSMTPHost(properties.getProperty(KEY_HOST));
			setFrom(getSMTPUsername() + "@" + getSMTPHost());
			toServer = properties.getProperty(TO_SERVER);
//			setTo(parseAddress(getTo()));  
		}
		catch (IOException ioe) {
			LogLog.error("Failed loading IPIPI service properties", ioe);
		}
		super.activateOptions();
	}

//	private String parseAddress(String addressStr) {
//		String[] addresses = addressStr.split(",");
//		StringBuffer sb = new StringBuffer();
//		for (String address : addresses) {
//			sb.append(address).append("@").append(toServer).append(",");
//		}
//		return sb.substring(0, sb.length() - 1);
//	}
	
}