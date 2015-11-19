package es.weso.main

import org.rogach.scallop._
import org.rogach.scallop.exceptions._
import es.weso.shacl._

object Main extends App {
  
    override def main(args: Array[String]): Unit = {
    
    val opts = new MainOpts(args, errorDriver)

    if (args.length == 0) {
      opts.printHelp()
      return
    }
    
    opts.processor() match {
      case "SHACL" => {
        val (results,time) = ShaclValidator.validate(opts.data(), opts.schema())
        println("Result: " + ShaclValidator.result2Str(results))
        if (opts.time()) {
         println("Elapsed time: " + time + " ns")
        }
      }
    }
  
    
    
   }
    
    
   private def errorDriver(e: Throwable, scallop: Scallop) = e match {
    case Help(s) =>
      println("Help: " + s)
      scallop.printHelp
      sys.exit(0)
    case _ =>
      println("Error: %s".format(e.getMessage))
      scallop.printHelp
      sys.exit(1)
  }

}
    
