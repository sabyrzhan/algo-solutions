package kz.sabyrzhan.algo.leetcode.problems.p1046;

import java.util.*;

public class LastStoneWeight {
    public static void main(String[] args) {
        LastStoneWeight p = new LastStoneWeight();
        p.execute();
    }

    private void execute() {
        int[] input = {2,7,4,1,8,1};

        Solution s = new Solution();
        int result = s.lastStoneWeight(input);
        System.out.println(result);
    }

    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for(int a : stones) {
                pq.add(a);
            }

            while(pq.size() > 1) {
                pq.add(pq.poll() - pq.poll());
            }

            return pq.poll();
        }

        public int lastStoneWeightAsArray(int[] stones) {
            List<Integer> items = new ArrayList<>();
            for(int a : stones) {
                items.add(a);
            }
            Collections.sort(items);
            int i = items.size() - 1;
            while(i >= 0) {
                if (items.size() <= 1) {
                    break;
                }

                int first = items.get(i - 1);
                int second = items.get(i);

                items.remove(items.size() - 1);
                items.remove(items.size() - 1);
                if (second - first != 0) {
                    items.add(second - first);
                    Collections.sort(items);
                }

                i = items.size() - 1;
            }

            return items.isEmpty() ? 0 : items.get(0);
        }
    }
}
