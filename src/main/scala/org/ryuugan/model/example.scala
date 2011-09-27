package org.ryuugan

import ru.circumflex._, orm._
import java.util.Date

class Example extends Record[Long, Example] {
  def PRIMARY_KEY = id
  def relation = Example

  val id = "id".BIGINT.NOT_NULL
  val login = "login".TEXT.NOT_NULL
  val registeredAt = "registered_at".TIMESTAMP.NOT_NULL(new Date)
  val queuedAt = "queued_at".TIMESTAMP.NOT_NULL.DEFAULT("current_timestamp")
}

object Example extends Example with Table[Long, Example]
