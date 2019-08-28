/**
 * 
 */
package org.jpractice.zuul.filter.error;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jpractice.zuul.FilterConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author: 作者： chengaofeng
 * @date: 创建时间：2018-10-30 08:48:42
 * @Description: TODO
 * @version V1.0
 */
public class ExceptionHandlerFilter extends ZuulFilter {
	private static Logger log = LogManager.getLogger(ExceptionHandlerFilter.class);
	protected static final String EXCEPTION_FILTER_RAN = "exception.ran";
    protected static final String SEND_ERROR_FILTER_RAN = "sendErrorFilter.ran";
    private ProxyRequestHelper helper;

    @Value("${error.path:/error}")
    private String errorPath;

    public ExceptionHandlerFilter(ProxyRequestHelper helper) {
        this.helper = helper;
    }
	@Override
	public String filterType() {
		return FilterConstants.ERROR_TYPE;
	}

	@Override
	public int filterOrder() {
        return FilterConstants.SEND_ERROR_FILTER_ORDER - 1;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();

		// only forward to errorPath if it hasn't been forwarded to already
		return ctx.getThrowable() != null && !ctx.getBoolean(EXCEPTION_FILTER_RAN, false);
	}

    private final static String ERROR_MESSAGE = "内部错误，请查看后台日志。";

    private void rewriteResponse() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getZuulResponseHeaders().clear();
        ctx.getResponse().reset();

        byte[] bytes = ERROR_MESSAGE.getBytes(Charset.forName("UTF-8"));

        ByteArrayInputStream content = new ByteArrayInputStream(bytes);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Language", "zh-CN");
        headers.add("Content-Type", "text/plain;charset=UTF-8");
        headers.add("Content-Length", Integer.toString(bytes.length));
        try {
            this.helper.setResponse(500, content, headers);
        } catch (IOException e) {
            throw new ZuulException(e, 500, ERROR_MESSAGE);
        }
    }

	@Override
    public Object run() throws ZuulException {
        // rewriteResponse();
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        RequestDispatcher dispatcher = request.getRequestDispatcher(this.errorPath);
        if (dispatcher != null) {
            ctx.set(SEND_ERROR_FILTER_RAN, true);
            if (!ctx.getResponse().isCommitted()) {
                ctx.setResponseStatusCode(500);
                try {
                    dispatcher.forward(request, ctx.getResponse());
                } catch (Exception e) {
                    throw new ZuulException(e, 500, ERROR_MESSAGE);
                }
            }
        }

		return null;
	}
}
