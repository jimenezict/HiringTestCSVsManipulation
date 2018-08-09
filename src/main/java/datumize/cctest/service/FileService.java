package datumize.cctest.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import datumize.cctest.pojo.InputObject;
import datumize.cctest.pojo.OutputObject;

public class FileService {

	private final static int ID = 0;
	private final static int CLIENT = 1;
	private final static int DATE = 2;
	private final static int INCOMES = 3;
	private final static int ZONE = 4;

	final static Logger logger = Logger.getLogger(FileService.class);

	public static File getFileByName(String name) throws Exception {

		File fileIn = null;

		if (name != null) {
			if (FileService.class.getClassLoader().getResource(name) != null) {
				fileIn = new File(FileService.class.getClassLoader().getResource(name).getFile());
			} else {
				logger.error("The file does not exist.");
				throw new Exception();
			}
		}
		return fileIn;
	}

	public static List<InputObject> readFileByName(File source) {

		List<InputObject> response = null;

		try (CSVReader csvR = new CSVReader(new FileReader(source))) {
			response = createInputList(csvR.readAll());
		} catch (IOException ie) {
			logger.error("Error reading the file.");
			ie.printStackTrace();
		}
		return response;
	}

	private static List<InputObject> createInputList(List<String[]> data) {

		List<InputObject> response = new ArrayList<InputObject>();

		for (String[] line : data) {
			try {
				response.add(setData(line));
			} catch (IllegalArgumentException e) {
				logger.warn("Error input data in line " + (data.indexOf(line) + 1) + ", discard line and continue.");
			}
		}
		return response;
	}

	private static InputObject setData(String[] line) throws IllegalArgumentException {

		InputObject iob = new InputObject();

		if (line.length != 5)
			throw new IllegalArgumentException();
		if (!isValidZone(line[ZONE])) {
			logger.warn("Invalid Zone");
			throw new IllegalArgumentException();
		}
		iob.setId(Integer.valueOf(line[ID]));
		iob.setClient(line[CLIENT]);
		iob.setDate(Date.valueOf(line[DATE]));
		iob.setIncomes(Integer.valueOf(line[INCOMES]));
		iob.setZone(line[ZONE]);

		return iob;
	}

	private static boolean isValidZone(String zoneName) {
		return (Zone.getZone(zoneName) != null);
	}

	public static Integer saveFileByName(String name, List<OutputObject> outputObject) {

		try (CSVWriter csvW = new CSVWriter(new FileWriter(name))) {
			List<String[]> allData = new ArrayList<String[]>();
			for (OutputObject out : outputObject) {
				String line[] = { out.getCliente(), out.getIncomes().toString() };
				allData.add(line);
			}
			csvW.writeAll(allData);
		}
		catch (IOException e) {
			logger.error("Error saving the file");
			e.printStackTrace();
		}
		return null;
	}
}
