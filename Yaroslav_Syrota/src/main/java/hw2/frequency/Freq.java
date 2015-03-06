package hw2.frequency;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.io.*;
import java.util.*;

/**
 * Created by Yaroslav_Syrota on 20.01.2015.
 */

/*
Написать класс для вычисления частоты слов в тексте с методами:
 - String setTextFromConsole() - добавляет текст с консоли в строку и возвращает строку
 - String setTextFromFile(String fileName) - добавляет текст из указанного поимени файла в строку и возвращает строку
 - String generateRandomText(int textLength) - генерирует случайный текст по указанной длинне
 - Set<String> getWordsByFrequency(int frequency) - возвращает множество слов, которые встречаются указанное количество раз
 - Set<String> getWordsByFrequencyLessThan(int frequency) - множество, которое встречается реже
 - Set<String> getWordsByFrequencyMoreThan(int frequency) - множество, которое встречается чаще
 - void printAcs() - вывести все слова + частота по возрастанию частоты
 - void printDesc() - вывести все слова + частота по убыванию частоты

Класс задания hw2.frequency.Freq
 */

public class Freq {
	  private HashMap<String, Integer> wordMap;

public Freq() {
		wordMap = new HashMap<String, Integer>();
		}

// добавляет текст с консоли в строку и возвращает строку
public String setTextFromConsole() {
		Scanner scan = new Scanner(System.in);
		return scan.next();
		}

// добавляет текст из указанного по имени файла в строку
// и возвращает строку
public String setTextFromFile(String fileName) throws FileNotFoundException {
		String textToReturn = new String();
		FileReader fr = new FileReader(fileName);
		Scanner scanFile = new Scanner(fr);
		while (scanFile.hasNext()) {
		textToReturn += scanFile.next();
		}
		scanFile.close();
		return textToReturn;
		}

// генерирует случайный текст по указанной длине
public String generateRandomText(int textLength) {
		String textToReturn = new String();
		String textSample = "generally the day after policy moves" +
		"from the ecb or the fed you have a little bit of " +
		"a pullback said head of global " +
		"equities at first new york securities after a euphoric " +
		"move up normally there is a little bit of a hangover " +
		"the next day the market extended its declines into the " +
		"close some traders said friday that investors were " +
		"wary of making or staying in bets that stocks will go " +
		"higher ahead of greece elections on sunday which could " +
		"again spark fears about political instability in " +
		"the eurozone ";
		for (int i = 0; i < textLength / textSample.length(); i++) {
		textToReturn += textSample;
		}
		textToReturn += textSample.substring(0, textLength % textSample.length());
		return textToReturn;
		}

public void fillWordMap(String inputString) {
		wordMap = new HashMap<String, Integer>();
		Reader read = new StringReader(inputString);
		Scanner scan = new Scanner(read);
		while (scan.hasNext()) {
		String currentItem = scan.next();
		if (wordMap.containsKey(currentItem)) {
		wordMap.replace(currentItem, wordMap.get(currentItem) + 1);
		} else {
		wordMap.put(currentItem, 1);
		}
		}
		}

// возвращает множество слов, которые встречаются
// указанное количество раз
public Set<String> getWordsByFrequency(int frequency) {
		Set<String> setToReturn = new HashSet<String>();
		Iterator<Map.Entry<String, Integer>> iterator = wordMap.entrySet().iterator();
		while (iterator.hasNext()) {
		Map.Entry<String, Integer> currentEntry = iterator.next();
		if (currentEntry.getValue().equals(frequency)) {
		setToReturn.add(currentEntry.getKey());
		}
		}
		return setToReturn;
		}

// возвращает множество, которое встречается реже
public Set<String> getWordsByFrequencyLessThan(int frequency) {
		Set<String> setToReturn = new HashSet<String>();
		Iterator<Map.Entry<String, Integer>> iterator = wordMap.entrySet().iterator();
		while (iterator.hasNext()) {
		Map.Entry<String, Integer> currentEntry = iterator.next();
		if (currentEntry.getValue().compareTo(frequency) < 0) {
		setToReturn.add(currentEntry.getKey());
		}
		}
		return setToReturn;
		}

// возвращает множество, которое встречается чаще
public Set<String> getWordsByFrequencyMoreThan(int frequency) {
		Set<String> setToReturn = new HashSet<String>();
		Iterator<Map.Entry<String, Integer>> iterator = wordMap.entrySet().iterator();
		while (iterator.hasNext()) {
		Map.Entry<String, Integer> currentEntry = iterator.next();
		if (currentEntry.getValue().compareTo(frequency) > 0) {
		setToReturn.add(currentEntry.getKey());
		}
		}
		return setToReturn;
		}

		// вывести все слова + частота по возрастанию частоты
		void printAcs() {
		Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
@Override
public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
		return o1.getValue().compareTo(o2.getValue());
		}
		};
		ArrayList<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordMap.entrySet());
//        Iterator<Map.Entry<String, Integer>> iterator = wordMap.entrySet().iterator();
//        while (iterator.hasNext()) {
//            sortedWords.add(iterator.next());
//        }
		Collections.sort(sortedWords, comparator);
		System.out.println(sortedWords);
		}

		// вывести все слова + частота по убыванию частоты
		void printDesc() {
		Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
@Override
public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
		return - o1.getValue().compareTo(o2.getValue());
		}
		};
		ArrayList<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordMap.entrySet());
//        Iterator<Map.Entry<String, Integer>> iterator = wordMap.entrySet().iterator();
//        while (iterator.hasNext()) {
//            sortedWords.add(iterator.next());
//        }
		Collections.sort(sortedWords, comparator);
		System.out.println(sortedWords);
		}

public HashMap<String, Integer> getWordMap() {
		return wordMap;
		}
public void setWordMap(HashMap<String, Integer> wordMap) {
		this.wordMap = wordMap;
		}

		}
