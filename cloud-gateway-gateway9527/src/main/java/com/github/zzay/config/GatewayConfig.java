package com.github.zzay.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zzay
 * @className GatewayConfig
 * @description Gateway Configuration
 * @create 2022/05/03 22:18
 */
@Configuration
public class GatewayConfig {

    /**
     * 配置了一个id为route-name的路由规则，
     * 当访问地址 http://localhost:9527/guonei时会自动转发到地址：http://news.baidu.com/guonei
     *
     * @param routeLocatorBuilder RouteLocatorBuilder
     * @return RouteLocator
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_zzay", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    /**
     * 配置了一个id为route-name的路由规则，
     * 当访问地址 http://localhost:9527/guoji时会自动转发到地址：http://news.baidu.com/guoji
     *
     * @param routeLocatorBuilder RouteLocatorBuilder
     * @return RouteLocator
     */
    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_zzay2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }

}
