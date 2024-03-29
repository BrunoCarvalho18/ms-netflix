package com.netflix.gatewayzuul.filter;

import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ErrorFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(ErrorFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletResponse response = RequestContext.getCurrentContext().getResponse();

		log.info("ErrorFilter: " + String.format(" o status da resposta é %d", response.getStatus()));

		return null;
	}

	@Override
	public String filterType() {
		return "erro";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
