/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.ui;

import Login.LoginKasir;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp
 */
public class Kasir extends javax.swing.JFrame {

    public String menu_barang;
    public StringTokenizer token;
    public String ganti = "";
    DefaultTableModel table = new DefaultTableModel();
     
    
     double totalHarga;
     double dataTotal;
    
    DefaultTableModel model;
    DefaultTableModel dataModel;
    
    public long harga_barang;
    double  nama, harga, jmlhjual,total;
    int a=0;
    

    public Kasir() {
        initComponents();
        setLocationRelativeTo(null);
        Koneksi conn = new Koneksi();
        Koneksi.getKoneksi();
         
        Tabel_barang.setModel(table);
        table.addColumn("No");
        table.addColumn("Nama Barang");
        table.addColumn("Harga");
        table.addColumn("Jumlah");
        table.addColumn("Total");
        model = (DefaultTableModel) Tabel_barang.getModel();
        //remove
        model.getDataVector().removeAllElements();
        revalidate(); 
        selectBarang();
    
    }
    
    
    private void sumTotal(){
        dataModel = (DefaultTableModel) Tabel_barang.getModel();
        int jumlah = dataModel.getRowCount();
        double totalHarga = 0;
       
        for (int i =0; i < jumlah; i++){
        double dataTotal= Double.valueOf(dataModel.getValueAt(i, 4).toString());
        totalHarga += dataTotal;
        
        //txtTagihan ke satuan rupiah
        double angka = totalHarga ;
        ganti = NumberFormat.getNumberInstance(Locale.US).format(angka);
        token = new StringTokenizer(ganti, ".");
        ganti = token.nextToken();
        ganti = ganti.replace(',', '.');
        Tagihan.setText(String.valueOf("Rp"+ganti));
    }
        Harga.setText("");
        
        Float Tagihan = (float)totalHarga;
        
        if(Tagihan >=5000000 ){
            float diskon = (Tagihan * 15)/100;
            float d = Tagihan - diskon;
            Diskon.setText(String.valueOf("15"));
            Rp.setText(String.valueOf(diskon));
            Total_Harga.setText(String.valueOf(d));
        }else if (Tagihan>=3000000){
            float diskon = (Tagihan * 5)/100;
            float d = Tagihan - diskon;
            Diskon.setText(String.valueOf("5"));
            Rp.setText(String.valueOf(diskon));
            Total_Harga.setText(String.valueOf(d));
        }else {
            
            Total_Harga.setText(String.valueOf(Tagihan));

    }
    }

     private void btnTambah(){
        
        //mengeksekusi isi tabel
        a=a+1;
        jmlhjual=Float.parseFloat(Jumlah.getText().toString());
        harga =Float.parseFloat(Harga.getText());
        total=(double)(jmlhjual*harga);
        model.insertRow(model.getRowCount(), new Object[]{String.valueOf(a),menu_barang,Harga.getText(),Jumlah.getText().toString(),String.valueOf(total)});
        }
        
    private void btnHapus(){
        ((DefaultTableModel)Tabel_barang.getModel()).setNumRows(0);
        
        id.setText("");
        Tagihan.setText("");
        Total_Harga.setText("");
        Bayar.setText("");
        Kembalian.setText("");
    }
    
    public void selectBarang(){
        try{
            Connection con = Koneksi.getKoneksi();
            Statement stm = con.createStatement();
            String query = "Select nama_barang from barang";
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Barang.addItem(rs.getString("nama_barang"));
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }

private void inputData(){
  try {
            Connection con = Koneksi.getKoneksi();
            Statement stm = con.createStatement();
            
            String query = "INSERT INTO `penjualan` (id_transaksi, nama_barang,harga, quantity) "
                     + "VALUES ('"+id.getText()+
                            "', '"+Barang.getSelectedItem()+
                            "', '"+Harga.getText()+
                            "', '"+Jumlah.getText()+
                            "')";    
            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan", "Yeay Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Harga = new javax.swing.JTextField();
        BtnAdd = new javax.swing.JButton();
        Tagihan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel_barang = new javax.swing.JTable();
        Total_Harga = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Bayar = new javax.swing.JTextField();
        rdb1 = new javax.swing.JRadioButton();
        rdb2 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        Kembalian = new javax.swing.JTextField();
        Hitung = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Barang = new javax.swing.JComboBox<>();
        Jumlah = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Diskon = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Rp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TRANSAKSI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(252, 252, 252))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Nama Barang");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Harga");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Jumlah");

        Harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HargaActionPerformed(evt);
            }
        });

        BtnAdd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BtnAdd.setText("ADD");
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });

        Tagihan.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        Tagihan.setForeground(new java.awt.Color(0, 0, 153));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Tagihan");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Data Penjualan");

        Tabel_barang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Tabel_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabel_barang);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Total Harga");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Bayar");

        Bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BayarActionPerformed(evt);
            }
        });

        rdb1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rdb1.setText("100.000");
        rdb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb1ActionPerformed(evt);
            }
        });

        rdb2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rdb2.setText("1.000.000");
        rdb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Kembalian");

        Hitung.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Hitung.setText("Hitung");
        Hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HitungActionPerformed(evt);
            }
        });

        Hapus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Hapus.setText("Clear");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Barang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Barang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Menu Pilihan" }));
        Barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarangActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Diskon");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("%  = Rp");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("INPUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Id Transaksi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10)
                                    .addComponent(jButton4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Total_Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Diskon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Rp)))
                                        .addGap(54, 54, 54)
                                        .addComponent(jLabel8)
                                        .addGap(49, 49, 49)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rdb1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(rdb2))
                                            .addComponent(Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(Kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Hitung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addGap(21, 21, 21))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addGap(67, 67, 67)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(58, 58, 58)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Barang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(id, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(Harga, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(Tagihan, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(Harga, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnAdd)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Tagihan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hitung)
                    .addComponent(jLabel10)
                    .addComponent(Diskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(Rp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdb1)
                    .addComponent(rdb2)
                    .addComponent(jLabel7)
                    .addComponent(Total_Harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hapus)
                    .addComponent(jButton4))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        inputData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarangActionPerformed
        // TODO add your handling code here:
        menu_barang = (String) Barang.getSelectedItem();
        switch(menu_barang){
        case "Paku 10 cm":
            Harga.setText(String.valueOf("1500"));
            break;
        case "Paku 8 cm":
            Harga.setText(String.valueOf("1300"));
            break;
        case "Paku 5 cm":
            Harga.setText(String.valueOf("1000"));
            break;
        case "Paku 3 cm":
            Harga.setText(String.valueOf("800"));
            break;
        case "Paku 2 cm":
            Harga.setText(String.valueOf("500"));
            break;
        case "Besi 20 mm":
            Harga.setText(String.valueOf("45000"));
            break;
        case "Besi 16 mm":
            Harga.setText(String.valueOf("40000"));
            break;
        case "Besi 13 mm":
            Harga.setText(String.valueOf("38000"));
            break;
        case "Besi 10 mm":
            Harga.setText(String.valueOf("35000"));
            break;   
        case "Besi 5 mm":
            Harga.setText(String.valueOf("30000"));
            break; 
        case "Semen Holcim":
            Harga.setText(String.valueOf("85000"));
            break;
        case "Semen Tiga Roda":
            Harga.setText(String.valueOf("90000"));
            break;
        case "Semen Gresik":
            Harga.setText(String.valueOf("87000"));
            break;
        case "Semen Padang":
            Harga.setText(String.valueOf("76000"));
            break;
        case "Semen Merah Putih":
            Harga.setText(String.valueOf("88000"));
            break;
        case "Batu bata":
            Harga.setText(String.valueOf("800"));
            break;
        case "Batu Pondasi":
            Harga.setText(String.valueOf("1100"));
            break;
        case "Batu Kumbung":
            Harga.setText(String.valueOf("500"));
            break;
        case "Kawat 8 mm":
            Harga.setText(String.valueOf("43000"));
            break;
        case "Kawat 5 mm":
            Harga.setText(String.valueOf("30000"));
            break;
        case "Kawat 3 mm":
            Harga.setText(String.valueOf("28000"));
            break;
        case "Kawat 2 mm":
            Harga.setText(String.valueOf("25000"));
            break;
        case "Lem Rajawali":
            Harga.setText(String.valueOf("180000"));
            break;
        case "Lem Fox":
            Harga.setText(String.valueOf("21000"));
            break;
        case "Lem PVC":
            Harga.setText(String.valueOf("32000"));
            break;
        case "Lem Power Glue":
            Harga.setText(String.valueOf("25000"));
            break;  
        case "Kayu 4 m":
            Harga.setText(String.valueOf("30000"));
            break;
        case "Kayu 3 m":
            Harga.setText(String.valueOf("28000"));
            break;
        case "Kayu 2 m":
            Harga.setText(String.valueOf("25000"));
            break;
        case "Asbes Plafon":
            Harga.setText(String.valueOf("75000"));
            break;
        case "Asbes Seng Gelombang":
            Harga.setText(String.valueOf("43000"));
            break;
        }

    }//GEN-LAST:event_BarangActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         MenuUtama read = new MenuUtama();
        read.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        // TODO add your handling code here:
        btnHapus();
    }//GEN-LAST:event_HapusActionPerformed

    private void HitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HitungActionPerformed
        // TODO add your handling code here:
        float bayar = Float.parseFloat(Bayar.getText());
        float kembalian = Float.parseFloat(Total_Harga.getText());

        double angka = bayar-kembalian ;
        ganti = NumberFormat.getNumberInstance(Locale.US).format(angka);
        token = new StringTokenizer(ganti, ".");
        ganti = token.nextToken();
        ganti = ganti.replace(',', '.');

        Kembalian.setText(String.valueOf("Rp"+ganti));
    }//GEN-LAST:event_HitungActionPerformed

    private void rdb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb2ActionPerformed
        // TODO add your handling code here:
        if(rdb2.isSelected()){
            Bayar.setText(String.valueOf("1000000"));
        }
    }//GEN-LAST:event_rdb2ActionPerformed

    private void rdb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb1ActionPerformed
        // TODO add your handling code here:
        if(rdb1.isSelected()){
            Bayar.setText(String.valueOf("100000"));
        }
    }//GEN-LAST:event_rdb1ActionPerformed

    private void BayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BayarActionPerformed

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        // TODO add your handling code here:
        btnTambah();
        sumTotal();

        Barang.setSelectedItem("Menu Pilihan");
        Harga.setText("");
        Jumlah.setText("");
    }//GEN-LAST:event_BtnAddActionPerformed

    private void HargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HargaActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_HargaActionPerformed

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
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Barang;
    private javax.swing.JTextField Bayar;
    private javax.swing.JButton BtnAdd;
    private javax.swing.JTextField Diskon;
    private javax.swing.JButton Hapus;
    private javax.swing.JTextField Harga;
    private javax.swing.JButton Hitung;
    private javax.swing.JTextField Jumlah;
    private javax.swing.JTextField Kembalian;
    private javax.swing.JTextField Rp;
    private javax.swing.JTable Tabel_barang;
    private javax.swing.JTextField Tagihan;
    private javax.swing.JTextField Total_Harga;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdb1;
    private javax.swing.JRadioButton rdb2;
    // End of variables declaration//GEN-END:variables
}
