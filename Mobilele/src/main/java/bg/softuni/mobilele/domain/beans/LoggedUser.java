package bg.softuni.mobilele.domain.beans;

import bg.softuni.mobilele.domain.dtos.model.UserRoleModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoggedUser {

    private String id;
    private String username;
    private List<UserRoleModel> roleModels;

    public void clearFields() {
        this.id = null;
        this.username = null;
        this.roleModels = null;
    }
}
