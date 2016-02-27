package br.com.caelum.estoque.ws;

import javax.xml.ws.WebFault;

/**
 * Created by danilo on 27/02/16.
 */
@WebFault(name = "AutorizacaoFault")
public class AutorizacaoException extends RuntimeException {

	private static final long serialVersionUID = 1l;

	public AutorizacaoException(String msg) {
		super(msg);
	}
}
