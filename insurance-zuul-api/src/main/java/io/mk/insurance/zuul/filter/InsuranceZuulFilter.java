package io.mk.insurance.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class InsuranceZuulFilter extends ZuulFilter {


	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		String headerAuth = request.getHeader("authorization");
		if (headerAuth == null) {
			throw new RuntimeException("Header missing");
		}

//		System.out.println("calling jwt " + headerAuth);
//		String response = jwtClient.getResponse(headerAuth);
//		System.out.println("res " + response);
//		try {
//			
//			URI url = new URI("http://localhost:8040/insurance-jwt-service/verifytoken");
//			ResponseEntity<String> exchange = new RestTemplate().exchange(url, HttpMethod.GET, entity, String.class);
//			System.out.println("got respo " + exchange.getBody());
//			return null;
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
