package dev.sobue.sudoku;

import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;

@Getter
@ToString
public class Sudoku {

  public static Sudoku build(int[][] input) {
    // check size
    var xMax = input.length;
    var yMax = input[0].length;

    if (!(xMax == 9 && yMax == 9)) {
      throw new IllegalArgumentException("input array is not valid");
    }

    Box[][] init = new Box[3][3];

    for (int x = 0, i = 0; x < xMax; x += 3, i++) {
      for (int y = 0, j = 0; y < yMax; y += 3, j++) {
        init[i][j] =
            new Box(
                new int[][]{
                    {input[x][y], input[x][y + 1], input[x][y + 2]},
                    {input[x + 1][y], input[x + 1][y + 1], input[x + 1][y + 2]},
                    {input[x + 2][y], input[x + 2][y + 1], input[x + 2][y + 2]},
                }
            );
      }
    }

    return new Sudoku(init);
  }

  private final Box[][] boxes;

  private Sudoku(Box[][] init) {
    this.boxes = init;
  }

  public void solve() {
    throw new UnsupportedOperationException("no implementation to solve");
  }

  public void printBoxes() {
    System.out.println(ReflectionToStringBuilder.toString(boxes, MULTI_LINE_STYLE));
  }
}
