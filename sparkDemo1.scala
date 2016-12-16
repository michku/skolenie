import sys.process._
val r = sc.textFile("/user/adastra/tcpdump")
val src = r.map( x => x.split(",")(2) )
val dest = r.map( x => x.split(",")(0) )
val ipAddresses = src.union( dest ).distinct
val ip2host = ipAddresses.map( y=> (y, "host "+y ) ).filter( x=>  x._2.! == 0 ).map( x=>(x._1, x._2 .!!) ).map( x=> (x._1, x._2.toString.replace("\n","").split(" ").last ))
ip2host.collect
...
