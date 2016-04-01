package it.polito.rubrica.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.polito.tdp.rubrica.model.VoceRubrica;

	public class VoceDAO {
		String jdbcURL = "jdbc:mysql://localhost/rubrica?user=root";

		public VoceRubrica findVoceByNome(String nomeCercato){
		
		try{	
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql ="Select nome,email,telefono From voce WHERE nome=\""+nomeCercato+"\"";
			
			ResultSet res = st.executeQuery(sql);
			
			if(res.next())
			{
				String nome = res.getString("nome");
				String telefono= res.getString("telefono");
				String email = res.getString("email");
				VoceRubrica v = new VoceRubrica(nome,email,telefono);
				res.close();
				conn.close();
				return v;
			}
			else
			{	
				res.close();
				conn.close();
				return null;
			}
		}
	catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
		
		public boolean addVoce(VoceRubrica v)
		{
			try{	
				Connection conn = DriverManager.getConnection(jdbcURL);
				
				Statement st = conn.createStatement();
				
				String sql= "INSERT INTO `rubrica`.`voce` (`nome`, `email`, `telefono`) VALUES ('"+v.getNome()+"', '"+v.getEmail()+"', '"+v.getTelefono()+"')";
				
				int res = st.executeUpdate(sql);
				
				if(res==1)
				{
					return true;
				}
				else
				{	
					conn.close();
					return false;
				}
			}
		catch(SQLException e)
			{
				e.printStackTrace();
			}
			return false;
		}
		
		
		


	
	
}


