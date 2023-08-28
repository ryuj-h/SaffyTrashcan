import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;


class Vec2{
	public int x,y;
	public boolean isAlive = true;

	public Vec2(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public int GetDistTo(Vec2 other) {
		return Math.abs(this.x - other.x) + Math.abs( this.y - other.y);
	}
}


public class BOJ17135castle {
	static int N ,M, D,Map[][];
	static boolean Seleted[];
	static ArrayList<Vec2> Enemys;
	static ArrayList<Vec2> saveEnemys;
	static int Solution = 0;
	static int MaxSolution = Integer.MIN_VALUE;
	
	public static void ourturn() {
		ArrayList<Vec2> Teams = new ArrayList<>();
		for(int i =0; i < M; i++) {
			if (Seleted[i])
				Teams.add(new Vec2(i,N));
		}
		
		for(Vec2 team : Teams) {
			Vec2 SelectedTarget = null;
			
			for(Vec2 enemy : Enemys) {
				int DistToEnemy = team.GetDistTo(enemy);
				if (DistToEnemy > D)
					continue;
				
				if (SelectedTarget == null) {
					SelectedTarget = enemy;
					continue;
				}
				if (team.GetDistTo(enemy) < team.GetDistTo(SelectedTarget)) {
					SelectedTarget = enemy;
				}
				else if (team.GetDistTo(enemy) == team.GetDistTo(SelectedTarget)) {
					if (enemy.x < SelectedTarget.x)
						SelectedTarget = enemy;
				}
			}
			
			if (SelectedTarget != null) {
				SelectedTarget.isAlive = false;
			}
		}
		
		// 죽은 친구들 Enemys에서 제거...
        Iterator it = Enemys.iterator();
        while (it.hasNext()) {
            Vec2 n = (Vec2) it.next();
            if (!n.isAlive) {
                it.remove();
                Solution++;
            }
        }
	}
	
	public static void enemyturn() {
		for(Vec2 enemy : Enemys) {
			enemy.y = enemy.y + 1;
		}
		
		Iterator it = Enemys.iterator();
        while (it.hasNext()) {
            Vec2 n = (Vec2) it.next();
            if (n.y >= N) {
                it.remove();
            }
        }
		
	}
	public static boolean isGameOver() {
		if (Enemys.isEmpty())
			return true;
		return false;
	}
	
	public static void dfs(int depth, int curr) {
		if(depth == 3) {
			
			
			Enemys = new ArrayList<>();
			for (int y = 0; y < N;y++) {
				for (int x = 0; x < M; x++) {
					if (Map[y][x] == 1)
						Enemys.add(new Vec2(x,y));
				}
			}
			
			Solution = 0;
			for(;;) {
				ourturn();
				enemyturn();
				if (isGameOver()) {
					break;
				}
			}
			
			MaxSolution = Math.max(MaxSolution, Solution);
			
			return;
		}
		
		for(int i =curr+1; i < M;i++) {
			Seleted[i] = true;
			dfs(depth+1,i);
			Seleted[i] = false;
		}
	}
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		Map = new int [N][M];
		Seleted = new boolean [M];
		Enemys = new ArrayList<>();
		saveEnemys = new ArrayList<>();
		
		for (int y = 0; y < N;y++) {
			st = new StringTokenizer (br.readLine());
			for (int x = 0; x < M; x++) {
				Map[y][x] = Integer.parseInt(st.nextToken());
				if (Map[y][x] == 1)
					Enemys.add(new Vec2(x,y));
			}
		}
		dfs(0,0);
		
		System.out.println(MaxSolution);
	}
}
