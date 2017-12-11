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
import javax.swing.JOptionPane;

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
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        b = new BDD();
        m = new MetodosG();
        initComponents();
        invisible();
        iniciarTabla();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(b.convertir2d1d
        (b.obtenerConsultas("select area from area order by area"))));
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

        jPanel1 = new javax.swing.JPanel();
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
        jcSolicitar = new javax.swing.JCheckBox();
        lSolicitar = new javax.swing.JLabel();
        lAprobar = new javax.swing.JLabel();
        jcAprobar = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel4.setBackground(new java.awt.Color(255, 0, 204));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PERMISOS");

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SISTEMA DE CONTROL DE INVENTARIOS IEEN");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        tbl_usuarios.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
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
        ){public boolean isCellEditable(int row, int column){return false;}}
    );
    tbl_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_usuariosMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_usuarios);

    jLabel1.setText("USUARIO: ");

    jLabel2.setText("CONTRASEÑA:");

    jLabel3.setText("MODULO:");

    jcAlta.setText("ALTA");
    jcAlta.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jcAltaActionPerformed(evt);
        }
    });

    jcBaja.setText("BAJA");
    jcBaja.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jcBajaActionPerformed(evt);
        }
    });

    jcConsulta.setText("CONSULTA");
    jcConsulta.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jcConsultaActionPerformed(evt);
        }
    });

    jcModificar.setText("MODIFICAR");
    jcModificar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jcModificarActionPerformed(evt);
        }
    });

    jcAdministrar.setText("ADMINISTRAR USUARIOS");
    jcAdministrar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jcAdministrarActionPerformed(evt);
        }
    });

    jTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
    jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jTextField1KeyTyped(evt);
        }
    });

    jTextField2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    jTextField2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
    jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jTextField2KeyTyped(evt);
        }
    });

    jComboBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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

    jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jButton1.setForeground(new java.awt.Color(255, 51, 153));
    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/save.png"))); // NOI18N
    jButton1.setText("GUARDAR");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jcSolicitar.setText("SOLICITAR PRODUCTOS");
    jcSolicitar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jcSolicitarActionPerformed(evt);
        }
    });

    lSolicitar.setText("0");

    lAprobar.setText("0");

    jcAprobar.setText("APROBAR SOLICITUDES DE PRODUCTOS");
    jcAprobar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jcAprobarActionPerformed(evt);
        }
    });

    jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jButton2.setForeground(new java.awt.Color(255, 51, 153));
    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/error.png"))); // NOI18N
    jButton2.setText("Cancelar");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    jLabel7.setBackground(new java.awt.Color(255, 255, 255));
    jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/IEE.png"))); // NOI18N

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel7)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcAlta)
                            .addComponent(jcBaja)
                            .addComponent(jcConsulta)
                            .addComponent(jcModificar)
                            .addComponent(jcAdministrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcSolicitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcAprobar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lAlta)
                            .addComponent(lBaja)
                            .addComponent(lConsulta)
                            .addComponent(lModificar)
                            .addComponent(lAdministrar)
                            .addComponent(lSolicitar)
                            .addComponent(lAprobar))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(idUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apPaterno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apMaterno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombre))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 430, Short.MAX_VALUE))
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel7)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcAlta)
                            .addComponent(lAlta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcBaja)
                            .addComponent(lBaja))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcConsulta)
                            .addComponent(lConsulta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcModificar)
                            .addComponent(lModificar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcAdministrar)
                            .addComponent(lAdministrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcSolicitar)
                            .addComponent(lSolicitar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcAprobar)
                            .addComponent(lAprobar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idUsuario)
                            .addComponent(apPaterno)
                            .addComponent(apMaterno)
                            .addComponent(nombre))))
                .addContainerGap()))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    setLocationRelativeTo(null);
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
        lSolicitar.setVisible(false);
        lAprobar.setVisible(false);
    }
    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked

        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked
    
    private void iniciarTabla(){
        String query = "select apellido_pa,apellido_ma,nombre from personal";
        String [][] busqueda = b.obtenerConsultas(query);
        tbl_usuarios.setModel(new javax.swing.table.DefaultTableModel(
                busqueda
                ,
            new String [] {
                "Apellido Paterno", "Apellido Materno", "Nombre"
            }
        )
        {@Override
        public boolean isCellEditable(int row, int column){return false;}}
        );
        
    }
    private void tbl_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usuariosMouseClicked
        // TODO add your handling code here:

        //if(evt.getButton()== java.awt.event.MouseEvent.BUTTON3){
        if(evt.getClickCount()==2){
            int rows = tbl_usuarios.rowAtPoint(evt.getPoint());
            apPaterno.setText(tbl_usuarios.getValueAt(rows, 0)+"");
            apMaterno.setText(tbl_usuarios.getValueAt(rows, 1)+"");
            nombre.setText(tbl_usuarios.getValueAt(rows, 2)+"");
            clasepop();
            /*final JPopupMenu menu = new JPopupMenu();
            JMenuItem item = new JMenuItem("Seleccionar");
            menu.add(item);
            ActionListener actionListener = new Permisos.PopupActionListener();
            item.addActionListener(actionListener);
            menu.show(evt.getComponent(),evt.getX(),evt.getY());*/
        }

    }//GEN-LAST:event_tbl_usuariosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int idModulo = b.getId("select * from area where area = '"+jComboBox1.getSelectedItem().toString()+"'");
        if(bandera){
            String uUsuario = "usuario='"+jTextField1.getText()+"', "+
                            "pass='"+jTextField2.getText()+"'";
            b.execute("update usuario set "+uUsuario+" where id_usuario ='"+usuario[0][0]+"'");
            String uPermisos = "alta_permiso='"+lAlta.getText()+"', "+
                            "baja_permiso='"+lBaja.getText()+"', "+
                            "consulta_permiso='"+lConsulta.getText()+"', "+
                            "modificar_permiso='"+lModificar.getText()+"', "+
                            "administrar_usuario_permiso='"+lAdministrar.getText()+"', "+
                            "solicitar_producto_permiso='"+lSolicitar.getText()+"', "+
                            "aprobar_solicitud_producto_permiso='"+lAprobar.getText()+"'";
            b.execute("update permisos set "+uPermisos+" where id_permiso ='"+usuario[0][3]+"'");
            b.execute("update personal per INNER JOIN puesto pue on per.puesto_id_puesto = pue.id_puesto inner join usuario usu on per.id_personal = usu.personal_id_personal set pue.area_id_area ='"+idModulo+"' where usu.id_usuario ='"+usuario[0][0]+"'");
            JOptionPane.showMessageDialog(this, "Actualizado con exito");
            bandera=true;
        }
        else{
            int idPermiso = m.getMax(b.obtenerConsultas("select id_permiso from permisos"));
            int idU = m.getMax(b.obtenerConsultas("select id_usuario from usuario"));
            String iusuario [] = new String []{idU+"",jTextField1.getText(),jTextField2.getText(),idPersonal[0][0]};
            b.insertar("usuario", iusuario);
            String ipermiso [] = new String []{idPermiso+"",lAlta.getText(),lBaja.getText(),lConsulta.getText(),lModificar.getText(),lAdministrar.getText(),lSolicitar.getText(),lAprobar.getText()};
            b.insertar("permisos", ipermiso);
            String ipermisos_modulos [] = new String []{idU+"",idPermiso+""};
            b.insertar("usuarios_permisos", ipermisos_modulos);
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
        jcSolicitar.setSelected(false);
        jcAprobar.setSelected(false);
        lAlta.setText("0");
        lBaja.setText("0");
        lConsulta.setText("0");
        lModificar.setText("0");
        lAdministrar.setText("0");
        lSolicitar.setText("0");
        lAprobar.setText("0");
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

    private void jcSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcSolicitarActionPerformed
        // TODO add your handling code here:
        if(lSolicitar.getText().equals("1"))lSolicitar.setText("0");
        else lSolicitar.setText("1");
    }//GEN-LAST:event_jcSolicitarActionPerformed

    private void jcAprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcAprobarActionPerformed
        // TODO add your handling code here:
        if(lAprobar.getText().equals("1"))lAprobar.setText("0");
        else lAprobar.setText("1");
    }//GEN-LAST:event_jcAprobarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    class PopupActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            clasepop();
        }
    }
    private void clasepop(){
        bandera=true;
            idPersonal = b.obtenerConsultas("select id_personal from personal where nombre ='"+nombre.getText()+"' and apellido_pa ='"+apPaterno.getText()
            +"' and apellido_ma='"+apMaterno.getText()+"'");
            //try{
            String [] isthere = b.convertir2d1d(b.obtenerConsultas("select p.id_personal from personal p left join usuario u on p.id_personal=u.personal_id_personal where u.id_usuario is null"));
            for (String there : isthere) {
                if (there.equals(idPersonal[0][0])) {
                    bandera=false;
                    JOptionPane.showMessageDialog(null, "No se encontró un usuario asignado, favor de rellenar los campos para agregar");
                    limpiar();
                    jTextField1.requestFocus();
                }
            }
            if(bandera){
            usuario= b.obtenerConsultas("select usu.id_usuario,usu.usuario,usu.pass,per.id_permiso,are.area,per.alta_permiso,per.baja_permiso,per.consulta_permiso,per.modificar_permiso,per.administrar_usuario_permiso,per.solicitar_producto_permiso,per.aprobar_solicitud_producto_permiso,usu.personal_id_personal from usuario usu inner join usuarios_permisos up on usu.id_usuario = up.usuario_id_usuario inner join permisos per on up.permisos_id_permiso = per.id_permiso inner join personal pe on usu.personal_id_personal = pe.id_personal inner join puesto pue on pe.puesto_id_puesto = pue.id_puesto inner join area are on pue.area_id_area = are.id_area where usu.personal_id_personal='"+idPersonal[0][0]+"'");
            if(usuario.length==0){bandera=false; return;}
            jTextField1.setText(usuario[0][1]);
            jTextField2.setText(usuario[0][2]);
            jComboBox1.setSelectedItem(usuario[0][4]);
            if(usuario[0][5].equals("1")){jcAlta.setSelected(true); lAlta.setText("1");}
                else {jcAlta.setSelected(false); lAlta.setText("0");}
            if(usuario[0][6].equals("1")){jcBaja.setSelected(true); lBaja.setText("1");}
                else {jcBaja.setSelected(false); lBaja.setText("0");}
            if(usuario[0][7].equals("1")){jcConsulta.setSelected(true); lConsulta.setText("1");}
                else {jcConsulta.setSelected(false); lConsulta.setText("0");}
            if(usuario[0][8].equals("1")){jcModificar.setSelected(true); lModificar.setText("1");}
                else {jcModificar.setSelected(false); lModificar.setText("0");}
            if(usuario[0][9].equals("1")){jcAdministrar.setSelected(true); lAdministrar.setText("1");}
                else {jcAdministrar.setSelected(false); lAdministrar.setText("0");}
            if(usuario[0][10].equals("1")){jcSolicitar.setSelected(true); lSolicitar.setText("1");}
                else {jcSolicitar.setSelected(false); lSolicitar.setText("0");}
            if(usuario[0][11].equals("1")){jcAprobar.setSelected(true); lAprobar.setText("1");}
                else {jcAprobar.setSelected(false); lAprobar.setText("0");}
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
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JCheckBox jcAdministrar;
    private javax.swing.JCheckBox jcAlta;
    private javax.swing.JCheckBox jcAprobar;
    private javax.swing.JCheckBox jcBaja;
    private javax.swing.JCheckBox jcConsulta;
    private javax.swing.JCheckBox jcModificar;
    private javax.swing.JCheckBox jcSolicitar;
    private javax.swing.JLabel lAdministrar;
    private javax.swing.JLabel lAlta;
    private javax.swing.JLabel lAprobar;
    private javax.swing.JLabel lBaja;
    private javax.swing.JLabel lConsulta;
    private javax.swing.JLabel lModificar;
    private javax.swing.JLabel lSolicitar;
    private javax.swing.JLabel nombre;
    private javax.swing.JTable tbl_usuarios;
    // End of variables declaration//GEN-END:variables
}