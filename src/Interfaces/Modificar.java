/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.MetodosG;
import basededatos.BDD;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Cherne
 */
public final class Modificar extends javax.swing.JFrame {

    /**
     * Creates new form Baja
     */
    File fichero;
    String folio;
    BDD b;
    MetodosG m;
    int idCategoria=0;
    String idCat;
    String idProducto;
    String idVehiculo;
    public Modificar(String user){
        initComponents();
        b = new BDD();
        m = new MetodosG();
        folio=user;
        idCat="";
        idProducto="";
        idVehiculo="";
        fillIn();
        String consulta [] = b.convertir2d1d
        (b.obtenerConsultas("select nombre_categoria from categoria order by nombre_categoria"));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(consulta));
        jComboBox1.setSelectedIndex(getPosicionJCombo(consulta, idCat));
    }

    private Modificar() {
    }
    
    private int getPosicionJCombo(String [] consulta, String idCategoria){
        String id = b.getOne("select nombre_categoria from categoria where id_categoria = '"+idCategoria+"'");
        int retornar=0;
        for(int i=0; i<consulta.length;i++){
            if(consulta[i].equals(id)){
               retornar = i;
            }
        }
        return retornar;
    }
    public String rutaALaNormalidad(String ru){
       String nuevoPath="";
       String a[]=ru.split("$");
       for(int i=0;i<a.length;i++){
           nuevoPath+=a[i]+"/";
       }return nuevoPath;
   }
    public void fillIn(){
        String [][] elementos =b.obtenerConsultas("select * from producto where folio_producto = '"+folio+"'");
        idCat=elementos[0][16];
        idProducto=elementos[0][0];
        altat2.setText(elementos[0][1]);
        altat5.setText(elementos[0][3]);
        altat7.setText(elementos[0][6]);
        altat6.setText(elementos[0][4]);
        altat4.setText(elementos[0][5]);
        altat3.setText(elementos[0][2]);
        try{
                    ImageIcon icon=new ImageIcon(rutaALaNormalidad(elementos[0][7]));
                    Icon icono=new ImageIcon(icon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),Image.SCALE_DEFAULT));
                    lblImage.setText("");
                    lblImage.setIcon(icono);
            }catch(Exception e){
                  javax.swing.JOptionPane.showMessageDialog(this, "Error abriendo imagen");
            }
        java.util.Date date2=null;
        try{date2 = new SimpleDateFormat("yyyy-MM-dd").parse(elementos[0][8]);}catch(ParseException e){}
        altat9.setDate(date2);
        altat10.setText(elementos[0][9]);
        altat11.setText(elementos[0][10]);
        altat12.setText(elementos[0][11]);
        altat13.setText(elementos[0][13]);
        altat14.setText(elementos[0][12]);
        jLabel6.setText(elementos[0][15]);
        if(idCat.equals("3")){
            String consultavehiculos = "select * from vehiculo where id_producto = '"+idProducto+"' and id_categoria = '"+idCat+"'";
            String [][] hello = b.obtenerConsultas(consultavehiculos);
            idVehiculo = hello [0][0];
            altatv3.setText(hello[0][1]);
            altatv4.setText(hello[0][2]);
            altatv5.setText(hello[0][3]);
            altatv6.setText(hello[0][4]);
        } 
    }
    
    private void update(){
        int idcategoria = b.getId("select * from categoria where nombre_categoria = '"+jComboBox1.getSelectedItem().toString()+"'");
        if(!idVehiculo.equals("") && idcategoria!=3){
            b.execute("delete from vehiculo where id_vehiculo = '"+idVehiculo+"'");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = sdf.format(altat9.getDate());
        String update = "nombre_producto='"+m.jtextfield(altat2)+"', "+
                            "descripcion_producto='"+m.jtextarea(altat3)+"', "+
                    "marca_producto='"+m.jtextfield(altat5)+"', "+
                    "modelo_producto='"+m.jtextfield(altat6)+"', "+
                    "num_serie_producto='"+m.jtextfield(altat4)+"', "+
                    "color_producto='"+m.jtextfield(altat7)+"', "+
                    "fecha_compra_producto='"+fecha+"', "+
                    "no_factura_producto='"+m.jtextfield(altat10)+"', "+
                    "importe_producto='"+m.jtextfield(altat11)+"', "+
                    "observaciones_producto='"+m.jtextarea(altat12)+"', "+
                    "stock_producto='"+m.jtextfield(altat14)+"', "+
                    "min_stock_producto='"+m.jtextfield(altat13)+"', "+
                    "id_categoria='"+idcategoria+"'";
        b.execute("update producto set "+update+" where id_producto ='"+idProducto+"'");
        if(idVehiculo.equals("") && idcategoria ==3){
            int idcar= m.getMax(b.obtenerConsultas("select id_vehiculo from vehiculo"));
            String [] insertarvehiculo = new String [7];
            insertarvehiculo[0]=idcar+"";
            insertarvehiculo[5]=idProducto;
            insertarvehiculo[6]=idcategoria+"";
            insertarvehiculo[1]=m.jtextfield(altatv3);
            insertarvehiculo[2]=m.jtextfield(altatv4);
            insertarvehiculo[3]=m.jtextfield(altatv5);
            insertarvehiculo[4]=m.jtextfield(altatv6);
            b.insertar("vehiculo", insertarvehiculo);
        }
        if(!idVehiculo.equals("") && idcategoria==3){
            String updateVehiculo = "placas_vehiculo='"+altatv3.getText()+"', "+
                            "no_motor_vehiculo='"+altatv4.getText()+"', "+
                    "km_vehiculo='"+altatv5.getText()+"', "+
                    "km_serv_vehiculo='"+altatv6.getText()+"'";
        b.execute("update vehiculo set "+updateVehiculo+" where id_vehiculo ='"+idVehiculo+"'");
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
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
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
        altat13 = new javax.swing.JTextField();
        altat2 = new javax.swing.JTextField();
        altat4 = new javax.swing.JTextField();
        altat5 = new javax.swing.JTextField();
        altat6 = new javax.swing.JTextField();
        altat7 = new javax.swing.JTextField();
        altat10 = new javax.swing.JTextField();
        altat11 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        altat3 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        altat12 = new javax.swing.JTextArea();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        altat9 = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        altalPlacas = new javax.swing.JLabel();
        altatv3 = new javax.swing.JTextField();
        altalNoMotor = new javax.swing.JLabel();
        altatv4 = new javax.swing.JTextField();
        altalKm = new javax.swing.JLabel();
        altatv5 = new javax.swing.JTextField();
        altalKmSer = new javax.swing.JLabel();
        altatv6 = new javax.swing.JTextField();
        lblImage = new javax.swing.JLabel();
        altat14 = new javax.swing.JTextField();
        altalCantidad1 = new javax.swing.JLabel();
        btnCargarFoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(255, 102, 255));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modificar Productos");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sistema de Control de Inventario IEEN");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/IEE.png"))); // NOI18N

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/minus-sign.png"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/salir2.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel21)
                        .addComponent(jLabel22)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Categoria:");

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
        jLabel5.setText("Folio:");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Folio perron");

        altalNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalNombre.setText("Nombre:");

        altalDes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalDes.setText("Descripcion:");

        altalMarca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalMarca.setText("Marca:");

        altalModelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalModelo.setText("Modelo:");

        altalNoSerie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalNoSerie.setText("Numero de serie:");

        altalColor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalColor.setText("Color:");

        altalFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalFecha.setText("Fecha de compra:");

        altalNoFact.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalNoFact.setText("No. Factura:");

        altalImporte.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalImporte.setText("Importe:");

        altalObser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalObser.setText("Observaciones:");

        altalCantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalCantidad.setText("Stock minimo:");

        altat13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altat13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altat13KeyTyped(evt);
            }
        });

        altat2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altat2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altat2KeyTyped(evt);
            }
        });

        altat4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altat4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altat4KeyTyped(evt);
            }
        });

        altat5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altat5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altat5KeyTyped(evt);
            }
        });

        altat6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altat6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altat6ActionPerformed(evt);
            }
        });
        altat6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altat6KeyTyped(evt);
            }
        });

        altat7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altat7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altat7KeyTyped(evt);
            }
        });

        altat10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altat10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altat10KeyTyped(evt);
            }
        });

        altat11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altat11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altat11KeyTyped(evt);
            }
        });

        altat3.setColumns(20);
        altat3.setRows(3);
        altat3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altat3KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(altat3);

        altat12.setColumns(20);
        altat12.setRows(5);
        altat12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altat12KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(altat12);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/save.png"))); // NOI18N
        jButton9.setText("Guardar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/file.png"))); // NOI18N
        jButton10.setText("Restaurar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/error.png"))); // NOI18N
        jButton11.setText("Cancelar");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Vehiculo"));

        altalPlacas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalPlacas.setText("Placas:");

        altatv3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatv3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatv3KeyTyped(evt);
            }
        });

        altalNoMotor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalNoMotor.setText("No. Motor: ");

        altatv4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatv4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatv4KeyTyped(evt);
            }
        });

        altalKm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalKm.setText("Kilometraje:");

        altatv5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatv5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatv5KeyTyped(evt);
            }
        });

        altalKmSer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalKmSer.setText("Km Servicio:");

        altatv6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altatv6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altatv6KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(altalPlacas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(altatv3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(altalNoMotor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(altatv4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(altalKm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(altatv5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(altalKmSer)
                        .addGap(20, 20, 20)
                        .addComponent(altatv6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(altalKm)
                        .addComponent(altatv5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(altalPlacas)
                        .addComponent(altatv3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(altalKmSer)
                        .addComponent(altatv6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(altalNoMotor)
                        .addComponent(altatv4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("FOTO");
        lblImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        altat14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altat14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altat14ActionPerformed(evt);
            }
        });
        altat14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altat14KeyTyped(evt);
            }
        });

        altalCantidad1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalCantidad1.setText("Stock_producto");

        btnCargarFoto.setText("Cargar Foto");
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
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
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(altalMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(altat5, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(altalColor)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(altalNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(altat2))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(altat7, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(altalModelo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(altat6))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(altalNoSerie)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(altat4))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(altalDes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(altalImporte)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(altat11)
                                        .addGap(237, 237, 237))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(altalCantidad)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(altat13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(altalCantidad1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(altat14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                        .addComponent(altalNoFact)
                                                        .addGap(19, 19, 19)
                                                        .addComponent(altat10))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(altalFecha)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(altat9, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(24, 24, 24))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(altalObser)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jButton11)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jScrollPane2))
                                        .addContainerGap())))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCargarFoto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jButton9)
                        .addGap(42, 42, 42)
                        .addComponent(jButton10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalCantidad)
                            .addComponent(altat13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altat14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalCantidad1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(altalNombre)
                            .addComponent(altat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altat10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalNoFact))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(altalMarca)
                            .addComponent(altat5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalFecha)))
                    .addComponent(altat9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altalColor)
                    .addComponent(altat7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(altalImporte)
                    .addComponent(altat11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(altalModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(altalNoSerie)
                            .addComponent(altat4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalDes))
                        .addGap(8, 8, 8)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(altalObser, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(altat6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCargarFoto))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked

        this.setVisible(false);
        this.dispose();  
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
            // TODO add your handling code here:
            update();
            JOptionPane.showMessageDialog(this, "Se han guardado los cambios");
            this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        fillIn();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusLost

    private void altat14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altat14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_altat14ActionPerformed

    private void altat2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altat2KeyTyped
        // TODO add your handling code here:
        if(altat2.getText().length()>30){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!='ñ' && c!='Ñ' && c!='á'
                && c!='é' && c!='í' && c!='ó' && c!='ú' && c!=' ' 
                && c!='Á' && c!='É' && c!='Í' && c!='Ú' && c!='Ó') evt.consume();
    }//GEN-LAST:event_altat2KeyTyped

    private void altat5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altat5KeyTyped
        // TODO add your handling code here:
        if(altat5.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!='ñ' && c!='Ñ' && c!='á'
                && c!='é' && c!='í' && c!='ó' && c!='ú' && c!=' ' 
                && c!='Á' && c!='É' && c!='Í' && c!='Ú' && c!='Ó' &&(c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altat5KeyTyped

    private void altat7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altat7KeyTyped
        // TODO add your handling code here:
        if(altat7.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') ) evt.consume();
    }//GEN-LAST:event_altat7KeyTyped

    private void altat6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altat6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_altat6ActionPerformed

    private void altat6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altat6KeyTyped
        // TODO add your handling code here:
        if(altat6.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altat6KeyTyped

    private void altat4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altat4KeyTyped
        // TODO add your handling code here:
        if(altat4.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altat4KeyTyped

    private void altat13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altat13KeyTyped
        // TODO add your handling code here:
        if(altat13.getText().length()>15){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altat13KeyTyped

    private void altat14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altat14KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altat14KeyTyped

    private void altat10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altat10KeyTyped
        // TODO add your handling code here:
        if(altat10.getText().length()>20){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altat10KeyTyped

    private void altat11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altat11KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')&& c!='.') evt.consume();
    }//GEN-LAST:event_altat11KeyTyped

    private void altatv3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatv3KeyTyped
        // TODO add your handling code here:
         if(altatv3.getText().length()>=9){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') &&(c<'0' || c>'9') && c!='-') evt.consume();
    }//GEN-LAST:event_altatv3KeyTyped

    private void altatv4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatv4KeyTyped
        // TODO add your handling code here:
        if(altatv4.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altatv4KeyTyped

    private void altatv5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatv5KeyTyped
        // TODO add your handling code here:
        if(altatv5.getText().length()>45){
            evt.consume();
        } 
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')&& c!='.') evt.consume();
    }//GEN-LAST:event_altatv5KeyTyped

    private void altatv6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altatv6KeyTyped
        // TODO add your handling code here:
        if(altatv6.getText().length()>45){
            evt.consume();
        }
         char c = evt.getKeyChar();
        if((c<'0' || c>'9')&& c!='.') evt.consume();
    }//GEN-LAST:event_altatv6KeyTyped

    private void altat3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altat3KeyTyped
        // TODO add your handling code here:
        if(altat3.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!='ñ' && c!='Ñ' && c!='á'
                && c!='é' && c!='í' && c!='ó' && c!='ú' && c!=' ' 
                && c!='Á' && c!='É' && c!='Í' && c!='Ú' && c!='Ó' &&(c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altat3KeyTyped

    private void altat12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altat12KeyTyped
        // TODO add your handling code here:
        if(altat12.getText().length()>80){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!='ñ' && c!='Ñ' && c!='á'
                && c!='é' && c!='í' && c!='ó' && c!='ú' && c!=' ' 
                && c!='Á' && c!='É' && c!='Í' && c!='Ú' && c!='Ó' &&(c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_altat12KeyTyped

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
        // TODO add your handling code here:
        int resultado;

        CargarFoto ventana= new CargarFoto();
        FileNameExtensionFilter filtro= new FileNameExtensionFilter("JPG y PNG","jpg","png");

        ventana.jfcCargarFoto.setFileFilter(filtro);
        resultado=ventana.jfcCargarFoto.showOpenDialog(null);
        if(JFileChooser.APPROVE_OPTION==resultado){

            fichero=ventana.jfcCargarFoto.getSelectedFile();
            javax.swing.JOptionPane.showMessageDialog(this, fichero);
            try{
                ImageIcon icon=new ImageIcon(fichero.toString());
                Icon icono=new ImageIcon(icon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),Image.SCALE_DEFAULT));
                lblImage.setText("");
                lblImage.setIcon(icono);
            }catch(Exception e){
                javax.swing.JOptionPane.showMessageDialog(this, "Error abriendo imagen");
            }

        }

    }//GEN-LAST:event_btnCargarFotoActionPerformed

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
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Modificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel altalCantidad;
    private javax.swing.JLabel altalCantidad1;
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
    private javax.swing.JTextField altat10;
    private javax.swing.JTextField altat11;
    private javax.swing.JTextArea altat12;
    private javax.swing.JTextField altat13;
    private javax.swing.JTextField altat14;
    private javax.swing.JTextField altat2;
    private javax.swing.JTextArea altat3;
    private javax.swing.JTextField altat4;
    private javax.swing.JTextField altat5;
    private javax.swing.JTextField altat6;
    private javax.swing.JTextField altat7;
    private com.toedter.calendar.JDateChooser altat9;
    private javax.swing.JTextField altatv3;
    private javax.swing.JTextField altatv4;
    private javax.swing.JTextField altatv5;
    private javax.swing.JTextField altatv6;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JLabel lblImage;
    // End of variables declaration//GEN-END:variables
}
