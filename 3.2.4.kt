/* Author: Young Chan Kim
 * Date: 2019.03.15.
 * Goal: 
	1) List all of superhero with his/her name, power, and gender
	2) List all of 'male' superhero
	3) List all of superhero who has the power more than 90
 */
 
 fun main(){
	val names = arrayListOf("Superman", "Spider man", "Wonder woman", "Thor", "Black Panther", "Batman", "Cat", "Invisible Woman", "Iron man", "Hulk", "Aquaman")
	val powers = arrayListOf("100", "85", "90", "95", "80", "92", "75", "92", "97", "85", "75")
	val genders = arrayListOf("M", "M", "F", "M", "M", "M", "F", "F", "M", "M", "M")
	val mapHero = HashMap<String,List<String>>()
	val size: Int
	
	// Make HashMap "mapHero"
	
	size = names.size-1
	for(i in 0..size) mapHero.put(names[i], listOf(powers[i], genders[i]))
	
	
	// List all of superhero with his/her name, power, and gender
	
	println("Superhero [Power Gender]")
	println("------------------------")
	for(key in mapHero.keys) println("$key ${mapHero[key]}")
	println()
	
	
	// List all of 'male' superhero
	
	println("Male Heroes")
	println("-----------")
	for(key in mapHero.keys){
		val gender = (mapHero[key] as List)[1]
		if(gender == "M") println(key)
	}
	println()
	
	
	// List all of superhero who has the power more than 90
	
	println("Strong Heroes (Power > 90)")
	println("--------------------------")
	for(key in mapHero.keys){
		val power = (mapHero[key] as List)[0].toInt()
		if(power > 90) println(key)
	}
}