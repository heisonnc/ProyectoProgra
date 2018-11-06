
package sistemadeactivos.presentation.administrador.ingresar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import sistemadeactivos.Application;
import sistemadeactivos.logic.Adquisicion;
import sistemadeactivos.logic.Bien;
import sistemadeactivos.logic.Categoria;
import sistemadeactivos.logic.Estado;
import sistemadeactivos.logic.Model;
import sistemadeactivos.logic.Solicitud;

public class IngresarView extends javax.swing.JFrame implements java.util.Observer {

    IngresarController controller;
    IngresarModel model;
    
    public void setController(IngresarController controller){
        this.controller=controller;
    }

    public IngresarController getController() {
        return controller;
    }
    
    public void inhabilitar(){
        comprobanteFld.setEnabled(false);
        fechaFld.setEnabled(false);
        cantidadFld.setEnabled(false);
        montoFld.setEnabled(false);
        marca.setEnabled(false);
        modelo.setEnabled(false);
        descripcion.setEnabled(false);
        precio.setEnabled(false);
        jComboBox1.setEnabled(false);
    } 
    
    public void setModel(IngresarModel model){
        this.model=model;
         model.addObserver(this);
    }

    public IngresarModel getModel() {
        return model;
    }
    
    @Override
   public void update(java.util.Observable updatedModel,Object parametros){
//       fechaFld.setEditable(false);
//       Date d = new Date();
//       DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
//       fechaFld.setText(hourFormat.format(d).toString());
       if(model.getRows().isEmpty()){
        this.limpiarErrores();
       }
       Solicitud filtro = model.getSolicitud();
       bienesFld.setModel(model.getBienes()); 
   }
    public IngresarView() {
        initComponents();
    }
    
    public void limpiarErrores(){
       this.cantidad.setForeground(Application.COLOR_OK); 
       this.comprobante.setForeground(Application.COLOR_OK); 
       this.fecha.setForeground(Application.COLOR_OK); 
       this.monto.setForeground(Application.COLOR_OK); 
       marca.setText("");
       this.modelo.setText("");
       descripcion.setText("");
       precio.setText("");
       comprobanteFld.setText("");
       montoFld.setText("");
       fechaFld.setText("");
       cantidadFld.setText("");
       cantidadBien.setText("");
   }
    
    public void limpiarBien(){
        marca.setText("");
       this.modelo.setText("");
       descripcion.setText("");
       precio.setText("");
       cantidadBien.setText("");
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comprobante = new javax.swing.JLabel();
        comprobanteFld = new javax.swing.JTextField();
        fecha = new javax.swing.JLabel();
        fechaFld = new javax.swing.JTextField();
        cantidad = new javax.swing.JLabel();
        cantidadFld = new javax.swing.JTextField();
        monto = new javax.swing.JLabel();
        montoFld = new javax.swing.JTextField();
        tipoFld = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        bienesFld = new javax.swing.JTable();
        marca = new javax.swing.JTextField();
        modelo = new javax.swing.JTextField();
        descripcion = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        agregarBienFld = new javax.swing.JButton();
        agregarSolicitudFld = new javax.swing.JButton();
        exitFld = new javax.swing.JButton();
        cantidadBien = new javax.swing.JTextField();

        comprobante.setText("combrobante");

        fecha.setText("fecha");

        fechaFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaFldActionPerformed(evt);
            }
        });

        cantidad.setText("cantidad");

        monto.setText("monto");

        tipoFld.setText("tipo");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Donacion", "Compra", "Traslado", "Elaboracion Propia" }));

        bienesFld.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(bienesFld);

        jScrollPane1.setViewportView(jScrollPane2);

        modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeloActionPerformed(evt);
            }
        });

        agregarBienFld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        agregarBienFld.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemadeactivos/presentation/icons/general/add.png"))); // NOI18N
        agregarBienFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBienFldActionPerformed(evt);
            }
        });

        agregarSolicitudFld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        agregarSolicitudFld.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemadeactivos/presentation/icons/general/add.png"))); // NOI18N
        agregarSolicitudFld.setText("Nuevo");
        agregarSolicitudFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarSolicitudFldActionPerformed(evt);
            }
        });

        exitFld.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemadeactivos/presentation/icons/general/exit.png"))); // NOI18N
        exitFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitFldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cantidadBien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agregarBienFld)))
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tipoFld)
                            .addComponent(comprobante))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comprobanteFld, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaFld, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cantidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cantidadFld, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addComponent(monto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(montoFld, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(agregarSolicitudFld)
                        .addGap(130, 130, 130)
                        .addComponent(exitFld)))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comprobante)
                    .addComponent(comprobanteFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha)
                    .addComponent(fechaFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad)
                    .addComponent(cantidadFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monto)
                    .addComponent(montoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoFld)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cantidadBien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(agregarBienFld, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregarSolicitudFld)
                    .addComponent(exitFld))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modeloActionPerformed

    public void habilitar(){
        comprobanteFld.setEnabled(true);
        fechaFld.setEnabled(true);
        cantidadFld.setEnabled(true);
        montoFld.setEnabled(true);
        marca.setEnabled(true);
        modelo.setEnabled(true);
        descripcion.setEnabled(true);
        precio.setEnabled(true);
        jComboBox1.setEnabled(true);
    }
    
    private void agregarSolicitudFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarSolicitudFldActionPerformed
        try{
        if(this.validar()){
                Solicitud s = toSolicitud();
                if(s == null){
                    throw new Exception("Solicitud no valida");
                }
                Categoria c = Model.instance().getCategoria("Indefinido");
                for(Bien b : model.rows){
                    b.setCategoria(c);
                }
                controller.preAgregarSolicitud(s, model.rows);
                model.setRows(new ArrayList<Bien>());
                JOptionPane.showMessageDialog(this, "Datos registrados", "OK", JOptionPane.INFORMATION_MESSAGE); 
        }
        else{
            JOptionPane.showMessageDialog(this, "Error en datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        this.limpiarErrores();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_agregarSolicitudFldActionPerformed

    private void exitFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitFldActionPerformed
        this.controller.exit();
    }//GEN-LAST:event_exitFldActionPerformed

    public boolean validar() throws Exception{
        boolean error = false;
        
        this.comprobante.setForeground(Application.COLOR_OK); 
        if (this.comprobanteFld.getText().isEmpty()){
            this.comprobante.setForeground(Application.COLOR_ERROR);
             error = true;
        }
        
//        this.fecha.setForeground(Application.COLOR_OK);        
//        if (this.fechaFld.getText().isEmpty()){
//            this.fecha.setForeground(Application.COLOR_ERROR);
//            error = true;
//        }
        
        this.cantidad.setForeground(Application.COLOR_OK);  
        int can = Integer.parseInt(cantidadFld.getText());
        if (this.cantidadFld.getText().isEmpty() || can < 1){
            this.cantidad.setForeground(Application.COLOR_ERROR);
            throw new Exception("ERROR");
        }
        
        double mon = Double.parseDouble(montoFld.getText());
        this.monto.setForeground(Application.COLOR_OK);        
        if (this.montoFld.getText().isEmpty() || mon < 1){
            this.monto.setForeground(Application.COLOR_ERROR);
            throw new Exception("ERROR");
        }
        
        return !error;
    }
    
    public boolean validarBien(){
        boolean error = false;
        
        this.comprobante.setForeground(Application.COLOR_OK); 
        if (this.marca.getText().isEmpty()){
             error = true;
        }
         
        if (this.modelo.getText().isEmpty()){
            error=true;
        }
               
        if (this.descripcion.getText().isEmpty()){
            error=true;
        }
        double pre = Double.parseDouble(this.precio.getText());
        if(this.precio.getText().isEmpty() || pre < 0){
            error = true;
        }
        
        return !error;
    }
    
    public Solicitud toSolicitud(){
        try{
        String str = (String)jComboBox1.getSelectedItem();
        Estado es = Model.instance().getEstado("Recibida");
        Solicitud result = new Solicitud();
        Adquisicion ad = Model.instance().getAdquisicion(str);
       
        result.setCantidadBienes(Integer.parseInt(cantidadFld.getText()));
        result.setComprobante(comprobanteFld.getText());
        result.setMontoTotal(Double.parseDouble(montoFld.getText()));
        result.setRechazo("en espera");
        result.setFecha(new Date());
        result.setEstado(es);
        result.setAdquisicion(ad);
        
        return result;
        }catch(Exception e){
            return null;
        }
    }
    
    public Bien toBien() throws Exception{
        Bien resultado = new Bien();
        resultado.setDescripcion(descripcion.getText());
        resultado.setCantidad(Integer.parseInt(cantidadBien.getText()));
        resultado.setMarca(marca.getText());
        resultado.setModelo(modelo.getText());
        resultado.setPrecioUnitario(Double.parseDouble(precio.getText()));
        return resultado;
    }
    
    private void agregarBienFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBienFldActionPerformed
        if(this.validarBien()){
            try {
                this.controller.agregarBien(this.toBien());
                JOptionPane.showMessageDialog(this, "Datos registrados", "OK", JOptionPane.INFORMATION_MESSAGE); 
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); 
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Error en datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        this.limpiarBien();
    }//GEN-LAST:event_agregarBienFldActionPerformed

    private void fechaFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaFldActionPerformed

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
            java.util.logging.Logger.getLogger(IngresarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBienFld;
    private javax.swing.JButton agregarSolicitudFld;
    private javax.swing.JTable bienesFld;
    private javax.swing.JLabel cantidad;
    private javax.swing.JTextField cantidadBien;
    private javax.swing.JTextField cantidadFld;
    private javax.swing.JLabel comprobante;
    private javax.swing.JTextField comprobanteFld;
    private javax.swing.JTextField descripcion;
    private javax.swing.JButton exitFld;
    private javax.swing.JLabel fecha;
    private javax.swing.JTextField fechaFld;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField modelo;
    private javax.swing.JLabel monto;
    private javax.swing.JTextField montoFld;
    private javax.swing.JTextField precio;
    private javax.swing.JLabel tipoFld;
    // End of variables declaration//GEN-END:variables
}
