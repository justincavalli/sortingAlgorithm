An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once. For example, “mango” and “ogman” are anagrams. 

Given an array of strings Strings, group the words that are anagrams to each other. You can return the answer in any order. 

For example, 

Input: strings = ["bucket","rat","mango","tango","ogtan","tar"]

Output: [["bucket"],["rat","tar"],["mango"],["tango","ogtan"]]

For this assignment complete the following tasks:

* Implement a function List<List<String>> groupAnagram(List<String> strings) that takes a list of strings and returns a list of lists of strings. 10
* In order to group the anagrams, you would need to sort all the given strings by the characters i.e. the ASCII code of the characters. After sorting the strings that converge to the same string, they are grouped together in the same anagram bucket. For example, after sorting both mango and ogman becomes agmno, therefore they are in the same bucket. Implement a function String sortString(String str) that sorts a string. You can’t use sorting API for this. Please use one of the following sorting algorithms - 10
    * Mergesort
    * Quicksort
    * Heapsort
    * Radix sort
