import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        //강의 개수 N, 강의 시간 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> lectureTime = new PriorityQueue<>(); //강의 시작 시간을 기준으로 오름차순 정렬
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectureTime.add(new Lecture(start, end));
        }

        //강의실의 개수 구하기
        PriorityQueue<Integer> lectureEndTime = new PriorityQueue<>(); //강의 종료 시간 저장
        lectureEndTime.add(lectureTime.poll().end);
        int count = 1;
        while (!lectureTime.isEmpty()) {
            Lecture lecture = lectureTime.poll();
            int endTime = lectureEndTime.peek();
            if (lecture.start < endTime) {
                lectureEndTime.add(lecture.end);
                count++;
            } else {
                lectureEndTime.poll();
                lectureEndTime.add(lecture.end);
            }
        }

        System.out.println(count);
    }

    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture lecture) {
            if (this.start == lecture.start) {
                return this.end - lecture.end;
            }
            return this.start - lecture.start;
        }
    }
}