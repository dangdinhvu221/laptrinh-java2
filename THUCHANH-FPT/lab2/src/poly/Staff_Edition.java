/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Dang Dinh Vu
 */
public class Staff_Edition extends javax.swing.JFrame {

    /**
     * Creates new form Staff_List
     */
    public Staff_Edition() {
        initComponents();
        this.setLocationRelativeTo(null);
        cbo();
    }

    public void cbo(){
        String[] data = {"Việt Nam", "Singapore", "United States", "Malaysia"};
        cboCountry.setModel(new DefaultComboBoxModel(data));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblStaffEdition = new javax.swing.JLabel();
        lblStaffId = new javax.swing.JLabel();
        lblFullname = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblNote = new javax.swing.JLabel();
        txtStaffId = new javax.swing.JTextField();
        txtFfullname = new javax.swing.JTextField();
        cboCountry = new javax.swing.JComboBox<>();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        chkSingle = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);

        lblStaffEdition.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lblStaffEdition.setForeground(new java.awt.Color(0, 0, 255));
        lblStaffEdition.setText("Staff Edition");

        lblStaffId.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblStaffId.setText("Staff Id");

        lblFullname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblFullname.setText("Fullname");

        lblCountry.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblCountry.setText("Country");

        lblGender.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblGender.setText("Gender");

        lblStatus.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblStatus.setText("Status");

        lblNote.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblNote.setText("Note");

        txtStaffId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStaffIdActionPerformed(evt);
            }
        });

        cboCountry.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cboCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup1.add(rdoMale);
        rdoMale.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rdoMale.setSelected(true);
        rdoMale.setText("Male");
        rdoMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMaleActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoFemale);
        rdoFemale.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rdoFemale.setText("Female");
        rdoFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFemaleActionPerformed(evt);
            }
        });

        chkSingle.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        chkSingle.setSelected(true);
        chkSingle.setText("Single?");

        txtNote.setColumns(20);
        txtNote.setRows(5);
        jScrollPane1.setViewportView(txtNote);

        btnCreate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnCreate.setText("Create");

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnUpdate.setText("Update");

        btnDelete.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDelete.setText("Delete");

        btnReset.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnReset.setText("Reset");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStaffId)
                    .addComponent(lblFullname)
                    .addComponent(lblCountry)
                    .addComponent(lblGender)
                    .addComponent(lblStatus)
                    .addComponent(lblNote))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(chkSingle)
                        .addComponent(txtFfullname, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                        .addComponent(lblStaffEdition)
                        .addComponent(txtStaffId)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rdoMale, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(rdoFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cboCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblStaffEdition)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStaffId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFullname)
                    .addComponent(txtFfullname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCountry)
                    .addComponent(cboCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGender)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoMale)
                        .addComponent(rdoFemale)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatus)
                    .addComponent(chkSingle))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblNote))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnReset))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoMaleActionPerformed

    private void txtStaffIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStaffIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStaffIdActionPerformed

    private void rdoFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoFemaleActionPerformed

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
            java.util.logging.Logger.getLogger(Staff_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff_Edition().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboCountry;
    private javax.swing.JCheckBox chkSingle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblFullname;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblStaffEdition;
    private javax.swing.JLabel lblStaffId;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtFfullname;
    private javax.swing.JTextArea txtNote;
    private javax.swing.JTextField txtStaffId;
    // End of variables declaration//GEN-END:variables
}
