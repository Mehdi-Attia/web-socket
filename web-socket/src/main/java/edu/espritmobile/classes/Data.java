package edu.espritmobile.classes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Data {
	public static List<Player> players = Arrays.asList(new Player("Marc-Andr�",
			"Ter Stegen"), new Player("Gerrard", "Piqu�"), new Player("Javier",
			"Mascherano"), new Player("Jordi", "Alba"), new Player("Daniel",
			"Alves"), new Player("Sergio", "Busquets"), new Player("Ivan",
			"Rakitic"), new Player("Xavier", "Hern�ndez"), new Player("Andr�s",
			"Iniesta"), new Player("Lionel", "Messi"), new Player("Neymar",
			"J�nior"), new Player("Pedro", "Rodr�guez"), new Player("Luis",
			"Su�rez"));

	public static Player getPlayer() {
		Random r = new Random();
		int index = r.nextInt(12);
		return players.get(index);
	}
}
