package br.com.tabacaria.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/olaMundo")
public class TesteService {

	public TesteService() {
		System.out.println("construindo testeservice");
	}
	
	//Acessar por http://localhost:8080/tabacaria/services/olaMundo
	@GET
	@Produces("text/plain")
	public String dizOla() {
		return "Olá, mundo REST!";
	}
}
