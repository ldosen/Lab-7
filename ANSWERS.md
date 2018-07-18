## _What is the purpose of the various auxiliary methods `populateList`, `populateFifoList`, and `ReverseLines.printReverse`?_
All of these methods contain recursive logic within them. In the case of `populateList` and `populateFifoList`,  recursion is being used in place of a loop to iterate through the given stack and add values to the List. `printReverse` is being used in place of our stack implementation to push strings onto a stack and them print them in reverse. Because java pushes non-returned instances onto a sort-of stack, this method functions almost identically to `ReverseLines` in Lab-5.

## _Why do these methods need to have arguments, and how does the argument change from one recursive call to the next?_
Let's take, `populateList` for example. The goal of the recursive logic is to replace the while loop that was used to iterate through the stack in Lab-5 and add the items to the list. This method needs arguments because it needs to know where to start but also what `List` to add elements to. Because the method needs to progress towards the base case, the recursive call will be different from the initial method call. In the case of `populateList` the recursive method starts on `curr + 1` instead of `curr` like the initial call. How I think of it is like a replacement for using the `++` operator to increment a counter variable in a for/while loop.

## _What are the time and space complexity of each of the `populateList`  `populateFifoList` methods, as well as `ReverseLines.printReverse`?_
The time and space complexity for the populate methods is `O(n)`. These methods will continue to call themselves until the base case is satisfied, which in this case is directly related to the size of the stack it has toe iterate through. Thus, the time it takes to execute grows linearly. A recursive method will keep creating instances until the base case is met, which again is directly related to the size of the stack. Thus, the amount of space this method could ever use is `O(n)`

The time and space complexity of `ReverseLines.prinstReverse` is `O(n)`. While the initial print statement is completed in constant time, once EOF is reached, the stack of instances must be returned to an print again. The max amount of space this method could possibly take up would depend on how many Strings are entered by EOF is reached.

## _Which of these methods can be implemented using `while` loops?_
All of them can be implemented using `while` loops. In fact, all of these operations were performed using while loops in Lab-5 when we first implemented them.
