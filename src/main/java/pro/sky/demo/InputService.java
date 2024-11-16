package pro.sky.demo;

import pro.sky.demo.exeptions.WrongLoginException;
import pro.sky.demo.exeptions.WrongPasswordException;

public interface InputService {
    String hello();
    String validation(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException;
}
