package br.com.tabacaria.dao;

public class JpaDaoFactory {

	public static JpaDaoFactory instance = new JpaDaoFactory();
	
	private CategoriaDao categoriaDao;
	

	private JpaDaoFactory() {}
		
	public static JpaDaoFactory getInstance(){
		return instance;
	}
	
	
	public CategoriaDao getCategoriaDao(){
		if(this.categoriaDao == null)
			this.categoriaDao = new CategoriaDao();
		return this.categoriaDao;
	}

}
