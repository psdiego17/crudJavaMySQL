package br.com.agenda.view;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Agenda {

	public static void main(String[] args) {
		
		ContatoDAO contatoDao = new ContatoDAO();
		
		/*
			//ADICIONAR DADOS NO BANCO
			Contato contato1 = new Contato();
			contato1.setNome("Maria dos Santos");
			contato1.setIdade(40);
			contato1.setDataCadastro(new Date());
			
			Contato contato2 = new Contato();
			contato2.setNome("João dos Santos");
			contato2.setIdade(47);
			contato2.setDataCadastro(new Date());
			
			Contato contato3 = new Contato();
			contato3.setNome("Soraia de Jesus");
			contato3.setIdade(38);
			contato3.setDataCadastro(new Date());
			
			//contatoDao.salvar(contato1);
			//contatoDao.salvar(contato2);
			//contatoDao.salvar(contato3);
		
		*/
		
		//BUSCAR DADOS DO BANCO
		System.out.println("Buscando dados no Banco de dados");
		for(Contato c: contatoDao.listar()) {
			System.out.println(c.toString());
		}
		
		
		//Atualizar dados no banco
		/*
		Contato contato = new Contato();
		contato.setNome("Soraia de Jesus Santos");
		contato.setIdade(39);
		contato.setDataCadastro(new Date());
		contato.setId(3);
		
		contatoDao.atualizar(contato); //Chave primária que está no banco
		
		*/
		
		//DELETAR CONTATO PELO ID(CHAVE PRIMÁRIA)
		contatoDao.deletar(11);
		
		

	}
	

}
