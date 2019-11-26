<<<<<<< HEAD
package com.netflix.gatewayzuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class RouteFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(RouteFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		log.info("RouteFilter: " + String.format("%s request para %s", request.getMethod(), request.getRequestURL().toString()));
		
		return null;
	}

	@Override
	public String filterType() {
		return "rota";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
=======
<<<<<<< HEAD
package com.netflix.gatewayzuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class RouteFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(RouteFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		log.info("RouteFilter: " + String.format("%s request para %s", request.getMethod(), request.getRequestURL().toString()));
		
		return null;
	}

	@Override
	public String filterType() {
		return "rota";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
=======
package com.netflix.gatewayzuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class RouteFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(RouteFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		log.info("RouteFilter: " + String.format("%s request para %s", request.getMethod(), request.getRequestURL().toString()));
		
		return null;
	}

	@Override
	public String filterType() {
		return "rota";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
>>>>>>> branch 'master' of https://github.com/BrunoCarvalho18/ms-netflix.git
>>>>>>> branch 'master' of https://github.com/BrunoCarvalho18/ms-netflix.git
