package SMS;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentProfile extends JFrame implements ActionListener {
    Choice choice;
    JTable table;
    JButton search,update,add,cancel;
    StudentProfile()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Search by roll no");
        heading.setBounds(20,20,150,20);
        add(heading);

        choice =new Choice();
        choice.setBounds(180,20,150,20);
        add(choice);

        try{
            Connections c=new Connections();
            ResultSet rs=c.s.executeQuery("select * from student");
            while(rs.next()){
                choice.add(rs.getString("Rollno"));
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }

        //creating table
        table=new JTable();
        try{
            Connections c=new Connections();
            ResultSet rs=c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            }
        catch (Exception ae){
            ae.printStackTrace();
        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        // now inserting values from database in table

        //creating buttons
        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        update=new JButton("Update");
        update.setBounds(120,70,80,20);
        update.addActionListener(this);
        add(update);

        add=new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);

        cancel=new JButton("Cancel");
        cancel.setBounds(320,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(300,100);
        setVisible(true);

    }    public static void main(String[] args) {
        new StudentProfile();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String quiry="select * from student where Rollno = '"+choice.getSelectedItem()+"'";
            try {
                Connections c=new Connections();
                ResultSet rs=c.s.executeQuery(quiry);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception ae){
                ae.printStackTrace();
            }
        }
        else if(e.getSource()==add){
            new StudentInfo();
        } else if (e.getSource()==update) {
            new UpdateStudent();
        }
        else this.dispose();
    }
}
