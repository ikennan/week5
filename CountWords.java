import acm.program.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

	public class CountWords extends ConsoleProgram {
		public void run() {
			int numberoflines = 0;
			int numberofwords = 0;
			int numberofcharacters = 0;
			BufferedReader rd = openFileReader("Enter file name here:");
			try {
				while (true) {
					String line = rd.readLine();
					if (line == null)
						break;
					numberoflines++;
					numberofcharacters += countWords(line);
					numberofcharacters += line.length();
				}
				rd.close();
			} catch (IOException ex) {
				println("An I/O exception has occurred");
			}
			println("Lines = " + numberoflines);
			println("Words = " + numberofcharacters);
			println("Chars = " + numberofcharacters);
		}

		/**
		 * Asks the user for the name of an input file and returns a BufferedReader
		 * attached to its contents. If the file does not exist, the user is given
		 * another chance to try.
		 */
		private BufferedReader openFileReader(String prompt) {
			BufferedReader rd = null;
			while (rd == null) {
				String name = readLine(prompt);
				try {
					rd = new BufferedReader(new FileReader(name));
				} catch (IOException ex) {
					println("Can't open that file.");
				}
			}
			return rd;
		}

		/**
		 * Counts the words (consecutive strings of letters and/or digits) in the input
		 * line.
		 */
		private int countWords(String line) {
			boolean inWord = false;
			int words = 0;
			for (int i = 0; i < line.length(); i++) {
				char ch = line.charAt(i);
				if (Character.isLetterOrDigit(ch)) {
					inWord = true;
				} else {
					if (inWord)
						words++;
					inWord = false;
				}
			}
			if (inWord)
				words++;
			return words;
		}

	}

// public static void main(String[] args) {

// file text = new File }

/*
 * public void run() { int numberoflines = 0; int numberofwords = 0; int
 * characters = 0; //File fileName = new File("file.txt"); //Reader readFile =
 * null; // FileReader readFile = new FileReader(fileName); //BufferedReader rd
 * = new BufferedReader(readFile); BufferedReader rd =
 * openFileReader("file.txt");
 * 
 * try { while (true) { String line = rd.readLine(); if (line == null) break;
 * numberoflines++; numberofwords += countWords(line); characters +=
 * line.length(); } rd.close(); } catch (IOException ex) {
 * println("An I/O exception has occurred"); } println("Lines = " +
 * numberoflines); println("Words = " + numberofwords); println("Chars = " +
 * characters); }
 * 
 * private BufferedReader openFileReader(String prompt) { BufferedReader rd =
 * null; while (rd == null) { String name = readLine(prompt); try { rd = new
 * BufferedReader(new FileReader(name)); } catch (IOException ex) {
 * println("Can't open that file."); } } return rd; }
 * 
 * private int countWords(String line) { boolean inWord = false; int words = 0;
 * for (int i = 0; i < line.length(); i++) { char ch = line.charAt(i); if
 * (Character.isLetterOrDigit(ch)) { inWord = true; } else { if (inWord)
 * words++; inWord = false; } } if (inWord) words++; return words;
 * 
 * }
 */
