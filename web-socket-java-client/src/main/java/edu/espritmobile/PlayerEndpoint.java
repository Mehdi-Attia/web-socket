package edu.espritmobile;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;

import edu.espritmobile.classes.Player;
import edu.espritmobile.decoders.PlayerDecoder;
import edu.espritmobile.encoders.PlayerEncoder;

@ClientEndpoint(decoders = PlayerDecoder.class, encoders = PlayerEncoder.class)
public class PlayerEndpoint {

	@OnMessage
	public void message(Player player) {

		System.out.println("Received msg: " + player);
	}
}
