package kz.sabyrzhan.algo.base_algorithms;

import kz.sabyrzhan.algo.data_structures.NodeWithLeftAndRight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class BFSTest {
    private BFS bfs = new BFS();
    NodeWithLeftAndRight root;

    @BeforeEach
    void setup() {
        root = new NodeWithLeftAndRight(1);
        root.setLeft(new NodeWithLeftAndRight(2));
        root.setRight(new NodeWithLeftAndRight(3));

        root.getLeft().setLeft(new NodeWithLeftAndRight(4));
        root.getLeft().setRight(new NodeWithLeftAndRight(5));

        root.getRight().setLeft(new NodeWithLeftAndRight(6));
        root.getRight().setRight(new NodeWithLeftAndRight(7));

        root.getRight().getLeft().setRight(new NodeWithLeftAndRight(8));
    }

    @Test
    void testIdentifyLevel() {
        int value = bfs.identifyLevel(root, 8);
        assertEquals(4, value);
    }

    @Test
    void testVisitAll() {
        var values = bfs.visitAll(root);
        assertEquals(Arrays.asList(1,2,3,4,5,6,7,8), values);
    }

}