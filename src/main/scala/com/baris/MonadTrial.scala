package com.baris

import cats.Monad
import cats._
import cats.implicits._
/**
  * Monad extends the Applicative type class with a new function flatten.
  * Flatten takes a value in a nested context (eg. F[F[A]] where F is the context) and “joins” the contexts together so that we have a
  * single context (ie. F[A]).
  */
/**
@typeclass trait Monad[F[_]] extends FlatMap[F] with Applicative[F] {
  ....
}
  */

object MonadTrial extends App{

  Option(Option(1)).flatten.foreach(println)

  type Birds = Int

  case class Pole(left: Birds, right: Birds) {
    def landLeft(n: Birds): Pole = copy(left = left + n)
    def landRight(n: Birds): Pole = copy(right = right + n)
  }

  println(Pole(0, 0).landLeft(2))
  println(Pole(0, 0).landLeft(1).landRight(1).landLeft(2))

  /**
    for comprehension == Monad

    */

  def routine: Option[Pole] =
    for {
      start <- Monad[Option].pure(Pole(0, 0))
      first = start.landLeft(2)
      second = first.landRight(2)
      third = second.landLeft(1)
    } yield third

  println(routine)

  for {
    x <- 3.some
    y <- "!".some
  } yield (x.show + y)

}
