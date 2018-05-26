package datumize.cctest;

import java.io.File;
import java.util.List;

import datumize.cctest.pojo.InputObject;
import datumize.cctest.pojo.OutputObject;
import datumize.cctest.service.FileService;
import datumize.cctest.service.TransformationService;

public class App 
{

	public static void main( String[] args )
    {
    	File inputFile = FileService.getFileByName("InputFile.csv"); 
    	List<InputObject> inputList = FileService.readFileByName(inputFile); 
    	List<OutputObject> outputList = TransformationService.transformFunction(inputList);
    	List<OutputObject>[] splitedList = TransformationService.splitByZone(outputList);
    	
    	for(int i=0; i<splitedList.length; i++){
    		FileService.saveFileByName(splitedList[i].get(0).getZone() + ".csv", splitedList[i]);
    	}
        
    }
}
