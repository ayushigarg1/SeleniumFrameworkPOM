package extentReporterListener;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
    public static ExtentReports extent;
    public static ExtentTest test;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = initReports();
        }
        return extent;
    }

    private static ExtentReports initReports() {
        System.out.println("Init Reports");

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/New_Report.html");
        System.out.println("Configuring Reports");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Test Extent Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        System.out.println("Attached SparkReporter");

        return extent;
    }

    public static void flushReports() {
        extent.flush();
    }

    public static void createTest(ExtentReports extentReports, String testcaseName) {
        test = extentReports.createTest(testcaseName).assignAuthor("Ayushi").assignCategory("Regression");
        test.info(testcaseName + " test case is loaded");
        test.pass(testcaseName + " test case is verified");
    }
}