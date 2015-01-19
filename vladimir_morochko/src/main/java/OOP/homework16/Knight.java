package OOP.homework16;

public class Knight {
	private int[][] board;
	private int maxHor;
	private int maxVert;

	public Knight() {
		maxVert = 8;
		maxHor = 8;
		board = new int[maxVert][maxHor];
	}

	public Knight(int rightBorder, int downBorder) {
		this();
		maxVert = downBorder;
		maxHor = rightBorder;
		board = new int[maxVert][maxHor];
	}

	public boolean findPath(int moveNumber, int hor, int vert) {
		board[vert][hor] = moveNumber;
		if (moveNumber == maxHor * maxVert) {
			return true;
		}
		moveNumber++;

		int moveHor = hor - 1;
		int moveVert = vert - 2;
		if (moveHor >= 0 && moveHor < maxHor && moveVert >= 0
				&& moveVert < maxVert) {
			if (board[moveVert][moveHor] == 0
					&& findPath(moveNumber, moveHor, moveVert)) {
				return true;
			}
		}

		moveHor = hor + 1;
		moveVert = vert - 2;
		if (moveHor >= 0 && moveHor < maxHor && moveVert >= 0
				&& moveVert < maxVert) {
			if (board[moveVert][moveHor] == 0
					&& findPath(moveNumber, moveHor, moveVert)) {
				return true;
			}
		}

		moveHor = hor + 2;
		moveVert = vert - 1;
		if (moveHor >= 0 && moveHor < maxHor && moveVert >= 0
				&& moveVert < maxVert) {
			if (board[moveVert][moveHor] == 0
					&& findPath(moveNumber, moveHor, moveVert)) {
				return true;
			}
		}

		moveHor = hor + 2;
		moveVert = vert + 1;
		if (moveHor >= 0 && moveHor < maxHor && moveVert >= 0
				&& moveVert < maxVert) {
			if (board[moveVert][moveHor] == 0
					&& findPath(moveNumber, moveHor, moveVert)) {
				return true;
			}
		}

		moveHor = hor + 1;
		moveVert = vert + 2;
		if (moveHor >= 0 && moveHor < maxHor && moveVert >= 0
				&& moveVert < maxVert) {
			if (board[moveVert][moveHor] == 0
					&& findPath(moveNumber, moveHor, moveVert)) {
				return true;
			}
		}

		moveHor = hor - 1;
		moveVert = vert + 2;
		if (moveHor >= 0 && moveHor < maxHor && moveVert >= 0
				&& moveVert < maxVert) {
			if (board[moveVert][moveHor] == 0
					&& findPath(moveNumber, moveHor, moveVert)) {
				return true;
			}
		}

		moveHor = hor - 2;
		moveVert = vert + 1;
		if (moveHor >= 0 && moveHor < maxHor && moveVert >= 0
				&& moveVert < maxVert) {
			if (board[moveVert][moveHor] == 0
					&& findPath(moveNumber, moveHor, moveVert)) {
				return true;
			}
		}

		moveHor = hor - 2;
		moveVert = vert - 1;
		if (moveHor >= 0 && moveHor < maxHor && moveVert >= 0
				&& moveVert < maxVert) {
			if (board[moveVert][moveHor] == 0
					&& findPath(moveNumber, moveHor, moveVert)) {
				return true;
			}
		}
		
		board[vert][hor] = 0;
		return false;
	}

	@Override
	public String toString() {
		String outString = " ";
		for (int hor = 0; hor < maxHor; hor++) {
			outString += ("  " + hor);
		}
		outString += "\n";

		for (int vert = 0; vert < maxVert; vert++) {
			outString += vert;
			for (int hor = 0; hor < maxHor; hor++) {
				outString += ((board[vert][hor] > 9 ? " " : "  ") + board[vert][hor]);
			}
			outString += "\n";
		}
		return outString;
	}

	public static void main(String[] args) {
		Knight myKnight = new Knight();
		System.out.println(myKnight);

		long t1, t2;
		t1 = System.nanoTime() / 1000;
		myKnight.findPath(1, 0, 6);
		t2 = System.nanoTime() / 1000;
		System.out.println(myKnight);
		System.out.println((t2 - t1) + " millis\n");

	}

}
