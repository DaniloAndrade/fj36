package br.com.caelum.jms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;

/**
 * Created by danilo on 05/03/16.
 */
public class RegistraGeradorNoTopico {

	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Topic topic = (Topic) ic.lookup("jms/TOPICO.LIVRARIA");
		try(JMSContext context = factory.createContext("jms","jms2")){
			context.setClientID("GeradorEbook");
			JMSConsumer consumer = context
					.createDurableConsumer(topic,"AssinaturaEbook","formato='ebook'",false);
			consumer.setMessageListener(new TratadorDeMensagem());

			context.start();

			Scanner scanner = new Scanner(System.in);
			System.out.println("Gerador esperando as mensagens.");
			System.out.println("Aperte Enter para fechar a conexão.");
			scanner.nextLine();
			scanner.close();
			context.stop();
		}
	}
}
