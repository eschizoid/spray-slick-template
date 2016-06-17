package com.timmeh.openhr.openholidays.model

import slick.driver.H2Driver.api._

// This file demonstrates how to map more than 22 columns to a nested case class using a custom mapping
class LargeTableExample2(tag: Tag)
  extends Table[LargeTableRow](tag, "LARGE_TABLE") {
  def idToD = (id, a, b, c, d)
  def id = column[Int]("ID", O.PrimaryKey)
  def a = column[String]("A")
  def b = column[String]("B")
  def c = column[String]("C")
  def d = column[String]("D")

  def eToI = (e, f, g, h, i)
  def e = column[String]("E")
  def f = column[String]("F")
  def g = column[String]("G")
  def h = column[String]("H")
  def i = column[String]("I")

  def jToN = (j, k, l, m, n)
  def j = column[String]("J")
  def k = column[String]("K")
  def l = column[String]("L")
  def m = column[String]("M")
  def n = column[String]("N")

  def oToS = (o, p, q, r, s)
  def o = column[String]("O")
  def p = column[String]("P")
  def q = column[String]("Q")
  def r = column[String]("R")
  def s = column[String]("S")

  def tToX = (t, u, v, w, x)
  def t = column[String]("T")
  def u = column[String]("U")
  def v = column[String]("V")
  def w = column[String]("W")
  def x = column[String]("X")

  def yToZ = (y, z)
  def y = column[String]("Y")
  def z = column[String]("Z")

  def * = (idToD, eToI, jToN, oToS, tToX, yToZ).shaped <> (
//      Map from tuple to case class
      {case (idToD, eToI, jToN, oToS, tToX, yToZ) => LargeTableRow(idToD, eToI, jToN, oToS, tToX, yToZ)},
//      Map from case class to tuple
      (lt: LargeTableRow) => Some(lt.idToD, lt.eToI, lt.jToN, lt.oToS, lt.tToX, lt.yToZ)
    )
}
