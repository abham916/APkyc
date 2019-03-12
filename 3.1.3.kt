/* Author: Young Chan Kim
 * Date: 2019.03.08.
 * Goal: Make multiplication table using loop
 */
 
fun main(){
	for(i in 2..9){
		for(j in 1..9)
			println("$i * $j = ${i*j}")
		println("\n-----------\n")
	}
}