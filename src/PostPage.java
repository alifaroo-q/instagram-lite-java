import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostPage extends javax.swing.JFrame {

    private ProfilePanel profilePicture;
    private javax.swing.JButton addPostBtn;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel name;
    private javax.swing.JTextPane postArea;
    private javax.swing.JButton refreshProfile;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel noOfLikes;
    private javax.swing.JLabel noOfPost;
    private javax.swing.JLabel postLabel;
    private javax.swing.JScrollPane postSection;
    private javax.swing.JPanel profileSection;
    private javax.swing.JPanel statSection;

    private final String userEmail;
    private String profilePic;

    String firstName = null, lastName = null;
    int totalLikes = 0, totalPost = 0;
    StringBuilder allPosts = null;

    public PostPage(String userEmail) {
        this.userEmail = userEmail;
        loadProfile();
        initComponents();
    }

    public void initComponents() {
        profilePicture = new ProfilePanel(profilePic);
        profileSection = new javax.swing.JPanel();
        statSection = new javax.swing.JPanel();
        noOfPost = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        noOfLikes = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        postLabel = new javax.swing.JLabel();
        postSection = new javax.swing.JScrollPane();
        postArea = new javax.swing.JTextPane();
        addPostBtn = new javax.swing.JButton();
        refreshProfile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Instagram Lite | Profile");
        setResizable(false);
        //setResizable(false);

        profileSection.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        profileSection.setPreferredSize(new java.awt.Dimension(4000, 204));

        statSection.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.lightGray));

        noOfPost.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        noOfPost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noOfPost.setText("0");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Posts");

        noOfLikes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        noOfLikes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noOfLikes.setText("0");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Likes");

        javax.swing.GroupLayout statSectionLayout = new javax.swing.GroupLayout(statSection);
        statSection.setLayout(statSectionLayout);
        statSectionLayout.setHorizontalGroup(
            statSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statSectionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(statSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noOfPost, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(statSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noOfLikes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        statSectionLayout.setVerticalGroup(
            statSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statSectionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(statSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noOfPost)
                    .addComponent(noOfLikes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10))
        );

        name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("loading...");

        javax.swing.GroupLayout profilePictureLayout = new javax.swing.GroupLayout(profilePicture);
        profilePicture.setLayout(profilePictureLayout);
        profilePictureLayout.setHorizontalGroup(
            profilePictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        profilePictureLayout.setVerticalGroup(
            profilePictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout profileSectionLayout = new javax.swing.GroupLayout(profileSection);
        profileSection.setLayout(profileSectionLayout);
        profileSectionLayout.setHorizontalGroup(
            profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileSectionLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profileSectionLayout.createSequentialGroup()
                        .addComponent(name)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(profileSectionLayout.createSequentialGroup()
                        .addComponent(profilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(statSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        profileSectionLayout.setVerticalGroup(
            profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileSectionLayout.createSequentialGroup()
                .addGroup(profileSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profileSectionLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(statSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(profileSectionLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(profilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileSectionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(profilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        emailLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emailLabel.setText("loading...");

        postLabel.setText("Posts");

        postArea.setEditable(false);
        postArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        postArea.setToolTipText("");
        postSection.setViewportView(postArea);

        addPostBtn.setText("Add Post");
        addPostBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPostBtnMouseClicked(evt);
            }
        });

        refreshProfile.setText("refresh");
        refreshProfile.setFocusPainted(false);
        refreshProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshProfileMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(postLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(addPostBtn))
                            .addComponent(postSection, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profileSection, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(emailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refreshProfile)))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(refreshProfile))
                .addGap(7, 7, 7)
                .addComponent(profileSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(postLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postSection, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addPostBtn)
                .addGap(15, 15, 15))
        );

        emailLabel.setText(userEmail);
        name.setText(firstName + " " + lastName);
        noOfLikes.setText(Integer.toString(totalLikes));
        noOfPost.setText(Integer.toString(totalPost));

        postArea.setText(allPosts.toString());

        pack();
    }

    public void loadProfile() {

        ResultSet result;
        Statement db = DatabaseConnection.getInstance("instagram_lite", "root", "ali123");

        String query = String.format(
                "select `firstName`, `lastName`, `image_path` from `user` join `profile_picture` on " +
                "`user`.`email` = `profile_picture`.`email` where `user`.`email` = '%s'", userEmail
        );

        String likeQuery = String.format("select sum(`numberOfLikes`) as `likes` from `post` " +
                "join `like` on `post`.`id` = `like`.`post_id` where `email` = '%s'", userEmail
        );

        String postQuery = String.format("select count(*) as `posts` from `post` " +
                "join `like` on `post`.`id` = `like`.`post_id` where email = '%s'", userEmail
        );

        String allPostQuery = String.format("select `post`.`id`, `title`, `description` from `post` " +
                "join `user` on `post`.`email` = `user`.`email` where `user`.`email` = '%s'", userEmail
        );

        try {
            result = db.executeQuery(query);
            while (result.next()) {
                firstName = result.getString("firstName");
                lastName = result.getString("lastName");
                profilePic = result.getString("image_path").replace("\\", "\\\\");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {
            result = db.executeQuery(likeQuery);
            while (result.next()) {
                 totalLikes = result.getInt("likes");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {
            result = db.executeQuery(postQuery);
            while (result.next()) {
                totalPost = result.getInt("posts");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {

            String title = null, description = null;
            int postId;
            allPosts = new StringBuilder();

            result = db.executeQuery(allPostQuery);
            while (result.next()) {
                postId = result.getInt("id");
                title = result.getString("title");
                description = result.getString("description");
                allPosts.append("Post ID: ").append(postId).append("\nTitle: ").append(title).append("\nDescription: ").append(description).append("\n\n");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private void addPostBtnMouseClicked(java.awt.event.MouseEvent evt) {
        java.awt.EventQueue.invokeLater(() -> {
            new PostFactory(userEmail).setVisible(true);
        });
    }

    private void refreshProfileMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> {
            new PostPage(userEmail).setVisible(true);
        });
    }
}