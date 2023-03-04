package bg.softuni.mobilele.domain.dtos.branding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginFormDto {
    private String username;
    private String password;
}
