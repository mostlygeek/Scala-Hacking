package chap32Actors

import scala.actors._

object NameResolver extends Actor {
    import java.net.{ InetAddress, UnknownHostException }
    def act() {
        loop { // react exists, so we need this loop
            react { // demo of using react vs recieve
                case (name: String, actor: Actor) =>
                    actor ! ('resolved, name, getIp(name))
                case ('resolved, name: String, Some(ip: InetAddress)) =>
                    println("Resolved: %s = %s".format(name, ip.getHostAddress()))
                case "EXIT" => exit()
                case ('resolved, name: String, None) =>
                    println("Could not resolve: " + name)
                case msg =>
                    println("Unhandled message: " + msg)
            }

        }
    }

    def getIp(name: String): Option[InetAddress] = {
        try {
            Some(InetAddress.getByName(name))
        } catch {
            case _: UnknownHostException => None
        }
    }
}
object NameResolverApp extends App {
    NameResolver.start()
    val ls = List("www.scala-lang.org",
        "nofs.fs", "news.ycombinator.com",
        "google.ca", "engadget.com")

    /*
     * loop through, and when done tell it to 
     * send the message back to itself... 
     */
    for (host <- ls)
        NameResolver ! (host, NameResolver)
}