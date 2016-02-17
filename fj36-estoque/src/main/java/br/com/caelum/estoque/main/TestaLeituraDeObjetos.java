package br.com.caelum.estoque.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.estoque.rmi.ItemEstoque;

public class TestaLeituraDeObjetos {
	
	
	public static void main(String[] args) throws  IOException, ClassNotFoundException {
		try(ObjectInputStream reader = 
				new ObjectInputStream(
						new FileInputStream(new File("itens.bin")))
		){
	

			
			
			List<ItemEstoque> itens = (List<ItemEstoque>) reader.readObject();
			
			for (ItemEstoque itemEstoque : itens) {
				System.out.println(itemEstoque.getCodigo());
				System.out.println(itemEstoque.getQuantidade());
			}
			
		}
		
		
	}
}
