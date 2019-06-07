package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.UsuarioPos;
import conexaojdbc.SingleConnection;

public class UsuarioPosDAO {
	
	private Connection connection;
	
	public UsuarioPosDAO() {
		connection = SingleConnection.getConnection();
	}
	
	// Método salvar dados no banco.
	public void salvar(UsuarioPos usuarioPos) throws SQLException {
		try {
		String sql ="insert into usuario(id, nome, email) values (?,?,?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setLong(1, usuarioPos.getId());
		insert.setString(2, usuarioPos.getNome());
		insert.setString(3, usuarioPos.getEmail());
		insert.execute();
		connection.commit();
		
		} catch(Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
			e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	// Método utilizando padrão DAO para listar objetos do banco.
	public List<UsuarioPos> listar () throws SQLException{
		List<UsuarioPos> list = new ArrayList<UsuarioPos>();
		
		String sql = "select * from usuario";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while (resultado.next()) {
			UsuarioPos usuarioPos = new UsuarioPos();
			usuarioPos.setId(resultado.getLong("id"));
			usuarioPos.setNome(resultado.getString("nome"));
			usuarioPos.setEmail(resultado.getString("email"));
			
			list.add(usuarioPos);
			
		}
		
		return list;
	}
	
	// Método para buscar um ou nenhum objeto no banco de dado.
	public UsuarioPos buscar(Long id) throws SQLException{
		UsuarioPos retornaBusca = new UsuarioPos();
		
		String sql = "select * from usuario where id =" + id;
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while (resultado.next()) {
			
			retornaBusca.setId(resultado.getLong("id"));
			retornaBusca.setNome(resultado.getString("nome"));
			retornaBusca.setEmail(resultado.getString("email"));			
		}
		return retornaBusca;
	}
	
}
