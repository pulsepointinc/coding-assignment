Please see bellow a wrong program output 
```
Input command: c 20 20
CommandNewCanvas ✓
----------------------
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
----------------------


Input command: l 0 0 19 19
CommandLine ✓
----------------------
|x                   |
| x                  |
|  x                 |
|   x                |
|    x               |
|     x              |
|      x             |
|       x            |
|        x           |
|         x          |
|          x         |
|           x        |
|            x       |
|             x      |
|              x     |
|               x    |
|                x   |
|                 x  |
|                  x |
|                   x|
----------------------


Input command: l 10 10 20 10
[WARN] CommandLine was partially applied (there were some invisible pixels)
----------------------
|x                   |
| x                  |
|  x                 |
|   x                |
|    x               |
|     x              |
|      x             |
|       x            |
|        x           |
|         x          |
|          xxxxxxxxxx|
|           x        |
|            x       |
|             x      |
|              x     |
|               x    |
|                x   |
|                 x  |
|                  x |
|                   x|
----------------------


Input command: b 10 0
Verify your input! Error message: Arguments for CommandBucketFill should have 4 coordinates which represent as 4 integer values

Input command: b 10 0  /
Verify your input! Error message: Colour should be represent as single character

Input command: b 18 15 -
CommandBucketFill ✓
----------------------
|x                   |
| x                  |
|  x                 |
|   x                |
|    x               |
|     x              |
|      x             |
|       x            |
|        x           |
|         x          |
|          xxxxxxxxxx|
|           x--------|
|            x-------|
|             x------|
|              x-----|
|               x----|
|                x---|
|                 x--|
|                  x-|
|                   x|
----------------------


Input command: r 10 10 20 20
[WARN] CommandRectangle was partially applied (there were some invisible pixels)
----------------------
|x                   |
| x                  |
|  x                 |
|   x                |
|    x               |
|     x              |
|      x             |
|       x            |
|        x           |
|         x          |
|          xxxxxxxxxx|
|           x--------|
|            x-------|
|             x------|
|              x-----|
|               x----|
|                x---|
|                 x--|
|                  x-|
|                   x|
----------------------


Input command: l 10 10 0 20
[WARN] CommandLine was partially applied (there were some invisible pixels)
----------------------
|x                   |
| x                  |
|  x                 |
|   x                |
|    x               |
|     x              |
|      x             |
|       x            |
|        x           |
|         x          |
|          xxxxxxxxxx|
|         x x--------|
|        x   x-------|
|       x     x------|
|      x       x-----|
|     x         x----|
|    x           x---|
|   x             x--|
|  x               x-|
| x                 x|
----------------------


Input command: b 0 10 .
CommandBucketFill ✓
----------------------
|x                   |
|.x                  |
|..x                 |
|...x                |
|....x               |
|.....x              |
|......x             |
|.......x            |
|........x           |
|.........x          |
|..........xxxxxxxxxx|
|.........x.x--------|
|........x...x-------|
|.......x.....x------|
|......x.......x-----|
|.....x.........x----|
|....x...........x---|
|...x.............x--|
|..x...............x-|
|.x.................x|
----------------------


Input command: b 18 19 =
CommandBucketFill ✓
----------------------
|x                   |
|.x                  |
|..x                 |
|...x                |
|....x               |
|.....x              |
|......x             |
|.......x            |
|........x           |
|.........x          |
|..........xxxxxxxxxx|
|.........x=x--------|
|........x===x-------|
|.......x=====x------|
|......x=======x-----|
|.....x=========x----|
|....x===========x---|
|...x=============x--|
|..x===============x-|
|.x=================x|
----------------------


Input command: q
Quit ✓
----------------------
|x                   |
|.x                  |
|..x                 |
|...x                |
|....x               |
|.....x              |
|......x             |
|.......x            |
|........x           |
|.........x          |
|..........xxxxxxxxxx|
|.........x=x--------|
|........x===x-------|
|.......x=====x------|
|......x=======x-----|
|.....x=========x----|
|....x===========x---|
|...x=============x--|
|..x===============x-|
|.x=================x|
----------------------

``` 






we would expect result as 
```
----------------------
|x///////////////////|
|.x//////////////////|
|..x/////////////////|
|...x////////////////|
|....x///////////////|
|.....x//////////////|
|......x/////////////|
|.......x////////////|
|........x///////////|
|.........x//////////|
|..........xxxxxxxxxx|
|.........xxx--------|
|........x x=x-------|
|.......x  x==x------|
|......x   x===x-----|
|.....x    x====x----|
|....x     x=====x---|
|...x      x======x--|
|..x       x=======x-|
|.x        x========x|
----------------------
```

