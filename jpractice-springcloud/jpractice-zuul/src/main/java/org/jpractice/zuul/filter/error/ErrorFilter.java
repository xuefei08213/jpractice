package org.jpractice.zuul.filter.error;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ErrorFilter extends ZuulFilter {

    private static Logger log = LogManager.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("Inside Route Filter");
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            log.error("zuul调用出现异常 :" + ctx.getThrowable().getCause().getMessage(), ctx.getThrowable());
            ctx.getZuulResponseHeaders().clear();
            ctx.getResponse().reset();
            ctx.getResponse().setStatus(500);
        } catch (Exception ex) {
            throw ex;
        }
        return null;
    }

}