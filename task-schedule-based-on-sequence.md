# Task Schedule\(based on sequence\)

```text
task scheduler can't change the sequence
Eg: 11212 and cooldown is 2
so 1__12_12 the result is 8(length)

Next follow up will be if the task can change the sequence:

https://leetcode.com/problems/task-scheduler/
```

```java
public int taskSchedule(int[] tasks, int cooldown) {
    int time = 0;
    //key: task  value: next same task valid start time
    HashMap<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < tasks.length; i++) {
        int curr = tasks[i];
        if (!map.containsKey(curr)) {
            //store the earlist task that can start
            //eg current time is 0, tasks[1, 1] coldown 2 
            //map should put(1, 0 + 2 + 1 = 3); means next 1 come should wait till time 3 to start
            map.put(curr, time + cooldown + 1);
        } else {
            int latest = map.get(curr);
            //time >= latest, now the task can valid start
            if (time >= latest) {
                map.put(curr, time + cooldown + 1);
            } else {
                //we add i every loop, if time still less then latest, we need stay for cooldown
                i--;
            }
        }
        time++;
    }
    return time;
}
```

