package kz.sabyrzhan.algo.aloexpert.easy;

import java.util.HashMap;
import java.util.Map;

public class T05_LinkedListConstruction {
    public static void main(String[] args) {
        Map<Integer, Program.Node> maps = new HashMap<>();
        Program.Node root = new Program.Node(1);
        Program.Node prev = root;
        maps.put(1, root);
        for(int i = 2; i < 5; i++) {
            Program.Node node = new Program.Node(i);
            node.prev = prev;
            prev.next = node;
            prev = node;
            maps.put(i, node);
        }

        prev.next = new Program.Node(5);
        prev.next.prev = prev;
        maps.put(5, prev.next);

        Program.Node n = new Program.Node(1);
        Program.DoublyLinkedList d = new Program.DoublyLinkedList();
        d.setHead(n);
        System.out.println(d.head);
        System.out.println(d.tail);
        System.out.println();
        d.remove(n);
        System.out.println(d.head);
        System.out.println(d.tail);
        if(true) return;

        d.head = root;
        d.tail = prev.next;

        System.out.println("Set 4 to head");
        d.setHead(maps.get(4));
        System.out.println(d.head);
        System.out.println(d.head.toStringPrev());
        System.out.println();

        System.out.println("set 6 to tail");
        Program.Node six = new Program.Node(6);
        d.setTail(six);
        System.out.println(d.head);
        System.out.println(six.toStringPrev());
        System.out.println();

        System.out.println("insert 3 before 6");
        d.insertBefore(six, maps.get(3));
        System.out.println(d.head);
        System.out.println(d.head.toStringPrev());
        System.out.println();

        System.out.println("insert new 3 after 6");
        d.insertAfter(six, new Program.Node(3));
        System.out.println(d.head);
        System.out.println(d.head.toStringPrev());
        System.out.println();

        System.out.println("insert new 3 at position 1");
        d.insertAtPosition(1, new Program.Node(3));
        System.out.println(d.head);
        System.out.println(d.head.toStringPrev());
        System.out.println();

        System.out.println("Remove values with 3");
        d.removeNodesWithValue(3);
        System.out.println(d.head);
        System.out.println(d.head.toStringPrev());
        System.out.println();

        System.out.println("Remove two");
        d.remove(maps.get(2));
        System.out.println(d.head);
        System.out.println(d.head.toStringPrev());
        System.out.println();

        System.out.println("Searrch for 5");
        System.out.println(d.containsNodeWithValue(5));
    }

    // Feel free to add new properties and methods to the class.
    static class Program {
        static class DoublyLinkedList {
            public Node head;
            public Node tail;

            public void setHead(Node node) {
                if(head == null) {
                    head = node;
                    head.next = tail;
                    if(tail != null) {
                        tail.prev = head;
                    }

                    if(tail == null) {
                        tail = head;
                    }

                    return;
                }
                insertBefore(head, node);
            }

            public void setTail(Node node) {
                if(tail == null) {
                    tail = node;
                    tail.prev = head;
                    if(head != null) {
                        head.next = tail;
                    }

                    if(head == null) {
                        head = tail;
                    }

                    return;
                }
                insertAfter(tail, node);
            }

            public void insertBefore(Node node, Node nodeToInsert) {
                remove(nodeToInsert);
                Node prev = node.prev;
                Node next = node;

                if(prev != null) {
                    prev.next = nodeToInsert;
                }

                next.prev = nodeToInsert;

                nodeToInsert.prev = prev;
                nodeToInsert.next = next;

                if(nodeToInsert.prev == null) {
                    head = nodeToInsert;
                }

                if(next.next == null) {
                    tail = next;
                }
            }

            public void insertAfter(Node node, Node nodeToInsert) {
                remove(nodeToInsert);

                Node prev = node;
                Node next = node.next;

                prev.next = nodeToInsert;

                if(next != null) {
                    next.prev = nodeToInsert;
                }

                nodeToInsert.prev = prev;
                nodeToInsert.next = next;

                if(nodeToInsert.next == null) {
                    this.tail = nodeToInsert;
                }

                if(prev.prev == null) {
                    head = prev;
                }
            }

            public void insertAtPosition(int position, Node nodeToInsert) {
                if(head != tail) {
                    Node foundNode = null;
                    Node tmpNode = null;
                    for(int i = 1; i <= position; i++) {
                        if(i == 1) {
                            tmpNode = head;
                        } else {
                            tmpNode = tmpNode.next;
                        }
                    }

                    foundNode = tmpNode;
                    if(foundNode == null) {
                        insertAfter(tail, nodeToInsert);
                    } else {
                        insertBefore(foundNode, nodeToInsert);
                    }
                } else {
                    if (head == null) {
                        head = nodeToInsert;
                        tail = nodeToInsert;
                    } else {
                        if(position <= 1) {
                            nodeToInsert.next = head;
                            head.prev = nodeToInsert;
                            tail = head;
                            head = nodeToInsert;
                        } else {
                            nodeToInsert.prev = tail;
                            tail.next = nodeToInsert;
                            head = tail;
                            tail = nodeToInsert;
                        }
                    }
                }
            }

            public void removeNodesWithValue(int value) {
                Node start = head;
                while(start != null) {
                    if(start.value == value) {
                        Node next = start.next;
                        remove(start);
                        start = next;
                    } else {
                        start = start.next;
                    }

                }
            }

            public void remove(Node node) {
                if(tail == head) {
                    if(node == head) {
                        head = null;
                        tail = null;
                        node.next = null;
                        node.prev = null;
                        return;
                    }
                }

                Node start = head;
                while(start != null) {
                    if(start == node) {
                        Node prev = start.prev;
                        Node next = start.next;

                        if(prev != null && next != null) {
                            prev.next = next;
                            next.prev = prev;
                        } else if(prev != null) {
                            prev.next = null;
                            tail = prev;
                        } else if(next != null) {
                            next.prev = null;
                            head = next;
                        }

                        next = start.next;
                        start.next = null;
                        start.prev = null;
                        start = next;
                    }

                    if(start != null) {
                        start = start.next;
                    }
                }
            }

            public boolean containsNodeWithValue(int value) {
                Node start = head;
                while(start != null) {
                    if(start.value == value) {
                        return true;
                    }
                    start = start.next;
                }

                return false;
            }
        }

        // Do not edit the class below.
        static class Node {
            public int value;
            public Node prev;
            public Node next;

            public Node(int value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return value + " " + next;
            }

            public String toStringPrev() {
                return value + " " + (prev != null ? prev.toStringPrev() : null);
            }
        }
    }
}
