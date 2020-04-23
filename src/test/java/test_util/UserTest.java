package test_util;

import model.User;

import java.sql.SQLException;

import static database.UserDBHandler.*;

public class UserTest {

    public static void main(String[] args) throws SQLException {

        // Test # 1: Get User
        System.out.println("Test 1: ");
        System.out.println("testA: ");
        System.out.println(getUserByUsername("admin_Beatriz"));
        System.out.println();

        System.out.println("testB: ");
        System.out.println(getUserByUsername("testing non existent user"));
        System.out.println();

        // Test # 2: User Exists
        System.out.println("Test 2: ");
        System.out.println("testA: ");
        userExists("admin_Beatriz");

        System.out.println();
        System.out.println();

        // Test # 3: Verify Credentials
        System.out.println("Test 4: ");
        System.out.print("testA: ");
        System.out.println(verifyEmail("admin_Beatriz", "bcangasperez2017@fau.edu"));
        System.out.println();

        // Test # 4: Verify Login Credentials
        System.out.print("testB: ");
        System.out.println(verifyLoginCredentials("admin_Beatriz", "test"));
        System.out.println();

        // Test # 5: Add User
        System.out.println("Test 5: ");
        User user = new User("admin", "B", "admin_B@test.com", "admin_B", "admin_B");
        System.out.println(getUserByUsername("admin_B"));
    }
}
