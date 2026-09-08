
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TodoApp extends JFrame {

    private JTextField taskField;
    private DefaultListModel<String> taskModel;
    private JList<String> taskList;

    public TodoApp() {
        setTitle("To-Do List");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Title
        JLabel title = new JLabel("My To-Do List", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));

        mainPanel.add(title, BorderLayout.NORTH);

        // Task input
        JPanel inputPanel = new JPanel(new BorderLayout(10, 0));

        taskField = new JTextField();
        taskField.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton addButton = new JButton("Add Task");

        inputPanel.add(taskField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Task list
        taskModel = new DefaultListModel<>();
        taskList = new JList<>(taskModel);

        taskList.setFont(new Font("Arial", Font.PLAIN, 16));
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(taskList);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton completeButton = new JButton("Complete");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear Completed");

        buttonPanel.add(completeButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        // Center panel
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));

        centerPanel.add(inputPanel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);

        // Add task
        addButton.addActionListener((ActionEvent e) -> addTask());

        // Press Enter to add task
        taskField.addActionListener((ActionEvent e) -> addTask());

        // Complete task
        completeButton.addActionListener((ActionEvent e) -> completeTask());

        // Delete task
        deleteButton.addActionListener((ActionEvent e) -> deleteTask());

        // Clear completed
        clearButton.addActionListener((ActionEvent e) -> clearCompleted());
    }

    private void addTask() {
        String task = taskField.getText().trim();

        if (task.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a task.",
                    "Empty Task",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        taskModel.addElement("[ ] " + task);
        taskField.setText("");
        taskField.requestFocus();
    }

    private void completeTask() {
        int index = taskList.getSelectedIndex();

        if (index == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select a task.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String task = taskModel.getElementAt(index);

        if (!task.startsWith("[✓]")) {
            task = task.replace("[ ]", "[✓]");
            taskModel.set(index, task);
        }
    }

    private void deleteTask() {
        int index = taskList.getSelectedIndex();

        if (index == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select a task to delete.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        taskModel.remove(index);
    }

    private void clearCompleted() {
        for (int i = taskModel.size() - 1; i >= 0; i--) {
            String task = taskModel.getElementAt(i);

            if (task.startsWith("[✓]")) {
                taskModel.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TodoApp app = new TodoApp();
            app.setVisible(true);
        });
    }
}

