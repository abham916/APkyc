/* Author: Young Chan Kim
 * Date: 2019.03.05.
 * Goal: Find bigger number(3 number)
 */
 
import java.util.Scanner

fun main(){
    var a: Int
	var b: Int
	var c: Int
    val sc = Scanner(System.`in`)
    
	print("Input three integer: ")
	a = sc.nextInt();
	b = sc.nextInt();
	c = sc.nextInt();
	if(a > b){
		if(a > c) println(a)
		else println(c)
	}
	else{
		if(b > c) println(b)
		else println(c)
	}
}