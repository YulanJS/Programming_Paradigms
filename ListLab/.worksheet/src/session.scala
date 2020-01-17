object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); 
  println("Welcome to the Scala worksheet")
  import scala.math. _;$skip(270); 
  //Yulan Jin List Processing I & II
  
  //List Processing I
  //problem 1: four versions
  //the sum of cubes of all odd numbers occurring in a list of integers
  //prepare:
  //define two helper functions first
  def isOdd(n: Int) = n % 2 == 1;System.out.println("""isOdd: (n: Int)Boolean""");$skip(31); 
  def cube(n: Int) = n * n * n;System.out.println("""cube: (n: Int)Int""");$skip(146); 
  
  //(1)iterative
  def sumCubeOdd(numbers: List[Int]) =
  {
  	var sum = 0
  	for(elem <- numbers if isOdd(elem)) sum += cube(elem)
  	sum
  };System.out.println("""sumCubeOdd: (numbers: List[Int])Int""");$skip(37); val res$0 = 
  
  sumCubeOdd(List(1, 2, 3, 4, 5));System.out.println("""res0: Int = """ + $show(res$0));$skip(21); val res$1 = 
  sumCubeOdd(List());System.out.println("""res1: Int = """ + $show(res$1));$skip(35); val res$2 = 
  sumCubeOdd(List(2, 4, 6, 8, 10));System.out.println("""res2: Int = """ + $show(res$2));$skip(35); val res$3 = 
  sumCubeOdd(List(3, 7, 8, 9, 11));System.out.println("""res3: Int = """ + $show(res$3));$skip(299); 
  //(2)recursive
  def sumCubeOddRecur(numbers: List[Int]): Int =
  	//only if else structure, no need for {}
  	//no need to declare a variable val here
  	if(numbers == Nil) 0
  	else if(isOdd(numbers.head)) cube(numbers.head) + sumCubeOddRecur(numbers.tail)
  	else sumCubeOddRecur(numbers.tail);System.out.println("""sumCubeOddRecur: (numbers: List[Int])Int""");$skip(26); val res$4 = 
  sumCubeOddRecur(List());System.out.println("""res4: Int = """ + $show(res$4));$skip(39); val res$5 = 
  sumCubeOddRecur(List(1, 2, 3, 4, 5));System.out.println("""res5: Int = """ + $show(res$5));$skip(40); val res$6 = 
  sumCubeOddRecur(List(2, 4, 6, 8, 10));System.out.println("""res6: Int = """ + $show(res$6));$skip(40); val res$7 = 
  sumCubeOddRecur(List(3, 7, 8, 9, 11));System.out.println("""res7: Int = """ + $show(res$7));$skip(296); 

  //(3)tail recursive
  def sumCubeOddTail(numbers: List[Int]) =
  {
  	def helper(result: Int, unseen: List[Int]): Int =
  		if(unseen == Nil) result
  		else if(isOdd(unseen.head)) helper(result + cube(unseen.head), unseen.tail)
  		else helper(result, unseen.tail)
  	helper(0, numbers)
  };System.out.println("""sumCubeOddTail: (numbers: List[Int])Int""");$skip(28); val res$8 = 
  
  sumCubeOddTail(List());System.out.println("""res8: Int = """ + $show(res$8));$skip(38); val res$9 = 
  sumCubeOddTail(List(1, 2, 3, 4, 5));System.out.println("""res9: Int = """ + $show(res$9));$skip(39); val res$10 = 
  sumCubeOddTail(List(2, 4, 6, 8, 10));System.out.println("""res10: Int = """ + $show(res$10));$skip(39); val res$11 = 
  sumCubeOddTail(List(3, 7, 8, 9, 11));System.out.println("""res11: Int = """ + $show(res$11));$skip(403); 
  
  //(4)map-filter-reduce
  def sumCubeOddMapFilterReduce(numbers: List[Int]) =
  	//a Nil collection can work under filter and map, but not reduce
  	//the original list is not nil, but the result after filter and map may be nil,
  	//it still cannot work under reduce
  	if(numbers.filter(isOdd _).map(cube _) == Nil) 0
  	else numbers.filter(isOdd _).map(cube _).reduce((x: Int, y: Int) => x + y);System.out.println("""sumCubeOddMapFilterReduce: (numbers: List[Int])Int""");$skip(41); val res$12 = 
  	
  sumCubeOddMapFilterReduce(List());System.out.println("""res12: Int = """ + $show(res$12));$skip(49); val res$13 = 
  sumCubeOddMapFilterReduce(List(1, 2, 3, 4, 5));System.out.println("""res13: Int = """ + $show(res$13));$skip(50); val res$14 = 
  sumCubeOddMapFilterReduce(List(2, 4, 6, 8, 10));System.out.println("""res14: Int = """ + $show(res$14));$skip(50); val res$15 = 
  sumCubeOddMapFilterReduce(List(3, 7, 8, 9, 11));System.out.println("""res15: Int = """ + $show(res$15));$skip(394); 
  
  //problem 2: four versions
  //!!!??? change it nested lists possible, be careful
	//computes the sum of numbers in a list of lists of numbers:
	//sumOfSums(List(List(1, 2, 3), List(4, 5, 6))) = 21
	//type List[List[Int]]
	
	//prepare
	//helper function first: how to deal with aList.head
	def sumOfList(aList: List[Int]) = if(aList == Nil) 0 else aList.reduce((x: Int, y: Int) => x + y);System.out.println("""sumOfList: (aList: List[Int])Int""");$skip(196); 
 	//(1)iterative
	def sumOfSums(aList: List[List[Int]]) =
	{
		var sum = 0
		for(subList <- aList)
		{
			//val and funciton name same may cause problems
			sum += sumOfList(subList)
		}
		sum
	};System.out.println("""sumOfSums: (aList: List[List[Int]])Int""");$skip(46); 
	val list21 = List(List(1, 2, 3), List(4, 5));System.out.println("""list21  : List[List[Int]] = """ + $show(list21 ));$skip(36); 
	val list22 = List(Nil, List(2, 5));System.out.println("""list22  : List[List[Int]] = """ + $show(list22 ));$skip(16); val res$16 = 
	sumOfSums(Nil);System.out.println("""res16: Int = """ + $show(res$16));$skip(19); val res$17 = 
	sumOfSums(list21);System.out.println("""res17: Int = """ + $show(res$17));$skip(19); val res$18 = 
	sumOfSums(list22);System.out.println("""res18: Int = """ + $show(res$18));$skip(148); 
	
	//(2)recursive
	def sumOfSumsRecur(aList: List[List[Int]]): Int =
		if(aList == Nil) 0
		else sumOfList(aList.head) + sumOfSumsRecur(aList.tail);System.out.println("""sumOfSumsRecur: (aList: List[List[Int]])Int""");$skip(21); val res$19 = 
	sumOfSumsRecur(Nil);System.out.println("""res19: Int = """ + $show(res$19));$skip(24); val res$20 = 
	sumOfSumsRecur(list21);System.out.println("""res20: Int = """ + $show(res$20));$skip(24); val res$21 = 
	sumOfSumsRecur(list22);System.out.println("""res21: Int = """ + $show(res$21));$skip(240); 
	
	//(3)tail recursive
	def sumOfSumsTail(aList: List[List[Int]]) =
	{
		def helper(result: Int, unseen: List[List[Int]]): Int =
			if(unseen == Nil) result
			else helper(result + sumOfList(unseen.head), unseen.tail)
		helper(0, aList)
	};System.out.println("""sumOfSumsTail: (aList: List[List[Int]])Int""");$skip(20); val res$22 = 
	sumOfSumsTail(Nil);System.out.println("""res22: Int = """ + $show(res$22));$skip(23); val res$23 = 
	sumOfSumsTail(list21);System.out.println("""res23: Int = """ + $show(res$23));$skip(23); val res$24 = 
	sumOfSumsTail(list22);System.out.println("""res24: Int = """ + $show(res$24));$skip(158); 
	
	//(4)map filter reduce
	
  def sumOfSumsMapFilterReduce(aList: List[List[Int]]) =
  {
  		if(aList == Nil) 0 else aList.map(sumOfList _).reduce(_ + _)
  };System.out.println("""sumOfSumsMapFilterReduce: (aList: List[List[Int]])Int""");$skip(32); val res$25 = 
  sumOfSumsMapFilterReduce(Nil);System.out.println("""res25: Int = """ + $show(res$25));$skip(35); val res$26 = 
  sumOfSumsMapFilterReduce(list21);System.out.println("""res26: Int = """ + $show(res$26));$skip(35); val res$27 = 
  sumOfSumsMapFilterReduce(list22);System.out.println("""res27: Int = """ + $show(res$27));$skip(738); 
  
  //problem 3:
  //depth(List(List(List(1, 2, List(3))))) = 4 a list of nested lists:
  //if I use type List[T], all elements are the same type
  //but it can be either a number or a nestedList
  //considering recursion, list.head may be a number, instead of a list, so use Any as the type
  //a number or other types, depth = 0
  //tail is a list... List(1, List(2)).tail = List(List(2)) NOT List(2)
  //!!!may combine case Nil and case _
  def depth(a: Any): Int =
  {
  	a match
  	{
  		case Nil => 0
  		//tail is made to be a list, when test depth, get 1 more than correct value, so depth - 1
  		//list = List(head, tail) max(d(h), d(t)) + 1
  		case head::tail => max(depth(head), depth(tail) - 1) + 1
  		case _ => 0
  	}
  };System.out.println("""depth: (a: Any)Int""");$skip(13); val res$28 = 
  depth(Nil);System.out.println("""res28: Int = """ + $show(res$28));$skip(11); val res$29 = 
  depth(1);System.out.println("""res29: Int = """ + $show(res$29));$skip(29); val res$30 = 
  depth(List(1, List(2, 3)));System.out.println("""res30: Int = """ + $show(res$30));$skip(41); val res$31 = 
  depth(List(List(List(1, List(3), 2))));System.out.println("""res31: Int = """ + $show(res$31));$skip(17); val res$32 = 
  depth(List(2));System.out.println("""res32: Int = """ + $show(res$32));$skip(29); val res$33 = 
  depth(List(List(2, 4), 1));System.out.println("""res33: Int = """ + $show(res$33));$skip(23); val res$34 = 
  depth(List(List(2)));System.out.println("""res34: Int = """ + $show(res$34));$skip(76); val res$35 = 
  depth(List(1, Nil, List(List(1, 2)), List(List(List(3, 4))), List(1, 2)));System.out.println("""res35: Int = """ + $show(res$35));$skip(338); 
  
  //problem 6: four versions
  //returns the number of elements in a list that satisfy a given predicate.
  //(The predicate is a parameter of type T=>Boolean.)
  
  //(1)iterative
  def numOfSatisfied[T](aList: List[T], predicate: T => Boolean) =
  {
  	var total = 0
  	for(elem <- aList if predicate(elem)) total += 1
  	total
  };System.out.println("""numOfSatisfied: [T](aList: List[T], predicate: T => Boolean)Int""");$skip(37); 
  
  def isEven(n: Int) = n % 2 == 0;System.out.println("""isEven: (n: Int)Boolean""");$skip(53); 
  def isPalindrome(str: String) = str == str.reverse;System.out.println("""isPalindrome: (str: String)Boolean""");$skip(19); 
  val list61 = Nil;System.out.println("""list61  : scala.collection.immutable.Nil.type = """ + $show(list61 ));$skip(35); 
  val list62 = List(1, 2, 3, 4, 5);System.out.println("""list62  : List[Int] = """ + $show(list62 ));$skip(48); 
  val list63 = List("dad", "mom", "me", "goog");System.out.println("""list63  : List[String] = """ + $show(list63 ));$skip(35); val res$36 = 
  numOfSatisfied(list61, isEven _);System.out.println("""res36: Int = """ + $show(res$36));$skip(35); val res$37 = 
  numOfSatisfied(list62, isEven _);System.out.println("""res37: Int = """ + $show(res$37));$skip(41); val res$38 = 
  numOfSatisfied(list63, isPalindrome _);System.out.println("""res38: Int = """ + $show(res$38));$skip(251); 
  
  //(2) recursive
  def numOfSatisfiedRecur[T](aList: List[T], predicate: T => Boolean): Int =
  	if(aList == Nil)0
  	else if(predicate(aList.head)) 1 + numOfSatisfiedRecur(aList.tail, predicate)
  	else numOfSatisfiedRecur(aList.tail, predicate);System.out.println("""numOfSatisfiedRecur: [T](aList: List[T], predicate: T => Boolean)Int""");$skip(45); val res$39 = 
  	
  numOfSatisfiedRecur(list61, isEven _);System.out.println("""res39: Int = """ + $show(res$39));$skip(40); val res$40 = 
  numOfSatisfiedRecur(list62, isEven _);System.out.println("""res40: Int = """ + $show(res$40));$skip(46); val res$41 = 
  numOfSatisfiedRecur(list63, isPalindrome _);System.out.println("""res41: Int = """ + $show(res$41));$skip(460); 
 
 	//(3) tail recursive
 	def numOfSatisfiedTail[T](aList: List[T], predicate: T => Boolean) =
 	{
 		//input parameters: aList and predicate, can be directly used in helper method
 		//no need to pass test(T => Boolean) into helper method
 		def helper(result: Int, unseen: List[T]): Int =
 		{
 			if(unseen == Nil) result
 			else if(predicate(unseen.head)) helper(result + 1, unseen.tail)
 			else helper(result, unseen.tail)
 		}
 		helper(0, aList)
 	};System.out.println("""numOfSatisfiedTail: [T](aList: List[T], predicate: T => Boolean)Int""");$skip(42); val res$42 = 
 	
 	numOfSatisfiedTail(list61, isEven _);System.out.println("""res42: Int = """ + $show(res$42));$skip(39); val res$43 = 
  numOfSatisfiedTail(list62, isEven _);System.out.println("""res43: Int = """ + $show(res$43));$skip(45); val res$44 = 
  numOfSatisfiedTail(list63, isPalindrome _);System.out.println("""res44: Int = """ + $show(res$44));$skip(218); 
  
  //(4) map filter reduce
  def numOfSatisfiedMapFilterReduce[T](aList: List[T], predicate: T => Boolean) =
    if(aList.filter(predicate) == Nil) 0
  	else aList.filter(predicate).map((elem: T) => 1).reduce(_ + _);System.out.println("""numOfSatisfiedMapFilterReduce: [T](aList: List[T], predicate: T => Boolean)Int""");$skip(52); val res$45 = 
    numOfSatisfiedMapFilterReduce(list61, isEven _);System.out.println("""res45: Int = """ + $show(res$45));$skip(52); val res$46 = 
    numOfSatisfiedMapFilterReduce(list62, isEven _);System.out.println("""res46: Int = """ + $show(res$46));$skip(58); val res$47 = 
    numOfSatisfiedMapFilterReduce(list63, isPalindrome _);System.out.println("""res47: Int = """ + $show(res$47));$skip(321); 
  //problem 7: four versions
  //returns true if all elements in a list satisfy a given predicate.
  
  //(1) iterative
  def allSatisfied[T](aList: List[T], predicate: T => Boolean) =
  {
  	//if found a not satisfied one, stop
  	var result = true
  	for(elem <- aList if result) result = predicate(elem)
  	result
  };System.out.println("""allSatisfied: [T](aList: List[T], predicate: T => Boolean)Boolean""");$skip(22); 
  
  val list71 = Nil;System.out.println("""list71  : scala.collection.immutable.Nil.type = """ + $show(list71 ));$skip(35); 
  val list72 = List(1, 2, 3, 4, 5);System.out.println("""list72  : List[Int] = """ + $show(list72 ));$skip(32); 
  val list73 = List(2, 4, 6, 8);System.out.println("""list73  : List[Int] = """ + $show(list73 ));$skip(48); 
  val list74 = List("dad", "mom", "me", "goog");System.out.println("""list74  : List[String] = """ + $show(list74 ));$skip(42); 
  val list75 = List("dad", "mom", "goog");System.out.println("""list75  : List[String] = """ + $show(list75 ));$skip(33); val res$48 = 
  allSatisfied(list71, isEven _);System.out.println("""res48: Boolean = """ + $show(res$48));$skip(33); val res$49 = 
  allSatisfied(list72, isEven _);System.out.println("""res49: Boolean = """ + $show(res$49));$skip(33); val res$50 = 
  allSatisfied(list73, isEven _);System.out.println("""res50: Boolean = """ + $show(res$50));$skip(39); val res$51 = 
  allSatisfied(list74, isPalindrome _);System.out.println("""res51: Boolean = """ + $show(res$51));$skip(39); val res$52 = 
  allSatisfied(list75, isPalindrome _);System.out.println("""res52: Boolean = """ + $show(res$52));$skip(196); 
  //(2) recursive
  def allSatisfiedRecur[T](aList: List[T], predicate: T => Boolean): Boolean =
  	if(aList == Nil) true
  	else predicate(aList.head) && allSatisfiedRecur(aList.tail, predicate);System.out.println("""allSatisfiedRecur: [T](aList: List[T], predicate: T => Boolean)Boolean""");$skip(229); val res$53 = 
  	//if I write in this way, it is already tail recursive, nothing appends to the recursive call
  	//else if(!predicate(aList.head)) false
  	//else allSatisfiedRecur(aList.tail, predicate)
  allSatisfiedRecur(list71, isEven _);System.out.println("""res53: Boolean = """ + $show(res$53));$skip(38); val res$54 = 
  allSatisfiedRecur(list72, isEven _);System.out.println("""res54: Boolean = """ + $show(res$54));$skip(38); val res$55 = 
  allSatisfiedRecur(list73, isEven _);System.out.println("""res55: Boolean = """ + $show(res$55));$skip(44); val res$56 = 
  allSatisfiedRecur(list74, isPalindrome _);System.out.println("""res56: Boolean = """ + $show(res$56));$skip(44); val res$57 = 
  allSatisfiedRecur(list75, isPalindrome _);System.out.println("""res57: Boolean = """ + $show(res$57));$skip(356); 
  
  //(3) tail recursive
  def allSatisfiedTail[T](aList: List[T], predicate: T => Boolean) =
  {
  	def helper(result: Boolean, unseen: List[T]): Boolean =
  	{
  		//to be consistent, all to be tail recursive, don't finish early
  		if(unseen == Nil) result
  		else helper(result && predicate(unseen.head), unseen.tail)
  	}
  	helper(true, aList)
  };System.out.println("""allSatisfiedTail: [T](aList: List[T], predicate: T => Boolean)Boolean""");$skip(37); val res$58 = 
  allSatisfiedTail(list71, isEven _);System.out.println("""res58: Boolean = """ + $show(res$58));$skip(37); val res$59 = 
  allSatisfiedTail(list72, isEven _);System.out.println("""res59: Boolean = """ + $show(res$59));$skip(37); val res$60 = 
  allSatisfiedTail(list73, isEven _);System.out.println("""res60: Boolean = """ + $show(res$60));$skip(43); val res$61 = 
  allSatisfiedTail(list74, isPalindrome _);System.out.println("""res61: Boolean = """ + $show(res$61));$skip(43); val res$62 = 
  allSatisfiedTail(list75, isPalindrome _);System.out.println("""res62: Boolean = """ + $show(res$62));$skip(155); 
  
  //(4) Map Filter Reduce
  def allSatisfiedMapFilterReduce[T](aList: List[T], predicate: T => Boolean) =
  	aList.filter(predicate).size == aList.size;System.out.println("""allSatisfiedMapFilterReduce: [T](aList: List[T], predicate: T => Boolean)Boolean""");$skip(51); val res$63 = 
  
 	allSatisfiedMapFilterReduce(list71, isEven _);System.out.println("""res63: Boolean = """ + $show(res$63));$skip(48); val res$64 = 
  allSatisfiedMapFilterReduce(list72, isEven _);System.out.println("""res64: Boolean = """ + $show(res$64));$skip(48); val res$65 = 
  allSatisfiedMapFilterReduce(list73, isEven _);System.out.println("""res65: Boolean = """ + $show(res$65));$skip(54); val res$66 = 
  allSatisfiedMapFilterReduce(list74, isPalindrome _);System.out.println("""res66: Boolean = """ + $show(res$66));$skip(54); val res$67 = 
  allSatisfiedMapFilterReduce(list75, isPalindrome _);System.out.println("""res67: Boolean = """ + $show(res$67));$skip(287); 
  
  
  //problem 8: four versions
  //returns true if any element in a list satisfies a given predicate.
  def anySatisfied[T](aList: List[T], predicate: T => Boolean) =
  {
  	//need revise
  	var result = false
  	for(elem <- aList if !result) result = predicate(elem)
  	result
  };System.out.println("""anySatisfied: [T](aList: List[T], predicate: T => Boolean)Boolean""");$skip(19); 
  val list80 = Nil;System.out.println("""list80  : scala.collection.immutable.Nil.type = """ + $show(list80 ));$skip(35); 
  val list81 = List(1, 2, 3, 4, 5);System.out.println("""list81  : List[Int] = """ + $show(list81 ));$skip(32); 
  val list82 = List(2, 4, 6, 8);System.out.println("""list82  : List[Int] = """ + $show(list82 ));$skip(32); 
  val list83 = List(1, 3, 5, 7);System.out.println("""list83  : List[Int] = """ + $show(list83 ));$skip(44); 
  val list84 = List("ab", "cd", "ef", "gh");System.out.println("""list84  : List[String] = """ + $show(list84 ));$skip(42); 
  val list85 = List("dad", "mom", "goog");System.out.println("""list85  : List[String] = """ + $show(list85 ));$skip(37); 
  val list86 = List("search", "nan");System.out.println("""list86  : List[String] = """ + $show(list86 ));$skip(35); val res$68 = 
  
  anySatisfied(list80, isOdd _);System.out.println("""res68: Boolean = """ + $show(res$68));$skip(32); val res$69 = 
  anySatisfied(list81, isOdd _);System.out.println("""res69: Boolean = """ + $show(res$69));$skip(32); val res$70 = 
  anySatisfied(list82, isOdd _);System.out.println("""res70: Boolean = """ + $show(res$70));$skip(32); val res$71 = 
  anySatisfied(list83, isOdd _);System.out.println("""res71: Boolean = """ + $show(res$71));$skip(39); val res$72 = 
  anySatisfied(list84, isPalindrome _);System.out.println("""res72: Boolean = """ + $show(res$72));$skip(39); val res$73 = 
  anySatisfied(list85, isPalindrome _);System.out.println("""res73: Boolean = """ + $show(res$73));$skip(39); val res$74 = 
  anySatisfied(list86, isPalindrome _);System.out.println("""res74: Boolean = """ + $show(res$74));$skip(348); 
  
  //(2) recursive
  def anySatisfiedRecur[T](aList: List[T], predicate: T => Boolean): Boolean =
  {
  	if(aList == Nil) false
  	else predicate(aList.head) || anySatisfiedRecur(aList.tail, predicate)
  	//the following way is tail recursive already
  	//else if(predicate(aList.head))true
  	//else anySatisfiedRecur(aList.tail, predicate)
  };System.out.println("""anySatisfiedRecur: [T](aList: List[T], predicate: T => Boolean)Boolean""");$skip(40); val res$75 = 
  
  anySatisfiedRecur(list80, isOdd _);System.out.println("""res75: Boolean = """ + $show(res$75));$skip(37); val res$76 = 
  anySatisfiedRecur(list81, isOdd _);System.out.println("""res76: Boolean = """ + $show(res$76));$skip(37); val res$77 = 
  anySatisfiedRecur(list82, isOdd _);System.out.println("""res77: Boolean = """ + $show(res$77));$skip(37); val res$78 = 
  anySatisfiedRecur(list83, isOdd _);System.out.println("""res78: Boolean = """ + $show(res$78));$skip(44); val res$79 = 
  anySatisfiedRecur(list84, isPalindrome _);System.out.println("""res79: Boolean = """ + $show(res$79));$skip(44); val res$80 = 
  anySatisfiedRecur(list85, isPalindrome _);System.out.println("""res80: Boolean = """ + $show(res$80));$skip(44); val res$81 = 
  anySatisfiedRecur(list86, isPalindrome _);System.out.println("""res81: Boolean = """ + $show(res$81));$skip(286); 
  
  //(3)tail recursive
  def anySatisfiedTail[T](aList: List[T], predicate: T => Boolean)=
  {
  	def helper(result: Boolean, unseen: List[T]): Boolean =
  	{
  		if(unseen == Nil) result
  		else helper(result || predicate(unseen.head), unseen.tail)
  	}
  	helper(false, aList)
  };System.out.println("""anySatisfiedTail: [T](aList: List[T], predicate: T => Boolean)Boolean""");$skip(40); val res$82 = 
  
  anySatisfiedRecur(list80, isOdd _);System.out.println("""res82: Boolean = """ + $show(res$82));$skip(37); val res$83 = 
  anySatisfiedRecur(list81, isOdd _);System.out.println("""res83: Boolean = """ + $show(res$83));$skip(37); val res$84 = 
  anySatisfiedRecur(list82, isOdd _);System.out.println("""res84: Boolean = """ + $show(res$84));$skip(37); val res$85 = 
  anySatisfiedRecur(list83, isOdd _);System.out.println("""res85: Boolean = """ + $show(res$85));$skip(44); val res$86 = 
  anySatisfiedRecur(list84, isPalindrome _);System.out.println("""res86: Boolean = """ + $show(res$86));$skip(44); val res$87 = 
  anySatisfiedRecur(list85, isPalindrome _);System.out.println("""res87: Boolean = """ + $show(res$87));$skip(44); val res$88 = 
  anySatisfiedRecur(list86, isPalindrome _);System.out.println("""res88: Boolean = """ + $show(res$88));$skip(150); 
  
  //map filter reduce
  def anySatisfiedMapFilterReduce[T](aList: List[T], predicate: T => Boolean)=
  {
  	aList.filter(predicate).size != 0
  };System.out.println("""anySatisfiedMapFilterReduce: [T](aList: List[T], predicate: T => Boolean)Boolean""");$skip(50); val res$89 = 
  
  anySatisfiedMapFilterReduce(list80, isOdd _);System.out.println("""res89: Boolean = """ + $show(res$89));$skip(47); val res$90 = 
  anySatisfiedMapFilterReduce(list81, isOdd _);System.out.println("""res90: Boolean = """ + $show(res$90));$skip(47); val res$91 = 
  anySatisfiedMapFilterReduce(list82, isOdd _);System.out.println("""res91: Boolean = """ + $show(res$91));$skip(47); val res$92 = 
  anySatisfiedMapFilterReduce(list83, isOdd _);System.out.println("""res92: Boolean = """ + $show(res$92));$skip(54); val res$93 = 
  anySatisfiedMapFilterReduce(list84, isPalindrome _);System.out.println("""res93: Boolean = """ + $show(res$93));$skip(54); val res$94 = 
  anySatisfiedMapFilterReduce(list85, isPalindrome _);System.out.println("""res94: Boolean = """ + $show(res$94));$skip(54); val res$95 = 
  anySatisfiedMapFilterReduce(list86, isPalindrome _);System.out.println("""res95: Boolean = """ + $show(res$95));$skip(315); 
                                                  
  //problem 10
  
  def isAscending(aList: List[Int]) =
  {
  	def helper(result: Boolean, unseen: List[Int]): Boolean =
  	{
  		if(unseen.size < 2) result
  		else helper(result && (unseen.head <= unseen.tail.head), unseen.tail)
  	}
  	helper(true, aList)
  };System.out.println("""isAscending: (aList: List[Int])Boolean""");$skip(20); 
  val list101 = Nil;System.out.println("""list101  : scala.collection.immutable.Nil.type = """ + $show(list101 ));$skip(24); 
  val list102 = List(1);System.out.println("""list102  : List[Int] = """ + $show(list102 ));$skip(27); 
 	val list103 = List(2, 1);System.out.println("""list103  : List[Int] = """ + $show(list103 ));$skip(29); 
	val list104 = List(1, 1, 3);System.out.println("""list104  : List[Int] = """ + $show(list104 ));$skip(32); 
	val list105 = List(4, 1, 2, 3);System.out.println("""list105  : List[Int] = """ + $show(list105 ));$skip(38); 
	val list106 = List(-5, -3, -4, 0, 6);System.out.println("""list106  : List[Int] = """ + $show(list106 ));$skip(24); val res$96 = 
	
	isAscending(list101);System.out.println("""res96: Boolean = """ + $show(res$96));$skip(22); val res$97 = 
	isAscending(list102);System.out.println("""res97: Boolean = """ + $show(res$97));$skip(22); val res$98 = 
	isAscending(list103);System.out.println("""res98: Boolean = """ + $show(res$98));$skip(22); val res$99 = 
	isAscending(list104);System.out.println("""res99: Boolean = """ + $show(res$99));$skip(22); val res$100 = 
	isAscending(list105);System.out.println("""res100: Boolean = """ + $show(res$100));$skip(22); val res$101 = 
	isAscending(list106);System.out.println("""res101: Boolean = """ + $show(res$101));$skip(327); 
	
	/*
	def isAscending(aList: List[Int]) =
	{
		aList == aList.sorted
	}
	
	isAscending(list101)
	isAscending(list102)
	isAscending(list103)
	isAscending(list104)
	isAscending(list105)
	isAscending(list106)
	*/
  
  //problem 13
  //create stream
  //An infinitely long stream of 1's
  def allOnes: Stream[Int] = 1 #:: allOnes;System.out.println("""allOnes: => Stream[Int]""");$skip(24); 
  val stream1 = allOnes;System.out.println("""stream1  : Stream[Int] = """ + $show(stream1 ));$skip(15); val res$102 = 
  stream1.head;System.out.println("""res102: Int = """ + $show(res$102));$skip(20); val res$103 = 
  stream1.tail.head;System.out.println("""res103: Int = """ + $show(res$103));$skip(25); val res$104 = 
  stream1.tail.tail.head;System.out.println("""res104: Int = """ + $show(res$104));$skip(10); val res$105 = 
  stream1;System.out.println("""res105: Stream[Int] = """ + $show(res$105));$skip(122); 
  
  //The stream of all non-negative integers
  def allNonNegatives(n: Int): Stream[Int] = n #:: allNonNegatives(n + 1);System.out.println("""allNonNegatives: (n: Int)Stream[Int]""");$skip(35); 
  val stream2 = allNonNegatives(0);System.out.println("""stream2  : Stream[Int] = """ + $show(stream2 ));$skip(15); val res$106 = 
  stream2.head;System.out.println("""res106: Int = """ + $show(res$106));$skip(20); val res$107 = 
  stream2.tail.head;System.out.println("""res107: Int = """ + $show(res$107));$skip(25); val res$108 = 
  stream2.tail.tail.head;System.out.println("""res108: Int = """ + $show(res$108));$skip(10); val res$109 = 
  stream2;System.out.println("""res109: Stream[Int] = """ + $show(res$109));$skip(135); 
   
  //The stream of all non-negative even integers
  def allNonNegativeEvens(n: Int): Stream[Int] = n #:: allNonNegativeEvens(n + 2);System.out.println("""allNonNegativeEvens: (n: Int)Stream[Int]""");$skip(39); 
  val stream3 = allNonNegativeEvens(0);System.out.println("""stream3  : Stream[Int] = """ + $show(stream3 ));$skip(13); val res$110 = 
  stream3(5);System.out.println("""res110: Int = """ + $show(res$110));$skip(10); val res$111 = 
  stream3;System.out.println("""res111: Stream[Int] = """ + $show(res$111));$skip(116); 
  
  //The stream of all squares of integers
  def allSquares(n: Int): Stream[Int] = (n * n) #:: allSquares(n + 1);System.out.println("""allSquares: (n: Int)Stream[Int]""");$skip(33); 
  
  val stream4 = allSquares(0);System.out.println("""stream4  : Stream[Int] = """ + $show(stream4 ));$skip(13); val res$112 = 
  stream4(4);System.out.println("""res112: Int = """ + $show(res$112));$skip(10); val res$113 = 
  stream4;System.out.println("""res113: Stream[Int] = """ + $show(res$113));$skip(132); 
  
  //List Processing II
  //problem 1
  var cs152 = List(List(93.0, 89.0, 90.0), List(75.0, 76.0, 68.0), List(88.0, 82.0, 78.0));System.out.println("""cs152  : List[List[Double]] = """ + $show(cs152 ));$skip(91); 
  var cs151 = List(List(90.0, 85.0, 83.0), List(69.0, 67.0, 55.0), List(69.0, 70.0, 71.0));System.out.println("""cs151  : List[List[Double]] = """ + $show(cs151 ));$skip(121); 
  def avg(scores: List[Double]): Double = //avg of scores
  	if(scores == Nil) 0 else scores.reduce(_ + _) / scores.size;System.out.println("""avg: (scores: List[Double])Double""");$skip(118); 

	def avgAvg(scores: List[List[Double]]): List[Double] =
   	//list of averages for each student
  	scores.map(avg _);System.out.println("""avgAvg: (scores: List[List[Double]])List[Double]""");$skip(20); val res$114 = 
  	
	avgAvg(cs152);System.out.println("""res114: List[Double] = """ + $show(res$114));$skip(15); val res$115 = 
	avgAvg(cs151);System.out.println("""res115: List[Double] = """ + $show(res$115));$skip(333); 
	
	def passing(scores: List[List[Double]]): List[Int] =
   //list of positions in the list with avg >= 70
   	//a list of Double
  {
   	var list1 = List[Int]() //List[Int](), otherwise, error
   	//append element to a list :+ elem
  	for(i <- 0 until avgAvg(scores).size if avgAvg(scores)(i) >= 70) {list1 = list1:+ i}
  	list1
  };System.out.println("""passing: (scores: List[List[Double]])List[Int]""");$skip(16); val res$116 = 
	passing(cs152);System.out.println("""res116: List[Int] = """ + $show(res$116));$skip(16); val res$117 = 
	passing(cs151);System.out.println("""res117: List[Int] = """ + $show(res$117));$skip(295); 
	
	/*
	def passing1(scores: List[List[Double]]): List[Int] =
	{
		avgAvg(scores).map((x: Double) => if(x >= 70)avgAvg(scores).indexOf(x) else -1).filter((y: Int) => y != -1)
	}
	
	passing1(cs152)
	passing1(cs151)
	*/
	
	def sum(aList: List[Double]) = if(aList == Nil) 0 else aList.reduce(_ + _);System.out.println("""sum: (aList: List[Double])Double""");$skip(137); 
	def sumSums(scores: List[List[Double]]):Double = //sum of sums of all scores
		if(scores == Nil) 0 else scores.map(sum _).reduce(_ + _);System.out.println("""sumSums: (scores: List[List[Double]])Double""");$skip(18); val res$118 = 
	
	sumSums(cs152);System.out.println("""res118: Double = """ + $show(res$118));$skip(16); val res$119 = 
	sumSums(cs151);System.out.println("""res119: Double = """ + $show(res$119));$skip(349); 
	
	//problem 2
	def spellCheck0(doc: List[String], dictionary: List[String]): List[String] =
	{
		//tail recursion
		def helper(result: List[String], unseen: List[String]): List[String] =
			if(unseen == Nil) result
			else helper(if(dictionary.contains(unseen.head)) result else result :+ unseen.head, unseen.tail)
		helper(List[String](), doc)
	};System.out.println("""spellCheck0: (doc: List[String], dictionary: List[String])List[String]""");$skip(66); val res$120 = 
	
	spellCheck0(List("scala", "java", "c"), List("c", "assembly"));System.out.println("""res120: List[String] = """ + $show(res$120));$skip(41); val res$121 = 
  spellCheck0(Nil, List("sjsu", "sjcc"));System.out.println("""res121: List[String] = """ + $show(res$121));$skip(24); val res$122 = 
  spellCheck0(Nil, Nil);System.out.println("""res122: List[String] = """ + $show(res$122));$skip(42); val res$123 = 
  spellCheck0(List("scala", "java"), Nil);System.out.println("""res123: List[String] = """ + $show(res$123));$skip(268); 
  
  //problem 3
  //3. A document is a list of words. A dictionary is a list of words. Implement:
	def spellCheck(doc: List[String], dictionary: List[String]): List[String] =
	//all words in doc not in dictionary
		doc.filter((x: String) => !dictionary.contains(x));System.out.println("""spellCheck: (doc: List[String], dictionary: List[String])List[String]""");$skip(65); val res$124 = 
	
	spellCheck(List("scala", "java", "c"), List("c", "assembly"));System.out.println("""res124: List[String] = """ + $show(res$124));$skip(40); val res$125 = 
  spellCheck(Nil, List("sjsu", "sjcc"));System.out.println("""res125: List[String] = """ + $show(res$125));$skip(23); val res$126 = 
  spellCheck(Nil, Nil);System.out.println("""res126: List[String] = """ + $show(res$126));$skip(41); val res$127 = 
  spellCheck(List("scala", "java"), Nil);System.out.println("""res127: List[String] = """ + $show(res$127));$skip(347); 
  
  //problem 4
  //4. A polynomial can be represented as a list of monomials. A monomial is a pair of the form (coefficient, exponent). For example, 3x2 – 5 is:
	//List((3.0, 2.0), (-5.0, 0.0))
	//Implement:
	def evalMono(mono: (Double, Double), x: Double): Double =
		//result of substituting x in mono, only a pair
		mono._1 * pow(x, mono._2);System.out.println("""evalMono: (mono: (Double, Double), x: Double)Double""");$skip(165); 
	def evalPoly(poly: List[(Double, Double)], x: Double): Double =
		//resut of substituting x in poly
		if(poly == Nil) 0 else poly.map(evalMono(_, x)).reduce(_ + _);System.out.println("""evalPoly: (poly: List[(Double, Double)], x: Double)Double""");$skip(44); 
	
	val poly0 = List((3.0, 2.0),(-5.0, 0.0));System.out.println("""poly0  : List[(Double, Double)] = """ + $show(poly0 ));$skip(23); val res$128 = 
	evalMono(poly0(0), 2);System.out.println("""res128: Double = """ + $show(res$128));$skip(23); val res$129 = 
	evalMono(poly0(1), 2);System.out.println("""res129: Double = """ + $show(res$129));$skip(20); val res$130 = 
	evalPoly(poly0, 2);System.out.println("""res130: Double = """ + $show(res$130))}
}
