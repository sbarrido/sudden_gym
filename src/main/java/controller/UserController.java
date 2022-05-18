package controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.UserService;

/**
 * Controller Class for Endpoints
 * Involved in User table transactions
 */
@RestController
public class UserController {

    //Service helper -- Connects to invoice table
    private UserService usrService = new UserService();

    /** GET endpoint for all users
     * 
     * @return target: string, all users listed
     */
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

     /** GET endpoint for designated user
     * 
     * @return target: string, designated user listed
     */
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