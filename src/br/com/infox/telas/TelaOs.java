/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.telas;

import javax.swing.JOptionPane;
import br.com.infox.dal.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author Jhon Lima
 */
public class TelaOs extends javax.swing.JFrame {

    //inicializando a variável conexao
    Connection conexao = null;
    //variáveis especiais de apoio à conexao com o BD
    PreparedStatement pst = null;
    //objeto matriz que recebe o resultado do comando sql
    ResultSet rs = null;
    public TelaOs() {
        initComponents();
        //executa o método conector
        //recebe a string de conexao ou null
        conexao = ModuloConexao.conector();
    }
    public void limpar(){
                    txtOsEq.setText(null);
                    txtOsDat.setText(null);
                    txtOsVal.setText(null);
                    txtOsSer.setText(null);
                    txtOsTec.setText(null);
                    txtOsIdCli.setText(null);
                    txtOsDef.setText(null);
    }
    private void consultar(){
        String sql = "SELECT * FROM tbos WHERE os = ?";
        try {
            //prepara a execução do comando sql
            pst = conexao.prepareStatement(sql);
            //associando o campo do formulário com o select
            pst.setString(1,txtOsOs.getText());
            //executando a query - montando o array
            rs = pst.executeQuery();
            //testa se encontrou
            if(rs.next()){
                txtOsDat.setText(rs.getString(2));
                txtOsEq.setText(rs.getString(3));
                txtOsDef.setText(rs.getString(4));              
                txtOsSer.setText(rs.getString(5));
                txtOsTec.setText(rs.getString(6));
                txtOsVal.setText(rs.getString(7));
                txtOsIdCli.setText(rs.getString(8));
                
            }else{
                JOptionPane.showMessageDialog(null,"O.S não cadastrada");
                limpar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void remover(){
    
        //pede confirmação para remover o.s
        int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja remover a O.S?");
        
        if(confirma == JOptionPane.YES_OPTION){
            String sql = "DELETE FROM tbos WHERE os=?";
            
            try {
                //prepara execução do comando sql
                pst = conexao.prepareStatement(sql);
                //recebe o campo do formulário e envia para o delete
                pst.setString(1,txtOsOs.getText());
                //executa o comando sql
                int apagado = pst.executeUpdate();
                 if(apagado>0){
                     JOptionPane.showMessageDialog(null,"Usuário removido com sucesso.");
                     
                     //limpando os campos do formulario
                    limpar();
                 }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    private void adicionar(){
       String test = "SELECT * FROM tbclientes WHERE idcli = ?";
       String sql = "INSERT INTO tbos(equipamento,defeito,servico,tecnico,valor,idcli) VALUES(?,?,?,?,?,?)";
        try {
            if(txtOsIdCli.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Preencha o campo Id Cliente corretamente!");
            }else{
                //Executa a consulta do idcli
                pst = conexao.prepareStatement(test);
                pst.setString(1,txtOsIdCli.getText());
                rs = pst.executeQuery();
                //caso exista inicia a query adicionar
                if(rs.next()){
                    pst = conexao.prepareStatement(sql);
                    //Inserindo dados
                    pst.setString(1,txtOsEq.getText());
                    pst.setString(2,txtOsDef.getText());
                    pst.setString(3,txtOsSer.getText());
                    pst.setString(4,txtOsTec.getText());
                    pst.setString(5,txtOsVal.getText());
                    pst.setString(6,txtOsIdCli.getText());
                    int adicionado = pst.executeUpdate();
                    //verifica se foi adicionado
                    if(adicionado>0){
                       JOptionPane.showMessageDialog(null, "O.S adicionada com sucesso!"); 
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Cliente não cadastrado."); 
                }
            }                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void alterar(){
        String test = "SELECT * FROM tbclientes WHERE idcli = ?";
        String sql = "UPDATE tbos SET equipamento=?, defeito=?, servico=?, tecnico=?,valor=?,idcli=? where os=?";      
        try {
            if(txtOsIdCli.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Preencha o campo Id Cliente corretamente!");
            }else{
                //Executa a consulta da os
                pst = conexao.prepareStatement(test);
                pst.setString(1,txtOsIdCli.getText());
                rs = pst.executeQuery();
                //caso exista inicia a query adicionar
                if(rs.next()){
                    pst = conexao.prepareStatement(sql);
                    //Inserindo dados
                    pst.setString(1,txtOsEq.getText());
                    pst.setString(2,txtOsDef.getText());
                    pst.setString(3,txtOsSer.getText());
                    pst.setString(4,txtOsTec.getText());
                    pst.setString(5,txtOsVal.getText());
                    pst.setString(6,txtOsIdCli.getText());
                    pst.setString(7,txtOsOs.getText());
                    int adicionado = pst.executeUpdate();
                    //verifica se foi adicionado
                    if(adicionado>0){
                       JOptionPane.showMessageDialog(null, "O.S alterada com sucesso!"); 
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Cliente não cadastrado."); 
                }
            }                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCliDelete = new javax.swing.JButton();
        btnCliUpdate = new javax.swing.JButton();
        btnCliRead = new javax.swing.JButton();
        btnCliCreate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtOsOs = new javax.swing.JTextField();
        txtOsEq = new javax.swing.JTextField();
        txtOsDef = new javax.swing.JTextField();
        txtOsVal = new javax.swing.JTextField();
        txtOsIdCli = new javax.swing.JTextField();
        txtOsTec = new javax.swing.JTextField();
        txtOsSer = new javax.swing.JTextField();
        txtOsDat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(792, 449));
        setMinimumSize(new java.awt.Dimension(792, 449));
        setResizable(false);

        btnCliDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/delete.png"))); // NOI18N
        btnCliDelete.setToolTipText("Remover");
        btnCliDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliDelete.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCliDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliDeleteActionPerformed(evt);
            }
        });

        btnCliUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/update.png"))); // NOI18N
        btnCliUpdate.setToolTipText("Alterar");
        btnCliUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliUpdate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCliUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliUpdateActionPerformed(evt);
            }
        });

        btnCliRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/read.png"))); // NOI18N
        btnCliRead.setToolTipText("Pesquisar");
        btnCliRead.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliRead.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCliRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliReadActionPerformed(evt);
            }
        });

        btnCliCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/create.png"))); // NOI18N
        btnCliCreate.setToolTipText("Adicionar");
        btnCliCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCliCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliCreateActionPerformed(evt);
            }
        });

        jLabel1.setText("OS");

        jLabel2.setText("Técnico");

        jLabel3.setText("Defeito");

        jLabel4.setText("Serviço");

        jLabel5.setText("Id Cliente");

        jLabel6.setText("Data");

        jLabel7.setText("Valor");

        jLabel8.setText("Equipamento");

        txtOsEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOsEqActionPerformed(evt);
            }
        });

        txtOsDat.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOsEq)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtOsOs, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtOsDat, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                    .addComponent(txtOsIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtOsTec, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtOsVal))
                    .addComponent(txtOsDef)
                    .addComponent(txtOsSer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(237, Short.MAX_VALUE)
                .addComponent(btnCliCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCliRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCliUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCliDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOsOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtOsDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtOsEq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOsDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtOsSer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOsVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOsTec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtOsIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCliCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCliRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCliUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCliDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCliDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliDeleteActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_btnCliDeleteActionPerformed

    private void btnCliUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliUpdateActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_btnCliUpdateActionPerformed

    private void btnCliReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliReadActionPerformed
        // chama o método consultar
        consultar();
    }//GEN-LAST:event_btnCliReadActionPerformed

    private void btnCliCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliCreateActionPerformed
        // TODO add your handling code here:
       adicionar();
    }//GEN-LAST:event_btnCliCreateActionPerformed

    private void txtOsEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOsEqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOsEqActionPerformed

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
            java.util.logging.Logger.getLogger(TelaOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaOs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliCreate;
    private javax.swing.JButton btnCliDelete;
    private javax.swing.JButton btnCliRead;
    private javax.swing.JButton btnCliUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtOsDat;
    private javax.swing.JTextField txtOsDef;
    private javax.swing.JTextField txtOsEq;
    private javax.swing.JTextField txtOsIdCli;
    private javax.swing.JTextField txtOsOs;
    private javax.swing.JTextField txtOsSer;
    private javax.swing.JTextField txtOsTec;
    private javax.swing.JTextField txtOsVal;
    // End of variables declaration//GEN-END:variables
}
