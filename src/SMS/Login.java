package SMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton Login,cancel;          // declare buttons globbaly to use them in whole class
    JPasswordField password_1;
    JTextField user_name_1;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        //we use jlabel to write anything on jframe
        setLayout(null);
        JLabel username1=new JLabel("Username");
        username1.setBounds(40,20,100,20);                     //setting location and bounds usernmane on jframe
        add(username1);

        //getting input
        user_name_1=new JTextField();
        user_name_1.setBounds(150,20,150,20);
        add(user_name_1);

        JLabel password1=new JLabel("Password");
        password1.setBounds(40,70,100,20);                     //setting location and bounds usernmane on jframe
        add(password1);


         password_1=new JPasswordField();
        password_1.setBounds(150,70,150,20);
        add(password_1);

        //now creating buttons

        Login=new JButton("Login");
        Login.setBounds(40,140,120,30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        Login.setFont(new Font("Tahoma",Font.BOLD,15));                  //takes font class object
        add(Login);

        cancel=new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);                // when u click cancel , control goes to action lister constructer
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));                  //takes font class object
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(350,0,200,200);
        add(img);


        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Login){
            String username=user_name_1.getText();   // to get text from text field we use gettext()
            String password=password_1.getText();
            // creating table in database and now getting taht
            String quiry="select * from login where username='"+username+"'and password='"+password+"'";

            // now executing that quiry
            try {
                Connections c=new Connections();
                ResultSet rs=c.s.executeQuery(quiry);

                if(rs.next()) {
                    this.dispose();                 // means rs is not empty and pass is true
                    new project();                     // will execute project class with menus
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }
            }catch (Exception ae){
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==cancel){
            setVisible(false);
        }
    }
}
