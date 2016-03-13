package br.com.caelum.camel;

import br.com.caelum.livraria.modelo.Livro;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by danilo on 12/03/16.
 */
public class TestePolling {
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("http://localhost:8088/fj36-livraria/loja/livros/mais-vendidos")
						.delayer(1000)
					.unmarshal().json()
					.process(new Processor() {
						@Override
						public void process(Exchange exchange) throws Exception {
						List<?> listaDeLivros = (List<?>) exchange.getIn().getBody();
						ArrayList<Livro> livros = (ArrayList<Livro>) listaDeLivros.get(0);
						Message message = exchange.getIn();
						message.setBody(livros);
					}
				}).log("${body}")
				.to("mock:livros");

			}
		});

		context.start();

		new Scanner(System.in).nextLine();

		context.stop();


	}
}
