package com.riane.spcnewzuul.process;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class MyFilterProcess extends FilterProcessor {

    @Override
    public void postRoute() throws ZuulException {
        try {
            super.postRoute();
        } catch (Exception ex) {
            RequestContext currentContext = RequestContext.getCurrentContext();
            currentContext.set("error.filter.type", "post");
            throw ex;
        }

    }

    @Override
    public Object runFilters(String sType) throws Throwable {
        try {
            return super.runFilters(sType);
        } catch (Exception ex) {
            RequestContext currentContext = RequestContext.getCurrentContext();
            currentContext.set("error.filter.type", sType);
            throw ex;
        }
    }
}
