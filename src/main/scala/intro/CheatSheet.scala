package intro

/*
This source file compiles with scalac:

> scalac CheatSheet.scala

The purpose of this document is to demonstrate various constructs in the Scala
programming language. Commentary is associated with declarations throughout.

The following is an object declaration. The term "object" is ambiguous in
general discourse. The Scala keyword "object" is used to describe the
declaration below. This document will call this an "object declaration", which
is to be distinguished from any other usage of the term "object."

Object declarations follow the object keyword with a name. That name is, by
convention, made of alpha characters with the first in upper-case and the
remainder in lower-case.

Inside the open and close braces of an object declaration are a collection of
values. This includes, var, val and def declarations. Less frequently, you will
encounter type-aliases (with the type keyword) and declarations that may also
appear at the top-level (trait, class, object).

Object declarations in Scala are similar to static method declarations in
languages such as Java or C#. They are not invoked on a specific instance (as in
a class or trait declaration). Unlike Java or C#, these static functions are
declared separately to a class or trait; that is, static functions belong in
an object declaration, while instance values and methods appear in the class or
trait.
*/
object CheatSheet {
//// var keyword, variable
  /*
  The var keyword defines a variable that may be updated by other code that
  references it. The var keyword is followed by a colon (:), which is
  pronounced, "is of the type" and following the colon is the type of the var.
  So we might say, a "var age is of the type Int." Following the name and type
  declaration is a value using the equals sign (=) followed by the value.

  In functional programming, we generally avoid the use of the var keyword,
  however, some use-cases might demand it for performance reasons. Other value
  declarations such as val and def are generally preferred.
  */
  var age: Int = 100

//// def keyword, method
  /*
  The def keyword declares a method. It may (not necessarily) be followed by one
  or more argument declarations. In this case, one argument is defined, "newAge
  is of the type Int" and the parameter list is followed by a colon (:) and a
  return type declaration.

  Return type declarations are not always necessary in Scala because the
  language may infer the return type automatically. However, it is good practice
  to explicitly specify method return types.

  In this case, the return type is Unit. This is similar to void in languages
  like Java and C#. This is because we are performing a *side-effect* in the
  method. The side-effect is the updating of the variable x declared earlier.

  It must be emphasised that this type of programming — declaring and updating
  variables is generally avoided in functional programming. The variable
  declaration (age) and updating method (newAge) are included for completeness
  and to demonstrate the essence of what it means to NOT be functional
  programming.
  */
  def updateAge(newAge: Int): Unit =
    age = newAge
}

//// top-level declaration
/*
Scala has a limited number of permitted top-level declarations. That is,
declarations that appear on the outside and not within any other declaration.
Top-level declarations may also appear within other declarations, but not all
declarations may appear at top-level.
*/

//// object declaration
/*
Object declarations may appear at top-level. They use the object keyword,
followed by its name, then enclosing braces. Within the braces are further
declarations. Objects define 'static' declarations, which are not associated
with an instance. They are invoked with the object name followed by the
declaration name.
*/
object AnObject {}

//// object declaration, main method
/*
To have a runnable Scala program, a method named 'main' must appear in a
top-level object declaration and with a specific signature.
*/
object AnObjectWithMain {
//// main method
  /*
  Note the absence of a = sign in the declaration. This means the function
  returns the type 'Unit'. We may choose to specify this explicitly, however,
  in the absence of a = sign, this is inferred.
  */
  def main(args: Array[String]) {
    println("hi")
  }
}

/*
Class declarations may appear at top-level. They use the class keyword, followed
by its name, then optional constructor parameters, then enclosing braces. Within
the braces are further declarations. Classes define instance declarations, which
are associated with an instance of that class. They are invoked with the
instance name followed by the declaration name.

Declarations in a class must be concrete. That is, they must not be abstract.
*/
class AClass(params: Int) {}

//// trait declaration
/*
Trait declarations may appear at top-level. They use the trait keyword, followed
by its name, then enclosing braces. Within the braces are further declarations.
Traits define instance declarations, which are associated with an instance of
that trait. They are invoked with the instance name followed by the declaration
name.

Declarations in a trait may be concrete or abstract.
*/
trait ATrait {}

//// case class declaration
/*
Case class declarations may appear at top-level. They use the case and class
keywords, followed by its name, then optional constructor parameters, then
enclosing braces. Within the braces are further declarations. Classes define
instance declarations, which are associated with an instance of that class. They
are invoked with the instance name followed by the declaration name.

Case classes include a default 'equals', 'hashCode' and 'toString' method for
instances. They may also be used in pattern-matching.

Declarations in a class must be concrete. That is, they must not be abstract.
*/
case class ACaseClass(params: Int) {}

//// extends keyword, with keyword
/*
Classes extend zero or one other class and zero or more traits. In this example,
the 'Sub' class extends the 'Super1' class and mixes in the 'Super2' trait.
*/
class Super1 {}
trait Super2 {}
class Sub extends Super1 with Super2 {}


//// sealed keyword, sealed trait declaration, algebraic data type
/*
Traits may be declared using the sealed keyword. This means that all subtypes of
that trait appear in the same source file. Attempting to subtype a sealed trait
outside of the source file results in a compile-time error.

Sealed traits are used often to define Algebraic Data Types (ADTs).
*/
sealed trait SealedTrait {}

//// type-parameter
/*
Scala declares type-parameters, similarly to Java. In Scala, they appear in
[square brackets] where in Java, they appear in <angle brackets>. Java uses the
term "generics" to describe type-parameters.
*/

//// class type-parameter
/*
This class defines a single type-parameter which may be used inside the body of
that class. We say 'the class is parameterised by A'. The position of the
type-parameter is important to how it is used. That is, type-parameters
appearing on a class have a scope over that class. Type-parameters defined
elsewhere have different scopes.
*/
class AClassWithTypeParameter[A] {}

//// method type-parameter
/*
This class defines a method that is parameterised with the name 'X'. This
type-parameter has scope within the method body.
*/
class AClassWithATypeParameterAndParameterisedMethod[T] {
  def method[X] {}
}

//// higher-kinded type-parameter
/*
This class defines a type parameter that accepts another type-parameter. This
means only certain values will work for that type-parameter. For example, 'Int'
will not work because it does not accept one more type-parameter. Similarly,
'Map' will not work because it accepts two type-parameters. Values that accept
one type-parameter are List, Set and Option. This is because they accept one
type-parameter.

The method in the class is parameterised on a type-parameter that accepts two
type-parameters. This means values such as Map and Function1 will work, but not
List, Option or Int.

This notion of parameterising on values that accept type-parameters is called
'higher-kinded polymorphism.' We describe these values as 'type constructors.'
So we might say that "F is a unary type constructor" because it is a
parameterised value that accepts one more type-parameter.
*/
class AClassWithHigherKind[F[_]] {
  def method[G[_, _]] {}
}

//// method declaration
/*
Methods are defined in objects, traits, classes or even inside methods. They use
the def keyword.
*/
class Methods {
  /*
  This method accepts one parameter of the type 'Int' and returns a value of the
  type 'String'. Concrete methods, specifed by the = sign, return a value inside
  the following method body.
  */
  def method1(x: Int): String = {
    "abc"
  }

//// implicit method argument
  /*
  Methods may accept implicit parameters. These are parameters that are
  optionally passed at the call site. The value of the parameter that is passed
  is resolved at compile-time. The compiler will inspect the program scope for a
  value of the correct type, in this case, List[Int] and use that value. If
  there is no value in scope, or there are two or more values in scope, the
  compiler will fail with a message.
  */
  def method2(x: Int)(implicit q: List[Int]): Long = {
    5L
  }

//// by-name method arguments
  /*
  Methods may pass parameters 'by-name.' This means that the value is not
  evaluated at run-time until needed. This is sometimes loosely called
  'lazy evaluation.' By-name evaluation often affects program termination
  results and program performance.
  */
  def method3(x: => Int): String = {
    "def"
  }
}

//// syntax
/*
Scala provides a wide variety of syntax. Following are a few of those.
*/
object Syntax {
//// if/else expression
  /*
  Producing a value, based on some Boolean value, is done using if/else syntax.
  These two keywords emulate the C/Java ternary operator. The type of the
  expression is the least common supertype of each of the branches.
  */
  val x: Int = if(true) 7 else 8

//// if expressions
  /*
  Producing an effect, based on some Boolean value, is done using if syntax.
  This keyword alone is anti-thetical to functional programming, since it
  deviates from producing a value; instead, it produces an effect. The type of
  the expression is 'Unit.'
  */
  val y = if(true) println("true")

//// for-comprehension
  /*
  For-comprehensions are done with the for/yield keywords and <- syntax. They
  expand to method calls on an instance. In this case, the for-comprehension
  expands to:

  Some(7).flatMap(a =>
  Some(8).map(b =>
  a + b))

  For-comprehensions are also called monad-comprehensions. They are similar to
  LINQ comprehensions in C# or do-notation in Haskell.
  */
  val f: Option[Int] =
    for {
      a <- Some(7)
      b <- Some(8)
    } yield a + b

//// pattern-matching, algebraic data type
  /*
  Pattern-matching is done with the match/case keywords. Pattern-matching is
  performed on special types of declaration called an algebraic data type.
  Algebraic Data Types are typically defined by a sealed trait, then one or more
  case class subtypes of that trait. These subtypes are sometimes called
  'data constructors' or just 'constructors' for that type.


  Option is an algebraic data type with two constructors called Some and None.
  Pattern-matching a value of the type Option is used to switch on which
  constructor was used to create that Option value.

  Algebraic data types are sometimes called 'sums' or 'sum types.' This is
  because they correspond to addition in algebra.
  */
  def m(option: Option[Int]): Int =
    option match {
      case Some(n) => 7
      case None => 8
    }

//// tuple
  /*
  Scala provides syntax for tuples (sometimes called products because they
  correspond to multiplication in algebra). A tuple is 0 or more values and they
  can be of various types. This case defines a tuple of 2 values of the types
  Int and String.
  */
  val t: (Int, String) = (7, "abc")
}

object TypeAlias {
//// type alias
  /*
  Scala defines type-aliases using the type keyword. In this case, X is aliased
  to List[Char]. This means that wherever the type 'X' appears, the compiler
  may treat it as a List[Char]. This is demonstrated in the method, where the
  value of the type X is pattern-matched (List has two data constructors) and a
  Char is returned.
  */
  type X = List[Char]

  def method(x: X): Char =
    x match {
      case Nil => 'x'
      case h :: _ => h
    }
}

//// function literal
object FunctionLiterals {
//// function as method argument
  /*
  Scala treats functions as first-class. In this case, the method accepts a
  value that is a function. That function must accept an Int and return a
  String to pass the compiler. The method body then uses that function by
  applying it to a value.

  Function parameters and values use => syntax.
  */
  def method(k: Int => String): String =
    k(9)

//// function literal
  /*
  This method calls a method that accepts a function argument. The function
  argument is created by an expression that names the argument (n), followed by
  => syntax, then the value to return from that function; in this case, a
  String.
  */
  def callmethod: String =
    method((n: Int) => (n + 100).toString.reverse)
}
