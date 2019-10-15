package com.max.camelrest.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.max.camelrest.dto.Order;
import com.max.camelrest.service.OrderService;

@Component
public class OrderRoute extends RouteBuilder {

	private final OrderService orderService;
	
	public OrderRoute(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@Override
	public void configure() throws Exception {
		
		rest("/orders").description("Order REST service")
			.consumes(MediaType.APPLICATION_JSON_VALUE)
			.produces(MediaType.APPLICATION_JSON_VALUE)
		
			.get()
				.outType(Order[].class)
			.route()
				.process(exchange -> exchange.getOut().setBody(orderService.getOrders()))
			.endRest()
			
			.post()
				.type(Order.class)
				.outType(Order.class)
			.route()
				.process(exchange -> orderService.addOrder(exchange.getIn().getBody(Order.class)))
			.endRest();
		
	}

}
