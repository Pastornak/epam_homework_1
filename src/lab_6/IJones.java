package lab_6;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.log4j.Logger;

public class IJones {
	
	private static final Logger LOG = Logger.getLogger(IJones.class);

	private int width = 0;
	private int height = 0;
	private int ways = 0;

	public static IJones INSTANCE = null;

	private IJones() {
	}

	public static IJones getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new IJones();
		}
		return INSTANCE;
	}

	public int ijones(String filename) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String[] numInfo = br.readLine().split(" ");
		width = Integer.parseInt(numInfo[0]);
		height = Integer.parseInt(numInfo[1]);
		System.out.println(width + " " + height);
		char[][] data = new char[width][height];
		for (int i = 0; i < height; i++) {
			data[i] = br.readLine().toCharArray();
		}
		br.close();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(data[i][j]);
			}
			System.out.println();
		}
		search(data);
		int result = ways;
		resetParams();
		return result;
	}
	
	private void resetParams(){
		width = 0;
		height = 0;
		ways = 0;
	}

	private void search(char[][] data) {
		LOG.info("Search method");
		for (int row = 0; row < height; row++) {
			searchInRow(data, row, 0);
		}
	}

	private void searchInRow(char[][] data, int row, int col) {
		//LOG.info("SearchInRow method with input: row " + row + ", col " + col);
		for (int iterCol = col; iterCol < width; iterCol++) {
			searchRelated(data, row, iterCol);
		}
	}

	private void searchRelated(char[][] data, int row, int col) {
		//LOG.info("SearchRelated method with input: row " + row + ", col " + col);
		char inputChar = data[row][col];
		if (col + 1 == width && (row == 0 || row == height - 1)) {
			ways++;
			return;
		}
		for (int rows = 0; rows < height; rows++) {
			for (int cols = col + 1; cols < width; cols++) {
				char symbol = data[rows][cols];
				if (symbol == inputChar && !isNext(row, col, rows, cols)) {
					searchInRow(data, rows, cols);
				}
			}
		}
	}

	private boolean isNext(int firstRow, int firstCol, int secondRow, int secondCol) {
		//LOG.info("isNext method with input: firstRow " + firstRow + ", firstCol " 
		//		+ firstCol + ", secondRow " + secondRow + ", secondCol " + secondCol);
		return firstRow == secondRow && firstCol + 1 == secondCol;
	}
}
