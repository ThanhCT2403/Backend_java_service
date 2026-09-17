package vn.demo.backend_java_service.controller.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UsePasswordRequest implements Serializable {
    @NotNull(message = "id must be not null")
    @Min(value = 1, message = "User must be greater than 0")
    private Long id;
    @NotBlank(message = "Password must be not blank")
    private String password;
    @NotBlank(message = "Confirm Password must be not blank")
    private String confirmPassword;
}
