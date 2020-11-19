/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;
import javax.swing.DefaultComboBoxModel;
import parcial4progra3.ConexionSql;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gerson
 */
public class empleados extends javax.swing.JFrame {
    int IdDepto = 0;
    DefaultTableModel tm;
    
    public DefaultComboBoxModel fillDept(){
        DefaultComboBoxModel lista = new DefaultComboBoxModel();
        try{
            //Llenado de la lista con los departamentos
            Connection cn = ConexionSql.getInstancia().getConexion();
            CallableStatement sql = cn.prepareCall("{call SP_departamentos}");
            ResultSet rs = sql.executeQuery();
            while(rs.next()){
                lista.addElement(rs.getInt(1) + "-" + rs.getString(2));
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.print(ex.getMessage());
        }
        return lista;
    }
    
    
    public void refreshCbxEmpleados(){
        DefaultComboBoxModel lista = new DefaultComboBoxModel();
        try{
            //Llenado de la lista con los departamentos
            Connection cn = ConexionSql.getInstancia().getConexion();
            CallableStatement sql = cn.prepareCall("{call SP_empleados}");
            ResultSet rs = sql.executeQuery();
            while(rs.next()){
                lista.addElement(rs.getInt(1) + "-" + rs.getString(2));
            }
            cbxEmpleados.setModel(lista);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.print(ex.getMessage());
        }
        
        
        
    }
    
    
    DefaultTableModel tablaEmpleados(){
         DefaultTableModel modelo;
         String data[][]={};
         String encabezado []={"Codigo","Nombre","Telefono","Departamento"}; 
           modelo = new DefaultTableModel(data, encabezado);
           jTableP.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
         //obteniendo la data
         try{
            //Llenado de la lista con los departamentos
            Connection cn = ConexionSql.getInstancia().getConexion();
            CallableStatement sql = cn.prepareCall("{call SP_empleados}");
            ResultSet rs = sql.executeQuery();
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getInt("idEmp"),rs.getString("nombre"),rs.getString("telefono"),rs.getString("departamento")});
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.print(ex.getMessage());
        }                 
         return modelo;
    }
    
    
    
    DefaultTableModel tablaMarcaciones(int idEmp){
         DefaultTableModel modelo;
         String data[][]={};
         String encabezado []={"Codigo","Nombre","Marcacion","Departamento", "Fecha"}; 
           modelo = new DefaultTableModel(data, encabezado);
           jTableP.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
         //obteniendo la data
         try{
            //Llenado de la lista con los departamentos
            Connection cn = ConexionSql.getInstancia().getConexion();
            CallableStatement sql = cn.prepareCall("{call SP_marcasEmpleado(?)}");
             String[] cbs = cbxEmpleados.getSelectedItem().toString().split("-");
            sql.setInt(1, Integer.parseInt(cbs[0]) );
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            ResultSet rs = sql.executeQuery();
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getInt("idEmp"),rs.getString("nombre"),rs.getString("tipoMarcacion"),rs.getString("departamento"), format.format(rs.getDate("fecha"))});
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.print(ex.getMessage());
        }
         
         return modelo;
    }
    
    
      
    
    void mostrarEmpleados(){
        jTableP.setModel(tablaEmpleados());       
        
    }
    
       void mostrarMarcaciones(){
     String[] cbs = cbDep.getSelectedItem().toString().split("-");
        jTableP.setModel(tablaMarcaciones(  Integer.parseInt(cbs[0])  ));       
        
    }


    public empleados() {
        initComponents();
        cbDep.setModel(fillDept());
        mostrarEmpleados();
        refreshCbxEmpleados();   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbDep = new javax.swing.JComboBox<>();
        lblDep = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableP = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbxEmpleados = new javax.swing.JComboBox<>();
        btnVerMarcaciones = new javax.swing.JButton();
        btnVerEmpleados = new javax.swing.JButton();
        btnEntrada = new javax.swing.JButton();
        btnSalida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblDep.setText("Departamento:");

        jTableP.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableP);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Teléfono:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel3.setText("Listado empleados:");

        cbxEmpleados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnVerMarcaciones.setText("Ver Marcaciones");
        btnVerMarcaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMarcacionesActionPerformed(evt);
            }
        });

        btnVerEmpleados.setText("Ver empleados");
        btnVerEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerEmpleadosActionPerformed(evt);
            }
        });

        btnEntrada.setText("Entrada");
        btnEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradaActionPerformed(evt);
            }
        });

        btnSalida.setText("Salida");
        btnSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnVerMarcaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(cbxEmpleados, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerEmpleados))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDep)
                            .addComponent(cbDep, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(lblDep)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAgregar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(btnVerEmpleados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntrada)
                    .addComponent(btnSalida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerMarcaciones)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerMarcacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMarcacionesActionPerformed
        mostrarMarcaciones();        
    }//GEN-LAST:event_btnVerMarcacionesActionPerformed

    private void btnVerEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEmpleadosActionPerformed
        mostrarEmpleados();       
    }//GEN-LAST:event_btnVerEmpleadosActionPerformed

    private void btnEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradaActionPerformed
            try{
            String[] cbs = cbxEmpleados.getSelectedItem().toString().split("-");
        Connection conexion = ConexionSql.getInstancia().getConexion();
            CallableStatement sql = conexion.prepareCall("{call SP_marcaEntrada(?,?)}");
            sql.setInt(1, Integer.parseInt(cbs[0]) );
            sql.registerOutParameter(2, java.sql.Types.INTEGER);
            sql.execute();
            if (sql.getInt(2)>0){
                JOptionPane.showMessageDialog(null, "Empleado marco entrada de "+cbs[1]);
            mostrarMarcaciones();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo marcar!");
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnEntradaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Pattern p = Pattern.compile("^[A-Za-z]*\\s()[A-Za-z]*$");
        Matcher m = p.matcher(txtNombre.getText());
        if (!m.find()){
            JOptionPane.showMessageDialog(null, "Ingrese un nombre valido");
            return;       
        }
        
        if(txtTelefono.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Telefono no puede ir vacio");
            return;    
        }
        try{
            String[] cbs = cbDep.getSelectedItem().toString().split("-");
        Connection conexion = ConexionSql.getInstancia().getConexion();
            CallableStatement sql = conexion.prepareCall("{call SP_ingresarEmpleado(?,?,?,?)}");
            sql.setString(1, txtNombre.getText());
            sql.setString(2, txtTelefono.getText());
            sql.setString(3, cbs[0]);
            sql.registerOutParameter(4, java.sql.Types.INTEGER);
            sql.execute();
            if (sql.getInt(4)>0){
                JOptionPane.showMessageDialog(null, "Empleado Ingresado con id: "+sql.getInt(4));
            mostrarEmpleados();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo ingresar!");
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex.getMessage());
        }
        
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaActionPerformed
        try{
            String[] cbs = cbxEmpleados.getSelectedItem().toString().split("-");
        Connection conexion = ConexionSql.getInstancia().getConexion();
            CallableStatement sql = conexion.prepareCall("{call SP_marcaSalida(?,?)}");
            sql.setInt(1, Integer.parseInt(cbs[0]) );
            sql.registerOutParameter(2, java.sql.Types.INTEGER);
            sql.execute();
            if (sql.getInt(2)>0){
                JOptionPane.showMessageDialog(null, "Empleado marco Salida de "+cbs[1]);
            mostrarMarcaciones();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo marcar!");
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnSalidaActionPerformed

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
            java.util.logging.Logger.getLogger(empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEntrada;
    private javax.swing.JButton btnSalida;
    private javax.swing.JButton btnVerEmpleados;
    private javax.swing.JButton btnVerMarcaciones;
    private javax.swing.JComboBox<String> cbDep;
    private javax.swing.JComboBox<String> cbxEmpleados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableP;
    private javax.swing.JLabel lblDep;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
