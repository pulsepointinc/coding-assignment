You're given the task of writing a simple console version of a drawing program.
In a nutshell, the program should work as follows:

1. Create a new canvas
2. Start drawing on the canvas by issuing various commands
3. Quit


| Command 	     | 	Description                                                                                                                                                              |
|---------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| C w h         | Should create a new canvas of width w and height h.                                                                                                                       |
| L x1 y1 x2 y2 | Should create a new line from (x1,y1) to (x2,y2). Lines will be drawn using the 'x' character.                                                                            |
| R x1 y1 x2 y2 | Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character. |
| B x y c       | Should fill the entire area connected to (x,y) with "colour" c. The behaviour of this is the same as that of the "bucket fill" tool in paint programs.                    |
| Q             | Should quit the program.                                                                                                                                                  |

### Sample I/O

Below is a sample run of the program. User input is prefixed with "Input command:"

```
Input command: c 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------

Input command: l 0 2 19 2 
----------------------
|                    |
|                    |
|xxxxxxxxxxxxxxxxxxxx|
|                    |
----------------------

Input command: b 0 0 a
----------------------
|aaaaaaaaaaaaaaaaaaaa|
|aaaaaaaaaaaaaaaaaaaa|
|xxxxxxxxxxxxxxxxxxxx|
|                    |
----------------------

Input command: q
```
