/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacclient;

import javax.swing.JOptionPane;

/**
 *
 * @author xdook
 */
public class JuegoPc extends javax.swing.JFrame {
    
    String[] casillas={"Z","Z","Z","Z","Z","Z","Z","Z","Z"};
    /**
     * Creates new form JuegoPc
     */
    public JuegoPc() {
        initComponents();
    }
    public JuegoPc(String usuarioConectado) {
        initComponents();
        jugador.setText(usuarioConectado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slot7 = new javax.swing.JButton();
        slot1 = new javax.swing.JButton();
        slot2 = new javax.swing.JButton();
        slot3 = new javax.swing.JButton();
        slot4 = new javax.swing.JButton();
        slot5 = new javax.swing.JButton();
        slot6 = new javax.swing.JButton();
        slot8 = new javax.swing.JButton();
        slot9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jugador = new javax.swing.JLabel();
        slot10 = new javax.swing.JButton();
        regresar = new javax.swing.JButton();

        slot7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot7ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        slot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot1ActionPerformed(evt);
            }
        });

        slot2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot2ActionPerformed(evt);
            }
        });

        slot3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot3ActionPerformed(evt);
            }
        });

        slot4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot4ActionPerformed(evt);
            }
        });

        slot5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot5ActionPerformed(evt);
            }
        });

        slot6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot6ActionPerformed(evt);
            }
        });

        slot8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot8ActionPerformed(evt);
            }
        });

        slot9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot9ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("\"O\" PC vs  \"X\"");

        jugador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jugador.setText("Jugador");

        slot10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot10ActionPerformed(evt);
            }
        });

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(slot4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slot5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slot6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(slot10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slot8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slot9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(slot1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slot2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slot3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jugador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(regresar)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(slot3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slot1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slot2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(slot6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(slot5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(slot4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slot9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slot10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slot8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jugador))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(regresar)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void pcTurn(){
        for (int i=0;i<casillas.length;i++){
            if("Z".equals(casillas[i])){
                casillas[i]="O";
                int casilla=i;
                switch (casilla){
                    case 0:{
                    slot1.setText("O");
                    slot1.setEnabled(false);
                    break;
                    }
                    case 1:{
                    slot2.setText("O");
                    slot2.setEnabled(false);
                    break;
                    }
                    case 2:{
                    slot3.setText("O");
                    slot3.setEnabled(false);
                    break;
                    }
                    case 4:{
                    slot5.setText("O");
                    slot5.setEnabled(false);
                    break;
                    }
                    case 6:{
                    slot10.setText("O");
                    slot10.setEnabled(false);
                    break;
                    }
                    case 8:{
                    slot9.setText("O");
                    slot9.setEnabled(false);
                    break;
                    }
                    case 3:{
                    slot4.setText("O");
                    slot4.setEnabled(false);
                    break;
                    }
                    case 5:{
                    slot6.setText("O");
                    slot6.setEnabled(false);
                    break;
                    }
                    case 7:{
                    slot8.setText("O");
                    slot8.setEnabled(false);
                    break;
                    }
                }
                return;
            }
            
        }
    }
    
    private void slot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot1ActionPerformed
        //Obtener si es mi turno
       slot1.setText("X");
       casillas[0]="X";
       slot1.setEnabled(false);
       checkIfEnd("X");
       pcTurn();
       checkIfEnd("O");
    }//GEN-LAST:event_slot1ActionPerformed

    private void slot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot2ActionPerformed
        // TODO add your handling code here:
        slot2.setText("X");
       casillas[1]="X";
       slot2.setEnabled(false);
       checkIfEnd("X");
       pcTurn();
       checkIfEnd("O");
    }//GEN-LAST:event_slot2ActionPerformed

    private void slot3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot3ActionPerformed
        // TODO add your handling code here:
        slot3.setText("X");
       casillas[2]="X";
       slot3.setEnabled(false);
       checkIfEnd("X");
       pcTurn();
       checkIfEnd("O");
    }//GEN-LAST:event_slot3ActionPerformed

    private void slot4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot4ActionPerformed
        // TODO add your handling code here:
       slot4.setText("X");
       casillas[3]="X";
       slot4.setEnabled(false);
       checkIfEnd("X");
       pcTurn();
       checkIfEnd("O");
    }//GEN-LAST:event_slot4ActionPerformed

    private void slot5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot5ActionPerformed
        // TODO add your handling code here:
       slot5.setText("X");
       casillas[4]="X";
       slot5.setEnabled(false);
       checkIfEnd("X");
       pcTurn();
       checkIfEnd("O");
    }//GEN-LAST:event_slot5ActionPerformed

    private void slot6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot6ActionPerformed
        // TODO add your handling code here:
        slot6.setText("X");
       casillas[5]="X";
       slot6.setEnabled(false);
       checkIfEnd("X");
       pcTurn();
       checkIfEnd("O");
    }//GEN-LAST:event_slot6ActionPerformed

    private void slot7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot7ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_slot7ActionPerformed

    private void slot8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot8ActionPerformed
        // TODO add your handling code here:
        slot8.setText("X");
       casillas[7]="X";
       slot8.setEnabled(false);
       checkIfEnd("X");
       pcTurn();
       checkIfEnd("O");
    }//GEN-LAST:event_slot8ActionPerformed

    private void slot9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot9ActionPerformed
        // TODO add your handling code here:
        slot9.setText("X");
       casillas[8]="X";
       slot9.setEnabled(false);
       checkIfEnd("X");
       pcTurn();
       checkIfEnd("O");
    }//GEN-LAST:event_slot9ActionPerformed

    private void slot10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot10ActionPerformed
        // ups! perdi slot 7, pero este lo suple
       slot10.setText("X");
       casillas[6]="X";
       slot10.setEnabled(false);
       checkIfEnd("X");
       pcTurn();
       checkIfEnd("O");
    }//GEN-LAST:event_slot10ActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        // registrar empate
        /*JOptionPane.showMessageDialog(null, "Se to!"); 
        Inicio.con.registerPcGame(jugador.getText(), "pc",true);*/
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void onTie() {                                         
        // registrar empate
        JOptionPane.showMessageDialog(null, "Empate!"); 
        Inicio.con.registerPcGame(jugador.getText(), "pc",true);
        this.setVisible(false);
        dispose();
    }   
    private void onWinning(String icon) {                                         
        // registrar empate
   
        if("O".equals(icon)){
            //gano pc
           
           Inicio.con.registerPcGame("pc",jugador.getText(),false);
           JOptionPane.showMessageDialog(null, "Ganó la pc!"); 
        }
        else{
           Inicio.con.registerPcGame(jugador.getText(),"pc",false);
           JOptionPane.showMessageDialog(null, "Ganaste!"); 
        }
        
       
        this.setVisible(false);
        dispose();
    }   
    
        private void checkIfEnd(String icon) {
        
//        x x x
//        - - -
//        - - -  
        if(slot1.getText().equals(icon) && slot2.getText().equals(icon) && slot3.getText().equals(icon))
            this.onWinning(icon);
//        - - -
//        x x x
//        - - -  
        else if(slot4.getText().equals(icon) && slot5.getText().equals(icon) && slot6.getText().equals(icon))
            this.onWinning(icon);
//        - - -
//        - - -
//        x x x
        else if(slot10.getText().equals(icon) && slot8.getText().equals(icon) && slot9.getText().equals(icon))
            this.onWinning(icon);
//        x - -
//        x - -
//        x - -
        else if(slot1.getText().equals(icon) && slot4.getText().equals(icon) && slot10.getText().equals(icon))
            this.onWinning(icon);
//        - x -
//        - x -
//        - x -
        else if(slot2.getText().equals(icon) && slot5.getText().equals(icon) && slot8.getText().equals(icon))
            this.onWinning(icon);
//        - - x
//        - - x
//        - - x
        else if(slot3.getText().equals(icon) && slot6.getText().equals(icon) && slot9.getText().equals(icon))
            this.onWinning(icon);
//        x - -
//        - x -
//        - - x
        else if(slot1.getText().equals(icon) && slot5.getText().equals(icon) && slot9.getText().equals(icon))
            this.onWinning(icon);
//        - - x
//        - x -
//        x - -
        else if(slot3.getText().equals(icon) && slot5.getText().equals(icon) && slot10.getText().equals(icon))
            this.onWinning(icon);
        
//      Revisar empate
        else if (
            (slot1.getText().equals("X")  || slot1.getText().equals("O") ) &&
            (slot2.getText().equals("X")  || slot2.getText().equals("O") ) &&
            (slot3.getText().equals("X")  || slot3.getText().equals("O") ) &&
            (slot4.getText().equals("X")  || slot4.getText().equals("O") ) &&
            (slot5.getText().equals("X")  || slot5.getText().equals("O") ) &&
            (slot6.getText().equals("X")  || slot6.getText().equals("O") ) &&
            (slot10.getText().equals("X")  || slot10.getText().equals("O") ) &&
            (slot8.getText().equals("X")  || slot8.getText().equals("O") ) &&
            (slot9.getText().equals("X")  || slot9.getText().equals("O") )
        ) this.onTie();
        
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
            java.util.logging.Logger.getLogger(JuegoPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoPc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jugador;
    private javax.swing.JButton regresar;
    private javax.swing.JButton slot1;
    private javax.swing.JButton slot10;
    private javax.swing.JButton slot2;
    private javax.swing.JButton slot3;
    private javax.swing.JButton slot4;
    private javax.swing.JButton slot5;
    private javax.swing.JButton slot6;
    private javax.swing.JButton slot7;
    private javax.swing.JButton slot8;
    private javax.swing.JButton slot9;
    // End of variables declaration//GEN-END:variables
}
