import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

public class TreeIterator implements Iterator<Integer> {
    private Queue<BinaryTree.Node> queue;

    public TreeIterator(BinaryTree.Node root) {
        queue = new LinkedList<>();
        if (root != null){
            queue.add(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        BinaryTree.Node current = queue.poll();
        Integer result = current.value;

        if (current.left != null){
            queue.offer(current.left);
        }
        if (current.right != null){
            queue.offer(current.right);
        }
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
