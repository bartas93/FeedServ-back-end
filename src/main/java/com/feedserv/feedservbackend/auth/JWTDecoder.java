package com.feedserv.feedservbackend.auth;

import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTDecoder {

	public static JWTEntity getJwtEntity(String jwtToken) {
		String jsonBody = getJwtBody(jwtToken);
		return getJwtEntityFromJson(jsonBody);
	}

	private static JWTEntity getJwtEntityFromJson(String jsonBody) {
		ObjectMapper objectMapper = new ObjectMapper();
		JWTEntity jwtEntity = null;
		try {
			jwtEntity = objectMapper.readValue(jsonBody, JWTEntity.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jwtEntity;
	}

	private static String getJwtBody(String jwtToken) {
		String[] split_string = jwtToken.split("\\.");
		String base64EncodedBody = split_string[1];

		Base64 base64Url = new Base64(true);
		String body = new String(base64Url.decode(base64EncodedBody));
		return body;
	}

}
