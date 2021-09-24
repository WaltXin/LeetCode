package InterviewQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company: Pinterest
 * same task requires cooldown time to cooldown
 *  input: (1, 1, 2, 1), cooldownTime: 2
 *  output: 1 _ _ 1 2 _ 1  -> 7
 *
 *  input: (1, 2, 3, 1, 2, 3), cooldownTime: 3
 *  output: 1 2 3 _ 1 2 3 -> 7
 * */
public class CPUCooldown {
    public static int solution(int cooldown, List<Integer> tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int task : tasks) {
            int time = 0;
            if (map.containsKey(task)) {
                //check cooldown time
                time = map.get(task);
                count += time + 1;
                map.put(task, cooldown);
            } else {
                map.put(task, cooldown);
                count++;
            }

            //no matter what, we need to set all map values minus 1 (except current task)
            if (time == 0)
                time = 1;
            else // here the time is the gap, if we skip the gap, we need to add the gap and plus one (This is the time passed)
                time++;
            for (int key : map.keySet()) {
                if (key != task) {
                    map.put(key, map.get(key) - time);
                    if (map.get(key) <= 0)
                        map.put(key, 0);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 1, 2, 1);
        System.out.println(solution(2, list1));

        List<Integer> list2 = Arrays.asList(1, 2, 3, 1, 2, 3);
        System.out.println(solution(3, list2));
    }
}
