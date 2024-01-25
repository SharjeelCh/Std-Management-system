package SMS;

import net.proteanit.sql.DbUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener {
    Choice choice;
    JLabel tfee,tname,tfname;
    JButton print,update,search;
    JComboBox course,smester;
    StudentFeeForm(){
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(400,50,500,300);
        add(img);


        JLabel rollNo=new JLabel("Search by roll no");
        rollNo.setBounds(40,60,150,20);
        rollNo.setFont(new Font("Tahoma",Font.ITALIC,18));
        add(rollNo);

        choice =new Choice();
        choice.setBounds(200,60,150,20);
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
        st_name.setBounds(40,100,150,20);
        st_name.setFont(new Font("serif",Font.BOLD,16));
        add(st_name);

         tname=new JLabel();
        tname.setBounds(200,100,150,20);
        tname.setFont(new Font("serif",Font.PLAIN,16));
        add(tname);

        // Fathername label and textfield
        JLabel fa_name=new JLabel("Father's Name");
        fa_name.setBounds(40,140,150,20);
        fa_name.setFont(new Font("serif",Font.BOLD,16));
        add(fa_name);

         tfname=new JLabel();
        tfname.setBounds(200,140,150,20);
        tfname.setFont(new Font("serif",Font.PLAIN,16));
        add(tfname);


        try{
            Connections c=new Connections();
            String query="select * from student where Rollno='"+choice.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }

        JLabel Course=new JLabel("Course");
        Course.setBounds(40,180,150,20);
        Course.setFont(new Font("serif",Font.BOLD,16));
        add(Course);

        String C_course[]={"BESE-28","BESE_27","BESE-26","BEIS-3","BEIS-2","BEIS_1"};
        course=new JComboBox(C_course);
        course.setBounds(200,180,150,20);
        add(course);

        JLabel Sem=new JLabel("Semester");
        Sem.setBounds(40,220,150,20);
        Sem.setFont(new Font("serif",Font.BOLD,16));
        add(Sem);

        String Sems[]={"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
        smester=new JComboBox(Sems);
        smester.setBounds(200,220,150,20);
        add(smester);

        JLabel Total=new JLabel("Total");
        Total.setBounds(40,260,150,20);
        Total.setFont(new Font("serif",Font.BOLD,16));
        add(Total);

        tfee=new JLabel();
        tfee.setBounds(200,260,150,20);
        tfee.setFont(new Font("serif",Font.BOLD,18));
        add(tfee);


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
                    }
                }catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });


        //buttons

        print=new JButton("Print");
        print.setBounds(40,340,100,25);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        print.setFont(new Font("Tahoma",Font.BOLD,15));
        add(print);

        //cancel button
        update=new JButton("Update");
        update.setBounds(160,340,100,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma",Font.BOLD,15));
        add(update);

        setVisible(true);
    }
    public static void main(String[] args) {
        new StudentFeeForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==print){
           JOptionPane.showMessageDialog(null,"Install printer to print");
           this.dispose();
        }
        else if(e.getSource()==update){
            String Course=(String) course.getSelectedItem();
            String semester=(String)smester.getSelectedItem();
            try{
                Connections c=new Connections();
                ResultSet rs=c.s.executeQuery("select * from fee1 where Course = '"+Course+"'");
                while(rs.next()){
                    tfee.setText(rs.getString(semester));
                }
            }catch (Exception dd){
                dd.printStackTrace();
            }
        }
    }
}
