package pro.sky.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.demo.exeptions.WrongLoginException;
import pro.sky.demo.exeptions.WrongPasswordException;

@RestController
public class InputController {

    private final String CONFIRMED_PASSWORD = "D_1hWiKjjP_9";

    private final InputService inputService;

    public InputController(InputService inputService) {
        this.inputService = inputService;
    }

    @GetMapping
    public String hello() {
        return inputService.hello();
    }


    @GetMapping(path = "/validation")
    public String validation(@RequestParam(required = false) String login, @RequestParam(required = false) String password) {
        try {
            return inputService.validation(login, password, CONFIRMED_PASSWORD);
        } catch (NullPointerException | WrongLoginException | WrongPasswordException e) {
            return "Input login and password";
        }
    }
}
