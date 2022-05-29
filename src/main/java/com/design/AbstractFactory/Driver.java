package com.design.AbstractFactory;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
            GuiFactory guiFactory = null;
            Scanner sc = new Scanner(System.in);
            String osName = sc.nextLine();

            if (osName.equalsIgnoreCase("MAC"))
                guiFactory = new MacOsFactory();
            else if (osName.equalsIgnoreCase("windows"))
                guiFactory = new WindowsFactory();
            else {
                System.out.println("please provide a valid Os name");
            }
            //operation starts
            Button button = guiFactory.createButton();
            Checkbox checkbox = guiFactory.createCheckbox();
            button.paint();
            checkbox.check();
    }
}
