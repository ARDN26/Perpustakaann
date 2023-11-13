import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminmenu {
    public static void admin_menu(){
        JFrame adminFrame = new JFrame("PERPUSTAKAAN");
        ImageIcon backgroundImage = new ImageIcon("src/img/112.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 300, 300);

        ImageIcon inputbookicon = new ImageIcon("src/img/book.png");
        ImageIcon inputadminicon = new ImageIcon("src/img/admin.png");
        ImageIcon inputmembericon = new ImageIcon("src/img/member.png");
        ImageIcon inputborrowicon = new ImageIcon("src/img/borrow.png");
        ImageIcon inputreturnicon = new ImageIcon("src/img/return.png");

        JButton inputBukuButton = new JButton("Input Buku",inputbookicon);
        inputBukuButton.setBounds(30, 15, 160, 32);
        inputBukuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputbuku.input_buku();
            }
        });

        JButton melihatBukuButton = new JButton("Melihat Buku");
        melihatBukuButton.setBounds(30, 55, 160, 32);
        melihatBukuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lihatbuku.tampilkan_data_buku();
            }
        });

        JButton peminjamanBukuButton = new JButton("Peminjaman Buku",inputborrowicon);
        peminjamanBukuButton.setBounds(30, 95, 160, 32);
        peminjamanBukuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                peminjamanbuku.peminjaman_buku();
        }
        });
        JButton pengembalianBukuButton = new JButton("Pengembalian Buku");
        pengembalianBukuButton.setBounds(30, 135, 160, 32);
        pengembalianBukuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pengembalianbuku.pengembalian_buku();
            }
        });


        adminFrame.add(inputBukuButton);
        adminFrame.add(melihatBukuButton);
        adminFrame.add(peminjamanBukuButton);
        adminFrame.add(pengembalianBukuButton);
        adminFrame.add(backgroundLabel);

        adminFrame.setSize(900,400);
        adminFrame.setLayout(null);
        adminFrame.setVisible(true);
        adminFrame.setLocationRelativeTo(null);
    }
}