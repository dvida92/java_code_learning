package Basics.Class_and_Inheritance.Interface;

import Basics.Class_and_Inheritance.Interface.Series;

/**
 * Created by davidzhou on 3/7/17.
 */
class twoD implements Series { //Without "public" to modify class twoD, this
                                //class twoD only accessible within its own package
   int start;
   int val;

   twoD(){
       start = 0;
       val = 0;
   }

   public int getNext() {
       val += 2l;
       return val;
   }

   public void reset() {
       val = start;
   }

   public void setStart(int x) {
       start = x;
       val = x;
   }

}
