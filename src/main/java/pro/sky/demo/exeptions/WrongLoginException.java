package pro.sky.demo.exeptions;

public class WrongLoginException extends Exception {

    public WrongLoginException(String message) {
        super(message);
    }
}
