package kz.sabyrzhan.algo.aloexpert.easy;

import java.util.ArrayList;
import java.util.List;

public class T04_DFSSearch {
    public static void main(String[] args) {
        Program.Node root = new Program.Node("A");
        root.addChild("B");
        root.addChild("C");
        root.addChild("D");

        Program.Node B = root.children.get(0);
        B.addChild("E");
        B.addChild("F");

        Program.Node F = B.children.get(1);
        F.addChild("I");
        F.addChild("J");

        Program.Node D = root.children.get(2);
        D.addChild("G");
        D.addChild("H");

        Program.Node G = D.children.get(0);
        G.addChild("K");

        List<String> result = F.depthFirstSearch(new ArrayList<>());
        System.out.println(result);
    }

    static class Program {
        // Do not edit the class below except
        // for the depthFirstSearch method.
        // Feel free to add new properties
        // and methods to the class.
        static class Node {
            String name;
            List<Node> children = new ArrayList<Node>();

            public Node(String name) {
                this.name = name;
            }

            public List<String> depthFirstSearch(List<String> array) {
                if(array.contains(name)) {
                    return array;
                } else {
                    array.add(name);
                    for(Node child : children) {
                        child.depthFirstSearch(array);
                    }

                    return array;
                }
            }

            public Node addChild(String name) {
                Node child = new Node(name);
                children.add(child);
                return this;
            }
        }
    }
}
