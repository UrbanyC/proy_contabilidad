/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.fomulario;

import static contabilidad.fomulario.login.archivo_patch;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class departamento extends javax.swing.JFrame {

    
    private DefaultTableModel tableModel;
    public departamento() {
        initComponents();
        cargarListado();
    }
    
    private void cargarListado() {
        ArrayList<String[]> datosDepartamentos = leerdatosDepartamentosDesdeArchivo();

        String[] columnas = {"ID", "Descripcion"};
        tableModel = new DefaultTableModel(columnas, 0);

        for (String[] fila : datosDepartamentos) {
            tableModel.addRow(fila);
        }

        tablaUsuarios.setModel(tableModel);
    }

    private ArrayList<String[]> leerdatosDepartamentosDesdeArchivo() {
        ArrayList<String[]> datosDepartamentos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo_patch))) {
            String linea;
            boolean esTablaUsuarios = false;
            

            while ((linea = br.readLine()) != null) {
                if (linea.trim().equals("- DEPARTAMENTO")) {
                    esTablaUsuarios = true;
                } else if (esTablaUsuarios && !linea.trim().isEmpty()) {
                    if(linea.startsWith("-")) {
                        break;
                    }
                    
                    String[] campos = linea.split("\\|");
                    datosDepartamentos.add(campos);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datosDepartamentos;
    }
    
        private void limpiarCampos() {
       
           btnEdit.setVisible(false);
           btnDelete.setVisible(false);
           btnClean.setVisible(true);
           btnSave.setVisible(true);
           deptoid.setEnabled(true);
           deptoid.setText("");
           deptodesc.setText("");
           formularioTabs.setSelectedIndex(1);
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        formularioTabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        deptodesc = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        deptoid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setTitle("Formulario de usuario");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setText("Departamentos");

        formularioTabs.setBackground(new java.awt.Color(255, 255, 255));
        formularioTabs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formularioTabsMouseClicked(evt);
            }
        });

        tablaUsuarios.setAutoCreateRowSorter(true);
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descripcion"
            }
        ));
        tablaUsuarios.setColumnSelectionAllowed(true);
        tablaUsuarios.setFillsViewportHeight(true);
        tablaUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaUsuarios.getTableHeader().setReorderingAllowed(false);
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        tablaUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaUsuariosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);
        tablaUsuarios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        formularioTabs.addTab("Listado", jPanel1);

        jLabel2.setText("Descripcion");

        deptodesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptodescActionPerformed(evt);
            }
        });

        btnSave.setText("Agregar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        deptoid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptoidActionPerformed(evt);
            }
        });

        jLabel8.setText("Id");

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClean.setText("Limpiar");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(deptodesc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnSave, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(deptoid, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnEdit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnDelete, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnClean, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnExit, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deptodesc, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deptoid, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deptoid, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(45, 45, 45)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deptodesc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        formularioTabs.addTab("Formulario", jLayeredPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(formularioTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(formularioTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaUsuariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaUsuariosKeyPressed
      
    }//GEN-LAST:event_tablaUsuariosKeyPressed

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
       
         
         DefaultTableModel tm = (DefaultTableModel) tablaUsuarios.getModel();
         
         String dato = String.valueOf(tm.getValueAt(tablaUsuarios.getSelectedRow(), 0));
         
           btnEdit.setVisible(true);
           btnDelete.setVisible(true);
           btnClean.setVisible(false);
           btnSave.setVisible(false);
           deptoid.setEnabled(false);
           
           deptoid.setText(String.valueOf(tm.getValueAt(tablaUsuarios.getSelectedRow(), 0)));
           deptodesc.setText(String.valueOf(tm.getValueAt(tablaUsuarios.getSelectedRow(), 1)));
           formularioTabs.setSelectedIndex(1);
         
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void formularioTabsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formularioTabsMouseClicked
        if(formularioTabs.getSelectedIndex()==0){
            cargarListado();
        }
        
        if( formularioTabs.getSelectedIndex()==1){
          limpiarCampos();
        
        }
    }//GEN-LAST:event_formularioTabsMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        limpiarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       // Ruta del archivo database.txt (ajusta esto según tu ubicación)
    String filePath = archivo_patch;

    // ID del departamento que deseas eliminar (reemplaza con el valor correcto)
    int departmentIdToDelete = Integer.parseInt(deptoid.getText());

    try {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        StringBuilder content = new StringBuilder();
        boolean departmentsSection = false;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            if (line.trim().equals("- DEPARTAMENTO")) {
                departmentsSection = true;
            } else if (departmentsSection && !line.trim().isEmpty() && !line.startsWith("-")) {
                String[] fields = line.split("\\|");
                if (fields.length >= 1) {
                    try {
                        int deptId = Integer.parseInt(fields[0]);
                        if (deptId == departmentIdToDelete) {
                            if(line.startsWith("-")) {
                                break;
                            }
                            // Si el ID del departamento coincide con el que queremos eliminar, no agregamos la línea al contenido
                            JOptionPane.showMessageDialog(null, "Departamento eliminado correctamente");
                            limpiarCampos();
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Error al convertir el ID de departamento: " + e.getMessage());
                    }
                }
            }
            // Agregamos la línea al contenido (excepto si es la línea que queremos eliminar)
            content.append(line).append("\n");
        }

        // Escribir los datos actualizados en el archivo
        FileWriter writer = new FileWriter(file);
        writer.write(content.toString());
        writer.close();

        System.out.println("Departamento con ID " + departmentIdToDelete + " eliminado correctamente.");
    } catch (IOException e) {
        System.err.println("Error al leer o escribir en el archivo: " + e.getMessage());
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       String filePath = archivo_patch;

        int userIdToUpdate = Integer.parseInt(deptoid.getText());

        String newdeptoid = deptoid.getText();
        String newdeptodesc = deptodesc.getText();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            StringBuilder content = new StringBuilder();
            boolean usersSection = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.trim().equals("- DEPARTAMENTO")) {
                    usersSection = true;
                    content.append(line).append("\n");
                } else if (usersSection && !line.trim().isEmpty() && !line.startsWith("-")) {
                    String[] fields = line.split("\\|");
                    if (fields.length >= 1 && fields[0].matches("\\d+")) {
                        int userId = Integer.parseInt(fields[0]);
                        if (userId == userIdToUpdate) {
                            content.append(userIdToUpdate + "|" + newdeptodesc).append("\n");
                            continue;
                        }
                    }
                    content.append(line).append("\n");
                } else {
                    content.append(line).append("\n");
                }
            }
            scanner.close();

            // Escribir los datos actualizados en el archivo
            FileWriter writer = new FileWriter(file);
            writer.write(content.toString());
            writer.close();

            System.out.println("Departamento con ID " + userIdToUpdate + " actualizado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al leer o escribir en el archivo: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void deptoidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptoidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deptoidActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

    String departmentIdInput = deptoid.getText();
    if (!departmentIdInput.matches("[0-9]+")) {
        JOptionPane.showMessageDialog(null, "El ID debe ser numérico");
        return;
    }
    
    String departmentDescInput = deptodesc.getText();
    if (departmentDescInput.length() > 30) {
        JOptionPane.showMessageDialog(null, "La descripción debe tener un máximo de 30 caracteres");
        return;
    }

    File file = new File(archivo_patch);
    try {
        Scanner scanner = new Scanner(file);
        boolean deptExists = false;

        // Iterar sobre el archivo para buscar el ID del departamento en la sección "DEPARTAMENTO"
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equals("- DEPARTAMENTO")) {
                // Entramos en la sección de departamentos, comenzamos a buscar el ID
                while (scanner.hasNextLine()) {
                    String deptLine = scanner.nextLine().trim();
                    if (deptLine.startsWith(departmentIdInput + "|")) {
                        // Si se encuentra un ID igual, mostrar mensaje y salir del bucle
                        deptExists = true;
                        break;
                    } else if (deptLine.startsWith("-")) {
                        // Hemos alcanzado el final de la sección de departamentos
                        break;
                    }
                }
                break; // Salir del bucle principal
            }
        }

        // Si el departamento ya existe, mostrar mensaje y salir del método
        if (deptExists) {
            JOptionPane.showMessageDialog(null, "Ya existe un departamento con el mismo ID.");
            return;
        }

        // Construir la nueva entrada del departamento
        String newDepartmentEntry = departmentIdInput + "|" + departmentDescInput + "\n";

        // Encontrar la posición donde insertar el nuevo registro
        StringBuilder content = new StringBuilder();
        boolean departmentsSection = false;
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            content.append(line).append("\n");

            if (line.trim().equals("- DEPARTAMENTO")) {
                departmentsSection = true;
            } else if (departmentsSection && !line.trim().isEmpty() && !line.startsWith("-")) {
                // Insertar el nuevo registro después de la sección de departamentos
                content.append(newDepartmentEntry);
                departmentsSection = false; // Evitar duplicar la inserción
            }
        }

        // Escribir los datos actualizados en el archivo
        FileWriter writer = new FileWriter(file);
        writer.write(content.toString());
        writer.close();

        System.out.println("Nuevo departamento con ID " + departmentIdInput + " ha sido agregado a la sección Departamentos en 'database.txt'.");
        JOptionPane.showMessageDialog(null, "Departamento creado correctamente");

        // Limpiar los campos de entrada
        deptodesc.setText("");
        deptoid.setText("");
    } catch (FileNotFoundException e) {
        System.err.println("Error: El archivo 'database.txt' no se encontró.");
    } catch (IOException e) {
        System.err.println("Error al escribir en el archivo 'database.txt'.");
    }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void deptodescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptodescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deptodescActionPerformed

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
            java.util.logging.Logger.getLogger(departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new departamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField deptodesc;
    private javax.swing.JTextField deptoid;
    private javax.swing.JTabbedPane formularioTabs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
