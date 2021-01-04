
1- The methods are in the Main/Java/Consol.class
2- It is assumed that this class will be a Consol type class for static methods Text manipulation, added maybe digit manipulations in other inner classes
3- It is assumed special characters will not be accepted in words
4- It is assumed '.' and ',' can be used in sentences
5- It is assumed it might contain more than 1 sentence. Instead of getting 1st sentence ending with first '.' dot, it collects all the words in entire text.
6- Test covers zero lenght text comparison
7- Empty excel data cell will accept "" instead of throwing nullpointer exception to catch the empty sentences. 0 lenght must be entered in excell not to be left empty
8- Consol.Text.findwords() method generate words and findTheLongestWordsInAText(String text)method generates the lenght and the words equal to this lenght.
9- A text may contain more than 1 maximum word so method will give a Map<Integer-K,List<String>-V> K=maxLength and Value=List of words whose lengths=K
10- Tests will run with Data Provider to collect data from the excel sheet under resources/data, you may add new rows under the range
11- The framework is prepared with TestNg to have maximum Data Driven capability for a Unit Test. Cucumber also possible, with more time availability.
12- Please run the tests and open the reports package and than open the extentreports.html by a browser to see the reports..

