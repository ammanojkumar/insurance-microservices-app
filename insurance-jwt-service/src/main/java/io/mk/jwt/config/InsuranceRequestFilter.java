package io.mk.jwt.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.mk.jwt.exception.TokenExpiryException;
import io.mk.jwt.service.InsuranceUserDetailsService;

@Component
public class InsuranceRequestFilter extends OncePerRequestFilter {

	@Autowired
	private InsuranceUserDetailsService studentUserDetailsService;

	@Autowired
	private AuthTokenUtil studentTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String jwtToken = request.getHeader("Authorization");

		String username = null;
		if (jwtToken != null) {
			try {
				username = studentTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
				throw new RuntimeException("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
				throw new TokenExpiryException("JWT Token has expired");
			}

			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = studentUserDetailsService.loadUserByUsername(username);

				if (studentTokenUtil.validateToken(jwtToken, userDetails)) {
					UsernamePasswordAuthenticationToken ustoken = new UsernamePasswordAuthenticationToken(userDetails,
							null, userDetails.getAuthorities());
					ustoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(ustoken);
				} else {
					System.out.println("JWT Token has expired");
					throw new RuntimeException("JWT Token has expired");
				}
			}
		}
		filterChain.doFilter(request, response);
	}
}
