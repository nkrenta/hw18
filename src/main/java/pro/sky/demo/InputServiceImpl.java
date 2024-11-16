package pro.sky.demo;

import org.springframework.stereotype.Service;
import pro.sky.demo.exeptions.WrongLoginException;
import pro.sky.demo.exeptions.WrongPasswordException;

import java.util.regex.Pattern;

@Service
public class InputServiceImpl implements InputService {

    private final Pattern LOGIN_PATTERN = Pattern.compile("[a-zA-Z0-9_]{1,20}");
    private final Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9_]{1,20}");

    public String hello() {
        return """
                Hi! It's a Web Page with validation login and password!\s
                Input your login and password like: http://localhost:8080/validation?login=1&password=2
                """;
    }

    public String validation(String login, String password, String confirmPassword) {
        try {
            validationLogin(login);
            validationPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e){
            return e.getMessage();
        }
        return "Validation finished!";
    }

    public void validationLogin(String login) throws WrongLoginException {
        if (!LOGIN_PATTERN.matcher(login).matches()) {
            throw new WrongLoginException("Invalid login!");
        }
    }

    public void validationPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new WrongPasswordException("Invalid password!");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("password isn't correct");
        }
    }
}
