package com.riane.spczuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

public class MyRestTemplateFilter extends ZuulFilter {

    private RestTemplate restTemplate;

    public MyRestTemplateFilter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * to classify a filter by type. Standard types in Zuul are "pre" for pre-routing filtering,
     * "route" for routing to an origin, "post" for post-routing filters, "error" for error handling.
     * We also support a "static" type for static responses see  StaticResponseFilter.
     * Any filterType made be created or added and run by calling FilterProcessor.runFilters(type)
     *
     * @return A String representing that type
     */
    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    /**
     * filterOrder() must also be defined for a filter. Filters may have the same  filterOrder if precedence is not
     * important for a filter. filterOrders do not need to be sequential.
     *
     * @return the int order of a filter
     */
    @Override
    public int filterOrder() {
        return 2;
    }

    /**
     * a "true" return from this method means that the run() method should be invoked
     *
     * @return true if the run() method should be invoked. false will not invoke the run() method
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String uri = request.getRequestURI();
        StringBuffer url = request.getRequestURL();
        System.err.println("uri is " + uri);
        System.err.println("url is " + url);
        if (uri.indexOf("abc") != -1) {
            return true;
        }
        return false;
    }

    /**
     * if shouldFilter() is true, this method will be invoked. this method is the core method of a ZuulFilter
     *
     * @return Some arbitrary artifact may be returned. Current implementation ignores it.
     * @throws ZuulException if an error occurs during execution.
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        String serviceId = (String) requestContext.get("serviceId");
        String requestURI = (String) requestContext.get("requestURI");
        String url = "http://" + serviceId + requestURI;
        String object = this.restTemplate.getForObject(url, String.class);
        requestContext.setResponseBody(object+", this is my filter");
        requestContext.sendZuulResponse();
        return null;
    }
}
