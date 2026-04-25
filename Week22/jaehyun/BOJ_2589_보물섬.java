import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, max;
	static char[][] graph;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		graph = new char[N][M];
		
		for(int r = 0; r < N; r++) {
			String S = sc.next();
			for(int c = 0; c < M; c++) {
				graph[r][c] = S.charAt(c);
			}
		}
		
		max = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(graph[r][c] == 'L') {
					bfs(r, c);
				}
			}
		}
		
		System.out.println(max);
	}
	
	static void bfs(int startY, int startX) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		visited[startY][startX] = true;
		queue.offer(new int[] {startY, startX, 0});
		int count = 0;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			count = now[2];
			for(int i = 0; i < 4; i++) {
				int moveY = now[0] + dr[i]; 
				int moveX = now[1] + dc[i];
				if(0 <= moveY && moveY < N && 0 <= moveX && moveX < M) {
					if(!visited[moveY][moveX] && graph[moveY][moveX] == 'L') {
						visited[moveY][moveX] = true;
						queue.offer(new int[] {moveY, moveX, now[2] + 1});
					}
				}
			}
		}
		if(max < count) max = count; 
	}

}
