package br.com.caelum.payfast;

import br.com.caelum.payfast.modelo.Pagamento;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * Created by danilo on 06/03/16.
 */
public class GeraXSDPagamento {
	public static void main(String[] args) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Pagamento.class);
		context.generateSchema(new SchemaOutputResolver() {
			@Override
			public Result createOutput(String namespaceUri,
									   String suggestedFileName) throws IOException {
				return new StreamResult(new File("pagamento.xsd"));
			}
		});
	}
}
