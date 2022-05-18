package controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import service.InvoiceService;

/**
 * Controller Class for Endpoints
 * Involved in Invoice table transactions
 */
@RestController
public class InvoiceController {
    //Service helper -- Connects to invoice table
    private InvoiceService iService = new InvoiceService();


    /** GET endpoint for all invoices
     * 
     * @return target: string, all invoices listed
     */
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

      /** GET endpoint for designated invoices
     * 
     * @return target: string, designated invoices listed
     */
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