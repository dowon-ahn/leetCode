package Medium;

/**
 * 46. Permutations
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
class Q46 {
    static List<List<Integer>> list;
    static List<Integer> temp;
    static HashMap<Integer, Boolean> hm;

    static void go(int dep, int n, int[] nums) {
        if (dep == nums.length) {
            List<Integer> ans = new LinkedList<Integer>();
            //add
            for (int i = 0; i < temp.size(); i++) {
                ans.add(temp.get(i));
            }
            list.add(ans);

            return;
        }

        for (int i = 0; i < n; i++) {
            if (hm.get(nums[i]) == null) {
                hm.put(nums[i], true);
                temp.add(nums[i]);
                go(dep + 1, n, nums);
                temp.remove((Object) nums[i]);
                hm.remove((Object) nums[i]);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        list = new LinkedList<List<Integer>>();
        hm = new HashMap<Integer, Boolean>();
        temp = new LinkedList<Integer>();
        go(0, nums.length, nums);

        return list;
    }

    /**
     * 테스트
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
