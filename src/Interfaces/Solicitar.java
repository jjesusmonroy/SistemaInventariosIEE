/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import Clases.Validaciones;
import Reportes.ListaVale;
import basededatos.BDD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Cherne
 */
public class Solicitar extends javax.swing.JFrame {

    /**
     * Creates new form Solicitar
     */
    public String [] nuevo2;
    Validaciones v;
    BDD b;
    Clases.MetodosG m;
    NuevaSolicitud n;
    int id_cambio,id_cambio2;
    int cont;
    String []datos;
    Object[][] data;
    int Cantidad;
    //String [][]matrix;
    int valFil;
    String stockCambio;
    public Solicitar() {
       
       // btnBorrar.setEnabled(false);
      //  valFil=5;
        //matrix=new String [valFil][5];
        nuevo2=new String[5];
        v=new Validaciones();
        m=new Clases.MetodosG();
        b= new BDD();
        id_cambio=0;
        id_cambio2=0;
      //  n= new NuevaSolicitud();
        data=new Object [0][0];
        cont =0;
        datos=new String [5];
//        btnNuevo.setVisible(false);
        initComponents();
 
      // tbl_productos1.setEnabled(false);
      //b = new BDD();
      iniciarTabla();
           tbl_productos1.setModel(new javax.swing.table.DefaultTableModel(
             data,
            new String [] {
                "Folio", "Categoria", "Nombre","Marca","Modelo","Stock"
            }
        ){
            @SuppressWarnings("rawtypes")
            Class[] columnTypes = new Class[] {
                String.class, String.class, String.class, Integer.class, Integer.class, Integer.class
            };
            @SuppressWarnings({ "unchecked", "rawtypes" })
            @Override
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
            boolean[] columnEditables = new boolean[] {
                false, false, false, false, false, false
            };
            @Override
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
   
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
        jTextField1 = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSolicitar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_productos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_productos1 = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/loupe.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/error.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSolicitar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSolicitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/hand-finger-with-a-ribbon.png"))); // NOI18N
        btnSolicitar.setText("SOLICITAR");
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });

        jScrollPane1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        tbl_productos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_productos);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("CANTIDAD:");

        txtCantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAgregar.setText(">>");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBorrar.setText("<<");
        btnBorrar.setEnabled(false);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jScrollPane2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        tbl_productos1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_productos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_productos1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_productos1);

        btnNuevo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/note.png"))); // NOI18N
        btnNuevo.setText("PETICION DE COMPRA");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
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
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSolicitar)
                        .addGap(14, 14, 14)
                        .addComponent(btnNuevo)
                        .addContainerGap(201, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(btnAgregar)
                            .addComponent(btnBorrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(btnCancelar)
                        .addComponent(btnSolicitar)
                        .addComponent(btnNuevo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrar)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 51, 204));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SOLICITUD DE PRODUCTOS");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, Short.MAX_VALUE)
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void iniciarTabla(){
        String query ="select p.folio_producto,c.nombre_categoria,p.nombre_producto,p.marca_producto,p.modelo_producto,p.stock_producto from producto p "
                + "inner join categoria c on p.id_categoria=c.id_categoria where p.status_producto='Activo'";
        String [][] busqueda = b.obtenerConsultas(query);
        tbl_productos.setModel(new javax.swing.table.DefaultTableModel(
                busqueda
                ,
            new String [] {
                "Folio", "Categoria", "Nombre","Marca","Modelo","Stock"
            }
                 ){
            @SuppressWarnings("rawtypes")
            Class[] columnTypes = new Class[] {
                String.class, String.class, String.class, Integer.class, Integer.class, String.class
            };
            @SuppressWarnings({ "unchecked", "rawtypes" })
            @Override
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
            boolean[] columnEditables = new boolean[] {
                false, false, false, false, false, false
            };
            @Override
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
      
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarActionPerformed
        String cad="";
        try{cad = tbl_productos1.getValueAt(0,0)+"";}catch(ArrayIndexOutOfBoundsException ex){
            javax.swing.JOptionPane.showMessageDialog(this, "No hay ningún elemento seleccionado");
            return;
        }
        System.out.println(tbl_productos1.getColumnCount() + " -  Row"+ tbl_productos1.getRowCount());
        String [][] arr = new String[tbl_productos1.getRowCount()][tbl_productos1.getColumnCount()];
        for(int i = 0;i<tbl_productos1.getColumnCount();i++){   
            for(int j = 0; j<tbl_productos1.getRowCount();j++){
                arr[j][i]=tbl_productos1.getValueAt(j,i)+"";
            }
        }
        
        List lista = new ArrayList();
        
        String x = javax.swing.JOptionPane.showInputDialog("Persona que solicita:");
        
        
        try{
                String value0,value2,value3,value4,value5;
                for(int i = 0;i<tbl_productos1.getRowCount();i++){
                    if(tbl_productos1.getValueAt(i, 0)==null)value0="";
                    else value0=tbl_productos1.getValueAt(i,0).toString();
                    if(tbl_productos1.getValueAt(i, 2)==null)value2="";
                    else value2=tbl_productos1.getValueAt(i,2).toString();
                    if(tbl_productos1.getValueAt(i, 3)==null)value3="";
                    else value3=tbl_productos1.getValueAt(i,3).toString();
                    if(tbl_productos1.getValueAt(i, 4)==null)value4="";
                    else value4=tbl_productos1.getValueAt(i,4).toString();
                    if(tbl_productos1.getValueAt(i, 5)==null)value5="";
                    else value5=tbl_productos1.getValueAt(i,5).toString();
                    ListaVale listaedad = new ListaVale(value0,value2,value3,value4,value5);
                    lista.add(listaedad);
                }
                try {
                JasperReport reporte = (JasperReport)  JRLoader.loadObject("src/Reportes/Vale.jasper");
                
                Map parametro = new HashMap();
                parametro.put("nombre",x+"");
                JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, new JRBeanCollectionDataSource(lista));
                JasperViewer jas = new JasperViewer(jprint,false); 
                jas.setVisible( true );
                }catch (JRException ex) {
                }
            }catch(ArrayIndexOutOfBoundsException e){
                JOptionPane.showMessageDialog(null,"No existen datos para generar reporte","ERROR",JOptionPane.WARNING_MESSAGE);
            }
       
    }//GEN-LAST:event_btnSolicitarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
         if(id_cambio==0){
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una fila");
        }else{
             if(!v.soloNumeros(txtCantidad.getText())){
                Cantidad=Integer.parseInt(txtCantidad.getText());
                String [][] busqueda = (b.obtenerConsultas("select folio_producto,nombre_producto,marca_producto,modelo_producto from producto where folio_producto="+id_cambio));
                String [] nuevo=new String[5];
                nuevo[0]=busqueda[0][0];
                nuevo[1]=busqueda[0][1];
                nuevo[2]=busqueda[0][2];
                nuevo[3]=busqueda[0][3];
                nuevo[4]=Cantidad+"";
                DefaultTableModel model =(DefaultTableModel) tbl_productos1.getModel(); 
                model.addRow(nuevo);
            }else{
                javax.swing.JOptionPane.showMessageDialog(this, "Inserte cantidad");
                txtCantidad.requestFocus(true);
            }
                txtCantidad.setText("");}
        /*if(!busIguales(id_cambio)){
            if(!v.soloNumeros(txtCantidad.getText())){
                Cantidad=Integer.parseInt(txtCantidad.getText());
                String [][] busqueda = (b.obtenerConsultas("select id_producto,nombre_producto,marca_producto,modelo_producto from producto where id_producto="+id_cambio));
                String [] nuevo=new String[5];
                nuevo[0]=busqueda[0][0];
                nuevo[1]=busqueda[0][1];
                nuevo[2]=busqueda[0][2];
                nuevo[3]=busqueda[0][3];
                nuevo[4]=Cantidad+"";
                DefaultTableModel model =(DefaultTableModel) tbl_productos1.getModel(); 
                model.addRow(nuevo);
            }else{
                javax.swing.JOptionPane.showMessageDialog(null, "Inserte cantidad");
            }
                txtCantidad.setText("");
        }else{
           DefaultTableModel model =(DefaultTableModel) tbl_productos1.getModel(); 
            model.removeRow(Integer.parseInt(id_cambio));
            if(!v.soloNumeros(txtCantidad.getText())){
                String [][] busqueda = (b.obtenerConsultas("select id_producto,nombre_producto,marca_producto,modelo_producto from producto where id_producto="+id_cambio));
                String [] nuevo=new String[5];
                nuevo[0]=busqueda[0][0];
                nuevo[1]=busqueda[0][1];
                nuevo[2]=busqueda[0][2];
                nuevo[3]=busqueda[0][3];
                nuevo[4]=Cantidad+"";
                DefaultTableModel model2 =(DefaultTableModel) tbl_productos1.getModel(); 
                model2.addRow(nuevo);
            }else{
                javax.swing.JOptionPane.showMessageDialog(null, "Inserte cantidad");
            }
                txtCantidad.setText("");
        }*/
         cambiarDeTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed
    
    private void addingRow(DefaultTableModel d){
        d.getValueAt(ERROR, cont);
    }
    
    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked

        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        //String [] opc=new String[]{"Si","No"};
        int resp=javax.swing.JOptionPane.showConfirmDialog(this, "¿Desea solicitar uno nuevo?","Producto no encontrado",0);
        if(resp==0){
            
        nuevo2[0]="null";
        nuevo2[1]=javax.swing.JOptionPane.showInputDialog(this, "Nombre del producto");
        nuevo2[2]=javax.swing.JOptionPane.showInputDialog(this, "Marca del producto ");
        nuevo2[3]=javax.swing.JOptionPane.showInputDialog(this, "Modelo del producto");
        nuevo2[4]=javax.swing.JOptionPane.showInputDialog(this, "Cantidad");
        addTable(nuevo2);
        
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        //obtInfo();
        dispose();
        NuevaSolicitud ns= new NuevaSolicitud();
        ns.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tbl_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_productosMouseClicked
        // TODO add your handling code here:
        id_cambio2=tbl_productos1.getRowCount();
        if(evt.getClickCount()==1 ){
            btnAgregar.setEnabled(true);
            int rows = tbl_productos.rowAtPoint(evt.getPoint());
            id_cambio=Integer.parseInt(tbl_productos.getValueAt(rows, 0).toString());   
            stockCambio=tbl_productos.getValueAt(rows, 4)+""; 
        }
           
            
    }//GEN-LAST:event_tbl_productosMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        if(tbl_productos1.getRowCount()==0){
             javax.swing.JOptionPane.showMessageDialog(this, "No hay más elementos que borrar");
         }else{
        if(cont==0){
            id_cambio2=tbl_productos1.getRowCount()-1;
            //javax.swing.JOptionPane.showMessageDialog(this, id_cambio2+"");
            DefaultTableModel model =(DefaultTableModel) tbl_productos1.getModel(); 
            model.removeRow(id_cambio2);
        }
        else{
         DefaultTableModel model =(DefaultTableModel) tbl_productos1.getModel(); 
             model.removeRow(id_cambio2);
            cont=0;}
         }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tbl_productos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_productos1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1 ){
            btnBorrar.setEnabled(true);
            id_cambio2= tbl_productos1.rowAtPoint(evt.getPoint());
            //= Integer.parseInt(tbl_productos1.getValueAt(rows, 0)+"");
            cont++;
             
        }
    }//GEN-LAST:event_tbl_productos1MouseClicked

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && c!='ñ' && c!='Ñ' && c!='á'
                && c!='é' && c!='í' && c!='ó' && c!='ú' && c!=' ' 
                && c!='Á' && c!='É' && c!='Í' && c!='Ú' && c!='Ó' &&(c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_jTextField1KeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
        
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            cambiarDeTabla();
        }
    }//GEN-LAST:event_txtCantidadKeyPressed
    private void cambiarDeTabla(){
        if(id_cambio==0){
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una fila");
        }else{
            if(busIguales(id_cambio)){    
                
             }else{
                    if(!v.soloNumeros(txtCantidad.getText())){
                       Cantidad=Integer.parseInt(txtCantidad.getText());
                       String [][] busqueda = (b.obtenerConsultas("select id_producto,nombre_producto,marca_producto,modelo_producto from producto where id_producto="+id_cambio));
                       String [] nuevo=new String[6];
                       nuevo[0]=busqueda[0][0];
                       nuevo[1]=busqueda[0][1];
                       nuevo[2]=busqueda[0][2];
                       nuevo[3]=busqueda[0][3];
                       nuevo[4]=Cantidad+"";
                       if(stockCambio.equals("null")){
                           nuevo[5]="No Aplica";
                       }else{
                            nuevo[5]=(Integer.parseInt(stockCambio)-Cantidad)+"";
                            stockCambio="";
                       }
                       DefaultTableModel model =(DefaultTableModel) tbl_productos1.getModel(); 
                       model.addRow(nuevo);
                   }else{
                       javax.swing.JOptionPane.showMessageDialog(this, "Inserte cantidad");
                       txtCantidad.requestFocus(true);
                   }
                txtCantidad.setText("");
              }
        }
    }
    private boolean busIguales(int id){
       // Cantidad=Integer.parseInt(txtCantidad.getText());
        for(int i=0;i<tbl_productos1.getRowCount();i++){
            if(id==Integer.parseInt(tbl_productos1.getValueAt(i,0)+"")){
            //    javax.swing.JOptionPane.showMessageDialog(this,tbl_productos1.getValueAt(i,0)+ " Buscando ");
                if(javax.swing.JOptionPane.showConfirmDialog(this, "Producto previamente seleccionado "+"\n"+"¿Desea aumentar la cantidad?")==0){
                    int cantidad=Integer.parseInt(javax.swing.JOptionPane.showInputDialog(this,"Cantidad"));
                    tbl_productos1.setValueAt(cantidad,i, 4);
                    if(!stockCambio.equals("null")){
                    tbl_productos1.setValueAt(Integer.parseInt(stockCambio)-cantidad, i, 5);}
                    txtCantidad.setText("");
                }
                return true;
            }
        }
        return false;
    }
  /*  public String[][] obtInfo(){
        
        DefaultTableModel model =(DefaultTableModel) tbl_productos1.getModel(); 
            int numFilas=model.getRowCount();
            int numColumnas=model.getColumnCount();
            
            valFil=numFilas;
            
//matrix[][]=new String[numFilas][numColumnas];
            for (int irow=0;irow<numFilas;irow++){
                for(int icol=0;icol<numColumnas;icol++){
                    n.matrix[irow][icol]=(String)model.getValueAt(irow, icol);
                }
            }
            return n.matrix;
    }*/
    
    public void addTable(String []arr){
       
                DefaultTableModel model =(DefaultTableModel) tbl_productos1.getModel(); 
                model.addRow(arr);
               //javax.swing.JOptionPane.showMessageDialog(this, n[0]+"     "+n[1]+"     "+n[2]+"     "+n[3]+"     "+n[4]);
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
            java.util.logging.Logger.getLogger(Solicitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Solicitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Solicitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Solicitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Solicitar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbl_productos;
    public javax.swing.JTable tbl_productos1;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
