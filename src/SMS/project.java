package SMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class project extends JFrame implements ActionListener {
    public project() {
        setSize(1540, 850);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/mcs1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);                   // no need of setbounds bc we are not setting layouts null
        add(img);

        //now menu
        JMenuBar menu = new JMenuBar();

        JMenu St_info = new JMenu("Student Portfolio");
        St_info.setForeground(Color.BLUE);
        menu.add(St_info);

        // there will be 2 sub menu items in menu Course info
        JMenuItem student = new JMenuItem("Student Profile");
        student.setBackground(Color.WHITE);
        student.addActionListener(this);
        St_info.add(student);


        //for updating any detail
        JMenu Update_Details = new JMenu("Update Details");
        Update_Details.setForeground(Color.BLUE);
        menu.add(Update_Details);

        JMenuItem update = new JMenuItem("Update");
        update.setBackground(Color.WHITE);
        update.addActionListener(this);
        Update_Details.add(update);

        //fee details and submission
        JMenu Fee = new JMenu("Fee Form");
        Fee.setForeground(Color.BLUE);
        menu.add(Fee);

        JMenuItem fee = new JMenuItem("Get Fee");
        fee.setBackground(Color.WHITE);
        fee.addActionListener(this);
        Fee.add(fee);

        //Utils for notepad
        JMenu notepad = new JMenu("Notes");
        notepad.setForeground(Color.BLUE);
        menu.add(notepad);

        JMenuItem note = new JMenuItem("Take Notes Now");
        note.setBackground(Color.white);
        note.addActionListener(this);
        notepad.add(note);

        //exiting
        JMenu exit = new JMenu("Leave");
        exit.setForeground(Color.BLUE);
        menu.add(exit);

        JMenuItem ex = new JMenuItem("Leave");
        ex.setBackground(Color.white);
        ex.addActionListener(this);
        exit.add(ex);




        setJMenuBar(menu);                            // instead of add() we use this for adding menu on jframe

        setVisible(true);
    }

    public static void main(String[] args) {
        new project();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if (msg.equals("Student Profile"))
            new StudentProfile();
        if (msg.equals("Leave"))
            this.dispose();
        if(msg.equals("Take Notes Now")){
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception ae){};
        }
        if (msg.equals("Update"))
            new UpdateStudent();
        if (msg.equals("Get Fee"))
            new StudentFeeForm();
    }
}
