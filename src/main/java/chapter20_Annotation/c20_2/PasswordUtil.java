package chapter20_Annotation.c20_2;

import chapter20_Annotation.c20_1.UseCase;

import java.util.List;

/**
 * 应用自定义注解 @UseCase的类
 */
public class PasswordUtil {

    @UseCase(id=47,description="Passwords must contain at least one numermic")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id=48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id=49, description="New password can't equal previous ones")
    public boolean checkForNewPassword(List<String> previousPasswords, String password) {
        return !previousPasswords.contains(password);
    }
}
