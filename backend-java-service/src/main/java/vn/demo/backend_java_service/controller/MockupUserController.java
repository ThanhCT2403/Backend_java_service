package vn.demo.backend_java_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.demo.backend_java_service.common.Gender;
import vn.demo.backend_java_service.controller.request.UsePasswordRequest;
import vn.demo.backend_java_service.controller.request.UserCreationRequest;
import vn.demo.backend_java_service.controller.request.UserUpdateRequest;
import vn.demo.backend_java_service.controller.response.UserResponse;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mockup/user")
@Tag(name = "Mockup User Controller")
public class MockupUserController {
    @Operation(summary = "Set user list", description = "API retrive user from db")
    @GetMapping("/list")
    public Map<String, Object> getList(@RequestParam(required = false) String keyword,
                                      @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "25") int size) {
        UserResponse userResponse1 = new UserResponse();
        userResponse1.setId(1L);
        userResponse1.setFirstName("Thanh");
        userResponse1.setLastName("CT");
        userResponse1.setGender(Gender.FEMALE);
        userResponse1.setBirthday(new Date());
        userResponse1.setUsername("admin");
        userResponse1.setEmail("admin@gmail.com");
        userResponse1.setPhone("0982441788");

        UserResponse userResponse2 = new UserResponse();
        userResponse2.setId(1L);
        userResponse2.setFirstName("Thanh");
        userResponse2.setLastName("CT");
        userResponse2.setGender(Gender.MALE);
        userResponse2.setBirthday(new Date());
        userResponse2.setUsername("admin");
        userResponse2.setEmail("admin@gmail.com");
        userResponse2.setPhone("0982441788");

        List<UserResponse> userResponseList = List.of(userResponse1, userResponse2);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.OK.value());
        result.put("message", "Users List");
        result.put("data", userResponseList);

        return result;
    }

    @Operation(summary = "Set user detail", description = "API retrive user from db")
    @GetMapping("/{userId}")
    public Map<String, Object> getUserDetail(@PathVariable Long userId) {
        UserResponse userResponse2 = new UserResponse();
        userResponse2.setId(1L);
        userResponse2.setFirstName("Thanh");
        userResponse2.setLastName("CT");
        userResponse2.setGender(Gender.MALE);
        userResponse2.setBirthday(new Date());
        userResponse2.setUsername("admin");
        userResponse2.setEmail("admin@gmail.com");
        userResponse2.setPhone("0982441788");
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.OK.value());
        result.put("message", "Users List");
        result.put("data", userResponse2);

        return result;
    }

    @Operation(summary = "Create User", description = "API add new user from db")
    @PostMapping("/create")
    public Map<String, Object> createUser(UserCreationRequest request) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.CREATED.value());
        result.put("message", "Users created successfully");
        result.put("data", 3);

        return result;
    }

    @Operation(summary = "Update User", description = "API update new user from db")
    @PutMapping("/update")
    public Map<String, Object> updateUser(UserUpdateRequest request) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.ACCEPTED.value());
        result.put("message", "Users updated successfully");
        result.put("data", "");

        return result;
    }

    @Operation(summary = "Change Password", description = "API update new user from db")
    @PatchMapping("/{user-id}/change-password")
    public Map<String, Object> changePassword(UsePasswordRequest request) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.NO_CONTENT.value());
        result.put("message", "Password updated successfully");
        result.put("data", "");

        return result;
    }

    @Operation(summary = "Delete User", description = "API delete user from db")
    @DeleteMapping("/delete/{user-id}")
    public Map<String, Object> deleteUser(@PathVariable Long userId) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.RESET_CONTENT.value());
        result.put("message", "Delete successfully");
        result.put("data", "");

        return result;
    }
}
