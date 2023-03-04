package bg.softuni.mobilele.domain.dtos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private List<UserRoleModel> role;
    private String imageUrl;
    private Date created;
    private Date modified;


    public boolean isValid() {
        return this.id != null;
    }
}
