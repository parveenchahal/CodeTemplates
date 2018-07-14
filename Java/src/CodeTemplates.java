
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.LinkedList;

//==============================================================================================================================
//Template
//==============================================================================================================================
class CodeTemplates {

//==============================================================================================================================
//Constants
//==============================================================================================================================
    public static int MOD = ((int) 1e9 + 7);
    public static double PI = Math.PI;
    public static Comparator<Integer> reverseIntegerComparator = (Integer o1, Integer o2) -> o2 - o1;

//==============================================================================================================================
//Methods
//==============================================================================================================================
    public static BufferedReader getBufferedReaderInstance() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static int readIntegerFromLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static long readLongFromLine(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine());
    }

    public static double readDoubleFromLine(BufferedReader br) throws IOException {
        return Double.parseDouble(br.readLine());
    }

    public static int[] readIntegerArrayFromLine(BufferedReader br) throws IOException {
        return toIntArrFromStringArr(br.readLine().split(" "));
    }

    public static long[] readLongArrayFromLine(BufferedReader br) throws IOException {
        return toLongArrFromStringArr(br.readLine().split(" "));
    }

    public static double[] readDoubleArrayFromLine(BufferedReader br) throws IOException {
        return toDoubleArrFromStringArr(br.readLine().split(" "));
    }

    public static String readLineFromLine(BufferedReader br) throws IOException {
        return br.readLine();
    }

    public static void println(Object... obj) {
        String x = "";
        for (Object o : obj) {
            if (o != null) {
                x += o.toString() + ", ";
            } else {
                x += "null, ";
            }
        }
        if (x.length() > 0) {
            System.out.println(x.substring(0, x.length() - 2));
        } else {
            System.out.println(x);
        }
    }

    public static void printArray(int[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    public static void printArray(char[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    public static void printArray(long[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    public static void printArray(double[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] col : matrix) {
            for (int x : col) {
                System.out.print(x + "\t");
            }
            System.out.println();
        }
    }

    public static void printMatrix(long[][] matrix) {
        for (long[] col : matrix) {
            for (long x : col) {
                System.out.print(x + "\t");
            }
            System.out.println();
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] col : matrix) {
            for (char x : col) {
                System.out.print(x + "\t");
            }
            System.out.println();
        }
    }

    public static String factorial(int n) {
        if (n >= 0) {
            BigInteger one = new BigInteger("1");
            BigInteger N = new BigInteger(Integer.toString(n));
            BigInteger factorial = new BigInteger(N.toString());
            N = N.subtract(one);
            while (N.compareTo(one) > 0) {
                factorial = factorial.multiply(N);
                N = N.subtract(one);
            }
            return factorial.toString();
        } else {
            throw new InvalidParameterException("n should be greater than equal to 0");
        }
    }

    public static String nCr(int n, int r) {
        if (n >= r && r > 0) {
            return new BigInteger(nPr(n, r)).divide(new BigInteger(factorial(r))).toString();
        } else {
            throw new InvalidParameterException("n and r should be positive and n should be greater than equal to r");
        }

    }

    public static String nPr(int n, int r) {
        if (n >= r && r > 0) {
            return new BigInteger(factorial(n)).divide(new BigInteger(factorial(n - r))).toString();
        } else {
            throw new InvalidParameterException("n and r should be positive and n should be greater than equal to r");
        }
    }

    public static int max(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    public static int min(int[] arr) {
        return Arrays.stream(arr).min().getAsInt();
    }

    public static long max(long[] arr) {
        return Arrays.stream(arr).max().getAsLong();
    }

    public static long min(long[] arr) {
        return Arrays.stream(arr).min().getAsLong();
    }

    public static double max(double[] arr) {
        return Arrays.stream(arr).max().getAsDouble();
    }

    public static double min(double[] arr) {
        return Arrays.stream(arr).min().getAsDouble();
    }

    public static double max(double a, double b, double c) {
        return Math.max(a, Math.max(b, c));
    }

    public static double min(double a, double b, double c) {
        return Math.min(a, Math.min(b, c));
    }

    public static int[] toIntArrFromStringArr(String[] arr) {
        return Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
    }

    public static long[] toLongArrFromStringArr(String[] arr) {
        return Arrays.stream(arr).mapToLong(Long::parseLong).toArray();
    }

    public static double[] toDoubleArrFromStringArr(String[] arr) {
        return Arrays.stream(arr).mapToDouble(Double::parseDouble).toArray();
    }

    public static void reverse(List<?> list) {
        Collections.sort(list, Collections.reverseOrder());
    }

    public static void reverse(int[] arr) {
        int N = arr.length;
        int lastIndex = N - 1;
        int half = N / 2;
        for (int i = 0; i < half; i++) {
            int t = arr[i];
            arr[i] = arr[lastIndex - i];
            arr[lastIndex - i] = t;
        }
    }

    public static void reverse(long[] arr) {
        int N = arr.length;
        int lastIndex = N - 1;
        int half = N / 2;
        for (int i = 0; i < half; i++) {
            long t = arr[i];
            arr[i] = arr[lastIndex - i];
            arr[lastIndex - i] = t;
        }
    }

    public static void reverse(double[] arr) {
        int N = arr.length;
        int lastIndex = N - 1;
        int half = N / 2;
        for (int i = 0; i < half; i++) {
            double t = arr[i];
            arr[i] = arr[lastIndex - i];
            arr[lastIndex - i] = t;
        }
    }

    public static void reverse(char[] arr) {
        int N = arr.length;
        int lastIndex = N - 1;
        int half = N / 2;
        for (int i = 0; i < half; i++) {
            char t = arr[i];
            arr[i] = arr[lastIndex - i];
            arr[lastIndex - i] = t;
        }
    }

    public static String reverse(String str) {
        char[] charArr = str.toCharArray();
        reverse(charArr);
        StringBuilder sb = new StringBuilder();
        for (char c : charArr) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcd(a - b, b);
        }
        return gcd(a, b - a);
    }

    public static long lcm(int[] arr) {
        long lcm = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    return 0;
                } else if (arr[i] < 0) {
                    arr[i] = arr[i] * (-1);
                }
                if (arr[i] == 1) {
                    counter++;
                }
                if (arr[i] % divisor == 0) {
                    divisible = true;
                    arr[i] = arr[i] / divisor;
                }
            }
            if (divisible) {
                lcm = lcm * divisor;
            } else {
                divisor++;
            }
            if (counter == arr.length) {
                return lcm;
            }
        }
    }

    public static double logNWithBase(double N, double base) {
        return Math.log(N) / Math.log(base);
    }

//==============================================================================================================================
//Classes
//==============================================================================================================================
    public static class Queue<E> extends LinkedList<E> {

        public Queue() {
        }

        public void enqueue(E value) {
            add(value);
        }

        public E dequeue() {
            if (size() <= 0) {
                return null;
            }
            return pollFirst();
        }

    }

    public static class PowerSet<E> {

        public List<Set<E>> get(E[] arr) {
            long nSets = 0;
            int N = arr.length;
            for (int i = 0; i < N; i++) {
                nSets = (nSets << 1) | 1;
            }
            ArrayList<Set<E>> result = new ArrayList<>();
            result.add(new HashSet<>());
            for (long i = 1; i <= nSets; i++) {
                Set<E> s = new HashSet<>();
                long p = i;
                for (int j = 0; p > 0; j++, p >>>= 1) {
                    if ((p & 1) > 0) {
                        s.add(arr[j]);
                    }
                }
                result.sort((Set<E> o1, Set<E> o2) -> o1.size() - o2.size());
                result.add(s);
            }
            return result;
        }
    }

    public static class AVLTree<K extends Comparable<K>, V> {

        private class Node implements Comparable<Node> {

            K key;
            V value;
            Node left, right;
            int size, height, BF;

            public Node(K key) {
                this(key, null);
            }

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
                this.left = null;
                this.right = null;
                this.size = 1;
                this.height = 1;
                this.BF = 0;
            }

            @Override
            public int compareTo(Node o) {
                if (comparator != null) {
                    return comparator.compare(key, o.key);
                }
                return key.compareTo(o.key);
            }

            @Override
            public String toString() {
                return "{Key: " + key.toString() + " ----> LC: " + (left != null ? left.key.toString() : "null") + ", RC: " + (right != null ? right.key.toString() : "null") + ", Height: " + height + ", BF: " + BF + ", Size: " + size + "}";
            }
        }

        private Node root;
        private Comparator comparator;

        public AVLTree() {
            this.root = null;
            this.comparator = null;
        }

        public AVLTree(Comparator<K> c) {
            this.root = null;
            this.comparator = c;
        }

        public boolean contains(K key) {
            return get(root, new Node(key, null)) != null;
        }

        public V get(K key) {
            Node node = get(root, new Node(key, null));
            if (node != null) {
                return node.value;
            }
            return null;
        }

        private Node get(Node root, Node key) {
            if (root == null) {
                return null;
            }
            int cmp = key.compareTo(root);
            if (cmp < 0) {
                return get(root.left, key);
            } else if (cmp > 0) {
                return get(root.right, key);
            }
            return root;
        }

        private int height(Node node) {
            if (node != null) {
                return node.height;
            }
            return 0;
        }

        private int size(Node node) {
            if (node != null) {
                return node.size;
            }
            return 0;
        }

        public void insert(K key) {
            insert(key, null);
        }

        public void insert(K key, V value) {
            if (key != null) {
                root = insert(root, new Node(key, value));
            }
        }

        private Node insert(Node root, Node newNode) {
            if (root == null) {
                return newNode;
            }
            int cmp = newNode.compareTo(root);
            if (cmp < 0) {
                root.left = insert(root.left, newNode);
            } else if (cmp > 0) {
                root.right = insert(root.right, newNode);
            } else {
                root.value = newNode.value;
            }
            resetHeightBfSize(root);
            return ifAffectedThenBalanceIt(root);
        }

        private Node ifAffectedThenBalanceIt(Node root) {
            if (root.BF > 1) {
                if (root.left.BF > 0) {
                    root = rotateRight(root);
                } else {
                    root.left = rotateLeft(root.left);
                    root = rotateRight(root);
                }
            } else if (root.BF < -1) {
                if (root.right.BF < 0) {
                    root = rotateLeft(root);
                } else {
                    root.right = rotateRight(root.right);
                    root = rotateLeft(root);
                }
            }
            return root;
        }

        private Node rotateRight(Node A) {
            Node B = A.left;
            Node C = B.right;
            A.left = C;
            B.right = A;
            resetHeightBfSize(A);
            resetHeightBfSize(B);
            return B;
        }

        private void resetHeightBfSize(Node node) {
            node.height = Math.max(height(node.left), height(node.right)) + 1;
            node.size = size(node.left) + size(node.right) + 1;
            node.BF = height(node.left) - height(node.right);
        }

        private Node rotateLeft(Node A) {
            Node B = A.right;
            Node C = B.left;
            A.right = C;
            B.left = A;
            resetHeightBfSize(A);
            resetHeightBfSize(B);
            return B;
        }

        public void preOrder() {
            preOrder(root);
        }

        private void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.println(root);
            preOrder(root.left);
            preOrder(root.right);
        }

        public void inOrder() {
            inOrder(root);
        }

        private void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.println(root);
            inOrder(root.right);
        }

        public int size() {
            return size(root);
        }

        public int height() {
            return height(root);
        }

        public int rank(K key) {
            if (key != null) {
                return rank(root, new Node(key), 1);
            }
            return -1;
        }

        private int rank(Node root, Node key, int rank) {
            if (root == null) {
                return -1;
            }
            int cmp = key.compareTo(root);
            if (cmp < 0) {
                rank = rank(root.left, key, rank);
            } else if (cmp > 0) {
                rank = rank(root.right, key, rank + size(root.left) + 1);
            } else {
                return size(root.left) + rank;
            }
            return rank;
        }

    }

    public static class Graph<E, P> {

        private Map<E, List<Edge<E, P>>> map;

        static public class Edge<E, P> {

            private E u, v;
            private P param;

            public E getU() {
                return u;
            }

            public E getV() {
                return v;
            }

            public P getParams() {
                return param;
            }

            public Edge(E u, E v, P params) {
                this.u = u;
                this.v = v;
                this.param = params;
            }

            public Edge(Edge<E, P> edge) {
                this.u = edge.u;
                this.v = edge.v;
                this.param = edge.param;
            }

            public Edge(Edge<E, P> edge, P params) {
                this.u = edge.u;
                this.v = edge.v;
                this.param = params;
            }

            @Override
            public String toString() {
                return "{u=" + u.toString() + ", v=" + v.toString() + ", param=" + param.toString() + "}";
            }
        }

        public Graph() {
            map = new HashMap<>();
        }

        @Override
        public String toString() {
            return map.toString();
        }

        public void addEdge(Edge<E, P> edge) {
            List<Edge<E, P>> list = map.get(edge.u);
            if (list != null) {
                list.add(edge);
            } else {
                list = new ArrayList<>();
                list.add(edge);
                map.put(edge.u, list);
            }
        }

        public List<Edge<E, P>> getConnections(E u) {
            return map.get(u);
        }

        public void reverseAllDirections() {
            Graph<E, P> newGraph = new Graph();
            for (Map.Entry<E, List<Edge<E, P>>> entry : map.entrySet()) {
                List<Graph.Edge<E, P>> list = entry.getValue();
                list.forEach((edge) -> {
                    newGraph.addEdge(new Edge(edge.v, edge.u, edge.param));
                });
            }
            this.map = newGraph.map;
        }
    }

    public static class HeapMap<E> {

        private Map<Object, Integer> map;

        private Object[] elementData;

        private final int INITIAL_CAPACITY = 50;

        private final int GROW_CAPACITY = 100;

        private final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

        private final Comparator<? super E> comparator;

        private int size = 0;

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOf(elementData, size)) + "\n" + map.toString();
        }

        public HeapMap() {
            this.elementData = new Object[INITIAL_CAPACITY];
            this.comparator = null;
            this.map = new HashMap<>();
        }

        public HeapMap(Comparator<? super E> comparator) {
            this.elementData = new Object[INITIAL_CAPACITY];
            this.comparator = comparator;
            this.map = new HashMap<>();
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size <= 0;
        }

        private void grow() {
            int oldLength = elementData.length;
            if (oldLength == MAX_ARRAY_SIZE) {
                throw new ArrayIndexOutOfBoundsException("Can't allocate continuous memory any more");
            }
            int newLength = oldLength + GROW_CAPACITY;
            if (newLength > MAX_ARRAY_SIZE) {
                newLength = MAX_ARRAY_SIZE;
            }
            elementData = Arrays.copyOf(elementData, newLength);
        }

        public void insert(E e) {
            if (elementData.length <= size) {
                grow();
            }
            elementData[size] = e;
            siftUp(size);
            size++;
        }
        
        public boolean contains(E e) {
            return map.containsKey(e);
        }

        public E remove() {
            if (size <= 0) {
                return null;
            }
            Object removedElement = elementData[0];
            map.remove(removedElement);
            Object lastElement = elementData[--size];
            elementData[size] = null;
            if (size > 0) {
                elementData[0] = lastElement;
                siftDown(0);
            }
            return (E) removedElement;
        }

        public void change(E oldE, E newE) {
            try {
                Integer index = map.get(oldE);
                if (index != null) {
                    map.remove(oldE);
                    change(index, newE);
                } else {
                    throw new Exception("Object not found in HashMap");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void change(int index, E newE) {
            int cmp = compare(newE, (E) elementData[index]);
            elementData[index] = newE;
            if (cmp < 0) {
                siftUp(index);
            } else if (cmp > 0) {
                siftDown(index);
            }
        }

        private int compare(E e1, E e2) {
            if (comparator != null) {
                return comparator.compare(e1, e2);
            }
            Comparable<? super E> key = (Comparable<? super E>) e1;
            return key.compareTo(e2);
        }

        private static int iParent(int index) {
            return (index - 1) >>> 1;
        }

        private static int iLeftChild(int index) {
            return (index << 1) + 1;
        }

        private static int iRightChild(int index) {
            return (index << 1) + 2;
        }

        private void siftUp(int index) {
            Object temp = elementData[index];
            while (index > 0) {
                int parent = iParent(index);
                if (compare((E) temp, ((E) elementData[parent])) >= 0) {
                    break;
                }
                elementData[index] = elementData[parent];
                map.put(elementData[parent], index);
                index = parent;
            }
            elementData[index] = temp;
            map.put(temp, index);
        }

        private void siftDown(int index) {
            if (size < 2) {
                return;
            }
            int lastParent = iParent(size - 1);
            Object temp = elementData[index];
            while (index <= lastParent) {
                int childIndex = iLeftChild(index);
                E child = (E) elementData[childIndex];
                int rightIndex = iRightChild(index);
                if (rightIndex < size && compare(child, (E) elementData[rightIndex]) > 0) {
                    child = (E) elementData[rightIndex];
                    childIndex = rightIndex;
                }
                if (compare((E) temp, child) <= 0) {
                    break;
                }
                elementData[index] = child;
                map.put(child, index);
                index = childIndex;
            }
            elementData[index] = temp;
            map.put(temp, index);
        }

        private void heapify() {
            for (int i = iParent(size - 1); i >= 0; i--) {
                siftDown(i);
            }
        }

    }

    public static class Point<E> {

        private E x;
        private E y;

        public Point(E x, E y) {
            this.x = x;
            this.y = y;
        }

        public E getX() {
            return x;
        }

        public void setX(E x) {
            this.x = x;
        }

        public E getY() {
            return y;
        }

        public void setY(E y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "(x : " + this.x + ", y : " + this.y + ")";
        }
    }
}
