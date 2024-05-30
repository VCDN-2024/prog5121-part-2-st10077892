package st10077892prog5121poeparttwo;

import javax.swing.JOptionPane;

public class ST10077892PROG5121POEPARTTWO {

    public static void main(String[] args) {
        Login login = new Login();

        
        String username = JOptionPane.showInputDialog("Enter a username (must contain an underscore and be no more than 5 characters long):");
        String password = JOptionPane.showInputDialog("Enter a password (at least 8 characters, must contain a capital letter, a number, and a special character):");
        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");

        String registrationResult = login.registerUser(username, password, firstName, lastName);
        JOptionPane.showMessageDialog(null, registrationResult);

        
        if (registrationResult.equals("Username and password successfully captured")) {
            String loginUsername = JOptionPane.showInputDialog("Enter your username to login:");
            String loginPassword = JOptionPane.showInputDialog("Enter your password to login:");

            boolean loginSuccess = login.loginUser(loginUsername, loginPassword);
            String loginStatus = login.returnLoginStatus(loginSuccess);
            JOptionPane.showMessageDialog(null, loginStatus);

            if (loginSuccess) {
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
                boolean exit = false;

                while (!exit) {
                    String option = JOptionPane.showInputDialog("Choose an option:\n1) Add tasks\n2) Show report\n3) Quit");

                    switch (option) {
                        case "1":
                            int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks you want to add:"));
                            Task[] tasks = new Task[numTasks];
                            int totalHours = 0;

                            for (int i = 0; i < numTasks; i++) {
                                String taskName = JOptionPane.showInputDialog("Enter task name:");
                                String taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
                                String developerDetails = JOptionPane.showInputDialog("Enter developer details (first and last name):");
                                int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (in hours):"));
                                String taskStatus = JOptionPane.showInputDialog("Enter task status (To Do, Done, Doing):");

                                Task task = new Task(taskName, i, taskDescription, developerDetails, taskDuration, taskStatus);

                                if (task.checkTaskDescription()) {
                                    tasks[i] = task;
                                    totalHours += task.getTaskDuration();
                                    JOptionPane.showMessageDialog(null, "Task successfully captured:\n" + task.printTaskDetails());
                                } else {
                                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                                    i--; 
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Total task duration: " + totalHours + " hours");
                            break;

                        case "2":
                            JOptionPane.showMessageDialog(null, "Coming Soon");
                            break;

                        case "3":
                            exit = true;
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Invalid option, please try again.");
                            break;
                    }
                }
            }
        }
    }
}


