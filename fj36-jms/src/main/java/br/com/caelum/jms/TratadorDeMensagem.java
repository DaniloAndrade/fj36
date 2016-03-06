package br.com.caelum.jms;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by danilo on 05/03/16.
 */
public class TratadorDeMensagem implements MessageListener{


	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println("Tratador recebendo mensagem: "+ textMessage.getText());
		}catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
