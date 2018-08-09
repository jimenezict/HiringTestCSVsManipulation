package datumize.cctest;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import datumize.cctest.pojo.InputObject;
import datumize.cctest.pojo.OutputObject;
import datumize.cctest.service.FileService;
import datumize.cctest.service.TransformationService;
import datumize.cctest.service.Zone;

public class App {

	final static Logger logger = Logger.getLogger(FileService.class);

	public static void main(String[] args) {
		File inputFile;
		try {
			inputFile = FileService.getFileByName("InputFile.csv");
			List<InputObject> inputList = FileService.readFileByName(inputFile);
			List<OutputObject> outputList = TransformationService.transformFunction(inputList);
			List<OutputObject>[] splitedList = TransformationService.splitByZone(outputList);

			for (int i = 0; i < splitedList.length; i++) {
				String fileName = Zone.getZone(i).getName() + ".csv";
				if (splitedList[i].isEmpty()) {
					logger.warn(fileName + " is empty.");
				} else {
					FileService.saveFileByName(fileName, splitedList[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
