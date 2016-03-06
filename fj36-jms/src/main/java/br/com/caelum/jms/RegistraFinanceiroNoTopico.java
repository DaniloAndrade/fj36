package br.com.caelum.jms;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;

/**
 * Created by danilo on 05/03/16.
 */
public class RegistraFinanceiroNoTopico {

	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Topic topic = (Topic) ic.lookup("jms/TOPICO.LIVRARIA");
		try(JMSContext context = factory.createContext("jms","jms2")){
			context.setClientID("Financeiro");
			JMSConsumer consumer = context.createDurableConsumer(topic,"AssinaturaNotas");
			consumer.setMessageListener(new TratadorDeMensagem());

			context.start();

			Scanner scanner = new Scanner(System.in);
			System.out.println("Financeiro esperando as mensagens.");
			System.out.println("Aperte Enter para fechar a conexão.");
			scanner.nextLine();
			scanner.close();
			context.stop();
		}
	}
}
