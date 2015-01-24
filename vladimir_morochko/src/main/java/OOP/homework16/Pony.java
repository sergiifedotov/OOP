package OOP.homework16;

public class Pony {
	private int[][] board;
	private int[][] scoreBoard;
	private int rightBorder;
	private int downBorder;
	private Path ponyPath;

	public Pony() {
		downBorder = 8;
		rightBorder = 8;
		board = new int[downBorder][rightBorder];
		scoreBoard = new int[downBorder][rightBorder];
		ponyPath = new Path();
	}

	public Pony(int rightBorder, int downBorder) {
		this();
		this.downBorder = downBorder;
		this.rightBorder = rightBorder;
		board = new int[downBorder][rightBorder];
		scoreBoard = new int[downBorder][rightBorder];
	}

	public void fillBoard(int number, int maxValue) {
		for (int i = 0; i < number; i++) {
			int vert = (int) (Math.random() * downBorder);
			int hor = (int) (Math.random() * rightBorder);
			board[vert][hor] = (int) (1 + Math.random() * maxValue);
		}
		// for (int vert = 0; vert < downBorder; vert++) {
		// for (int hor = 0; hor < rightBorder; hor++) {
		// board[vert][hor] = 1;
		// }
		// }

	}

	public void fillScoreBoard() {
		int right = 0;
		int down = 0;
		for (int vert = downBorder - 1; vert >= 0; vert--) {
			for (int hor = rightBorder - 1; hor >= 0; hor--) {
				if (hor < rightBorder - 1) {
					right = scoreBoard[vert][hor + 1];
				} else {
					right = 0;
				}

				if (vert < downBorder - 1) {
					down = scoreBoard[vert + 1][hor];
				} else {
					down = 0;
				}

				scoreBoard[vert][hor] = board[vert][hor]
						+ (right > down ? right : down);
			}
		}

	}

	public String scoreBoardPath() {
		String outString = "";
		int hor = 0;
		int vert = 0;
		int right = 0;
		int down = 0;

		while (hor < rightBorder && vert < downBorder) {
			outString += "[" + hor + ", " + vert + "], ";
			
			if (hor < rightBorder - 1) {
				right = scoreBoard[vert][hor + 1];
			} else {
				right = 0;
			}

			if (vert < downBorder - 1) {
				down = scoreBoard[vert + 1][hor];
			} else {
				down = 0;
			}

			if (right >= down) {
				hor++;
			} else {
				vert++;
			}
		}
		return outString;
	}

	public int go(int right, int down) {
		int myScore = board[down][right];

		int rightScore = 0;
		if (right < rightBorder - 1) {
			rightScore = go(right + 1, down);
		}

		int downScore = 0;
		if (down < downBorder - 1) {
			downScore = go(right, down + 1);
		}

		if (rightScore > downScore) {
			myScore += rightScore;
		} else if (rightScore < downScore) {
			myScore += downScore;
		} else if (right == rightBorder - 1 && down == downBorder - 1) {
		} else {
			myScore += rightScore;
		}
		return myScore;
	}

	public String boardToString() {
		String outString = " ";
		for (int hor = 0; hor < rightBorder; hor++) {
			outString += ("  " + hor);
		}
		outString += "\n";

		for (int vert = 0; vert < downBorder; vert++) {
			outString += vert;
			for (int hor = 0; hor < rightBorder; hor++) {
				outString += ((board[vert][hor] > 9 ? " " : "  ") 
						+ board[vert][hor]);
			}
			outString += "\n";
		}
		return outString;
	}

	public String scoreBoardToString() {
		String outString = " ";
		for (int hor = 0; hor < rightBorder; hor++) {
			outString += ("  " + hor);
		}
		outString += "\n";

		for (int vert = 0; vert < downBorder; vert++) {
			outString += vert;
			for (int hor = 0; hor < rightBorder; hor++) {
				outString += ((scoreBoard[vert][hor] > 9 ? " " : "  ") 
						+ scoreBoard[vert][hor]);
			}
			outString += "\n";
		}
		return outString;
	}

	private class Path {
		private int score;
		private Move move;

		public Path() {
			move = new Move(0, 0);
		}

		@SuppressWarnings("unused")
		public Path(int right, int down) {
			this();
			this.move.down = down;
			this.move.right = right;
		}

		public void create() {
			score = move.buildPath();
		}

		@Override
		public String toString() {
			return "" + move;
		}

	}

	private class Move {
		private int right;
		private int down;
		private Move next;

		public Move() {
			this.right = 0;
			this.down = 0;
		}

		public Move(int right, int down) {
			this();
			this.right = right;
			this.down = down;
		}

		@Override
		public String toString() {
			return "[" + right + ", " + down + "], " + next;
		}

		public int buildPath() {
			int myScore = board[down][right];

			if (right == rightBorder - 1 && down == downBorder - 1) {
				next = null;
				return myScore;
			}

			int rightScore = 0;
			Move rightMove = new Move(right + 1, down);
			if (right < rightBorder - 1) {
				rightScore = rightMove.buildPath();
			}

			int downScore = 0;
			Move downMove = new Move(right, down + 1);
			if (down < downBorder - 1) {
				downScore = downMove.buildPath();
			}

			if (rightScore > downScore || down == downBorder - 1) {
				myScore += rightScore;
				next = rightMove;
			} else if (rightScore < downScore || right == rightBorder - 1) {
				myScore += downScore;
				next = downMove;
			} else {
				myScore += rightScore;
				next = rightMove;
			}
			return myScore;
		}

	}

	public static void main(String[] args) {
		Pony myLittlePony = new Pony(8, 8);
		// System.out.println(myLittlePony.boardToString());
		myLittlePony.fillBoard(70, 9);
		System.out.println(myLittlePony.boardToString());

		long t1, t2;
		t1 = System.nanoTime() / 1000;
		int result = myLittlePony.go(0, 0);
		t2 = System.nanoTime() / 1000;
		System.out.println(result);
		System.out.println((t2 - t1) + " millis\n");

		t1 = System.nanoTime() / 1000;
		myLittlePony.ponyPath.create();
		System.out.println(myLittlePony.ponyPath);
		System.out.println(myLittlePony.ponyPath.score);
		t2 = System.nanoTime() / 1000;
		System.out.println((t2 - t1) + " millis\n");

		t1 = System.nanoTime() / 1000;
		myLittlePony.fillScoreBoard();
		System.out.println(myLittlePony.scoreBoardToString());
		System.out.println(myLittlePony.scoreBoardPath());
		t2 = System.nanoTime() / 1000;
		System.out.println((t2 - t1) + " millis");
	}

}
