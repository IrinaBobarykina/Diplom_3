package utils;

import org.apache.commons.lang3.RandomStringUtils;
import user.User;

public class Generator {
    private static final String domain_name = "@gmail.com";

    public static String generateUserName() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public static String generateUserEmail() {
        return RandomStringUtils.randomAlphabetic(8) + domain_name;
    }

    public static String generateUserPassword() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public static String generateWrongUserPassword() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public static User generateUser() {
        String name = generateUserName();
        String email = generateUserEmail();
        String password = generateUserPassword();
        return new User(name, email, password);
    }
}
