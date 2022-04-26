package tugas4praktikumpbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame{
    JLabel lUsername = new JLabel("Username : ");
    JTextField fUsername = new JTextField (20);
    JLabel lPassword = new JLabel ("Password : ");
    JPasswordField fPassword = new JPasswordField(10);
    JButton bLogin = new JButton("Login");
    JLabel lRegUser = new JLabel ("Username : ");
    JTextField fRegUser = new JTextField (20);
    JLabel lRegPass = new JLabel ("Password : ");
    JPasswordField fRegPass = new JPasswordField (10);
    JButton bRegister = new JButton ("Register");
    
    public GUI(){
        setVisible(true);
        setTitle("");
        setSize(600,230);
        setLayout(null);
        
        add(lUsername);
        add(fUsername);
        add(lPassword);
        add(fPassword);
        add(bLogin);
        
        add(lRegUser);
        add(fRegUser);
        add(lRegPass);
        add(fRegPass);
        add(bRegister);
        
        lUsername.setBounds(30, 40, 100,30);
        fUsername.setBounds(120,40,100,30);
        lPassword.setBounds(30,80,100,30);
        fPassword.setBounds(120,80,100,30);
        bLogin.setBounds(120,150,90,20);
        
        lRegUser.setBounds(270,40,100,30);
        fRegUser.setBounds(340,40,100,30);
        lRegPass.setBounds(270,80,100,30);
        fRegPass.setBounds(340,80,100,30);
        bRegister.setBounds(340,150,90,20);
        
        bLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Connector conn = new Connector();
                String user = fUsername.getText();
                System.out.println(user);
                if (conn.checkUsername(user) && user != "" && conn.checkLogin(user, String.valueOf(fPassword.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Login Sukses!");
                }
                else if (user.isEmpty() || String.valueOf(fPassword.getPassword()).isEmpty()) { //error handling
                    JOptionPane.showMessageDialog(null, "Jangan Kosong!");
                }
                else if (!conn.checkUsername(user)) {
                    JOptionPane.showMessageDialog(null, "Username Salah!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Password Salah!");
                }
                
            }
            
        });
        bRegister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Connector conn = new Connector();
                String reguser = fRegUser.getText();
                String regpass = String.valueOf(fRegPass.getPassword());
                if (!reguser.isEmpty() && !regpass.isEmpty()) {
                    conn.masukData(reguser,regpass);
                    JOptionPane.showMessageDialog(null, "Register Sukses!");
                }
                else if (reguser.isEmpty() || regpass.isEmpty()) { //error handling
                    JOptionPane.showMessageDialog(null, "Jangan Kosong!");
                }
            }
        });
    }
    
}