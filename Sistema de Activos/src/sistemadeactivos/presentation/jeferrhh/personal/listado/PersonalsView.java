/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.jeferrhh.personal.listado;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import sistemadeactivos.Application;
import sistemadeactivos.logic.Funcionario;

/**
 *
 * @author xxxx
 */
public class PersonalsView extends javax.swing.JDialog implements java.util.Observer {
    PersonalsController controller;
    PersonalsModel model;
    
    public PersonalsView() {
//        super("",false,true);
        initComponents();
    }

    public PersonalsController getController() {
        return controller;
    }

    public void setController(PersonalsController controller) {
        this.controller = controller;
    }

    public PersonalsModel getModel() {
        return model;
    }

    public void setModel(PersonalsModel model) {
        this.model = model;
        model.addObserver(this);
    }

    
    @Override
    public void update(Observable o, Object arg) {
        this.limpiarErrores();
       Funcionario filtro = model.getFilter();
       this.fromFuncionario(filtro);
       tablaFunc.setModel(model.getFuncionarios()); 
    }
    
    
       public void limpiarErrores(){
       this.textFieldBuscarPNombre.setForeground(Application.COLOR_OK); 
   }
   
    boolean validar(){
        boolean error=false;
        
        this.textFieldBuscarPNombre.setForeground(Application.COLOR_OK); 
        if (this.textFieldBuscarPNombre.getText().isEmpty()){
            this.textFieldBuscarPNombre.setForeground(Application.COLOR_ERROR);
            error=true;
        }
        return !error;
    }
    
     Funcionario toPersona(){
        Funcionario result = new Funcionario();
        result.setNombre(textFieldBuscarPNombre.getText());
        return result;
    }
     
      public void fromFuncionario(Funcionario filtro){
       textFieldBuscarPNombre.setText(filtro.getNombre());
   }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFunc = new javax.swing.JTable();
        textFieldBuscarPNombre = new javax.swing.JTextField();
        buttonBuscarPNombre = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        buttonEliminarFuncionario = new javax.swing.JButton();
        buttonAgregaFuncionario = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(41, 79, 137));

        jPanel2.setBackground(new java.awt.Color(59, 91, 141));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Lista de Funcionarios");

        tablaFunc.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFuncMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaFunc);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        textFieldBuscarPNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldBuscarPNombreActionPerformed(evt);
            }
        });

        buttonBuscarPNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonBuscarPNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/sistemadeactivos/presentation/icons/especiales/005-search.png"))); // NOI18N
        buttonBuscarPNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarPNombreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Nombre del Funcionario");

        buttonEliminarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/sistemadeactivos/presentation/icons/general/delete.png"))); // NOI18N

        buttonAgregaFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/sistemadeactivos/presentation/icons/especiales/021-user-3.png"))); // NOI18N
        buttonAgregaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregaFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(buttonAgregaFuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonEliminarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldBuscarPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(buttonBuscarPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textFieldBuscarPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonBuscarPNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonEliminarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAgregaFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void textFieldBuscarPNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldBuscarPNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldBuscarPNombreActionPerformed

    private void buttonBuscarPNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarPNombreActionPerformed
            if(this.validar()){
            try {
                controller.buscar(this.toPersona());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); 
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Debe indicar algún dato", "ERROR", JOptionPane.ERROR_MESSAGE);            
        }
    }//GEN-LAST:event_buttonBuscarPNombreActionPerformed

    private void buttonAgregaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregaFuncionarioActionPerformed
         try {
            controller.preAgregar(this.textFieldBuscarPNombre.getLocationOnScreen());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_buttonAgregaFuncionarioActionPerformed

    private void tablaFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFuncMouseClicked
           if (evt.getClickCount() == 2) {
        int row = this.tablaFunc.getSelectedRow();
        int col = this.tablaFunc.getSelectedColumn();
        if(col==4){
            controller.searchFuncioanrio(row,evt.getLocationOnScreen()); 
        }
        else{
            controller.editar(row,evt.getLocationOnScreen());
        }
      }
    }//GEN-LAST:event_tablaFuncMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAgregaFuncionario;
    private javax.swing.JButton buttonBuscarPNombre;
    private javax.swing.JButton buttonEliminarFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaFunc;
    private javax.swing.JTextField textFieldBuscarPNombre;
    // End of variables declaration//GEN-END:variables

    
}
