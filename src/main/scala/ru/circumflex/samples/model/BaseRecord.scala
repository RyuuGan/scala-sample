package ru.circumflex.samples

import ru.circumflex._, orm._
import java.lang.IllegalStateException

abstract class BaseRecord[R <: BaseRecord[R]]
    extends Record[Long, R]
    with IdentityGenerator[Long, R] { this: R =>

  def PRIMARY_KEY = id

  val id = "id".BIGINT.NOT_NULL.AUTO_INCREMENT
}

trait BaseTable[R <: BaseRecord[R]]
    extends BaseRecord[R]
    with Table[Long, R] { this: R =>

  def fetch(id: String): R = fetchOption(id).getOrElse(throw new IllegalStateException("No record with such id: " + id))

  def fetchOption(id: String): Option[R] = try {
    get(id.trim.toLong)
  } catch {
    case e: NumberFormatException => None
  }

}