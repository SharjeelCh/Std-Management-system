package SMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SMS.Login;
import com.toedter.calendar.JDateChooser;

public class StudentInfo extends JFrame implements ActionListener {
    JTextField tname,tfname,taddress,tphone,temail,rollno;
    JComboBox course;
    JButton submit,cancel;
    JDateChooser date;

    StudentInfo(){
        setSize(900,700);
        setLocation(350,50);

        setLayout(null);

        JLabel Heading=new JLabel("Student Portfolio");
        Heading.setBounds(310,30,500,50);
        Heading.setFont(new Font("serif",Font.BOLD,30));
        add(Heading);

        // name label and textfield
        JLabel st_name=new JLabel("Name");
        st_name.setBounds(50,150,100,30);
        st_name.setFont(new Font("serif",Font.BOLD,20));
        add(st_name);

        tname=new JTextField();
        tname.setBounds(200,150,150,30);
        add(tname);

        // Fathername label and textfield
        JLabel fa_name=new JLabel("Father's Name");
        fa_name.setBounds(400,150,200,30);
        fa_name.setFont(new Font("serif",Font.BOLD,20));
        add(fa_name);

        tfname=new JTextField();
        tfname.setBounds(600,150,150,30);
        add(tfname);

        //Roll number
        JLabel roll_no=new JLabel("CNIC");
        roll_no.setBounds(50,200,200,30);
        roll_no.setFont(new Font("serif",Font.BOLD,20));
        add(roll_no);

        rollno=new JTextField();
        rollno.setBounds(200,200,150,30);
        rollno.setFont(new Font("serif",Font.BOLD,20));
        add(rollno);

        //dob number
        JLabel doB=new JLabel("Date of Birth");
        doB.setBounds(400,200,200,30);
        doB.setFont(new Font("serif",Font.BOLD,20));
        add(doB);

        date=new JDateChooser();
        date.setBounds(600,200,150,30);
        add(date);

        // adreess label and textfield
        JLabel Adrress=new JLabel("Address");
        Adrress.setBounds(50,250,200,30);
        Adrress.setFont(new Font("serif",Font.BOLD,20));
        add(Adrress);

        taddress=new JTextField();
        taddress.setBounds(200,250,150,30);
        add(taddress);

        // phone label and textfield
        JLabel Phone=new JLabel("Phone no");
        Phone.setBounds(400,250,200,30);
        Phone.setFont(new Font("serif",Font.BOLD,20));
        add(Phone);

        tphone=new JTextField();
        tphone.setBounds(600,250,150,30);
        add(tphone);

        //course
        JLabel Course=new JLabel("Course");
        Course.setBounds(50,300,200,30);
        Course.setFont(new Font("serif",Font.BOLD,20));
        add(Course);

        String C_course[]={"BESE-28","BESE_27","BESE-26","BEIS-3","BEIS-2","BEIS_1"};
        course=new JComboBox(C_course);
        course.setBounds(200,300,150,30);
        add(course);

        //email
        JLabel Email=new JLabel("Email");
        Email.setBounds(400,300,200,30);
        Email.setFont(new Font("serif",Font.BOLD,20));
        add(Email);

        temail=new JTextField();
        temail.setBounds(600,300,150,30);
        add(temail);

        // submission button
        submit=new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);

        //cancel button
        cancel=new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String name=tname.getText();
            String fname=tfname.getText();
            String Rollno=rollno.getText();
            String DOB=((JTextField)date.getDateEditor().getUiComponent()).getText();
            String Address=taddress.getText();
            String Phone=tphone.getText();
            String Email=temail.getText();
            String Course=(String)course.getSelectedItem();
            try{
                String query="insert into student values('"+name+"', '"+fname+"', '"+Rollno+"', '"+DOB+"', '"+Address+"', '"+Phone+"', '"+Email+"', '"+Course+"')";
                Connections c=new Connections();
                c.s.executeUpdate(query);                            // will update the info in database

                JOptionPane.showMessageDialog(null,"Student Informtion Entered Successfully");
                setVisible(false);
            }catch (Exception ae){
                ae.printStackTrace();
            }
        }
        else{
            this.dispose();
        }
    }
}
