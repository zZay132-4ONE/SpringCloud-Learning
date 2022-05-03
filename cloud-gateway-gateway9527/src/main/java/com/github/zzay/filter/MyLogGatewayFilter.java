package com.github.zzay.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author zzay
 * @className MyLogGatewayFilter
 * @description Log Gateway Filter
 * @create 2022/05/03 22:49
 */
@Component
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

    /**
     * Filter
     *
     * @param exchange ServerWebExchange
     * @param chain    GatewayFilterChain
     * @return Mono
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Time: " + new Date() + "\t"
                + "Conduct customized global gateway filter: MyLogGateWayFilter");
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null) {
            System.out.println("======== Username is null, cannot log in ! ========");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * Filter order level
     *
     * @return Filter order level
     */
    @Override
    public int getOrder() {
        return 0;
    }

}
