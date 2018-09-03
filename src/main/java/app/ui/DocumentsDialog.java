
package app.ui;

import app.Launcher;
import app.model.Model;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author maksim.khramov
 */
public class DocumentsDialog extends javax.swing.JDialog {

    /**
     * Creates new form DocumentsDialog
     */
    public DocumentsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        List<Model> models = Launcher.getApplication().getController().getModels();
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Views");

        models.stream().map((model) -> { return new ModelTreeNode(model); }).forEach((node) -> { root.add(node); });
        viewsTree.setModel(new DefaultTreeModel(root));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewsTree = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Documents");
        setModal(true);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        viewsTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewsTreeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(viewsTree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void viewsTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewsTreeMouseClicked
        if(evt.getClickCount() == 2) {            
            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(DocumentsDialog.this, "Clicked on: " + viewsTree.getLastSelectedPathComponent());
            });
        }
        
    }//GEN-LAST:event_viewsTreeMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree viewsTree;
    // End of variables declaration//GEN-END:variables
    
    private class ModelTreeNode extends DefaultMutableTreeNode {
        
        public ModelTreeNode(Model model) {
            super(model);
        }
    }
    
    private class ViewTreeNode extends DefaultMutableTreeNode {

        @Override
        public boolean getAllowsChildren() {
            return false;
        }

    }
}
