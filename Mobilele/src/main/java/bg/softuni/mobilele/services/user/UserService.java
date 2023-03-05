package bg.softuni.mobilele.services.user;

import bg.softuni.mobilele.domain.dtos.branding.UserLoginFormDto;
import bg.softuni.mobilele.domain.dtos.branding.UserRegisterFormDto;
import bg.softuni.mobilele.domain.dtos.model.UserModel;

public interface UserService {

    UserModel registerUser(UserRegisterFormDto userRegister);

    UserModel loginUser(UserLoginFormDto userLogin);

    void logout();
}
