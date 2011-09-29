package ru.circumflex.samples

import ru.circumflex._, orm._
import java.util.Date

class Example extends BaseRecord[Example] {
  def relation = Example

  val login = "login".TEXT.NOT_NULL
  val registeredAt = "registered_at".TIMESTAMP.NOT_NULL(new Date)
  val queuedAt = "queued_at".TIMESTAMP.NOT_NULL.DEFAULT("current_timestamp")
}

object Example extends Example with BaseTable[Example]
