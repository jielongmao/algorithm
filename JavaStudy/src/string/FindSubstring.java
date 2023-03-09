package string;

import java.util.*;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2023/1/3 11:14
 */
public class FindSubstring {

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        List<Integer> substring = findSubstring(s, words);
        for (int i : substring) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        int sLen = s.length(); // 字符串s长度
        int len = words.length; // 能使用的单词总数量
        int wLen = words[0].length(); // 单个单词的长度
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < wLen; i++) {
            if (i + wLen * len > sLen) {
                break;
            }
            Map<String, Integer> differ = new HashMap<>();
            for (int j = 0; j < len; j++) {
                String word = s.substring(i + j * wLen, i + (j + 1) * wLen);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < sLen - wLen * len + 1; start += wLen) {
                if (start != i) {
                    String word = s.substring(start + (len - 1) * wLen, start + len * wLen);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - wLen, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }

    public static List<Integer> findSubstring1(String s, String[] words) {
        if (s == null || "".equals(s) || words.length == 0 || words[0].length() == 0) {
            return null;
        }
        int sLen = s.length();
        int len = words.length;
        int wLen = words[0].length();

        List<Integer> ansList = new ArrayList<>();

        Map<Integer, List<Integer>> wordMap = new HashMap<>();
        for (int i = 0; i <= sLen - wLen; i++) {
            String sub = s.substring(i, i + wLen);
            List<Integer> list = findWord(sub, words);
            if (list.size() != 0) {
                wordMap.put(i, list);
            }
        }
        for (int i = 0; i <= sLen - len * wLen; i++) {
            if (wordMap.get(i) != null) {
                int j = i;
                int time = 0;
                Set<Integer> set = new HashSet<>();
                while (set.size() < len && j < sLen && time < len) {
                    List<Integer> list = wordMap.get(j);
                    if (list == null) {
                        break;
                    }
                    int m = -1;
                    for (int k : list) {
                        if (!set.contains(k)) {
                            m = k;
                            break;
                        }
                    }
                    if (m == -1) {
                        break;
                    }
                    set.add(m);
                    j += wLen;
                    time++;
                }
                if (set.size() == len) {
                    ansList.add(i);
                }
            }
        }
        return ansList;
    }

    public static List<Integer> findWord(String word, String[] words) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                list.add(i);
            }
        }
        return list;
    }

}
