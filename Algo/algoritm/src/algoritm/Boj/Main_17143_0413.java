package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17143_0413 {
	static int R, C, M;

	static class Node {
		int speed;
		int size;
		int d;

		Node(int speed, int d, int size) {
			this.speed = speed;
			this.size = size;
			this.d = d;
		}
	}

	static Node a[][], b[][];
	static int delta[][] = { {}, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		a = new Node[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			a[r][c] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		int sum = 0;
		for (int man = 1; man <= C; man++) {
			for (int fish = 1; fish <= R; fish++) { // 현재 위치열에서 물고기 잡기
				if (a[fish][man] != null) {
					sum += a[fish][man].size;
					a[fish][man] = null;
					break;
				}
			}

			////////////////////////////////////////////
			b = new Node[R + 1][C + 1];

			for (int i = 1; i <= R; i++) { // 상어 이동
				for (int j = 1; j <= C; j++) {
					if (a[i][j] != null) {
						move(i, j);
					}

				}
			}
			
			copy();

		}
		System.out.println(sum);
	}

	static public void copy() {
		for (int i = 1; i <= R; i++) { 
			for (int j = 1; j <= C; j++) {
				if (b[i][j] != null) {
					a[i][j] = new Node(b[i][j].speed , b[i][j].d , b[i][j].size);
				}
			}
		}

	}

	static public void move(int r, int c) {
		int d = a[r][c].d;
		int speed = a[r][c].speed;
		int size = a[r][c].size;

		int nextX = r;
		int nextY = c;

		for (int i = 0; i < speed; i++) {
			nextX += delta[d][0] ; // 다음 좌표
			nextY += delta[d][1] ;

			if (nextX < 1 || nextX > R || nextY < 1 || nextY > C) {
				nextX -= delta[d][0] ; // 범위 밖을 나가면 원래 좌표로 변경
				nextY -= delta[d][1] ;

				 // 방향을 반대로 바꿔줌
				if(d == 1) d = 2;
				else if(d == 2) d= 1;
				else if(d == 3) d= 4;
				else if(d == 4) d= 3;
				
				nextX += delta[d][0] ; // 방향이 바뀌고 다음 좌표
				nextY += delta[d][1] ;

			}

		}

		if (b[nextX][nextY] == null) { // 이동한 위치에 아무것도 없을 때
			b[nextX][nextY] = new Node(speed, d, size);

		} else { // 이동한 위치에 이미 상어가 있을때
			if (b[nextX][nextY].size < size) { // 지금 상어가 크기 가 더 큰경우 변경해준다
				b[nextX][nextY] = new Node(speed, d, size);
			}
		}

		a[r][c] = null;

	}

}
