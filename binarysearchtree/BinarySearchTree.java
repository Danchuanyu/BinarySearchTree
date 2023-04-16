import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    private class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
        }
    }

    public void insert(T data) {
        if (root == null) {
            root = new Node<T>(data);
            return;
        }

        insertHelper(root, data);
    }

    private void insertHelper(Node<T> node, T data) {
        if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<T>(data);
            } else {
                insertHelper(node.left, data);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<T>(data);
            } else {
                insertHelper(node.right, data);
            }
        }
    }

    public void delete(T data) {
        root = deleteHelper(root, data);
    }

    private Node<T> deleteHelper(Node<T> node, T data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.data) < 0) {
            node.left = deleteHelper(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = deleteHelper(node.right, data);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                Node<T> temp = findMin(node.right);
                node.data = temp.data;
                node.right = deleteHelper(node.right, temp.data);
            }
        }

        return node;
    }

    private Node<T> findMin(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public boolean contains(T data) {
        return containsHelper(root, data);
    }

    private boolean containsHelper(Node<T> node, T data) {
        if (node == null) {
            return false;
        }

        if (data.compareTo(node.data) < 0) {
            return containsHelper(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            return containsHelper(node.right, data);
        } else {
            return true;
        }
    }

    public String toString() {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<Node<T>> queue = new ArrayList<Node<T>>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> current = queue.remove(0);
            if (current == null) {
                sb.append("N, ");
            } else {
                sb.append(current.data.toString() + ", ");
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        sb.deleteCharAt(sb.length() - 2); // remove last ", "
        return sb.toString();
    }

    public BinarySearchTree<T> rebalance() {
        ArrayList<T> inOrderList = inOrder();
        BinarySearchTree<T> newTree = new BinarySearchTree<T>();
        addInOrder(inOrderList, 0, inOrderList.size() - 1, newTree);
        return newTree;
    }
    
    private ArrayList<T> inOrder() {
        return null;
    }

    private void addInOrder(ArrayList<T> inOrderList, int start, int end, BinarySearchTree<T> tree) {
        if (start <= end) {
            int mid = (start + end) / 2;
            tree.insert(inOrderList.get(mid));
            addInOrder(inOrderList, start, mid - 1, tree);
            addInOrder(inOrderList, mid + 1, end, tree);
        }
    }
    /**
 * Partitions the tree into two halves based on the median element
 * and returns an array list containing the two halves.
     * @param album
 *
 * @return An array list containing the two halves of the partitioned tree.
 */
public ArrayList<BinarySearchTree<T>> partition(Album album) {
    ArrayList<T> sortedList = inOrder();
    int size = sortedList.size();
    if (size <= 1) {
        ArrayList<BinarySearchTree<T>> emptyResult = new ArrayList<>();
        emptyResult.add(this);
        emptyResult.add(new BinarySearchTree<T>());
        return emptyResult;
    }

    int medianIndex = size / 2;
    T median = sortedList.get(medianIndex);
    BinarySearchTree<T> leftSubtree = new BinarySearchTree<>();
    BinarySearchTree<T> rightSubtree = new BinarySearchTree<>();
    for (int i = 0; i < size; i++) {
        T current = sortedList.get(i);
        if (current.compareTo(median) < 0) {
            leftSubtree.insert(current);
        } else if (current.compareTo(median) > 0) {
            rightSubtree.insert(current);
        }
    }

    ArrayList<BinarySearchTree<T>> result = new ArrayList<>();
    result.add(leftSubtree);
    result.add(rightSubtree);
    return result;
}

    public Object getRoot() {
        return null;
    }

    public String size() {
        return null;
    }

    public String getTitle() {
        return null;
    }

}    
