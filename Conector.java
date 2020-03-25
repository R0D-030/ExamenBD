package Examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conector {

	// atributos

	private static Connection con;
	private static Conector INSTANCE = null;

	private Conector() {

	}

	private synchronized static void crearInstancia() {
		if (INSTANCE == null) {
			INSTANCE = new Conector();
			crearConexion();
		}
	}

	public static Conector getInstancia() {
		if (INSTANCE == null) {
			crearInstancia();
		}
		return INSTANCE;
	}

	// Conexion al usuario
	private static void crearConexion() {
		String host = "127.0.0.1";
		String user = "Joel";
		String password = "Totololo";
		String dataBase = "spotify";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String urlConexion = "jdbc:mysql://" + host + "/" + dataBase + "?" + "user=" + user + "&password="
					+ password;
			con = DriverManager.getConnection(urlConexion);
			System.out.println("Entro");
		} catch (Exception e) {

		}

	}

	// Ejecercio 1
	public ArrayList<String> getPopularidad() throws SQLException {
		ArrayList<String> listPopularidad = new ArrayList<String>();
		PreparedStatement ps = con.prepareStatement("select artists.name as Artists , max(plays) as Reproducciones\r\n"
				+ "from artists\r\n" + "inner join songs on artists.id=songs.artist\r\n" + "group by artists.name\r\n"
				+ "order by max(plays) asc;");
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			listPopularidad.add(res.getString("Artist") + "   " + res.getString("Reproducciones"));
		}
		res.close();
		return listPopularidad;
	}

	// Ejercicio 2
	public ArrayList<String> getCanciones() throws SQLException {
		ArrayList<String> listCanciones = new ArrayList<String>();
		PreparedStatement ps = con
				.prepareStatement("select songs.title as Song, albums.title as Album\r\n" + "from songs\r\n"
						+ "inner join albums on songs.album = albums.id\r\n" + "where songs.title like '%y'");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			listCanciones.add(rs.getString("Song") + "       " + rs.getString("Album"));
		}
		rs.close();
		return listCanciones;
	}

}
