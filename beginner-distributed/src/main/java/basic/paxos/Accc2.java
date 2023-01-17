package basic.paxos;

import org.apache.commons.lang3.RandomUtils;

import java.util.*;

/**
 * @author ：ysh
 * Created in 2023/1/17 16:16
 */
public class Accc2 {
    public int[] topKFrequent(int[] nums, int k) {


        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (Integer integer : nums) {
            Integer temp = map.get(integer);
            if (Objects.isNull(temp)) {
                temp = 0;
            }
            map.put(integer, ++temp);
        }

        LinkedHashMap<Integer, Integer> integerIntegerMap = sortByComparator(map, true);

        return null;
    }


    public static void main(String[] args) {
        int[] nums = new int[10_000_000];
        for (int i = 0; i < 10_000_000; i++) {
            nums[i] = RandomUtils.nextInt(1, 100);
        }
        Accc2 accc1 = new Accc2();
        int[] ints = accc1.topKFrequent(nums, 2);
    }

    private static LinkedHashMap<Integer, Integer> sortByComparator(Map<Integer, Integer> map, final boolean order) {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                if (order) {
                    return o1.getValue().compareTo(o2.getValue());
                } else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

}
