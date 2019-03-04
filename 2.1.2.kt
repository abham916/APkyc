/* Author: Young Chan Kim
 * Date: 2019.03.05.
 * Goal: Find bigger number(2 number)
 */
 
import java.util.Scanner

fun main(){
    var x: Int
	var y: Int
    val sc = Scanner(System.`in`)
    
	print("Input two integer: ")
	x = sc.nextInt();
	y = sc.nextInt();
	if(x > y) println(x)
	else println(y)
}