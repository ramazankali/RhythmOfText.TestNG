package positiveunittests;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import stringmanipulations.Consol;
import utilities.ExcelUtil;
import utilities.TestBase;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class UnitTestsConsolTextPositive extends TestBase {

    @Test(dataProvider = "TC_0001_UnitTestPositiveConsolTextMethodFindWords")
    public void TC_0001_UnitTestPositiveConsolTextMethodFindWords(String text, String expectedWords) {

        extentTest = extentReports.createTest(
                "TC_0001_UnitTests.InRhythm.Consol.Text.FindWords",
                "Testing the Consol.text.FindWords() functionality");
        extentTest.info(String.format("Tested text is : \"%s\"", text));

        List<String> actualListOfWords = Consol.Text.findwords(text);

        List<String> expectedListOfWords = Arrays.asList(expectedWords.split(",").clone());
        expectedListOfWords=expectedListOfWords.
                stream().
                filter(words->words.replaceAll(" ","").length()!=0).
                collect(Collectors.toList());
       if (expectedListOfWords.isEmpty()&&actualListOfWords.isEmpty()){
           extentTest.info(String.format("Text after special Character filtering is empty! %s", actualListOfWords.stream().collect(Collectors.joining())));
       }
       else {

           Assert.assertEquals("The number of expectedWords founded by method is incorrect!",
                   expectedListOfWords.size(),
                   actualListOfWords.size());
           extentTest.info(String.format("Expected number of words: %s matches actual number of words: %s",
                   expectedListOfWords.size(),
                   actualListOfWords.size()));

           Collections.sort(actualListOfWords);
           Collections.sort(expectedListOfWords);

           expectedListOfWords.stream().filter(t -> !actualListOfWords.contains(t)).forEach(System.out::println);
           Assert.assertEquals("The expectedWords founded does not match expected list!", expectedListOfWords, actualListOfWords);

           extentTest.info(String.format("Expected Words: %s", expectedListOfWords));
           extentTest.info(String.format("Actual Words  : %8s", actualListOfWords));
       }

    }

    @DataProvider(name = "TC_0001_UnitTestPositiveConsolTextMethodFindWords")
    public Object[][] getDataTC_0001() throws IOException {
        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/data/TestData.xlsx", "TC_0001");
        int numberOfRows = excelUtil.rowCount();
        int numberOfColumns = excelUtil.columnCount();

        Object[][] obj = new Object[numberOfRows - 1][numberOfColumns];
        for (int r = 0; r < numberOfRows - 1; r++) {
            for (int c = 0; c < numberOfColumns; c++) {

                obj[r][c] = excelUtil.getCellData(r + 1, c);
            }
        }
        return obj;

    }

    @Test(dataProvider = "TC_0002_UnitTestPositiveConsolTextMethodGetWordsAsAMapWithSizesInAText")
    public void TC_0002_UnitTestPositiveConsolTextMethodFindTheLongestWordInAText(
            String text,
            String longestWordLength,
            String words) {

        extentTest = extentReports.createTest(
                "TC_0002_UnitTests.InRhythm.Consol.Text.FindTheLongestWordInAText",
                "Testing the FindTheLongestWordInAText functionality");
        extentTest.info("Starting Test");

        //We create a new map and find the longest word lenght and words whose lenghts are equal to this maximum lenght
        Map<Integer, List<String>> actualMapOfWords = Consol.Text.findTheLongestWordsInAText(text);

        int expectedLenghtOfLongestWord = (int) Double.parseDouble(longestWordLength);
        List<String> expectedListOfWords = Arrays.asList(words.split(",").clone());

        if (!actualMapOfWords.isEmpty() &&
        expectedLenghtOfLongestWord!=0&&
        !expectedListOfWords.isEmpty()) {




            //we get the expected words as a string seperated by comma and here we split to create a list of words by splitting with ","


            //We create a map same as actual map Map<K,V> K is expected lenght and V is expected list of words
            Map<Integer, List<String>> expectedMapOfWords = new HashMap<>();
            expectedMapOfWords.put(expectedLenghtOfLongestWord, expectedListOfWords);

            //We assert the method generated only 1 maximum length integer.
            Assert.assertEquals("The method generated more than 1 maximum lenght!",
                    actualMapOfWords.keySet().size(),
                    expectedMapOfWords.keySet().size());
            extentTest.info(String.format("The method generated a single maximum size as Expected: %d Actual:%d  ", 1, actualMapOfWords.keySet().size()));

            //We assert that the keyset (Lenghts) of expected and generated datas are exactly same
            Assert.assertEquals("Expected and Actual maximum lenghts does not match!", expectedMapOfWords.
                    keySet().
                    stream().
                    findFirst().
                map(lenght -> lenght).
        get().
                            intValue(), actualMapOfWords.keySet().
                    stream().
                    findFirst().
                map(length -> length).
        get().
                            intValue());

            extentTest.info(String.format(
                    "Expected Length: %d matches Actual:%d  ",
                    expectedMapOfWords.
                            keySet().
                            stream().
                            findFirst().
                            map(lenght -> lenght).
                            get(),
                    actualMapOfWords.keySet().
                            stream().
                            findFirst().
                            map(length -> length).
                            get()));

            //We assert the List<String> is exactly same as List<String> actual words
            //we first stream and than sort and than use Collections to check equality

            Assert.assertEquals("Words' Lists do not match!", expectedMapOfWords.
                            get(expectedLenghtOfLongestWord).
                            stream().
                            sorted().collect(Collectors.toList()),
                    actualMapOfWords.get(expectedLenghtOfLongestWord).
                            stream().
                            sorted().
                            collect(Collectors.toList()));

            extentTest.info("The method generated correct list of words as expected");
        }
        else extentTest.info("There is no words in the text after special character filtering!");
    }

    @DataProvider(name = "TC_0002_UnitTestPositiveConsolTextMethodGetWordsAsAMapWithSizesInAText")
    public Object[][] getDataTC_0002() throws IOException {
        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/data/TestData.xlsx", "TC_0002");
        int numberOfRows = excelUtil.rowCount();
        int numberOfColumns = excelUtil.columnCount();

        Object[][] obj = new Object[numberOfRows - 1][numberOfColumns];
        for (int r = 0; r < numberOfRows - 1; r++) {
            for (int c = 0; c < numberOfColumns; c++) {

                obj[r][c] = excelUtil.getCellData(r + 1, c);
            }
        }
        return obj;

    }

}
