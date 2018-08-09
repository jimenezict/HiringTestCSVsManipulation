package datumize.cctest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import datumize.cctest.pojo.InputObject;
import datumize.cctest.pojo.OutputObject;
import datumize.cctest.service.FileService;
import datumize.cctest.service.TransformationService;
import datumize.cctest.service.Zone;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test(expected = Exception.class)
	public void getFileByNameNoExistsTest() throws Exception {
		FileService.getFileByName("Amparo");
	}

	@Test
	public void getFileByExistsTest() throws Exception {
		File fileIn = FileService.getFileByName("InputFile.csv");
		assertNotNull(fileIn);
	}

	@Test
	public void getFileByNameNullTest() throws Exception {
		assertNull(FileService.getFileByName(null));
	}

	@Test
	public void readPartialCorruptFileByName() throws Exception {
		File fileIn = FileService.getFileByName("Fail001.csv");
		List<InputObject> inputList = FileService.readFileByName(fileIn);
		assertEquals(6, inputList.size());
	}

	@Test
	public void transformFunction() {
		List<InputObject> inputList = new ArrayList<InputObject>();
		InputObject input1 = new InputObject();
		input1.setClient("Client");
		input1.setIncomes(10);
		input1.setZone("Gryffindor");
		for (int i = 0; i < 5; i++) {
			inputList.add(input1);
		}
		List<OutputObject> outputList = TransformationService.transformFunction(inputList);
		assertEquals(1, outputList.size());
		assertTrue(outputList.get(0).getIncomes() == 50);

	}

	@Test
	public void splitByZoneNull() {
		List<OutputObject> outputList = new ArrayList<OutputObject>();
		assertEquals(4, TransformationService.splitByZone(outputList).length);
	}

	@Test
	public void splitByZone() {
		List<OutputObject> outputList = new ArrayList<OutputObject>();
		outputList.add(new OutputObject("Gryffindor", 56, "Client1"));
		outputList.add(new OutputObject("Hufflepuff", 56, "Client1"));
		outputList.add(new OutputObject("Ravenclaw", 56, "Client1"));
		outputList.add(new OutputObject("Gryffindor", 56, "Client2"));
		outputList.add(new OutputObject("Gryffindor", 56, "Client3"));
		outputList.add(new OutputObject("Ravenclaw", 56, "Client2"));
		assertEquals(4, TransformationService.splitByZone(outputList).length);
		assertEquals(3, TransformationService.splitByZone(outputList)[Zone.GRYFFINDOR.getValue()].size());
	}

}
