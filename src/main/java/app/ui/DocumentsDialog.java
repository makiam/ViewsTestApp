
package app.ui;

import app.Launcher;
import app.model.Model;
import app.view.View;
import app.view.events.ToggleViewEvent;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.greenrobot.eventbus.EventBus;

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

        models.stream().map((model) -> { return new ModelTreeNode(model); }).forEach((node) -> { addModelNode(root, node); });
        viewsTree.setModel(new DefaultTreeModel(root));
    }
    
    private void addModelNode(DefaultMutableTreeNode root, ModelTreeNode pNode) {
        List<View> views = Launcher.getApplication().getController().getViews((Model)pNode.getUserObject());
        views.stream().filter(view -> view != null).map((view) -> { return new ViewTreeNode(view); }).forEach((node) -> { pNode.add(node); });
        root.add(pNode);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewsTree = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Documents");
        setModal(true);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
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
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(okButton)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void viewsTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewsTreeMouseClicked
        final Object ct = viewsTree.getLastSelectedPathComponent();        
        if(evt.getClickCount() == 2 && ct instanceof ViewTreeNode) {
            dispose();
            SwingUtilities.invokeLater(() -> {
                EventBus.getDefault().post(new ToggleViewEvent((View)((ViewTreeNode)ct).getUserObject()));                
            });
        }
        
    }//GEN-LAST:event_viewsTreeMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JTree viewsTree;
    // End of variables declaration//GEN-END:variables
    
    private class ModelTreeNode extends DefaultMutableTreeNode {
        
        public ModelTreeNode(Model model) {
            super(model);
        }
    }
    
    private class ViewTreeNode extends DefaultMutableTreeNode {

        public ViewTreeNode(View view) {
            super(view);
        }
        
        @Override
        public boolean getAllowsChildren() {
            return false;
        }

        @Override
        public String toString() {
            return "ViewTreeNode{" + this.userObject + '}';
        }
        

    }
}
