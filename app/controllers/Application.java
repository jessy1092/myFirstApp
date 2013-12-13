package controllers;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Product;
import play.*;
import play.db.ebean.Model;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

public class Application extends Controller 
{

    public static Result index() 
    {
//  	return ok(index.render("Your new application is ready."));
    	return ok("Hello World! Lee 12314212");
    }
    
    public static Result getProduct(Long barcode)
    {
    	List<Product> products = new Model.Finder(String.class, Product.class).all();
    	ObjectNode result = Json.newObject();
    	for(Product product : products)
    	{
    		if(product.barcode == barcode)
    		{
    			result.put("id", product.id);
    			result.put("barcode", product.barcode);
    			result.put("pic1",product.pic1);
    			result.put("pic2",product.pic2);
    			result.put("pic3",product.pic3);
    		}
    		
    	}
    	return ok(result);
    }
    
    public static Result listAll()
    {
    	List<Product> products = new Model.Finder(String.class, Product.class).all();
    	ObjectNode result = Json.newObject();
    	for(Product product : products)
    	{
    		result.put("id", product.id);
    		result.put("barcode", product.barcode);
    	}
    	return ok(result);
    }
    
    public static Result createProduct()
    {
    	Map<String, String[]> values = request().body().asFormUrlEncoded();
    	Product product = new Product();
    	product.barcode = Long.parseLong(values.get("barcode")[0]);
    	product.pic1 = values.get("pic")[0].getBytes();
    	product.pic2 = values.get("pic")[1].getBytes();
    	product.pic3 = values.get("pic")[2].getBytes();
    	return ok(product.barcode + "Sucess");
    	
    }
    
}
