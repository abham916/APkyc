/* Author: Young Chan Kim
 * Date: 2019.03.29.
 * Goal: Practice kotlin super class
 */

open class Grade(){
	var score: Int = 0
 
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

class CS(val java: Int, val python: Int, val web: Int): Grade(){
	val arr = arrayOf(java, python, web)
	
	fun max(): Int{
		var max: Int
		
		max = arr[0]
		for(i in arr){
			if(i > max) max = i
		}
		return max
	}
}

class EE(val listening: Int, val writing: Int, val reading: Int): Grade(){
	
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
	var cs = CS(10, 20, 30)
	var ee = EE(10, 20, 30)
	
	println(cs.max())
	println(ee.total(ee.listening, ee.writing, ee.reading))

}