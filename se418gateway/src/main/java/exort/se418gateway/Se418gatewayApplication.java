package exort.se418gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class Se418gatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Se418gatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("ladder",r -> r.path("/ladder")
					.uri("https://ladder:8050/"))
			.build();
        //StripPrefixGatewayFilterFactory.Config config = new StripPrefixGatewayFilterFactory.Config();
        //config.setParts(1);
        //return builder.routes()
        //        .route("host_route", r -> r.path("/a/**").filters(f -> f.stripPrefix(1)).uri("http://ladder:8050"))
        //        .route("host_route", r -> r.path("/b/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:8040"))
        //        .build();
    }
}
