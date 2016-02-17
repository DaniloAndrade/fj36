package br.com.caelum.estoque.cliente;

import java.rmi.Naming;

import br.com.caelum.estoque.rmi.EstoqueRmi;
import br.com.caelum.estoque.rmi.ItemEstoque;

public class ClienteRmi {
	public static void main(String[] args) throws Exception{
		EstoqueRmi rmi = (EstoqueRmi) Naming
				.lookup("rmi://localhost:1099/estoque");
		
		ItemEstoque itemEstoque = rmi.getItemEstoque("ARQ");
		System.out.println("Quantidade disponível " + itemEstoque.getQuantidade());
	}
}
