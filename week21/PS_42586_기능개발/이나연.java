import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.add(day);
        }

        ArrayList<Integer> list = new ArrayList<>();
        int sum = queue.peek();
        int count = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now > sum) {
                list.add(count); //배포
                sum = now;
                count = 1;
            } else {
                count++;
            }
        }
        list.add(count);

        int[] answer = list.stream()
                .mapToInt(i -> i)
                .toArray();
        return answer;
    }
}