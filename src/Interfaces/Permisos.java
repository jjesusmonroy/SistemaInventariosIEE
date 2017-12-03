/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.MetodosG;
import basededatos.BDD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author pasto
 */
public class Permisos extends javax.swing.JFrame {

    /**
     * Creates new form Permisos
     */
    BDD b;
    boolean bandera;
    String [][] usuario;
    MetodosG m;
    String [][] idPersonal;
    public Permisos() {
        b = new BDD();
        m = new MetodosG();
        initComponents();
        invisible();
        iniciarTabla();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(b.convertir2d1d
        (b.obtenerConsultas("select _nombre_modulo from modulos order by _nombre_modulo"))));
        bandera=true;
        usuario = null;
        idPersonal =null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_usuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcAlta = new javax.swing.JCheckBox();
        jcBaja = new javax.swing.JCheckBox();
        jcConsulta = new javax.swing.JCheckBox();
        jcModificar = new javax.swing.JCheckBox();
        jcAdministrar = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<String>();
        idUsuario = new javax.swing.JLabel();
        apPaterno = new javax.swing.JLabel();
        apMaterno = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        lAlta = new javax.swing.JLabel();
        lBaja = new javax.swing.JLabel();
        lConsulta = new javax.swing.JLabel();
        lModificar = new javax.swing.JLabel();
        lAdministrar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 102, 255));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Permisos");

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sistema de Control de Inventario IEEN");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/minus-sign.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/salir2.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_usuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_usuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_usuarios);

        jLabel1.setText("USUARIO: ");

        jLabel2.setText("CONTRASEÑA:");

        jLabel3.setText("MODULO:");

        jcAlta.setText("Alta");
        jcAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcAltaActionPerformed(evt);
            }
        });

        jcBaja.setText("Baja");
        jcBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBajaActionPerformed(evt);
            }
        });

        jcConsulta.setText("Consulta");
        jcConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcConsultaActionPerformed(evt);
            }
        });

        jcModificar.setText("Modificar");
        jcModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcModificarActionPerformed(evt);
            }
        });

        jcAdministrar.setText("Administrar U");
        jcAdministrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcAdministrarActionPerformed(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        idUsuario.setText("idUsuario");

        apPaterno.setText("apPaterno");

        apMaterno.setText("apMaterno");

        nombre.setText("nombre");

        lAlta.setText("0");

        lBaja.setText("0");

        lConsulta.setText("0");

        lModificar.setText("0");

        lAdministrar.setText("0");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcAlta)
                            .addComponent(jcBaja)
                            .addComponent(jcConsulta)
                            .addComponent(jcModificar)
                            .addComponent(jcAdministrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lAlta)
                            .addComponent(lBaja)
                            .addComponent(lConsulta)
                            .addComponent(lModificar)
                            .addComponent(lAdministrar))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apPaterno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apMaterno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombre))
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcAlta)
                            .addComponent(lAlta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcBaja)
                            .addComponent(lBaja))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcConsulta)
                            .addComponent(lConsulta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcModificar)
                            .addComponent(lModificar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcAdministrar)
                            .addComponent(lAdministrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idUsuario)
                            .addComponent(apPaterno)
                            .addComponent(apMaterno)
                            .addComponent(nombre))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel14MouseClicked
    private void invisible(){
        idUsuario.setVisible(false);
        apPaterno.setVisible(false);
        apMaterno.setVisible(false);
        nombre.setVisible(false);
        lAlta.setVisible(false);
        lBaja.setVisible(false);
        lConsulta.setVisible(false);
        lModificar.setVisible(false);
        lAdministrar.setVisible(false);
    }
    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked

        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked
    
    private void iniciarTabla(){
        String query = "select apellido_pat_personal,apellido_mat_personal,nombre_personal from personal";
        String [][] busqueda = b.obtenerConsultas(query);
        tbl_usuarios.setModel(new javax.swing.table.DefaultTableModel(
                busqueda
                ,
            new String [] {
                "Apellido Paterno", "Apellido Materno", "Nombre"
            }
        ));
        
    }
    private void tbl_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usuariosMouseClicked
        // TODO add your handling code here:

        if(evt.getButton()== java.awt.event.MouseEvent.BUTTON3){
            int rows = tbl_usuarios.rowAtPoint(evt.getPoint());
            apPaterno.setText(tbl_usuarios.getValueAt(rows, 0)+"");
            apMaterno.setText(tbl_usuarios.getValueAt(rows, 1)+"");
            nombre.setText(tbl_usuarios.getValueAt(rows, 2)+"");
            final JPopupMenu menu = new JPopupMenu();
            JMenuItem item = new JMenuItem("Seleccionar");
            menu.add(item);
            ActionListener actionListener = new Permisos.PopupActionListener();
            item.addActionListener(actionListener);
            menu.show(evt.getComponent(),evt.getX(),evt.getY());
        }

    }//GEN-LAST:event_tbl_usuariosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int idModulo = b.getId("select * from modulos where _nombre_modulo = '"+jComboBox1.getSelectedItem().toString()+"'");
        if(bandera){
            String uUsuario = "nombre_usuario='"+jTextField1.getText()+"', "+
                            "contraseña_usuario='"+jTextField2.getText()+"'";
            b.execute("update usuarios set "+uUsuario+" where id_usuario ='"+usuario[0][0]+"'");
            String uPermisos = "alta_perrmiso='"+lAlta.getText()+"', "+
                            "baja_permiso='"+lBaja.getText()+"', "+
                            "consulta_permiso='"+lConsulta.getText()+"', "+
                            "modificar_permiso='"+lModificar.getText()+"', "+
                            "administrar_usuario_permiso='"+lAdministrar.getText()+"'";
            b.execute("update permisos set "+uPermisos+" where id_permiso ='"+usuario[0][3]+"'");
            b.execute("update permisos_modulos set id_modulo='"+idModulo+"' where id_usuario='"+usuario[0][0]+"'");
            JOptionPane.showMessageDialog(this, "Actualizado con exito");
            bandera=true;
        }
        else{
            int idPermiso = m.getMax(b.obtenerConsultas("select id_permiso from permisos"));
            int idU = m.getMax(b.obtenerConsultas("select id_usuario from usuarios"));
            String iusuario [] = new String []{idU+"",jTextField1.getText(),jTextField2.getText(),idPersonal[0][0]};
            b.insertar("usuarios", iusuario);
            String ipermiso [] = new String []{idPermiso+"",lAlta.getText(),lBaja.getText(),lConsulta.getText(),lModificar.getText(),lAdministrar.getText()};
            b.insertar("permisos", ipermiso);
            String ipermisos_modulos [] = new String []{idU+"",idPersonal[0][0],idPermiso+"",idModulo+""};
            b.insertar("permisos_modulos", ipermisos_modulos);
            JOptionPane.showMessageDialog(this, "Insertado con exito");
            bandera=true;
        }
        limpiar();
        iniciarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void limpiar(){
        jTextField1.setText("");
        jTextField2.setText("");
        jcAlta.setSelected(false);
        jcBaja.setSelected(false);
        jcConsulta.setSelected(false);
        jcModificar.setSelected(false);
        jcAdministrar.setSelected(false);
        lAlta.setText("0");
        lBaja.setText("0");
        lConsulta.setText("0");
        lModificar.setText("0");
        lAdministrar.setText("0");
    }
    private void jcAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcAltaActionPerformed
        // TODO add your handling code here:
        if(lAlta.getText().equals("1"))lAlta.setText("0");
        else lAlta.setText("1");
    }//GEN-LAST:event_jcAltaActionPerformed

    private void jcBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBajaActionPerformed
        // TODO add your handling code here:
        if(lBaja.getText().equals("1"))lBaja.setText("0");
        else lBaja.setText("1");
    }//GEN-LAST:event_jcBajaActionPerformed

    private void jcConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcConsultaActionPerformed
        // TODO add your handling code here:
        if(lConsulta.getText().equals("1"))lConsulta.setText("0");
        else lConsulta.setText("1");
    }//GEN-LAST:event_jcConsultaActionPerformed

    private void jcModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcModificarActionPerformed
        // TODO add your handling code here:
        if(lModificar.getText().equals("1"))lModificar.setText("0");
        else lModificar.setText("1");
    }//GEN-LAST:event_jcModificarActionPerformed

    private void jcAdministrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcAdministrarActionPerformed
        // TODO add your handling code here:
        if(lAdministrar.getText().equals("1"))lAdministrar.setText("0");
        else lAdministrar.setText("1");
    }//GEN-LAST:event_jcAdministrarActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        if(jTextField1.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') &&(c<'0' || c>'9')&& c!='_') evt.consume();
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        if(jTextField2.getText().length()>16){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') &&(c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_jTextField2KeyTyped
    class PopupActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            
            idPersonal = b.obtenerConsultas("select id_personal from personal where nombre_personal ='"+nombre.getText()+"' and apellido_pat_personal ='"+apPaterno.getText()
            +"' and apellido_mat_personal='"+apMaterno.getText()+"'");
            //try{
            String [] isthere = b.convertir2d1d(b.obtenerConsultas("select p.id_personal from personal p left join usuarios u on p.id_personal=u.id_personal where u.id_usuario is null"));
            for (String there : isthere) {
                if (there.equals(idPersonal[0][0])) {
                    bandera=false;
                    JOptionPane.showMessageDialog(null, "No se encontró un usuario asignado, favor de rellenar los campos para agregar");
                    jTextField1.requestFocus();
                }
            }
            if(bandera){
            usuario= b.obtenerConsultas("select u.id_usuario,u.nombre_usuario,u.contraseña_usuario,pe.id_permiso,m._nombre_modulo,pe.alta_perrmiso,pe.baja_permiso,pe.consulta_permiso,pe.modificar_permiso,pe.administrar_usuario_permiso,u.id_personal from usuarios u inner join permisos_modulos pm on u.id_personal=pm.id_personal and u.id_usuario=pm.id_usuario inner join modulos m on pm.id_modulo=m.id_modulo inner join permisos pe on pm.id_permiso=pe.id_permiso where u.id_personal='"+idPersonal[0][0]+"'");
            if(usuario.length==0){bandera=false; return;}
            jTextField1.setText(usuario[0][1]);
            jTextField2.setText(usuario[0][2]);
            jComboBox1.setSelectedItem(usuario[0][4]);
            if(usuario[0][5].equals("1")){jcAlta.setSelected(true); lAlta.setText("1");}
            if(usuario[0][6].equals("1")){jcBaja.setSelected(true); lBaja.setText("1");}
            if(usuario[0][7].equals("1")){jcConsulta.setSelected(true); lConsulta.setText("1");}
            if(usuario[0][8].equals("1")){jcModificar.setSelected(true); lModificar.setText("1");}
            if(usuario[0][9].equals("1")){jcAdministrar.setSelected(true); lAdministrar.setText("1");}
            }
        }
    }
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
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Permisos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apMaterno;
    private javax.swing.JLabel apPaterno;
    private javax.swing.JLabel idUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JCheckBox jcAdministrar;
    private javax.swing.JCheckBox jcAlta;
    private javax.swing.JCheckBox jcBaja;
    private javax.swing.JCheckBox jcConsulta;
    private javax.swing.JCheckBox jcModificar;
    private javax.swing.JLabel lAdministrar;
    private javax.swing.JLabel lAlta;
    private javax.swing.JLabel lBaja;
    private javax.swing.JLabel lConsulta;
    private javax.swing.JLabel lModificar;
    private javax.swing.JLabel nombre;
    private javax.swing.JTable tbl_usuarios;
    // End of variables declaration//GEN-END:variables
}
