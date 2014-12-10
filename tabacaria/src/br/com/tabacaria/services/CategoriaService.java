package br.com.tabacaria.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import br.com.tabacaria.dao.CategoriaDao;
import br.com.tabacaria.dao.JpaDaoFactory;
import br.com.tabacaria.model.Categoria;
import br.com.tabacaria.model.CategoriaJaExisteException;
import br.com.tabacaria.model.rest.Categorias;

@Path("/categorias")
@Consumes({ MediaType.TEXT_XML, MediaType.APPLICATION_XML,
		MediaType.APPLICATION_JSON })
@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_XML,
		MediaType.APPLICATION_JSON })
public class CategoriaService {

	private CategoriaDao categoriaDao = JpaDaoFactory.getInstance().getCategoriaDao();

	private static final int TAMANHO_PAGINA = 10;

	@GET
	@Path("{descricao}")
	public Categoria encontreCategoria(@PathParam("descricao") String descricaoCategoria) {
		Categoria categoria = categoriaDao.buscaPorDescricao(descricaoCategoria);
		if (categoria != null)
			return categoria;

		throw new WebApplicationException(Status.NOT_FOUND);

	}

	@GET
	public Categorias listeTodasAsCategorias(@QueryParam("pagina") int pagina) {
		List<Categoria> categorias = categoriaDao.listaPaginada(pagina, TAMANHO_PAGINA);
		return new Categorias(categorias);
	}

	@POST
	public Response criarCategoria(Categoria categoria) {
		
		try {
			categoriaDao.salva(categoria);
		} catch (CategoriaJaExisteException e) {
			throw new WebApplicationException(Status.CONFLICT);
		}

		URI uri = UriBuilder.fromPath("categorias/{descricao}").build(
				categoria.getDescricao());

		return Response.created(uri).entity(categoria).build();
	}

	@PUT
	@Path("{descricao}")
	public void atualizarCategoria(@PathParam("descricao") String descricao, Categoria categoria) {
		encontreCategoria(descricao);
		categoria.setDescricao(descricao);
		categoriaDao.atualiza(categoria);
	}

	@DELETE
	@Path("{descricao}")
	public void apagarCategoria(@PathParam("descricao") String descricao) {
		categoriaDao.remove(descricao);
	}

}
