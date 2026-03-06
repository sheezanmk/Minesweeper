## Minesweeper

A simple version of the classic Minesweeper game built using Java, playable in the console. It involves core game logic such as grid handling, mine placement, user input, and win/loss conditions. It is built as a learning exercise to practice Object-oriented design, 2D grid algorithms, Game logic implementation.

## Snippet

- Example gameplay:

=== Minesweeper (Console) ===
Enter your move as: row column (both 0-9)

0 1 2 3 4 5 6 7 8 9
0 . . . . . . . . . .
1 . . . . . . . . . .
2 . . . . . . . . . .
3 . . . 0 . . . . . .
4 . . . . . . . . . .
5 . . . . . . . . . .
6 . . . . . . . . . .
7 . . . . . . . . . .
8 . . . . . . . . . .
9 . . . . . . . . . .

- Symbols used:

| Symbol | Meaning                     |
| ------ | --------------------------- |
| `.`    | Hidden cell                 |
| `0–8`  | Number of surrounding mines |
| `*`    | Mine (shown when game ends) |

## Requirements

The goal of this project was to recreate a simplified Minesweeper game playable in the Java console.

The project focuses on implementing core programming concepts such as:

- Object Oriented Programming

- 2D arrays

- Game state management

- User input handling

- Randomized mine placement

- Console rendering

Players reveal cells by entering coordinates. The game continues until a mine is hit or all safe cells are revealed.

## Stack Used

# Java

- Standard Java Libraries

- Scanner for user input

- Math.random() for mine placement

Java was chosen because the project focuses on object-oriented design and algorithmic thinking rather than UI development.

## Build Steps

- Compile the project
- javac \*.java

- Run the program
  - java Main

- Example input
  - Row (0-9): 3
  - Col (0-9): 7

## Design Goals

The main design goal was to build a clear separation of responsibilities between classes.

The project follows a simple object-oriented structure:

- Cell → represents a single square on the board
- Board → contains the game logic and grid
- Game → manages user interaction and rendering
- Main → entry point for the program

Separating responsibilities helps make the project easier to maintain and extend.

- For example:
  - The Cell class stores only the data related to a single square.

  - The Board class handles all grid operations and game rules.

  - The Game class manages input, rendering, and game flow.

  - This approach keeps each class focused on a single responsibility.

## Features

- 10 × 10 Minesweeper grid

- Random placement of 10 mines

- Safe cell counting for surrounding mines (0–8)

- User input via row and column coordinates

- Grid rendering after every move

- Mine detection and game over logic

- Win detection when all safe cells are revealed

- Console-based interface

## Known Issues

- Cells displaying 0 do not cascade to reveal neighboring safe cells (full Minesweeper behaviour).

- Input requires row and column separately instead of a single command (row col).

These limitations were acceptable for the MVP scope.

## Future Goals

If more time were available, the following features would be added:

- Cascade reveal for 0 cells

- Single command input (row col)

- Mine flagging feature

- Improved console visuals (borders and colours)

- Configurable board size and mine count
