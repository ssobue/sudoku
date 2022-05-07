package dev.sobue.sudoku;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Box {

  private final Cell[][] cells;

  Box() {
    this(new int[][]{
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    });
  }

  Box(int[][] cells) {
    // check size
    var xMax = cells.length;
    var yMax = cells[0].length;

    if (!(xMax == 3 && yMax == 3)) {
      throw new IllegalArgumentException("input array is not valid");
    }

    this.cells = new Cell[xMax][yMax];

    for (var x = 0; x < xMax; x++) {
      for (var y = 0; y < yMax; y++) {
        this.cells[x][y] = new Cell(cells[x][y]);
      }
    }
  }
}
