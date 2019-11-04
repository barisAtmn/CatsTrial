package com.baris

import cats.Functor
import cats.implicits._

/***
  Functor as the ability to work with a single effect
  */
object FunctorsTrial extends App{

  val listOption = List(Some(1), None, Some(2))

  // Same
  Functor[List].compose[Option].map(listOption)(_ + 1).foreach(println)
  listOption.map(_.map(_ +1))

  val list = List(3,5)

  // Same
  Functor[List].map(list)(_ + 1).foreach(println)
  list.map(_ + 1).foreach(println)


}
