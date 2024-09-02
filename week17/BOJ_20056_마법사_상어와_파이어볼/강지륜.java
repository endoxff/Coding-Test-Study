import java.util.*;
import java.io.*;
import java.awt.*;

class FireBall {
	
	Point point;	// 파이어볼 위치
	int m;			// 질량
	int d; 			// 방향
	int s;			// 속력
	
	FireBall(String x, String y, String m, String s, String d) {
		this.point = new Point(Integer.parseInt(x)-1, Integer.parseInt(y)-1);
		this.m = Integer.parseInt(m);
		this.d = Integer.parseInt(d);
		this.s = Integer.parseInt(s);
	}
	
	FireBall(int x, int y, int m, int d, int s) {
		this.point = new Point(x, y);
		this.m = m;
		this.d = d;
		this.s = s;
	}
	
	void updatePoint(Point point) {
		this.point = point;
	}
	
}

class SameFireBall {
	
	int cnt;
	ArrayList<Integer> idxs = new ArrayList<>();
	
	SameFireBall(int idx) {
		cnt = 1;
		idxs.add(idx);
	}
	
	void update(int idx) {
		cnt++;
		idxs.add(idx);
	}
	
}

public class Main {
	
	static int N, M, K;		// 순서대로 격자의 크기, 파이어볼 수, 명령의 수
	static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1,  -1}};
	static Map<Integer, FireBall> map = new LinkedHashMap<>();
	static Map<Point, SameFireBall> same = new LinkedHashMap<>();
	static int result = 0;
	static int maxIdx = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		K = Integer.parseInt(str[2]);
		
		for(int i=0; i<M; i++) {
			str = br.readLine().split(" ");	
			map.put(i, new FireBall(str[0], str[1], str[2], str[3], str[4]));
		}
		
		maxIdx = M-1;
		for(int i=0; i<K; i++) {
		
			map.forEach((idx, fb) -> {
				
				int x = fb.point.x + dir[fb.d][0] * (fb.s % N);
				int y = fb.point.y + dir[fb.d][1] * (fb.s % N);

				x = (x < 0) ? x + N : x;
				x = (x > N-1) ? x - N : x;
				y = (y < 0) ? y + N : y;
				y = (y > N-1) ? y - N : y;
				
				fb.updatePoint(new Point(x, y));
			});
			
			map.forEach((idx, fb) -> {
				if (same.get(new Point(fb.point.x, fb.point.y)) == null) 
					same.put(new Point(fb.point.x, fb.point.y), new SameFireBall(idx));
				else 
					same.get(new Point(fb.point.x, fb.point.y)).update(idx);
			});
			
			same.forEach((point, fb) -> {
				
				if (fb.idxs.size() < 2)
					return;
					
				int totalM = 0;
				int totalS = 0;
				boolean even = false;
				boolean odd = false;
				
				for(int k=0; k<fb.idxs.size(); k++) {
					totalM += map.get(fb.idxs.get(k)).m;
					totalS += map.get(fb.idxs.get(k)).s;
					
					if (map.get(fb.idxs.get(k)).d % 2 == 0)
						even = true;
					else
						odd = true;
				}
				
				totalM /= 5;
				totalS /= fb.idxs.size();

				if (totalM != 0) {
					int add = 0;
					
					if (even && odd)
						add = 1;
					
					for(int k=0; k<4; k++) {
						map.put(maxIdx + 1, new FireBall(point.x, point.y, totalM, add, totalS));
						add += 2;
						maxIdx ++;
					}
				}
				
				for(int k=0; k<fb.idxs.size(); k++) 
					map.remove(fb.idxs.get(k));
			});
			
			same.clear();
		}
		
		map.forEach((idx, fb) -> {
			result += fb.m;
		});
		
		System.out.println(result);
	}
}
