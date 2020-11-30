/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import entity.Book;

/**
 *
 * @author TrongDuyDao
 */
public class MyList {
    
    Node<Book> head, tail;
    
    //ctor
    public MyList() {
        head = tail = null;
    }
    //check if the list is empty or not
    public boolean isEmpty() {
        return head == null;
    }
    //add a new Book to the end of list
    public void addLast(Book b) {
        int size = size();
        if (size == 0) {
            head = new Node<>(b);
            return;
        }
        Node<Book> node = head;
        while (node != null && node.next != null) {
            node = node.next;
        }
        node.next = new Node<>(b);
    }
    //add a new Book to the begining of list
    public void addFirst(Book b) {
        if (size() == 0) {
            head = new Node<>(b);
            return;
        }
        head = new Node<>(b, head);
    }
    //output information of all books in the list
    public void traverse() {
        Node<Book> node = head;
        while (node != null) {
            System.out.println(node.info);
            node = node.next;
        }
    }
    //return number of nodes/elements in the list
    public int size() {
        if (isEmpty()) return 0;
        int size = 0;
        Node<Book> node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }
    //return a Node at position k, starting position is 0
    public Node<Book> getNode(int k) {
        if (k < 0 || k >= size()) throw new ArrayIndexOutOfBoundsException();
        
        int index = 0;
        Node<Book> node = head;
        while (node != null) {
            if (k == index) break;
            node = node.next;
            index++;
        }
        return node;
    }
    //add a new book after a position k
    public void addAfter(Book b, int k) {
        Node<Book> nodeK = getNode(k);
        nodeK.next = new Node<Book>(b, nodeK.next);
        
        
    }
    //delete a book at position k
    public void deleteAt(int k) {
        int size = size();
        if (k < 0 || k >= size) throw new ArrayIndexOutOfBoundsException();

        Node<Book> newNode = k == size ? getNode(k) : getNode(k).next;
        for (int i = k-1; i >= 0; i--) {
            Node<Book> curr = getNode(i);
            curr.next = newNode;
            newNode = curr;    
        }
        head = newNode;
    }
    //search a Node by a given book code
    public Node<Book> search(String bCode) {
        Node<Book> node = head;
        while (node != null) {
            if (node.info.getbCode().equals(bCode)) return node;
            node = node.next;
        }
        return null;
    }
}
