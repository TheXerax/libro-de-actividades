/*
 * PanelTerminal.java
 *
 * Created on 16 de enero de 2008, 11:37
 */
package terminal.ui.gui;

import terminal.shell.*;
import java.awt.event.*;

/**
 *
 * @author  david
 */
public class PanelTerminal extends javax.swing.JPanel {

    public static final long serialVersionUID = 1;
    private InterfazShell shell;
    private int numeroLineas;

    /** Creates new form PanelTerminal */
    public PanelTerminal() {
        initComponents();
        this.inicializar();
    }

    public boolean isFin() {
        return this.shell.isFin();
    }

    public void setShell(InterfazShell shell) {
        this.shell=shell;
        this.txtConsolaHtml.setText(shell.getSalida());
        this.txtConsolaHtml.setAutoscrolls(true);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtConsolaHtml = new javax.swing.JTextPane();
        pnlEntrada = new javax.swing.JPanel();
        lblPrompt = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        btnEjecutar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setLayout(new java.awt.BorderLayout());

        txtConsolaHtml.setBackground(new java.awt.Color(16, 13, 9));
        txtConsolaHtml.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        txtConsolaHtml.setForeground(new java.awt.Color(251, 245, 5));
        jScrollPane2.setViewportView(txtConsolaHtml);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pnlEntrada.setLayout(new javax.swing.BoxLayout(pnlEntrada, javax.swing.BoxLayout.X_AXIS));

        lblPrompt.setText("Prompt del terminal$");
        pnlEntrada.add(lblPrompt);

        txtEntrada.setText("Escriba aquí...");
        txtEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEntradaKeyPressed(evt);
            }
        });
        pnlEntrada.add(txtEntrada);

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });
        pnlEntrada.add(btnEjecutar);

        add(pnlEntrada, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents
    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        this.ejecutarComando();
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void txtEntradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.ejecutarComando();
        }
    }//GEN-LAST:event_txtEntradaKeyPressed

    private void inicializar() {
        shell = new ShellAPIjava();
        this.txtConsolaHtml.setText(shell.getSalida());
        this.txtConsolaHtml.setAutoscrolls(true);
        this.numeroLineas=30;
    }

    private void ejecutarComando() {
        this.txtConsolaHtml.setText(this.txtConsolaHtml.getText() + this.txtEntrada.getText() + "\n");
        shell.setEntrada(this.txtEntrada.getText());
        String s = this.txtConsolaHtml.getText();
        //if (s.split("\n").length >20) { s=""; }
        this.txtConsolaHtml.setText(s + shell.getSalida());

        this.lblPrompt.setText(shell.getPrompt());
        this.txtEntrada.setText("");
    //this.txtEntrada.selectAll();
    //this.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPrompt;
    private javax.swing.JPanel pnlEntrada;
    private javax.swing.JTextPane txtConsolaHtml;
    private javax.swing.JTextField txtEntrada;
    // End of variables declaration//GEN-END:variables
}