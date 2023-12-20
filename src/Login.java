import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login() {

        setIconImage(Toolkit.getDefaultToolkit().

                getImage("res/logo.png"));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500,500);

        setVisible(true);
        setLayout(new FlowLayout());

        setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("아이디 :  ");
        nameField = new JTextField(10);

        JLabel passwordLabel = new JLabel("비밀번호:");
        passwordField = new JPasswordField(10);


        loginButton = new JButton("학식 시스템 로그인");
        add(nameLabel);
        add(nameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());

                if ("영양사".equals(name) && "1234".equals(password)) {
                    new CafeteriaMachine();
                } else {
                    JOptionPane.showMessageDialog(null, "인증 실패");
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}