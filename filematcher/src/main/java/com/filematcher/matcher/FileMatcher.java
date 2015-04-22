package com.filematcher.matcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.filematcher.model.PersonName;

public class FileMatcher {
	public static void main(String[] args) throws Exception {
		FileMatcher fileMatcher=new FileMatcher();
		
		String firstFileName=args[0];
		String secFileName=args[1];
		List<PersonName> firstFileList=fileMatcher.loadFile(firstFileName);
		List<PersonName> secndFileList=fileMatcher.loadFile(secFileName);
		
		List<PersonName> matchStringsList=new ArrayList<PersonName>();
		
		List<String> nameToNameMap=new ArrayList<String>();
		System.out.println("size of first file :"+firstFileList.size()+"\nFirst File :"+firstFileList);
		System.out.println("size of Second file :"+secndFileList.size()+"\nSecond File :"+secndFileList);
		for(PersonName personToBeMatched:firstFileList){
			if(secndFileList.contains(personToBeMatched)){
				matchStringsList.add(personToBeMatched); 
				int indexOfMatchedName=secndFileList.indexOf(personToBeMatched);
				nameToNameMap.add("First Person :"+personToBeMatched+"<-> Second Person :"+secndFileList.get(indexOfMatchedName));
			}
		}
		System.out.println("\n\nResult Size :"+matchStringsList.size()+"\nResult element :"+nameToNameMap);
	}
	
	private List<PersonName> loadFile(String fileToBeLoaded){
		Scanner reader = null;
		List<PersonName> fileStrList = new ArrayList<PersonName>();
		try{
			reader = new Scanner(new File(fileToBeLoaded));
			while(reader.hasNext()){
				String personName = reader.nextLine().trim();
				fileStrList.add(new PersonName(personName));
			}
		} catch (FileNotFoundException e) {
			System.err.println("File ["+fileToBeLoaded+"] does not exist");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
			reader.close();
			}catch(Exception e){
				System.err.println("File Loading Failed");
				e.printStackTrace();
			}
		}		
		return fileStrList;
	}
}
