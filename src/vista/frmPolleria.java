/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.salaControlador;
import data_access_object.loginDAO;
import data_access_object.pedidoDAO;
import data_access_object.productoDAO;
import data_access_object.salaDAO;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import modelo.DetallePedido;
import modelo.Eventos;
import modelo.ExportarExcel;
import modelo.Login;
import modelo.Pedido;
import modelo.Producto;
import modelo.Sala;
import modelo.Tables;

/**
 *
 * @author leonv
 */
public class frmPolleria extends javax.swing.JFrame {
    
    private salaControlador controlador;
    Sala sl = new Sala();
    
    salaDAO slDao = new salaDAO();
    
    Eventos event = new Eventos();
    
    Producto pla = new Producto();
    productoDAO plaDao = new productoDAO();
    
    Pedido ped = new Pedido();
    pedidoDAO pedDao = new pedidoDAO();
    DetallePedido detPedido = new DetallePedido();
    
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();
    
    loginDAO lgDao = new loginDAO();
    int item;
    double Totalpagar = 0.00;
    
    Date fechaActual = new Date();
    String fechaFormato = new SimpleDateFormat("yyyy-MM-dd").format(fechaActual);
    
    public frmPolleria(Login priv){
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        ImageIcon img = new ImageIcon(getClass().getResource("/images/donlolo_logo.png"));
        Image igmEscalada = img.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_SMOOTH);
        Icon icono = new ImageIcon(igmEscalada);
        labelLogo.setIcon(icono);
        this.setIconImage(img.getImage());
        this.setLocationRelativeTo(null);
        txtIdHistorialPedido.setVisible(false);
        
        
        if (priv.getRol().equals("Administrador")) {

            LabelVendedor.setText(priv.getNombre());
        } else {
            LabelVendedor.setText(priv.getNombre());
        }
        
        if (priv.getRol().equals("Mesero")) {
            btnExportar.setEnabled(false);
            btnPestañaEstadoPedido.setEnabled(false);
            btnPestañaRegistroPlatos.setEnabled(false);
            btnExportar.setEnabled(false);
            btnUsuarios4.setEnabled(false);
            btnPestañaSalas.setEnabled(false);
            LabelVendedor.setText(priv.getNombre());
        } else {
            LabelVendedor.setText(priv.getNombre());
        }
        
        /*if (priv.getRol().equals("Cocinero")) {
            jTabbedPane1.setEnabled(false);
            PanelSalas.setEnabled(false);
            btnPestañaSalas.setEnabled(false);
            btnExportar.setEnabled(false);
            btnExportar2.setEnabled(false);
            btnUsuarios4.setEnabled(false);
            btnPestañaHistorialPedidosVentas.setEnabled(false);
            btnPestañaRegistroPlatos.setEnabled(false);
            labelLogo.setEnabled(false);
            LabelVendedor.setText(priv.getNombre());
        } else {
            LabelVendedor.setText(priv.getNombre());
        }*/
        
        if (priv.getRol().equals("Cocinero")) {
            // Deshabilitar la pestaña y otras funcionalidades
            jTabbedPane1.setEnabled(false);
            jPanel1.setEnabled(false);
            PanelSalas.setEnabled(false);
            btnPestañaSalas.setEnabled(false);
            btnExportar.setEnabled(false);
            btnExportar2.setEnabled(false);
            btnUsuarios4.setEnabled(false);
            btnPestañaHistorialPedidosVentas.setEnabled(false);
            btnPestañaRegistroPlatos.setEnabled(false);
            labelLogo.setEnabled(false); // Deshabilita el componente

            LabelVendedor.setText(priv.getNombre());

            // Eliminar el listener de clic del labelLogo
            for (java.awt.event.MouseListener ml : labelLogo.getMouseListeners()) {
                labelLogo.removeMouseListener(ml);
            }

            // Mostrar directamente la pestaña de estado de pedidos (suponiendo que el índice es 6)
            LimpiarTable();
            ListarDetallesPedido();
            jTabbedPane1.setSelectedIndex(6);
            jPanel1.setEnabled(true);

        } else {
            LabelVendedor.setText(priv.getNombre());
        }
        
        
        
        txtIdHistorialPedido.setVisible(false);
        txtIdPedido.setVisible(false);
        txtIdPlato.setVisible(false);
        txtIdSala.setVisible(false);
        txtTempIdSala.setVisible(true);
        txtTempNumMesa.setVisible(true);
        jTabbedPane1.setEnabled(false);
        txtIdEmpleado.setVisible(false);
        txtIdDetalle.setVisible(false);
        txtTempIdSala.setVisible(false);
        txtTempNumMesa.setVisible(false);
        
        
    }
    
    
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelSalas = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSala = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnBuscarSala = new javax.swing.JButton();
        btnEliminarSala = new javax.swing.JButton();
        btnActualizarSala = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMesas = new javax.swing.JTextField();
        txtNombreSala = new javax.swing.JTextField();
        btnRegistrarSala = new javax.swing.JButton();
        btnCancelarSala = new javax.swing.JButton();
        txtIdSala = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBuscadorSala = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        PanelMesas = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtApellidosEmpleado = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCelularEmpleado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtDNIEmpleado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbxGeneroEmpleado = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtDireccionEmpleado = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbxRol = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        txtIdEmpleado = new javax.swing.JTextField();
        btnCancelarEmpleado = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnExportar3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtBuscadorEmpleados = new javax.swing.JTextField();
        btnBuscarEmpleado = new javax.swing.JButton();
        btnEliminarEmpleado = new javax.swing.JButton();
        btnEditarEmpleado = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableUsuarios = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnGuardarPlato = new javax.swing.JButton();
        btnCancelarPlato = new javax.swing.JButton();
        txtIdPlato = new javax.swing.JTextField();
        txtNombrePlato = new javax.swing.JTextField();
        txtPrecioPlato = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtDescripcionPlato = new javax.swing.JTextField();
        cbxTipoPlato = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        txtBuscadorPlato = new javax.swing.JTextField();
        btnBuscarPlato = new javax.swing.JButton();
        btnEditarPlato = new javax.swing.JButton();
        btnEliminarPlato = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablePlatos = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtBuscarPlato = new javax.swing.JTextField();
        btnAñadirPlato = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblTemPlatos = new javax.swing.JTable();
        Eliminar = new javax.swing.JButton();
        txtTempIdSala = new javax.swing.JTextField();
        txtTempNumMesa = new javax.swing.JTextField();
        Restar = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        btnAgregarComentario = new javax.swing.JButton();
        btnEliminarTempPlato = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        totalMenu = new javax.swing.JLabel();
        btnGenerarPedido = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextPane();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableMenu = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        btnCambiarEstadoDetalle = new javax.swing.JButton();
        txtIdDetalle = new javax.swing.JTextField();
        btnExportar2 = new javax.swing.JButton();
        txtBuscadorConfirmacionPedido = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableConfirmacionPedidos = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tableFinalizar = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtFechaHora = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtIdPedido = new javax.swing.JTextField();
        txtIdHistorialPedido = new javax.swing.JTextField();
        txtSalaFinalizar = new javax.swing.JTextField();
        txtNumMesaFinalizar = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        totalFinalizar = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TablePedidos = new javax.swing.JTable();
        btnExportar = new javax.swing.JButton();
        btnPestañaHistorialPedidosVentas = new javax.swing.JButton();
        btnPestañaEstadoPedido = new javax.swing.JButton();
        btnPestañaSalas = new javax.swing.JButton();
        LabelVendedor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPestañaRegistroPlatos = new javax.swing.JButton();
        btnUsuarios4 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        labelLogo = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 239, 215));
        setMinimumSize(new java.awt.Dimension(1520, 820));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelSalas.setPreferredSize(new java.awt.Dimension(1300, 0));
        PanelSalas.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane1.setViewportView(PanelSalas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1440, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Principal", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        tableSala.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "MESAS"
            }
        ));
        tableSala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSalaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableSala);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 253, 1395, 205));

        jLabel3.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel3.setText("Registro de Salas");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 15, -1, -1));

        btnBuscarSala.setBackground(new java.awt.Color(239, 231, 138));
        btnBuscarSala.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnBuscarSala.setText("Buscar");
        btnBuscarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSalaActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, 110, 30));

        btnEliminarSala.setBackground(new java.awt.Color(239, 231, 138));
        btnEliminarSala.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnEliminarSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulo-cruzado.png"))); // NOI18N
        btnEliminarSala.setText("Eliminar");
        btnEliminarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSalaActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 210, 116, -1));

        btnActualizarSala.setBackground(new java.awt.Color(239, 231, 138));
        btnActualizarSala.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnActualizarSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulo-de-pluma.png"))); // NOI18N
        btnActualizarSala.setText("Editar");
        btnActualizarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarSalaActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 210, 116, -1));

        jPanel11.setBackground(new java.awt.Color(255, 215, 225));
        jPanel11.setForeground(new java.awt.Color(255, 215, 225));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel4.setText("Nombre:");
        jPanel11.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 31, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel5.setText("Número de Mesas:");
        jPanel11.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 81, -1, -1));

        txtMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesasActionPerformed(evt);
            }
        });
        jPanel11.add(txtMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 73, 127, 32));

        txtNombreSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreSalaActionPerformed(evt);
            }
        });
        jPanel11.add(txtNombreSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 23, 127, 32));

        btnRegistrarSala.setBackground(new java.awt.Color(239, 231, 138));
        btnRegistrarSala.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnRegistrarSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar (1).png"))); // NOI18N
        btnRegistrarSala.setText("Registrar");
        btnRegistrarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarSalaActionPerformed(evt);
            }
        });
        jPanel11.add(btnRegistrarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 48, 115, -1));

        btnCancelarSala.setBackground(new java.awt.Color(239, 231, 138));
        btnCancelarSala.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnCancelarSala.setText("Cancelar");
        btnCancelarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarSalaActionPerformed(evt);
            }
        });
        jPanel11.add(btnCancelarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 90, 110, 27));
        jPanel11.add(txtIdSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 47, -1, 30));

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 72, 1395, 124));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda (1).png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 208, -1, 32));

        txtBuscadorSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorSalaActionPerformed(evt);
            }
        });
        jPanel2.add(txtBuscadorSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 670, 31));

        jTabbedPane1.addTab("Salas", jPanel2);

        PanelMesas.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane3.setViewportView(PanelMesas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1440, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        jTabbedPane1.addTab("Mesas", jPanel3);

        jPanel12.setBackground(new java.awt.Color(255, 215, 225));
        jPanel12.setForeground(new java.awt.Color(255, 215, 225));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel7.setText("Nombre:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel8.setText("Correo:");

        txtApellidosEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosEmpleadoActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnIniciar.setBackground(new java.awt.Color(239, 231, 138));
        btnIniciar.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar (1).png"))); // NOI18N
        btnIniciar.setText("Registrar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel10.setText("Apellido:");

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel11.setText("Celular:");

        txtCelularEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularEmpleadoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel12.setText("DNI:");

        txtDNIEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIEmpleadoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel13.setText("Género:");

        cbxGeneroEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel14.setText("Dirección:");

        txtDireccionEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionEmpleadoActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel15.setText("Rol:");

        cbxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Mesero", "Cocinero" }));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel16.setText("Contraseña:");

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        btnCancelarEmpleado.setBackground(new java.awt.Color(239, 231, 138));
        btnCancelarEmpleado.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnCancelarEmpleado.setText("Cancelar");
        btnCancelarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(txtApellidosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)))
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxGeneroEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDNIEmpleado)
                            .addComponent(txtCelularEmpleado)
                            .addComponent(txtDireccionEmpleado)
                            .addComponent(txtPass)
                            .addComponent(cbxRol, 0, 185, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnCancelarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtApellidosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCelularEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNIEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(10, 10, 10)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbxGeneroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtDireccionEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar)
                    .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jLabel9.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel9.setText("Registro de Usuarios");

        btnExportar3.setBackground(new java.awt.Color(239, 231, 138));
        btnExportar3.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnExportar3.setText("Exportar");
        btnExportar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportar3ActionPerformed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda (1).png"))); // NOI18N

        txtBuscadorEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorEmpleadosActionPerformed(evt);
            }
        });

        btnBuscarEmpleado.setBackground(new java.awt.Color(239, 231, 138));
        btnBuscarEmpleado.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnBuscarEmpleado.setText("Buscar");
        btnBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoActionPerformed(evt);
            }
        });

        btnEliminarEmpleado.setBackground(new java.awt.Color(239, 231, 138));
        btnEliminarEmpleado.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnEliminarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulo-cruzado.png"))); // NOI18N
        btnEliminarEmpleado.setText("Eliminar");
        btnEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEmpleadoActionPerformed(evt);
            }
        });

        btnEditarEmpleado.setBackground(new java.awt.Color(239, 231, 138));
        btnEditarEmpleado.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnEditarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulo-de-pluma.png"))); // NOI18N
        btnEditarEmpleado.setText("Editar");
        btnEditarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEmpleadoActionPerformed(evt);
            }
        });

        TableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellidos", "Correo", "Contraseña", "Rol", "Dirección", "Celular", "DNI", "Género"
            }
        ));
        TableUsuarios.setMinimumSize(new java.awt.Dimension(200, 80));
        TableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TableUsuarios);
        if (TableUsuarios.getColumnModel().getColumnCount() > 0) {
            TableUsuarios.getColumnModel().getColumn(0).setMinWidth(40);
            TableUsuarios.getColumnModel().getColumn(0).setMaxWidth(40);
            TableUsuarios.getColumnModel().getColumn(1).setMinWidth(85);
            TableUsuarios.getColumnModel().getColumn(1).setMaxWidth(85);
            TableUsuarios.getColumnModel().getColumn(9).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExportar3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscadorEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(btnEditarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExportar3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBuscadorEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminarEmpleado)
                                .addComponent(btnEditarEmpleado))
                            .addGap(1, 1, 1)))
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Usuarios", jPanel4);

        jLabel18.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel18.setText("Registro de Platos");

        jPanel13.setBackground(new java.awt.Color(255, 215, 225));
        jPanel13.setForeground(new java.awt.Color(255, 215, 225));
        jPanel13.setPreferredSize(new java.awt.Dimension(1395, 117));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel19.setText("Nombre:");
        jPanel13.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 19, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel20.setText("Descripción:");
        jPanel13.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 17, -1, 20));

        btnGuardarPlato.setBackground(new java.awt.Color(239, 231, 138));
        btnGuardarPlato.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnGuardarPlato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar (1).png"))); // NOI18N
        btnGuardarPlato.setText("Guardar");
        btnGuardarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPlatoActionPerformed(evt);
            }
        });
        jPanel13.add(btnGuardarPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, 110, 42));

        btnCancelarPlato.setBackground(new java.awt.Color(239, 231, 138));
        btnCancelarPlato.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnCancelarPlato.setText("Cancelar");
        btnCancelarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPlatoActionPerformed(evt);
            }
        });
        jPanel13.add(btnCancelarPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 90, 110, 27));
        jPanel13.add(txtIdPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, -1, 30));

        txtNombrePlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombrePlatoActionPerformed(evt);
            }
        });
        jPanel13.add(txtNombrePlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 17, 201, 20));

        txtPrecioPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioPlatoActionPerformed(evt);
            }
        });
        jPanel13.add(txtPrecioPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 49, 79, 20));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel21.setText("Precio:");
        jPanel13.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 51, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel22.setText("Categoría:");
        jPanel13.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 84, -1, -1));

        txtDescripcionPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionPlatoActionPerformed(evt);
            }
        });
        jPanel13.add(txtDescripcionPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 45, 225, 63));

        cbxTipoPlato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Brasa", "Especial", "Guarnición" }));
        jPanel13.add(cbxTipoPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 81, 124, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda (1).png"))); // NOI18N

        txtBuscadorPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorPlatoActionPerformed(evt);
            }
        });

        btnBuscarPlato.setBackground(new java.awt.Color(239, 231, 138));
        btnBuscarPlato.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnBuscarPlato.setText("Buscar");
        btnBuscarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPlatoActionPerformed(evt);
            }
        });

        btnEditarPlato.setBackground(new java.awt.Color(239, 231, 138));
        btnEditarPlato.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnEditarPlato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulo-de-pluma.png"))); // NOI18N
        btnEditarPlato.setText("Editar");
        btnEditarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPlatoActionPerformed(evt);
            }
        });

        btnEliminarPlato.setBackground(new java.awt.Color(239, 231, 138));
        btnEliminarPlato.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnEliminarPlato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulo-cruzado.png"))); // NOI18N
        btnEliminarPlato.setText("Eliminar");
        btnEliminarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPlatoActionPerformed(evt);
            }
        });

        TablePlatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Categoria", "Precio", "Descripción"
            }
        ));
        TablePlatos.setPreferredSize(new java.awt.Dimension(300, 50));
        TablePlatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePlatosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TablePlatos);
        if (TablePlatos.getColumnModel().getColumnCount() > 0) {
            TablePlatos.getColumnModel().getColumn(0).setMinWidth(50);
            TablePlatos.getColumnModel().getColumn(0).setMaxWidth(50);
            TablePlatos.getColumnModel().getColumn(2).setMinWidth(200);
            TablePlatos.getColumnModel().getColumn(2).setPreferredWidth(200);
            TablePlatos.getColumnModel().getColumn(2).setMaxWidth(300);
            TablePlatos.getColumnModel().getColumn(3).setMinWidth(200);
            TablePlatos.getColumnModel().getColumn(3).setPreferredWidth(200);
            TablePlatos.getColumnModel().getColumn(3).setMaxWidth(300);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 1395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscadorPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(255, 255, 255)
                        .addComponent(btnEditarPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnEliminarPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscadorPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnEditarPlato)
                    .addComponent(btnEliminarPlato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Platos", jPanel5);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel26.setText("Registro de Pedidos");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 18, -1, -1));

        jPanel14.setBackground(new java.awt.Color(255, 215, 225));
        jPanel14.setForeground(new java.awt.Color(255, 215, 225));
        jPanel14.setPreferredSize(new java.awt.Dimension(1395, 117));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda (1).png"))); // NOI18N

        txtBuscarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarPlatoActionPerformed(evt);
            }
        });

        btnAñadirPlato.setBackground(new java.awt.Color(239, 231, 138));
        btnAñadirPlato.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnAñadirPlato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar (1).png"))); // NOI18N
        btnAñadirPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirPlatoActionPerformed(evt);
            }
        });

        tblTemPlatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "Nombre", "Categoria", "Precio"
            }
        ));
        jScrollPane7.setViewportView(tblTemPlatos);
        if (tblTemPlatos.getColumnModel().getColumnCount() > 0) {
            tblTemPlatos.getColumnModel().getColumn(0).setMinWidth(20);
            tblTemPlatos.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblTemPlatos.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarPlato)
                        .addGap(18, 18, 18)
                        .addComponent(btnAñadirPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAñadirPlato)
                    .addComponent(txtBuscarPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 83, 561, 386));

        Eliminar.setBackground(new java.awt.Color(239, 231, 138));
        Eliminar.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulo-cruzado.png"))); // NOI18N
        Eliminar.setText("Eliminar Pedido");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPanel6.add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 260, -1, 27));

        txtTempIdSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTempIdSalaActionPerformed(evt);
            }
        });
        jPanel6.add(txtTempIdSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 35, -1, 30));

        txtTempNumMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTempNumMesaActionPerformed(evt);
            }
        });
        jPanel6.add(txtTempNumMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 35, -1, 30));

        Restar.setBackground(new java.awt.Color(239, 231, 138));
        Restar.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        Restar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circulo-negativo.png"))); // NOI18N
        Restar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestarActionPerformed(evt);
            }
        });
        jPanel6.add(Restar, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 258, 40, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel27.setText("Comentario:");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 295, -1, -1));

        btnAgregarComentario.setBackground(new java.awt.Color(239, 231, 138));
        btnAgregarComentario.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnAgregarComentario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar (1).png"))); // NOI18N
        btnAgregarComentario.setText("Agregar");
        btnAgregarComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarComentarioActionPerformed(evt);
            }
        });
        jPanel6.add(btnAgregarComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 424, 116, -1));

        btnEliminarTempPlato.setBackground(new java.awt.Color(239, 231, 138));
        btnEliminarTempPlato.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnEliminarTempPlato.setText("Cancelar");
        btnEliminarTempPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTempPlatoActionPerformed(evt);
            }
        });
        jPanel6.add(btnEliminarTempPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(882, 426, 110, 27));

        jLabel31.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel31.setText("Total a pagar:");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 340, -1, -1));

        totalMenu.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        totalMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalMenu.setText("00.00");
        jPanel6.add(totalMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 340, -1, -1));

        btnGenerarPedido.setBackground(new java.awt.Color(239, 231, 138));
        btnGenerarPedido.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        btnGenerarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insignia-dolar (1).png"))); // NOI18N
        btnGenerarPedido.setText("  Realizar");
        btnGenerarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPedidoActionPerformed(evt);
            }
        });
        jPanel6.add(btnGenerarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 380, 181, 43));

        jScrollPane10.setViewportView(txtComentario);

        jPanel6.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 318, 387, 100));

        tableMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Plato", "Tipo", "Cantidad", "Precio", "SubTotal", "Comentario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMenu.setRowHeight(23);
        tableMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMenuMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tableMenu);

        jPanel6.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 810, 170));

        jTabbedPane1.addTab("Registro Pedido", jPanel6);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel29.setText("Estado de Pedidos");
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 16, -1, -1));

        jPanel15.setBackground(new java.awt.Color(255, 215, 225));
        jPanel15.setForeground(new java.awt.Color(255, 215, 225));
        jPanel15.setPreferredSize(new java.awt.Dimension(1395, 84));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel30.setText("Cambiar estado:");
        jPanel15.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        btnCambiarEstadoDetalle.setBackground(new java.awt.Color(239, 231, 138));
        btnCambiarEstadoDetalle.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        btnCambiarEstadoDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar (1).png"))); // NOI18N
        btnCambiarEstadoDetalle.setText("Marcar pedido como realizado");
        btnCambiarEstadoDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarEstadoDetalleActionPerformed(evt);
            }
        });
        jPanel15.add(btnCambiarEstadoDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 260, -1));

        txtIdDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdDetalleActionPerformed(evt);
            }
        });
        jPanel15.add(txtIdDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 130, 30));

        jPanel7.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 73, -1, 100));

        btnExportar2.setBackground(new java.awt.Color(239, 231, 138));
        btnExportar2.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnExportar2.setText("Exportar");
        btnExportar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportar2ActionPerformed(evt);
            }
        });
        jPanel7.add(btnExportar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1298, 188, 110, 27));

        txtBuscadorConfirmacionPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorConfirmacionPedidoActionPerformed(evt);
            }
        });
        jPanel7.add(txtBuscadorConfirmacionPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 185, 670, 31));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda (1).png"))); // NOI18N
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 185, -1, 32));

        tableConfirmacionPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Plato", "Tipo", "Cantidad", "Precio", "Comentario", "ID Pedido", "Estado"
            }
        ));
        tableConfirmacionPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableConfirmacionPedidosMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableConfirmacionPedidos);

        jPanel7.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 1390, 230));

        jTabbedPane1.addTab("Estado de Pedido", jPanel7);

        jLabel25.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel25.setText("Finalizar Pedido");

        tableFinalizar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Plato", "Categoría", "Cantidad", "Precio", "SubTotal", "Comentario", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableFinalizar.setRowHeight(23);
        jScrollPane13.setViewportView(tableFinalizar);

        jPanel16.setBackground(new java.awt.Color(255, 215, 225));
        jPanel16.setForeground(new java.awt.Color(255, 215, 225));

        jLabel32.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel32.setText("Fecha y Hora:");

        jLabel33.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel33.setText("N° Mesa:");

        txtFechaHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaHoraActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel34.setText("Sala:");

        txtIdPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPedidoActionPerformed(evt);
            }
        });

        txtSalaFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaFinalizarActionPerformed(evt);
            }
        });

        txtNumMesaFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumMesaFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(txtIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdHistorialPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumMesaFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSalaFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalaFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumMesaFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(27, 27, 27)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdHistorialPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jLabel35.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel35.setText("Total a pagar:");

        totalFinalizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        totalFinalizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalFinalizar.setText("00.00");

        btnFinalizar.setBackground(new java.awt.Color(239, 231, 138));
        btnFinalizar.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        btnFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insignia-dolar (1).png"))); // NOI18N
        btnFinalizar.setText("  Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 917, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addGap(18, 18, 18)
                                        .addComponent(totalFinalizar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(121, 121, 121))))
                    .addComponent(jLabel25))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(totalFinalizar))
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Finalizar Pedido", jPanel8);

        jLabel36.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel36.setText("Historial de Pedidos");

        TablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Sala", "Atendido", "N° Mesa", "Fecha", "Total", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablePedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TablePedidos.setRowHeight(23);
        TablePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePedidosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TablePedidosMouseEntered(evt);
            }
        });
        jScrollPane9.setViewportView(TablePedidos);
        if (TablePedidos.getColumnModel().getColumnCount() > 0) {
            TablePedidos.getColumnModel().getColumn(0).setMinWidth(50);
            TablePedidos.getColumnModel().getColumn(0).setPreferredWidth(50);
            TablePedidos.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btnExportar.setBackground(new java.awt.Color(239, 231, 138));
        btnExportar.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(989, 989, 989)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1394, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Historial Pedidos", jPanel9);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 196, 1440, 510));

        btnPestañaHistorialPedidosVentas.setBackground(new java.awt.Color(182, 239, 255));
        btnPestañaHistorialPedidosVentas.setFont(new java.awt.Font("Britannic Bold", 0, 16)); // NOI18N
        btnPestañaHistorialPedidosVentas.setText("Historial de Pedidos");
        btnPestañaHistorialPedidosVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPestañaHistorialPedidosVentasActionPerformed(evt);
            }
        });
        getContentPane().add(btnPestañaHistorialPedidosVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 730, 216, 50));

        btnPestañaEstadoPedido.setBackground(new java.awt.Color(182, 239, 255));
        btnPestañaEstadoPedido.setFont(new java.awt.Font("Britannic Bold", 0, 16)); // NOI18N
        btnPestañaEstadoPedido.setText("Seguimiento de Pedidos");
        btnPestañaEstadoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPestañaEstadoPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPestañaEstadoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 730, 216, 50));

        btnPestañaSalas.setBackground(new java.awt.Color(182, 239, 255));
        btnPestañaSalas.setFont(new java.awt.Font("Britannic Bold", 0, 16)); // NOI18N
        btnPestañaSalas.setText("Gestión de Salas");
        btnPestañaSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPestañaSalasActionPerformed(evt);
            }
        });
        getContentPane().add(btnPestañaSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 730, 216, 50));

        LabelVendedor.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        LabelVendedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelVendedor.setText("SISTEMA DE PEDIDOS");
        getContentPane().add(LabelVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 180, 190, -1));

        jLabel2.setFont(new java.awt.Font("Impact", 0, 62)); // NOI18N
        jLabel2.setText("BRASA & BROASTER \"DON LOLO\" ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 790, 60));

        btnPestañaRegistroPlatos.setBackground(new java.awt.Color(182, 239, 255));
        btnPestañaRegistroPlatos.setFont(new java.awt.Font("Britannic Bold", 0, 16)); // NOI18N
        btnPestañaRegistroPlatos.setText("Registro de Platos");
        btnPestañaRegistroPlatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPestañaRegistroPlatosActionPerformed(evt);
            }
        });
        getContentPane().add(btnPestañaRegistroPlatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 730, 216, 50));

        btnUsuarios4.setBackground(new java.awt.Color(239, 231, 138));
        btnUsuarios4.setFont(new java.awt.Font("Britannic Bold", 0, 16)); // NOI18N
        btnUsuarios4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png"))); // NOI18N
        btnUsuarios4.setText(" Usuarios");
        btnUsuarios4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarios4ActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuarios4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 15, 150, 50));

        btnSalir.setBackground(new java.awt.Color(239, 231, 138));
        btnSalir.setFont(new java.awt.Font("Britannic Bold", 0, 16)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        btnSalir.setText(" Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1366, 15, 150, 50));

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/donlolo_logo.png"))); // NOI18N
        labelLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLogoMouseClicked(evt);
            }
        });
        getContentPane().add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        jPanel10.setBackground(new java.awt.Color(245, 239, 215));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1540, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
        ExportarExcel obj;

        try{
            obj = new ExportarExcel();
            obj.exportarExcel(TablePedidos);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void TablePedidosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePedidosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePedidosMouseEntered

    private void TablePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePedidosMouseClicked
        // TODO add your handling code here:
        int fila = TablePedidos.rowAtPoint(evt.getPoint());
        int id_pedido = Integer.parseInt(TablePedidos.getValueAt(fila, 0).toString());
        LimpiarTable();
        verPedido(id_pedido);
        verPedidoDetalle(id_pedido);
        jTabbedPane1.setSelectedIndex(7);
        btnFinalizar.setEnabled(false);
        txtIdHistorialPedido.setText("" + id_pedido);
    }//GEN-LAST:event_TablePedidosMouseClicked

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
        // Obtiene el ID del pedido desde el campo de texto
        int idPedido = Integer.parseInt(txtIdPedido.getText().trim());

        // Crea una instancia de tu DAO para poder llamar a los métodos
        //PedidoDAO pedDao = new PedidoDAO();
        // Verifica si todos los detalles del pedido están en "REALIZADO"
        if (pedDao.verificarDetallesRealizados(idPedido)) {
            // Si todos los detalles están realizados, pregunta si se desea finalizar
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de finalizar el pedido?");
            if (pregunta == 0) {
                // Si la respuesta es afirmativa, actualiza el estado del pedido
                if (pedDao.actualizarEstado(idPedido)) {
                    // Si el estado se actualizó correctamente, genera el PDF

                    JOptionPane.showMessageDialog(null, "Pedido finalizado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al finalizar el pedido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            // Si no todos los detalles están en "REALIZADO", muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "No se puede finalizar el pedido. Todos los detalles deben estar en estado 'REALIZADO'", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void txtNumMesaFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumMesaFinalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumMesaFinalizarActionPerformed

    private void txtSalaFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaFinalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaFinalizarActionPerformed

    private void txtIdPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPedidoActionPerformed

    private void txtFechaHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaHoraActionPerformed

    private void txtBuscadorConfirmacionPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorConfirmacionPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorConfirmacionPedidoActionPerformed

    private void btnExportar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportar2ActionPerformed
        // TODO add your handling code here:
        ExportarExcel obj;

        try{
            obj = new ExportarExcel();
            obj.exportarExcel(tableConfirmacionPedidos);
        } catch (IOException ex){
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_btnExportar2ActionPerformed

    private void txtIdDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdDetalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdDetalleActionPerformed

    private void btnCambiarEstadoDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarEstadoDetalleActionPerformed
        // TODO add your handling code here:
        // Verifica si se seleccionó una fila
        int filaSeleccionada = tableConfirmacionPedidos.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un registro de la tabla.");
            return;
        }

        // Obtén el ID del detalle desde la columna correspondiente
        int idDetalle = Integer.parseInt(tableConfirmacionPedidos.getValueAt(filaSeleccionada, 0).toString());

        // Cambiar el estado del detalle
        boolean resultado = pedDao.cambiarEstadoDetalle(idDetalle, "REALIZADO");
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Estado cambiado a 'REALIZADO'");
            actualizarTablaDetalles(); // Método opcional para refrescar la tabla

        } else {
            JOptionPane.showMessageDialog(null, "Error al cambiar el estado");
        }
    }//GEN-LAST:event_btnCambiarEstadoDetalleActionPerformed

    private void TablePlatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePlatosMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        int fila = TablePlatos.rowAtPoint(evt.getPoint());

        // Establece los valores de los otros campos de texto
        txtIdPlato.setText(TablePlatos.getValueAt(fila, 0).toString());
        txtNombrePlato.setText(TablePlatos.getValueAt(fila, 1).toString());

        // Establece el valor seleccionado del ComboBox
        String tipoPlato = TablePlatos.getValueAt(fila, 2).toString(); // Obtén el valor de la columna del tipo de plato
        cbxTipoPlato.setSelectedItem(tipoPlato); // Establece el valor en el ComboBox

        txtPrecioPlato.setText(TablePlatos.getValueAt(fila, 3).toString());
        txtDescripcionPlato.setText(TablePlatos.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_TablePlatosMouseClicked

    private void btnEliminarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPlatoActionPerformed
        // TODO add your handling code here:
        // Verificar si el ID está vacío
        if (!"".equals(txtIdPlato.getText())) {
            // Confirmar si el usuario desea eliminar el registro
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este plato?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (pregunta == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(txtIdPlato.getText()); // Convertir el ID a entero
                    productoDAO productoDAO = new productoDAO();
                    if (productoDAO.eliminar(id)) {
                        JOptionPane.showMessageDialog(null, "Plato eliminado correctamente");
                        LimpiarPlatos(); // Método para limpiar los campos del formulario
                        LimpiarTable(); // Método para limpiar la tabla
                        ListarPlatos(TablePlatos); // Método para actualizar la tabla con los datos actuales
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el plato");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El ID debe ser un número válido");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_btnEliminarPlatoActionPerformed

    private void btnEditarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPlatoActionPerformed
        // TODO add your handling code here:
        // Verificar si el ID está vacío
        if ("".equals(txtIdPlato.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para editar");
        } else {
            // Validar que los campos obligatorios no estén vacíos
            if (!"".equals(txtNombrePlato.getText()) && !"".equals(txtPrecioPlato.getText()) && !"".equals(txtDescripcionPlato.getText())) {

                // Mostrar ventana de confirmación
                int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Está seguro de que desea editar este plato?",
                    "Confirmación de Edición",
                    JOptionPane.YES_NO_OPTION);

                // Si el usuario selecciona 'Sí'
                if (respuesta == JOptionPane.YES_OPTION) {
                    try {
                        Producto producto = new Producto();
                        producto.setId_producto(Integer.parseInt(txtIdPlato.getText()));
                        producto.setNom_producto(txtNombrePlato.getText());
                        producto.setPrecio(Double.parseDouble(txtPrecioPlato.getText()));
                        producto.setDescripcion(txtDescripcionPlato.getText());
                        producto.setTipoPlato(cbxTipoPlato.getSelectedItem().toString());

                        productoDAO productoDAO = new productoDAO();
                        if (productoDAO.modificar(producto)) {
                            JOptionPane.showMessageDialog(null, "Plato modificado correctamente");
                            LimpiarTable();
                            ListarPlatos(TablePlatos); // Método para actualizar la tabla
                            LimpiarPlatos(); // Método para limpiar los campos del formulario
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al modificar el plato");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "El precio debe ser un número válido");
                    }
                } else {
                    // Si el usuario selecciona 'No', no se hace nada
                    JOptionPane.showMessageDialog(null, "Edición cancelada");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
            }
        }
    }//GEN-LAST:event_btnEditarPlatoActionPerformed

    private void btnBuscarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPlatoActionPerformed
        // TODO add your handling code here:
        // Obtener el texto del campo de búsqueda
        String busqueda = txtBuscadorPlato.getText().trim();

        // Verificar si el campo está vacío
        if (busqueda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del plato que desea buscar");
            return;
        }

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) TablePlatos.getModel();
        // Limpiar la tabla antes de mostrar resultados
        modelo.setRowCount(0);

        // Consultar la base de datos para buscar los platos
        productoDAO productoDAO = new productoDAO(); // Crear una instancia de ProductoDAO
        List<Producto> platos = productoDAO.listar(busqueda); // Buscar platos con el nombre que contiene la búsqueda
        boolean encontrado = false;

        // Recorrer la lista de platos para agregar aquellos que coinciden con la búsqueda
        for (Producto plato : platos) {
            modelo.addRow(new Object[]{
                plato.getId_producto(),
                plato.getNom_producto(),
                plato.getTipoPlato(),
                plato.getPrecio(),
                plato.getDescripcion()
            });
            encontrado = true;
        }

        // Mostrar mensaje si no se encontraron resultados
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontraron platos que coincidan con la búsqueda");
        }
    }//GEN-LAST:event_btnBuscarPlatoActionPerformed

    private void txtBuscadorPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorPlatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorPlatoActionPerformed

    private void txtDescripcionPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionPlatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionPlatoActionPerformed

    private void txtPrecioPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioPlatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioPlatoActionPerformed

    private void txtNombrePlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePlatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePlatoActionPerformed

    private void btnCancelarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPlatoActionPerformed
        // TODO add your handling code here:
        LimpiarPlatos();
    }//GEN-LAST:event_btnCancelarPlatoActionPerformed

    private void btnGuardarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPlatoActionPerformed
        // TODO add your handling code here:
        // Validar que los campos no estén vacíos
        if (!"".equals(txtNombrePlato.getText()) && !"".equals(txtPrecioPlato.getText()) && !"".equals(txtDescripcionPlato.getText())) {
            try {
                Producto producto = new Producto();
                producto.setNom_producto(txtNombrePlato.getText());
                producto.setPrecio(Double.parseDouble(txtPrecioPlato.getText()));
                producto.setDescripcion(txtDescripcionPlato.getText());
                producto.setTipoPlato(cbxTipoPlato.getSelectedItem().toString());

                productoDAO productoDAO = new productoDAO();
                if (productoDAO.registrar(producto)) {
                    JOptionPane.showMessageDialog(null, "Plato registrado correctamente");
                    LimpiarTable();
                    ListarPlatos(TablePlatos); // Método para actualizar la tabla de platos
                    LimpiarPlatos(); // Método para limpiar los campos del formulario
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar el plato");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El precio debe ser un número válido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
        }
    }//GEN-LAST:event_btnGuardarPlatoActionPerformed

    private void TableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableUsuariosMouseClicked
        // TODO add your handling code here:
        // Obtener la fila seleccionada en la tabla
        int fila = TableUsuarios.rowAtPoint(evt.getPoint());

        // Establecer los valores en los campos de texto correspondientes
        txtIdEmpleado.setText(TableUsuarios.getValueAt(fila, 0).toString());
        txtNombre.setText(TableUsuarios.getValueAt(fila, 1).toString());
        txtApellidosEmpleado.setText(TableUsuarios.getValueAt(fila, 2).toString());
        txtCorreo.setText(TableUsuarios.getValueAt(fila, 3).toString());
        txtCelularEmpleado.setText(TableUsuarios.getValueAt(fila, 6).toString());
        txtDNIEmpleado.setText(TableUsuarios.getValueAt(fila, 7).toString());
        txtDireccionEmpleado.setText(TableUsuarios.getValueAt(fila, 9).toString());

        // Establecer el valor seleccionado en el ComboBox de género
        String genero = TableUsuarios.getValueAt(fila, 8).toString();
        cbxGeneroEmpleado.setSelectedItem(genero);

        // Establecer el valor en el campo de contraseña (opcional, depende de los requisitos de seguridad)
        txtPass.setText(TableUsuarios.getValueAt(fila, 4).toString());

        // Establecer el valor seleccionado en el ComboBox de rol
        String rol = TableUsuarios.getValueAt(fila, 5).toString();
        cbxRol.setSelectedItem(rol);
    }//GEN-LAST:event_TableUsuariosMouseClicked

    private void btnEditarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEmpleadoActionPerformed
        // TODO add your handling code here:
        // Verificar si el campo de ID está vacío
        if ("".equals(txtIdEmpleado.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para editar");
        } else {
            // Validar que los campos obligatorios no estén vacíos
            if (!"".equals(txtNombre.getText()) && !"".equals(txtApellidosEmpleado.getText())
                && !"".equals(txtCorreo.getText()) && !"".equals(txtCelularEmpleado.getText())
                && !"".equals(txtDNIEmpleado.getText()) && !"".equals(txtDireccionEmpleado.getText())) {

                // Mostrar ventana de confirmación
                int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Está seguro de que desea editar este registro?",
                    "Confirmación de Edición",
                    JOptionPane.YES_NO_OPTION);

                // Si el usuario selecciona 'Sí'
                if (respuesta == JOptionPane.YES_OPTION) {
                    try {
                        // Crear una nueva instancia de login (usuario)
                        Login usuario = new Login();
                        usuario.setId(Integer.parseInt(txtIdEmpleado.getText()));  // Establecer el ID del usuario
                        usuario.setNombre(txtNombre.getText());
                        usuario.setApellido(txtApellidosEmpleado.getText());
                        usuario.setCorreo(txtCorreo.getText());
                        usuario.setPass(txtPass.getText());  // Se asume que el campo de contraseña es opcional
                        usuario.setRol(cbxRol.getSelectedItem().toString());
                        usuario.setCelular(Integer.parseInt(txtCelularEmpleado.getText()));
                        usuario.setDni(Integer.parseInt(txtDNIEmpleado.getText()));
                        usuario.setGenero(cbxGeneroEmpleado.getSelectedItem().toString());
                        usuario.setDireccion(txtDireccionEmpleado.getText());

                        // Instanciar el DAO para editar el usuario
                        loginDAO loginDAO = new loginDAO();
                        if (loginDAO.EditarUsuario(usuario)) {
                            JOptionPane.showMessageDialog(null, "Empleado editado correctamente");
                            LimpiarTable();  // Método para limpiar la tabla y actualizarla
                            ListarUsuarios(TableUsuarios);  // Método para actualizar la tabla con la lista de usuarios
                            LimpiarUsuario();  // Método para limpiar los campos del formulario
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al editar el empleado");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Verifique que los campos numéricos sean correctos");
                    }
                } else {
                    // Si el usuario selecciona 'No', no se hace nada
                    JOptionPane.showMessageDialog(null, "Edición cancelada");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
            }
        }
    }//GEN-LAST:event_btnEditarEmpleadoActionPerformed

    private void btnEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoActionPerformed
        // TODO add your handling code here:
        // Verificar si el ID está vacío
        if (!"".equals(txtIdEmpleado.getText())) {  // Asegúrate de que txtIdEmpleado sea el campo donde se ingresa el ID del usuario
            // Confirmar si el usuario desea eliminar el registro
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este empleado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (pregunta == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(txtIdEmpleado.getText()); // Convertir el ID a entero
                    loginDAO loginDao = new loginDAO(); // Usar el DAO para eliminar el usuario
                    if (loginDao.EliminarUsuario(id)) {
                        JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
                        LimpiarUsuario(); // Método para limpiar los campos del formulario
                        LimpiarTable(); // Método para limpiar la tabla
                        ListarUsuarios(TableUsuarios); // Método para actualizar la tabla con los datos actuales
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El ID debe ser un número válido");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }

    }//GEN-LAST:event_btnEliminarEmpleadoActionPerformed

    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
        // TODO add your handling code here:
        String busqueda = txtBuscadorEmpleados.getText().trim(); // Obtener texto del campo de búsqueda

        // Verificar si el campo está vacío
        if (busqueda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor para buscar"); // Mostrar mensaje si está vacío
            return;
        }

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) TableUsuarios.getModel();
        // Limpiar la tabla antes de mostrar resultados
        modelo.setRowCount(0);

        // Consultar la base de datos para buscar usuarios
        loginDAO loginDAO = new loginDAO(); // Crear una instancia de LoginDAO
        List<Login> usuarios = loginDAO.listar(busqueda); // Buscar usuarios con el valor de búsqueda
        boolean encontrado = false;

        // Recorrer la lista de usuarios para agregar aquellos que coinciden con la búsqueda
        for (Login usuario : usuarios) {
            modelo.addRow(new Object[]{
                usuario.getId(), // ID del usuario
                usuario.getNombre(), // Nombre del usuario
                usuario.getApellido(), // Apellido del usuario
                usuario.getCorreo(), // Correo del usuario
                usuario.getPass(), //Pass del usuario
                usuario.getRol(), // Rol del usuario
                usuario.getCelular(), // Celular del usuario
                usuario.getDni(), // DNI del usuario
                usuario.getGenero(), // Género del usuario
                usuario.getDireccion() // Dirección del usuario
            });
            encontrado = true; // Indicar que se encontró al menos un usuario
        }

        // Mostrar mensaje si no se encontraron resultados
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontraron usuarios que coincidan con la búsqueda");
        }
    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    private void txtBuscadorEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorEmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorEmpleadosActionPerformed

    private void btnExportar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportar3ActionPerformed
        // TODO add your handling code here:
        ExportarExcel obj;

        try {
            obj = new ExportarExcel();
            obj.exportarExcel(TableUsuarios);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_btnExportar3ActionPerformed

    private void btnCancelarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEmpleadoActionPerformed
        // TODO add your handling code here:
        LimpiarUsuario();
    }//GEN-LAST:event_btnCancelarEmpleadoActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void txtDireccionEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionEmpleadoActionPerformed

    private void txtDNIEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIEmpleadoActionPerformed

    private void txtCelularEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularEmpleadoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        // Validar que los campos obligatorios no estén vacíos
        if (txtNombre.getText().equals("") || txtApellidosEmpleado.getText().equals("")
            || txtCorreo.getText().equals("") || txtCelularEmpleado.getText().equals("")
            || txtDNIEmpleado.getText().equals("") || txtDireccionEmpleado.getText().equals("")
            || txtPass.getPassword().length == 0) {

            JOptionPane.showMessageDialog(null, "Todos los campos son requeridos");
        } else {
            // Crear una instancia del modelo `login`
            Login lg = new Login();

            // Asignar los valores de los TextField y ComboBox a los atributos del objeto
            lg.setNombre(txtNombre.getText());
            lg.setApellido(txtApellidosEmpleado.getText());
            lg.setCorreo(txtCorreo.getText());
            lg.setCelular(Integer.parseInt(txtCelularEmpleado.getText()));
            lg.setDni(Integer.parseInt(txtDNIEmpleado.getText()));
            lg.setGenero(cbxGeneroEmpleado.getSelectedItem().toString());
            lg.setDireccion(txtDireccionEmpleado.getText());
            lg.setPass(String.valueOf(txtPass.getPassword()));
            lg.setRol(cbxRol.getSelectedItem().toString());

            // Llamar al método `Registrar` de la clase DAO
            boolean registrado = lgDao.Registrar(lg);

            // Validar si el registro fue exitoso
            if (registrado) {
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
                LimpiarUsuario();
                LimpiarTable();
                ListarUsuarios();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar usuario");
            }
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidosEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosEmpleadoActionPerformed

    private void txtBuscadorSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorSalaActionPerformed
        // TODO add your handling code here:
        // Obtener el texto del campo de búsqueda
        String busqueda = txtBuscadorSala.getText().trim();

        // Verificar si el campo está vacío
        if (busqueda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la sala que desea buscar");
            return;
        }

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tableSala.getModel();
        // Limpiar la tabla antes de mostrar resultados
        modelo.setRowCount(0);

        // Consultar la base de datos para buscar las salas
        List<Sala> salas = slDao.listarSalas(); // Recuperar todas las salas
        boolean encontrado = false;

        for (Sala sala : salas) {
            if (sala.getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                // Agregar la sala encontrada a la tabla
                modelo.addRow(new Object[]{
                    sala.getId_sala(),
                    sala.getNombre(),
                    sala.getMesa()
                });
                encontrado = true;
            }
        }

        // Mostrar mensaje si no se encontraron resultados
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontraron salas que coincidan con la búsqueda");
        }
    }//GEN-LAST:event_txtBuscadorSalaActionPerformed

    private void btnCancelarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarSalaActionPerformed
        // TODO add your handling code here:
        LimpiarSala();
    }//GEN-LAST:event_btnCancelarSalaActionPerformed

    private void btnRegistrarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarSalaActionPerformed
        // TODO add your handling code here:
        if (txtNombreSala.getText().equals("") || txtMesas.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Los campos esta vacios");
        } else {
            sl.setNombre(txtNombreSala.getText());
            sl.setMesa(Integer.parseInt(txtMesas.getText()));
            slDao.registrarSala(sl);
            JOptionPane.showMessageDialog(null, "Sala Registrado");
            LimpiarSala();
            LimpiarTable();
            ListarSalas();
        }
    }//GEN-LAST:event_btnRegistrarSalaActionPerformed

    private void txtNombreSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreSalaActionPerformed

    private void txtMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesasActionPerformed

    private void btnActualizarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarSalaActionPerformed
        // TODO add your handling code here:
        // Validar si se seleccionó una fila
        if ("".equals(txtIdSala.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            // Validar si el nombre de la sala no está vacío
            if (!"".equals(txtNombreSala.getText()) && !"".equals(txtMesas.getText())) {
                // Mostrar ventana de confirmación
                int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Está seguro de que desea actualizar esta sala?",
                    "Confirmación de Actualización",
                    JOptionPane.YES_NO_OPTION);

                // Si el usuario selecciona 'Sí'
                if (respuesta == JOptionPane.YES_OPTION) {
                    try {
                        // Asignar valores al objeto Sala
                        sl.setId_sala(Integer.parseInt(txtIdSala.getText()));
                        sl.setNombre(txtNombreSala.getText());
                        sl.setMesa(Integer.parseInt(txtMesas.getText())); // Asegúrate de convertir el texto a un entero

                        // Llamar al DAO para actualizar la sala
                        if (slDao.modificarSala(sl)) {
                            JOptionPane.showMessageDialog(null, "Sala modificada correctamente");
                            LimpiarSala();
                            LimpiarTable();
                            ListarSalas();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al modificar la sala");
                        }
                    } catch (NumberFormatException e) {
                        // Capturar posibles errores de conversión de texto a entero
                        JOptionPane.showMessageDialog(null, "El campo 'Mesas' debe ser un número válido");
                    }
                } else {
                    // Si el usuario selecciona 'No', no se hace nada
                    JOptionPane.showMessageDialog(null, "Actualización cancelada");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Complete todos los campos");
            }
        }
    }//GEN-LAST:event_btnActualizarSalaActionPerformed

    private void btnEliminarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSalaActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtIdSala.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdSala.getText());
                slDao.eliminarSala(id);
                LimpiarSala();
                LimpiarTable();
                ListarSalas();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }//GEN-LAST:event_btnEliminarSalaActionPerformed

    private void btnBuscarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSalaActionPerformed
        // TODO add your handling code here:
        String busqueda = txtBuscadorSala.getText().trim();

        // Verificar si el campo está vacío
        if (busqueda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la sala que desea buscar");
            return;
        }

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tableSala.getModel();
        // Limpiar la tabla antes de mostrar resultados
        modelo.setRowCount(0);

        // Consultar la base de datos para buscar las salas
        List<Sala> salas = slDao.listarSalas(); // Recuperar todas las salas
        boolean encontrado = false;

        for (Sala sala : salas) {
            if (sala.getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                // Agregar la sala encontrada a la tabla
                modelo.addRow(new Object[]{
                    sala.getId_sala(),
                    sala.getNombre(),
                    sala.getMesa()
                });
                encontrado = true;
            }
        }

        // Mostrar mensaje si no se encontraron resultados
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontraron salas que coincidan con la búsqueda");
        }
    }//GEN-LAST:event_btnBuscarSalaActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void tableSalaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSalaMouseClicked
        // TODO add your handling code here:
        int fila = tableSala.rowAtPoint(evt.getPoint());
        txtIdSala.setText(tableSala.getValueAt(fila, 0).toString());
        txtNombreSala.setText(tableSala.getValueAt(fila, 1).toString());
        txtMesas.setText(tableSala.getValueAt(fila, 2).toString());
    }//GEN-LAST:event_tableSalaMouseClicked

    private void btnPestañaHistorialPedidosVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPestañaHistorialPedidosVentasActionPerformed
        // TODO add your handling code here:
        LimpiarTable();
        ListarPedidos();
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_btnPestañaHistorialPedidosVentasActionPerformed

    private void btnPestañaEstadoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPestañaEstadoPedidoActionPerformed
        // TODO add your handling code here:
        LimpiarTable();
        ListarDetallesPedido();
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_btnPestañaEstadoPedidoActionPerformed

    private void btnPestañaSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPestañaSalasActionPerformed
        LimpiarTable();
        ListarSalas();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnPestañaSalasActionPerformed

    private void btnPestañaRegistroPlatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPestañaRegistroPlatosActionPerformed
        LimpiarTable();
        ListarPlatos(TablePlatos);
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_btnPestañaRegistroPlatosActionPerformed

    private void btnUsuarios4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarios4ActionPerformed
        // TODO add your handling code here:
        LimpiarTable();
        ListarUsuarios();
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnUsuarios4ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);

        // Si el usuario selecciona "Sí" (JOptionPane.YES_OPTION), salir del programa
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void labelLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLogoMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
        PanelSalas.removeAll();
        panelSalas();
    }//GEN-LAST:event_labelLogoMouseClicked

    private void tableMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMenuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMenuMouseClicked

    private void btnGenerarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPedidoActionPerformed
        // TODO add your handling code here:
        if (tableMenu.getRowCount() > 0) {
            RegistrarPedido();
            detallePedido();
            LimpiarTableMenu();
            JOptionPane.showMessageDialog(null, "PEDIDO REGISTRADO");
            jTabbedPane1.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "NO HAY PRODUCTO EN LA PEDIDO");
        }
    }//GEN-LAST:event_btnGenerarPedidoActionPerformed

    private void btnEliminarTempPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTempPlatoActionPerformed
        // TODO add your handling code here:
        txtComentario.setText("");
    }//GEN-LAST:event_btnEliminarTempPlatoActionPerformed

    private void btnAgregarComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarComentarioActionPerformed
        // TODO add your handling code here:
        // Verificar que se haya ingresado un comentario
        if (txtComentario.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un comentario.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si no se ingresa un comentario
        }

        // Verificar si se ha seleccionado una fila en la tabla
        int selectedRow = tableMenu.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si no hay fila seleccionada
        }

        try {
            // Obtener el ID de la fila seleccionada
            int id = Integer.parseInt(tableMenu.getValueAt(selectedRow, 0).toString());

            // Recorrer la tabla para buscar la fila con el ID correspondiente
            for (int i = 0; i < tableMenu.getRowCount(); i++) {
                if (Integer.parseInt(tableMenu.getValueAt(i, 0).toString()) == id) {
                    // Actualizar el comentario en la columna correspondiente
                    tableMenu.setValueAt(txtComentario.getText().trim(), i, 6);

                    // Limpiar el campo de texto y la selección de la tabla
                    txtComentario.setText("");
                    tableMenu.clearSelection();

                    // Mostrar mensaje de confirmación
                    JOptionPane.showMessageDialog(null, "Comentario agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    return; // Salir del método después de actualizar
                }
            }

            // Mostrar mensaje si no se encuentra el ID en la tabla
            JOptionPane.showMessageDialog(null, "El ID seleccionado no coincide con ninguna fila.", "Error", JOptionPane.ERROR_MESSAGE);

        } catch (NumberFormatException e) {
            // Manejar errores al convertir valores a enteros
            JOptionPane.showMessageDialog(null, "Error al procesar el ID de la fila seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Manejar cualquier otro error inesperado
            JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarComentarioActionPerformed

    private void RestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestarActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableMenu.getSelectedRow();

        if (selectedRow >= 0) {  // Si se ha seleccionado una fila
            int id = Integer.parseInt(tableMenu.getValueAt(selectedRow, 0).toString());
            double precio = Double.parseDouble(tableMenu.getValueAt(selectedRow, 4).toString()); // Precio unitario
            int cantidadActual = Integer.parseInt(tableMenu.getValueAt(selectedRow, 3).toString()); // Cantidad actual

            // Si la cantidad es mayor a 1, reducir la cantidad en 1
            if (cantidadActual > 1) {
                int nuevaCantidad = cantidadActual - 1; // Nueva cantidad después de restar 1
                double nuevoSubtotal = nuevaCantidad * precio; // Nuevo subtotal

                // Actualiza la cantidad y el subtotal en la tabla
                tableMenu.setValueAt(nuevaCantidad, selectedRow, 3); // Actualiza cantidad (columna 3)
                tableMenu.setValueAt(nuevoSubtotal, selectedRow, 5);  // Actualiza subtotal (columna 5)

                // Actualiza el total a pagar después de modificar
                TotalPagar(tableMenu, totalMenu);
            } else {
                // Si la cantidad es 1, no puedes reducirla más
                JOptionPane.showMessageDialog(null, "La cantidad no puede ser menor a 1.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            // Si no se ha seleccionado ninguna fila, mostrar un mensaje
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un registro para restar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_RestarActionPerformed

    private void txtTempNumMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTempNumMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTempNumMesaActionPerformed

    private void txtTempIdSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTempIdSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTempIdSalaActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
        // Obtiene el modelo de la tabla
        modelo = (DefaultTableModel) tableMenu.getModel();

        // Verifica si se ha seleccionado alguna fila
        int selectedRow = tableMenu.getSelectedRow();

        if (selectedRow != -1) { // Si se ha seleccionado una fila
            // Obtiene la cantidad actual del plato seleccionado
            int cantidad = Integer.parseInt(tableMenu.getValueAt(selectedRow, 3).toString());

            // Muestra un cuadro de diálogo preguntando si desea eliminar la fila seleccionada
            int opcion = JOptionPane.showConfirmDialog(null,
                "¿Deseas eliminar esta cantidad de este plato? (Cantidad: " + cantidad + ")",
                "Eliminar Plato",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            if (opcion == JOptionPane.YES_OPTION) {
                // Si selecciona "Sí", elimina la fila seleccionada
                modelo.removeRow(selectedRow);
                // Actualiza el total después de la eliminación
                TotalPagar(tableMenu, totalMenu);
            }
            // Si selecciona "No", no se hace nada y la fila no se elimina
        } else {
            // Si no se ha seleccionado ninguna fila, muestra un mensaje de advertencia
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un registro para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void btnAñadirPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirPlatoActionPerformed
        // TODO add your handling code here:
        // Verificar si se ha seleccionado una fila en la tabla de platos
        if (tblTemPlatos.getSelectedRow() >= 0) {
            int id = Integer.parseInt(tblTemPlatos.getValueAt(tblTemPlatos.getSelectedRow(), 0).toString());
            String nom_producto = tblTemPlatos.getValueAt(tblTemPlatos.getSelectedRow(), 1).toString();
            String tipoPlato = tblTemPlatos.getValueAt(tblTemPlatos.getSelectedRow(), 2).toString();
            //double precio = Double.parseDouble(tblTemPlatos.getValueAt(tblTemPlatos.getSelectedRow(), 3).toString());
            double precio = Double.parseDouble(tblTemPlatos.getValueAt(tblTemPlatos.getSelectedRow(), 3).toString());
            int cantidadInicial = 1; // Cantidad inicial
            double subtotal = cantidadInicial * precio;

            item = item + 1; // Incrementa el contador de ítems

            tmp = (DefaultTableModel) tableMenu.getModel();

            // Comprobar si el plato ya existe
            for (int i = 0; i < tableMenu.getRowCount(); i++) {
                if (tableMenu.getValueAt(i, 0).equals(id)) {
                    int cantActual = Integer.parseInt(tableMenu.getValueAt(i, 3).toString());
                    int nuevoCantidad = cantActual + 1;
                    double nuevoSub = precio * nuevoCantidad;
                    tmp.setValueAt(nuevoCantidad, i, 3); // Actualiza cantidad
                    tmp.setValueAt(nuevoSub, i, 5);     // Actualiza subtotal (columna 5)
                    TotalPagar(tableMenu, totalMenu);   // Actualiza el total
                    return;
                }
            }

            // Si no existe, añadir el plato
            Object[] fila = {
                id, // ID del plato
                nom_producto, // Nombre del plato
                tipoPlato, // Tipo de plato
                cantidadInicial, // Cantidad inicial
                precio, // Precio unitario
                subtotal // Subtotal (columna 5)
            };

            tmp.addRow(fila); // Añade la fila
            tableMenu.setModel(tmp); // Refresca el modelo de la tabla

            TotalPagar(tableMenu, totalMenu); // Calcula el total después de añadir
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONA UNA FILA");
        }
    }//GEN-LAST:event_btnAñadirPlatoActionPerformed

    private void txtBuscarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPlatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPlatoActionPerformed

    private void tableConfirmacionPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableConfirmacionPedidosMouseClicked
        // TODO add your handling code here:
        int fila = tableConfirmacionPedidos.rowAtPoint(evt.getPoint());
        int id_detalle = Integer.parseInt(tableConfirmacionPedidos.getValueAt(fila, 0).toString());

        jTabbedPane1.setSelectedIndex(6);
        txtIdDetalle.setText("" + id_detalle);
    }//GEN-LAST:event_tableConfirmacionPedidosMouseClicked


    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JLabel LabelVendedor;
    private javax.swing.JPanel PanelMesas;
    private javax.swing.JPanel PanelSalas;
    private javax.swing.JButton Restar;
    private javax.swing.JTable TablePedidos;
    private javax.swing.JTable TablePlatos;
    private javax.swing.JTable TableUsuarios;
    private javax.swing.JButton btnActualizarSala;
    private javax.swing.JButton btnAgregarComentario;
    private javax.swing.JButton btnAñadirPlato;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnBuscarPlato;
    private javax.swing.JButton btnBuscarSala;
    private javax.swing.JButton btnCambiarEstadoDetalle;
    private javax.swing.JButton btnCancelarEmpleado;
    private javax.swing.JButton btnCancelarPlato;
    private javax.swing.JButton btnCancelarSala;
    private javax.swing.JButton btnEditarEmpleado;
    private javax.swing.JButton btnEditarPlato;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnEliminarPlato;
    private javax.swing.JButton btnEliminarSala;
    private javax.swing.JButton btnEliminarTempPlato;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnExportar2;
    private javax.swing.JButton btnExportar3;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnGenerarPedido;
    private javax.swing.JButton btnGuardarPlato;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnPestañaEstadoPedido;
    private javax.swing.JButton btnPestañaHistorialPedidosVentas;
    private javax.swing.JButton btnPestañaRegistroPlatos;
    private javax.swing.JButton btnPestañaSalas;
    private javax.swing.JButton btnRegistrarSala;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnUsuarios4;
    private javax.swing.JComboBox<String> cbxGeneroEmpleado;
    private javax.swing.JComboBox<String> cbxRol;
    private javax.swing.JComboBox<String> cbxTipoPlato;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JTable tableConfirmacionPedidos;
    private javax.swing.JTable tableFinalizar;
    private javax.swing.JTable tableMenu;
    private javax.swing.JTable tableSala;
    private javax.swing.JTable tblTemPlatos;
    private javax.swing.JLabel totalFinalizar;
    private javax.swing.JLabel totalMenu;
    private javax.swing.JTextField txtApellidosEmpleado;
    private javax.swing.JTextField txtBuscadorConfirmacionPedido;
    private javax.swing.JTextField txtBuscadorEmpleados;
    private javax.swing.JTextField txtBuscadorPlato;
    private javax.swing.JTextField txtBuscadorSala;
    private javax.swing.JTextField txtBuscarPlato;
    private javax.swing.JTextField txtCelularEmpleado;
    private javax.swing.JTextPane txtComentario;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNIEmpleado;
    private javax.swing.JTextField txtDescripcionPlato;
    private javax.swing.JTextField txtDireccionEmpleado;
    private javax.swing.JTextField txtFechaHora;
    private javax.swing.JTextField txtIdDetalle;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtIdHistorialPedido;
    private javax.swing.JTextField txtIdPedido;
    private javax.swing.JTextField txtIdPlato;
    private javax.swing.JTextField txtIdSala;
    private javax.swing.JTextField txtMesas;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombrePlato;
    private javax.swing.JTextField txtNombreSala;
    private javax.swing.JTextField txtNumMesaFinalizar;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPrecioPlato;
    private javax.swing.JTextField txtSalaFinalizar;
    private javax.swing.JTextField txtTempIdSala;
    private javax.swing.JTextField txtTempNumMesa;
    // End of variables declaration//GEN-END:variables

    //Metodo creado por el controlador, ejemplo del ing
    public void setControlador(salaControlador controlador) {
        this.controlador = controlador;
    }
    
    private void ListarUsuarios() {
        List<Login> Listar = lgDao.ListarUsuarios();
        modelo = (DefaultTableModel) TableUsuarios.getModel();
        Object[] ob = new Object[10];
        for (int i = 0; i < Listar.size(); i++) {
            ob[0] = Listar.get(i).getId();
            ob[1] = Listar.get(i).getNombre();
            ob[2] = Listar.get(i).getApellido();
            ob[3] = Listar.get(i).getCorreo();
            ob[4] = Listar.get(i).getPass();
            ob[5] = Listar.get(i).getRol();
            ob[6] = Listar.get(i).getCelular();
            ob[7] = Listar.get(i).getDni();
            ob[8] = Listar.get(i).getGenero();
            ob[9] = Listar.get(i).getDireccion();

            modelo.addRow(ob);
        }
        colorHeader(TableUsuarios);
    }

    private void ListarUsuarios(JTable tabla) {
        // Listar los usuarios utilizando el DAO correspondiente
        List<Login> listaUsuarios = lgDao.ListarUsuarios(); // Obtiene la lista de usuarios desde el DAO
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel(); // Obtiene el modelo de la tabla
        modelo.setRowCount(0); // Limpia la tabla antes de agregar los nuevos datos

        // Definir el arreglo de objetos para agregar cada fila
        Object[] ob = new Object[10]; // Ajusta el tamaño según la cantidad de columnas en tu tabla

        // Recorre la lista de usuarios y agrega cada uno a la tabla
        for (Login usuario : listaUsuarios) {
            ob[0] = usuario.getId(); // ID del usuario
            ob[1] = usuario.getNombre(); // Nombre del usuario
            ob[2] = usuario.getApellido(); // Apellido del usuario
            ob[3] = usuario.getCorreo(); // Correo del usuario
            ob[4] = usuario.getPass(); // Contraseña del usuario (puedes omitirla si no la necesitas mostrar)
            ob[5] = usuario.getRol(); // Rol del usuario
            ob[6] = usuario.getCelular(); // Celular del usuario
            ob[7] = usuario.getDni(); // DNI del usuario
            ob[8] = usuario.getGenero(); // Género del usuario
            ob[9] = usuario.getDireccion(); // Dirección del usuario

            modelo.addRow(ob); // Agrega la fila a la tabla
        }
        colorHeader(tabla); // Método para cambiar el color del encabezado de la tabla (si es necesario)
    }

    private void LimpiarTableMenu() {
        tmp = (DefaultTableModel) tableMenu.getModel();
        int fila = tableMenu.getRowCount();
        for (int i = 0; i < fila; i++) {
            tmp.removeRow(0);
        }
    }

    private void editarSala() {
        int filaSeleccionada = tableSala.getSelectedRow(); // Obtén la fila seleccionada
        if (filaSeleccionada >= 0) {
            // Actualiza los valores de la fila con los datos de los campos de texto
            tableSala.setValueAt(txtIdSala.getText(), filaSeleccionada, 0); // Columna ID
            tableSala.setValueAt(txtNombreSala.getText(), filaSeleccionada, 1); // Columna Nombre
            tableSala.setValueAt(txtMesas.getText(), filaSeleccionada, 2); // Columna Mesas

            // Mensaje de confirmación
            JOptionPane.showMessageDialog(this, "Sala editada correctamente.");
        } else {
            // Mensaje de error si no se seleccionó ninguna fila
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una sala para editar.");
        }
    }

    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    private void ListarSalas() {
        List<Sala> Listar = slDao.listarSalas();
        modelo = (DefaultTableModel) tableSala.getModel();
        Object[] ob = new Object[3];
        for (int i = 0; i < Listar.size(); i++) {
            ob[0] = Listar.get(i).getId_sala();
            ob[1] = Listar.get(i).getNombre();
            ob[2] = Listar.get(i).getMesa();
            modelo.addRow(ob);
        }
        colorHeader(tableSala);

    }

    private void colorHeader(JTable tabla) {
        tabla.setModel(modelo);
        JTableHeader header = tabla.getTableHeader();
        header.setOpaque(false);
        header.setBackground(new Color(0, 110, 255));
        header.setForeground(Color.white);
    }

    private void LimpiarSala() {
        txtIdSala.setText("");
        txtNombreSala.setText("");
        txtMesas.setText("");
    }

    private void LimpiarPlatos() {
        txtIdPlato.setText("");
        txtNombrePlato.setText("");
        txtPrecioPlato.setText("");
        txtDescripcionPlato.setText("");
    }

    private void LimpiarUsuario() {
        txtNombre.setText("");
        txtApellidosEmpleado.setText("");
        txtCorreo.setText("");
        txtCelularEmpleado.setText("");
        txtDNIEmpleado.setText("");
        txtDireccionEmpleado.setText("");
        txtPass.setText("");
    }

    private void panelSalas() {
        List<Sala> Listar = slDao.listarSalas();
        for (int i = 0; i < Listar.size(); i++) {
            int id = Listar.get(i).getId_sala();
            int cantidad = Listar.get(i).getMesa();
            JButton boton = new JButton(Listar.get(i).getNombre(), new ImageIcon(getClass().getResource("/images/sala.png")));
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            boton.setHorizontalTextPosition(JButton.CENTER);
            boton.setVerticalTextPosition(JButton.BOTTOM);
            boton.setBackground(new Color(204, 204, 204));
            PanelSalas.add(boton);
            boton.addActionListener((ActionEvent e) -> {
                LimpiarTable();
                PanelMesas.removeAll();
                panelMesas(id, cantidad);
                jTabbedPane1.setSelectedIndex(2);
            });
        }
    }

    //crear mesas
    private void panelMesas(int id_sala, int cant) {
        for (int i = 1; i <= cant; i++) {
            int num_mesa = i;
            //verificar estado
            JButton boton = new JButton("MESA N°: " + i, new ImageIcon(getClass().getResource("/images/mesa.png")));
            boton.setHorizontalTextPosition(JButton.CENTER);
            boton.setVerticalTextPosition(JButton.BOTTOM);
            int verificar = pedDao.verificarEstadoPedido(num_mesa, id_sala);
            if (verificar > 0) {
                boton.setBackground(new Color(255, 51, 51));
            } else {
                boton.setBackground(new Color(0, 102, 102));
            }
            boton.setForeground(Color.WHITE);
            boton.setFocusable(false);
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            PanelMesas.add(boton);
            boton.addActionListener((ActionEvent e) -> {
                if (verificar > 0) {
                    LimpiarTable();
                    verPedido(verificar);
                    verPedidoDetalle(verificar);
                    btnFinalizar.setEnabled(true);

                    jTabbedPane1.setSelectedIndex(7);
                } else {
                    LimpiarTable();
                    ListarPlatos(tblTemPlatos);
                    jTabbedPane1.setSelectedIndex(5);
                    txtTempIdSala.setText("" + id_sala);
                    txtTempNumMesa.setText("" + num_mesa);
                }
            });
        }
    }

    // productos
    private void TotalPagar(JTable tabla, JLabel label) {
        Totalpagar = 0.00; // Reinicia el total a 0
        int numFila = tabla.getRowCount(); // Obtiene el número de filas en la tabla

        // Recorre cada fila de la tabla
        for (int i = 0; i < numFila; i++) {
            // Accede al subtotal (columna correcta)
            double subtotal = Double.parseDouble(tabla.getValueAt(i, 5).toString());
            Totalpagar += subtotal; // Suma el subtotal al total general
        }

        // Muestra el total en el JLabel formateado con 2 decimales
        label.setText(String.format("%.2f", Totalpagar));
    }

    public void verPedido(int id_pedido) {
        ped = pedDao.obtenerPedido(id_pedido);
        totalFinalizar.setText("" + ped.getTotal());
        txtFechaHora.setText("" + ped.getFecha());
        txtSalaFinalizar.setText("" + ped.getId_sala());
        txtNumMesaFinalizar.setText("" + ped.getNum_mesa());
        txtIdPedido.setText("" + ped.getId());
        ped.getId_sala();
        ped.getNum_mesa();
    }

    //registrar pedido
    private void RegistrarPedido() {
        int id_sala = Integer.parseInt(txtTempIdSala.getText());
        int num_mesa = Integer.parseInt(txtTempNumMesa.getText());
        double monto = Totalpagar;
        ped.setId_sala(id_sala);
        ped.setNum_mesa(num_mesa);
        ped.setTotal(monto);
        ped.setUsuario(LabelVendedor.getText());
        pedDao.registrarPedido(ped);
    }

    public void verPedidoDetalle(int id_pedido) {
        List<DetallePedido> Listar = pedDao.obtenerDetallesPedido(id_pedido);
        modelo = (DefaultTableModel) tableFinalizar.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < Listar.size(); i++) {
            ob[0] = Listar.get(i).getId_detallepedido();
            ob[1] = Listar.get(i).getNombre();
            ob[2] = Listar.get(i).getTipoPlato();
            ob[3] = Listar.get(i).getCantidad();
            ob[4] = Listar.get(i).getPrecio();
            ob[5] = Listar.get(i).getCantidad() * Listar.get(i).getPrecio();
            ob[6] = Listar.get(i).getComentario();
            ob[7] = Listar.get(i).getEstado();
            modelo.addRow(ob);
        }
        colorHeader(tableFinalizar);
    }

    private void detallePedido() {
        int id = pedDao.obtenerUltimoIdPedido();
        for (int i = 0; i < tableMenu.getRowCount(); i++) {
            String nombre = tableMenu.getValueAt(i, 1).toString();
            String tipoPlato = tableMenu.getValueAt(i, 2).toString();
            int cant = Integer.parseInt(tableMenu.getValueAt(i, 3).toString());
            double precio = Double.parseDouble(tableMenu.getValueAt(i, 4).toString());

            // Manejo de posibles valores nulos en la columna 6
            Object comentarioObj = tableMenu.getValueAt(i, 6);
            String comentario = (comentarioObj != null) ? comentarioObj.toString() : "";

            detPedido.setNombre(nombre);
            detPedido.setTipoPlato(tipoPlato);
            detPedido.setPrecio(precio);
            detPedido.setCantidad(cant);
            detPedido.setComentario(comentario);
            detPedido.setId_pedido(id);
            //detPedido.setEstado(estado);

            pedDao.registrarDetallePedido(detPedido);
        }
    }

    private void ListarPedidos() {
        Tables color = new Tables(6); // CAMBIADO: Pasa el índice de la columna de estado (6)
        List<Pedido> Listar = pedDao.listarPedidos();
        modelo = (DefaultTableModel) TablePedidos.getModel();
        Object[] ob = new Object[7];
        
        for (int i = 0; i < Listar.size(); i++) {
            ob[0] = Listar.get(i).getId();
            ob[1] = Listar.get(i).getSala();
            ob[2] = Listar.get(i).getUsuario();
            ob[3] = Listar.get(i).getNum_mesa();
            ob[4] = Listar.get(i).getFecha();
            ob[5] = Listar.get(i).getTotal();
            ob[6] = Listar.get(i).getEstado(); // Columna 6 es 'Estado' para TablePedidos
            modelo.addRow(ob);
        }
        colorHeader(TablePedidos);
        TablePedidos.setDefaultRenderer(Object.class, color);
    }

    private void ListarPlatos(JTable tabla) {
        // Cambia el nombre del método y la variable de acuerdo a la nueva clase
        List<Producto> listar = plaDao.listar(txtBuscarPlato.getText()); // Asegúrate de que txtBuscarProducto sea el campo correcto
        modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
        Object[] ob = new Object[5]; // Cambia el tamaño del arreglo a 4 para incluir todos los campos de Producto

        for (Producto producto : listar) {
            ob[0] = producto.getId_producto(); // Asegúrate de usar getId_producto()
            ob[1] = producto.getNom_producto(); // Asegúrate de usar getNom_producto()
            ob[2] = producto.getTipoPlato(); // Incluye el tipo de plato si es necesario
            ob[3] = producto.getPrecio();// Asegúrate de usar getPrecio()
            ob[4] = producto.getDescripcion(); //Se incluye la descripcion
            modelo.addRow(ob);
        }
        colorHeader(tabla);
    }

    private void ListarEstados(JTable tabla) {
        // Obtiene el texto ingresado en el campo de búsqueda
        String textoBusqueda = txtBuscadorConfirmacionPedido.getText().trim(); // Elimina espacios extra al inicio y al final

        // Verifica que el campo de búsqueda no esté vacío
        if (!textoBusqueda.isEmpty()) {
            // Convertir el texto de búsqueda a un entero si es un ID de pedido
            try {
                int idPedido = Integer.parseInt(textoBusqueda); // Intenta convertir el texto a un entero
                // Llama al método del DAO para obtener los detalles del pedido con el ID buscado
                List<DetallePedido> listar = pedDao.obtenerDetallesPedido(idPedido);
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

                Object[] ob = new Object[8]; // Cambia el tamaño del arreglo según la cantidad de columnas necesarias

                for (DetallePedido detalle : listar) {
                    ob[0] = detalle.getId_detallepedido(); // ID del detalle del pedido
                    ob[1] = detalle.getNombre(); // Nombre del producto
                    ob[2] = detalle.getTipoPlato(); // Tipo de plato
                    ob[3] = detalle.getCantidad(); // Cantidad del producto
                    ob[4] = detalle.getPrecio(); // Precio del producto
                    ob[5] = detalle.getComentario(); // Comentarios o notas del detalle
                    ob[6] = detalle.getId_pedido();
                    ob[7] = detalle.getEstado(); // Estado del detalle
                    modelo.addRow(ob); // Añadir la fila a la tabla
                }
                colorHeader(tabla); // Si tienes un método para personalizar la cabecera, úsalo aquí
            } catch (NumberFormatException e) {
                // Si no se puede convertir el texto a número, muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un ID de pedido válido", "Error de búsqueda", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Si el campo de búsqueda está vacío, no muestra nada
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0); // Limpiar la tabla
        }
    }
    
    private void ListarDetallesPedido() {
        Tables colorConfirmacion = new Tables(7); // CAMBIADO: Pasa el índice de la columna de estado (7)
        List<DetallePedido> listarDetalles = pedDao.listarDetallesPedido();
        modelo = (DefaultTableModel) tableConfirmacionPedidos.getModel();
        modelo.setRowCount(0); 
        Object[] ob = new Object[8];
        for (int i = 0; i < listarDetalles.size(); i++) {
            ob[0] = listarDetalles.get(i).getId_detallepedido();
            ob[1] = listarDetalles.get(i).getNombre();
            ob[2] = listarDetalles.get(i).getTipoPlato();
            ob[3] = listarDetalles.get(i).getCantidad();
            ob[4] = listarDetalles.get(i).getPrecio();
            ob[5] = listarDetalles.get(i).getComentario();
            ob[6] = listarDetalles.get(i).getId_pedido();
            ob[7] = listarDetalles.get(i).getEstado(); 
            modelo.addRow(ob);
        }
        colorHeader(tableConfirmacionPedidos);
        tableConfirmacionPedidos.setDefaultRenderer(Object.class, colorConfirmacion); // Usa la nueva instancia de Tables
    }


    private void actualizarTablaDetalles() {
        DefaultTableModel modelo = (DefaultTableModel) tableConfirmacionPedidos.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        List<DetallePedido> lista = pedDao.listarDetallesPedido(); // Supongamos que tienes este método
        for (DetallePedido detalle : lista) {
            modelo.addRow(new Object[]{
                detalle.getId_detallepedido(),
                detalle.getNombre(),
                detalle.getTipoPlato(),
                detalle.getPrecio(),
                detalle.getCantidad(),
                detalle.getComentario(),
                detalle.getId_pedido(),
                detalle.getEstado()
            });
        }
    }
   
}
