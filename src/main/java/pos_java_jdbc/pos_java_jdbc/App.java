package pos_java_jdbc.pos_java_jdbc;

import java.util.Scanner;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class App {
	public static void main(String[] args) {
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
