package org.example;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        TaskHandler handler = new TaskHandler();
        TaskManager manager = new TaskManager(handler);
        manager.start();

    }
}



