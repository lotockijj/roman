package sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSms{
	public static final String ACCAUNT_SID = "AC844e5967570c3e4e7444226d2fe7e90c";
	public static final String AUTH_TOKEN = "AC844e5967570c3e4e7444226d2fe7e90c";

	public static void main(String[] args){
		Twilio.init(ACCAUNT_SID, AUTH_TOKEN);

		Message message = Message.creator(
			new PhoneNumber("+380679538747"),
			new PhoneNumber("+380679538747"),
			"This is the ship that made the Kessel Run in 14 parsecs?!"
		).create();

		System.out.println(message.getSid());
	}
}