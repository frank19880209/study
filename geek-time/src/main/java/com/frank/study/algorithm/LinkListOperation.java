package com.frank.study.algorithm;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

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

    /**
     * 链表两两配对反转
     * @param current 当前header
     * @return 返回反转之后的节点
     */
    public static Node reverseInPair(Node current) {
        if(current == null || current.getNext() == null){
            return current;
        }
        Node head = current.getNext();
        //用户存储调整之后的链表，防止出现丢失
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


    /**
     * 判断单链表中是否含有环
     * @param header 头节点
     * @return 返回true表示有环，否则无环
     */
    private static Boolean checkLoopInLink(Node header){
        if(header == null || header.getNext() == null){
            return false;
        }
        Set<Node> visitNodes = new HashSet<>();
        visitNodes.add(header);
        Node next = header.getNext();
        while (next != null){
            if(visitNodes.contains(next)){
                return true;
            }
            visitNodes.add(next);
            next = next.getNext();
        }
        return false;
    }


    /**
     * 判断单链表中是否含有环(第二种方式)
     * @param header 头节点
     * @return 返回true表示有环，否则无环
     */
    private static Boolean checkLoopInLink2(Node header){
        Node slow = header;
        Node quick = header;
        while (slow != null && quick != null){
            slow = slow.getNext();
            if(quick.getNext() != null){
                quick = quick.getNext().getNext();
            }else{
                break;
            }
            if(slow == quick){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * 合并两个有序链表
     *
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * 示例：
     *
     * 输入：1,2,4, 1,3,4
     * 输出：1,1,2,3,4,4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * @param header1
     * @param header2
     * @return
     */
    private static Node mergeTwoLists(Node header1,Node header2){
        if(header1 == null || header2 == null){
            return header1 == null?header2:header1;
        }
        Node resultNode = new Node();
        resultNode.setData(-1);
        Node currentNode = resultNode;
        while (header1 != null && header2 != null){
            if((int)header1.getData()< (int)header2.getData() ){
                currentNode.setNext(header1);
                header1 = header1.getNext();
                if(header1 == null){
                    currentNode.getNext().setNext(header2);
                    break;
                }
                currentNode = currentNode.getNext();
            }else if((int)header1.getData()== (int)header2.getData() ){
                currentNode.setNext(header1);
                header1 = header1.getNext();
                currentNode.getNext().setNext(header2);
                header2 = header2.getNext();
                if(header2 == null){
                    currentNode.getNext().getNext().setNext(header1);
                    break;
                }
                currentNode = currentNode.getNext().getNext();
            }else{
                currentNode.setNext(header2);
                header2 = header2.getNext();
                if(header2 == null){
                    currentNode.getNext().setNext(header1);
                    break;
                }
                currentNode = currentNode.getNext();
            }
        }
        return resultNode.getNext();
    }

    public static void main(String[] args) {
       testLinkReverse();
       testLinkReverseInPair();
       testLoopLink();
       testMergeTwoLists();
    }

    private static void testMergeTwoLists(){
        Node firstNode = createNodeByStr("1,2,3,4,5,6,7");
        Node secondNode = createNodeByStr("5,7");
        mergeTwoLists(firstNode,secondNode);
        firstNode = createNodeByStr("1,2,3,4,5,6,7");
        secondNode = createNodeByStr("5,7");
        mergeTwoLists(secondNode,firstNode);

        Node firstNode1 =  createNodeByStr("1,2,4");
        Node secondNode1 = createNodeByStr("1,3,4");
        mergeTwoLists(firstNode1,secondNode1);


        Node node1 = createNodeByStr("2");
        Node node2 = createNodeByStr("1");
        mergeTwoLists(node1,node2);

        Node nodeA = createNodeByStr("-9,-5,-3,-2,-2,3,7");
        Node nodeB = createNodeByStr("-10,-8,-4,-3,-1,3");

        mergeTwoLists(nodeA,nodeB);
    }


    private static void testLoopLink(){
        //无环测试
        if(!checkLoopInLink(createNode())){
            System.out.println("1)测试无环通过");
        }
        //测试有环情况
        if(checkLoopInLink(createLoopLink())){
            System.out.println("1)测试有环通过");
        }

        //无环测试
        if(!checkLoopInLink2(createNode())){
            System.out.println("2)测试无环通过");
        }
        //测试有环情况
        if(checkLoopInLink2(createLoopLink())){
            System.out.println("2)测试有环通过");
        }
    }

    /**
     * 测试链表两两配对反转
     */
    private static void testLinkReverseInPair(){
        printNode(reverseInPair(createNode()));
    }

    private static void testLinkReverse(){
        Node node = null;
        Node reNode = reverse(node);
        if (reNode == null) {
            System.out.println("=====right");
        }
        printNode(reverse(createNode()));
    }

    private static void printNode(Node node){
        Node next = node.getNext();
        System.out.println(node.getData());
        while (next != null) {
            System.out.println(next.getData());
            next = next.getNext();
        }
    }


    /**
     * 创建含有环的单链表
     * @return 返回header节点
     */
    private static Node createLoopLink(){

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
        Node eightNode = new Node();
        eightNode.setData(8);

        Node nineNode = new Node();
        nineNode.setData(9);

        Node tenNode = new Node();
        tenNode.setData(10);

        first.setNext(second);
        second.setNext(third);
        third.setNext(forthNode);
        forthNode.setNext(fiveNode);
        fiveNode.setNext(sixNode);
        sixNode.setNext(sevenNode);
        sevenNode.setNext(eightNode);
        eightNode.setNext(nineNode);
        nineNode.setNext(tenNode);
        tenNode.setNext(fiveNode);
        return first;
    }


    private static Node createNodeByStr(String s){
        if(StringUtils.isBlank(s)){
            return null;
        }
        String[]sarr = s.split(",");
        Node header = new Node();
        Node current = header;
        for (String s1 : sarr) {
            Node node = new Node();
            node.setData(Integer.valueOf(s1));
            current.setNext(node);
            current = current.getNext();
        }
        return header.getNext();
    }

    /**
     * 创建单链表
     * @return 返回header节点
     */
    private static Node createNode(){
        Node first = createNodeByStr("1,-2,3,4,5,6,7");
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
        private Integer data;
        private Node next;


        public Object getData() {
            return data;
        }

        public void setData(Integer data) {
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
