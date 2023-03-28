package u04lab.polyglot.a01b
import scala.jdk.javaapi.OptionConverters
import u04lab.polyglot.OptionToOptional
import u04lab.code.Option
import u04lab.code.Option.*
import u04lab.code.List.*
import u04lab.code.List
import u04lab.code.Stream.*
import u04lab.code.Stream
import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01b/sol2/ */
class LogicsImpl(private val size: Int, private val mines: Int) extends Logics:
  private val random = Random(42)
  private var _minesPos: List[(Int, Int)] = Stream.toList(
    Stream.take(
      Stream.iterate((random.nextInt(size), random.nextInt(size)))((_, _) => (random.nextInt(size), random.nextInt(size)))
    )(mines)
  )

  def hit(x: Int, y: Int): java.util.Optional[Integer] =
    println(_minesPos)
    OptionToOptional(None()) // Option => Optional converter

  def won = false
