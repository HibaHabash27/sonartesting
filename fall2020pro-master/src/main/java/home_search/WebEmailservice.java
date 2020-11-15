package home_search;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.util.logging.Logger;

public class WebEmailservice {
	
	static final  String SENDER_EMAILID = "rahafnawas6@gmail.com";
	static final  String PASS = "2324roro";
	static final  String EMAIL_SMTPSERVER = "smtp.gmail.com"; 			
	static	final  String EMAIL_SERVERPORT = "465";
	String  receiverEmailID = null;
	  String emailSubject = "Test Mail";
	 String emailBody ;
	 StringBuilder s;
	  public static final Logger LOGGER = Logger.getLogger(WebEmailservice.class.getName());
	
	
	public void sendMail(String mail,List<home_information> list)
	{
		
		LOGGER.info("send an email");
		
		 
		  receiverEmailID=mail; 
		
		  emailSubject="test ";
		  
		  for(home_information list1 : list)
		  {
			  s.append(list1.type);
			  s.append("/");
			  s.append(list1.material);
			  s.append("/");
			  s.append(list1.placement);
			  s.append("/");
			  s.append(list1.price);
			  s.append("/");
			  s.append(list1.numberOfBathroom1);
			  s.append("/");
			  s.append(list1.numberOfBedroom);
			  s.append("/");
			  emailBody=s.toString();
		  }
		
		  Properties props = new Properties();
		  props.put("mail.smtp.user",SENDER_EMAILID);
		  props.put("mail.smtp.host", EMAIL_SMTPSERVER);
		  props.put("mail.smtp.port", EMAIL_SERVERPORT);
		  props.put("mail.smtp.starttls.enable", "true");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.socketFactory.port", EMAIL_SERVERPORT);
		  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.socketFactory.fallback", "false");
		  props.put("mail.smtp.ssl.checkserveridentity","true");
		 
		  try{  
		  Authenticator auth = new SMTPAuthenticator();
		  Session session = Session.getInstance(props, auth);
		  MimeMessage msg = new MimeMessage(session);
		  msg.setText(emailBody);
		  msg.setSubject(emailSubject);
		  msg.setFrom(new InternetAddress(SENDER_EMAILID));
		  msg.addRecipient(Message.RecipientType.TO,
		  new InternetAddress(receiverEmailID));
		  Transport.send(msg);
		  LOGGER.info("Message send Successfully:)"); }
		  
		  catch (Exception mex)
		  {
			  LOGGER.info("");
			  
			  }
		
		  
		  }
	      
		  public class SMTPAuthenticator extends javax.mail.Authenticator
		  {
			  @Override
		  public PasswordAuthentication getPasswordAuthentication()
		  {
		  return new PasswordAuthentication(SENDER_EMAILID, PASS);
		  }
		  } 
		  

	
	
	}


