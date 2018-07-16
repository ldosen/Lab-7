# COMP 271  Lab 7 

# Individual project

Collaborate with your classmates on a conceptual level but do not share code.
Submit individually.

# Objectives

An understanding of the following concepts and techniques:

- recursion (C/A)
- linear versus nonlinear recursion (C/A)
- relationship between recursion and stacks
- auxiliary methods with arguments (A)

# Instructions

First, start with your lab 5  solution.

https://github.com/channahnaiman/Lab5-cfn.git
Then, make the following modifications:

- `TestLinkedStack`: 

  - add the following lines to the end of `testAsListNonempty`:
  
        final List<String> list2 = fixture.asList();
        assertEquals(2, list2.size());
    
  - add the following tests after `testAsListNonempty`:
  
        @Test
        public void testAsFifoListEmpty() {
          assertEquals(0, fixture.asFifoList().size());
        }

        @Test
        public void testAsFifoListNonempty() {
          final String value1 = "hello";
          final String value2 = "world";
          fixture.push(value1);
          fixture.push(value2);
          final List<String> list = fixture.asFifoList();
          assertEquals(2, list.size());
          assertEquals(Arrays.asList(value1, value2), list);
          final List<String> list2 = fixture.asFifoList();
          assertEquals(2, list2.size());
        }  

- `IStack`: add the following method at the end:

      /**
       * Returns a Java list containing the items currently in the stack.
       * The item at the bottom of the stack is the first item of the list (at index 0).
       *
       * @post The stack remains unchanged.
       * @return The list containing the items in the stack
       */
      List<E> asFifoList();

- `LinkedStack`

  - change method `asList` as follows:
  
        @Override
        public List<E> asList() {
          final ArrayList<E> result = new ArrayList<>(size);
          populateList(null, result); // TODO replace null with the right reference
          return result;
        }  

  - add the following methods at the end:
  
        private void populateList(final Node<E> curr, final List<E> result) {
          // TODO recursively populate the list in the desired order
        }

        @Override
        public List<E> asFifoList() {
          final ArrayList<E> result = new ArrayList<>(size);
          populateFifoList(null, result); // TODO replace null with the right reference
          return result;
        }

        private void populateFifoList(final Node<E> curr, final List<E> result) {
          // TODO recursively populate the list in the desired order
        }
  
- `ReverseLines`: 

  - change `main` as follows:
  
        public static void main(final String[] args) {
          final Scanner input = new Scanner(System.in);
          printReverse(input);
        }
  
  - implement `printReverse` to *recursively* print the input lines in the order read and then again in reverse order:
  
        private static void printReverse(final Scanner input) {
          // TODO recursively read and print successive input lines until EOF, then print them out in reverse order
        }        
  
Finally, you are done when

- your implementation is logically correct
- all tests pass
- the main method behaves as expected, e.g.,
  
      ./build/scripts/cs2-lab7-linkedstack-java
      hello <- input line
      hello <- line echoed back by your program
      world <- input line
      world <- line echoed back by your program
      what  <- etc.
      what
      up
      up
      up    <- last line printed in reverse order
      what  <- second-last line printed in reverse order
      world <- etc.
      hello

# Written part

Answer the following questions:

- What is the purpose of the various auxiliary methods `populateList`, `populateFifoList`, and `ReverseLines.printReverse`?

- Why do these methods need to have arguments, and how does the argument change from one recursive call to the next?

- What are the time and space complexity of each of the `populateList` `populateFifoList` methods, as well as `ReverseLines.printReverse`?

- Which of these methods can be implemented using `while` loops?

# Grading

- 8 submission via GitHub
- 24 completion of items listed above
- 8 written part
 
*40 points TOTAL*
