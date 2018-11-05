/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.dependencias.edicion;

import java.util.Arrays;
import javax.swing.JOptionPane;
import sistemadeactivos.Application;
import sistemadeactivos.logic.Dependencia;
import sistemadeactivos.logic.Funcionario;

/**
 *
 * @author mauri
 */
public class DependenciaView  extends javax.swing.JDialog implements java.util.Observer  {

    DependenciaController controller;
    DependenciaModel model;
    
    public DependenciaView() {
        initComponents();
    }

    
    
    public void setController(DependenciaController controller){
        this.controller=controller;
    }

    public DependenciaController getController() {
        return controller;
    }
    
    
    public void setModel(DependenciaModel model){
        this.model=model;
         model.addObserver(this);
    }

    public DependenciaModel getModel() {
        return model;
    }
   public void update(java.util.Observable updatedModel,Object parametros){
       this.limpiarErrores();
       Dependencia actual = model.getCurrent();
       this.fromDependencia(actual);
   }
      public void limpiarErrores(){
        this.textNombreDependencia.setForeground(Application.COLOR_OK); 
   } 
      
     public  boolean validar(){
     boolean error=false;
     if(this.textNombreDependencia.getText().isEmpty()){
         error= true;
     }
//     if(this.textadminDependencia.getText().isEmpty()){
//         error= true;
//     }
     return !error; 
     }
     
     public Dependencia toDependencia(){
         Dependencia dep= new Dependencia();
         dep.setDescripcion(this.textNombreDependencia.getText());
         if(model.fun!= null){
             dep.setFuncionario(model.getFun());
         }
         return dep;
     }
      
      public void fromDependencia(Dependencia dependencia){
          
        this.textNombreDependencia.setText(dependencia.getDescripcion());
        if(dependencia.getFuncionario()!= null){
            this.textadminDependencia.setText(dependencia.getFuncionario().getNombre());
        }
        if(model.fun!= null){
            this.textadminDependencia.setText(model.fun.getNombre());
            dependencia.setFuncionario(model.fun);
        }
          
        Boolean editable = Arrays.asList(Application.MODO_AGREGAR, Application.MODO_EDITAR).contains(model.getModo());
        if(editable){
            
        this.textNombreDependencia.setEnabled(editable);
        this.agregaAdmin.setEnabled(editable);
        this.textadminDependencia.setEditable(false);
            
        }
        
         Boolean editableConsult = Arrays.asList(Application.MODO_CONSULTAR).contains(model.getModo());
        if(editableConsult){
            
        this.textNombreDependencia.setEnabled(false);
        this.agregaAdmin.setEnabled(false);  
        this.textadminDependencia.setEditable(false);   
        }   
        
        this.validate(); 
      }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        textadminDependencia = new javax.swing.JTextField();
        agregaAdmin = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textNombreDependencia = new javax.swing.JTextField();
        buttonAceptaNombre = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(59, 91, 141));

        jPanel2.setBackground(new java.awt.Color(63, 112, 188));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Administrador de la dependencia");

        jPanel4.setBackground(new java.awt.Color(63, 112, 188));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        textadminDependencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textadminDependenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textadminDependencia, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textadminDependencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        agregaAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemadeactivos/presentation/icons/general/add.png"))); // NOI18N
        agregaAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregaAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(agregaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(agregaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(63, 112, 188));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Nombre de la dependencia que desea registrar");

        textNombreDependencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreDependenciaActionPerformed(evt);
            }
        });

        buttonAceptaNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemadeactivos/presentation/icons/especiales/007-success.png"))); // NOI18N
        buttonAceptaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptaNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(textNombreDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(buttonAceptaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textNombreDependencia, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAceptaNombre)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNombreDependenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreDependenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreDependenciaActionPerformed

    private void textadminDependenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textadminDependenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textadminDependenciaActionPerformed

    private void agregaAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregaAdminActionPerformed
       controller.showFuncionarios();
    }//GEN-LAST:event_agregaAdminActionPerformed

    private void buttonAceptaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptaNombreActionPerformed
         if(this.validar()){
            try {
                Dependencia dep= toDependencia();
                if(dep.getFuncionario()==null){
                    dep.setFuncionario(new Funcionario());
                    dep.getFuncionario().setId(0);
                    dep.getFuncionario().setNombre(" ");
                }
                this.controller.guardar(dep);
                JOptionPane.showMessageDialog(this, "Datos registrados", "OK", JOptionPane.INFORMATION_MESSAGE); 
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); 
            }
        }
//        else{
//            JOptionPane.showMessageDialog(this, "Error en datos", "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_buttonAceptaNombreActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregaAdmin;
    private javax.swing.JButton buttonAceptaNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField textNombreDependencia;
    private javax.swing.JTextField textadminDependencia;
    // End of variables declaration//GEN-END:variables
}
