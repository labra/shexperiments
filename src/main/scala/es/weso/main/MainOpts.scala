package es.weso.main

import org.rogach.scallop._
import org.rogach.scallop.exceptions._
import es.weso.shacl._

class MainOpts(
  arguments: Array[String],
  onError: (Throwable, Scallop) => Nothing) extends ScallopConf(arguments) {

  banner("""| ShExperiments
            | Options:
            |""".stripMargin)

  footer("Enjoy!")


  val data = opt[String]("data",
    short = 'd',
    required = true,
    descr = "Data to validate")

/*  val dataFormat = opt[String]("data-format",
    noshort = true,
    required = false,
    default = Some("TURTLE"),
    descr = "Data to validate") */
    
  val schema = opt[String]("schema",
    short = 'x',
    required = true,
    descr = "Schema")
    
  val processor = opt[String]("processor",
    short = 'p',
    default = Some(Processors.default),
    required = true,
    descr = "Processor. Possible processors: " + Processors.toString,
    validate = (x => Processors.available(x))
  )
    

/*  val schemaFormat = opt[String]("schema-format",
    noshort = true,
    required = false,
    default = Some("TURTLE"),
    descr = "Data to validate") */
    
  val time = toggle("time",
    prefix = "no-",
    default = Some(false),
    descrYes = "show time",
    descrNo = "don't show time",
    short = 't')
    
  override protected def onError(e: Throwable) = onError(e, builder)

}
