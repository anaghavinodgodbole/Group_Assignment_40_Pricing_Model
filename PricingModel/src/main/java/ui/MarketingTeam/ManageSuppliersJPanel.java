/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.MarketingTeam;
import model.Business.Business;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductSummary;
import model.Supplier.Supplier;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kal bugrara
 */
public class ManageSuppliersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageSuppliersJPanel
     */
    JPanel CardSequencePanel;
    Business business;
    Supplier selectedsupplier;
    Product selectedproduct;

    public ManageSuppliersJPanel(Business bz, JPanel jp) {
        CardSequencePanel = jp;
        this.business = bz;
        initComponents();
        initializeTable();

    }

    public void initializeTable() {

//clear supplier table
        SuppliersComboBox.removeAllItems();

        int rc = SupplierCatalogTable.getRowCount();
        int i;
        for (i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) SupplierCatalogTable.getModel()).removeRow(i);
        }
//load suppliers to the combobox

        ArrayList<Supplier> supplierlist = business.getSupplierDirectory().getSuplierList();

        if (supplierlist.isEmpty()) {
            return;
        }
        for (Supplier s : supplierlist) {
            SuppliersComboBox.addItem(s.toString());
            SuppliersComboBox.setSelectedIndex(0);

            String suppliername = (String) SuppliersComboBox.getSelectedItem();

            selectedsupplier = business.getSupplierDirectory().findSupplier(suppliername);

            ProductCatalog pc = selectedsupplier.getProductCatalog();

            for (Product pt : pc.getProductList()) {

                Object[] row = new Object[5];
                row[0] = pt;
                row[1] = pt.getFloorPrice();
                row[2] = pt.getCeilingPrice();
                row[3] = pt.getTargetPrice();
//                row[1] = pt.getPerformanceMeasure();
//               row[2] = la.getName();
                ((DefaultTableModel) SupplierCatalogTable.getModel()).addRow(row);
            }

        }
    }

    public void refreshTable() {

//clear supplier table
        int rc = SupplierCatalogTable.getRowCount();
        int i;
        for (i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) SupplierCatalogTable.getModel()).removeRow(i);
        }

        String suppliername = (String) SuppliersComboBox.getSelectedItem();

        selectedsupplier = business.getSupplierDirectory().findSupplier(suppliername);
        if (selectedsupplier == null) {
            return;
        }
        ProductCatalog pc = selectedsupplier.getProductCatalog();

        for (Product pt : pc.getProductList()) {

            Object[] row = new Object[5];
            row[0] = pt;
            row[1] = pt.getFloorPrice();
            row[2] = pt.getCeilingPrice();
            row[3] = pt.getTargetPrice();
//                row[1] = pt.getPerformanceMeasure();
//               row[2] = la.getName();
            ((DefaultTableModel) SupplierCatalogTable.getModel()).addRow(row);
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

        SuppliersComboBox = new javax.swing.JComboBox<>();
        Back = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        SupplierCatalogTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        productNameTextField = new javax.swing.JTextField();
        productFrequencyAboveTargetTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        productRevenueTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        productFrequencyBelowTargetTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        productPricePerformanceTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(250, 243, 224));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SuppliersComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppliersComboBoxActionPerformed(evt);
            }
        });
        add(SuppliersComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));

        Back.setBackground(new java.awt.Color(142, 107, 57));
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        Next.setBackground(new java.awt.Color(142, 107, 57));
        Next.setForeground(new java.awt.Color(255, 255, 255));
        Next.setText("Next >>");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });
        add(Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 80, -1));

        jLabel1.setText("Suppliers");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, -1));

        SupplierCatalogTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Floor", "Ceiling", "Target"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SupplierCatalogTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SupplierCatalogTableMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SupplierCatalogTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(SupplierCatalogTable);

        jScrollPane2.setViewportView(jScrollPane1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 123, 580, 100));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Manage Suppliers");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 550, -1));

        jLabel3.setText("Product name");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 110, -1));

        productNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameTextFieldActionPerformed(evt);
            }
        });
        add(productNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 150, -1));
        add(productFrequencyAboveTargetTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 150, -1));

        jLabel4.setText("Frequency Above Target");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 150, -1));

        productRevenueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productRevenueTextFieldActionPerformed(evt);
            }
        });
        add(productRevenueTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 150, -1));

        jLabel5.setText("Sales Revenues");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 110, -1));
        add(productFrequencyBelowTargetTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 150, -1));

        jLabel6.setText("Frequency Below Target");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 150, -1));

        productPricePerformanceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productPricePerformanceTextFieldActionPerformed(evt);
            }
        });
        add(productPricePerformanceTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 150, -1));

        jLabel7.setText("Marign around target");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 150, -1));

        jLabel8.setText("Product");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

    }//GEN-LAST:event_BackActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        // TODO add your handling code here:
        
        ManageProductPerformanceDetail mppd = new ManageProductPerformanceDetail(selectedproduct, CardSequencePanel);
        CardSequencePanel.add(mppd);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

    }//GEN-LAST:event_NextActionPerformed

    private void SuppliersComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppliersComboBoxActionPerformed
        // TODO add your handling code here:

        refreshTable();
        //String sname = (String) SuppliersComboBox.getSelectedItem();
        //selectedsupplier = business.getSupplierDirectory().findSupplier(sname);


    }//GEN-LAST:event_SuppliersComboBoxActionPerformed

    private void SupplierCatalogTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierCatalogTableMousePressed
        // TODO add your handling code here:
        int suppliertablesize = SupplierCatalogTable.getRowCount();
        int selectedrow = SupplierCatalogTable.getSelectionModel().getLeadSelectionIndex();

        if (selectedrow < 0 || selectedrow > suppliertablesize - 1) {
            return;
        }
        selectedproduct = (Product) SupplierCatalogTable.getValueAt(selectedrow, 0);
        if (selectedproduct == null) {
            return;
        }
        
//        ProductSummary productsummary = new ProductSummary(selectedproduct);
//
//        productNameTextField.setText(selectedproduct.toString());
//        String revenues = String.valueOf(productsummary.getSalesRevenues());
//        productRevenueTextField.setText(revenues);
//        productFrequencyAboveTargetTextField.setText( String.valueOf(productsummary.getNumberAboveTarget()));
//        productFrequencyBelowTargetTextField.setText( String.valueOf(productsummary.getNumberBelowTarget()));
//        productPricePerformanceTextField.setText(String.valueOf(productsummary.getProductPricePerformance()));
    }//GEN-LAST:event_SupplierCatalogTableMousePressed

    private void productNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameTextFieldActionPerformed

    private void productRevenueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productRevenueTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productRevenueTextFieldActionPerformed

    private void productPricePerformanceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productPricePerformanceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productPricePerformanceTextFieldActionPerformed

    private void SupplierCatalogTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierCatalogTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_SupplierCatalogTableMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Next;
    private javax.swing.JTable SupplierCatalogTable;
    private javax.swing.JComboBox<String> SuppliersComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField productFrequencyAboveTargetTextField;
    private javax.swing.JTextField productFrequencyBelowTargetTextField;
    private javax.swing.JTextField productNameTextField;
    private javax.swing.JTextField productPricePerformanceTextField;
    private javax.swing.JTextField productRevenueTextField;
    // End of variables declaration//GEN-END:variables

}
