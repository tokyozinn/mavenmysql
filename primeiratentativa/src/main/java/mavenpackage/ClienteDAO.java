package mavenpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ClienteDAO {
	
	private final String SQL = "SELECT * from cliente";
	
	
	public List<Clientes> getListaClientes() {
		
		List<Clientes> clientes = new ArrayList<Clientes>();

		try {
			Connection con = ConexaoDB.getConnection();
			PreparedStatement stmt = con.prepareStatement(SQL);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Clientes c = new Clientes();
				c.setId(rs.getString("CliID"));
				c.setNome(rs.getString("Nome"));
				c.setCpf(rs.getString("CPF"));
				
				clientes.add(c);
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível obter a listagem dos clientes: " + e.getMessage());
		}
		return clientes;
	}

}
