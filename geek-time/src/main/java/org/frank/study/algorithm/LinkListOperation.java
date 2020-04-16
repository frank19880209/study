package org.frank.study.algorithm;

/**
 * @ClassName: LinkListOperation
 * @Description: 链表操作
 * @Author: 孙中伟
 * @Date: 2020/4/16 8:32
 * @Version: 1.0
 */
public class LinkListOperation {

    /**
     * 单链表反转
     */
    public static Node reverse(Node node) {
        Node next = null;
        if (node == null) {
            return node;
        } else {
            next = node.getNext();
            node.setNext(null);
        }
        while (next != null) {
            Node next2 = next.getNext();
            next.setNext(node);
            node = next;
            next = next2;
        }
        return node;
    }

    public static Node reverseInPair(Node current) {
        if(current == null || current.getNext() == null){
            return current;
        }
        Node head = current.getNext();
        Node preNode = null;
        while (current != null && current.getNext() != null){
            Node next = current.getNext();
            Node next2 =  next.getNext();
            next.setNext(current);
            current.setNext(next2);
            if(preNode != null){
                preNode.setNext(next);
            }
            preNode = current;
            current = next2;
        }
        return head;
    }

    public static void main(String[] args) {
       testLinkReverse();
    }

    private static void testLinkReverse(){
        Node node = null;
        Node reNode = reverse(node);
        if (reNode == null) {
            System.out.println("=====right");
        }
        printNode(reverse(createNode()));
        printNode(reverseInPair(createNode()));
    }

    private static void printNode(Node node){
        Node next = node.getNext();
        System.out.println(node.getData());
        while (next != null) {
            System.out.println(next.getData());
            next = next.getNext();
        }
    }


    private static Node createNode(){
        Node first = new Node();
        first.setData(1);
        Node second = new Node();
        second.setData(2);
        Node third = new Node();
        third.setData(3);
        Node forthNode = new Node();
        forthNode.setData(4);
        Node fiveNode = new Node();
        fiveNode.setData(5);
        Node sixNode = new Node();
        sixNode.setData(6);
        Node sevenNode = new Node();
        sevenNode.setData(7);

        first.setNext(second);
        second.setNext(third);
        third.setNext(forthNode);
        forthNode.setNext(fiveNode);
        fiveNode.setNext(sixNode);
        sixNode.setNext(sevenNode);
        return first;
    }


    private static class Node {
        private Object data;
        private Node next;


        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
