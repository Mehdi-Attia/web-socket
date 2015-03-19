package edu.espritmobile.decoders;

import java.io.IOException;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import org.codehaus.jackson.map.ObjectMapper;

import edu.espritmobile.classes.Player;

public class PlayerDecoder implements Decoder.Text<Player> {

	@Override
	public void init(EndpointConfig config) {
	}

	@Override
	public void destroy() {
	}

	@Override
	public Player decode(String s) throws DecodeException {
		Player player = null;
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			player = objectMapper.readValue(s, Player.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return player;
	}

	@Override
	public boolean willDecode(String s) {
		return s != null;
	}

}
