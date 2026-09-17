package vn.demo.backend_java_service.service;

import vn.demo.backend_java_service.controller.request.SignInRequest;
import vn.demo.backend_java_service.controller.response.TokenResponse;

public interface AuthenticationService {

    TokenResponse getAccessToken(SignInRequest request);
    TokenResponse getRefreshToken(String request);
}
