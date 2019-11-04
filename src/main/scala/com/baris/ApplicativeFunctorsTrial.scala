package com.baris

import cats._
import cats.implicits._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
When we were mapping functions over functors, we usually mapped functions that take only one parameter.
But what happens when we map a function like *, which takes two parameters, over a functor?
  */
/**
Cartesian defines product function, which produces a pair of (A, B) wrapped in effect F[_] out of F[A] and F[B].
The symbolic alias for product is |@| also known as the applicative style.
{Cartesian} captures the idea of composing independent effectful values.
@typeclass trait Cartesian[F[_]] {
  def product[A, B](fa: F[A], fb: F[B]): F[(A, B)]
}
  */
object ApplicativeFunctorsTrial extends App{

  // Functor style
  val hs = Functor[List].map(List(1, 2, 3, 4)) ({(_: Int) * (_:Int)}.curried)

  hs.foreach(println)

  Functor[List].map(hs) {_(9)}.foreach(println)

  Applicative[Option].map2(Some(2), Some(3))(_ + _).foreach(println)

  Applicative[Future].compose[Option].map2(Future.successful(Some(5)), Future.successful(Some('a')))(_ + _)
    .onComplete{
      case Success(data)  => println(data)
      case Failure(exception)  => println(exception)
    }

  (3.some, 5.some) mapN { _ - _ } foreach(println)

}

