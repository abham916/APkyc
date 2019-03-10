/* Author: Young Chan Kim
 * Date: 2019.03.08.
 * Goal: Print *****
				****
				 ***
				  **
				   *
 */
 
fun main(){
	for(i in 1..5){
		for(z in 1..i-1)
			print(" ")
		for(j in i..5)
			print("*")
		println()
	}
}