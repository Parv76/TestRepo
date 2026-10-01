package test;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.path.json.JsonPath;

public class Complexjsonparse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//this is used when there is no original response but has a simulated response
		JsonPath js = new JsonPath(Payload.getCoursedetails());
		int count = js.getInt("courses.size()");
		int purchaseamt = js.getInt("courses[0].price");
		String titleFirst = js.getString("courses[0].title");
		System.out.println("Count is " + count);
		System.out.println("Purchase amt of Selenium python "+ purchaseamt );
		System.out.println("Title of first course "+ titleFirst );
		//System.out.println("\n"+js.getString("courses[0].title")+"  "+ js.getInt("courses[0].price")+
		//"  "+js.getString("courses[1].title")+"  "+ js.getInt("courses[1].price")
//		+"  "+js.getString("courses[2].title")+ "  "+js.getInt("courses[2].price"));
 for(int i=0;i<count;i++)
 {
	System.out.println(js.getString("courses["+i+"].title")+"  ");
	System.out.println(js.getInt("courses["+i+"].price")+"  ");
 }
 for(int i=0;i<count;i++)
 {
 if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA"))
 {
		System.out.println("Noof copies sold RPA course "+ js.getInt("courses["+i+"].copies")+"  " );
break;
}

	 }
 //int sum=0;
 int prod1=0;int prod2=0;int realprod =0;
 //int indprod =0;
 for(int i=0;i<count;i++)
 {
	prod1 = js.getInt("courses["+i+"].price");
	prod2 = js.getInt("courses["+i+"].copies");
	 //sum= sum +  js.getInt("courses["+i+"].price");
	 realprod = realprod + prod1*prod2;

 }	
 System.out.println(realprod);
 int PurchaseAmt = js.getInt("dashboard.purchaseAmount");
 System.out.println(PurchaseAmt);
 if (realprod == PurchaseAmt )
 {
	 System.out.println("Purchase amount is equal to sum of all course price");

 }
 else
	 System.out.println("Purchase amount is not equal to sum of all course price");
	}

}
