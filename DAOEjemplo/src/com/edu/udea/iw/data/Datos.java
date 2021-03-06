package com.edu.udea.iw.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//@Author Julian Vasquez - julivas96@gmail.com @Version = 1.0
public class Datos {
	public static void consultarCiudades(){
		//metodo para realizar la busqueda en la base de datos
		Connection con=null; // variable para manejar la conexion
		PreparedStatement ps = null; //parametro de envio para el query
		ResultSet rs = null; //respuesta de la busqueda
		try{
			Class.forName("com.mysql.jdbc.Driver"); //Busca el driver especial para la base de datos, en este caso, mysql
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ciudades","root","root");//Conecta el driver con el localhost/ip y la base de datos correspondiente
			ps = con.prepareStatement("Select * From ciudades");//Se prepara la sentencia sql pero no se envia
			rs = ps.executeQuery();//Se envia y ejecuta la sentencia sql anteriormente preparada
			while(rs.next()){
				System.out.println(rs.getString("codigo")+":"+rs.getString("Nombre"));
			}
		}catch(ClassNotFoundException e){ //manejo de excepciones
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();//se cierran las variables de conexion
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		
	}
}
