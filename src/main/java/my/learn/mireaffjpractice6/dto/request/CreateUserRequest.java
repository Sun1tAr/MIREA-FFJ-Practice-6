package my.learn.mireaffjpractice6.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateUserRequest {

    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    @Email
    private String email;

}
