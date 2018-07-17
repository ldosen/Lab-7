package edu.luc.cs271.linkedstack;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;


public class LinkedStack<E> implements IStack<E> {

  /**
   * The topmost node of this stack. The stack gets pushed down from here.
   */
  private Node<E> top;

  @Override
  public E push(final E obj) {
    top = new Node<>(obj, top);
    return obj;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    } else {
      return top.data;
    }
  }

  @Override
  public E pop() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    } else {
      E result = top.data;
      top = top.next;
      return result;
    }
  }

  @Override
  public boolean isEmpty() {
    return top == null;
  }

  @Override
  public List<E> asList() {
    final ArrayList<E> result = new ArrayList<>();
    populateList(top, result);
    return result;
  }

  private void populateList(final Node<E> curr, final List<E> result) {
    if (curr == null) {
      return;
    }
    else{
      result.add(curr.data);
      populateList(curr.next, result);
    }
  }

  @Override
  public List<E> asFifoList() {
    final ArrayList<E> result = new ArrayList<>();
    populateFifoList(top, result);
    return result;
  }

  private void populateFifoList(final Node<E> curr, final List<E> result) {
    if (curr == null){
      return;
    }
    else{
      result.add(0, curr.data);
      populateFifoList(curr.next, result);
    }
    // TODO recursively populate the list in the desired order
  }
}
