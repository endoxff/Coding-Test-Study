import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> days = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) 
            if ((100 - progresses[i]) % speeds[i] == 0) 
                days.offer((100 - progresses[i]) / speeds[i]);
            else 
                days.offer((100 - progresses[i]) / speeds[i] + 1);
        
        ArrayList<Integer> list = new ArrayList<>();
        int base = days.poll();
        int cnt = 1;
        
        while(!days.isEmpty()) {
            
            if (days.peek() <= base) {
                days.poll();
                cnt++;
                
                if (days.isEmpty()) 
                    list.add(cnt);
            } else {
                list.add(cnt);
                cnt = 1;
                base = days.poll(); 
                
                if (days.isEmpty()) 
                    list.add(cnt);
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) 
            answer[i] = list.get(i);
    return answer;
    }
}