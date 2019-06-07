package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import dao.UsuarioPosDAO;
import model.UsuarioPos;

public class TesteBancoJdbc {

//	@Test
//	public void initBanco() throws SQLException {
//		UsuarioPosDAO usuarioPosDAO = new UsuarioPosDAO();
//		UsuarioPos usuarioPos = new UsuarioPos();
//		
//		usuarioPos.setId(5l);
//		usuarioPos.setNome("Lindalvalva");
//		usuarioPos.setEmail("lin0265@gmail.com.");
//		
//		usuarioPosDAO.salvar(usuarioPos);
//	}
//	
//	@Test
//	public void iniciarLista(){
//		UsuarioPosDAO dao = new UsuarioPosDAO();
//		
//		try {
//			List<UsuarioPos> list = dao.listar();
//			
//			for (UsuarioPos usuarioPos : list) {
//				System.out.println(usuarioPos);
//				System.out.println("-------------------------");
//			}
//		
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	@Test
//	public void iniciarBusca() {
//		UsuarioPosDAO dao = new UsuarioPosDAO();
//		
//		try {
//			UsuarioPos usuarioPos = dao.buscar(3L);
//			System.out.println(usuarioPos);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}

	@Test
	public void contarDomingos() {

		DateTime dataInicial = null;
		DateTime dataFinal = null;
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy");

		int tentativas = 0;

		while (tentativas < 3) {
			try {
				System.out.println("Digite a data inicial: ");
				Scanner scanner = new Scanner(System.in);

				String inicial = scanner.next();

				System.out.println("Digite a data final: ");
				String finalDate = scanner.next();
				dataInicial = DateTime.parse(inicial, dateTimeFormatter);
				dataFinal = DateTime.parse(finalDate, dateTimeFormatter);
				break;
			} catch (Exception e) {
				tentativas++;
				System.out.println("Data invalida. Formato dd/MM/yyyy.");
			}
		}

		Days days = Days.daysBetween(dataInicial, dataFinal);

		Integer semanasEntre = (days.getDays() / 7);

		// Verificando se a data inicial é domingo.
		if (dataInicial.getDayOfWeek() == 7) {
			semanasEntre++;
		}

		System.out.println(
				String.format("Domingos entre o dia %s e o dia %s: %s.", dataInicial.toString(dateTimeFormatter),
						dataFinal.toString(dateTimeFormatter), semanasEntre.toString()));
	}
}
