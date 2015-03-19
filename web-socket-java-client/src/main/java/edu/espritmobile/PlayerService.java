package edu.espritmobile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import edu.espritmobile.classes.Player;

public class PlayerService {

	Session session;

	public static void main(String[] args) throws InterruptedException,
			IOException {
		PlayerService client = new PlayerService();
		client.start();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String playerGivenName = "";
		String playerLastName = "";
		do {
			playerGivenName = br.readLine();
			playerLastName = br.readLine();
			client.session.getAsyncRemote().sendObject(
					new Player(playerGivenName, playerLastName));
		} while (!(playerGivenName.equals("exit") || playerLastName
				.equals("exit")));
	}

	public void start() {
		WebSocketContainer container = ContainerProvider
				.getWebSocketContainer();

		String uri = "ws://localhost:2000/web-socket/player";
		System.out.println("Connecting to " + uri);
		try {
			session = container.connectToServer(PlayerEndpoint.class,
					URI.create(uri));
		} catch (DeploymentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
