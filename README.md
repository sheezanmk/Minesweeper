A simple version of the classic Minesweeper game built using Java, playable in the console.
It involves core game logic such as grid handling, mine placement, user input, and win/loss conditions.

Features:

10 × 10 grid

10 mines placed randomly on the board

User reveals cells by entering grid coordinates

Each revealed cell shows a number from 0–8 indicating how many mines surround it

If a mine is revealed → BOOM! Game over

If all safe cells are revealed → You win

Grid is re-rendered after every user command

Mines are revealed only when the game ends

How to Play :

Run the program.

You will see a 10×10 grid with row and column indices (0–9).

Enter a row and column to reveal a cell.

Game Rules:

Revealing a mine ends the game immediately.

Revealing a safe cell shows how many mines surround it.

The game is won when all non-mine cells are revealed.

How to Run :
Compile all java files:
`javac *.java
`

Run the game :
`java App`
