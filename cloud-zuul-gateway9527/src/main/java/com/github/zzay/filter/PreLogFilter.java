package com.github.zzay.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author zzay
 * @className PreLogFilter
 * @description Conduct logs before mapping routes (Pre-Filter)
 * @create 2022/05/03 17:27
 */
@Slf4j
@Component
public class PreLogFilter extends ZuulFilter {

    /**
     * Set the type of filtering
     *
     * @return Type of filtering
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * Set the order level of the filter (1 represents the greatest)
     *
     * @return Order level of the filter
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * Set whether the filter should work or not
     *
     * @return Whether the filter should work or not
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * Run
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String host = request.getRemoteHost();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        System.out.println("======== " + new Date().getTime() + " ========");
        return null;
    }

}
