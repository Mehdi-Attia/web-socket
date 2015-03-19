package edu.espritmobile;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import edu.espritmobile.classes.Data;
import edu.espritmobile.classes.Player;
import edu.espritmobile.decoders.PlayerDecoder;
import edu.espritmobile.encoders.PlayerEncoder;

@ServerEndpoint(value = "/player", decoders = { PlayerDecoder.class, }, encoders = { PlayerEncoder.class })
@Stateless
public class PlayerEndpoint {

	@OnMessage
	public void onMessage(Player player, Session session) throws IOException,
			InterruptedException {

		// Print the client message for testing purposes
		System.out.println("Received: " + player);

		// Send 3 messages to the client every 5 seconds
		int sentMessages = 0;
		while (sentMessages < 3) {
			Thread.sleep(3000);
			session.getAsyncRemote().sendObject(Data.getPlayer());
			sentMessages++;
		}
	}

	@OnOpen
	public void onOpen() {
		System.out.println("Client connected");

	}

	@OnClose
	public void onClose() {
		System.out.println("Connection closed");
	}
}
