package br.com.caelum.payfast.rest;

import br.com.caelum.payfast.modelo.Pagamento;

import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by danilo on 27/02/16.
 */

@Path("/pagamentos")
@Singleton
public class PagamentoResource {

	private Map<Integer,Pagamento> repositorio = new HashMap<>();
	private Integer idPagamento = 1;

	public PagamentoResource() {

		Pagamento pagamento = new Pagamento();
		pagamento.setId(idPagamento++);
		pagamento.setValor(BigDecimal.TEN);
		pagamento.comStatusCriado();
		repositorio.put(pagamento.getId(),pagamento);
	}


	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Pagamento buscaPagamento(@PathParam("id") Integer id){
		return repositorio.get(id);
	}
}
