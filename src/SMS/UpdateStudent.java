package SMS;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener {
    JTextField taddress,tphone,temail;
    JTextField course;
    JButton submit,cancel;
    JLabel rollno;
    Choice choice;

    UpdateStudent(){
        setSize(900,700);
        setLocation(350,50);

        setLayout(null);

        JLabel Heading=new JLabel("Update Student Details");
        Heading.setBounds(50,30,500,50);
        Heading.setFont(new Font("Tahoma",Font.ITALIC,35));
        add(Heading);

        //serching by cnic to update the student detials

        JLabel rollNo=new JLabel("Search by roll no");
        rollNo.setBounds(50,100,200,20);
        rollNo.setFont(new Font("Tahoma",Font.ITALIC,18));
        add(rollNo);

        choice =new Choice();
        choice.setBounds(250,100,200,20);
        add(choice);

        try {
            Connections c=new Connections();
            ResultSet rs=c.s.executeQuery("select * from student");
            while(rs.next()){
                choice.add(rs.getString("Rollno"));
            }
        }catch (Exception aa){
            aa.printStackTrace();
        }


        // name label and textfield
        JLabel st_name=new JLabel("Name");
        st_name.setBounds(50,150,100,30);
        st_name.setFont(new Font("serif",Font.BOLD,20));
        add(st_name);

        JLabel tname=new JLabel();
        tname.setBounds(200,150,150,30);
        tname.setFont(new Font("serif",Font.PLAIN,18));
        add(tname);

        // Fathername label and textfield
        JLabel fa_name=new JLabel("Father's Name");
        fa_name.setBounds(400,150,200,30);
        fa_name.setFont(new Font("serif",Font.BOLD,20));
        add(fa_name);

        JLabel tfname=new JLabel();
        tfname.setBounds(600,150,150,30);
        tfname.setFont(new Font("serif",Font.PLAIN,18));
        add(tfname);

        //Roll number
        JLabel roll_no=new JLabel("CNIC");
        roll_no.setBounds(50,200,200,30);
        roll_no.setFont(new Font("serif",Font.BOLD,20));
        add(roll_no);

        rollno=new JLabel();
        rollno.setBounds(200,200,150,30);
        rollno.setFont(new Font("serif",Font.PLAIN,18));
        add(rollno);

        //dob number
        JLabel doB=new JLabel("Date of Birth");
        doB.setBounds(400,200,200,30);
        doB.setFont(new Font("serif",Font.BOLD,20));
        add(doB);

        JLabel date=new JLabel();
        date.setBounds(600,200,150,30);
        date.setFont(new Font("serif",Font.PLAIN,18));
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

        course=new JTextField();
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

        try{
            Connections c=new Connections();
            String query="select * from student where Rollno='"+choice.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                rollno.setText(rs.getString("Rollno"));
                date.setText(rs.getString("DOB"));
                taddress.setText(rs.getString("Address"));
                tphone.setText(rs.getString("Phone"));
                temail.setText(rs.getString("Email"));
                course.setText(rs.getString("Course"));
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }

        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Connections c=new Connections();
                    String query="select * from student where Rollno='"+choice.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(query);
                    while(rs.next()){
                        tname.setText(rs.getString("name"));
                        tfname.setText(rs.getString("fname"));
                        rollno.setText(rs.getString("Rollno"));
                        date.setText(rs.getString("DOB"));
                        taddress.setText(rs.getString("Address"));
                        tphone.setText(rs.getString("Phone"));
                        temail.setText(rs.getString("Email"));
                        course.setText(rs.getString("Course"));
                    }
                }catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        // submission button
        submit=new JButton("Update");
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
        new UpdateStudent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // we will update the values in database here in action performed
        if(e.getSource()==submit){
           String Rollno=rollno.getText();
            String Address=taddress.getText();
            String Phone=tphone.getText();
            String Email=temail.getText();
           String Course=course.getText();
           // now we will run a quiry to update values
            try{
                String query="update student set Address='"+Address+"', Phone='"+Phone+"', Email='"+Email+"', Course='"+Course+"' where Rollno='"+Rollno+"'";
                Connections c=new Connections();
                c.s.executeUpdate(query);                            // will update the info in database

                JOptionPane.showMessageDialog(null,"Student Informtion Updated Successfully");
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

