package datumize.cctest.service;

import java.util.ArrayList;
import java.util.List;

import datumize.cctest.pojo.InputObject;
import datumize.cctest.pojo.OutputObject;

public class TransformationService {

	public static List<OutputObject> transformFunction(List<InputObject> inputList) {
		List<OutputObject> outputList = new ArrayList<OutputObject>();

		for (InputObject auxInput : inputList) {
			OutputObject outputObject = isNewClientOnZone(auxInput, outputList);
			if (outputObject == null) {
				outputList.add(new OutputObject(auxInput.getZone(), auxInput.getIncomes(), auxInput.getClient()));
			} else {
				updateIncomes(outputObject, auxInput.getIncomes());
			}
		}
		return outputList;
	}

	// Updates the outputObject value for incomes with the second parameter one
	private static void updateIncomes(OutputObject outputObject, Integer incomes) {

		outputObject.setIncomes(outputObject.getIncomes() + incomes);
	}

	// Checks if there is an output object on the list that has the same zone and
	// client of the auxInput
	private static OutputObject isNewClientOnZone(InputObject auxInput, List<OutputObject> outputList) {

		for (OutputObject auxOutput : outputList) {
			if (auxInput.getClient().equals(auxOutput.getCliente()) && auxInput.getZone().equals(auxOutput.getZone()))
				return auxOutput;
		}
		return null;
	}

	// Generates a different list of output objects according to the zone
	public static List<OutputObject>[] splitByZone(List<OutputObject> outputList) {

		@SuppressWarnings("unchecked")
		List<OutputObject>[] splitList = new ArrayList[Zone.values().length];

		for (int i = 0; i < splitList.length; i++) {
			splitList[i] = new ArrayList<OutputObject>();
		}
		if (!outputList.isEmpty()) {
			for (OutputObject auxOutput : outputList) {

				switch (Zone.getZone(auxOutput.getZone())) {

				case GRYFFINDOR:
					splitList[Zone.GRYFFINDOR.ordinal()].add(auxOutput);
					break;
				case HUFFLEPUFF:
					splitList[Zone.HUFFLEPUFF.ordinal()].add(auxOutput);
					break;
				case RAVENCLAW:
					splitList[Zone.RAVENCLAW.ordinal()].add(auxOutput);
					break;
				case SLYTHERIN:
					splitList[Zone.SLYTHERIN.ordinal()].add(auxOutput);
					break;
				default:
					break;
				}
			}
		}
		return splitList;
	}

}
