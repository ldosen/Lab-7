package edu.luc.cs271.linkedstack;

import java.util.Scanner;

public class ReverseLines {

  public static void main(final String[] args) {
    LinkedStack<String> stringStack = new LinkedStack<>();
    final Scanner input = new Scanner(System.in);
    while (input.hasNextLine()) {
      final String line = input.nextLine();
      stringStack.push(line);
    }
    while (! stringStack.isEmpty()){
      System.out.println(stringStack.pop());
    }
  }
}
