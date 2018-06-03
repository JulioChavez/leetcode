/**
  Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

  For example,
  MovingAverage m = new MovingAverage(3);
  m.next(1) = 1
  m.next(10) = (1 + 10) / 2
  m.next(3) = (1 + 10 + 3) / 3
  m.next(5) = (10 + 3 + 5) / 3
 */

 class MovingAverage {
     private double[] items;
     private int numOfItems;
     private int ptr;

     /** Initialize your data structure here. */
     public MovingAverage(int size) {
         this.items = new double[size];
         this.numOfItems = 0;
         this.ptr = 0;
     }

     public double next(int val) {
         // Store the new value
         this.items[ptr] = val;

         // Update numOfItems until the array is full
         if (this.numOfItems < this.items.length)
             ++this.numOfItems;

         // Get total
         double total = 0;
         for (int i = 0; i < this.numOfItems; ++i) {
             total += this.items[i];
         }

         // Update the array pointer
         ptr = ++ptr % this.items.length;

         // Return the average
         return total / this.numOfItems;
     }
 }

 /**
  * Your MovingAverage object will be instantiated and called as such:
  * MovingAverage obj = new MovingAverage(size);
  * double param_1 = obj.next(val);
  */
