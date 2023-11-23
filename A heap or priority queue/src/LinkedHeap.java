class LinkedHeap {
    static class Node {
        int value;
        Node left;
        Node right;
        int size; // Total number of elements in the subtree rooted at this node

        Node(int value) {
            this.value = value;
            this.size = 1;
        }
    }

    private Node root;
    private int size;

    public LinkedHeap() {
        root = null;
        size = 0;
    }

    public void add(int value) {
        root = add(root, value);
        size++;
    }

    private Node add(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value > node.value) {
            // Swap the values to maintain the max-heap property
            int temp = value;
            value = node.value;
            node.value = temp;
        }

        if (size % 2 == 0) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                node.left = add(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                node.right = add(node.right, value);
            }
        }
        return node;
    }

    public int remove() {
        if (size == 0) {
            return -1; // Handle the case when the heap is empty.
        }

        int removedValue = root.value;
        size--;

        if (size == 0) {
            root = null;
        } else {
            // Promote the node with the highest priority
            root = removeAndPromote(root);
        }

        return removedValue;
    }

    private Node removeAndPromote(Node node) {
        // Remove and promote the node with the highest priority

        // If the left branch is empty, promote the right value
        if (node.left == null) {
            return node.right;
        }
        // If the right branch is empty or left is higher priority, promote the left value
        if (node.right == null || node.left.value > node.right.value) {
            int temp = node.value;
            node.value = node.left.value;
            node.left.value = temp;
            node.left = removeAndPromote(node.left);
        } else {
            int temp = node.value;
            node.value = node.right.value;
            node.right.value = temp;
            node.right = removeAndPromote(node.right);
        }

        // Decrement the size after removing
        node.size--;

        return node;
    }

    public int push(int incr) {
        int depth = push(root, incr);
        return depth;
    }

    private int push(Node node, int incr) {
        if (node == null) {
            return 0;
        }

        node.value += incr;

        int leftDepth = push(node.left, incr);
        int rightDepth = push(node.right, incr);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
