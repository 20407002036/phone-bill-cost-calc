phone-bill-cost-calc
====================

Program which calculates the cost of a phone bill using an itemised list of times.  

Running the program
-------------------
    javac Bill.java && java Bill [input file] [cost per min in double]

### Example
    javac Bill.java && java Bill items.txt 0.4

Run the application with items.txt as the input file and 0.4 as the cost of using 1 minute.

Items file
----------
The items file is the input for this program. It consists of the timings for each phone call. 

### Example

    30
    1.52
    5.23
    45
    1.25.03

The example above shows a bill with 5 phone calls. The items are:

1. a 30 second call
2. a 1 minute and 52 seconds call
3. a 5 minute and 23 seconds call
4. a 45 seconds calls
5. a 1 hour, 25 minutes and 3 seconds call
