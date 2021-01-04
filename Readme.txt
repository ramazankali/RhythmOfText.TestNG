
*- You may run the test by running /runcertainclasses.xml   file
*- Than after run you may see the reports at ./reports/extentreport.html  by opening file in chrome

*- The framework is prepared with TestNg to have maximum Data Driven capability for a Unit Test.
*- Cucumber also possible, with more time availability
*- Please run the tests and open the reports package and than open the extentreports.html by a browser to see the reports..
*- You can run the xml suite files as well after adding to the framework in next commits.
*- Tests will run with Data Provider to collect data from the excel sheet under resources/data, you may add new rows under the range
*- The methods are in the Main/Java/Consol.class
*- Tests are in Tests package
*- It is assumed that this class will be a Consol type class for static methods like Text manipulation. Other inner classes maybe added like Integer, Double manipulation etc..
*- It is assumed special characters will not be accepted in words
*- It is assumed [!?'’.",] can be used in sentences and are used as word seperators as well.
*- It is assumed it might contain more than 1 sentence. Instead of getting 1st sentence ending with first '.' dot, it collects all the words in entire text.
*- Test covers zero lenght text comparison
*- Empty excel data cell will transfer to Java a "" string instead of throwing nullpointer exception to catch the empty sentences.
*- 0 value must be entered in excel cells if the expected length is 0, should not be left blank.
*- Consol.Text.findwords() method generate words as a List<String>
*- A text may contain more than 1 maximum word so Consol.text.findTheLongestWordsInAText(String text) will give a Map<Integer-K,List<String>-V>
    K=maxLength and Value=List of words whose lengths=K --> (3,[and,not,..]) (3,[InRhythm,contains])