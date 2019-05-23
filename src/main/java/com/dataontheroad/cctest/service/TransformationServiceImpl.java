package dataontheroad.cctest.service;

import java.util.ArrayList;
import java.util.List;

import datumize.cctest.pojo.InputObject;
import datumize.cctest.pojo.OutputObject;

public class TransformationServiceImpl implements TransformationService{

	@Override
	public static List<OutputObject> transformFunction(List<InputObject> inputList){
		List<OutputObject> outputList = new ArrayList<OutputObject>();
		
		for(InputObject auxInput: inputList){
			OutputObject outputObject= isNewClientOnZone(auxInput, outputList);
			if(outputObject == null){
				outputList.add(new OutputObject(auxInput.getZone(),auxInput.getIncomes(),auxInput.getClient()));
			}else{
				updateIncomes(outputObject,auxInput.getIncomes());
			}
		}
		return outputList;
	}

	@Override
	//Updates the outputObject value for incomes with the second parameter one
	private static void updateIncomes(OutputObject outputObject, Integer incomes) {
				
	}

	@Override
	//Checks if there is an output object on the list that has the same zone and client of the auxInput 
	private static OutputObject isNewClientOnZone(InputObject auxInput, List<OutputObject> outputList){
		
		return null;		
	}

	@Override
	//Generates a different list of output objects according to the zone 
	public static List<OutputObject>[] splitByZone(List<OutputObject> outputList) {
		
		return null;
	}
	
}
