package org.bq.elastic;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@ComponentScan
@EnableElasticsearchRepositories(basePackages = "org.bq.elastic.repository")
@PropertySource("classpath:application.properties")
public class ElasticSearchMainConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(ElasticSearchMainConfiguration.class);

	@Autowired
	private Environment environment;

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		return new ElasticsearchTemplate(client());
	}

	@SuppressWarnings("resource")
	@Bean
	public Client client() {
		Settings settings = Settings.builder()
				.put("cluster.name", environment.getProperty("spring.data.elasticsearch.properties.cluster-name"))
				.build();
		TransportClient client = null;
		try {
			client = new PreBuiltTransportClient(settings)
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		} catch (UnknownHostException e) {
			LOG.error("error creating client elasticsearch");
			throw new RuntimeException("error creating client elasticsearch");
		}
		return client;
	}

}
