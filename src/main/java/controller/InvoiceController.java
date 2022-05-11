package controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import service.InvoiceService;

@RestController
public class InvoiceController {
    private InvoiceService iService = new InvoiceService();

    @GetMapping("/invoice")
    public String invoice() {
        String[] record = {"0", "0", "1", "1-1-2001"};
        String[] record1 = {"1", "2", "1", "3-3-2001"};
        String[] record2 = {"2", "1", "1", "2-2-2001"};
        ArrayList<String> target = new ArrayList<String>();

        try{
            iService.update(record);
            iService.update(record1);
            // iService.update(record2);
            target = iService.readAll();
        }catch(Exception ex) {
            System.out.println(ex);
        }

        return target.toString();
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
}