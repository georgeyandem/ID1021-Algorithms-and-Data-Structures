import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;

public class TreeIterator implements Iterator<Integer> 
{
        private BinaryTree.Node next;
        private Stack<BinaryTree.Node> stack;

        public TreeIterator(BinaryTree.Node root) {
            stack = new Stack<>();
            next = root;
            initializeStack();
        }

        private void initializeStack() {
            while (next != null) {
                stack.push(next);
                next = next.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            BinaryTree.Node current = stack.pop();
            Integer result = current.value;

            next = current.right;
            initializeStack();

            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
