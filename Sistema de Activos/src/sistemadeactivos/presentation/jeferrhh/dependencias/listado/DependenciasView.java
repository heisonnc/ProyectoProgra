/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.dependencias.listado;

import javax.swing.JOptionPane;
import sistemadeactivos.Application;
import sistemadeactivos.logic.Dependencia;

/**
 *
 * @author mauri
 */
public class DependenciasView extends javax.swing.JInternalFrame implements java.util.Observer{

    DependenciasController controller;
    DependenciasModel model;
    
    public void setController(DependenciasController controller){
        this.controller=controller;
    }

    public DependenciasController getController() {
        return controller;
    }
    
    public void setModel(DependenciasModel model){
        this.model=model;
         model.addObserver(this);
    }

    public DependenciasModel getModel() {
        return model;
    }
    
    @Override
   public void update(java.util.Observable updatedModel,Object parametros){
       this.limpiarErrores();
       Dependencia filtro = model.getFilter();
       this.fromDependencia(filtro);
       dependenciasFLd.setModel(model.getDependencias()); 
   }
    /**
     * Creates new form PersonasView
     */
    public DependenciasView() {
//        super("",false,true);
        initComponents();
    }
    
    public void limpiarErrores(){
       this.descripcionLbl.setForeground(Application.COLOR_OK); 
   }
   
    boolean validar(){
        boolean error=false;
        
        this.descripcionLbl.setForeground(Application.COLOR_OK); 
        if (this.descripcionFld.getText().isEmpty()){
            this.descripcionLbl.setForeground(Application.COLOR_ERROR);
            error=true;
        }
        return !error;
    }
    
    public void fromDependencia(Dependencia filtro){
       descripcionFld.setText(filtro.getDescripcion());
   }
   
    Dependencia toDependencia(){
        Dependencia result = new Dependencia();
        result.setDescripcion(descripcionFld.getText());
        return result;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descripcionLbl = new javax.swing.JLabel();
        descripcionFld = new javax.swing.JTextField();
        agregarFld = new javax.swing.JButton();
        borrarFld = new javax.swing.JButton();
        buscarFld = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        dependenciasFLd = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        descripcionLbl.setText("Descripcion");

        descripcionFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcionFldActionPerformed(evt);
            }
        });

        agregarFld.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemadeactivos/presentation/icons/general/add.png"))); // NOI18N
        agregarFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarFldActionPerformed(evt);
            }
        });

        borrarFld.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemadeactivos/presentation/icons/general/delete.png"))); // NOI18N
        borrarFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarFldActionPerformed(evt);
            }
        });

        buscarFld.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemadeactivos/presentation/icons/general/search.png"))); // NOI18N
        buscarFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFldActionPerformed(evt);
            }
        });

        dependenciasFLd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(dependenciasFLd);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(descripcionLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descripcionFld, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscarFld))
                            .addComponent(agregarFld)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(borrarFld)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarFld)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(descripcionLbl)
                        .addComponent(descripcionFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(agregarFld)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrarFld))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarFldActionPerformed
        try {
            controller.preAgregar(this.agregarFld.getLocationOnScreen());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_agregarFldActionPerformed

    private void buscarFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarFldActionPerformed
        if(this.validar()){
            try {
                controller.buscar(this.toDependencia());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); 
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Debe indicar algún dato", "ERROR", JOptionPane.ERROR_MESSAGE);            
        }
    }//GEN-LAST:event_buscarFldActionPerformed

    private void borrarFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_borrarFldActionPerformed

    private void descripcionFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcionFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descripcionFldActionPerformed

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
            java.util.logging.Logger.getLogger(DependenciasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DependenciasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DependenciasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DependenciasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DependenciasView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarFld;
    private javax.swing.JButton borrarFld;
    private javax.swing.JButton buscarFld;
    private javax.swing.JTable dependenciasFLd;
    private javax.swing.JTextField descripcionFld;
    private javax.swing.JLabel descripcionLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}