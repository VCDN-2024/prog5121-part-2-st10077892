public class LoginTest {

    public static void main(String[] args) {
        Login login = new Login();

        // Test: Username correctly formatted
        assert login.checkUserName("kyl_1") == true;
        // Test: Username incorrectly formatted
        assert login.checkUserName("kyle!!!!!!!") == false;

        // Test: Password meets complexity requirements
        assert login.checkPasswordComplexity("Ch&&sec@ke99!") == true;
        // Test: Password does not meet complexity requirements
        assert login.checkPasswordComplexity("password") == false;

        // Test: Registration and login success
        assert login.registerUser("kyl_1", "Ch&&sec@ke99!", "John", "Doe").equals("Username and password successfully captured");
        assert login.loginUser("kyl_1", "Ch&&sec@ke99!") == true;

        // Test: Registration failure due to username
        assert login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "John", "Doe").equals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");

        // Test: Registration failure due to password
        assert login.registerUser("kyl_1", "password", "John", "Doe").equals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");

        // Test: Login failure
        assert login.loginUser("kyl_1", "wrongPassword") == false;

        // Test: Task creation and validation
        Task task1 = new Task("Login Feature", 

