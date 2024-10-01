import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int value : scoville) {
            queue.add(value);
        }

        int answer = 0;
        while (queue.peek() < K && queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            int tmp = first + second * 2;
            queue.add(tmp);
            answer++;
        }
        if (queue.peek() < K) {
            answer = -1;
        }

        return answer;
    }
}