package config;

import org.apache.commons.lang3.RandomStringUtils;

public class Generator {
    private static final String domain_name = "@gmail.com";

    public static String generateUserName() {
        String name = RandomStringUtils.randomAlphabetic(8);
        return name;
    }

    public static String generateUserEmail() {
        String email = RandomStringUtils.randomAlphabetic(8) + domain_name;
        return email;
    }

    public static String generateUserPassword() {
        String password = RandomStringUtils.randomAlphabetic(8);
        return password;
    }

    public static String generateWrongUserPassword() {
        String wrongPassword = RandomStringUtils.randomAlphabetic(5);
        return wrongPassword;
    }
}
