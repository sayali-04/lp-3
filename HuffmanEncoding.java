import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node left, right;

    public Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }

    // For priority queue sorting (ascending order of frequency)
    public int compareTo(Node other) {
        return this.freq - other.freq;
    }
}

public class HuffmanEncoding {

    // Recursive function to print Huffman codes
    static void printHuffmanCodes(Node root, String code) {
        if (root == null)
            return;

        // If it's a leaf node → print the character and its code
        if (root.left == null && root.right == null && Character.isLetter(root.ch)) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        // Traverse left (append 0) and right (append 1)
        printHuffmanCodes(root.left, code + "0");
        printHuffmanCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] characters = new char[n];
        int[] frequency = new int[n];

        
        System.out.println("Enter characters: ");
        for (int i = 0; i < n; i++) {
            characters[i] = sc.next().charAt(0);
        }

        
        System.out.println("Enter their frequencies: ");
        for (int i = 0; i < n; i++) {
            frequency[i] = sc.nextInt();
        }

        // Step 1: Create a priority queue (min-heap)
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(new Node(characters[i], frequency[i]));
        }

        // Step 2: Build Huffman Tree
        while (pq.size() > 1) {
            // Extract two smallest frequency nodes
            Node left = pq.poll();
            Node right = pq.poll();

            // Create new internal node with combined frequency
            Node newNode = new Node('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;

            pq.add(newNode);
        }

        // Step 3: Print Huffman Codes
        Node root = pq.peek();
        System.out.println("\nHuffman Codes:");
        printHuffmanCodes(root, "");

        sc.close();
    }
}
