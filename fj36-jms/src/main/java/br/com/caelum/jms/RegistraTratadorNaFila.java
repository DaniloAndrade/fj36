package br.com.caelum.jms;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;

/**
 * Created by danilo on 05/03/16.
 */
public class RegistraTratadorNaFila {

	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Queue queue = (Queue) ic.lookup("jms/FILA.GERADOR");
		try(JMSContext context = factory.createContext("jms","jms2")){
			JMSConsumer consumer = context.createConsumer(queue);
			consumer.setMessageListener(new TratadorDeMensagem());
			context.start();

			Scanner scanner = new Scanner(System.in);
			System.out.println("Tratador esperando as mensagens na fila jms.");
			scanner.nextLine();
			scanner.close();
			context.stop();
		}
	}
}
