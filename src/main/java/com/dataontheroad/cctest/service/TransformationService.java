package dataontheroad.cctest.service;

import java.util.ArrayList;
import java.util.List;

import datumize.cctest.pojo.InputObject;
import datumize.cctest.pojo.OutputObject;

public interface TransformationService {
	
	public static List<OutputObject> transformFunction(List<InputObject> inputList);
	
	private static void updateIncomes(OutputObject outputObject, Integer incomes);

	private static OutputObject isNewClientOnZone(InputObject auxInput, List<OutputObject> outputList);

	public static List<OutputObject>[] splitByZone(List<OutputObject> outputList);
	
}
