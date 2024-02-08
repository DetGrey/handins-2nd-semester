package com.example.kotlin_intro

fun main() {
    // Exercise 1
    eligibleToVote();

    // Exercise 2
    val max : Int = getMax(1,18,-8);
    println(max); //18

    val min : Int = getMin(1,18,-8);
    println(min); //-8
    println()

    // Exercise 3
    val average = calculateAverage(listOf(1, 2, 3, 4, 5))
    println(average)
    println()

    // Exercise 4
    val validCPRNumber = validCPR()
    println("Validity: $validCPRNumber")
    println()

    // Exercise 5
    oneToHundred()

    // Exercise 6
    abbreviations()

    // Exercise 7
    val grade = calculateGrade()
    println(grade)
    println()

    // Exercise 8
    val stringList: List<String> = listOf("Hello", "world", "hi", "something", "none")
    println(filterWordsByLength(stringList, 5))
    println()

    // Exercise 9 Advanced (Optional)
    val validISBNNumber = validISBN()
    println("ISBN validity: $validISBNNumber")

}
/*
1. A person is elligible to vote if his/her age is greater than or equal to 18.
Define a method to find out if he/she is elligible to vote. Let the user input their age.
Get inspiration in the terminal output below:
    Please enter your age
    6
    You are not eligible to vote
 */

fun eligibleToVote() {
    println("Exercise 1")
    println("Please enter your age")
    val age = readln().toInt()
    if (age < 18) {
        println("You are not eligible to vote")
    }
    else {
        println("You are eligible to vote")
    }
    println();
}

/*
2. Define two functions to print the maximum and the minimum number respectively among three numbers
    val max : Int = getMax(1,18,8);

    val min : Int = getMin(1,18,-8);

    println(max); //18
    println(min); //-8
 */

fun getMax(a: Int, b: Int, c: Int): Int {
    println("Exercise 2.1 Get Max")
    val result = if (a > b) {
        if (a > c) a
        else c
    }
    else {
        if (b > c) b
        else c
    }
    return result
}
fun getMin(a: Int, b: Int, c: Int): Int {
    println("Exercise 2.2 Get Min")
    val result = if (a < b) {
        if (a < c) a
        else c
    }
    else {
        if (b < c) b
        else c
    }
    return result
}

/*
3. Write a Kotlin function named calculateAverage that takes in a list of numbers and returns their average.
 */

fun calculateAverage(list: List<Int>): Double {
    println("Exercise 3 Calculate Average")
    var sum: Double = 0.0
    for (num in list) {
        sum += num
    }
    return sum / list.size
}

/*
4. Write a method that returns if a user has input a valid CPR number.
A valid CPR number has:
    10 Digits.
    The first 2 digits are not above 31.
    The middle 2 digits are not above 12.
The method returns true if the CPR number is valid, false if it is not.
 */

fun validCPR(): Boolean {
    println("Exercise 4 Valid CPR?")
    println("Please enter a CPR number")
    val number: String = readln()
    var firstTwo: Boolean = false
    var middleTwo: Boolean = false
    if ("\\d{10}".toRegex().matches(number)) {
        firstTwo = number.slice(0 until 2).toInt() <= 31
        middleTwo = number.slice(2 until 4).toInt() <= 12
    }
    return (number.length == 10 && firstTwo && middleTwo)
}

/*
5. Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz”
instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of
both three and five print “FizzBuzz”.
 */

fun oneToHundred() {
    println("Exercise 5 One to Hundred")
    for (i in 1..100) {
        if (i % 3 == 0 && i % 5 == 0) {
            println("FizzBuzz")
        }
        else if (i % 3 == 0) {
            println("Fizz")
        }
        else if (i % 5 == 0) {
            println("Buzz")
        }
        else {
            println(i)
        }
    }
    println()
}

/*
6. Write a program that takes your full name as input and displays the abbreviations of the first
and middle names except the last name which is displayed as it is.
For example, if your name is Robert Brett Roser, then the output should be R.B. Roser.
Or Benjamin Dalsgaard Hughes will be B.D. Hughes
 */

fun abbreviations() {
    println("Exercise 6 Abbreviations")
    println("Please enter your name")
    val names: List<String> = readln().split(" ")
    val abbreviatedNames: MutableList<String> = mutableListOf()
    for (i in names.indices) {
        val name: String = if (i == names.size - 1) {
                names[i]
            } else {
                names[i].slice(0 until 1) + "."
            }
        abbreviatedNames.add(name)
    }
    val abbreviatedName = abbreviatedNames.joinToString(" ")
    println(abbreviatedName)
    println()
}

/*
7. Write a program that takes a numerical grade (0-100) as input and prints out the corresponding
american letter grade. Implement a function calculateGrade that takes an integer parameter
representing the grade and returns a string representing the letter grade according to
the following scale:
    90-100: "A"
    80-89: "B"
    70-79: "C"
    60-69: "D"
    Below 60: "F"
 */

fun calculateGrade(): String {
    println("Exercise 7 Calculate letter grade from numerical grade")
    println("Enter numerical grade between 0 and 100:")
    val grade: Int = readln().toInt()

    val letterGrade: String = when {
        grade > 100 -> "Grade not possible"
        grade in 90..100 -> "A"
        grade in 80..89 -> "B"
        grade in 70..79 -> "C"
        grade in 60..69 -> "D"
        else -> "F"
    }
    return letterGrade
}

/*
8. Write a Kotlin function named filterWordsByLength that takes in a list of strings and a
minimum length, and returns a list containing only the words that have a length greater than
or equal to the specified minimum length.
Use filter function and lambda expressions
*/

fun filterWordsByLength(list: List<String>, minLength: Int): List<String> {
    println("Exercise 8 Filter Words by Length")
    return list.filter { it.length >= minLength }
}

/* Advanced (Optional)
ISBN validation
The ISBN-10 format is 9 digits (0 to 9) plus one check character (either a digit or an X only).
In the case the check character is an X, this represents the value '10'. These may be communicated
with or without hyphens, and can be checked for their validity by the following formula:
(x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) mod 11 == 0
If the result is 0, then it is a valid ISBN-10, otherwise it is invalid.

Example
Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula, and get:
(3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 * 1) mod 11 == 0

Given a string the program should check if the provided string is a valid ISBN-10. Putting this into
place requires some thinking about preprocessing/parsing of the string prior to calculating the check
digit for the ISBN.
The program should be able to verify ISBN-10 both with and without separating dashes.
 */

fun validISBN(): Boolean {
    println("Exercise 9 Advanced (Optional) ISBN validation")
    println("Please enter ISBN-10 number:")
    val number = readln().replace("-", "").replace(" ", "").lowercase()

    return if ("x" in number) {
        (number[0].digitToInt() * 10 + number[1].digitToInt() * 9 + number[2].digitToInt() * 8 + number[3].digitToInt() * 7 + number[4].digitToInt() * 6 + number[5].digitToInt() * 5 + number[6].digitToInt() * 4 + number[7].digitToInt() * 3 + number[8].digitToInt() * 2 + 10 * 1).mod(11) == 0
    }
    else {
        (number[0].digitToInt() * 10 + number[1].digitToInt() * 9 + number[2].digitToInt() * 8 + number[3].digitToInt() * 7 + number[4].digitToInt() * 6 + number[5].digitToInt() * 5 + number[6].digitToInt() * 4 + number[7].digitToInt() * 3 + number[8].digitToInt() * 2 + number[9].digitToInt() * 1).mod(11) == 0
    }
}
