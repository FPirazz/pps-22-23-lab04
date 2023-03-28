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
  private var revealedCells: Int = 0
  private var _minesPos: List[(Int, Int)] = Stream.toList(
    Stream.take(
      Stream.iterate((random.nextInt(size), random.nextInt(size)))((_, _) => (random.nextInt(size), random.nextInt(size)))
    )(mines)
  )
  def hit(x: Int, y: Int): java.util.Optional[Integer] = (x, y) match
    case (_, _) if List.contains(_minesPos, (x, y)) => OptionToOptional(None()) // Option => Optional converter
    case _ => var count: Int = 0;
              for
                i <- x-1 to x+1
                j <- y-1 to y+1
              do if List.contains(_minesPos, (i, j)) then  count = count + 1
              revealedCells = revealedCells + 1
              if revealedCells == (size * size) - mines then won = true
              OptionToOptional(Some(count))

  var won = false
