package controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.ItemService;

@RestController
public class ItemController {
    private ItemService itmService = new ItemService();

    @GetMapping("/item")
    public String item() {
        String target = null;
        try{
            target = itmService.readAll();
        }catch(Exception ex) {
            System.out.println(ex);
        }

        return target;
    }

    @GetMapping("/item/{id}")
    public String getItemByID(@PathVariable String id) {
        String target = null;

        try {
            target = itmService.read(Integer.valueOf(id));
        }catch(Exception ex) {
            System.out.println(ex);
        }

        return target;
    }
}
