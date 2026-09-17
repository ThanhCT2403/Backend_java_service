package vn.demo.backend_java_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import vn.demo.backend_java_service.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceDetail {

    private final UserRepository userRepository;
    public UserDetailsService UserServiceDetail() {
        return userRepository::findByUsername;
    }
}
