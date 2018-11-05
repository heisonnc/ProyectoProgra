/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.personal.edicion;

import java.util.Arrays;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistemadeactivos.Application;
import sistemadeactivos.logic.Funcionario;
import sistemadeactivos.logic.Rol;
import sistemadeactivos.logic.Usuario;

/**
 *
 * @author book
 */
public class PersonalView extends javax.swing.JDialog implements java.util.Observer {

    PersonalController controller;
    PersonalModel model;

    public void setController(PersonalController controller) {
        this.controller = controller;
    }

    public void setModel(PersonalModel model) {
        this.model = model;
        model.addObserver(this);
    }
    
    
    
    public PersonalView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        textPassword = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        comboBoxRoles = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        buttoActualizar = new javax.swing.JButton();
        buttonGuardar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(59, 91, 141));

        jPanel2.setBackground(new java.awt.Color(48, 97, 173));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Password:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("ID Usuario:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Datos de usuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(285, 285, 285))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(48, 97, 173));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Nombre:");

        comboBoxRoles.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboBoxRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador Dependencia", "Secretaria", "Jefe OCCBB", "Jefe RRHH" }));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Rol que empleara:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(42, 42, 42)
                .addComponent(comboBoxRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboBoxRoles))
                .addContainerGap())
        );

        buttoActualizar.setBackground(new java.awt.Color(48, 97, 173));
        buttoActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttoActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/sistemadeactivos/presentation/icons/especiales/015-repeat.png"))); // NOI18N
        buttoActualizar.setText("Actualizar");
        buttoActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttoActualizarActionPerformed(evt);
            }
        });

        buttonGuardar.setBackground(new java.awt.Color(48, 97, 173));
        buttonGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/sistemadeactivos/presentation/icons/general/save.png"))); // NOI18N
        buttonGuardar.setText("Guardar");
        buttonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttoActualizar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttoActualizar)
                    .addComponent(buttonGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarActionPerformed
             if(this.validar()){
            try {
                Funcionario funcionario= new Funcionario();
                Usuario user = new Usuario();
                funcionario=this.toFuncionario();
                user=this.toUsuario(funcionario);
                this.controller.guardarUsuario(user);
                JOptionPane.showMessageDialog(this, "Datos registrados", "OK", JOptionPane.INFORMATION_MESSAGE); 
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); 
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Error en datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonGuardarActionPerformed

    private void buttoActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttoActualizarActionPerformed
           if(this.validar()){
            try {
                Funcionario funcionario= new Funcionario();
                Usuario user = new Usuario();
                funcionario=this.toFuncionario();
                user=this.toUsuario(funcionario);
                this.controller.updateUsuario(user);
                JOptionPane.showMessageDialog(this, "Datos registrados", "OK", JOptionPane.INFORMATION_MESSAGE); 
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); 
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Error en datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttoActualizarActionPerformed

    /**
     * @param args the command line arguments
     */


    @Override
    public void update(Observable o, Object o1) {
       this.limpiarErrores();
       Usuario user=this.model.getUser();
       if(user.getFuncionario()!=null){
           
          this.fromUsuario(user);
           
       }else{
       Funcionario actual = model.getCurrent();
       this.fromFuncionario(actual); 
       }
       
    }
    
    public void fromFuncionario(Funcionario funcionario){
       
        Boolean editable = Arrays.asList(Application.MODO_AGREGAR, Application.MODO_EDITAR).contains(model.getModo());
        // dependiento del usuario que le llegue le abilita el campo para que ingrese los datos 
        
        
        if(editable){
        
        this.textNombre.setEditable(editable);
        this.textId.setEditable(editable);
        this.textPassword.setEditable(editable); 
        this.buttonGuardar.setVisible(editable);
        this.buttoActualizar.setVisible(false);
        this.textNombre.setText(funcionario.getNombre());
        
        
        }
         Boolean editableEdit = Arrays.asList(Application.MODO_CONSULTAR).contains(model.getModo()); 
        if(editableEdit){
            
        this.textNombre.setEditable(false);
        this.textId.setEditable(false);
        this.textPassword.setEditable(false); 
        this.buttonGuardar.setVisible(false);
        this.buttoActualizar.enable(false);
//      this.textNombre.setText(funcionario.getNombre());



        
        }
        this.validate();   
    }
    
    
        public void fromUsuario(Usuario user){
        Funcionario funcionario=user.getFuncionario();
            
            
        Boolean editable = Arrays.asList(Application.MODO_AGREGAR).contains(model.getModo());
        // dependiento del usuario que le llegue le abilita el campo para que ingrese los datos         
        if(editable){
        
        this.textNombre.setEditable(editable);
        this.textId.setEditable(editable);
        this.textPassword.setEditable(editable); 
        this.buttonGuardar.setVisible(editable);
        this.buttoActualizar.setVisible(false);
        this.textNombre.setText(funcionario.getNombre());
        this.textId.setText(user.getId());
        this.textPassword.setText(user.getClave());
        
            try {
                int pos= controller.getRolPos(user.getRol().getDescripcion());
                
                this.comboBoxRoles.setSelectedIndex(pos);
                
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(this, "Error en datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
        
        Boolean editableAct = Arrays.asList(Application.MODO_EDITAR).contains(model.getModo());
        // dependiento del usuario que le llegue le abilita el campo para que ingrese los datos         
        if(editableAct){
        
        this.textNombre.setEditable(editableAct);
        this.textId.setEditable(editableAct);
        this.textPassword.setEditable(editableAct); 
        this.buttonGuardar.setVisible(false);
        this.buttoActualizar.setVisible(editableAct);
        this.textNombre.setText(funcionario.getNombre());
        this.textId.setText(user.getId());
        this.textPassword.setText(user.getClave());
        
            try {
                int pos= controller.getRolPos(user.getRol().getDescripcion());
                
                this.comboBoxRoles.setSelectedIndex(pos);
                
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(this, "Error en datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
        
         Boolean editableConsul = Arrays.asList(Application.MODO_CONSULTAR).contains(model.getModo()); 
        if(editableConsul){
            
        this.textNombre.setEditable(false);
        this.textId.setEditable(false);
        this.textPassword.setEditable(false);
        this.textPassword.setVisible(false);
        this.buttonGuardar.setVisible(false);
        this.buttoActualizar.enable(false);
//      this.textNombre.setText(funcionario.getNombre());
        this.textId.setEditable(false);
        
        
        this.buttoActualizar.setVisible(false);
        this.textNombre.setText(funcionario.getNombre());
        this.textId.setText(user.getId());
        this.textPassword.setText(user.getClave());
        
          try {
                int pos= controller.getRolPos(user.getRol().getDescripcion());
                
                this.comboBoxRoles.setSelectedIndex(pos);
                
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(this, "Error en datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        this.validate();   
    }
    
    public Funcionario toFuncionario(){
        Funcionario result= new Funcionario();
        result.setNombre(this.textNombre.getText());
        return result;
    }
    
    public Usuario toUsuario(Funcionario funcionario){
        Usuario user = new Usuario();
        user.setId(this.textId.getText());
        user.setClave(this.textPassword.getText());
        user.setFuncionario(funcionario);
        String select=this.comboBoxRoles.getSelectedItem().toString();
        Rol rol= new Rol();
        
        try {
            rol= controller.getRol(select);
            user.setRol(rol);
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, "Error en datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        

        
        return user;
    }
    public void limpiarErrores(){
        this.textPassword.setForeground(Application.COLOR_OK);
        this.textNombre.setForeground(Application.COLOR_OK);
   }   
     
    public  boolean validar(){
     boolean error=false;
         
     if(this.textNombre.getText().isEmpty()){
         error= true;
     }
     if(this.textPassword.getText().isEmpty()){
         error= true;
     }
     return !error; 
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttoActualizar;
    private javax.swing.JButton buttonGuardar;
    private javax.swing.JComboBox<String> comboBoxRoles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPassword;
    // End of variables declaration//GEN-END:variables
}
