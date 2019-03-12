/* Author: Young Chan Kim
 * Date: 2019.03.08.
 * Goal: Print *****
				****
				 **
				  *
 */
 
fun main(){
	var space = 1
	
	for(i in 1..5){
		if(i == 3) continue
		for(z in 1..space-1)
			print(" ")
		for(j in i..5)
			print("*")
		println()
		space++
	}
}