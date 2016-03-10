package br.com.caelum.livraria.jms;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.caelum.livraria.jaxb.SerializadorXml;
import br.com.caelum.livraria.modelo.Pedido;

import javax.jms.*;

@Component
@Lazy(true)
public class EnviadorMensagemJms implements Serializable {

//	@Qualifier("hornetQConnectionFactory")
	@Autowired
	private ConnectionFactory factory;
//	@Qualifier("topicoLivraria")
	@Autowired
	private Topic topic;

	private static final long serialVersionUID = 1L;

	public void enviar(Pedido pedido) {
		// código para enviar a mensagem
		System.out.println("JMS: Enviando pedido: "+ pedido);
		try (JMSContext context = factory.createContext("jms","jms2")){
			JMSProducer producer = context.createProducer();
			producer.setProperty("formato", pedido.getFormato());
			producer.send(topic,pedido.toString());
		}
	}
}
