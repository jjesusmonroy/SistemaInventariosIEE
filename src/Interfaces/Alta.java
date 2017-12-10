/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import basededatos.BDD;
import Clases.*;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.Image;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Cherne
 */
public class Alta extends javax.swing.JFrame {

    /**
     * Creates new form Alta
     */
    Validaciones v;
    BDD b;
    MetodosG m;
    File fichero;
    String ficherovalidacion;
    boolean existe;
    public Alta() {
        ficherovalidacion="";
        v=new Validaciones();
        b = new BDD();
        m = new MetodosG();        
        initComponents();
        jPanel2.setBackground(Color.WHITE);
        jPanel4.setBackground(Color.white);
        //jPanel2.setBackground(new java.awt.Color(219,213,219));
        altatvplacas.setToolTipText("XXX-00-00 / XX-000-00");
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(b.convertir2d1d
        (b.obtenerConsultas("select nombre_categoria from categoria order by nombre_categoria"))));
        folio();
       // jPanel4.setEnabled(false);
        altatfecha.setFocusable(false);
        altatstockmin.setEnabled(false);
        altalCantidad.setForeground(Color.GRAY);
        camposDesVehiculos();
        limpiar();
        
    }
    private void folio(){
        int id = m.getMax(b.obtenerConsultas("select id_producto from producto"));
        jLabel6.setText(id+"");
    }
    private void altaProductos(){
        existe=true;
        int id = Integer.parseInt(jLabel6.getText()); // opcional en lo que se resuelve lo del folio
        int id2 = b.getId("select * from categoria where nombre_categoria = '"+jComboBox1.getSelectedItem().toString()+"'");        
        String [] insertar = new String [17];
        insertar[0]=id+"";
        insertar[1]=jLabel6.getText();
        insertar[2]=m.jtextfield(altatnombre);
        insertar[3]=m.jtextarea(altatdescripcion);
        insertar[4]=m.jtextfield(altatmarca);
        insertar[5]=m.jtextfield(altatmodelo);
        insertar[6]=m.jtextfield(altatnoserie);
        insertar[7]=m.jtextfield(altatcolor);
        if(ficherovalidacion.equals("")){insertar[8]=null;}
        else {insertar[8]=rutaChida(fichero.toString());}
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        if(altatfecha.getDate().after(date)){return;}
        insertar[9] = sdf.format(altatfecha.getDate());
        insertar[10]=m.jtextfield(altatnofactura);
        insertar[11]=m.jtextfield(altatimprote);    
        insertar[12]=m.jtextarea(altatobserv);
        insertar[13]=m.jtextfield(altatstockmin);
        insertar[14]=m.jtextfield(altatstockmin);
        insertar[15]="Disponible";
        insertar[16]=id2+"";
        if(jComboBox1.getSelectedItem().toString().toLowerCase().equals("consumibles")){
            if(m.exists(insertar[2].toLowerCase(), b.obtenerConsultas("select nombre_producto from producto where status_producto = 'Disponible'"))){
                String atole = JOptionPane.showInputDialog("Producto encontrado, agregar stock?");
                b.execute("update producto set stock_producto = stock_producto + "+atole+ " where nombre_producto = '"+insertar[2]+"'");
                JOptionPane.showMessageDialog(this, "Actualizado con exito");
                existe=false;
                return;
            }
        }
        b.insertar("producto", insertar);
        if(jComboBox1.getSelectedItem().toString().toLowerCase().equals("vehiculo") || jComboBox1.getSelectedItem().toString().toLowerCase().equals("vehiculos")){
            int idcar= m.getMax(b.obtenerConsultas("select id_vehiculo from vehiculo"));
            String [] insertarvehiculo = new String [8];
            insertarvehiculo[0]=idcar+"";
            insertarvehiculo[1]=m.jtextfield(altatvplacas);
            insertarvehiculo[2]=m.jtextfield(altatvnomotor);
            insertarvehiculo[3]=m.jtextfield(altatvkm);
            insertarvehiculo[4]=m.jtextfield(altatvservicio);
            insertarvehiculo[5]=jComboBox2.getSelectedItem().toString();
            insertarvehiculo[6]=idcar+"";
            insertarvehiculo[7]=id+"";
            b.insertar("vehiculo", insertarvehiculo);
        }
        folio();
    }
    
    private void limpiar(){
        jComboBox1.setSelectedIndex(0);
        lblImage.setIcon(null);
        altatnombre.setText("");
        altatdescripcion.setText("");
        altatnoserie.setText("");
        altatmarca.setText("");
        altatmodelo.setText("");
        altatcolor.setText("");
        Date date = new Date();
        altatfecha.setDate(date);
        altatnofactura.setText("");
        altatimprote.setText("");
        altatobserv.setText("");
        altatstockmin.setText("");
        altatvplacas.setText("");
        altatvnomotor.setText("");
        altatvkm.setText("");
        altatvservicio.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        altalNombre = new javax.swing.JLabel();
        altalDes = new javax.swing.JLabel();
        altalMarca = new javax.swing.JLabel();
        altalModelo = new javax.swing.JLabel();
        altalNoSerie = new javax.swing.JLabel();
        altalColor = new javax.swing.JLabel();
        altalFecha = new javax.swing.JLabel();
        altalNoFact = new javax.swing.JLabel();
        altalImporte = new javax.swing.JLabel();
        altalObser = new javax.swing.JLabel();
        altalCantidad = new javax.swing.JLabel();
        altatstockmin = new javax.swing.JTextField();
        altatnombre = new javax.swing.JTextField();
        altatnoserie = new javax.swing.JTextField();
        altatmarca = new javax.swing.JTextField();
        altatmodelo = new javax.swing.JTextField();
        altatcolor = new javax.swing.JTextField();
        altatnofactura = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        altatdescripcion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        altatobserv = new javax.swing.JTextArea();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        altatfecha = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        altalPlacas = new javax.swing.JLabel();
        altatvplacas = new javax.swing.JTextField();
        altalNoMotor = new javax.swing.JLabel();
        altatvnomotor = new javax.swing.JTextField();
        altalKm = new javax.swing.JLabel();
        altatvkm = new javax.swing.JTextField();
        altalKmSer = new javax.swing.JLabel();
        altatvservicio = new javax.swing.JTextField();
        altatvtipo = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<String>();
        lblImage = new javax.swing.JLabel();
        btnCargarFoto = new javax.swing.JButton();
        altatimprote = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel3.setBackground(new java.awt.Color(255, 51, 204));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ALTA DE PRODUCTOS");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SISTEMA DE CONTROL DE INVENTARIO IEEN");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/minus-sign.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/salir2.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("CATEGORIA:");

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 51, 153));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        jComboBox1.setName(""); // NOI18N
        jComboBox1.setNextFocusableComponent(altatnombre);
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("FOLIO");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Folio");

        altalNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalNombre.setText("NOMBRE:");

        altalDes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalDes.setText("DESCRIPCIÓN:");

        altalMarca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalMarca.setText("MARCA:");

        altalModelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalModelo.setText("MODELO:");

        altalNoSerie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalNoSerie.setText("NO. DE SERIE:");

        altalColor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalColor.setText("COLOR:");

        altalFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalFecha.setText("FECHA DE COMPRA:");

        altalNoFact.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalNoFact.setText("NO. FACTURA:");

        altalImporte.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalImporte.setText("IMPORTE:");

        altalObser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalObser.setText("OBSERVACIONES:");

        altalCantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalCantidad.setText("STOCK MINIMO:");

        altatstockmin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatstockmin.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        altatstockmin.setNextFocusableComponent(altatnofactura);
        altatstockmin.setPreferredSize(new java.awt.Dimension(5, 22));
        altatstockmin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                altatstockminFocusGained(evt);
            }
        });
        altatstockmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatstockminKeyTyped(evt);
            }
        });

        altatnombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatnombre.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        altatnombre.setNextFocusableComponent(altatmarca);
        altatnombre.setPreferredSize(new java.awt.Dimension(5, 22));
        altatnombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                altatnombreFocusGained(evt);
            }
        });
        altatnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatnombreKeyTyped(evt);
            }
        });

        altatnoserie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatnoserie.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        altatnoserie.setNextFocusableComponent(altatdescripcion);
        altatnoserie.setPreferredSize(new java.awt.Dimension(5, 22));
        altatnoserie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                altatnoserieFocusGained(evt);
            }
        });
        altatnoserie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatnoserieKeyTyped(evt);
            }
        });

        altatmarca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatmarca.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        altatmarca.setNextFocusableComponent(altatcolor);
        altatmarca.setPreferredSize(new java.awt.Dimension(5, 22));
        altatmarca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                altatmarcaFocusGained(evt);
            }
        });
        altatmarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatmarcaKeyTyped(evt);
            }
        });

        altatmodelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatmodelo.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        altatmodelo.setNextFocusableComponent(altatnoserie);
        altatmodelo.setPreferredSize(new java.awt.Dimension(5, 22));
        altatmodelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                altatmodeloFocusGained(evt);
            }
        });
        altatmodelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatmodeloKeyTyped(evt);
            }
        });

        altatcolor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatcolor.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        altatcolor.setMinimumSize(new java.awt.Dimension(5, 22));
        altatcolor.setNextFocusableComponent(altatmodelo);
        altatcolor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                altatcolorFocusGained(evt);
            }
        });
        altatcolor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatcolorKeyTyped(evt);
            }
        });

        altatnofactura.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatnofactura.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        altatnofactura.setNextFocusableComponent(altatfecha);
        altatnofactura.setPreferredSize(new java.awt.Dimension(5, 22));
        altatnofactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                altatnofacturaFocusGained(evt);
            }
        });
        altatnofactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatnofacturaKeyTyped(evt);
            }
        });

        altatdescripcion.setColumns(20);
        altatdescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatdescripcion.setRows(3);
        altatdescripcion.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        altatdescripcion.setNextFocusableComponent(altatstockmin);
        altatdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatdescripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(altatdescripcion);

        altatobserv.setColumns(20);
        altatobserv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatobserv.setRows(5);
        altatobserv.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        altatobserv.setNextFocusableComponent(altatvplacas);
        altatobserv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatobservKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(altatobserv);

        jButton9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 51, 153));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/save.png"))); // NOI18N
        jButton9.setText("GUARDAR");
        jButton9.setNextFocusableComponent(jButton10);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 51, 153));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/eraser.png"))); // NOI18N
        jButton10.setText("LIMPIAR");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 51, 153));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/delete-button.png"))); // NOI18N
        jButton11.setText("CANCELAR");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        altatfecha.setBackground(new java.awt.Color(255, 255, 255));
        altatfecha.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        altatfecha.setForeground(new java.awt.Color(255, 51, 153));
        altatfecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatfecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                altatfechaFocusGained(evt);
            }
        });
        altatfecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                altatfechaPropertyChange(evt);
            }
        });
        altatfecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatfechaKeyTyped(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Vehiculo"));

        altalPlacas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalPlacas.setText("PLACAS:");

        altatvplacas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatvplacas.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        altatvplacas.setNextFocusableComponent(altatvnomotor);
        altatvplacas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                altatvplacasFocusGained(evt);
            }
        });
        altatvplacas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                altatvplacasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                altatvplacasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatvplacasKeyTyped(evt);
            }
        });

        altalNoMotor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalNoMotor.setText("NO. MOTOR:");

        altatvnomotor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatvnomotor.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        altatvnomotor.setNextFocusableComponent(altatvkm);
        altatvnomotor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                altatvnomotorFocusGained(evt);
            }
        });
        altatvnomotor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatvnomotorKeyTyped(evt);
            }
        });

        altalKm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalKm.setText("KILOMETRAJE:");

        altatvkm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatvkm.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        altatvkm.setNextFocusableComponent(altatvservicio);
        altatvkm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                altatvkmFocusGained(evt);
            }
        });
        altatvkm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatvkmKeyTyped(evt);
            }
        });

        altalKmSer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalKmSer.setText("KM. SERVICIO:");

        altatvservicio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatvservicio.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        altatvservicio.setNextFocusableComponent(jButton9);
        altatvservicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                altatvservicioFocusGained(evt);
            }
        });
        altatvservicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatvservicioKeyTyped(evt);
            }
        });

        altatvtipo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatvtipo.setText("TIPO:");

        jComboBox2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 51, 153));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Camioneta", "Pickup", "Auto", "Motocicleta" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(altalNoMotor)
                    .addComponent(altalPlacas)
                    .addComponent(altatvtipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(altatvplacas)
                    .addComponent(altatvnomotor)
                    .addComponent(jComboBox2, 0, 124, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(altalKmSer)
                    .addComponent(altalKm))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(altatvkm, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(altatvservicio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altatvtipo)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(altalKm)
                        .addComponent(altatvkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(altalPlacas)
                        .addComponent(altatvplacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(altatvservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(altalNoMotor)
                        .addComponent(altatvnomotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(altalKmSer)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lblImage.setBackground(new java.awt.Color(255, 255, 255));
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("FOTO");
        lblImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCargarFoto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCargarFoto.setForeground(new java.awt.Color(255, 51, 153));
        btnCargarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/subir_foto.png"))); // NOI18N
        btnCargarFoto.setText("CARGAR FOTO");
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });

        altatimprote.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 153), null));
        altatimprote.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        altatimprote.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatimprote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatimproteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11)
                        .addContainerGap(95, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(altalModelo)
                                            .addComponent(altalColor)
                                            .addComponent(altalMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(altalNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(altatnombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(altatmarca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(altatcolor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(altatmodelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBox1, 0, 266, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(altalNoSerie)
                                            .addComponent(altalDes))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(altatnoserie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(altalFecha)
                                        .addGap(18, 18, 18)
                                        .addComponent(altatfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(altalCantidad)
                                            .addComponent(altalNoFact))
                                        .addGap(51, 51, 51)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(altatstockmin, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(altatnofactura, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(btnCargarFoto)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(altalObser)
                                                .addComponent(altalImporte))
                                            .addGap(34, 34, 34)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(altatimprote, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(altalCantidad)
                    .addComponent(altatstockmin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(altatnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(altatmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalMarca)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(altalNoFact)
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(altatnofactura, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(altatfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalFecha))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(altatcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalColor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(altatmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalModelo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(altalNoSerie)
                            .addComponent(altatnoserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(altalDes)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(altatimprote, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalImporte))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalObser, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCargarFoto)
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton11))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/IEE.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked

        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void altat11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_altat11FocusLost
        // TODO add your handling code here:
        float a=Float.parseFloat(altatimprote.getText());
        altatimprote.setText(a+"");
    }//GEN-LAST:event_altat11FocusLost

    private void altatvservicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_altatvservicioFocusGained
        // TODO add your handling code here:
        altatvservicio.setBackground(Color.white);
        //asKmServicio.setText("");
    }//GEN-LAST:event_altatvservicioFocusGained

    private void altatvkmFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_altatvkmFocusGained
        // TODO add your handling code here:
        altatvkm.setBackground(Color.white);
        //asKilometraje.setText("");
    }//GEN-LAST:event_altatvkmFocusGained

    private void altatvnomotorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_altatvnomotorFocusGained
        // TODO add your handling code here:
        altatvnomotor.setBackground(Color.white);
        //asNoMotor.setText("");
    }//GEN-LAST:event_altatvnomotorFocusGained

    private void altatvplacasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatvplacasKeyTyped
        // TODO add your handling code here:
        if(altatvplacas.getText().length()>=9){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') &&(c<'0' || c>'9') && c!='-') evt.consume();
    }//GEN-LAST:event_altatvplacasKeyTyped

    private void altatvplacasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatvplacasKeyReleased
        // TODO add your handling code here:
        altatvplacas.setText(altatvplacas.getText().toUpperCase());
    }//GEN-LAST:event_altatvplacasKeyReleased

    private void altatvplacasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatvplacasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_altatvplacasKeyPressed

    private void altatvplacasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_altatvplacasFocusGained
        // TODO add your handling code here:
        altatvplacas.setBackground(Color.white);
        //asPlacas.setText("");
    }//GEN-LAST:event_altatvplacasFocusGained

    private void altatfechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_altatfechaFocusGained
            altatimprote.hasFocus();
    }//GEN-LAST:event_altatfechaFocusGained

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButton10ActionPerformed
	
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        String var = jComboBox1.getSelectedItem().toString().toLowerCase();
        //validaFecha();
        switch (var) {
            case "vehiculos":
                if(valVehiculo()==0){// && validaFecha()){
                    altaProductos();
                    //altatnombre.setEnabled(false);
                    if(existe)javax.swing.JOptionPane.showMessageDialog(null,"Se insertó el registro");
                    limpiar();
                }else{
                    javax.swing.JOptionPane.showMessageDialog(null,"Campos vacios/invalidos");
                }   break;
            case "consumibles":
                if(valCamposConsumibles()==0){// && validaFecha()){
                    altaProductos();
                    if(existe)javax.swing.JOptionPane.showMessageDialog(null,"Se insertó el registro");
                    limpiar();
                }else{
                    altatstockmin.setBackground(Color.PINK);
                    javax.swing.JOptionPane.showMessageDialog(null,"Campos vacios/invalidos");
                }   break;
            default:
                if(valCamposGeneral()==0){// && validaFecha()){
                    altaProductos();
                    if(existe)javax.swing.JOptionPane.showMessageDialog(null,"Se inserto el registro");
                    limpiar();
                }else{
                    javax.swing.JOptionPane.showMessageDialog(null,"Campos vacios/invalidos");
                }   break;
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void altatnofacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_altatnofacturaFocusGained
        // TODO add your handling code here:
        altatnofactura.setBackground(Color.white);
        //asNoFact.setText("");
    }//GEN-LAST:event_altatnofacturaFocusGained

    private void altatcolorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_altatcolorFocusGained
        // TODO add your handling code here:
        altatcolor.setBackground(Color.white);
        //asColor.setText("");
    }//GEN-LAST:event_altatcolorFocusGained

    private void altatmodeloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_altatmodeloFocusGained
        // TODO add your handling code here:
        altatmodelo.setBackground(Color.white);
        //asNoSerie.setText("");
    }//GEN-LAST:event_altatmodeloFocusGained

    private void altatmarcaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_altatmarcaFocusGained
        // TODO add your handling code here:
        altatmarca.setBackground(Color.white);
        //asModelo.setText("");
    }//GEN-LAST:event_altatmarcaFocusGained

    private void altatnoserieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_altatnoserieFocusGained
        // TODO add your handling code here:
        altatnoserie.setBackground(Color.white);
        //asMarca.setText("");
    }//GEN-LAST:event_altatnoserieFocusGained

    private void altatnombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_altatnombreFocusGained
        // TODO add your handling code here:
        altatnombre.setBackground(Color.WHITE);
        //asNombre.setText("");
    }//GEN-LAST:event_altatnombreFocusGained

    private void altatstockminFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_altatstockminFocusGained
        // TODO add your handling code here:
        altatstockmin.setBackground(Color.WHITE);
        //asStock.setText("");
    }//GEN-LAST:event_altatstockminFocusGained

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        String var = jComboBox1.getSelectedItem().toString().toLowerCase();
        if(var.equals("consumibles")){
            altatstockmin.setEnabled(true);
            altalCantidad.setForeground(Color.BLACK);
            altatnoserie.setEnabled(false);
            altatdescripcion.setEnabled(false);
            altatobserv.setEnabled(false);
            altatmodelo.setEnabled(false);
        }else if(var.equals("vehiculos")){
            camposHabVehiculos();
        }else{
            camposDesVehiculos();
            altatstockmin.setEnabled(false);
            altatnoserie.setEnabled(true);
            altatdescripcion.setEnabled(true);
            altatobserv.setEnabled(true);
            altatmodelo.setEnabled(true);
            altalCantidad.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
        // TODO add your handling code here:
        int resultado;
        
        CargarFoto ventana= new CargarFoto();
        FileNameExtensionFilter filtro= new FileNameExtensionFilter("JPG y PNG","jpg","png");
        
        ventana.jfcCargarFoto.setFileFilter(filtro);
        resultado=ventana.jfcCargarFoto.showOpenDialog(null);
        if(JFileChooser.APPROVE_OPTION==resultado){

            fichero=ventana.jfcCargarFoto.getSelectedFile();
            try{
                    ImageIcon icon=new ImageIcon(fichero.toString());
                    ficherovalidacion=fichero.toString();
                    Icon icono=new ImageIcon(icon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),Image.SCALE_DEFAULT));
                    lblImage.setText("");
                    lblImage.setIcon(icono);
            }catch(Exception e){
                  javax.swing.JOptionPane.showMessageDialog(this, "Error abriendo imagen");
            }
        
        }
     
    }//GEN-LAST:event_btnCargarFotoActionPerformed

    private void altatnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatnombreKeyTyped
        // TODO add your handling code here:
        if(altatnombre.getText().length()>30){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!='ñ' && c!='Ñ' && c!='á'
                && c!='é' && c!='í' && c!='ó' && c!='ú' && c!=' ' 
                && c!='Á' && c!='É' && c!='Í' && c!='Ú' && c!='Ó') evt.consume();
    }//GEN-LAST:event_altatnombreKeyTyped

    private void altatmarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatmarcaKeyTyped
        // TODO add your handling code here:
        if(altatmarca.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!='ñ' && c!='Ñ' && c!='á'
                && c!='é' && c!='í' && c!='ó' && c!='ú' && c!=' ' 
                && c!='Á' && c!='É' && c!='Í' && c!='Ú' && c!='Ó' &&(c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altatmarcaKeyTyped

    private void altatcolorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatcolorKeyTyped
        // TODO add your handling code here:
        if(altatcolor.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!=' ' ) evt.consume();
    }//GEN-LAST:event_altatcolorKeyTyped

    private void altatmodeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatmodeloKeyTyped
        // TODO add your handling code here:
        if(altatmodelo.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altatmodeloKeyTyped

    private void altatnoserieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatnoserieKeyTyped
        // TODO add your handling code here:
        if(altatnoserie.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altatnoserieKeyTyped

    private void altatstockminKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatstockminKeyTyped
        // TODO add your handling code here:
        if(altatstockmin.getText().length()>15){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altatstockminKeyTyped

    private void altatnofacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatnofacturaKeyTyped
        // TODO add your handling code here:
        if(altatnofactura.getText().length()>20){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altatnofacturaKeyTyped

    private void altatobservKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatobservKeyTyped
        // TODO add your handling code here:
        if(altatobserv.getText().length()>80){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!='ñ' && c!='Ñ' && c!='á'
                && c!='é' && c!='í' && c!='ó' && c!='ú' && c!=' ' 
                && c!='Á' && c!='É' && c!='Í' && c!='Ú' && c!='Ó' &&(c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altatobservKeyTyped

    private void altatdescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatdescripcionKeyTyped
        // TODO add your handling code here:
        if(altatdescripcion.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!='ñ' && c!='Ñ' && c!='á'
                && c!='é' && c!='í' && c!='ó' && c!='ú' && c!=' ' 
                && c!='Á' && c!='É' && c!='Í' && c!='Ú' && c!='Ó' &&(c<'0' || c>'9') && c!='.' && c!=',') evt.consume();
    }//GEN-LAST:event_altatdescripcionKeyTyped

    private void altatvnomotorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatvnomotorKeyTyped
        // TODO add your handling code here:
        if(altatvnomotor.getText().length()>45){
            evt.consume();
        }
         char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altatvnomotorKeyTyped

    private void altatvkmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatvkmKeyTyped
        // TODO add your handling code here:
        if(altatvkm.getText().length()>45){
            evt.consume();
        }
         char c = evt.getKeyChar();
        if((c<'0' || c>'9')&& c!='.') evt.consume();
    }//GEN-LAST:event_altatvkmKeyTyped

    private void altatvservicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatvservicioKeyTyped
        // TODO add your handling code here:
         if(altatvservicio.getText().length()>45){
            evt.consume();
        }
         char c = evt.getKeyChar();
        if((c<'0' || c>'9')&& c!='.') evt.consume();
    }//GEN-LAST:event_altatvservicioKeyTyped

    private void altatimproteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatimproteKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')&& c!='.') evt.consume();
    }//GEN-LAST:event_altatimproteKeyTyped

    private void altatfechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatfechaKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_altatfechaKeyTyped

    private void altatfechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_altatfechaPropertyChange
        // TODO add your handling code here:
        Date date = new Date();
        if(altatfecha.getDate()==null)return;
        if(altatfecha.getDate().after(date)){JOptionPane.showMessageDialog(this, "Fecha posterior a la actual");}
    }//GEN-LAST:event_altatfechaPropertyChange
   public int valCamposGeneral(){
       int cont=0;
        if(v.soloLetras(altatnombre.getText())==true){
            cont++;
            //asNombre.setText("*");
            altatnombre.setBackground(Color.PINK);
        }
        if(v.estaVacio(altatnoserie.getText())==true){
            cont++;
            //asMarca.setText("*");
            altatnoserie.setBackground(Color.PINK);
        }
        if(v.estaVacio(altatmarca.getText())==true){
            cont++;
            //asModelo.setText("*");
            altatmarca.setBackground(Color.PINK);
        }
        if(v.estaVacio(altatmodelo.getText())==true){
            cont++;
            //asNoSerie.setText("*");
            altatmodelo.setBackground(Color.PINK);
        }
        if(v.soloLetras(altatcolor.getText())==true){
            cont++;
            //asColor.setText("*");
            altatcolor.setBackground(Color.PINK);
        }
        if(v.soloNumeros(altatnofactura.getText())==true){
            cont++;
            //asNoFact.setText("*");
            altatnofactura.setBackground(Color.PINK);
        }
        if(v.soloDecimales(altatimprote.getText())==true){
            cont++;
            //asImporte.setText("*");
            altatimprote.setBackground(Color.PINK);
        }
        return cont;
   }
    public int valVehiculo(){
          int cont=0;
        if(v.estaVacio(altatnoserie.getText())==true){
            cont++;
            //asMarca.setText("*");
            altatnoserie.setBackground(Color.PINK);
        }
        if(v.estaVacio(altatmarca.getText())==true){
            cont++;
            //asModelo.setText("*");
            altatmarca.setBackground(Color.PINK);
        }
        if(v.estaVacio(altatmodelo.getText())==true){
            cont++;
            //asNoSerie.setText("*");
            altatmodelo.setBackground(Color.PINK);
        }
        if(v.soloLetras(altatcolor.getText())==true){
            cont++;
            //asColor.setText("*");
            altatcolor.setBackground(Color.PINK);
        }
        if(v.soloNumeros(altatnofactura.getText())==true){
            cont++;
            //asNoFact.setText("*");
            altatnofactura.setBackground(Color.PINK);
        }
        if(v.soloDecimales(altatimprote.getText())==true){
            cont++;
            //asImporte.setText("*");
            altatimprote.setBackground(Color.PINK);
        }       
       if(v.estaVacio(altatvplacas.getText())){
            cont++;
            //asImporte.setText("*");
            altatvplacas.setBackground(Color.PINK);
       }
       if(altatvplacas.getText().length()!=9){
            cont++;
            altatvplacas.setBackground(Color.PINK);
        }else if(v.valPlacas(altatvplacas.getText())){
             cont++;
            //asImporte.setText("*");
            altatvplacas.setBackground(Color.PINK);
        }
        
        if(v.estaVacio(altatvnomotor.getText())){
            cont++;
            altatvnomotor.setBackground(Color.PINK);
        }
        if(v.soloNumeros(altatvnomotor.getText())){
            cont++;
            altatvnomotor.setBackground(Color.PINK);
        }
        if(v.estaVacio(altatvkm.getText())){
            cont++;
            altatvkm.setBackground(Color.PINK);
        }
        if(v.soloDecimales(altatvkm.getText())){
            cont++;
            altatvkm.setBackground(Color.PINK);
        }
        if(v.estaVacio(altatvservicio.getText())){
            cont++;
            altatvservicio.setBackground(Color.PINK);
        }
        if(v.soloDecimales(altatvservicio.getText())){
            cont++;
            altatvservicio.setBackground(Color.PINK);
        }
        return cont;
   }
    public int valCamposConsumibles(){
       int cont=0;
       if(v.soloNumeros(altatstockmin.getText())==true){
           cont++;
            //asNombre.setText("*");
            altatstockmin.setBackground(Color.PINK);
       }
        if(v.soloLetras(altatnombre.getText())==true){
            cont++;
            //asNombre.setText("*");
            altatnombre.setBackground(Color.PINK);
        }
        if(v.estaVacio(altatmarca.getText())==true){
            cont++;
            //asModelo.setText("*");
            altatmarca.setBackground(Color.PINK);
        }
        if(v.soloLetras(altatcolor.getText())==true){
            cont++;
            //asColor.setText("*");
            altatcolor.setBackground(Color.PINK);
        }
        if(v.soloNumeros(altatnofactura.getText())==true){
            cont++;
            //asNoFact.setText("*");
            altatnofactura.setBackground(Color.PINK);
        }
        if(v.soloDecimales(altatimprote.getText())==true){
            cont++;
            //asImporte.setText("*");
            altatimprote.setBackground(Color.PINK);
        }
        return cont;
   }
   public void camposDesVehiculos(){
       altatnombre.setEnabled(true);
       altatvplacas.setEnabled(false);
        altatvnomotor.setEnabled(false);
        altatvkm.setEnabled(false);
        altatvservicio.setEnabled(false);
        altatstockmin.setEnabled(false);
        altatvtipo.setEnabled(false);
        jComboBox2.setEnabled(false);
        altalNoMotor.setForeground(Color.GRAY);
        altalKm.setForeground(Color.GRAY);
        altalKmSer.setForeground(Color.GRAY);
        altalPlacas.setForeground(Color.GRAY);
   }
   public void camposHabVehiculos(){
      // jPanel4.setEnabled(true);
        altatnoserie.setEnabled(true);
        altatdescripcion.setEnabled(true);
        altatobserv.setEnabled(true);
        altatmodelo.setEnabled(true);
        altatnombre.setEnabled(false);
        altatvplacas.setEnabled(true);
        altatvnomotor.setEnabled(true);
        altatvkm.setEnabled(true);
        altatvservicio.setEnabled(true);
        altatvtipo.setEnabled(true);
        jComboBox2.setEnabled(true);
        altalNoMotor.setForeground(Color.BLACK);
        altalKm.setForeground(Color.BLACK);
        altalKmSer.setForeground(Color.BLACK);
        altalPlacas.setForeground(Color.BLACK);
   }
   public String rutaChida(String ru){
       return ru.replace("\\", "$");
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
            java.util.logging.Logger.getLogger(Alta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel altalCantidad;
    private javax.swing.JLabel altalColor;
    private javax.swing.JLabel altalDes;
    private javax.swing.JLabel altalFecha;
    private javax.swing.JLabel altalImporte;
    private javax.swing.JLabel altalKm;
    private javax.swing.JLabel altalKmSer;
    private javax.swing.JLabel altalMarca;
    private javax.swing.JLabel altalModelo;
    private javax.swing.JLabel altalNoFact;
    private javax.swing.JLabel altalNoMotor;
    private javax.swing.JLabel altalNoSerie;
    private javax.swing.JLabel altalNombre;
    private javax.swing.JLabel altalObser;
    private javax.swing.JLabel altalPlacas;
    private javax.swing.JTextField altatcolor;
    private javax.swing.JTextArea altatdescripcion;
    private com.toedter.calendar.JDateChooser altatfecha;
    private javax.swing.JFormattedTextField altatimprote;
    private javax.swing.JTextField altatmarca;
    private javax.swing.JTextField altatmodelo;
    private javax.swing.JTextField altatnofactura;
    private javax.swing.JTextField altatnombre;
    private javax.swing.JTextField altatnoserie;
    private javax.swing.JTextArea altatobserv;
    private javax.swing.JTextField altatstockmin;
    private javax.swing.JTextField altatvkm;
    private javax.swing.JTextField altatvnomotor;
    private javax.swing.JTextField altatvplacas;
    private javax.swing.JTextField altatvservicio;
    private javax.swing.JLabel altatvtipo;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblImage;
    // End of variables declaration//GEN-END:variables
}
