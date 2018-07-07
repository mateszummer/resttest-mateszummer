package sums.smartbar.restcontroller;

import sums.smartbar.service.ProductService;
import sums.smartbar.service.CategoryService;
import sums.smartbar.service.OrderService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ProductRest {


    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value= "/addOrder", method = RequestMethod.POST)
    public String addOrder(@RequestParam("orderDetails") String orderDetails) {
        Gson gson = new Gson();
        HashMap<Integer,Integer> jsonParams = gson.fromJson(orderDetails, HashMap.class);
        boolean success = orderService.addOrder(jsonParams);
        return success ? "ok" : "not ok";


    }

    @RequestMapping(value = "/getAllOrder", method = RequestMethod.GET)
    public String getAllOrder(){
        Gson gson = new Gson();
        return gson.toJson(orderService.getAll());
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll() {
        Gson gson = new Gson();
        return gson.toJson(productService.getAll());
    }

    @RequestMapping(value = "/getDrinksByCategory/{category}", method = RequestMethod.GET)
    public String getDrinkByCategory(@PathVariable("category") Integer categoryId) {
        Gson gson = new Gson();
        return gson.toJson(productService.getAllByCategoryId(categoryId));
    }

    @RequestMapping(value = "/get500", method = RequestMethod.GET)
    public ResponseEntity get500() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    public String getCategories() {
        Gson gson = new Gson();
        return gson.toJson(categoryService.getAllDTO());
    }

    @RequestMapping(value = "/deleteDrink", method = RequestMethod.POST)
    public void deleteDrink(@RequestParam("productId") Integer id) {

        productService.deleteProductById(id);
    }

    @RequestMapping(value = "/deleteCategory", method = RequestMethod.POST)
    public void deleteCategory(@RequestParam("categoryId") Integer categoryId) {
        categoryService.deleteCategoryById(categoryId);
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public void addDrink(@RequestParam("name") String name,
                         @RequestParam("price") Integer price,
                         @RequestParam("categoryId") Integer categoryId,
                         @RequestParam("productId") Integer productId) {
        productService.addProduct(name, price, categoryId, productId);
    }

//    @RequestMapping(value = "/sendMessage/{msg}", method = RequestMethod.GET)
//    public void sendMessage(@PathVariable("msg") String msg) throws IOException {
//        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//                    OkHttpClient client = new OkHttpClient();
//                    JSONObject json=new JSONObject();
//                    JSONObject dataJson=new JSONObject();
//                    dataJson.put("body",msg);
//                    dataJson.put("title","random title");
//                    json.put("notification",dataJson);
//                    json.put("to",androidKey);
//                    com.squareup.okhttp.RequestBody body = com.squareup.okhttp.RequestBody.create(JSON,json.toString());
//                    Request request = new Request.Builder()
//                            .header("Authorization",firebaseSrvKey)
//                            .url("https://fcm.googleapis.com/fcm/send")
//                            .post(body)
//                            .build();
//        client.newCall(request).execute();
//    }
}
