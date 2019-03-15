/* Author: Young Chan Kim
 * Date: 2019.03.15.
 * Goal: 
	1) List all of superhero with his/her name, power, and gender
	2) List all of 'male' superhero
	3) List all of superhero who has the power more than 90
 */
 
fun main(){
	val name = arrayListOf("Superman", "Spider man", "Wonder woman", "Thor", "Black Panther", "Batman", "Cat", "Invisible Woman", "Iron man", "Hulk", "Aquaman")
	val power = arrayListOf(100, 85, 90, 95, 80, 92, 75, 92, 97, 85, 75)
	val gender = arrayListOf("M", "M", "F", "M", "M", "M", "F", "F", "M", "M", "M")
	val Hero = ArrayList<HashMap<String, Any>>()
	val size: Int
	
	// Make ArrayList of HashMap
	
	size = name.size-1
	for(i in 0..size) Hero.add(hashMapOf("name" to name[i], "power" to power[i], "gender" to gender[i]))
	
	
	// List all of superhero with his/her name, power, and gender
	
	println("${"Name".padEnd(18)} ${"Power".padEnd(6)} ${"Gender".padEnd(6)}")
	println("--------------------------------")
	for(h in Hero){
		val n = h.get("name").toString()
		val p = h.get("power").toString()
		val g = h.get("gender").toString()
		println("${n.padEnd(18)} ${p.padEnd(6)} ${g.padEnd(6)}")
	}
	println("\n")
	
	
	// List all of 'male' superhero
	
	println("Male Heroes")
	println("-----------")
	for(h in Hero)
		if(h.get("gender") == "M") println(h.get("name"))
	println("\n")
	
	
	// List all of superhero who has the power more than 90
	
	println("Strong Heroes (Power > 90)")
	println("--------------------------")
	for(h in Hero){
		val p = h.get("power")
		if(p as Int > 90) println(h.get("name"))
	}
}