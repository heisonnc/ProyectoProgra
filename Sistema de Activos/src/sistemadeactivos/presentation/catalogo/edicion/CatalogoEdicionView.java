/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeactivos.presentation.catalogo.edicion;

import java.util.Arrays;
import java.util.Observable;
import sistemadeactivos.Application;
import sistemadeactivos.logic.Activo;

/**
 *
 * @author book
 */
public class CatalogoEdicionView extends javax.swing.JDialog implements java.util.Observer  {

    CatalogoEdicionController controller;
    CatalogoEdicionModel model;
    
    public CatalogoEdicionView() {
        initComponents();
    }
    
    public void setController(CatalogoEdicionController controller){
        this.controller=controller;
    }

    public CatalogoEdicionController getController() {
        return controller;
    }
    
    
    public void setModel(CatalogoEdicionModel model){
        this.model=model;
         model.addObserver(this);
    }

    public CatalogoEdicionModel getModel() {
        return model;
    }
   public void update(java.util.Observable updatedModel,Object parametros){
       this.limpiarErrores();
       Activo actual = model.getCurrent();
       
   }
      public void limpiarErrores(){
        this.textFieldConsecutivo.setForeground(Application.COLOR_OK); 
        this.textFieldDescripcion.setForeground(Application.COLOR_OK); 
        this.textFieldEncargadoArticulo.setForeground(Application.COLOR_OK); 
        this.textFieldMarca.setForeground(Application.COLOR_OK); 
        this.textFieldModelo.setForeground(Application.COLOR_OK); 
        this.textFieldPrecio.setForeground(Application.COLOR_OK); 
        this.textFieldUbicacion.setForeground(Application.COLOR_OK); 
   } 
      
     public  boolean validar(){
     boolean error=false;
     if(this.textFieldConsecutivo.getText().isEmpty() || this.textFieldDescripcion.getText().isEmpty() ||
//             this.textFieldEncargadoArticulo.getText().isEmpty()|| 
             this.textFieldMarca.getText().isEmpty() ||
             this.textFieldModelo.getText().isEmpty() || this.textFieldPrecio.getText().isEmpty()) 
//             ||this.textFieldUbicacion.getText().isEmpty())
             {
         error= true;
     }
//     if(this.textadminDependencia.getText().isEmpty()){
//         error= true;
//     }
     return !error; 
     }
     
     public void fromActivo(Activo activo){
         
        Boolean editable = Arrays.asList(Application.MODO_AGREGAR, Application.MODO_EDITAR).contains(model.getModo());
        
        if(editable){
            
            this.textFieldDescripcion.setEnabled(!editable);
            this.textFieldMarca.setEnabled(!editable);
            this.textFieldModelo.setEnabled(!editable);
            this.textFieldPrecio.setEnabled(!editable);
            this.textFieldConsecutivo.setEnabled(!editable);
            this.textFieldUbicacion.setEnabled(!editable);
            this.textFieldEncargadoArticulo.setEnabled(!editable);
            this.buttonAceptaCategoria.setEnabled(editable);
            this.buttonBuscarEncargado.setEnabled(editable);
            this.buttonBuscarUbicacion.setEnabled(editable);
            
            this.textFieldDescripcion.setText(activo.getBien().getDescripcion());
            this.textFieldMarca.setText(activo.getBien().getMarca());
            this.textFieldModelo.setText(activo.getBien().getModelo());
            double d=activo.getBien().getPrecioUnitario();
            String cadena = String.valueOf(d);
            this.textFieldPrecio.setText(cadena);
            cadena = String.valueOf(activo.getId());
            this.textFieldConsecutivo.setText(cadena);
            if(activo.getPuesto()!= null){
                String ubicacion=activo.getPuesto().getDependencia().getDescripcion()+" en el "+activo.getPuesto().getRol().getDescripcion();
                this.textFieldUbicacion.setText(ubicacion);
            }else{
                this.textFieldUbicacion.setText("No asignado aun");
            }
            
            this.textFieldEncargadoArticulo.setText("No asigando aun");
            
        }else{
            
            this.textFieldDescripcion.setEnabled(!editable);
            this.textFieldMarca.setEnabled(!editable);
            this.textFieldModelo.setEnabled(!editable);
            this.textFieldPrecio.setEnabled(!editable);
            this.textFieldConsecutivo.setEnabled(!editable);
            this.textFieldUbicacion.setEnabled(!editable);
            this.textFieldEncargadoArticulo.setEnabled(!editable);
            this.buttonAceptaCategoria.setVisible(editable);
            this.buttonBuscarEncargado.setVisible(editable);
            this.buttonBuscarUbicacion.setVisible(editable);
            
            this.textFieldDescripcion.setText(activo.getBien().getDescripcion());
            this.textFieldMarca.setText(activo.getBien().getMarca());
            this.textFieldModelo.setText(activo.getBien().getModelo());
            double d=activo.getBien().getPrecioUnitario();
            String cadena = String.valueOf(d);
            this.textFieldPrecio.setText(cadena);
            cadena = String.valueOf(activo.getId());
            this.textFieldConsecutivo.setText(cadena);
            if(activo.getPuesto()!= null){
                String ubicacion=activo.getPuesto().getDependencia().getDescripcion()+" en el "+activo.getPuesto().getRol().getDescripcion();
                this.textFieldUbicacion.setText(ubicacion);
            }else{
                this.textFieldUbicacion.setText("No asignado aun");
            }
            
            if(activo.getEncargado()!=null){
                this.textFieldEncargadoArticulo.setText(activo.getEncargado().getNombre());
            }else{
            this.textFieldEncargadoArticulo.setText("No asigando aun");
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        buttonAceptaCategoria = new javax.swing.JButton();
        comboBoxCategoria = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        textFieldDescripcion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        marca = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textFieldPrecio = new javax.swing.JTextField();
        textFieldModelo = new javax.swing.JTextField();
        textFieldMarca = new javax.swing.JTextField();
        textFieldConsecutivo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        buttonBuscarEncargado = new javax.swing.JButton();
        textFieldEncargadoArticulo = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        textFieldUbicacion = new javax.swing.JTextField();
        buttonBuscarUbicacion = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        buttonEliminar = new javax.swing.JButton();
        buttoGuardar = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonCodeBar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(600, 150));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(52, 84, 133));

        jPanel2.setBackground(new java.awt.Color(59, 91, 141));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPanel4.setBackground(new java.awt.Color(49, 69, 100));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        buttonAceptaCategoria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonAceptaCategoria.setText("Aceptar");

        comboBoxCategoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoria 1", "Categoria 2", "Categoria 3", "Categoria 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(buttonAceptaCategoria)
                .addGap(56, 56, 56)
                .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAceptaCategoria)
                    .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(65, 97, 146));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descripcion");

        textFieldDescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Consecurivo");

        marca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        marca.setForeground(new java.awt.Color(255, 255, 255));
        marca.setText("Marca");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Modelo");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Precio");

        textFieldPrecio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textFieldModelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textFieldMarca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        textFieldConsecutivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(marca)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldConsecutivo)
                    .addComponent(textFieldDescripcion)
                    .addComponent(textFieldPrecio)
                    .addComponent(textFieldModelo)
                    .addComponent(textFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textFieldConsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marca)
                    .addComponent(textFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(52, 84, 133));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        buttonBuscarEncargado.setText("Buscar encargado ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textFieldEncargadoArticulo)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(buttonBuscarEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textFieldEncargadoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonBuscarEncargado))
        );

        jTabbedPane1.addTab("Encargado del Articulo", jPanel6);

        buttonBuscarUbicacion.setText("Buscar ubicacion del articulo");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textFieldUbicacion)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(buttonBuscarUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textFieldUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonBuscarUbicacion))
        );

        jTabbedPane1.addTab("Ubicacion del Articulo", jPanel7);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        buttonEliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonEliminar.setText("Eliminar");
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        buttoGuardar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttoGuardar.setText("Guardar");

        buttonUpdate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonUpdate.setText("Actualizar");

        buttonCodeBar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonCodeBar.setText("Imprimir");
        buttonCodeBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCodeBarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(buttoGuardar)
                .addGap(18, 18, 18)
                .addComponent(buttonEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonUpdate)
                .addGap(18, 18, 18)
                .addComponent(buttonCodeBar)
                .addGap(22, 22, 22))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttoGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(buttonUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCodeBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonCodeBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCodeBarActionPerformed
       controller.codeBarShow();
    }//GEN-LAST:event_buttonCodeBarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttoGuardar;
    private javax.swing.JButton buttonAceptaCategoria;
    private javax.swing.JButton buttonBuscarEncargado;
    private javax.swing.JButton buttonBuscarUbicacion;
    private javax.swing.JButton buttonCodeBar;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel marca;
    private javax.swing.JTextField textFieldConsecutivo;
    private javax.swing.JTextField textFieldDescripcion;
    private javax.swing.JTextField textFieldEncargadoArticulo;
    private javax.swing.JTextField textFieldMarca;
    private javax.swing.JTextField textFieldModelo;
    private javax.swing.JTextField textFieldPrecio;
    private javax.swing.JTextField textFieldUbicacion;
    // End of variables declaration//GEN-END:variables

}
