package es.weso.main

import org.scalameter.api._
import org.scalameter.Measurer._
import org.scalameter.picklers.Implicits._

object RangeBenchmark extends Bench.LocalTime {

  /* configuration */

  override lazy val executor = LocalExecutor(
    new Executor.Warmer.Default,
    Aggregator.average,
    new Measurer.Default)
//  override lazy val reporter = new LoggingReporter
  override lazy val persistor = Persistor.None

  /* inputs */
  
  val sizes = Gen.range("size")(300000, 1500000, 300000)

  val ranges = for {
    size <- sizes
  } yield 0 until size

  /* tests */

  performance of "Range" in {
    measure method "map" config (
      exec.benchRuns -> 2
    ) in {
      using(ranges) in {
        r => r.map(_ + 1)
      }
    }
  }
}