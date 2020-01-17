

object Foo extends App {
  class Foo
  class Bar extends Foo
  class Baz extends Bar

  val foo = new Foo
  val bar = new Bar
  val baz = new Baz

  println("foo.isInstanceOf[Foo]: " + (foo.isInstanceOf[Foo]))  // true
  println("bar.isInstanceOf[Foo]: " + (bar.isInstanceOf[Foo]))  // true
  println("baz.isInstanceOf[Foo]: " + (baz.isInstanceOf[Foo]))  // true
}