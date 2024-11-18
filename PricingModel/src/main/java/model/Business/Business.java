/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.CustomerManagement.ChannelCatalog;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.CustomerManagement.MarketCatalog;
import model.MarketingManagement.MarketingPersonDirectory;
import model.MarketingManagement.MarketingPersonProfile;
import model.OrderManagement.MasterOrderList;
import model.Personnel.EmployeeDirectory;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;
import model.ProductManagement.SolutionOfferCatalog;
import model.SalesManagement.SalesPersonDirectory;
import model.SalesManagement.SalesPersonProfile;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    PersonDirectory persondirectory;
    MasterOrderList masterorderlist;
    CustomerDirectory customers;
    SupplierDirectory suppliers;
    MarketCatalog marketcatalog;
    ChannelCatalog channelcatalog;
     SolutionOfferCatalog solutionoffercatalog;
    CustomerDirectory customerdirectory;
    EmployeeDirectory employeedirectory;
    SalesPersonDirectory salespersondirectory;
    UserAccountDirectory useraccountdirectory;
    MarketingPersonDirectory marketingpersondirectory;
    public SolutionOfferCatalog getSolutionoffercatalog() {
        return solutionoffercatalog;
    }

    public void setSolutionoffercatalog(SolutionOfferCatalog solutionoffercatalog) {
        this.solutionoffercatalog = solutionoffercatalog;
    }
   

    public Business(String n) {
        name = n;
        masterorderlist = new MasterOrderList();
        suppliers = new SupplierDirectory();
//        solutionoffercatalog = new SolutionOfferCatalog();
        persondirectory = new PersonDirectory();
        customerdirectory = new CustomerDirectory(this);
        salespersondirectory = new SalesPersonDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
        marketingpersondirectory = new MarketingPersonDirectory(this);
        employeedirectory = new EmployeeDirectory(this);

    }

    public int getSalesVolume() {
        return masterorderlist.getSalesVolume();

    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }
    public MarketingPersonDirectory getMarketingPersonDirectory() {
        return marketingpersondirectory;
    }

    public SupplierDirectory getSupplierDirectory() {
        System.out.println("getSupplierDirectory" + suppliers.getSuplierList());
        for(Supplier s: suppliers.getSuplierList()){
            System.out.println(s.getName());
        }
        return suppliers;
    }

    public ProductsReport getSupplierPerformanceReport(String n) {
        Supplier supplier = suppliers.findSupplier(n);
        if (supplier == null) {
            return null;
        }
        return supplier.prepareProductsReport();

    }

    public ArrayList<ProductSummary> getSupplierProductsAlwaysAboveTarget(String n) {

        ProductsReport productsreport = getSupplierPerformanceReport(n);
        return productsreport.getProductsAlwaysAboveTarget();

    }

    public int getHowManySupplierProductsAlwaysAboveTarget(String n) {
        ProductsReport productsreport = getSupplierPerformanceReport(n); // see above
        int i = productsreport.getProductsAlwaysAboveTarget().size(); //return size of the arraylist
        return i;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerdirectory;
    }

    public SalesPersonDirectory getSalesPersonDirectory() {
        return salespersondirectory;
    }

    public MasterOrderList getMasterOrderList() {
        return masterorderlist;
    }
        public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }
    public void populateSuppliers() {
  
    for (int supplierIndex = 1; supplierIndex <= 10; supplierIndex++) {
        
        Supplier currentSupplier = suppliers.newSupplier("Supplier" + supplierIndex);
        
        for (int productIndex = 1; productIndex <= 10; productIndex++) { 
            ProductCatalog pc = currentSupplier.getProductCatalog();

           
            Product p = pc.newProduct(
                "Product" + productIndex + "_Supplier" + supplierIndex,
                (int) (Math.random() * 1000), 
                (int) (Math.random() * 500 + 1000), 
                (int) (Math.random() * 800 + 500) 
            );
            
            
            p.setSupplier(currentSupplier);        }
    }
    }
     public void populateCustomersSalesMarketing() {

    for (int customerIndex = 1; customerIndex <= 10; customerIndex++) {

        Person customerPerson = persondirectory.newPerson("Customer" + customerIndex);


        CustomerProfile currentCustomer = customerdirectory.newCustomerProfile(customerPerson);
    }


    for (int salesIndex = 1; salesIndex <= 5; salesIndex++) {
    
        Person salesPerson = persondirectory.newPerson("SalesPerson" + salesIndex);


        SalesPersonProfile salespersonProfile = salespersondirectory.newSalesPersonProfile(salesPerson);


        useraccountdirectory.newUserAccount(salespersonProfile, "sales" + salesIndex, "spassword" + salesIndex);
        
    }


    for (int marketingIndex = 1; marketingIndex <= 5; marketingIndex++) {

        Person marketingPerson = persondirectory.newPerson("MarketingPerson" + marketingIndex);

   
        MarketingPersonProfile marketingPersonProfile = marketingpersondirectory.newMarketingPersonProfile(marketingPerson);
        useraccountdirectory.newUserAccount(marketingPersonProfile, "market" + marketingIndex, "mpassword" + marketingIndex);
    }
}

}
