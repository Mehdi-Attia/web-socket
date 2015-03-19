package edu.espritmobile.encoders;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import edu.espritmobile.classes.Player;

public class PlayerEncoder implements Encoder.Text<Player> {

	@Override
	public void init(EndpointConfig config) {
	}

	@Override
	public void destroy() {

	}

	@Override
	public String encode(Player player) throws EncodeException {
		String json = null;
		ObjectWriter ow = new ObjectMapper().writer()
				.withDefaultPrettyPrinter();
		try {
			json = ow.writeValueAsString(player);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

}
