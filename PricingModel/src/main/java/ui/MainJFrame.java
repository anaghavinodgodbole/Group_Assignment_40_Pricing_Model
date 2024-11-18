
package ui;

import model.MarketingManagement.MarketingPersonProfile;
import model.Business.Business;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.ProductManagement.SolutionOffer;
import model.Personnel.EmployeeProfile;
import model.Personnel.Profile;
import model.ProductManagement.Product;
import model.SalesManagement.SalesPersonProfile;
import model.OrderManagement.MasterOrderList;
//import model.SolutionOrders.SolutionOrder;
import model.Supplier.Supplier;
import model.UserAccountManagement.UserAccount;
import model.UserAccountManagement.UserAccountDirectory;
//import UserInterface.Main.WorkSpaceProfiles.BusinessManagerWorkAreaJPanel;
import ui.MarketingTeam.MarketingManagerWorkAreaJPanel1;
import ui.SalesPerson.SalesPersonWorkAreaJPanel;
import javax.swing.JPanel;
import model.Business.ConfigureABusiness;
import model.ProductManagement.ProductCatalog;
import model.Supplier.SupplierDirectory;
import ui.MarketingTeam.MarketingManagerWorkAreaJPanel1;
import ui.SalesPerson.SalesPersonWorkAreaJPanel;
 

/**
 *
 * @author kal bugrara
 */
public class MainJFrame extends javax.swing.JFrame {

    Business business;
    SupplierDirectory suppliers;

    /**
     * Creates new form PricingMainFrame
     */

    public MainJFrame() {
//        System.out.println("1st");
        initComponents();
//        System.out.println("2nd");
        business = ConfigureABusiness.initialize();
        suppliers = new SupplierDirectory();
        business.populateSuppliers();
        setSize(1100, 800);

        // TODO: Create static suppliers
        
        //Check for whether suppliers were populated
//        for(Supplier supplier : business.getSupplierDirectory().getSuplierList()){
//            for(Product product: supplier.getProductCatalog().getProductList()){
//                //System.out.println("Supplier Name : " + supplier.getName()  +"--" + product.getName() +" "+ product.getCeilingPrice()  );
//            }
//        }
        
      //  business.populateMarketChannels();
        
        //Check for markets and channels
//        for(Market market : business.getMarketCatalog().getMarkets()){
//            System.out.println("Current Market is : " + market.getName());
//            System.out.println("--------------------------------");
//            
//            for (Channel channel : market.getValidchannels()){
//                System.out.println(channel.getChannelType());
//            }
//        }
//        System.out.println("Printing market channel combo");
//        System.out.println("-------------------------------");
//        int j = 0;
//        for (MarketChannelAssignment mca : business.getMarketChannelComboCatalog().getMcalist()){
//            System.out.println(j+1);
//            System.out.println("MCA : channel - "+mca.getChannel().getChannelType() + " and Market - " + mca.getMarket().getName());
//        }
        
        business.populateCustomersSalesMarketing();

// TODO:  CREATE 10 CUSTOMER HERE
        
//        for (CustomerProfile customer: business.getCustomerDirectory().getCustomerlist() ){
//            System.out.println("*************************************");
//            System.out.println("Current customer is:" + customer.getPerson().toString());
//            System.out.println("Current customer's market and Channel : " +customer.getMarkets().get(0).getName() +" - " + customer.getMca().get(0).getChannel().getChannelType());
//            System.out.println("--------------------------------"); 
//        }

//        business.createSolutionOffers();
        
        
//        for(SolutionOffer so: business.getSolutionoffercatalog().getSolutionoffers()){
//            System.out.println("----------------");
//            System.out.println("The Market Channel Assignment is : Market ==> " + so.getMarketchannelcomb().getMarket().getName() + " and Channel ==> " + so.getMarketchannelcomb().getChannel().getChannelType());
//            System.out.println("Product size for this bundle " + so.getProducts().size() +"    "+ so.getProducts().get(0).getName());
//            System.out.println("Total Ceiling Price : " + so.getTotalCeilingPrice() + " and total Floor price : " + so.getTotalFloorPrice());
//            System.out.println("-------------End of this product-------------");
//        }

//        business.orderSolutionOffers();
        
//        for(SolutionOrder mso : business.getMasterSolutionOrderList().getSolutionorderlist()){
//            System.out.println("---------Solution Order ------------");
//           System.out.println("Customer is: " + mso.getCustomer());
//           System.out.println("salesperson is:" + mso.getSalesPerson().getPerson().getPersonId());
//           System.out.println("Product 1 is: " + mso.getSelectedsolutionoffer().getProducts().get(0).getName());
//           System.out.println("Product count: " + mso.getSelectedsolutionoffer().getProducts().size());
//        }
        
//        for(SolutionOrder so : business.getMasterSolutionOrderList().getSolutionorderlist()){
//            System.out.println("*****************************************");
//            System.out.println("Product List");
//            for(Product product:so.getSelectedsolutionoffer().getProducts()){
//                System.out.println(product.getName() +" | F, T, C : " + product.getFloorPrice() + ", " + product.getTargetPrice() + ", " + product.getCeilingPrice());
//                
//            }
//            System.out.println("Price sold at : " + so.getSolutionPrice());
//            System.out.println("Target price of bundle : " + so.getTotalTargetPrice());
//            System.out.println("Floor and Ceiling price : " + so.getSelectedsolutionoffer().getTotalFloorPrice() +"||| " +so.getSelectedsolutionoffer().getTotalCeilingPrice()  );
//            System.out.println("-----------------------------------------");
//        }
//
//        business.printSalesReport();
        
    }

    public void insert(JPanel jpanel) {

    }
    
    public void populateSuppliers() {
  
    for (int supplierIndex = 1; supplierIndex <= 10; supplierIndex++) {
        
        Supplier currentSupplier = suppliers.newSupplier("Supplier" + supplierIndex);

        
        for (int productIndex = 1; productIndex <= 5; productIndex++) { 
            ProductCatalog pc = currentSupplier.getProductCatalog();

           
            Product p = pc.newProduct(
                "Product" + productIndex + "_Supplier" + supplierIndex,
                (int) (Math.random() * 1000), 
                (int) (Math.random() * 500 + 1000), 
                (int) (Math.random() * 800 + 500) 
            );
            
            
            p.setSupplier(currentSupplier);
            suppliers.addSupplier(currentSupplier);
        }
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SplitHomeArea = new javax.swing.JSplitPane();
        actionsidejpanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        UserNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PasswordTextField = new javax.swing.JPasswordField();
        CardSequencePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        actionsidejpanel.setBackground(new java.awt.Color(250, 243, 224));
        actionsidejpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        actionsidejpanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 70, 30));

        jLabel1.setText("User Name");
        actionsidejpanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        UserNameTextField.setText("sales");
        UserNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserNameTextFieldActionPerformed(evt);
            }
        });
        actionsidejpanel.add(UserNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, -1));

        jLabel2.setText("Password");
        actionsidejpanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));
        actionsidejpanel.add(PasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 130, -1));

        SplitHomeArea.setLeftComponent(actionsidejpanel);

        CardSequencePanel.setBackground(new java.awt.Color(250, 243, 224));
        CardSequencePanel.setLayout(new java.awt.CardLayout());
        SplitHomeArea.setRightComponent(CardSequencePanel);

        getContentPane().add(SplitHomeArea, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserNameTextFieldActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        //      WorkAreaJPanel ura = new WorkAreaJPanel(workareajpanl);

        String un = UserNameTextField.getText();
        String pw = PasswordTextField.getText();

        UserAccountDirectory uad = business.getUserAccountDirectory();

        UserAccount useraccount = uad.AuthenticateUser(un, pw);
        if (useraccount == null) {
            return;
        }
        SalesPersonWorkAreaJPanel salesworkarea;
        MarketingManagerWorkAreaJPanel1 marketingworkarea;
        // BusinessManagerWorkAreaJPanel bzmanagerworkarea;
        String r = useraccount.getRole();
        Profile profile = useraccount.getAssociatedPersonProfile();
        //       if (r.equalsIgnoreCase("sales")) {

            //        if (profile instanceof SalesPersonProfile) {
                if (profile instanceof SalesPersonProfile) {
                    SalesPersonProfile spp = (SalesPersonProfile) profile;
                    salesworkarea = new SalesPersonWorkAreaJPanel(business, spp, CardSequencePanel,"Sales");
                    CardSequencePanel.removeAll();
                    CardSequencePanel.add("Sales", salesworkarea);
                    populateSuppliers();
                    ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

                }

                if (profile instanceof MarketingPersonProfile) {
                    marketingworkarea = new MarketingManagerWorkAreaJPanel1(business, CardSequencePanel,"Marketing", useraccount);
                    CardSequencePanel.removeAll();
                    CardSequencePanel.add("Marketing", marketingworkarea);
                    ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

                }

                //        if (profile instanceof EmployeeProfile) {
                    //
                    //            bzmanagerworkarea = new BusinessManagerWorkAreaJPanel(business, CardSequencePanel);
                    //            CardSequencePanel.removeAll();
                    //            CardSequencePanel.add("Admin", bzmanagerworkarea);
                    //            ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
                    //
                    //        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardSequencePanel;
    private javax.swing.JPasswordField PasswordTextField;
    private javax.swing.JSplitPane SplitHomeArea;
    private javax.swing.JTextField UserNameTextField;
    private javax.swing.JPanel actionsidejpanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables


}
