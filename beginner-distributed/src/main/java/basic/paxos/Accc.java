package basic.paxos;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.RandomUtils;

import java.util.*;

/**
 * @author ：ysh
 * Created in 2023/1/17 16:16
 */
public class Accc {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer integer : nums) {
            Integer temp = map.get(integer);
            if (Objects.isNull(temp)) {
                temp = 0;
            }
            map.put(integer, ++temp);
        }

        return sortByComparator(map, false, k);

    }

    public static void main(String[] args) {
        int[] nums = new int[10_000];
        for (int i = 0; i < 10_000; i++) {
            nums[i] = RandomUtils.nextInt(1, 100);
        }
        Accc accc = new Accc();
        int[] ints = accc.topKFrequent(nums, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    private static int[] sortByComparator(Map<Integer, Integer> map, final boolean order, int k) {
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
//        LinkedList<Integer> integers = new LinkedList<>();
        int[] ints = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            ints[i] = (entry.getKey());
            i++;
            if (k == i) {
                break;
            }

        }
        return ints;
    }
}
