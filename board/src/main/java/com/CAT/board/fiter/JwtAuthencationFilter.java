package com.CAT.board.fiter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.CAT.board.security.TokenProvider;

import antlr.StringUtils;

@Component
public class JwtAuthencationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	//request�� ������ ��, Request Header�� Authorization �ʵ��� Bearer Token�� ������
	//������ Token�� �����ϰ� ���� ����� SecurityContext�� �߰�
	
	/**@Autowired private TokenProvider tokenProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			String token = parseBearerToken(request);
			
			if(token != null && !token.equalsIgnoreCase("null")) {
				// ��ū �����ؼ� payload�� userEmail ������
				String userEmail = tokenProvider.validate(token);
				
				// SecurityContext�� �߰��� ��ü
				AbstractAuthenticationToken authentication =
						new UsernamePasswordAuthenticationToken(userEmail, null, AuthorityUtils.NO_AUTHORITIES);
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				// SecurityContext�� AbstractAuthenticationToken ��ü�� �߰��ؼ�
				// �ش� Thread�� ���������� ���� ������ ���� �� �ֵ��� ����
				SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
				securityContext.setAuthentication(authentication);
				SecurityContextHolder.setContext(securityContext);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		filterChain.doFilter(request, response);

	}
	
	// Request Header�� Authorization �ʵ��� Bearer Token�� ������
	private String parseBearerToken(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		
		//if(StringUtils.isBlank(bearerToken)&& bearerToken.startsWith("Bearer "))
		//	return bearerToken.substring(7);
		return null;
		
	}**/

}