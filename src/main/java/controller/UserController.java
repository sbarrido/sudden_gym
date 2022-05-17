package controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.UserService;

@RestController
public class UserController {
    private UserService usrService = new UserService();

    @GetMapping("/user")
    public String user() {
        String target = null;
        try{
            target = usrService.readAll();
        }catch(Exception ex) {
            System.out.println(ex);
        }

        return target;
    }
    @GetMapping("/user/{id}")
    public String getUserbyID(@PathVariable String id) {
        String target = null;

        try {
            target = usrService.read(Integer.valueOf(id));
        }catch(Exception ex) {
            System.out.println(ex);
        }

        return target;
    }
}