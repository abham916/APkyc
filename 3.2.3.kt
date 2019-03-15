/* Author: Young Chan Kim
 * Date: 2019.03.15.
 * Goal: 
	1) Show the detail of Batman: Name?, Power?, Gender?
	2) Show the superhero who has the power, '100'  
 */
 
 fun main(){
	val names = arrayListOf("Superman", "Spider man", "Wonder woman", "Thor", "Black Panther", "Batman", "Cat", "Invisible Woman", "Iron man", "Hulk", "Aquaman")
	val powers = arrayListOf("100", "85", "90", "95", "80", "92", "75", "92", "97", "85", "75")
	val genders = arrayListOf("M", "M", "F", "M", "M", "M", "F", "F", "M", "M", "M")
	val mapHero = HashMap<String,List<String>>()
    var choose: String
	val size: Int
	
	size = names.size-1
	for(i in 0..size) mapHero.put(names[i], listOf(powers[i], genders[i]))
	
	choose = "Batman"
	println("Name\t[Power, Gender]")
	println("-----------------------")
	println("$choose\t${mapHero[choose]}")
	
	choose = "100"
    for(key in mapHero.keys){
		val power = (mapHero[key] as List)[0]
		if(power == choose) println("\nSuperhero who has power $choose is $key")
	}
 }
	