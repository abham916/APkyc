/* Author: Young Chan Kim
 * Date: 2019.03.15.
 * Goal: 
	1) Add 5 new superheroes to "Superheroes" ArrayList
	2) List all of them  
 */
 
 fun main(){
	val superheroes = arrayListOf("Superman", "Spider man", "Wonder woman", "Thor", "Black Panther", "Batman", "Cat", "Invisible Woman", "Iron man", "Hulk", "Aquaman")
	
	superheroes.add("Ant man")
	superheroes.add("Captain America")
	superheroes.add("Wolverine")
	superheroes.add("Doctor Strange")
	superheroes.add("Hawkeye")
	
	println("List of Superheroes")
	println("------------------")
	for(i in superheroes) println(i)	
}