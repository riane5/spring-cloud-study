package com.riane.spcnewzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ERROR_TYPE;

@Component
public class MyErrorFilter extends SendErrorFilter {

    @Override
    public String filterType() {
        return ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        if (null != currentContext.get("error.filter.type") && currentContext.get("error.filter.type").equals("post")) {
            return true;
        }
        return false;
    }

    /*@Override
    public Object run() throws ZuulException {
        System.err.println("running my error ");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        request.setAttribute("javax.servlet.error.status_code", 1000);

        request.setAttribute("javax.servlet.error.exception", "test exception");
        request.setAttribute("javax.servlet.error.message", "test exception meaasge");
        currentContext.set("sendErrorFilter.ran", true);
        if (!currentContext.getResponse().isCommitted()) {
            currentContext.setResponseStatusCode(10001);
            //currentContext.setResponseBody(request.toString());
            //currentContext.sendZuulResponse();
            //dispatcher.forward(request, ctx.getResponse());
        }
        currentContext.setResponseBody(request.toString());
        currentContext.sendZuulResponse();
        return null;
    }*/
}
