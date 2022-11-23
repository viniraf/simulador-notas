/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.MenuItems;

import Connection.MySQL;
import View.Login.StudentLoginPanel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author AnderSecurity
 */
public class MatterSearchPanel extends javax.swing.JFrame {

MySQL conectar = new MySQL();
String campoVazio = "";

    public MatterSearchPanel() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    
        private void SearchMatter() {
            
        this.conectar.conectaBanco();
        int consultaId = StudentLoginPanel.studentId;
        cbxMatter.removeAllItems();
        
        try {
            this.conectar.executarSQL(
            "SELECT "
            + "nameMatter"
             + " FROM"
            + " grades"
          + " WHERE"
            + " idStudent = " + consultaId + ";"
            );
        while(this.conectar.getResultSet().next()) {
            cbxMatter.addItem(this.conectar.getResultSet().getString(1));
        }
        } catch (Exception e) {
            System.out.println("Erro ao consultar Matérias: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar matérias!");
        
        } finally {
            this.conectar.fechaBanco();     
    }
    }
 
        private void SearchGrades() {
            
        this.conectar.conectaBanco();
        int consultaId2 = StudentLoginPanel.studentId;
        
        try {
            this.conectar.executarSQL(
            "SELECT "
            + "noteAc1,"
            + "ac1Multiplier,"
            + "noteAc2,"
            + "ac2Multiplier,"
            + "noteAf,"
            + "afMultiplier,"
            + "noteSub,"
            + "subMultiplier,"
            + "noteAg,"
            + "agMultiplier"
             + " FROM grades"
          + " WHERE"
            + " idStudent = " + consultaId2 + " and nameMatter = '" + cbxMatter.getSelectedItem() + "';"
            );
        while(this.conectar.getResultSet().next()) {
            txtAc1Note.setText(this.conectar.getResultSet().getString(1));
            txtAc1Multiplier.setText(this.conectar.getResultSet().getString(2));
            txtAc2Note.setText(this.conectar.getResultSet().getString(3));
            txtAc2Multiplier.setText(this.conectar.getResultSet().getString(4));
            txtAfNote.setText(this.conectar.getResultSet().getString(1));
            txtAfMultiplier.setText(this.conectar.getResultSet().getString(2));
            txtSubNote.setText(this.conectar.getResultSet().getString(3));
            txtSubMultiplier.setText(this.conectar.getResultSet().getString(4));
            txtAgNote.setText(this.conectar.getResultSet().getString(1));
            txtAgMultiplier.setText(this.conectar.getResultSet().getString(2));
        }  
        } catch (Exception e) {
            System.out.println("Erro ao consultar Serviço: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar Serviço!");
        } finally {
            this.conectar.fechaBanco();     
    }
    }
    
private void Calculate(String campoVazio) {
        int consultaId = StudentLoginPanel.studentId;
        float note = 0;
        float somaPesos = Float.parseFloat(txtAc1Multiplier.getText()) + Float.parseFloat(txtAc2Multiplier.getText()) + Float.parseFloat(txtAfMultiplier.getText()) + Float.parseFloat(txtSubMultiplier.getText()) + Float.parseFloat(txtAgMultiplier.getText());
        
        try {
            switch (campoVazio) {
                case "Ac1Note":
                    note = (Float.parseFloat(txtMedia.getText())*somaPesos) - (Float.parseFloat(txtAc2Note.getText())*Float.parseFloat(txtAc2Multiplier.getText()) - Float.parseFloat(txtAfNote.getText())*Float.parseFloat(txtAfMultiplier.getText()) - Float.parseFloat(txtSubNote.getText())*Float.parseFloat(txtSubMultiplier.getText()) - Float.parseFloat(txtAgNote.getText())*Float.parseFloat(txtAgMultiplier.getText())) / Float.parseFloat(txtAc1Multiplier.getText());
                    txtAc1Note.setText(Float.toString(note));
                    break;
                        
                case "Ac2Note":
                    note = (Float.parseFloat(txtMedia.getText())*somaPesos) - (Float.parseFloat(txtAc1Note.getText())*Float.parseFloat(txtAc1Multiplier.getText()) - Float.parseFloat(txtAfNote.getText())*Float.parseFloat(txtAfMultiplier.getText()) - Float.parseFloat(txtSubNote.getText())*Float.parseFloat(txtSubMultiplier.getText()) - Float.parseFloat(txtAgNote.getText())*Float.parseFloat(txtAgMultiplier.getText())) / Float.parseFloat(txtAc2Multiplier.getText());
                    txtAc2Note.setText(Float.toString(note));
                    break;
                    
                case "AfNote":
                    note = (Float.parseFloat(txtMedia.getText())*somaPesos) - (Float.parseFloat(txtAc1Note.getText())*Float.parseFloat(txtAc1Multiplier.getText()) - Float.parseFloat(txtAc2Note.getText())*Float.parseFloat(txtAc2Multiplier.getText()) - Float.parseFloat(txtSubNote.getText())*Float.parseFloat(txtSubMultiplier.getText()) - Float.parseFloat(txtAgNote.getText())*Float.parseFloat(txtAgMultiplier.getText())) / Float.parseFloat(txtAfMultiplier.getText());
                    txtAfNote.setText(Float.toString(note));
                    break;
                
                case "SubNote":
                    note = (Float.parseFloat(txtMedia.getText())*somaPesos) - (Float.parseFloat(txtAc1Note.getText())*Float.parseFloat(txtAc1Multiplier.getText()) - Float.parseFloat(txtAc2Note.getText())*Float.parseFloat(txtAc2Multiplier.getText()) - Float.parseFloat(txtAfNote.getText())*Float.parseFloat(txtAfMultiplier.getText()) - Float.parseFloat(txtAgNote.getText())*Float.parseFloat(txtAgMultiplier.getText())) / Float.parseFloat(txtSubMultiplier.getText());
                    txtAfNote.setText(Float.toString(note));
                    break;
                    
                case "AgNote":
                    note = (Float.parseFloat(txtMedia.getText())*somaPesos) - (Float.parseFloat(txtAc1Note.getText())*Float.parseFloat(txtAc1Multiplier.getText()) - Float.parseFloat(txtAc2Note.getText())*Float.parseFloat(txtAc2Multiplier.getText()) - Float.parseFloat(txtAfNote.getText())*Float.parseFloat(txtAfMultiplier.getText()) - Float.parseFloat(txtSubNote.getText())*Float.parseFloat(txtSubMultiplier.getText())) / Float.parseFloat(txtAgMultiplier.getText());
                    txtAfNote.setText(Float.toString(note));
                    break;
                    
                case "Media":
                    note = (Float.parseFloat(txtAc1Note.getText())*Float.parseFloat(txtAc1Multiplier.getText()) + Float.parseFloat(txtAc2Note.getText())*Float.parseFloat(txtAc2Multiplier.getText()) + Float.parseFloat(txtAfNote.getText())*Float.parseFloat(txtAfMultiplier.getText()) + Float.parseFloat(txtSubNote.getText())*Float.parseFloat(txtSubMultiplier.getText()) + Float.parseFloat(txtAgNote.getText())*Float.parseFloat(txtAgMultiplier.getText())) / somaPesos;
                    txtMedia.setText(Float.toString(note));
                    break;
            }
            
            this.conectar.conectaBanco();
            this.conectar.updateSQL(
            "UPDATE grades SET "
            + "noteAc1 = " + Float.parseFloat(txtAc1Note.getText()) + ","
            + "noteAc2 = " + Float.parseFloat(txtAc1Note.getText()) + ","
            + "noteAf = " + Float.parseFloat(txtAc1Note.getText()) + ","
            + "noteSub = " + Float.parseFloat(txtAc1Note.getText()) + ","
            + "noteAg = " + Float.parseFloat(txtAc1Note.getText()) + ","
            + "ac1Multiplier = " + Float.parseFloat(txtAc1Note.getText()) + ","
            + "ac2Multiplier = " + Float.parseFloat(txtAc1Note.getText()) + ","
            + "afMultiplier = " + Float.parseFloat(txtAc1Note.getText()) + ","
            + "subMultiplier = " + Float.parseFloat(txtAc1Note.getText()) + ","
            + "agMultiplier = " + Float.parseFloat(txtAc1Note.getText()) + ""
            + " WHERE id = " + consultaId + ";"
            );
            JOptionPane.showMessageDialog(null, "Calculado com sucesso!");
            } catch (Exception e) {
            System.out.println("Erro ao calcular: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao calcular!");
        
        } finally {
            this.conectar.fechaBanco();
    }
    }

private void chkCamposPesos (boolean chkPeso) {
    if (txtAc1Multiplier.getText().equals("") || txtAc2Multiplier.getText().equals("") || txtAfMultiplier.getText().equals("") || txtSubMultiplier.getText().equals("") || txtAgMultiplier.getText().equals("") ) {
        JOptionPane.showMessageDialog(null, "Todos os pesos devem estar preenchidos!");
        chkPeso = false;
    }
}

private void chkCamposNotas(boolean chkNote) {
    
    if (txtAc1Note.getText().equals("")) {
        if (txtAc2Note.getText().equals("") || txtAfNote.getText().equals("") || txtSubNote.getText().equals("") || txtAgNote.getText().equals("") || txtMedia.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Só é permitido deixar um campo vazio nas notas, incluindo a média!");
            chkNote = false;
        }
        else {
            campoVazio = "Ac1Note";
        }
    }
    else if (txtAc2Note.getText().equals("")){
        if (txtAc1Note.getText().equals("") || txtAfNote.getText().equals("") || txtSubNote.getText().equals("") || txtAgNote.getText().equals("") || txtMedia.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Só é permitido deixar um campo vazio nas notas, incluindo a média!");
            chkNote = false;
        }
        else {
            campoVazio = "Ac2Note";
        }
    }
    else if (txtAfNote.getText().equals("")) {
        if (txtAc1Note.getText().equals("") || txtAc2Note.getText().equals("") || txtSubNote.getText().equals("") || txtAgNote.getText().equals("") || txtMedia.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Só é permitido deixar um campo vazio nas notas, incluindo a média!");
            chkNote = false;
        }
        else {
            campoVazio = "AfNote";
        }
    }
    else if (txtSubNote.getText().equals("")) {
        if (txtAc1Note.getText().equals("") || txtAc2Note.getText().equals("") || txtAfNote.getText().equals("") || txtAgNote.getText().equals("") || txtMedia.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Só é permitido deixar um campo vazio nas notas, incluindo a média!");
            chkNote = false;
        }        
        else {
            campoVazio = "SubNote";
        }
    }
    else if (txtAgNote.getText().equals("")) {
        if (txtAc1Note.getText().equals("") || txtAc2Note.getText().equals("") || txtAfNote.getText().equals("") || txtSubNote.getText().equals("") || txtMedia.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Só é permitido deixar um campo vazio nas notas, incluindo a média!");
            chkNote = false;
        }     
        else {
            campoVazio = "AgNote";
        }
    }
    else if (txtMedia.getText().equals("")) {
        if (txtAc1Note.getText().equals("") || txtAc2Note.getText().equals("") || txtAfNote.getText().equals("") || txtSubNote.getText().equals("") || txtAgNote.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Só é permitido deixar um campo vazio nas notas, incluindo a média!");
            chkNote = false;
        }     
        else {
            campoVazio = "Media";
        }
    }


}
    
private void ClearData() {
    txtAc1Note.setText("");
    txtAc1Multiplier.setText("");
    txtAc2Note.setText("");
    txtAc2Multiplier.setText("");
    txtAfNote.setText("");
    txtAfMultiplier.setText("");
    txtSubNote.setText("");
    txtSubMultiplier.setText("");
    txtAgNote.setText("");
    txtAgMultiplier.setText("");
    cbxMatter.removeAllItems();
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblMatter = new javax.swing.JLabel();
        cbxMatter = new javax.swing.JComboBox<>();
        btnBuscarMaterias = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnLimpar = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        btnBuscarNotas = new javax.swing.JButton();
        txtAc1Multiplier = new javax.swing.JTextField();
        lblNotas = new javax.swing.JLabel();
        lblPesos = new javax.swing.JLabel();
        txtAc1Note = new javax.swing.JTextField();
        txtAfNote = new javax.swing.JTextField();
        txtAc2Multiplier = new javax.swing.JTextField();
        txtAc2Note = new javax.swing.JTextField();
        txtAfMultiplier = new javax.swing.JTextField();
        txtAgNote = new javax.swing.JTextField();
        txtSubMultiplier = new javax.swing.JTextField();
        txtSubNote = new javax.swing.JTextField();
        txtAgMultiplier = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMedia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Matéria"));
        jPanel1.setName("Buscar Serviço"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMatter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMatter.setText("Matéria:");

        btnBuscarMaterias.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscarMaterias.setText("BUSCAR MATÉRIAS");
        btnBuscarMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMateriasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblMatter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxMatter, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscarMaterias)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMatter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatter))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnCalcular.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCalcular.setText("CALCULAR");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnBuscarNotas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscarNotas.setText("BUSCAR NOTAS");
        btnBuscarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNotasActionPerformed(evt);
            }
        });

        lblNotas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNotas.setText("Notas:");

        lblPesos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPesos.setText("Pesos:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("AC1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("AC2");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("AF");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("SUB");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("AG");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("MÉDIA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel1)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel2)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel3)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel4)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPesos)
                                    .addComponent(lblNotas))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtAc1Multiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtAc2Multiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtAc1Note, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtAc2Note, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btnBuscarNotas)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtAfNote, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAfMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSubNote, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSubMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAgMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAgNote, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(txtMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel6)))))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNotas)
                            .addComponent(txtAc1Note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAfNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAc2Note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAgNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAc1Multiplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPesos)
                            .addComponent(txtAc2Multiplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAfMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAgMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMateriasActionPerformed
       SearchMatter();
    }//GEN-LAST:event_btnBuscarMateriasActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        ClearData();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        boolean chkNote = true;
        boolean chkPeso = true;
        chkCamposNotas(chkNote);
        chkCamposPesos(chkPeso);
        if (chkNote) {
            if (chkPeso) {
                Calculate(campoVazio);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Só é permitido deixar um campo vazio nas notas, incluindo a média!");
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnBuscarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNotasActionPerformed
        SearchGrades();
    }//GEN-LAST:event_btnBuscarNotasActionPerformed

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
            java.util.logging.Logger.getLogger(MatterSearchPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatterSearchPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatterSearchPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatterSearchPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MatterSearchPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarMaterias;
    private javax.swing.JButton btnBuscarNotas;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cbxMatter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblMatter;
    private javax.swing.JLabel lblNotas;
    private javax.swing.JLabel lblPesos;
    private javax.swing.JTextField txtAc1Multiplier;
    private javax.swing.JTextField txtAc1Note;
    private javax.swing.JTextField txtAc2Multiplier;
    private javax.swing.JTextField txtAc2Note;
    private javax.swing.JTextField txtAfMultiplier;
    private javax.swing.JTextField txtAfNote;
    private javax.swing.JTextField txtAgMultiplier;
    private javax.swing.JTextField txtAgNote;
    private javax.swing.JTextField txtMedia;
    private javax.swing.JTextField txtSubMultiplier;
    private javax.swing.JTextField txtSubNote;
    // End of variables declaration//GEN-END:variables
}
