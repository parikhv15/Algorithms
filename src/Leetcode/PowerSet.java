package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vrajp on 4/18/2016.
 */
public class PowerSet {

    public static void main(String a[]) {
        PowerSet ps = new PowerSet();

        // Input Array
        int nums[] = {1, 2, 3};
        System.out.println(ps.getPowerSet(nums));
    }

    public List<List<Integer>> getPowerSet(int[] nums) {
        List<Integer> set = new ArrayList<Integer>();
        List<List<Integer>> powerSet = new ArrayList<List<Integer>>();

        powerSetUtil(nums, 0, set, powerSet);

        return powerSet;
    }

    public void powerSetUtil(int[] nums, int index, List<Integer> set, List<List<Integer>> powerSet) {
        if (index == nums.length) {
            powerSet.add(new ArrayList<Integer>(set));
        }
        else {
            set.add(nums[index]);
            powerSetUtil(nums, index+1, set, powerSet);
            set.remove(set.size() - 1);
            powerSetUtil(nums, index+1, set, powerSet);

        }
    }
}
