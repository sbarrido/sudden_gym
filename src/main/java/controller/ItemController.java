package controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.ItemService;


/**
 * Controller Class for Endpoints
 * Involved in Item table transactions
 */
@RestController
public class ItemController {

    //Service helper -- Connects to invoice table
    private ItemService itmService = new ItemService();

    /** GET endpoint for all items
     * 
     * @return target: string, all items listed
     */
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

    /** GET endpoint for designated invoices
     * 
     * @return target: string, designated invoices listed
     */
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
