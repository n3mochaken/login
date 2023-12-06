import java.sql.SQLOutput;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void validateUser(String login, String password, String confirmPassword) {
        try {
            validateLogin(login);
            validatePassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    private static void validateLogin(String login) throws WrongLoginException {
        if (login.length() > 20 || !login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Invalid login");
        }
    }

    private static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password.length() > 20 || !password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Invalid password");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Passwords don't match");
        }
    }

    public static void main(String[] args) {
        String login = "aasd";
        String password = "11";
        String confirmPassword = "1111";

        validateUser(login, password, confirmPassword);
    }
}


