package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {
    public ExtentReports extentReports;
    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentTest extentTest;

    @BeforeTest
    public void setup() {
        //starting the reporter and setting the path. Folder:reprots. File name: extentreport.html
        extentHtmlReporter = new ExtentHtmlReporter("./reports/extentreport.html");
        //Create a folder in the root folder level. Also create a file: extentreport.html

        //Doing some configuration with extentHtmlReporter(OPTIONAL)
        extentHtmlReporter.config().setReportName("RhytmhicReports");
        extentHtmlReporter.config().setTheme(Theme.STANDARD);//Setting the color
        extentHtmlReporter.config().setDocumentTitle("Consol.Text");
        extentHtmlReporter.config().setEncoding("UTF-8");

        //Creating extent reports. We will use this to attach our report
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        //We can give some more configuration
        extentReports.setSystemInfo("Automation Engineer", "Ramazan Kali");
        extentReports.setSystemInfo("Environment", "Test Environment");
        extentReports.setSystemInfo("Test Type", "Consol.text Unit Tests ");

    }

    @AfterTest
    public void endReport() {
        extentReports.flush();
    }

}
