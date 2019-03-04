/* Author: Young Chan Kim
 * Date: 2019.03.05.
 * Goal: Convert cm to m
 */
 
import java.util.Scanner

fun main(){
    var cm: Int
    var m: Int
    val sc = Scanner(System.`in`)
    
    print("Input cm: ")
    cm = sc.nextInt()
    m = cm / 100
    cm = cm % 100
    println("$m"+"m $cm"+"cm")
}