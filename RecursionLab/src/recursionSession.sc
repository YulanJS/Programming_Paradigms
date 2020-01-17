object recursionSession {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  //CS 152 Yulan Jin
  
  def inc(n: Int) = n + 1                         //> inc: (n: Int)Int
  def dec(n: Int) = n - 1                         //> dec: (n: Int)Int
  def isZero(n: Int) = n == 0                     //> isZero: (n: Int)Boolean
  //assume all input are nonnegative integers
  
  //problem 1: use recursion
  def add(n: Int, m: Int) : Int = if(isZero(m)) n else inc(add(n, dec(m)))
                                                  //> add: (n: Int, m: Int)Int
  add(1,0)                                        //> res0: Int = 1
  add(2,3)                                        //> res1: Int = 5
  add(0,4)                                        //> res2: Int = 4
  add(0,0)                                        //> res3: Int = 0
  
  //problem 2: can use add
  def mul(n: Int, m: Int) : Int = if(isZero(m)) 0 else add(n, mul(n, dec(m)))
                                                  //> mul: (n: Int, m: Int)Int
  mul(0,4)                                        //> res4: Int = 0
  mul(6,0)                                        //> res5: Int = 0
  mul(7,8)                                        //> res6: Int = 56
  mul(1,6)                                        //> res7: Int = 6
  
  //problem 3
  def exp2(m: Int): Int = if(isZero(m)) 1 else mul(exp2(dec(m)), 2)
                                                  //> exp2: (m: Int)Int
  exp2(0)                                         //> res8: Int = 1
  exp2(1)                                         //> res9: Int = 2
  exp2(4)                                         //> res10: Int = 16
  exp2(6)                                         //> res11: Int = 64
  
  //problem 4
  def hyperExp(n: Int): Int = if(isZero(n)) 1 else exp2(hyperExp(dec(n)))
                                                  //> hyperExp: (n: Int)Int
  hyperExp(0)                                     //> res12: Int = 1
  hyperExp(1)                                     //> res13: Int = 2
  hyperExp(2)                                     //> res14: Int = 4
  hyperExp(3)                                     //> res15: Int = 16
  //hyperExp(4) already stack overflow?
  
  //problem 5
  //p1 rewrite with tail recursion: only allowed to use isZero(), no other comparisons
  //count reversely, index from bigger ones to smaller ones
  def addTail(n: Int, m: Int) =
  {
  	def helper(count: Int, result: Int): Int = if(isZero(count)) result else helper(dec(count), inc(result))
  	helper(m, n)
  }                                               //> addTail: (n: Int, m: Int)Int
  addTail(3,0)                                    //> res16: Int = 3
  addTail(0,0)                                    //> res17: Int = 0
  addTail(4,3)                                    //> res18: Int = 7
  addTail(5,6)                                    //> res19: Int = 11
  addTail(0,8)                                    //> res20: Int = 8
  
  //p2 rewrite with tail recursion: use addTial instead of add
  def mulTail(n: Int, m: Int) =
  {
  	def helper(count: Int, result: Int): Int = if(isZero(count)) result else helper(dec(count), addTail(n, result))
  	helper(m, 0)
  }                                               //> mulTail: (n: Int, m: Int)Int
  mulTail(3,0)                                    //> res21: Int = 0
  mulTail(0,7)                                    //> res22: Int = 0
  mulTail(4,3)                                    //> res23: Int = 12
  mulTail(5,6)                                    //> res24: Int = 30
  
  //p3 rewrite with tail recursion
   def exp2Tail(n: Int) =
  {
  	def helper(count: Int, result: Int): Int = if(isZero(count)) result else helper(dec(count), mulTail(result, 2))
  	helper(n, 1)
  }                                               //> exp2Tail: (n: Int)Int
  exp2Tail(0)                                     //> res25: Int = 1
  exp2Tail(1)                                     //> res26: Int = 2
  exp2Tail(3)                                     //> res27: Int = 8
  exp2Tail(6)                                     //> res28: Int = 64
     
  //p4 rewrite with tail recursion
   def hyperExpTail(n: Int) =
  {
  	def helper(count: Int, result: Int): Int = if(isZero(count)) result else helper(dec(count), exp2Tail(result))
  	helper(n, 1)
  }                                               //> hyperExpTail: (n: Int)Int
  hyperExpTail(0)                                 //> res29: Int = 1
  hyperExpTail(1)                                 //> res30: Int = 2
  hyperExpTail(3)                                 //> res31: Int = 16
  hyperExpTail(4)                                 //> res32: Int = 65536
  hyperExpTail(5)                                 //> res33: Int = 0
  hyperExpTail(8)                                 //> res34: Int = 4
  println("The runtime should still be linear.")  //> The runtime should still be linear.
  println("hyperExp(4) causes stack overflow, but hyperExpTail(5) doesn't cause stack overflow.")
                                                  //> hyperExp(4) causes stack overflow, but hyperExpTail(5) doesn't cause stack 
                                                  //| overflow.
  println("The value of hyperExpTail(5) is incorrect because it exceeds the 32 bit storage for an Int.")
                                                  //> The value of hyperExpTail(5) is incorrect because it exceeds the 32 bit sto
                                                  //| rage for an Int.
                                                  
  //problem 9 fib recursive and tail recursive
  def fib(n: Int): Int =  if(n <= 1) 1 else fib(n - 2) + fib(n - 1)
                                                  //> fib: (n: Int)Int
  fib(0)                                          //> res35: Int = 1
  fib(1)                                          //> res36: Int = 1
  fib(2)                                          //> res37: Int = 2
  fib(3)                                          //> res38: Int = 3
  fib(4)                                          //> res39: Int = 5
  fib(5)                                          //> res40: Int = 8
  
  def fibTail(n: Int) =
  {
  	def helper(count: Int, prev: Int, curr: Int): Int =
  	{
  		if(count == n) curr else helper(count + 1, curr, prev + curr)
  	}
  	helper(0, 0, 1)
  }                                               //> fibTail: (n: Int)Int
  
  fibTail(0)                                      //> res41: Int = 1
  fibTail(1)                                      //> res42: Int = 1
  fibTail(2)                                      //> res43: Int = 2
  fibTail(3)                                      //> res44: Int = 3
  fibTail(4)                                      //> res45: Int = 5
  fibTail(5)                                      //> res46: Int = 8
  fibTail(6)                                      //> res47: Int = 13
  fibTail(7)                                      //> res48: Int = 21
  
  //problem 10: choose m things from n things, use recursion

  def choose(n: Int, m: Int): Int =
  	if(n < m) 0
  	else if(m == 0) 1
  	else if(m == 1) n
  	else choose(n - 1, m - 1) + choose(n - 1, m)
                                                  //> choose: (n: Int, m: Int)Int

  choose(2, 3)                                    //> res49: Int = 0
  choose(4, 2)                                    //> res50: Int = 6
  choose(5, 0)                                    //> res51: Int = 1
  choose(3, 1)                                    //> res52: Int = 3
  choose(5, 2)                                    //> res53: Int = 10
  choose(0, 0)                                    //> res54: Int = 1
  choose(0, 4)                                    //> res55: Int = 0
}