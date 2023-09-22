package com.ecommerceproject.ElasticSearchClient;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.TransportUtils;
import co.elastic.clients.transport.rest_client.RestClientTransport;

@Configuration
public class ElasticSearchConfig {
	
		@Value("${spring.elasticsearch.rest.username}")
		private String username;
		@Value("${spring.elasticsearch.rest.password}")
		private String password;
		@Value("${elasticsearch.port}")
		private String port;
		@Value("${elasticsearch.host}")
		private String host;
		
		String fingerprint= "41e4002cbd557d28290a5f208445e5efa0abaa1ce991199a40d40c978d695c50";
	
	@Bean
	public RestClient elasticsearchRestClient()
	{
		try {
			SSLContext sslContext = TransportUtils
			    .sslContextFromCaFingerprint(fingerprint); 

			BasicCredentialsProvider credsProv = new BasicCredentialsProvider(); 
			credsProv.setCredentials(
			    AuthScope.ANY, new UsernamePasswordCredentials(username, password)
			);

			RestClient restClient = RestClient
			    .builder(new HttpHost(host,Integer.parseInt(port) , "https")) 
			    .setHttpClientConfigCallback(hc -> hc
			        .setSSLContext(sslContext) 
			        .setDefaultCredentialsProvider(credsProv)
			    ).build();

			// Create the transport and the API client
			ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
			ElasticsearchClient client = new ElasticsearchClient(transport);
			return restClient;
					}
					catch(Exception e) {
						e.printStackTrace();
						return null;
					}
			}

	}
