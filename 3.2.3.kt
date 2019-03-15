/* Author: Young Chan Kim
 * Date: 2019.03.15.
 * Goal: 
	1) Show the detail of Batman: Name?, Power?, Gender?
	2) Show the superhero who has the power, '100'  
 */
 
fun main(){
	val name = arrayListOf("Superman", "Spider man", "Wonder woman", "Thor", "Black Panther", "Batman", "Cat", "Invisible Woman", "Iron man", "Hulk", "Aquaman")
	val power = arrayListOf(100, 85, 90, 95, 80, 92, 75, 92, 97, 85, 75)
	val gender = arrayListOf("M", "M", "F", "M", "M", "M", "F", "F", "M", "M", "M")
	val Hero = ArrayList<HashMap<String, Any>>()
	var choose: Any
	val size: Int
	
	// Make ArrayList of HashMap
	
	size = name.size-1
	for(i in 0..size) Hero.add(hashMapOf("name" to name[i], "power" to power[i], "gender" to gender[i]))
	
	
	// Show the detail of Batman
	
	choose = "Batman"
	println("${"Name".padEnd(8)} ${"Power".padEnd(6)} ${"Gender".padEnd(6)}")
	println("----------------------")
	for(h in Hero){
		if(h.containsValue(choose)){
			print("${h.get("name").toString().padEnd(8)}") 
			print(" ${h.get("power").toString().padEnd(6)}")
			println(" ${h.get("gender").toString().padEnd(6)}")
		}
	}
	println()
	
	
	// Show the superhero with power 100
	
	choose = 100
	for(h in Hero)
		if(h.containsValue(choose)) println("Superhero who has power $choose is ${h.get("name")}")
}
