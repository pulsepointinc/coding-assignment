## Pulse point coding assignment 
                
Let's imagine, in this repository we keep production code for some very important application. \ 
The statement of work you can find in the issue [#1](/../../issues/1).  

But, oh Boy! Our code contains some bugs and our users made an issue with an example of a wrong behaviour [#2](/../../issues/2) 

Your __goal__ is to figure out what's going on and __fix__ all bugs you can find.

As a result you have to create a [git-patch](https://www.jetbrains.com/help/idea/use-patches.html) and send it to **izemlyanskiy@pulsepoint.com** (yes, like a patch to the Linux Kernel) 

Good luck! 

### How to build and run

```
./gradlew clean build
```

Then in the folder `build/libs/` you may find an executable file which you could run with 
```
java -jar build/libs/coding-assignment-1.0.0-SNAPSHOT-all.jar
```