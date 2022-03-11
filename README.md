

https://user-images.githubusercontent.com/90436611/157783963-e26c71f5-dd09-45f9-a358-1113ffcf73df.mp4

INTRODUCTION:
This is my first project in Java.
My program is an offset of the Snake Xenzia Rewind 97 Retro game.

HOW THE GAME WORKS:
At the start menu, the player chooses a food type by clicking on the corresponding box.
The aim is to "eat" the food. The player can move the snake around using the corresponding arrow keys or W-Up, S-Down, A-Left, D-right.
The game ends when the snake "bites" itself.

WITHIN THE CODE:
CLASSES: CELL-implemented in main to create a grid of cells.
         SNAKE-implemented in main to store the coordinates of the snake in an array and modify its length.
         SCORE-implemented in the bottom menu of the game. Used to keep track of the score i.e increases by 1 each eat.

METHODS: backgroundmenu-sets the background graphics.
         startmenu-menu where the player chooses a food type.
         startgame-initializes the snake and food.
         spawnfood-spawns the food at random.
         updatebottommenu-updates the score at the bottom menu of the game.
         movesnake-moves the snake.
         checkcollision-checks collision of the snake cells.
         gameover-sets the game over screen.
         draw-draws the current grid
         
GAME AUDIO(background music)-Unpack in gameaudio.rar . Used with the StdAudio library
