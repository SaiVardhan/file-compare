package com.filematcher.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.filematcher.datatypes.PersonName;

public class MatchTwoFile {
	public static void main(String[] args) throws FileNotFoundException {
		MatchTwoFile fileMatcher=new MatchTwoFile();
		
		String firstFileName="File1.txt";
		String secFileName="File2.txt";
		List<PersonName> firstFileList=fileMatcher.loadFile(firstFileName);
		List<PersonName> secndFileList=fileMatcher.loadFile(secFileName);
		
		List<PersonName> matchStrings=new ArrayList<PersonName>();
		System.out.println("size of first file :"+firstFileList.size()+"\nName in first File :"+firstFileList);
		System.out.println("size of Second file :"+secndFileList.size()+"\nName in first File :"+secndFileList);
		for(PersonName personToBeMatched:firstFileList){
			if(secndFileList.contains(personToBeMatched)){
				matchStrings.add(personToBeMatched);
			}
		}
		System.out.println("\n\nResult Size :"+matchStrings.size()+"\nResult element :"+matchStrings);
	}
	
	private List<PersonName> loadFile(String fileToBeLoaded) throws FileNotFoundException{
		Scanner reader = null;
		List<PersonName> fileStrList = new ArrayList<PersonName>();
		try{
			reader = new Scanner(new File(fileToBeLoaded));
			while(reader.hasNext()){
				String personName = reader.nextLine().toLowerCase().trim();
				fileStrList.add(new PersonName(personName));
			}
		}finally{
			reader.close();
		}		
		return fileStrList;
	}
}
