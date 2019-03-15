/* Author: Young Chan Kim
 * Date: 2019.03.15.
 * Goal: 
	1) List all of superhero.
	2) Show my favorite hero.  
 */
 
 fun main(){
	val superheroes = arrayOf("Superman", "Spider man", "Wonder woman", "Thor", "Black Panther", "Batman", "Cat", "Invisible Woman", "Iron man", "Hulk", "Aquaman")
	
	println("List of Superheroes")
	println("------------------")
	for(i in superheroes) println(i)
	println("------------------")
	println("My favorite: ${ superheroes[1] }")
}