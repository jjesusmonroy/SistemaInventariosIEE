/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.MetodosG;
import basededatos.BDD;
import java.awt.Color;
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
    boolean vehiculo,consumible;
    public Modificar(String user){
        initComponents();
        vehiculo=false;
        consumible=false;
        b = new BDD();
        m = new MetodosG();
        folio=user;
        idCat="";
        idProducto="";
        idVehiculo="";
        String consulta [] = b.convertir2d1d
        (b.obtenerConsultas("select nombre_categoria from categoria order by nombre_categoria"));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(consulta));
        fillIn();
        jcomboboxchange();
    }

    private Modificar() {
    }
    private String rutanormal(String ru){
        return ru.replace("$", "\\");
    }
    private String rutachida(String ru){
        return ru.replace("\\", "$$");
    }
    public void fillIn(){
        String query="select p.id_producto,p.folio_producto,p.nombre_producto,p.descripcion_producto,p.marca_producto,p.modelo_producto,p.num_serie_producto,p.color_producto,p.foto_producto,p.fecha_compra_producto,p.no_factura_producto,p.importe_producto,p.observaciones_producto,p.stock_producto,p.min_stock_producto,p.status_producto,p.id_categoria,c.nombre_categoria from producto p inner join categoria c on p.id_categoria=c.id_categoria where p.folio_producto = '"+folio+"'";
        String [][] elementos =b.obtenerConsultas(query);
        idCat=elementos[0][16];
        idProducto=elementos[0][0];
        nombre.setText(elementos[0][2]);
        marca.setText(elementos[0][4]);
        color.setText(elementos[0][7]);
        modelo.setText(elementos[0][5]);
        noserie.setText(elementos[0][6]);
        descripcion.setText(elementos[0][3]);
        try{
                    ImageIcon icon=new ImageIcon(rutanormal(elementos[0][8]));
                    Icon icono=new ImageIcon(icon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),Image.SCALE_DEFAULT));
                    lblImage.setText("");
                    lblImage.setIcon(icono);
            }catch(Exception e){
                  javax.swing.JOptionPane.showMessageDialog(this, "Error abriendo imagen");
            }
        java.util.Date date2=null;
        try{date2 = new SimpleDateFormat("yyyy-MM-dd").parse(elementos[0][9]);}catch(ParseException e){}
        fecha.setDate(date2);
        nofact.setText(elementos[0][10]);
        importe.setText(elementos[0][11]);
        observaciones.setText(elementos[0][12]);
        stockmin.setText(elementos[0][14]);
        stock.setText(elementos[0][13]);
        jLabel6.setText(elementos[0][1]);
        jComboBox1.setSelectedItem(elementos[0][17]);
        if("vehiculos".equals(elementos[0][17].toLowerCase())){
            String consultavehiculos = "select * from vehiculo where id_producto = '"+idProducto+"'";
            String [][] hello = b.obtenerConsultas(consultavehiculos);
            idVehiculo = hello [0][0];
            placas.setText(hello[0][1]);
            nomotor.setText(hello[0][2]);
            kilometraje.setText(hello[0][3]);
            kmservicio.setText(hello[0][4]);
            jComboBox2.setSelectedItem(hello[0][5]);
        } 
    }
    
    private void update(){
        int idcategoria = b.getId("select * from categoria where nombre_categoria = '"+jComboBox1.getSelectedItem().toString()+"'");
        if(!idVehiculo.equals("") && jComboBox1.getSelectedItem().toString().toLowerCase().equals("vehiculos")){
            b.execute("delete from vehiculo where id_vehiculo = '"+idVehiculo+"'");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String getfecha = sdf.format(fecha.getDate());
        String update = "nombre_producto='"+m.jtextfield(nombre)+"', "+
                            "descripcion_producto='"+m.jtextarea(descripcion)+"', "+
                    "marca_producto='"+m.jtextfield(marca)+"', "+
                    "modelo_producto='"+m.jtextfield(modelo)+"', "+
                    "num_serie_producto='"+m.jtextfield(noserie)+"', "+
                    "color_producto='"+m.jtextfield(color)+"', "+
                    "fecha_compra_producto='"+getfecha+"', "+
                    "no_factura_producto='"+m.jtextfield(nofact)+"', "+
                    "importe_producto='"+m.jtextfield(importe)+"', "+
                    "observaciones_producto='"+m.jtextarea(observaciones)+"', "+
                    "stock_producto='"+m.jtextfield(stock)+"', "+
                    "min_stock_producto='"+m.jtextfield(stockmin)+"', "+
                    "id_categoria='"+idcategoria+"'";
        b.execute("update producto set "+update+" where id_producto ='"+idProducto+"'");
        if(!fichero.toString().equals("")){
        b.execute("update producto set foto_producto ='"+rutachida(fichero.toString())+"' where id_producto ='"+idProducto+"'");}
        if(idVehiculo.equals("") && jComboBox1.getSelectedItem().toString().toLowerCase().equals("vehiculos")){
            int idcar= m.getMax(b.obtenerConsultas("select id_vehiculo from vehiculo"));
            String [] insertarvehiculo = new String [8];
            insertarvehiculo[0]=idcar+"";
            insertarvehiculo[1]=m.jtextfield(placas);
            insertarvehiculo[2]=m.jtextfield(nomotor);
            insertarvehiculo[3]=m.jtextfield(kilometraje);
            insertarvehiculo[4]=m.jtextfield(kmservicio);
            insertarvehiculo[5]=jComboBox2.getSelectedItem().toString();
            insertarvehiculo[6]=idcar+"";
            insertarvehiculo[7]=idProducto+"";
            b.insertar("vehiculo", insertarvehiculo);
        }
        if(!idVehiculo.equals("") && idcategoria==3){
            String updateVehiculo = "placas_vehiculo='"+placas.getText()+"', "+
                            "no_motor_vehiculo='"+nomotor.getText()+"', "+
                    "km_vehiculo='"+kilometraje.getText()+"', "+
                    "km_vehiculo='"+kilometraje.getText()+"', "+
                    "tipo_vehiculo='"+jComboBox2.getSelectedItem().toString()+"'";
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
        stockmin = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        noserie = new javax.swing.JTextField();
        marca = new javax.swing.JTextField();
        modelo = new javax.swing.JTextField();
        color = new javax.swing.JTextField();
        nofact = new javax.swing.JTextField();
        importe = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        observaciones = new javax.swing.JTextArea();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        fecha = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        altalPlacas = new javax.swing.JLabel();
        placas = new javax.swing.JTextField();
        altalNoMotor = new javax.swing.JLabel();
        nomotor = new javax.swing.JTextField();
        altalKm = new javax.swing.JLabel();
        kilometraje = new javax.swing.JTextField();
        altalKmSer = new javax.swing.JLabel();
        kmservicio = new javax.swing.JTextField();
        altalPlacas1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        lblImage = new javax.swing.JLabel();
        stock = new javax.swing.JTextField();
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

        stockmin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        stockmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockminKeyTyped(evt);
            }
        });

        nombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });

        noserie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        noserie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noserieKeyTyped(evt);
            }
        });

        marca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        marca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                marcaKeyTyped(evt);
            }
        });

        modelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeloActionPerformed(evt);
            }
        });
        modelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                modeloKeyTyped(evt);
            }
        });

        color.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        color.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                colorKeyTyped(evt);
            }
        });

        nofact.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nofact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nofactKeyTyped(evt);
            }
        });

        importe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        importe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                importeKeyTyped(evt);
            }
        });

        descripcion.setColumns(20);
        descripcion.setRows(3);
        descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(descripcion);

        observaciones.setColumns(20);
        observaciones.setRows(5);
        observaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                observacionesKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(observaciones);

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
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Vehiculo"));

        altalPlacas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalPlacas.setText("Placas:");

        placas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        placas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                placasKeyTyped(evt);
            }
        });

        altalNoMotor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalNoMotor.setText("No. Motor: ");

        nomotor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nomotor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomotorKeyTyped(evt);
            }
        });

        altalKm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalKm.setText("Kilometraje:");

        kilometraje.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        kilometraje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kilometrajeKeyTyped(evt);
            }
        });

        altalKmSer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalKmSer.setText("Km Servicio:");

        kmservicio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        kmservicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kmservicioKeyTyped(evt);
            }
        });

        altalPlacas1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        altalPlacas1.setText("Tipo:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Camioneta", "Pickup", "Auto", "Motocicleta" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(altalNoMotor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomotor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(altalPlacas)
                            .addComponent(altalPlacas1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(placas)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(altalKm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(altalKmSer)
                        .addGap(20, 20, 20)
                        .addComponent(kmservicio)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altalPlacas1)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(altalKm)
                        .addComponent(kilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(altalPlacas)
                        .addComponent(placas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(altalKmSer)
                        .addComponent(kmservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(altalNoMotor)
                        .addComponent(nomotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("FOTO");
        lblImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        stock.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockActionPerformed(evt);
            }
        });
        stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockKeyTyped(evt);
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
                                .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(altalColor)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(altalNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nombre))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(altalModelo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(modelo))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(altalNoSerie)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(noserie))
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
                                        .addComponent(importe)
                                        .addGap(237, 237, 237))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(altalCantidad)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(stockmin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(altalCantidad1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                        .addComponent(altalNoFact)
                                                        .addGap(19, 19, 19)
                                                        .addComponent(nofact))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(altalFecha)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(stockmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalCantidad1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(altalNombre)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nofact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalNoFact))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(altalMarca)
                            .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalFecha)))
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altalColor)
                    .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(altalImporte)
                    .addComponent(importe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(altalModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(altalNoSerie)
                            .addComponent(noserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altalDes))
                        .addGap(8, 8, 8)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(altalObser, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jcomboboxchange();
    }//GEN-LAST:event_jComboBox1ItemStateChanged
    
    private void jcomboboxchange(){
        String var = jComboBox1.getSelectedItem().toString().toLowerCase();
        switch (var) {
            case "consumibles":
                stockmin.setEnabled(true);
                stock.setEnabled(true);
                altalCantidad.setForeground(Color.BLACK);
                noserie.setEnabled(false);
                descripcion.setEnabled(false);
                observaciones.setEnabled(false);
                modelo.setEnabled(false);
                jComboBox2.setEnabled(false);
                placas.setEnabled(false);
                nomotor.setEnabled(false);
                kilometraje.setEnabled(false);
                kmservicio.setEnabled(false);
                break;
            case "vehiculos":
                camposHabVehiculos();
                stock.setEnabled(false);
                stockmin.setEnabled(false);
                break;
            default:
                camposDesVehiculos();
                stockmin.setEnabled(false);
                stock.setEnabled(false);
                noserie.setEnabled(true);
                descripcion.setEnabled(true);
                observaciones.setEnabled(true);
                modelo.setEnabled(true);
                altalCantidad.setForeground(Color.GRAY);
                break;
        }
    }
    private void camposDesVehiculos(){
        nombre.setEnabled(true);
       placas.setEnabled(false);
        nomotor.setEnabled(false);
        kilometraje.setEnabled(false);
        kmservicio.setEnabled(false);
        jComboBox2.setEnabled(false);
        stockmin.setEnabled(false);
        altalNoMotor.setForeground(Color.GRAY);
        altalKm.setForeground(Color.GRAY);
        altalKmSer.setForeground(Color.GRAY);
        altalPlacas.setForeground(Color.GRAY);
        altalPlacas1.setForeground(Color.GRAY);
   }
   private void camposHabVehiculos(){
      // jPanel4.setEnabled(true);
        noserie.setEnabled(true);
        descripcion.setEnabled(true);
        observaciones.setEnabled(true);
        modelo.setEnabled(true);
        nombre.setEnabled(false);
        placas.setEnabled(true);
        nomotor.setEnabled(true);
        kilometraje.setEnabled(true);
        kmservicio.setEnabled(true);
        jComboBox2.setEnabled(true);
        altalNoMotor.setForeground(Color.BLACK);
        altalPlacas1.setForeground(Color.BLACK);
        altalKm.setForeground(Color.BLACK);
        altalKmSer.setForeground(Color.BLACK);
        altalPlacas.setForeground(Color.BLACK);
   }
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

    private void stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockActionPerformed

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        // TODO add your handling code here:
        if(nombre.getText().length()>30){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!='ñ' && c!='Ñ' && c!='á'
                && c!='é' && c!='í' && c!='ó' && c!='ú' && c!=' ' 
                && c!='Á' && c!='É' && c!='Í' && c!='Ú' && c!='Ó') evt.consume();
    }//GEN-LAST:event_nombreKeyTyped

    private void marcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marcaKeyTyped
        // TODO add your handling code here:
        if(marca.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!='ñ' && c!='Ñ' && c!='á'
                && c!='é' && c!='í' && c!='ó' && c!='ú' && c!=' ' 
                && c!='Á' && c!='É' && c!='Í' && c!='Ú' && c!='Ó' &&(c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_marcaKeyTyped

    private void colorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_colorKeyTyped
        // TODO add your handling code here:
        if(color.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') ) evt.consume();
    }//GEN-LAST:event_colorKeyTyped

    private void modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modeloActionPerformed

    private void modeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modeloKeyTyped
        // TODO add your handling code here:
        if(modelo.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_modeloKeyTyped

    private void noserieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noserieKeyTyped
        // TODO add your handling code here:
        if(noserie.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_noserieKeyTyped

    private void stockminKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockminKeyTyped
        // TODO add your handling code here:
        if(stockmin.getText().length()>15){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_stockminKeyTyped

    private void stockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_stockKeyTyped

    private void nofactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nofactKeyTyped
        // TODO add your handling code here:
        if(nofact.getText().length()>20){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_nofactKeyTyped

    private void importeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importeKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')&& c!='.') evt.consume();
    }//GEN-LAST:event_importeKeyTyped

    private void placasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_placasKeyTyped
        // TODO add your handling code here:
         if(placas.getText().length()>=9){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') &&(c<'0' || c>'9') && c!='-') evt.consume();
    }//GEN-LAST:event_placasKeyTyped

    private void nomotorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomotorKeyTyped
        // TODO add your handling code here:
        if(nomotor.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_nomotorKeyTyped

    private void kilometrajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kilometrajeKeyTyped
        // TODO add your handling code here:
        if(kilometraje.getText().length()>45){
            evt.consume();
        } 
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')&& c!='.') evt.consume();
    }//GEN-LAST:event_kilometrajeKeyTyped

    private void kmservicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kmservicioKeyTyped
        // TODO add your handling code here:
        if(kmservicio.getText().length()>45){
            evt.consume();
        }
         char c = evt.getKeyChar();
        if((c<'0' || c>'9')&& c!='.') evt.consume();
    }//GEN-LAST:event_kmservicioKeyTyped

    private void descripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionKeyTyped
        // TODO add your handling code here:
        if(descripcion.getText().length()>45){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!='ñ' && c!='Ñ' && c!='á'
                && c!='é' && c!='í' && c!='ó' && c!='ú' && c!=' ' 
                && c!='Á' && c!='É' && c!='Í' && c!='Ú' && c!='Ó' &&(c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_descripcionKeyTyped

    private void observacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_observacionesKeyTyped
        // TODO add your handling code here:
        if(observaciones.getText().length()>80){
            evt.consume();
        }
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!='ñ' && c!='Ñ' && c!='á'
                && c!='é' && c!='í' && c!='ó' && c!='ú' && c!=' ' 
                && c!='Á' && c!='É' && c!='Í' && c!='Ú' && c!='Ó' &&(c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_observacionesKeyTyped

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
                Icon icono=new ImageIcon(icon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),Image.SCALE_DEFAULT));
                lblImage.setText("");
                lblImage.setIcon(icono);
            }catch(Exception e){
            }

        }

    }//GEN-LAST:event_btnCargarFotoActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

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
    private javax.swing.JLabel altalPlacas1;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JTextField color;
    private javax.swing.JTextArea descripcion;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JTextField importe;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
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
    private javax.swing.JTextField kilometraje;
    private javax.swing.JTextField kmservicio;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField modelo;
    private javax.swing.JTextField nofact;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nomotor;
    private javax.swing.JTextField noserie;
    private javax.swing.JTextArea observaciones;
    private javax.swing.JTextField placas;
    private javax.swing.JTextField stock;
    private javax.swing.JTextField stockmin;
    // End of variables declaration//GEN-END:variables
}
