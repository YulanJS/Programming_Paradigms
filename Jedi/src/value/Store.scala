package value

import collection.mutable._
import context._

class Store(private var elems: ArrayBuffer[Value] = ArrayBuffer[Value]()) extends Value {

  // adds e to the end of store
  def add(e: Value) { elems += e }

  // inserts e at position pos in this
  def put(e: Value, pos: Integer) {
    if (pos.value < 0 || pos.value > elems.length - 1) throw new IndexOutOfBoundsException(pos.toString)
    elems.insert(pos.value, e)
  }

  // removes element at position pos from this
  def rem(pos: Integer) {
    if (pos.value < 0 || pos.value > elems.length - 1) throw new IndexOutOfBoundsException(pos.toString)
    elems.remove(pos.value)
  }

  // returns element at position pos in this
  def get(pos: Integer): Value = elems(pos.value)

  // returns true ie this contains e
  def contains(e: Value): Boole = Boole(elems.contains(e))

  // returns the size of this
  def size: Integer = Integer(elems.length)

  // returns "{e0 e1 e2 ...}"
  override def toString = {
    var s = ""
    for (i <- 0 to elems.length - 1) {
      s = s.concat(elems(i).toString)
      s = s.concat(" ")
    }
    "{" + s + "}"
  }

  // returns store containing the elements of this transformed by trans
  def map(trans: Closure): Store = {
    var s = new Store
    var tempEnv = new Environment()
    for (e <- elems) {
      s.add(trans(List(e), tempEnv))
    }
    s
  }

  // returns store containing the elements of this that passed test
  def filter(test: Closure): Store = {
    var s = new Store
    var tempEnv = new Environment()
    def f(x: Value) = test(List(x), tempEnv)
    for (e <- elems) {
      if (f(e) == Boole(true)) s.add(e)
    }
    s
  }

}