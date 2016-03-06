package br.com.caelum.jms;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;

/**
 * Created by danilo on 05/03/16.
 */
public class EnviadorParaOTopico {

	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Topic topic = (Topic) ic.lookup("jms/TOPICO.LIVRARIA");
		try(JMSContext context = factory.createContext("jms","jms2")){
			JMSProducer producer = context.createProducer();
			producer.setProperty("formato","ebook");
			Scanner scanner = new Scanner(System.in);

			while (scanner.hasNextLine()){
				String line = scanner.nextLine();
				producer.send(topic,line);
			}

			scanner.close();
		}
	}
}
