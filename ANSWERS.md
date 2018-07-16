## _Why does `LinkedStack` not require an explicit constructor?_
The simple answer to this question is that Java provides a default constructor for each class that accepts no parameters. The default constructor simply calls the `super` class constructor inherited from `Object` and initializes all of the instance variables for the class. We could have easily written an explicit constructor for this class however, say one that creates the stack and pushes a given element onto the top of it. Thus, the reason why we use the default constructor here instead of one we wrote ourselves is purely subjective. 

## _What is the time and (extra) space complexity of each of the  `LinkedStack`  methods, as well as  `ReverseLines.main`?_
The time complexity for all of the `LinkedStack` methods except for the `asList` method are O(1). These statements simply evaluate a few statements when invoked, don't involve loops, and don't use any kind of list. The time complexity for the `asList` method would be O(n). The time it would take to complete would increase as the size of the stack increases, thus it would take longer for `curr` to equal `null`. 

The space complexity for the `LinkedStack` methods are all O(1). In my experience so far, the major thing that increases space complexity of a method is if it takes an array or list as an argument as those can vary in size. As none of these methods take a list as a parameter, the number of memory calls they make will remain constant.

The time complexity for `ReverseLines.main` is O(n). As the size of the stack increases, the time it will take for each item to be popped and printed to the console will increase in proportion to the size of the stack. 

The space complexity for `ReverseLines.main` is O(n<sup>2</sup>). The method must allow N units of space for args and N units of space for the newly declared stack. 

## _How else (not using  `Node`) could we have implemented  `LinkedStack`  in such a way that it is still based on a linked list but the  `asList`  method uses constant time and space?_

We could use the LinkedList class provided by Java and use an integer `top` to keep track of which item in the list was the top. The push method would increment top while the pop method would decrement it. How to make the method perform its intended operation in constant time is a bit trickier. Any sort of iterating through the `List` with a loop would make the operation O(n). After a lot of thinking, I decided that the method should probably just return the LinkedList that makes the stack. `top` only serves a purpose inside of the stack class, but outside the `LinkedList` used as a stack would function just like any other `LinkedList`. To me this seems like the best solution: the method takes constant space as it no longer has to declare another List of size N and constant time as it simply returns the List itself without any kind of iteration.

##  _Is it better for  `push`  and  `pop`  to return the item or the stack itself? Briefly discuss the pros and cons of each design._
What `push` and `pop` return is really dependent on what the program needs to do. If we have a stack of Nodes that store student data and want to change the data of each Node in a certain order, having these two methods return the item itself make more sense. On the other hand, if we want to remove an item from a stack and then perform a different operation with the stack, then returning the stack itself would make more sense.
