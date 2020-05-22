package MyQSender;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Entities.Sinhvien;

public class MyQSender {
	private QueueConnection qConnect = null;
	private QueueSession qSession = null;
	private Queue queue = null;

	public MyQSender() throws NamingException, JMSException {
		Context ctx = new InitialContext();
		QueueConnectionFactory qFactory = (QueueConnectionFactory) ctx.lookup("cfName");
		qConnect = qFactory.createQueueConnection();
		qSession = qConnect.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) ctx.lookup("MyQueue");
		qConnect.start();
	}

	public static void main(String[] args) throws NamingException, JMSException {
		Sinhvien sv = new Sinhvien("01420011", "Nguyễn Văn Lành", 30);
		MyQSender sender = new MyQSender();
		sender.sendObjectMessage(sv);
		sender.exit();
	}

	private void exit() throws JMSException {
		qSession.close();
		qConnect.close();
	}

	private void sendObjectMessage(Sinhvien sv) throws JMSException {
		ObjectMessage msg = qSession.createObjectMessage();
		QueueSender qSender = qSession.createSender(queue);
		msg.setObject(sv.toString());
		qSender.send(msg);
	}
}
