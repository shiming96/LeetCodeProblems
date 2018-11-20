import java.util.*;

class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {

        //统计频次
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                //传入比较器
                (a, b) -> map.get(a) - map.get(b)//用Lamda表达式表示匿名内部类
        );

        for(int key : map.keySet()) {
            if(pq.size() < k) {
                pq.add(key);
            }
            //当前key的频次比优先队列中频次最小的值大时
            else if(map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }
}
