package Logistics;

//import org.junit.Test;
import org.testng.Assert;
import  org.testng.annotations.Test;




public class SenerityDemo extends CreateHashMapExample
{

    static String key,value, singleHeader;

    @Test(enabled = false)
    public void printTestData()
    {
        System.out.print("This is the dummy test case 1");
    }

    @Test(enabled = false)
    public void printTestDataTwo()
    {
        System.out.print("This is the dummy test case 2");
    }

    @Test(enabled = false)
    public void printTestDataThree()
    {
        System.out.print("This is the dummy test case 3");

    }

    @Test
    public void  printSingleHeader(){

        singleHeader = getContentTypeHeader ();

        Assert.assertEquals ("application/json", singleHeader);

    }


    @Test
    public void addMoreHeaders(){

        key = "TestHeaderKey";
        value = "TestHeaderValue";

        //Add new header
        buildCustomHeaders(key, value);


        //Assert.assertEquals (numberMapping, "{TestHeaderKey=TestHeaderValue, Content-Type=application/json}", "The two headersets are equals ");


        //print all headers
        System.out.println("All the headers \t:\t" + numberMapping);

        //print single header
        System.out.println("One Signle header \t:\t" + numberMapping.get (key));


    }
}
