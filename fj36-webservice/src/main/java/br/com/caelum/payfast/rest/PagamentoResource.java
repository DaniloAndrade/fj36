package br.com.caelum.payfast.rest;

import br.com.caelum.payfast.modelo.Pagamento;
import br.com.caelum.payfast.modelo.Transacao;

import javax.ejb.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
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

	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response criarPagamento(Transacao transacao, @Context HttpHeaders hh) throws URISyntaxException {


		Pagamento pagamento = new Pagamento();
		pagamento.setId(idPagamento++);
		pagamento.setValor(transacao.getValor());
		repositorio.put(pagamento.getId(),pagamento);
		System.out.println("PAGAMENTO CRIADO " + pagamento);
		List<MediaType> acceptableMediaTypes = hh.getAcceptableMediaTypes();
		MediaType mediaType = acceptableMediaTypes.stream()
				.findFirst().orElse(MediaType.APPLICATION_JSON_TYPE);

		return Response
				.created(new URI("/pagamentos/" + pagamento.getId()))
				.entity(pagamento)
				.type(mediaType)
				.build();
	}
}
