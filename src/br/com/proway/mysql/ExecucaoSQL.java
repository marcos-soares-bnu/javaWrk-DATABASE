package br.com.proway.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ExecucaoSQL {

	private Connect con = new Connect();
	
	public ExecucaoSQL(){
		
		if (con.connect() == false){
			ConnectMSSQLServer con = new ConnectMSSQLServer();
			con.connect();
		}
	}
	
	public void insereProduto(int codigo, String descricao){
		
		String sql = "insert into ts_registro (codigo, descricao) values (?, ?) ";
		
		try{
			Connection connect = con.getConnection();
			java.sql.PreparedStatement statement = connect.prepareStatement(sql);
			
			statement.setInt(1, codigo);
			statement.setString(2, descricao);
			
			statement.execute();
			statement.close();
			
			System.out.println("produto inserido com sucesso!");
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Algo de errado não está certo!");
		}
		
	}

	
	public List<Registro> listaProduto(){
		
		Registro reg = new Registro(1, "");
		List<Registro> result = new ArrayList<Registro>();
		String sql = "select * from ts_registro ";
		
		try{
			Connection connect = con.getConnection();
			java.sql.PreparedStatement statement = connect.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			
			while (resultset.next()) {
				
				reg.codigo = resultset.getInt(1);
				reg.descricao = resultset.getString(2);

				result.add(reg);
				
			}
			resultset.close();
			statement.close();
			
			
		} catch (SQLException e){
			
			System.out.println("Algo de errado não está certo!");
		}
		return result;
		
	}

	
	public void selecionaProduto(){
		
		String sql = "select * from ts_registro ";
		
		try{
			Connection connect = con.getConnection();
			java.sql.PreparedStatement statement = connect.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while (resultset.next()) {
				
				String string0 = resultset.getString(1);
				String string1 = resultset.getString("descricao");

				System.out.println("Produto codigo = " + string0 + " Descricao = " + string1);
				
			}
			
			statement.close();
			
		} catch (SQLException e){
			
			System.out.println("Algo de errado não está certo!");
		}
		
	}

	
	public void atualizaProduto(int codigo, String descricao){
		
		String sql = "update ts_registro set descricao = ? where codigo = ? ";
		
		try{
			Connection connect = con.getConnection();
			java.sql.PreparedStatement statement = connect.prepareStatement(sql);
			
			statement.setInt(2, codigo);
			statement.setString(1, descricao);
			
			statement.execute();
			statement.close();
			
			System.out.println("produto atualizado com sucesso!");
		} catch (SQLException e){
			
			System.out.println("Algo de errado não está certo!");
		}
		
	}


	public void deletaProduto(int codigo){
		
		String sql = "delete from ts_registro where codigo = ? ";
		
		try{
			Connection connect = con.getConnection();
			java.sql.PreparedStatement statement = connect.prepareStatement(sql);
			
			statement.setInt(1, codigo);
			
			statement.executeUpdate();
			statement.close();
			
			System.out.println("produto deletado com sucesso!");
		} catch (SQLException e){
			
			System.out.println("Algo de errado não está certo!");
		}
		
	}
	
	
	
}
