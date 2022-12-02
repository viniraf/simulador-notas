/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.CustomMenuItems;

import Connection.MySQL;
import View.Login.StudentLoginPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class MatterSearch extends javax.swing.JPanel {
    
    MySQL conectar = new MySQL();
    String campoVazio = "";

    /**
     * Creates new form ProviderRegister
     */
    public MatterSearch() {
        initComponents();
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
            txtAfNote.setText(this.conectar.getResultSet().getString(5));
            txtAfMultiplier.setText(this.conectar.getResultSet().getString(6));
            txtSubNote.setText(this.conectar.getResultSet().getString(7));
            txtSubMultiplier.setText(this.conectar.getResultSet().getString(8));
            txtAgNote.setText(this.conectar.getResultSet().getString(9));
            txtAgMultiplier.setText(this.conectar.getResultSet().getString(10));
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
                    note = ((Float.parseFloat(txtMedia.getText())*somaPesos) - (Float.parseFloat(txtAc2Note.getText())*Float.parseFloat(txtAc2Multiplier.getText())) - (Float.parseFloat(txtAfNote.getText())*Float.parseFloat(txtAfMultiplier.getText())) - (Float.parseFloat(txtSubNote.getText())*Float.parseFloat(txtSubMultiplier.getText())) - (Float.parseFloat(txtAgNote.getText())*Float.parseFloat(txtAgMultiplier.getText()))) / Float.parseFloat(txtAc1Multiplier.getText());
                    txtAc1Note.setText(Float.toString(note));
                    break;
                        
                case "Ac2Note":
                    note = ((Float.parseFloat(txtMedia.getText())*somaPesos) - (Float.parseFloat(txtAc1Note.getText())*Float.parseFloat(txtAc1Multiplier.getText())) - (Float.parseFloat(txtAfNote.getText())*Float.parseFloat(txtAfMultiplier.getText())) - (Float.parseFloat(txtSubNote.getText())*Float.parseFloat(txtSubMultiplier.getText())) - (Float.parseFloat(txtAgNote.getText())*Float.parseFloat(txtAgMultiplier.getText()))) / Float.parseFloat(txtAc2Multiplier.getText());
                    txtAc2Note.setText(Float.toString(note));
                    break;
                    
                case "AfNote":
                    note = ((Float.parseFloat(txtMedia.getText())*somaPesos) - (Float.parseFloat(txtAc1Note.getText())*Float.parseFloat(txtAc1Multiplier.getText())) - (Float.parseFloat(txtAc2Note.getText())*Float.parseFloat(txtAc2Multiplier.getText())) - (Float.parseFloat(txtSubNote.getText())*Float.parseFloat(txtSubMultiplier.getText())) - (Float.parseFloat(txtAgNote.getText())*Float.parseFloat(txtAgMultiplier.getText()))) / Float.parseFloat(txtAfMultiplier.getText());
                    txtAfNote.setText(Float.toString(note));
                    break;
                
                case "SubNote":
                    note = ((Float.parseFloat(txtMedia.getText())*somaPesos) - (Float.parseFloat(txtAc1Note.getText())*Float.parseFloat(txtAc1Multiplier.getText())) - (Float.parseFloat(txtAc2Note.getText())*Float.parseFloat(txtAc2Multiplier.getText())) - (Float.parseFloat(txtAfNote.getText())*Float.parseFloat(txtAfMultiplier.getText())) - (Float.parseFloat(txtAgNote.getText())*Float.parseFloat(txtAgMultiplier.getText()))) / Float.parseFloat(txtSubMultiplier.getText());
                    txtSubNote.setText(Float.toString(note));
                    break;
                    
                case "AgNote":
                    note = ((Float.parseFloat(txtMedia.getText())*somaPesos) - (Float.parseFloat(txtAc1Note.getText())*Float.parseFloat(txtAc1Multiplier.getText())) - (Float.parseFloat(txtAc2Note.getText())*Float.parseFloat(txtAc2Multiplier.getText())) - (Float.parseFloat(txtAfNote.getText())*Float.parseFloat(txtAfMultiplier.getText())) - (Float.parseFloat(txtSubNote.getText())*Float.parseFloat(txtSubMultiplier.getText()))) / Float.parseFloat(txtAgMultiplier.getText());
                    txtAgNote.setText(Float.toString(note));
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
            + "noteAc2 = " + Float.parseFloat(txtAc2Note.getText()) + ","
            + "noteAf = " + Float.parseFloat(txtAfNote.getText()) + ","
            + "noteSub = " + Float.parseFloat(txtSubNote.getText()) + ","
            + "noteAg = " + Float.parseFloat(txtAgNote.getText()) + ","
            + "ac1Multiplier = " + Float.parseFloat(txtAc1Multiplier.getText()) + ","
            + "ac2Multiplier = " + Float.parseFloat(txtAc2Multiplier.getText()) + ","
            + "afMultiplier = " + Float.parseFloat(txtAfMultiplier.getText()) + ","
            + "subMultiplier = " + Float.parseFloat(txtSubMultiplier.getText()) + ","
            + "agMultiplier = " + Float.parseFloat(txtAgMultiplier.getText()) + ""
            + " WHERE idStudent = " + consultaId + " and nameMatter = '" + cbxMatter.getSelectedItem() + "';"
            );
            JOptionPane.showMessageDialog(null, "Calculado com sucesso!");
            } catch (Exception e) {
            System.out.println("Erro ao calcular: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao calcular!");
        
        } finally {
            this.conectar.fechaBanco();
    }
    }

private boolean chkCamposPesos () {
    boolean chkPesos = true;
    if (txtAc1Multiplier.getText().equals("") || txtAc2Multiplier.getText().equals("") || txtAfMultiplier.getText().equals("") || txtSubMultiplier.getText().equals("") || txtAgMultiplier.getText().equals("")) {
        chkPesos = false;
    }
    return chkPesos;
}

private boolean chkCamposNotas() {
    boolean chkNote = true;
    if (txtAc1Note.getText().equals("")) {
        if (txtAc2Note.getText().equals("") || txtAfNote.getText().equals("") || txtSubNote.getText().equals("") || txtAgNote.getText().equals("") || txtMedia.getText().equals("")) {
            chkNote = false;
        }
        else {
            campoVazio = "Ac1Note";
        }
    }
    else if (txtAc2Note.getText().equals("")){
        if (txtAc1Note.getText().equals("") || txtAfNote.getText().equals("") || txtSubNote.getText().equals("") || txtAgNote.getText().equals("") || txtMedia.getText().equals("")) {
            chkNote = false;
        }
        else {
            campoVazio = "Ac2Note";
        }
    }
    else if (txtAfNote.getText().equals("")) {
        if (txtAc1Note.getText().equals("") || txtAc2Note.getText().equals("") || txtSubNote.getText().equals("") || txtAgNote.getText().equals("") || txtMedia.getText().equals("")) {
            chkNote = false;
        }
        else {
            campoVazio = "AfNote";
        }
    }
    else if (txtSubNote.getText().equals("")) {
        if (txtAc1Note.getText().equals("") || txtAc2Note.getText().equals("") || txtAfNote.getText().equals("") || txtAgNote.getText().equals("") || txtMedia.getText().equals("")) {
            chkNote = false;
        }        
        else {
            campoVazio = "SubNote";
        }
    }
    else if (txtAgNote.getText().equals("")) {
        if (txtAc1Note.getText().equals("") || txtAc2Note.getText().equals("") || txtAfNote.getText().equals("") || txtSubNote.getText().equals("") || txtMedia.getText().equals("")) {
            chkNote = false;
        }     
        else {
            campoVazio = "AgNote";
        }
    }
    else if (txtMedia.getText().equals("")) {
        if (txtAc1Note.getText().equals("") || txtAc2Note.getText().equals("") || txtAfNote.getText().equals("") || txtSubNote.getText().equals("") || txtAgNote.getText().equals("")) {
            chkNote = false;
        }     
        else {
            campoVazio = "Media";
        }
    }
        return chkNote;
}
    
private void ClearData2() {
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
    txtMedia.setText("");
    cbxMatter.removeAllItems();
}

    private void DeleteMatter() {
        int consultaId = StudentLoginPanel.studentId;
        this.conectar.conectaBanco();
        String deleteMatter = this.cbxMatter.getSelectedItem().toString();
        
        try {
            this.conectar.updateSQL(
            "DELETE FROM grades "
                    + "WHERE idStudent = " + consultaId + " AND nameMatter = '" + deleteMatter + "';"
            );
            JOptionPane.showMessageDialog(null, "Matéria removida!");
        } catch (Exception e) {
            System.out.println("Erro ao deletar matéria: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao deletar matéria!");
        
        } finally {
            ClearData2();
            this.conectar.fechaBanco();     
    }
        
    }        


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarMaterias = new javax.swing.JButton();
        cbxMatter = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAc1Note = new javax.swing.JTextField();
        txtAc2Note = new javax.swing.JTextField();
        txtAfNote = new javax.swing.JTextField();
        txtAgNote = new javax.swing.JTextField();
        txtSubNote = new javax.swing.JTextField();
        txtAc2Multiplier = new javax.swing.JTextField();
        txtSubMultiplier = new javax.swing.JTextField();
        txtAc1Multiplier = new javax.swing.JTextField();
        txtAfMultiplier = new javax.swing.JTextField();
        txtAgMultiplier = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnBuscarNotas = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtMedia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setForeground(new java.awt.Color(102, 102, 102));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Consulta de notas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Busca matéria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setText("Matéria");
        jLabel1.setToolTipText("");

        btnBuscarMaterias.setText("BUSCAR MATÉRIAS");
        btnBuscarMaterias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(cbxMatter, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(btnBuscarMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel1)))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxMatter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnBuscarMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Notas da matéria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel6.setText("Notas");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setText("Pesos");

        jLabel3.setText("AC1");

        jLabel4.setText("AC2");

        jLabel5.setText("AF");

        jLabel7.setText("SUB");

        jLabel8.setText("AG");

        btnBuscarNotas.setText("BUSCAR NOTAS");
        btnBuscarNotas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBuscarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNotasActionPerformed(evt);
            }
        });

        btnCalcular.setText("CALCULAR");
        btnCalcular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnLimpar.setText("LIMPAR");
        btnLimpar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txtMedia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setText("MÉDIA");

        btnDeletar.setText("DELETAR");
        btnDeletar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtAc1Multiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtAc2Multiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtAc1Note, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtAc2Note, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel3)
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel4)))))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtAfNote, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSubNote, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtAfMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSubMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAgNote, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAgMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel5)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel7)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel8))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnBuscarNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtAc1Note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAc2Note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAfNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAgNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtAc1Multiplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAc2Multiplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAfMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAgMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel10.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("© Copyright 2022");

        jLabel11.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("SimulaNotas Software");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel10)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(568, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMateriasActionPerformed
       SearchMatter();
    }//GEN-LAST:event_btnBuscarMateriasActionPerformed

    private void btnBuscarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNotasActionPerformed
        SearchGrades();
    }//GEN-LAST:event_btnBuscarNotasActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
         if (chkCamposNotas()) {
                if (chkCamposPesos()) {
                    Calculate(campoVazio);
            }
                else {
                    JOptionPane.showMessageDialog(null, "Todos os campos de pesos devem ser preenchidos!");
                }
        }
            else {
                JOptionPane.showMessageDialog(null, "Só é permitido deixar um campo vazio nas notas, incluindo a média!");
            }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
       ClearData2();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        if (cbxMatter.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma matéria para deletar!");
        }
        else {
        DeleteMatter();
        }
    }//GEN-LAST:event_btnDeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarMaterias;
    private javax.swing.JButton btnBuscarNotas;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cbxMatter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
