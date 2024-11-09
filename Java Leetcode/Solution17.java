// 17. Letter Combinations of a Phone Number

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution17 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }

        Map<Character, String> digToLtrs = new HashMap<>();
        digToLtrs.put('2', "abc");
        digToLtrs.put('3', "def");
        digToLtrs.put('4', "ghi");
        digToLtrs.put('5', "jkl");
        digToLtrs.put('6', "mno");
        digToLtrs.put('7', "pqrs");
        digToLtrs.put('8', "tuv");
        digToLtrs.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), res, digToLtrs);

        return res;

    }

    private void backtrack(String digits, int idx, StringBuilder comb, List<String> res, Map<Character, String> digToLtrs) {
        if (idx == digits.length()) {
            res.add(comb.toString());
            return;
        }
        String letters = digToLtrs.get(digits.charAt(idx));
        for (char letter : letters.toCharArray()) {
            comb.append(letter);
            backtrack(digits, idx + 1, comb, res, digToLtrs);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}
