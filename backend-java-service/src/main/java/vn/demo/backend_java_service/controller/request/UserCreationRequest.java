package vn.demo.backend_java_service.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import vn.demo.backend_java_service.common.Gender;
import vn.demo.backend_java_service.common.UserType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@ToString
public class UserCreationRequest implements Serializable {
    @NotBlank(message = "First name not blank")
    private String firstName;
    @NotBlank(message = "Last name not blank")
    private String lastName;
    private Gender gender;
    private Date birthday;
    private String username;
    @Email(message = "Email invalid")
    private String email;
    private String phone;
    private UserType type;
    private List<AddressRequest> addresses;
}
