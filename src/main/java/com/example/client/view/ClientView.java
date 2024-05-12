package com.example.client.view;

import com.example.server.data.UserData;

import java.util.Scanner;

public class ClientView {

    private final Scanner scanner = new Scanner(System.in);

    public UserData getUserData(){
        UserData data = new UserData();
        System.out.println("Enter your name: ");
        data.setName(scanner.nextLine());
        System.out.println("Enter your surname: ");
        data.setSurname(scanner.nextLine());
        System.out.println("Enter your age: ");
        data.setAge(Integer.parseInt(scanner.nextLine()));
        return data;
    }

    public void getOutput(String output){
        System.out.println(output);
    }

}
