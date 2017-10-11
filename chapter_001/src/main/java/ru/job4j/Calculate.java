package ru.job4j;

/**
* Class Calculate для вычисления арифметических операций
* @author vkovrov
* @version 0.1
* @since 0.1
*/
public class Calculate {

	/**
	* Метод echo
	* @param name Ваше имя
	* @return Конкатенация строки и содержимого переменной name
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}

	/**
	* Метод main точка входа в программу при запуске
	* @param args - массив входных данных 
	*/
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
}