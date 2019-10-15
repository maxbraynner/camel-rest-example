package com.max.camelrest.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		restConfiguration()
			.bindingMode(RestBindingMode.json);

		rest()
			.produces(MediaType.APPLICATION_JSON_VALUE)
			.consumes(MediaType.APPLICATION_JSON_VALUE)
			
			.get("/health").route().setBody(constant("Ok")).endRest();
	}

}
