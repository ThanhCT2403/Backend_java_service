package vn.demo.backend_java_service.service;

import vn.demo.backend_java_service.controller.request.UsePasswordRequest;
import vn.demo.backend_java_service.controller.request.UserCreationRequest;
import vn.demo.backend_java_service.controller.request.UserUpdateRequest;
import vn.demo.backend_java_service.controller.response.UserPageResponse;
import vn.demo.backend_java_service.controller.response.UserResponse;
import vn.demo.backend_java_service.model.UserEntity;

import java.util.List;

public interface UserService {

    UserPageResponse findAll(String keyword, String sort, int page, int size);

    UserResponse findById(Long id);

    UserResponse findByUserName(String username);

    UserResponse findByEmail(String email);

    long save(UserCreationRequest req);

    void update(UserUpdateRequest req);

    void changePassword(UsePasswordRequest req);

    void delete(Long id);
}
