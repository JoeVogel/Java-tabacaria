package br.com.tabacaria.model.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.tabacaria.model.Categoria;

@XmlRootElement
public class Categorias {

	private List<Categoria> categorias = new ArrayList<>();

	public Categorias() {
	}

	public Categorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@XmlTransient
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
	@XmlElement(name="link")
	public List<Link> getLinks() {
		List<Link> links = new ArrayList<>();
		for (Categoria categoria : getCategorias()) {
			
			Link link = Link.fromPath("categorias/{nome}")
					.rel("categoria")
					.title(categoria.getDescricao())
					.build(categoria.getDescricao());
			
			
			links.add(link);
		}
		return links;
	}
	
	public void setLinks (List<Link> links) {
		
	}
}
