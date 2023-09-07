package cs.intro.exercise_11_7_2;

import linkedlist.LinkedList;

import java.security.InvalidParameterException;

public class Stack<T> {

    private LinkedList<T> linkedList = new LinkedList<>();

    T pop() {
        T toReturn = linkedList.getLast();
        linkedList.removeLast();
        return toReturn;
    }

    void push(T object) {
        if(object == null) throw new InvalidParameterException();
        linkedList.add(object);
    }

    int size() {
        return this.linkedList.size();
    }

}
