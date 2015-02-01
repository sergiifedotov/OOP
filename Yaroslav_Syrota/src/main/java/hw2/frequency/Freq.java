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
	private String wordsSet = "";


	public String setTextFromConsole() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String temp = reader.readLine();
		wordsSet += temp;
		return temp;
	}

	public String setTextFromFile(String fileName) {
		String temp = "";
		try {
			FileInputStream fis = new FileInputStream(fileName);
			do {
				fis.read();
				temp += fis.toString();
			} while(fis.read()!='\n');
			/*
			while(fis.available()>0) {
				temp += fis.read();
			}
			*/
			fis.close();
		} catch(FileNotFoundException e) {
			System.out.println("can not open the file");

		} catch (IOException e) {
			System.out.println(e);
		}
		wordsSet += temp;
		return temp;
	}

	public String generateRandomText(int textLength) {
		String temp = "";
		Set<String> set = revertSet(wordsSet);
		for(int i=0; i<textLength; i++) {
			Iterator<String> iterator = set.iterator();
			temp += iterator.next();
		}
		return temp;
	}

	public Set<String> getWordsByFrequency(int frequency) {
		HashMap<String, Integer> map = revertMap(wordsSet);
		Set<String> set = new HashSet<String>();
		Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> pair = iterator.next();
			if(pair.getValue() == frequency) set.add(pair.getKey());
		}
		return set;
	}

	public Set<String> getWordsByFrequencyLessThan(int frequency) {
		HashMap<String, Integer> map = revertMap(wordsSet);
		Set<String> set = new HashSet<String>();
		Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> pair = iterator.next();
			if(pair.getValue() < frequency) set.add(pair.getKey());
		}
		return set;
	}

	public Set<String> getWordsByFrequencyMoreThan(int frequency) {
		HashMap<String, Integer> map = revertMap(wordsSet);
		Set<String> set = new HashSet<String>();
		Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> pair = iterator.next();
			if(pair.getValue() > frequency) set.add(pair.getKey());
		}
		return set;
	}

	public void printAcs() {
		HashMap<String, Integer> map = revertMap(wordsSet);
		int[] ind = new int[map.size()];
		String[] val = new String[map.size()];
		Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
		int o = 0;
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> pair = iterator.next();
			ind[o] = pair.getValue();
			val[o] = pair.getKey();
			o++;
		}
		quicksort(ind, val, 0, ind.length-1);
		for(int i=0; i<ind.length; i++) {
			System.out.println(val[i]);
		}
	}

	public void printDesc() {
		HashMap<String, Integer> map = revertMap(wordsSet);
		int[] ind = new int[map.size()];
		String[] val = new String[map.size()];
		Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
		int o = 0;
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> pair = iterator.next();
			ind[o] = pair.getValue();
			val[o] = pair.getKey();
			o++;
		}
		quicksort(ind, val, 0, ind.length-1);
		for(int i=val.length-1; i>=0; i--) {
			System.out.println(val[i]);
		}
	}

	public Set<String> revertSet(String s) {
		Set<String> set = new HashSet<String>();
		String temp = "";
		char[] l = s.toCharArray();
		for(char i : l) {
			if(i!=' ' && i!=',' && i!='.') temp += i;
			else {
				set.add(temp);
				temp = "";
			}
		}
		return set;
	}

	public HashMap<String, Integer> revertMap(String s) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String temp = "";
		char[] l = s.toCharArray();
		for(char i : l) {
			if(i!=' ' && i!=',' && i!='.') temp += i;
			else {
				if(map.containsKey(temp)) {
					int t = map.get(temp);
					map.put(temp, t++);
					temp="";
				} else {
					map.put(temp, 1);
					temp = "";
				}

			}
		}
		return map;
	}



	private int partition(int[] array, String[] words, int start, int end)
	{
		int marker = start;
		for ( int i = start; i <= end; i++ )
		{
			if ( array[i] <= array[end] )
			{
				int temp = array[marker];
				String t = words[marker];// swap
				array[marker] = array[i];
				words[marker] = words[i];
				array[i] = temp;
				words[i] = t;
				marker += 1;
			}
		}
		return marker - 1;
	}

	private void quicksort(int[] array, String[] words, int start, int end)
	{
		if ( start >= end )
		{
			return;
		}
		int pivot = partition (array, words, start, end);
		quicksort (array, words, start, pivot-1);
		quicksort (array, words, pivot+1, end);
	}



}
