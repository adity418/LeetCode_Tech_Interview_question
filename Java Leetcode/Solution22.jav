// 22. Generate Parentheses
// Given n pairs of parentheses, write a function to 
// generate all combinations of well-formed parentheses.

class Solution22{
    public List<String> generateParenthesis(int n){
        List <String> res = new ArrayList<>();

        dfs(0, 0, "", n, res);

        return res;
    }

    private void dfs(int openP, int closeP, String s, int n, List<String> res){
        if(openp == closeP && openP + clos+ == n * 2){
            res.add();
            return;
        }

        if (openP < n){
            dfs(openP + 1, closeP, s + "(", n, res);
        }

        if(closeP < openP){
            dfs(openP, closeP +  1, s + ")", n, res);
        }
    }
}


// class Solution {
//     public static boolean check(String s) {
//         int x = 0;
//         for (char c : s.toCharArray()) {
//             if (c == '(')
//                 x++;
//             else
//                 x--;
//             if (x < 0)
//                 return false;
//         }
//         return x == 0;
//     }

//     public void solve(int n, int open, int close, List<String> ans, StringBuilder builder) {
//         if (open + close == 2*n) {
//             String s = builder.toString();
//             ans.add(s);
//             return;
//         }
//         if(open < n){
//             builder.append('(');
//             solve(n, open + 1, close, ans, builder);
//             if(builder.length() > 0)
//                 builder.deleteCharAt(builder.length() - 1);
//         }
//         if(close < open) {
//             builder.append(')');
//             solve(n, open, close+1, ans, builder);
//             if(builder.length() > 0)
//                 builder.deleteCharAt(builder.length() - 1);
//         }
//     }

//     public List<String> generateParenthesis(int n) {
//         List<String> ans = new ArrayList<String>();
//         StringBuilder builder = new StringBuilder();
//         solve(n, 0, 0, ans, builder);
//         return ans;
//     }
// }