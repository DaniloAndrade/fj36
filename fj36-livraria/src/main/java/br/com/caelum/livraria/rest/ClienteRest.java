package br.com.caelum.livraria.rest;

import java.io.Serializable;

import br.com.caelum.livraria.modelo.Link;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

import br.com.caelum.livraria.modelo.Pagamento;
import br.com.caelum.livraria.modelo.Transacao;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

@Component
@Scope("request")
public class ClienteRest implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static final String SERVER_URI = "http://localhost:8080/fj36-webservice";

	private static final String ENTRY_POINT = "/pagamentos/";

	public Pagamento criarPagamento(Transacao transacao) {
		Client client = ClientBuilder.newClient();
		Pagamento pagamento = client.target(SERVER_URI + ENTRY_POINT)
				.request()
				.buildPost(Entity.json(transacao))
				.invoke(Pagamento.class);
		System.out.println("Pagamento criado, id: " +pagamento.getId());
		return pagamento;
	}

	public Pagamento confirmarPagamento(Pagamento pagamento) {
		Link linkConfirmar = pagamento.getLinkPeloRel("confirmar");
		Client client = ClientBuilder.newClient();
		Pagamento resposta = client.target(SERVER_URI + linkConfirmar.getUri())
				.request()
				.build(linkConfirmar.getMethod())
				.invoke(Pagamento.class);
		System.out.println("Pagamento confirmado, id: "+ resposta.getId());
		return resposta;
	}

}
