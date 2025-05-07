
/**
 * Below is the code for RecruitmentSystem GUI class.
 * 
 * @author (Sumaiya Kadir Akhy)
 * @version (05/05/2025)
 */

//Imports Built-in packages for the GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

public class RecruitmentSystem extends JFrame implements ActionListener {
    //Arraylist
    private ArrayList<StaffHire> staffList = new ArrayList<>();

    // Input Components like Text Field, Combo Box, Check Box etc
    private JTextField vacancyField, designationField, jobTypeField, nameField;
    private JTextField joinDateField, qualificationField, appointedByField;
    private JTextField salaryField, hoursField, wagesField, workingHoursField, displayIndexField;
    private JComboBox<String> shiftCombo;
    private JCheckBox joinedCheck;

    // Buttons
    private JButton addFullTimeBtn, addPartTimeBtn, setSalaryBtn;
    private JButton setShiftBtn, terminateBtn, displayBtn, clearBtn;

    public RecruitmentSystem() {
        setTitle("Staff Recruitment System");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // This is going to Create Panels
        JPanel inputPanel = createInputPanel();
        JPanel buttonPanel = createButtonPanel();

        // This will Add Components to Frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Common Fields below
        panel.add(new JLabel("Vacancy Number*:"));
        vacancyField = new JTextField();
        panel.add(vacancyField);

        panel.add(new JLabel("Designation*:"));
        designationField = new JTextField();
        panel.add(designationField);

        panel.add(new JLabel("Job Type*:"));
        jobTypeField = new JTextField();
        panel.add(jobTypeField);

        panel.add(new JLabel("Staff Name*:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Joining Date (DD/MM/YYYY):"));
        joinDateField = new JTextField();
        panel.add(joinDateField);

        panel.add(new JLabel("Qualification:"));
        qualificationField = new JTextField();
        panel.add(qualificationField);

        panel.add(new JLabel("Appointed By:"));
        appointedByField = new JTextField();
        panel.add(appointedByField);

        panel.add(new JLabel("Joined:"));
        joinedCheck = new JCheckBox();
        panel.add(joinedCheck);

        //  This is Specific Fields for Full-time only
        panel.add(new JLabel("Salary (FullTime only):"));
        salaryField = new JTextField();
        panel.add(salaryField);

        panel.add(new JLabel("Weekly Hours (FullTime only):"));
        hoursField = new JTextField();
        panel.add(hoursField);

        // Part-time Specific Fields only
        panel.add(new JLabel("Wages/Hour (PartTime only):"));
        wagesField = new JTextField();
        panel.add(wagesField);

        panel.add(new JLabel("Working Hours/Day (PartTime only):"));
        workingHoursField = new JTextField();
        panel.add(workingHoursField);

        panel.add(new JLabel("Shift:"));
        shiftCombo = new JComboBox<>(new String[]{"morning", "day", "evening"});
        panel.add(shiftCombo);

        // Display Field below
        panel.add(new JLabel("Display Index:"));
        displayIndexField = new JTextField();
        panel.add(displayIndexField);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 0, 5, 5));

        addFullTimeBtn = new JButton("Add Full Time");
        addFullTimeBtn.addActionListener(this);
        panel.add(addFullTimeBtn);

        addPartTimeBtn = new JButton("Add Part Time");
        addPartTimeBtn.addActionListener(this);
        panel.add(addPartTimeBtn);

        setSalaryBtn = new JButton("Set Salary");
        setSalaryBtn.addActionListener(this);
        panel.add(setSalaryBtn);

        setShiftBtn = new JButton("Set Shift");
        setShiftBtn.addActionListener(this);
        panel.add(setShiftBtn);

        terminateBtn = new JButton("Terminate PartTime Staff");
        terminateBtn.addActionListener(this);
        panel.add(terminateBtn);

        displayBtn = new JButton("Display");
        displayBtn.addActionListener(this);
        panel.add(displayBtn);

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(this);
        panel.add(clearBtn);

        return panel;
    }
    
    //Validates display number input 
    private int validateDisplayNumber() {
        int displayNumber = -1; // Initialize to -1 as required
        
        try {
            displayNumber = Integer.parseInt(displayIndexField.getText());
            
            if (displayNumber < 0 || displayNumber >= staffList.size()) {
                JOptionPane.showMessageDialog(this,
                    "Error: Please enter index between 0 and " + (staffList.size()-1),
                    "Invalid Range",
                    JOptionPane.ERROR_MESSAGE);
                return -1;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Error: Please enter a valid integer",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        
        return displayNumber;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addFullTimeBtn) {
            addFullTimeStaff();
        } else if (e.getSource() == addPartTimeBtn) {
            addPartTimeStaff();
        } else if (e.getSource() == setSalaryBtn) {
            setSalary();
        } else if (e.getSource() == setShiftBtn) {
            setShift();
        } else if (e.getSource() == terminateBtn) {
            terminateStaff();
        } else if (e.getSource() == displayBtn) {
            displayStaff();
        } else if (e.getSource() == clearBtn) {
            clearFields();
        }
    }

    private void addFullTimeStaff() {
        try {
            int vacancy = Integer.parseInt(vacancyField.getText());
            String designation = designationField.getText();
            String jobType = jobTypeField.getText();
            String name = nameField.getText();
            String joinDate = joinDateField.getText();
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();
            boolean joined = joinedCheck.isSelected();
            double salary = Double.parseDouble(salaryField.getText());
            int hours = Integer.parseInt(hoursField.getText());

            FullTimeStaffHire staff = new FullTimeStaffHire(
                    vacancy, designation, jobType, name, joinDate,
                    qualification, appointedBy, joined, salary, hours);

            staffList.add(staff);
            JOptionPane.showMessageDialog(this, "Full-time staff members added successfully!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Please enter valid numbers only for vacancy, salary and hours", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addPartTimeStaff() {
        try {
            int vacancy = Integer.parseInt(vacancyField.getText());
            String designation = designationField.getText();
            String jobType = jobTypeField.getText();
            String name = nameField.getText();
            String joinDate = joinDateField.getText();
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();
            boolean joined = joinedCheck.isSelected();
            int workingHours = Integer.parseInt(workingHoursField.getText());
            double wages = Double.parseDouble(wagesField.getText());
            String shift = (String) shiftCombo.getSelectedItem();

            PartTimeStaffHire staff = new PartTimeStaffHire(
                    vacancy, designation, jobType, name, joinDate,
                    qualification, appointedBy, joined, workingHours,
                    wages, shift);

            staffList.add(staff);
            JOptionPane.showMessageDialog(this, "Part-time staff members added successfully!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Please enter valid numbers only, for vacancy, wages and working hours", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

     private void setSalary() {
        int index = validateDisplayNumber();
        if (index == -1) return;
        
        try {
            StaffHire staff = staffList.get(index);
            if (staff instanceof FullTimeStaffHire) {
                double newSalary = Double.parseDouble(salaryField.getText());
                ((FullTimeStaffHire) staff).setSalary(newSalary);
                JOptionPane.showMessageDialog(this, "Salary updated successfully");
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Selected staff is not full-time", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Please enter valid numbers", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void setShift() {
        int index = validateDisplayNumber();
        if (index == -1) return;
        
        StaffHire staff = staffList.get(index);
        if (staff instanceof PartTimeStaffHire) {
            String newShift = (String) shiftCombo.getSelectedItem();
            ((PartTimeStaffHire) staff).setShifts(newShift);
            JOptionPane.showMessageDialog(this, "Shift updated successfully");
        } else {
            JOptionPane.showMessageDialog(this, 
                "Selected staff is not part-time", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void terminateStaff() {
        int index = validateDisplayNumber();
        if (index == -1) return;
        
        StaffHire staff = staffList.get(index);
        if (staff instanceof PartTimeStaffHire) {
            ((PartTimeStaffHire) staff).terminateStaff();
            JOptionPane.showMessageDialog(this, "Staff terminated successfully");
        } else {
            JOptionPane.showMessageDialog(this, 
                "Only part-time staff can be terminated", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    

    private void displayStaff() {
        int index = validateDisplayNumber();
        if (index == -1) return;
        
        StaffHire staff = staffList.get(index);
        JTextArea textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        
        // Redirect console output to text area
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        System.setOut(printStream);
        
        staff.display();
        
        JOptionPane.showMessageDialog(this, 
            new JScrollPane(textArea), 
            "Staff Details", 
            JOptionPane.INFORMATION_MESSAGE);
            
        // This will restore standard output
        System.setOut(System.out);
    }
    

    private void clearFields() {
        vacancyField.setText("");
        designationField.setText("");
        jobTypeField.setText("");
        nameField.setText("");
        joinDateField.setText("");
        qualificationField.setText("");
        appointedByField.setText("");
        joinedCheck.setSelected(false);
        salaryField.setText("");
        hoursField.setText("");
        workingHoursField.setText("");
        wagesField.setText("");
        shiftCombo.setSelectedIndex(0);
        displayIndexField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                {
                    new RecruitmentSystem();
            });
    }

    class CustomOutputStream extends OutputStream {
        private JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) throws IOException {
            textArea.append(String.valueOf((char) b));
        }
    }
}