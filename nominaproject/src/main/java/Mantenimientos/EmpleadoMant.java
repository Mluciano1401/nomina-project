package Mantenimientos;

import ManejadordeArchivos.ManejadorArchivos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author María Luciano
 */
public class EmpleadoMant extends javax.swing.JPanel {
    boolean editar = false;    
    public static String antigualinea="";
    /**
     * Creates new form EmpleadoMant
     */
    public EmpleadoMant() {
        initComponents();
        File puestos = new File("puesto.txt");
        File departamentos = new File("departamento.txt");
        try{
            Scanner leer1 = new Scanner(departamentos);            
            Scanner leer2 = new Scanner(puestos);
            while (leer1.hasNextLine()){
                String linea = leer1.nextLine();
                Scanner sl = new Scanner(linea);
                sl.useDelimiter("\\s*;\\s*");
                iddepartamento.addItem(sl.next());
            }
            while (leer2.hasNextLine()){
                String linea = leer2.nextLine();
                Scanner sl = new Scanner(linea);
                sl.useDelimiter("\\s*;\\s*");
                idpuesto.addItem(sl.next());
            }
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null,"Error al traer datos " + error);
            error.printStackTrace();
         }
        
        id_empleado.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer cod;
                boolean encontrado=false;
                cod=Integer.parseInt(id_empleado.getText());
                Scanner s;
                try{
                    File f = new File("empleado.txt");
                    s = new Scanner(f);
                    if(!f.exists()){
                        f.createNewFile();
                    }
                    else{
                         while (s.hasNextLine() && !encontrado){
                         String linea = s.nextLine();
                         Scanner sl = new Scanner(linea);
                         sl.useDelimiter("\\s*;\\s*");
                         try{
                             if(cod==Integer.parseInt(sl.next())){
                                 nombre.setText(sl.next());
                                 apellidop.setText(sl.next());
                                 apellidom.setText(sl.next());
                                 direccion.setText(sl.next());
                                 sexo.setSelectedIndex(sl.nextByte());                                 
                                 iddepartamento.setSelectedIndex(sl.nextByte());
                                 idpuesto.setSelectedIndex(sl.nextByte());
                                 coop.setSelectedIndex(sl.nextByte());
                                 sueldo.setText(sl.next());
                                 encontrado=true;
                                 editar= true;
                                 antigualinea=(id_empleado.getText() +";"+ nombre.getText()
                                 +";"+apellidop.getText()+";"+apellidom.getText()+";"+direccion.getText()+";"+
                                 ";"+sexo.getSelectedIndex()+iddepartamento.getSelectedIndex()
                                 +idpuesto.getSelectedIndex()
                                 +";"+coop.getSelectedIndex()+";"+sueldo.getText());
                                 Status.setText("Modificando Empleado");
                                 jButtonGuardar.setEnabled(true);
                             }
                             else{
                                 nombre.setText("");
                                 apellidop.setText("");
                                 apellidom.setText("");
                                 direccion.setText("");
                                 sexo.setSelectedIndex(0);
                                 iddepartamento.setSelectedIndex(0);
                                 idpuesto.setSelectedIndex(0);
                                 coop.setSelectedIndex(0);
                                 sueldo.setText("");
                                 encontrado=false;
                                 editar = false;
                                 Status.setText("Creando Empleado");
                                 jButtonGuardar.setEnabled(true);
                             }
                         }
                         catch(Exception error){
                            JOptionPane.showMessageDialog(null,"Error al leer Archivo " + error);
                            error.printStackTrace();
                         }
                    }
                 }
                 s.close();
                }
                catch(FileNotFoundException error){
                        JOptionPane.showMessageDialog(null,"Error al leer Archivo " + error);
                        error.printStackTrace();
                }
                catch(Exception error){
                    error.printStackTrace();
                }
                
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

        jLabel4 = new javax.swing.JLabel();
        Status = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        sexo = new javax.swing.JComboBox<>();
        direccion = new javax.swing.JTextField();
        apellidop = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        id_empleado = new javax.swing.JTextField();
        apellidom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        coop = new javax.swing.JComboBox<>();
        sueldo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButtonLimpiar = new javax.swing.JButton();
        iddepartamento = new javax.swing.JComboBox<>();
        idpuesto = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 255, 255));
        setMinimumSize(new java.awt.Dimension(660, 540));
        setPreferredSize(new java.awt.Dimension(668, 529));

        jLabel4.setText("Sexo");

        Status.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Status.setText("Empleado");

        jLabel5.setText("Dirección");

        nombre.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                nombreComponentAdded(evt);
            }
        });
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexoActionPerformed(evt);
            }
        });

        direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionActionPerformed(evt);
            }
        });

        jLabel2.setText("nombre ");

        jButtonGuardar.setBackground(new java.awt.Color(153, 255, 153));
        jButtonGuardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setToolTipText("");
        jButtonGuardar.setBorder(null);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jLabel3.setText("apellido paterno");

        jLabel8.setText("id");

        jLabel7.setText("Id departamento");

        id_empleado.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                id_empleadoComponentAdded(evt);
            }
        });

        jLabel6.setText("apellido materno");

        jLabel9.setText("Id puesto");

        jLabel10.setText("Cooperativa");

        coop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "no", "si" }));
        coop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coopActionPerformed(evt);
            }
        });

        sueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sueldoActionPerformed(evt);
            }
        });

        jLabel11.setText("Sueldo");

        jButtonLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonLimpiar.setText("limpiar");
        jButtonLimpiar.setBorder(null);
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(192, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(direccion)
                                        .addComponent(apellidop)
                                        .addComponent(nombre)
                                        .addComponent(id_empleado)
                                        .addComponent(apellidom)
                                        .addComponent(sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(coop, javax.swing.GroupLayout.Alignment.LEADING, 0, 83, Short.MAX_VALUE)
                                        .addComponent(idpuesto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(iddepartamento, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(Status)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(id_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(apellidop, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(apellidom, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(iddepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(idpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGuardar)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nombreComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_nombreComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreComponentAdded

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
      ManejadorArchivos MA = new ManejadorArchivos();
      String Id = id_empleado.getText();
      String nombreEmpleado = nombre.getText();
      String apellidoP = apellidop.getText();
      String apellidoM = apellidom.getText();
      String direc = direccion.getText();
      int sex = sexo.getSelectedIndex();
      int iddep = iddepartamento.getSelectedIndex();
      int idp = idpuesto.getSelectedIndex();
      int coope = coop.getSelectedIndex();
      String sueldobruto = sueldo.getText();
        try{
            if(editar==false){
                String data  = Id + ";"+ nombreEmpleado + ";"+apellidoP+ ";"+ apellidoM+
                ";"+  direc+ ";"+ sex+ ";"+ iddep+";"+  idp+ ";"+ coope+ ";"+
                sueldobruto+"\n";
                MA.GuardarDatos(data,"empleado.txt");
            }
            else{
                String data  = Id + ";"+ nombreEmpleado + ";"+apellidoP+ ";"+ apellidoM+
                ";"+  direc+ ";"+ sex+ ";"+ iddep+";"+  idp+ ";"+ coope+ ";"+
                sueldobruto;
                MA.ModificaDatos(Id,antigualinea, data,"empleado1.txt","empleado.txt");
            }
            jButtonLimpiarActionPerformed(evt);
        }
        catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void id_empleadoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_id_empleadoComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_id_empleadoComponentAdded

    private void direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionActionPerformed
    private void sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexoActionPerformed

    private void coopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coopActionPerformed
       int cooperativa = coop.getSelectedIndex();
       if(cooperativa == 1){
           Cooperativa cooplayout = new Cooperativa();
           JOptionPane.showMessageDialog(null,cooplayout);
       }
    }//GEN-LAST:event_coopActionPerformed

    private void sueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sueldoActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        id_empleado.setText("");
        nombre.setText("");
        apellidop.setText("");
        apellidom.setText("");
        direccion.setText("");
        sexo.setSelectedIndex(0);
        iddepartamento.setSelectedIndex(0);
        idpuesto.setSelectedIndex(0);
        coop.setSelectedIndex(0);
        sueldo.setText("");
        Status.setText("Empleado");
    }//GEN-LAST:event_jButtonLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Status;
    private javax.swing.JTextField apellidom;
    private javax.swing.JTextField apellidop;
    private javax.swing.JComboBox<String> coop;
    private javax.swing.JTextField direccion;
    private javax.swing.JTextField id_empleado;
    private javax.swing.JComboBox<String> iddepartamento;
    private javax.swing.JComboBox<String> idpuesto;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nombre;
    private javax.swing.JComboBox<String> sexo;
    private javax.swing.JTextField sueldo;
    // End of variables declaration//GEN-END:variables
}
