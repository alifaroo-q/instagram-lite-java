import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class LoginPage extends javax.swing.JFrame {

    private javax.swing.JTextField emailTxtBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField passwordTxtBox;
    private javax.swing.JButton proceedBtn;
    private javax.swing.JButton signupBtn;

    public LoginPage() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        emailTxtBox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordTxtBox = new javax.swing.JPasswordField();
        proceedBtn = new javax.swing.JButton();
        signupBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Instagram Lite | Login");
        setBackground(new java.awt.Color(242, 145, 197));
        setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        jLabel2.setText("Email");

        emailTxtBox.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel3.setText("Password");

        passwordTxtBox.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        proceedBtn.setText("Proceed");
        proceedBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proceedBtnMouseClicked(evt);
            }
        });

        signupBtn.setText("Signup");
        signupBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailTxtBox)
                            .addComponent(passwordTxtBox, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(proceedBtn)
                        .addGap(10, 10, 10)
                        .addComponent(signupBtn)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proceedBtn)
                    .addComponent(signupBtn))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }

    private void proceedBtnMouseClicked(java.awt.event.MouseEvent evt) {

        String email = emailTxtBox.getText();
        String password = new String(passwordTxtBox.getPassword());

        ResultSet result;

        Statement db = DatabaseConnection.getInstance("instagram_lite", "root", "ali123");

        String query = String.format("select `email`, `password` from `user_credential` where `email` = '%s'", email);

        String userEmail = null;
        String userPassword = null;

        try {
            result = db.executeQuery(query);
            while (result.next()) {
                userEmail = result.getString("email");
                userPassword = result.getString("password");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        if ( email.equals(userEmail) && password.equals(userPassword) ) {
            JOptionPane.showMessageDialog(null, "Login Successful");
            showPost(email);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Login Failed");
        }
    }

    private void showPost(String userEmail) {
        java.awt.EventQueue.invokeLater(() -> {
            new PostPage(userEmail).setVisible(true);
        });
    }

    private void signupBtnMouseClicked(java.awt.event.MouseEvent evt) {
        java.awt.EventQueue.invokeLater(() -> {
            new SignupPage(this).setVisible(true);
        });
    }

}