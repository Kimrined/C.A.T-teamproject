package com.CAT.board.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// JWT : ���� ������ �� ��ū
// JSON ���·� ������ ��ū
// (header).(payload).(signature)

// header: typ (�ش� ��ū�� Ÿ��), alg(��ū�� �����ϱ� ���� ���� �ؽ� �˰���)
// payload: sub (�ش� ��ū�� ����), iat (��ū�� ����� �ð�), exp (��ū�� ����Ǵ� �ð�)

@Service
public class TokenProvider {
	// JWT ���� �� ������ ���� Ű
	private static final String SECURITY_KEY = "jwtseckey!@";
	
	// JWT �����ϴ� �޼���
	public String create (String userEmail) {
		// ���� ��¥�� ���� ��¥ + 1�ð����� ����
		Date exprTime = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
		
		// JWT�� ����
		return Jwts.builder()
				// ��ȣȭ�� ���� �˰���, Ű
				.signWith(SignatureAlgorithm.HS512, SECURITY_KEY)
				// JWT ����, ������, ������ 
				.setSubject(userEmail).setIssuedAt(new Date()).setExpiration(exprTime)
				// ����
				.compact();
	}
	
	// JWT ����
	public String validate (String token) {
		// �Ű������� ���� token�� Ű�� ����ؼ� ��ȣȭ (���ڵ�)
		Claims claims = (Claims) Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token).getBody();
		// ��ȣȭ�� ��ū�� payload���� ������ �����´�.
		return claims.getSubject();
	}
}
