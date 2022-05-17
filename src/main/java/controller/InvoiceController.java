package controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.InvoiceService;

@RestController
public class InvoiceController {
    private InvoiceService iService = new InvoiceService();

    @GetMapping("/invoice")
    public String invoice() {
        String target = null;
        try{
            target = iService.readAll();
        }catch(Exception ex) {
            System.out.println(ex);
        }

        return target;
    }

    @GetMapping("/invoice/{id}")
    public String getInvoiceByID(@PathVariable String id) {
        String target = null;
        try{
            target = iService.read(Integer.valueOf(id));
        }catch(Exception ex) {
            System.out.println(ex);
        }
        
        if(target == null) {
            target = "Not Found";
        }
        return target;

    }
    @DeleteMapping(value = "/invoice/{id}")
    public void deleteInvoiceByID(@PathVariable String id) {
        try{
            iService.delete(Integer.valueOf(id));
        }catch(Exception ex) {
            System.out.println(ex);
        }
    }
}