package br.com.proway.mysql;

import java.util.ArrayList;
import java.util.List;

public class TestBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Connect conexao = new Connect();
		//conexao.connect();
		
		ExecucaoSQL execsql = new ExecucaoSQL();
		
/*
		execsql.insereProduto(1, "produto1 de teste de Bando de Dados!");
		execsql.insereProduto(2, "produto2 de teste de Bando de Dados!");
		execsql.insereProduto(3, "produto3 de teste de Bando de Dados!");
		execsql.insereProduto(4, "produto4 de teste de Bando de Dados!");
		
		//
		execsql.selecionaProduto();
		//
		execsql.atualizaProduto(1, "11111111111111111");
		//
		execsql.selecionaProduto();*/
		//
		List<Registro> lstProd = new ArrayList<Registro>();
		lstProd = execsql.listaProduto();
		
		for (Registro r : lstProd) {
			
			System.out.println(r.codigo + " " + r.descricao);
		}
		//
		//execsql.deletaProduto(1);
		//execsql.deletaProduto(2);
		//execsql.deletaProduto(3);
		//execsql.deletaProduto(4);
		//
	}

}
