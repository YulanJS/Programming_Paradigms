object recursionSession {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(69); 
  println("Welcome to the Scala worksheet");$skip(51); 
  //CS 152 Yulan Jin
  
  def inc(n: Int) = n + 1;System.out.println("""inc: (n: Int)Int""");$skip(26); 
  def dec(n: Int) = n - 1;System.out.println("""dec: (n: Int)Int""");$skip(30); 
  def isZero(n: Int) = n == 0;System.out.println("""isZero: (n: Int)Boolean""");$skip(153); 
  //assume all input are nonnegative integers
  
  //problem 1: use recursion
  def add(n: Int, m: Int) : Int = if(isZero(m)) n else inc(add(n, dec(m)));System.out.println("""add: (n: Int, m: Int)Int""");$skip(11); val res$0 = 
  add(1,0);System.out.println("""res0: Int = """ + $show(res$0));$skip(11); val res$1 = 
  add(2,3);System.out.println("""res1: Int = """ + $show(res$1));$skip(11); val res$2 = 
  add(0,4);System.out.println("""res2: Int = """ + $show(res$2));$skip(11); val res$3 = 
  add(0,0);System.out.println("""res3: Int = """ + $show(res$3));$skip(109); 
  
  //problem 2: can use add
  def mul(n: Int, m: Int) : Int = if(isZero(m)) 0 else add(n, mul(n, dec(m)));System.out.println("""mul: (n: Int, m: Int)Int""");$skip(11); val res$4 = 
  mul(0,4);System.out.println("""res4: Int = """ + $show(res$4));$skip(11); val res$5 = 
  mul(6,0);System.out.println("""res5: Int = """ + $show(res$5));$skip(11); val res$6 = 
  mul(7,8);System.out.println("""res6: Int = """ + $show(res$6));$skip(11); val res$7 = 
  mul(1,6);System.out.println("""res7: Int = """ + $show(res$7));$skip(86); 
  
  //problem 3
  def exp2(m: Int): Int = if(isZero(m)) 1 else mul(exp2(dec(m)), 2);System.out.println("""exp2: (m: Int)Int""");$skip(10); val res$8 = 
  exp2(0);System.out.println("""res8: Int = """ + $show(res$8));$skip(10); val res$9 = 
  exp2(1);System.out.println("""res9: Int = """ + $show(res$9));$skip(10); val res$10 = 
  exp2(4);System.out.println("""res10: Int = """ + $show(res$10));$skip(10); val res$11 = 
  exp2(6);System.out.println("""res11: Int = """ + $show(res$11));$skip(92); 
  
  //problem 4
  def hyperExp(n: Int): Int = if(isZero(n)) 1 else exp2(hyperExp(dec(n)));System.out.println("""hyperExp: (n: Int)Int""");$skip(14); val res$12 = 
  hyperExp(0);System.out.println("""res12: Int = """ + $show(res$12));$skip(14); val res$13 = 
  hyperExp(1);System.out.println("""res13: Int = """ + $show(res$13));$skip(14); val res$14 = 
  hyperExp(2);System.out.println("""res14: Int = """ + $show(res$14));$skip(14); val res$15 = 
  hyperExp(3);System.out.println("""res15: Int = """ + $show(res$15));$skip(368); 
  //hyperExp(4) already stack overflow?
  
  //problem 5
  //p1 rewrite with tail recursion: only allowed to use isZero(), no other comparisons
  //count reversely, index from bigger ones to smaller ones
  def addTail(n: Int, m: Int) =
  {
  	def helper(count: Int, result: Int): Int = if(isZero(count)) result else helper(dec(count), inc(result))
  	helper(m, n)
  };System.out.println("""addTail: (n: Int, m: Int)Int""");$skip(15); val res$16 = 
  addTail(3,0);System.out.println("""res16: Int = """ + $show(res$16));$skip(15); val res$17 = 
  addTail(0,0);System.out.println("""res17: Int = """ + $show(res$17));$skip(15); val res$18 = 
  addTail(4,3);System.out.println("""res18: Int = """ + $show(res$18));$skip(15); val res$19 = 
  addTail(5,6);System.out.println("""res19: Int = """ + $show(res$19));$skip(15); val res$20 = 
  addTail(0,8);System.out.println("""res20: Int = """ + $show(res$20));$skip(238); 
  
  //p2 rewrite with tail recursion: use addTial instead of add
  def mulTail(n: Int, m: Int) =
  {
  	def helper(count: Int, result: Int): Int = if(isZero(count)) result else helper(dec(count), addTail(n, result))
  	helper(m, 0)
  };System.out.println("""mulTail: (n: Int, m: Int)Int""");$skip(15); val res$21 = 
  mulTail(3,0);System.out.println("""res21: Int = """ + $show(res$21));$skip(15); val res$22 = 
  mulTail(0,7);System.out.println("""res22: Int = """ + $show(res$22));$skip(15); val res$23 = 
  mulTail(4,3);System.out.println("""res23: Int = """ + $show(res$23));$skip(15); val res$24 = 
  mulTail(5,6);System.out.println("""res24: Int = """ + $show(res$24));$skip(204); 
  
  //p3 rewrite with tail recursion
   def exp2Tail(n: Int) =
  {
  	def helper(count: Int, result: Int): Int = if(isZero(count)) result else helper(dec(count), mulTail(result, 2))
  	helper(n, 1)
  };System.out.println("""exp2Tail: (n: Int)Int""");$skip(14); val res$25 = 
  exp2Tail(0);System.out.println("""res25: Int = """ + $show(res$25));$skip(14); val res$26 = 
  exp2Tail(1);System.out.println("""res26: Int = """ + $show(res$26));$skip(14); val res$27 = 
  exp2Tail(3);System.out.println("""res27: Int = """ + $show(res$27));$skip(14); val res$28 = 
  exp2Tail(6);System.out.println("""res28: Int = """ + $show(res$28));$skip(208); 
     
  //p4 rewrite with tail recursion
   def hyperExpTail(n: Int) =
  {
  	def helper(count: Int, result: Int): Int = if(isZero(count)) result else helper(dec(count), exp2Tail(result))
  	helper(n, 1)
  };System.out.println("""hyperExpTail: (n: Int)Int""");$skip(18); val res$29 = 
  hyperExpTail(0);System.out.println("""res29: Int = """ + $show(res$29));$skip(18); val res$30 = 
  hyperExpTail(1);System.out.println("""res30: Int = """ + $show(res$30));$skip(18); val res$31 = 
  hyperExpTail(3);System.out.println("""res31: Int = """ + $show(res$31));$skip(18); val res$32 = 
  hyperExpTail(4);System.out.println("""res32: Int = """ + $show(res$32));$skip(18); val res$33 = 
  hyperExpTail(5);System.out.println("""res33: Int = """ + $show(res$33));$skip(18); val res$34 = 
  hyperExpTail(8);System.out.println("""res34: Int = """ + $show(res$34));$skip(49); 
  println("The runtime should still be linear.");$skip(98); 
  println("hyperExp(4) causes stack overflow, but hyperExpTail(5) doesn't cause stack overflow.");$skip(105); 
  println("The value of hyperExpTail(5) is incorrect because it exceeds the 32 bit storage for an Int.");$skip(167); 
                                                  
  //problem 9 fib recursive and tail recursive
  def fib(n: Int): Int =  if(n <= 1) 1 else fib(n - 2) + fib(n - 1);System.out.println("""fib: (n: Int)Int""");$skip(9); val res$35 = 
  fib(0);System.out.println("""res35: Int = """ + $show(res$35));$skip(9); val res$36 = 
  fib(1);System.out.println("""res36: Int = """ + $show(res$36));$skip(9); val res$37 = 
  fib(2);System.out.println("""res37: Int = """ + $show(res$37));$skip(9); val res$38 = 
  fib(3);System.out.println("""res38: Int = """ + $show(res$38));$skip(9); val res$39 = 
  fib(4);System.out.println("""res39: Int = """ + $show(res$39));$skip(9); val res$40 = 
  fib(5);System.out.println("""res40: Int = """ + $show(res$40));$skip(185); 
  
  def fibTail(n: Int) =
  {
  	def helper(count: Int, prev: Int, curr: Int): Int =
  	{
  		if(count == n) curr else helper(count + 1, curr, prev + curr)
  	}
  	helper(0, 0, 1)
  };System.out.println("""fibTail: (n: Int)Int""");$skip(16); val res$41 = 
  
  fibTail(0);System.out.println("""res41: Int = """ + $show(res$41));$skip(13); val res$42 = 
  fibTail(1);System.out.println("""res42: Int = """ + $show(res$42));$skip(13); val res$43 = 
  fibTail(2);System.out.println("""res43: Int = """ + $show(res$43));$skip(13); val res$44 = 
  fibTail(3);System.out.println("""res44: Int = """ + $show(res$44));$skip(13); val res$45 = 
  fibTail(4);System.out.println("""res45: Int = """ + $show(res$45));$skip(13); val res$46 = 
  fibTail(5);System.out.println("""res46: Int = """ + $show(res$46));$skip(13); val res$47 = 
  fibTail(6);System.out.println("""res47: Int = """ + $show(res$47));$skip(13); val res$48 = 
  fibTail(7);System.out.println("""res48: Int = """ + $show(res$48));$skip(207); 
  
  //problem 10: choose m things from n things, use recursion

  def choose(n: Int, m: Int): Int =
  	if(n < m) 0
  	else if(m == 0) 1
  	else if(m == 1) n
  	else choose(n - 1, m - 1) + choose(n - 1, m);System.out.println("""choose: (n: Int, m: Int)Int""");$skip(17); val res$49 = 

  choose(2, 3);System.out.println("""res49: Int = """ + $show(res$49));$skip(15); val res$50 = 
  choose(4, 2);System.out.println("""res50: Int = """ + $show(res$50));$skip(15); val res$51 = 
  choose(5, 0);System.out.println("""res51: Int = """ + $show(res$51));$skip(15); val res$52 = 
  choose(3, 1);System.out.println("""res52: Int = """ + $show(res$52));$skip(15); val res$53 = 
  choose(5, 2);System.out.println("""res53: Int = """ + $show(res$53));$skip(15); val res$54 = 
  choose(0, 0);System.out.println("""res54: Int = """ + $show(res$54));$skip(15); val res$55 = 
  choose(0, 4);System.out.println("""res55: Int = """ + $show(res$55))}
}
