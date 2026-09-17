package vn.demo.backend_java_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.demo.backend_java_service.common.Gender;
import vn.demo.backend_java_service.controller.request.UsePasswordRequest;
import vn.demo.backend_java_service.controller.request.UserCreationRequest;
import vn.demo.backend_java_service.controller.request.UserUpdateRequest;
import vn.demo.backend_java_service.controller.response.UserPageResponse;
import vn.demo.backend_java_service.controller.response.UserResponse;
import vn.demo.backend_java_service.model.UserEntity;
import vn.demo.backend_java_service.service.UserService;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Tag(name = "User Controller")
@Slf4j(topic = "USER-CONTROLLER")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @Operation(summary = "Set user list", description = "API retrive user from db")
    @GetMapping("/list")
    public Map<String, Object> getList(@RequestParam(required = false) String keyword,
                                    @RequestParam(required = false) String sort,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "25") int size) {
        log.info("Get user list");
        UserPageResponse userList = userService.findAll(keyword, sort, page, size);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.OK.value());
        result.put("message", "Users List");
        result.put("data", userList);

        return result;
    }

    @Operation(summary = "Set user detail", description = "API retrive user from db")
    @GetMapping("/{userId}")
    public Map<String, Object> getUserDetail(@PathVariable @Min(value = 1, message = "User must be greater than 0") Long userId) {
        UserResponse userResponse = userService.findById(userId);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.OK.value());
        result.put("message", "Users List");
        result.put("data", userResponse);

        return result;
    }

    @Operation(summary = "Create User", description = "API add new user from db")
    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody @Valid UserCreationRequest request) {
        log.info("Create User: {}", request);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.CREATED.value());
        result.put("message", "Users created successfully");
        result.put("data", userService.save(request));

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Operation(summary = "Update User", description = "API update new user from db")
    @PutMapping("/upd")
    public Map<String, Object> updateUser(@RequestBody @Valid UserUpdateRequest request) {
        log.info("Update user: {}", request);
        userService.update(request);
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.ACCEPTED.value());
        result.put("message", "Users updated successfully");
        result.put("data", "");

        return result;
    }

    @Operation(summary = "Change Password", description = "API update new user from db")
    @PatchMapping("/change-pwd")
    public Map<String, Object> changePassword(@RequestBody UsePasswordRequest request) {
        log.info("Change password for user: {}", request);
        userService.changePassword(request);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.NO_CONTENT.value());
        result.put("message", "Password updated successfully");
        result.put("data", "");

        return result;
    }

    @GetMapping("/confirm-email")
    public void confirmEmail(@RequestParam String secretCode, HttpServletResponse response) throws IOException {
        log.info("Confirm email: {}", secretCode);
        try {

        } catch (Exception e) {
            log.error("Confirm Email was failure, errorMessage={}", e.getMessage());
        } finally {
            response.sendRedirect("https://google.com");
        }
    }

    @Operation(summary = "Delete User", description = "API delete user from db")
    @DeleteMapping("/delete/{userId}")
    public Map<String, Object> deleteUser(@PathVariable @Min(value = 1, message = "User must be greater than 0") Long userId) {
        log.info("Deleting user: {}", userId);

        userService.delete(userId);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.RESET_CONTENT.value());
        result.put("message", "Delete successfully");
        result.put("data", "");

        return result;
    }
}
