import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> al = new ArrayList<>();
        GP(n, 0, 0, "", al);
        return al;
    }

    private void GP(int n, int oc, int cc, String ans, ArrayList<String> al) {
        if (cc == n && oc == n) {
            al.add(ans);
            return;
        }
        if (oc < n) {
            GP(n, oc + 1, cc, ans + "(", al);
        }
        if (cc < oc) {
            GP(n, oc, cc + 1, ans + ")", al);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3; 
        List<String> result = solution.generateParenthesis(n);
        for (String s : result) {
            System.out.println(s);
        }
    }
}