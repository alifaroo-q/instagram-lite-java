import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;

public class SignupPage extends javax.swing.JFrame {

    private javax.swing.JButton Login;
    private javax.swing.JTextField emailTxtBox;
    private javax.swing.JTextField firstNameTxtBox;
    private javax.swing.JTextField lastNameTxtBox;
    private javax.swing.JButton imagePickerBtn;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField passwordTxtBox;
    private javax.swing.JButton proceedBtn;
    private javax.swing.JLabel signupHeading;

    private String profilePicture = null;

    public SignupPage(LoginPage login) {
        initComponents();
        login.setVisible(false);
    }

    private void initComponents() {

        signupHeading = new javax.swing.JLabel();
        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel2 = new javax.swing.JLabel();
        firstNameTxtBox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emailTxtBox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passwordTxtBox = new javax.swing.JPasswordField();
        proceedBtn = new javax.swing.JButton();
        Login = new javax.swing.JButton();
        lastNameTxtBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        imagePickerBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Instagram Lite | Signup");
        setResizable(false);

        signupHeading.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        signupHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signupHeading.setText("Signup");

        jLabel2.setText("First Name");

        firstNameTxtBox.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel3.setText("Last Name");

        jLabel4.setText("Email");

        emailTxtBox.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel5.setText("Password");

        passwordTxtBox.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        proceedBtn.setText("Proceed");
        proceedBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proceedBtnMouseClicked(evt);
            }
        });

        Login.setText("Login");
        Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginMouseClicked(evt);
            }
        });

        jLabel1.setText("Avatar");

        imagePickerBtn.setText("Pick Image");
        imagePickerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagePickerBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(proceedBtn)
                .addGap(10, 10, 10)
                .addComponent(Login)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(signupHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameTxtBox, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                            .addComponent(emailTxtBox)
                            .addComponent(passwordTxtBox)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameTxtBox))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(imagePickerBtn))
                        .addGap(0, 0, 0))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(signupHeading)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstNameTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagePickerBtn)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proceedBtn)
                    .addComponent(Login))
                .addGap(25, 25, 25))
        );

        pack();
    }

    private void imagePickerBtnMouseClicked(java.awt.event.MouseEvent evt){

        int status = jFileChooser1.showDialog(this, imagePickerBtn.getName());

        if (status == JFileChooser.APPROVE_OPTION) {
            String temp = jFileChooser1.getSelectedFile().getAbsolutePath();
            profilePicture = temp.replace("\\", "\\\\");
            JOptionPane.showMessageDialog(null, "Picture selected");
        } else {
            JOptionPane.showMessageDialog(null, "Picture not selected");
        }
    }

    private void proceedBtnMouseClicked(java.awt.event.MouseEvent evt) {

        String firstName = firstNameTxtBox.getText();
        String lastName = lastNameTxtBox.getText();
        String email = emailTxtBox.getText();
        String password = new String(passwordTxtBox.getPassword());

        Statement db = DatabaseConnection.getInstance("instagram_lite", "root", "ali123");

        String values = String.format("'%s', '%s', '%s'", firstName, lastName, email);
        String query = String.format("insert into `user` (`firstName`, `lastName`, `email`) value (%s)", values);

        String passwordQuery = String.format("insert into `user_credential` value ('%s', '%s')", password, email);
        String pictureQuery = String.format("insert into `profile_picture` value ('%s', '%s')", profilePicture, email);

        System.out.println(pictureQuery);

        try {
            db.executeUpdate(query);
            db.executeUpdate(passwordQuery);
            db.executeUpdate(pictureQuery);
            JOptionPane.showMessageDialog(null, "Signup Successful", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        firstNameTxtBox.setText("");
        lastNameTxtBox.setText("");
        emailTxtBox.setText("");
        passwordTxtBox.setText("");
    }

    private void LoginMouseClicked(java.awt.event.MouseEvent evt) {
        java.awt.EventQueue.invokeLater(() -> {
            this.setVisible(false);
            new LoginPage().setVisible(true);
        });
    }
}