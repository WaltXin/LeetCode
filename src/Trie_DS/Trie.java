package Trie_DS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Trie {
    //build trie that stores words
    private class Node {
        Map<Character, Node> children;
        boolean isWord;

        public Node(boolean isWord) {
            this.isWord = isWord;
            children = new HashMap<>();
        }
    }

    private Node root;
    public Trie(String[] arr) {
        this.root = buildTrie(arr);
    }

    public Node buildTrie(String[] arr) {
        Node root = new Node(false);
        for (String str : arr) {
            Node temp = root;
            for (char c : str.toCharArray()) {
                if (temp.children.get(c) == null) {
                    temp.children.put(c, new Node(false));
                }
                temp = temp.children.get(c);
            }
            temp.isWord = true;
        }
        return root;
    }

    public Node getTrie() {
        return root;
    }

//    public void printAllWords(Node root, String s) {
//        //dfs print all words
//        if (root == null)
//            return;
//        if (root.isWord)
//            System.out.println(s);
//        for ()
//    }

    public String formatStr(String str) {
        int[] strArr = new int[24];
        for (Character ch : str.toCharArray()) {
            strArr[ch - 'a']++;
        }

        String model = "abcdefghijklmnopqrstuvwxyz";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 24; i++) {
            sb.append(strArr[i]);
            //covert i to alphabet
            sb.append(model.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arrs = {"abc", "apple", "because"};
        Trie trie = new Trie(arrs);
        Node root = trie.getTrie();

        System.out.println(trie.formatStr("aaabc"));
    }
}
