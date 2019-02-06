import java.util.ArrayList;
import java.util.Arrays;

public class altTest {
	public static int[] roverPos(int[][] grid) {
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				System.out.print(grid[row][column]+",");
			}
			System.out.println();
		}
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				if ((grid[row][column]) == 1) {
					int[] pos = new int[2];
					pos[0] = column;
					pos[1] = row;
					System.out.println();
					return pos;
				}
			}
		}
		
		int[] pos = new int[2];
		Arrays.fill(pos, 0);
		return pos;
	}

	public static void canMakeMove(int[][] grid, String move) {
		int[] rovPos = roverPos(grid);
		int ypos = rovPos[0];
		int xpos = rovPos[1];
		if (move.equals("RIGHT")) {
			if (ypos + 1 < grid[0].length) {
				grid[xpos][ypos] = 0;
				grid[xpos][ypos+1] = 1;
			}
		} else if (move.equals("LEFT")) {
			if (ypos - 1 >= 0) {
				grid[xpos][ypos] = 0;
				grid[xpos][ypos -1] = 1;
			}
		} else if (move.equals("DOWN")) {
			if (xpos + 1 < grid.length) {
				grid[xpos][ypos] = 0;
				grid[xpos + 1][ypos] = 1;
			}
		} else if (move.equals("UP")) {
			if (xpos - 1 >= 0) {
				grid[xpos][ypos] = 0;
				grid[xpos -1][ypos] = 1;
			}
		}
	}

	public static int roverMove(int size, ArrayList<String> commands) {
		int[][] grid = new int[size][size];
		grid[0][0] = 1;
		int noOfCommands = commands.size();
		int[] moves = new int[noOfCommands];
		for (int count = 0; count < noOfCommands; count++) {
			String move = commands.get(count);
			canMakeMove(grid, move);
		}
		int[] endPos = roverPos(grid);
		return ((endPos[1] * size) + endPos[0]);
	}

	public static void main(String args[]) {
		ArrayList<String> roverList = new ArrayList<String>();
		String[] directions = { "RIGHT", "DOWN", "LEFT", "LEFT", "DOWN" };
		roverList.addAll(Arrays.asList(directions));
		System.out.println(roverMove(4, roverList));
	}
}
