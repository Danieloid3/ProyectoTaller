package vista;

import controlador.ControllerCategoria;
import java.awt.Dimension;
import java.util.Set;
import javax.swing.JOptionPane;
import modelo.CategoriaModel;

public class InternalFormCategoria extends javax.swing.JInternalFrame {

    /**
     * Creates new form InternalFormCategoria
     */
    public InternalFormCategoria() {
        initComponents();
        this.setSize(new Dimension(400, 200));
        this.setTitle("Categoría");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_descripcion_categoria = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registrar categoría");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripción:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 90, 30));
        getContentPane().add(txt_descripcion_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 240, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/fondo3.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 160));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        CategoriaModel categoria = new CategoriaModel();
        ControllerCategoria controlCategoria = new ControllerCategoria();

        categoria.setDescripcion(txt_descripcion_categoria.getText().trim());
        categoria.setEstado(1);

        //Validar datos vacios
        if (txt_descripcion_categoria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese registros en los campos");
        } else {
            if (!controlCategoria.CategoriaExistente(txt_descripcion_categoria.getText().trim())) {
                categoria.setDescripcion(txt_descripcion_categoria.getText().trim());
                categoria.setEstado(1);

                if (controlCategoria.Guardar(categoria)) {
                    JOptionPane.showMessageDialog(null, "Categoría guardada exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Categoría existente, ingrese una nueva");
            }
        }
        // Limpiar el text field
        txt_descripcion_categoria.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_descripcion_categoria;
    // End of variables declaration//GEN-END:variables
}
