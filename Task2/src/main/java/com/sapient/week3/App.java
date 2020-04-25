package com.sapient.week3;

/**
 * Runner class
 */
public class App {
    public static void main(String[] args) {
        Command_Line1 commandLine1 = new Command_Line1();
        commandLine1.setData();
        commandLine1.calData();
        commandLine1.displayData();

        KeyRead_Line2 keyReadLine2 = new KeyRead_Line2();
        keyReadLine2.read();
        keyReadLine2.display();
        keyReadLine2.sort();
        keyReadLine2.display();
        keyReadLine2.find(4);

        System.out.println(NumToWords.fig_to_words(132));
    }
}
