package edu.espritmobile.classes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Data {
	public static List<Player> players = Arrays.asList(new Player("Marc-André",
			"Ter Stegen"), new Player("Gerrard", "Piqué"), new Player("Javier",
			"Mascherano"), new Player("Jordi", "Alba"), new Player("Daniel",
			"Alves"), new Player("Sergio", "Busquets"), new Player("Ivan",
			"Rakitic"), new Player("Xavier", "Hernández"), new Player("Andrés",
			"Iniesta"), new Player("Lionel", "Messi"), new Player("Neymar",
			"Júnior"), new Player("Pedro", "Rodríguez"), new Player("Luis",
			"Suárez"));

	public static Player getPlayer() {
		Random r = new Random();
		int index = r.nextInt(12);
		return players.get(index);
	}
}
