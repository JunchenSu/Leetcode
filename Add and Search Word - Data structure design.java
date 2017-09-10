public class WordDictionary {

    private TrieNode root;
    
    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean end = false;
    }
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            if (node.children[w[i] - 'a'] == null) {
                node.children[w[i] - 'a'] = new TrieNode();
            } 
            node = node.children[w[i] - 'a'];
        }
        node.end = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] w = word.toCharArray();
        return searchHelper(w, 0, root);
    }
    
    private boolean searchHelper(char[] word, int i, TrieNode node) {
        if (i == word.length) return node.end == true;
        if (word[i] != '.') {
            if (node.children[word[i] - 'a'] == null) return false;
            else {
                return searchHelper(word, i+1, node.children[word[i] - 'a']);
            }
        } else {
            for (TrieNode trienode : node.children) {
                if (trienode != null) return searchHelper(word, i+1, trienode);
            }
        }
        return false;
    }
}
/*
trie常用来找longest prefix, 可以定义一个类A， 里面包含一个hashmap和一个用于表示是否到字符串尾的boolean，A里的map的key指向下一个A。
视频 ： https://www.youtube.com/watch?v=AXjmTQ8LEoI
**/
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
