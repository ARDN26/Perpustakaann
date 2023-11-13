import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class pengembalianbuku {
    public static void pengembalian_buku() {
        JFrame pengembalianBukuFrame = new JFrame("Pengembalian Buku");
        ImageIcon backgroundImage = new ImageIcon("src/img/cream.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 650, 450);

        JLabel labelKodeBuku, labelIdAnggota, labelTglKembali;

        labelKodeBuku = new JLabel("Kode Buku:");
        labelKodeBuku.setBounds(30, 15, 100, 30);

        labelIdAnggota = new JLabel("ID Anggota:");
        labelIdAnggota.setBounds(30, 55, 100, 30);

        labelTglKembali = new JLabel("Tgl Kembali:");
        labelTglKembali.setBounds(30, 95, 100, 30);

        JTextField kdBukuField, idAnggotaField, tglKembaliField;

        kdBukuField = new JTextField();
        kdBukuField.setBounds(130, 15, 200, 30);

        idAnggotaField = new JTextField();
        idAnggotaField.setBounds(130, 55, 200, 30);

        tglKembaliField = new JTextField();
        tglKembaliField.setBounds(130, 95, 200, 30);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(130, 135, 100, 25);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kdbuku = kdBukuField.getText();
                String idanggota = idAnggotaField.getText();
                String tglkembali = tglKembaliField.getText();

                Connection connection = Koneksi.connect();
                if (connection != null) {
                    try {
                        Statement stmt = connection.createStatement();
                        String insertQuery = "INSERT INTO pengembalian_buku ( kdbuku, idanggota, tglkembali) VALUES ('" + kdbuku + "', '" + idanggota + "', '" + tglkembali + "')";
                        int rowsAffected = stmt.executeUpdate(insertQuery);
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(pengembalianBukuFrame, "Data Pengembalian Buku berhasil ditambahkan.");
                        } else {
                            JOptionPane.showMessageDialog(pengembalianBukuFrame, "Gagal menambahkan data Pengembalian Buku.");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(pengembalianBukuFrame, "Terjadi kesalahan: " + ex.getMessage());
                    }
                }
            }
        });

        pengembalianBukuFrame.add(labelKodeBuku);
        pengembalianBukuFrame.add(kdBukuField);
        pengembalianBukuFrame.add(labelIdAnggota);
        pengembalianBukuFrame.add(idAnggotaField);
        pengembalianBukuFrame.add(labelTglKembali);
        pengembalianBukuFrame.add(tglKembaliField);
        pengembalianBukuFrame.add(submitButton);
        pengembalianBukuFrame.add(backgroundLabel);

        pengembalianBukuFrame.setSize(400, 300);
        pengembalianBukuFrame.setLayout(null);
        pengembalianBukuFrame.setVisible(true);
        pengembalianBukuFrame.setLocationRelativeTo(null);
    }
}