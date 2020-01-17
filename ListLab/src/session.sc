object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  import scala.math. _
  //Yulan Jin List Processing I & II
  
  //List Processing I
  //problem 1: four versions
  //the sum of cubes of all odd numbers occurring in a list of integers
  //prepare:
  //define two helper functions first
  def isOdd(n: Int) = n % 2 == 1                  //> isOdd: (n: Int)Boolean
  def cube(n: Int) = n * n * n                    //> cube: (n: Int)Int
  
  //(1)iterative
  def sumCubeOdd(numbers: List[Int]) =
  {
  	var sum = 0
  	for(elem <- numbers if isOdd(elem)) sum += cube(elem)
  	sum
  }                                               //> sumCubeOdd: (numbers: List[Int])Int
  
  sumCubeOdd(List(1, 2, 3, 4, 5))                 //> res0: Int = 153
  sumCubeOdd(List())                              //> res1: Int = 0
  sumCubeOdd(List(2, 4, 6, 8, 10))                //> res2: Int = 0
  sumCubeOdd(List(3, 7, 8, 9, 11))                //> res3: Int = 2430
  //(2)recursive
  def sumCubeOddRecur(numbers: List[Int]): Int =
  	//only if else structure, no need for {}
  	//no need to declare a variable val here
  	if(numbers == Nil) 0
  	else if(isOdd(numbers.head)) cube(numbers.head) + sumCubeOddRecur(numbers.tail)
  	else sumCubeOddRecur(numbers.tail)        //> sumCubeOddRecur: (numbers: List[Int])Int
  sumCubeOddRecur(List())                         //> res4: Int = 0
  sumCubeOddRecur(List(1, 2, 3, 4, 5))            //> res5: Int = 153
  sumCubeOddRecur(List(2, 4, 6, 8, 10))           //> res6: Int = 0
  sumCubeOddRecur(List(3, 7, 8, 9, 11))           //> res7: Int = 2430

  //(3)tail recursive
  def sumCubeOddTail(numbers: List[Int]) =
  {
  	def helper(result: Int, unseen: List[Int]): Int =
  		if(unseen == Nil) result
  		else if(isOdd(unseen.head)) helper(result + cube(unseen.head), unseen.tail)
  		else helper(result, unseen.tail)
  	helper(0, numbers)
  }                                               //> sumCubeOddTail: (numbers: List[Int])Int
  
  sumCubeOddTail(List())                          //> res8: Int = 0
  sumCubeOddTail(List(1, 2, 3, 4, 5))             //> res9: Int = 153
  sumCubeOddTail(List(2, 4, 6, 8, 10))            //> res10: Int = 0
  sumCubeOddTail(List(3, 7, 8, 9, 11))            //> res11: Int = 2430
  
  //(4)map-filter-reduce
  def sumCubeOddMapFilterReduce(numbers: List[Int]) =
  	//a Nil collection can work under filter and map, but not reduce
  	//the original list is not nil, but the result after filter and map may be nil,
  	//it still cannot work under reduce
  	if(numbers.filter(isOdd _).map(cube _) == Nil) 0
  	else numbers.filter(isOdd _).map(cube _).reduce((x: Int, y: Int) => x + y)
                                                  //> sumCubeOddMapFilterReduce: (numbers: List[Int])Int
  	
  sumCubeOddMapFilterReduce(List())               //> res12: Int = 0
  sumCubeOddMapFilterReduce(List(1, 2, 3, 4, 5))  //> res13: Int = 153
  sumCubeOddMapFilterReduce(List(2, 4, 6, 8, 10)) //> res14: Int = 0
  sumCubeOddMapFilterReduce(List(3, 7, 8, 9, 11)) //> res15: Int = 2430
  
  //problem 2: four versions
  //!!!??? change it nested lists possible, be careful
	//computes the sum of numbers in a list of lists of numbers:
	//sumOfSums(List(List(1, 2, 3), List(4, 5, 6))) = 21
	//type List[List[Int]]
	
	//prepare
	//helper function first: how to deal with aList.head
	def sumOfList(aList: List[Int]) = if(aList == Nil) 0 else aList.reduce((x: Int, y: Int) => x + y)
                                                  //> sumOfList: (aList: List[Int])Int
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
	}                                         //> sumOfSums: (aList: List[List[Int]])Int
	val list21 = List(List(1, 2, 3), List(4, 5))
                                                  //> list21  : List[List[Int]] = List(List(1, 2, 3), List(4, 5))
	val list22 = List(Nil, List(2, 5))        //> list22  : List[List[Int]] = List(List(), List(2, 5))
	sumOfSums(Nil)                            //> res16: Int = 0
	sumOfSums(list21)                         //> res17: Int = 15
	sumOfSums(list22)                         //> res18: Int = 7
	
	//(2)recursive
	def sumOfSumsRecur(aList: List[List[Int]]): Int =
		if(aList == Nil) 0
		else sumOfList(aList.head) + sumOfSumsRecur(aList.tail)
                                                  //> sumOfSumsRecur: (aList: List[List[Int]])Int
	sumOfSumsRecur(Nil)                       //> res19: Int = 0
	sumOfSumsRecur(list21)                    //> res20: Int = 15
	sumOfSumsRecur(list22)                    //> res21: Int = 7
	
	//(3)tail recursive
	def sumOfSumsTail(aList: List[List[Int]]) =
	{
		def helper(result: Int, unseen: List[List[Int]]): Int =
			if(unseen == Nil) result
			else helper(result + sumOfList(unseen.head), unseen.tail)
		helper(0, aList)
	}                                         //> sumOfSumsTail: (aList: List[List[Int]])Int
	sumOfSumsTail(Nil)                        //> res22: Int = 0
	sumOfSumsTail(list21)                     //> res23: Int = 15
	sumOfSumsTail(list22)                     //> res24: Int = 7
	
	//(4)map filter reduce
	
  def sumOfSumsMapFilterReduce(aList: List[List[Int]]) =
  {
  		if(aList == Nil) 0 else aList.map(sumOfList _).reduce(_ + _)
  }                                               //> sumOfSumsMapFilterReduce: (aList: List[List[Int]])Int
  sumOfSumsMapFilterReduce(Nil)                   //> res25: Int = 0
  sumOfSumsMapFilterReduce(list21)                //> res26: Int = 15
  sumOfSumsMapFilterReduce(list22)                //> res27: Int = 7
  
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
  }                                               //> depth: (a: Any)Int
  depth(Nil)                                      //> res28: Int = 0
  depth(1)                                        //> res29: Int = 0
  depth(List(1, List(2, 3)))                      //> res30: Int = 2
  depth(List(List(List(1, List(3), 2))))          //> res31: Int = 4
  depth(List(2))                                  //> res32: Int = 1
  depth(List(List(2, 4), 1))                      //> res33: Int = 2
  depth(List(List(2)))                            //> res34: Int = 2
  depth(List(1, Nil, List(List(1, 2)), List(List(List(3, 4))), List(1, 2)))
                                                  //> res35: Int = 4
  
  //problem 6: four versions
  //returns the number of elements in a list that satisfy a given predicate.
  //(The predicate is a parameter of type T=>Boolean.)
  
  //(1)iterative
  def numOfSatisfied[T](aList: List[T], predicate: T => Boolean) =
  {
  	var total = 0
  	for(elem <- aList if predicate(elem)) total += 1
  	total
  }                                               //> numOfSatisfied: [T](aList: List[T], predicate: T => Boolean)Int
  
  def isEven(n: Int) = n % 2 == 0                 //> isEven: (n: Int)Boolean
  def isPalindrome(str: String) = str == str.reverse
                                                  //> isPalindrome: (str: String)Boolean
  val list61 = Nil                                //> list61  : scala.collection.immutable.Nil.type = List()
  val list62 = List(1, 2, 3, 4, 5)                //> list62  : List[Int] = List(1, 2, 3, 4, 5)
  val list63 = List("dad", "mom", "me", "goog")   //> list63  : List[String] = List(dad, mom, me, goog)
  numOfSatisfied(list61, isEven _)                //> res36: Int = 0
  numOfSatisfied(list62, isEven _)                //> res37: Int = 2
  numOfSatisfied(list63, isPalindrome _)          //> res38: Int = 3
  
  //(2) recursive
  def numOfSatisfiedRecur[T](aList: List[T], predicate: T => Boolean): Int =
  	if(aList == Nil)0
  	else if(predicate(aList.head)) 1 + numOfSatisfiedRecur(aList.tail, predicate)
  	else numOfSatisfiedRecur(aList.tail, predicate)
                                                  //> numOfSatisfiedRecur: [T](aList: List[T], predicate: T => Boolean)Int
  	
  numOfSatisfiedRecur(list61, isEven _)           //> res39: Int = 0
  numOfSatisfiedRecur(list62, isEven _)           //> res40: Int = 2
  numOfSatisfiedRecur(list63, isPalindrome _)     //> res41: Int = 3
 
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
 	}                                         //> numOfSatisfiedTail: [T](aList: List[T], predicate: T => Boolean)Int
 	
 	numOfSatisfiedTail(list61, isEven _)      //> res42: Int = 0
  numOfSatisfiedTail(list62, isEven _)            //> res43: Int = 2
  numOfSatisfiedTail(list63, isPalindrome _)      //> res44: Int = 3
  
  //(4) map filter reduce
  def numOfSatisfiedMapFilterReduce[T](aList: List[T], predicate: T => Boolean) =
    if(aList.filter(predicate) == Nil) 0
  	else aList.filter(predicate).map((elem: T) => 1).reduce(_ + _)
                                                  //> numOfSatisfiedMapFilterReduce: [T](aList: List[T], predicate: T => Boolean)
                                                  //| Int
    numOfSatisfiedMapFilterReduce(list61, isEven _)
                                                  //> res45: Int = 0
    numOfSatisfiedMapFilterReduce(list62, isEven _)
                                                  //> res46: Int = 2
    numOfSatisfiedMapFilterReduce(list63, isPalindrome _)
                                                  //> res47: Int = 3
  //problem 7: four versions
  //returns true if all elements in a list satisfy a given predicate.
  
  //(1) iterative
  def allSatisfied[T](aList: List[T], predicate: T => Boolean) =
  {
  	//if found a not satisfied one, stop
  	var result = true
  	for(elem <- aList if result) result = predicate(elem)
  	result
  }                                               //> allSatisfied: [T](aList: List[T], predicate: T => Boolean)Boolean
  
  val list71 = Nil                                //> list71  : scala.collection.immutable.Nil.type = List()
  val list72 = List(1, 2, 3, 4, 5)                //> list72  : List[Int] = List(1, 2, 3, 4, 5)
  val list73 = List(2, 4, 6, 8)                   //> list73  : List[Int] = List(2, 4, 6, 8)
  val list74 = List("dad", "mom", "me", "goog")   //> list74  : List[String] = List(dad, mom, me, goog)
  val list75 = List("dad", "mom", "goog")         //> list75  : List[String] = List(dad, mom, goog)
  allSatisfied(list71, isEven _)                  //> res48: Boolean = true
  allSatisfied(list72, isEven _)                  //> res49: Boolean = false
  allSatisfied(list73, isEven _)                  //> res50: Boolean = true
  allSatisfied(list74, isPalindrome _)            //> res51: Boolean = false
  allSatisfied(list75, isPalindrome _)            //> res52: Boolean = true
  //(2) recursive
  def allSatisfiedRecur[T](aList: List[T], predicate: T => Boolean): Boolean =
  	if(aList == Nil) true
  	else predicate(aList.head) && allSatisfiedRecur(aList.tail, predicate)
                                                  //> allSatisfiedRecur: [T](aList: List[T], predicate: T => Boolean)Boolean
  	//if I write in this way, it is already tail recursive, nothing appends to the recursive call
  	//else if(!predicate(aList.head)) false
  	//else allSatisfiedRecur(aList.tail, predicate)
  allSatisfiedRecur(list71, isEven _)             //> res53: Boolean = true
  allSatisfiedRecur(list72, isEven _)             //> res54: Boolean = false
  allSatisfiedRecur(list73, isEven _)             //> res55: Boolean = true
  allSatisfiedRecur(list74, isPalindrome _)       //> res56: Boolean = false
  allSatisfiedRecur(list75, isPalindrome _)       //> res57: Boolean = true
  
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
  }                                               //> allSatisfiedTail: [T](aList: List[T], predicate: T => Boolean)Boolean
  allSatisfiedTail(list71, isEven _)              //> res58: Boolean = true
  allSatisfiedTail(list72, isEven _)              //> res59: Boolean = false
  allSatisfiedTail(list73, isEven _)              //> res60: Boolean = true
  allSatisfiedTail(list74, isPalindrome _)        //> res61: Boolean = false
  allSatisfiedTail(list75, isPalindrome _)        //> res62: Boolean = true
  
  //(4) Map Filter Reduce
  def allSatisfiedMapFilterReduce[T](aList: List[T], predicate: T => Boolean) =
  	aList.filter(predicate).size == aList.size//> allSatisfiedMapFilterReduce: [T](aList: List[T], predicate: T => Boolean)Bo
                                                  //| olean
  
 	allSatisfiedMapFilterReduce(list71, isEven _)
                                                  //> res63: Boolean = true
  allSatisfiedMapFilterReduce(list72, isEven _)   //> res64: Boolean = false
  allSatisfiedMapFilterReduce(list73, isEven _)   //> res65: Boolean = true
  allSatisfiedMapFilterReduce(list74, isPalindrome _)
                                                  //> res66: Boolean = false
  allSatisfiedMapFilterReduce(list75, isPalindrome _)
                                                  //> res67: Boolean = true
  
  
  //problem 8: four versions
  //returns true if any element in a list satisfies a given predicate.
  def anySatisfied[T](aList: List[T], predicate: T => Boolean) =
  {
  	//need revise
  	var result = false
  	for(elem <- aList if !result) result = predicate(elem)
  	result
  }                                               //> anySatisfied: [T](aList: List[T], predicate: T => Boolean)Boolean
  val list80 = Nil                                //> list80  : scala.collection.immutable.Nil.type = List()
  val list81 = List(1, 2, 3, 4, 5)                //> list81  : List[Int] = List(1, 2, 3, 4, 5)
  val list82 = List(2, 4, 6, 8)                   //> list82  : List[Int] = List(2, 4, 6, 8)
  val list83 = List(1, 3, 5, 7)                   //> list83  : List[Int] = List(1, 3, 5, 7)
  val list84 = List("ab", "cd", "ef", "gh")       //> list84  : List[String] = List(ab, cd, ef, gh)
  val list85 = List("dad", "mom", "goog")         //> list85  : List[String] = List(dad, mom, goog)
  val list86 = List("search", "nan")              //> list86  : List[String] = List(search, nan)
  
  anySatisfied(list80, isOdd _)                   //> res68: Boolean = false
  anySatisfied(list81, isOdd _)                   //> res69: Boolean = true
  anySatisfied(list82, isOdd _)                   //> res70: Boolean = false
  anySatisfied(list83, isOdd _)                   //> res71: Boolean = true
  anySatisfied(list84, isPalindrome _)            //> res72: Boolean = false
  anySatisfied(list85, isPalindrome _)            //> res73: Boolean = true
  anySatisfied(list86, isPalindrome _)            //> res74: Boolean = true
  
  //(2) recursive
  def anySatisfiedRecur[T](aList: List[T], predicate: T => Boolean): Boolean =
  {
  	if(aList == Nil) false
  	else predicate(aList.head) || anySatisfiedRecur(aList.tail, predicate)
  	//the following way is tail recursive already
  	//else if(predicate(aList.head))true
  	//else anySatisfiedRecur(aList.tail, predicate)
  }                                               //> anySatisfiedRecur: [T](aList: List[T], predicate: T => Boolean)Boolean
  
  anySatisfiedRecur(list80, isOdd _)              //> res75: Boolean = false
  anySatisfiedRecur(list81, isOdd _)              //> res76: Boolean = true
  anySatisfiedRecur(list82, isOdd _)              //> res77: Boolean = false
  anySatisfiedRecur(list83, isOdd _)              //> res78: Boolean = true
  anySatisfiedRecur(list84, isPalindrome _)       //> res79: Boolean = false
  anySatisfiedRecur(list85, isPalindrome _)       //> res80: Boolean = true
  anySatisfiedRecur(list86, isPalindrome _)       //> res81: Boolean = true
  
  //(3)tail recursive
  def anySatisfiedTail[T](aList: List[T], predicate: T => Boolean)=
  {
  	def helper(result: Boolean, unseen: List[T]): Boolean =
  	{
  		if(unseen == Nil) result
  		else helper(result || predicate(unseen.head), unseen.tail)
  	}
  	helper(false, aList)
  }                                               //> anySatisfiedTail: [T](aList: List[T], predicate: T => Boolean)Boolean
  
  anySatisfiedRecur(list80, isOdd _)              //> res82: Boolean = false
  anySatisfiedRecur(list81, isOdd _)              //> res83: Boolean = true
  anySatisfiedRecur(list82, isOdd _)              //> res84: Boolean = false
  anySatisfiedRecur(list83, isOdd _)              //> res85: Boolean = true
  anySatisfiedRecur(list84, isPalindrome _)       //> res86: Boolean = false
  anySatisfiedRecur(list85, isPalindrome _)       //> res87: Boolean = true
  anySatisfiedRecur(list86, isPalindrome _)       //> res88: Boolean = true
  
  //map filter reduce
  def anySatisfiedMapFilterReduce[T](aList: List[T], predicate: T => Boolean)=
  {
  	aList.filter(predicate).size != 0
  }                                               //> anySatisfiedMapFilterReduce: [T](aList: List[T], predicate: T => Boolean)B
                                                  //| oolean
  
  anySatisfiedMapFilterReduce(list80, isOdd _)    //> res89: Boolean = false
  anySatisfiedMapFilterReduce(list81, isOdd _)    //> res90: Boolean = true
  anySatisfiedMapFilterReduce(list82, isOdd _)    //> res91: Boolean = false
  anySatisfiedMapFilterReduce(list83, isOdd _)    //> res92: Boolean = true
  anySatisfiedMapFilterReduce(list84, isPalindrome _)
                                                  //> res93: Boolean = false
  anySatisfiedMapFilterReduce(list85, isPalindrome _)
                                                  //> res94: Boolean = true
  anySatisfiedMapFilterReduce(list86, isPalindrome _)
                                                  //> res95: Boolean = true
                                                  
  //problem 10
  
  def isAscending(aList: List[Int]) =
  {
  	def helper(result: Boolean, unseen: List[Int]): Boolean =
  	{
  		if(unseen.size < 2) result
  		else helper(result && (unseen.head <= unseen.tail.head), unseen.tail)
  	}
  	helper(true, aList)
  }                                               //> isAscending: (aList: List[Int])Boolean
  val list101 = Nil                               //> list101  : scala.collection.immutable.Nil.type = List()
  val list102 = List(1)                           //> list102  : List[Int] = List(1)
 	val list103 = List(2, 1)                  //> list103  : List[Int] = List(2, 1)
	val list104 = List(1, 1, 3)               //> list104  : List[Int] = List(1, 1, 3)
	val list105 = List(4, 1, 2, 3)            //> list105  : List[Int] = List(4, 1, 2, 3)
	val list106 = List(-5, -3, -4, 0, 6)      //> list106  : List[Int] = List(-5, -3, -4, 0, 6)
	
	isAscending(list101)                      //> res96: Boolean = true
	isAscending(list102)                      //> res97: Boolean = true
	isAscending(list103)                      //> res98: Boolean = false
	isAscending(list104)                      //> res99: Boolean = true
	isAscending(list105)                      //> res100: Boolean = false
	isAscending(list106)                      //> res101: Boolean = false
	
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
  def allOnes: Stream[Int] = 1 #:: allOnes        //> allOnes: => Stream[Int]
  val stream1 = allOnes                           //> stream1  : Stream[Int] = Stream(1, ?)
  stream1.head                                    //> res102: Int = 1
  stream1.tail.head                               //> res103: Int = 1
  stream1.tail.tail.head                          //> res104: Int = 1
  stream1                                         //> res105: Stream[Int] = Stream(1, 1, 1, ?)
  
  //The stream of all non-negative integers
  def allNonNegatives(n: Int): Stream[Int] = n #:: allNonNegatives(n + 1)
                                                  //> allNonNegatives: (n: Int)Stream[Int]
  val stream2 = allNonNegatives(0)                //> stream2  : Stream[Int] = Stream(0, ?)
  stream2.head                                    //> res106: Int = 0
  stream2.tail.head                               //> res107: Int = 1
  stream2.tail.tail.head                          //> res108: Int = 2
  stream2                                         //> res109: Stream[Int] = Stream(0, 1, 2, ?)
   
  //The stream of all non-negative even integers
  def allNonNegativeEvens(n: Int): Stream[Int] = n #:: allNonNegativeEvens(n + 2)
                                                  //> allNonNegativeEvens: (n: Int)Stream[Int]
  val stream3 = allNonNegativeEvens(0)            //> stream3  : Stream[Int] = Stream(0, ?)
  stream3(5)                                      //> res110: Int = 10
  stream3                                         //> res111: Stream[Int] = Stream(0, 2, 4, 6, 8, 10, ?)
  
  //The stream of all squares of integers
  def allSquares(n: Int): Stream[Int] = (n * n) #:: allSquares(n + 1)
                                                  //> allSquares: (n: Int)Stream[Int]
  
  val stream4 = allSquares(0)                     //> stream4  : Stream[Int] = Stream(0, ?)
  stream4(4)                                      //> res112: Int = 16
  stream4                                         //> res113: Stream[Int] = Stream(0, 1, 4, 9, 16, ?)
  
  //List Processing II
  //problem 1
  var cs152 = List(List(93.0, 89.0, 90.0), List(75.0, 76.0, 68.0), List(88.0, 82.0, 78.0))
                                                  //> cs152  : List[List[Double]] = List(List(93.0, 89.0, 90.0), List(75.0, 76.0
                                                  //| , 68.0), List(88.0, 82.0, 78.0))
  var cs151 = List(List(90.0, 85.0, 83.0), List(69.0, 67.0, 55.0), List(69.0, 70.0, 71.0))
                                                  //> cs151  : List[List[Double]] = List(List(90.0, 85.0, 83.0), List(69.0, 67.0
                                                  //| , 55.0), List(69.0, 70.0, 71.0))
  def avg(scores: List[Double]): Double = //avg of scores
  	if(scores == Nil) 0 else scores.reduce(_ + _) / scores.size
                                                  //> avg: (scores: List[Double])Double

	def avgAvg(scores: List[List[Double]]): List[Double] =
   	//list of averages for each student
  	scores.map(avg _)                         //> avgAvg: (scores: List[List[Double]])List[Double]
  	
	avgAvg(cs152)                             //> res114: List[Double] = List(90.66666666666667, 73.0, 82.66666666666667)
	avgAvg(cs151)                             //> res115: List[Double] = List(86.0, 63.666666666666664, 70.0)
	
	def passing(scores: List[List[Double]]): List[Int] =
   //list of positions in the list with avg >= 70
   	//a list of Double
  {
   	var list1 = List[Int]() //List[Int](), otherwise, error
   	//append element to a list :+ elem
  	for(i <- 0 until avgAvg(scores).size if avgAvg(scores)(i) >= 70) {list1 = list1:+ i}
  	list1
  }                                               //> passing: (scores: List[List[Double]])List[Int]
	passing(cs152)                            //> res116: List[Int] = List(0, 1, 2)
	passing(cs151)                            //> res117: List[Int] = List(0, 2)
	
	/*
	def passing1(scores: List[List[Double]]): List[Int] =
	{
		avgAvg(scores).map((x: Double) => if(x >= 70)avgAvg(scores).indexOf(x) else -1).filter((y: Int) => y != -1)
	}
	
	passing1(cs152)
	passing1(cs151)
	*/
	
	def sum(aList: List[Double]) = if(aList == Nil) 0 else aList.reduce(_ + _)
                                                  //> sum: (aList: List[Double])Double
	def sumSums(scores: List[List[Double]]):Double = //sum of sums of all scores
		if(scores == Nil) 0 else scores.map(sum _).reduce(_ + _)
                                                  //> sumSums: (scores: List[List[Double]])Double
	
	sumSums(cs152)                            //> res118: Double = 739.0
	sumSums(cs151)                            //> res119: Double = 659.0
	
	//problem 2
	def spellCheck0(doc: List[String], dictionary: List[String]): List[String] =
	{
		//tail recursion
		def helper(result: List[String], unseen: List[String]): List[String] =
			if(unseen == Nil) result
			else helper(if(dictionary.contains(unseen.head)) result else result :+ unseen.head, unseen.tail)
		helper(List[String](), doc)
	}                                         //> spellCheck0: (doc: List[String], dictionary: List[String])List[String]
	
	spellCheck0(List("scala", "java", "c"), List("c", "assembly"))
                                                  //> res120: List[String] = List(scala, java)
  spellCheck0(Nil, List("sjsu", "sjcc"))          //> res121: List[String] = List()
  spellCheck0(Nil, Nil)                           //> res122: List[String] = List()
  spellCheck0(List("scala", "java"), Nil)         //> res123: List[String] = List(scala, java)
  
  //problem 3
  //3. A document is a list of words. A dictionary is a list of words. Implement:
	def spellCheck(doc: List[String], dictionary: List[String]): List[String] =
	//all words in doc not in dictionary
		doc.filter((x: String) => !dictionary.contains(x))
                                                  //> spellCheck: (doc: List[String], dictionary: List[String])List[String]
	
	spellCheck(List("scala", "java", "c"), List("c", "assembly"))
                                                  //> res124: List[String] = List(scala, java)
  spellCheck(Nil, List("sjsu", "sjcc"))           //> res125: List[String] = List()
  spellCheck(Nil, Nil)                            //> res126: List[String] = List()
  spellCheck(List("scala", "java"), Nil)          //> res127: List[String] = List(scala, java)
  
  //problem 4
  //4. A polynomial can be represented as a list of monomials. A monomial is a pair of the form (coefficient, exponent). For example, 3x2 – 5 is:
	//List((3.0, 2.0), (-5.0, 0.0))
	//Implement:
	def evalMono(mono: (Double, Double), x: Double): Double =
		//result of substituting x in mono, only a pair
		mono._1 * pow(x, mono._2)         //> evalMono: (mono: (Double, Double), x: Double)Double
	def evalPoly(poly: List[(Double, Double)], x: Double): Double =
		//resut of substituting x in poly
		if(poly == Nil) 0 else poly.map(evalMono(_, x)).reduce(_ + _)
                                                  //> evalPoly: (poly: List[(Double, Double)], x: Double)Double
	
	val poly0 = List((3.0, 2.0),(-5.0, 0.0))  //> poly0  : List[(Double, Double)] = List((3.0,2.0), (-5.0,0.0))
	evalMono(poly0(0), 2)                     //> res128: Double = 12.0
	evalMono(poly0(1), 2)                     //> res129: Double = -5.0
	evalPoly(poly0, 2)                        //> res130: Double = 7.0
}