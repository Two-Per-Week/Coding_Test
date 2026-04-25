import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R, C, targetY, targetX, count;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] graph;
	static int[][] visited;
	static Queue<int[]> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		graph = new char[R][C];
		Queue<int[]> tempQueue = new LinkedList<>();
		queue = new LinkedList<>();
		visited = new int[R][C];
		
		// 고슴도치 1, 물 2
		// y좌표, x좌표, 뭔지, 포지션
		for(int r = 0; r < R; r++) {
			String S = sc.next();
			for(int c = 0; c < C; c++) {
				graph[r][c] = S.charAt(c);
				if(graph[r][c] == 'S') {
					queue.add(new int[] {r, c, 1, 0});
					visited[r][c] = 1;
				}
				else if(graph[r][c] == '*') {
					tempQueue.add(new int[] {r, c, 2});
					visited[r][c] = 2;
				}
			}
		}
		
		while (!tempQueue.isEmpty()) queue.add(tempQueue.poll());
		
		count = -1;
		bfs();
		
		if(count == -1) System.out.println("KAKTUS");
		else System.out.println(count);

	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];
			int what = now[2];
			
			if(what == 1 && visited[r][c] != 1) continue;
			
			for(int i = 0; i < 4; i++) {
				int moveY = r + dr[i];
				int moveX = c + dc[i];
				
				if(0 <= moveY && moveY < R && 0 <= moveX && moveX < C && graph[moveY][moveX] != 'X') {
					if(what == 1) {
						if(graph[moveY][moveX] == 'D') {
							count = now[3]+1;
							return;
						}
						else if(visited[moveY][moveX] == 0) {
							queue.add(new int[] {moveY, moveX, what, now[3] + 1});
						}
					} else {
						if(graph[moveY][moveX] != 'D' && (visited[moveY][moveX] == 0 || visited[moveY][moveX] == 1)) {
							queue.add(new int[] {moveY, moveX, what});
						}
					}
					visited[moveY][moveX] = what;
				}
			}
			
		}
	}

}
