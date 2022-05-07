package dev.sobue.sudoku;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Cell {

  private int num = 0;

  Cell(int num) {
    this.num = num;
  }
}
