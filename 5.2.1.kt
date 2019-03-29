/* Author: Young Chan Kim
 * Date: 2019.03.29.
 * Goal: Practice kotlin super class
 */
​
open class Grade{
	fun total(vararg score: Int): Int{
		var sum: Int
			
		sum = 0
		for(i in score){
			sum += i
		}
		return sum
	}
    
    fun ave(vararg score: Int): Int{
		var sum = 0
		
		for(i in score){
			sum += i
		}
		return sum/score.size
	}   
}
​
class CS: Grade(){
	val java: Int = 95
	val python: Int = 90 
	val web: Int = 80

	fun max(vararg score: Int): Int{
		var max: Int
		
		max = score[0]
		for(i in score){
			if(i > max) max = i
		}
		return max
	}
}

class EE: Grade(){
	val listening: Int = 50
	val writing: Int = 60 
	val reading: Int = 80
	fun min(vararg score: Int): Int{
		var min: Int
		
		min = score[0]
		for(i in score){
			if(i < min) min = i
		}
		return min
	}
}

fun main(){
	val cs = CS()
	val ee = EE()
	
	println(cs.max(cs.java, cs.python, cs.web))

}