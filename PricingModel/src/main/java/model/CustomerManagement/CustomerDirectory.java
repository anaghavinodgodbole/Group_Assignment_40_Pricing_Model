/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.ArrayList;

import model.Business.Business;
import model.Personnel.Person;

/**
 *
 * @author kal bugrara
 */
public class CustomerDirectory {

    Business business;
     ArrayList<CustomerProfile> customerlist;

    public ArrayList<CustomerProfile> getCustomerlist() {
        return customerlist;
    }

    public void setCustomerlist(ArrayList<CustomerProfile> customerlist) {
        this.customerlist = customerlist;
    }
   

    public CustomerDirectory(Business d) {

        business = d;
        customerlist = new ArrayList();

    }

    public CustomerProfile newCustomerProfile(Person p) {

        CustomerProfile sp = new CustomerProfile(p);
        customerlist.add(sp);
        return sp;
    }

    public CustomerProfile findCustomer(String id) {

        for (CustomerProfile sp : customerlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
        public CustomersReport generatCustomerPerformanceReport(){
        CustomersReport customersreport = new CustomersReport();
    
        for(CustomerProfile cp: customerlist){
            
            CustomerSummary cs = new CustomerSummary(cp);
            customersreport.addCustomerSummary(cs);
        }
        return customersreport; 
    } 
        
     public ArrayList<CustomerProfile> searchCustomerByName(String customerName) {
        ArrayList<CustomerProfile> customerByName = new ArrayList<>();
        for (CustomerProfile customer: customerlist){
            if (customer.toString().toLowerCase().contains(customerName)) {
                customerByName.add(customer);
            }
        }
        return customerByName;
    }
}
