package org.jpractice.zuul.filter.error;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ROUTE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SIMPLE_HOST_ROUTING_FILTER_ORDER;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.HttpResponse;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class InternalServerErrorFilter extends ZuulFilter {

	private ProxyRequestHelper helper;

	public InternalServerErrorFilter(ProxyRequestHelper helper) {
		this.helper = helper;
	}

	@Override
	public String filterType() {
		return ROUTE_TYPE;
	}

	@Override
	public int filterOrder() {
        return SIMPLE_HOST_ROUTING_FILTER_ORDER + 1;
	}

	@Override
	public boolean shouldFilter() {

		return true;
	}

    private final static int[] REWRITE_CODES = new int[] { 400, 404, 500 };
	
	
	private final static String ERROR_MESSAGE = "内部错误，请查看后台日志。";


    private void rewriteResponse(int statusCode) throws ZuulException {

		byte[] bytes = ERROR_MESSAGE.getBytes(Charset.forName("UTF-8"));
		
		ByteArrayInputStream content = new ByteArrayInputStream(bytes);
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Content-Language", "zh-CN");
		headers.add("Content-Type", "text/plain;charset=UTF-8");
		headers.add("Content-Length", Integer.toString(bytes.length));
		try {
			this.helper.setResponse(statusCode, content, headers);
		} catch (IOException e) {
			throw new ZuulException(e, 500, ERROR_MESSAGE);
		}
	}

	@Override
	public Object run() throws ZuulException {
		HttpResponse response = (HttpResponse) RequestContext.getCurrentContext().get("zuulResponse");
		int statusCode = response.getStatusLine().getStatusCode();

		if (ArrayUtils.contains(REWRITE_CODES, statusCode)) {

			this.rewriteResponse(statusCode);
		}

		return null;
	}

}
