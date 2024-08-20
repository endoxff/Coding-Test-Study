import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
	
	static int N, K, L, direction;
	static ArrayList<Point> snake = new ArrayList<>();
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};	// 상 우 하 좌
	static ArrayList<Point> apple = new ArrayList<>();
	static Map<Integer, Character> command = new LinkedHashMap<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());	// 보드의 크기
		K = Integer.parseInt(br.readLine());	// 사과의 개수
		
		// apple는 사과의 위치
		for(int i=0; i<K; i++) {
			String[] str = br.readLine().split(" ");
			apple.add(new Point(Integer.parseInt(str[0])-1, Integer.parseInt(str[1])-1));
		}
		
		L = Integer.parseInt(br.readLine());	// 뱀의 방향 변환 횟수
		
		for(int i=0; i<L; i++) {
			String[] str = br.readLine().split(" ");
			// x초가 끝난 뒤에 왼쪽 ('L') 또는 오른쪽 ('D')로 90도 회전
			command.put(Integer.parseInt(str[0]), str[1].charAt(0));	 
		}
		
		int time = 0;
		direction = 1;
		snake.add(new Point(0, 0));
		
		while(true) {
			time++;

			int x = snake.get(0).x + dir[direction][0];
			int y = snake.get(0).y + dir[direction][1];
			
			if (x < 0 || y < 0 || x >= N || y >= N || snake.contains(new Point(x, y)) )
				break;

			snake.add(0, new Point(x, y));
			
			if (apple.contains(new Point(x, y)))
				apple.remove(new Point(x, y));
			else
				snake.remove(snake.size()-1);
			
			if (command.get(time) != null) {
				if (command.get(time).equals('D')) 
					direction = (direction + 1 > 3) ? 0: direction + 1;
				else 
					direction = (direction == 0) ? 3: direction - 1;
			}
		}
		System.out.println(time);
	}
}
