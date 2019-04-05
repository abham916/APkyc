/* Author: Young Chan Kim
 * Date: 2019.03.29.
 * Goal: Practice kotlin interface
 */

interface Grade{
	fun total(): Int
    fun ave(): Int
}

class CS(val java: Int, val python: Int, val web: Int): Grade{
	val arr = arrayOf(java, python, web)
	
	override fun total(): Int {
		var sum: Int
			
		sum = 0
		for(i in arr)
			sum += i
		
		return sum
	}
    override fun ave(): Int {
		var sum: Int
			
		sum = 0
		for(i in arr)
			sum += i
		
		return sum/arr.size
	}
	
	fun max(): Int{
		var max: Int
		
		max = arr[0]
		for(i in arr){
			if(i > max) max = i
		}
		return max
	}
}

class EE(val listening: Int, val writing: Int, val reading: Int): Grade{
	val arr = arrayOf(listening, writing, reading)
    
    override fun total(): Int {
		var sum: Int
			
		sum = 0
		for(i in arr)
			sum += i
		
		return sum
	}
    override fun ave(): Int {
		var sum: Int
			
		sum = 0
		for(i in arr)
			sum += i
		
		return sum/arr.size
	}
    
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
	
	println(cs.total())
	println(ee.ave())
}