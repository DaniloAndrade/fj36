package br.com.caelum.estoque.ws;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebService(targetNamespace = "http://caelum.com.br/estoquews/v1")
@Stateless
public class EstoqueWS  {


	private Map<String, ItemEstoque> repositorio = new HashMap<String, ItemEstoque>();



	public EstoqueWS(){
		repositorio.put("ARQ", new ItemEstoque("ARQ", 5));
		repositorio.put("SOA", new ItemEstoque("SOA", 2));
		repositorio.put("TDD", new ItemEstoque("TDD", 3));
		repositorio.put("RES", new ItemEstoque("RES", 6));
		repositorio.put("LOG", new ItemEstoque("LOG", 5));
		repositorio.put("WEB", new ItemEstoque("WEB", 9));
	}

	@WebMethod(operationName = "ItensPeloCodigo")
	@WebResult(name = "ItemEstoque")
	public List<ItemEstoque> getQuantidade(
			@WebParam(name = "codigo") List<String> codigoProduto,
			@WebParam(name = "tokenUsuario",header = true) String token){

		if (token == null || !token.equals("TOKEN123")){
			throw new AutorizacaoException("Nao autorizado");
		}
		
		System.out.println("Verificando estoque do produto "+codigoProduto);
		return codigoProduto.stream().map(repositorio::get).collect(Collectors.toList());
	}

}
