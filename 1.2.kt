/* Author: Young Chan Kim
 * Date: 2019.03.01.
 */
 
fun main() {
    
    var x = "I Love Coding."
    
	var a = 5
    var b = 2
	var result: Int
    
	var eng = 90
    var his = 80
    var mus = 80
    var total: Int
    var ave: Int
	
	println("1.")
    println(x)
	
	println("----------------------------")
	
	println("2.")
    result = a*b
	println("$a x $b = $result")
	
	println("----------------------------")
	
	println("3.")
	println("English $eng")
    println("History $his")
    println("Music $mus")
    println()
    total = sum(eng, his, mus)
    ave = av(total)
    println("Total: $total")
    println("Ave: $ave")  
}

fun sum(a:Int, b:Int, c:Int): Int{
    return a+b+c
}

fun av(x:Int): Int{
    return x/3
}