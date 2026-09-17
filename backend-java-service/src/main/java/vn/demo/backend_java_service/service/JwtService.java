package vn.demo.backend_java_service.service;

import org.springframework.security.core.GrantedAuthority;
import vn.demo.backend_java_service.common.TokenType;

import java.util.Collection;

public interface JwtService {
    String generateAccessToken(long userId, String username, Collection<? extends GrantedAuthority> authorities);
    String generateRefreshToken(long userId, String username, Collection<? extends GrantedAuthority> authorities);
    String extractUsername(String token, TokenType type);
}
