package trieTree.leetcode;

/**
 * @Description 前缀树
 * @Author: tmj
 * @Data: 2022/9/15 14:46
 */
public class Trie {

    public int pass;

    public int end;

    public Trie[] nexts;

    /** Initialize your data structure here. */
    public Trie() {
        pass = 0;
        end = 0;
        nexts = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        if(word != null && !search(word) ){
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int j = chars[i] - 'a';
                if(root.nexts[j] == null){
                    root.nexts[j] = new Trie();
                }
                root = root.nexts[j];
                root.pass++;
            }
            root.end++;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie root = this;
        if(word != null){
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int j = chars[i] - 'a';
                if(root.nexts[j] == null){
                    return false;
                }
                root = root.nexts[j];
            }
            return root.end>0;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie root = this;
        if(prefix != null){
            char[] chars = prefix.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int j = chars[i] - 'a';
                if(root.nexts[j] == null){
                    return false;
                }
                root = root.nexts[j];
            }
            return true;
        }
        return false;
    }
}
