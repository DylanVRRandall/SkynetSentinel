package com.google.randalldylan101.sentinel.service;

import com.google.gson.Gson;
import com.google.randalldylan101.sentinel.beans.RobotCPU;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RobotCPUService {
	public RobotCPU[] get() throws IOException {
		HttpGet request = new HttpGet("https://robotstakeover20210903110417.azurewebsites.net/robotcpu");

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(request)) {

			HttpEntity entity = response.getEntity();
			if (entity != null)
				return new Gson().fromJson(EntityUtils.toString(entity), RobotCPU[].class);

			return null;
		}
	}
}
