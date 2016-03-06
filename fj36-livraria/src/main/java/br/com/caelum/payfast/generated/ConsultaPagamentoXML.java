package br.com.caelum.payfast.generated;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 * Created by danilo on 06/03/16.
 */
public class ConsultaPagamentoXML {
	private static final String SERVER_URI = "http://localhost:8080/fj36-webservice";
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Pagamento pagamento = client.target(SERVER_URI + "/pagamentos/1")
				.request()
				.accept(MediaType.APPLICATION_XML_TYPE)
				.buildGet()
				.invoke(Pagamento.class);

		System.out.printf("%d %f %s\n",
				pagamento.getId(),pagamento.getValor(),pagamento.getStatus());
	}
}
