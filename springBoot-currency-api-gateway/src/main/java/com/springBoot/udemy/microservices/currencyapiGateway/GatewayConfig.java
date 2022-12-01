package com.springBoot.udemy.microservices.currencyapiGateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route(p -> p.path("/get") // consider this path
					.filters(f-> f.addRequestHeader("MyHeader", "saman") // add header
							.addRequestParameter("myParam", "Hello")) // add param before routing
					.uri("http://httpbin.org:80")) // redirect to this path- this path is a path which shows the details of a request
				.route(p-> p.path("/currency-exchange/**") // ** stands for the anything after this point (regular expression)
						.uri("lb://currency-exchange"))  // lb is used to perform load balancing by gateway, it means that find current-exchange from eureka and route to the path
				
				.route(p-> p.path("/currency-conversion/**")
						.uri("lb://currency-converter"))
				
				.route(p-> p.path("/currency-conversion-saman/**") // to add a custom uri and rewrite the path 
																		// (?<name>capturing text) to define a named group "name": a named group capturing in java regex
																		// it captures the string which is ".*" in our case and assigns to a group named "segment"
																		// we can get the value of the captured group by ${name} :to reference to captured group in Matcher's replacement string
																		// here we say take .* and append to the next path in the place of ${segment} (the group name is segment)
						// more info : https://stackoverflow.com/questions/415580/regex-named-groups-in-java
						.filters(f -> f.rewritePath("/currency-conversion-saman/(?<segment>.*)", "/currency-conversion/${segment}")) // change the path before redirecting
						.uri("lb://currency-converter")										
						)
				
				.build();
		
		
	}
}
