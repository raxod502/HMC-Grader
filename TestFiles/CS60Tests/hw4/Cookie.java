/**
 * A Cookie class that models Cookies with simplistic lists of 
 * ingredients and very coarse calorie counting
 * 
 * @author CS60 cookie monster
 */
public class Cookie {
  /********************************
   * Class variables 
   * aka Static Variables
   ********************************/
  public static int cookieCount = 0; 
  private static int handfulOfCookies = 6;
  /********************************
   * Instance Variables 
   ********************************/
  private String type; 
  private String[] ingredients;
  
  /********************************
   * Constructors
   ********************************/
  /**
   * Cookie()
   * 
   * Constructor to create a sugar cookie
   */
  public Cookie(){
    Cookie.cookieCount ++;
    this.type = "Sugar";
    this.ingredients = new String[4];
    this.ingredients[0] = "butter";
    this.ingredients[1] = "sugar";
    this.ingredients[2] = "eggs";
    this.ingredients[3] = "flour";
  }
  /**
   * Cookie (String inputType)
   * 
   * Constructor to make Cookie objects provided the type of the cookie
   * @param inputType - the type of the cookie
   */
  public Cookie(String inputType){
    Cookie.cookieCount ++;
    this.type = inputType;
    if (inputType.equals("chocolate chip")) {
      this.ingredients = new String[5];
      this.ingredients[0] = "chocolate chips";
      this.ingredients[1] = "butter";
      this.ingredients[2] = "sugar";
      this.ingredients[3] = "eggs";
      this.ingredients[4] = "flour";
      
    }
    else if (inputType.equals("gluten free")) {
      this.ingredients = new String[4];
      this.ingredients[0] = "eggs";
      this.ingredients[1] = "sugar";
      this.ingredients[2] = "peanut butter";
      this.ingredients[3] = "chocolate chips";
    }
    else {
      this.ingredients = new String[5];
      this.ingredients[0] = inputType.concat("s");
      this.ingredients[1] = "butter";
      this.ingredients[2] = "sugar";
      this.ingredients[3] = "eggs";
      this.ingredients[4] = "flour";
    }
  }
  
  /********************************
   * Non-static Methods
   ********************************/
  /**
   * getType()
   * @return the type of the cookie
   */
  public String getType(){
    return this.type;
  }
  
  /**
   * getCalories()
   * @return the calories in the batch of cookies
   */
  public int getCalories(){
    return this.ingredients.length * 100;
  }
  
  /**
   * listIngredients()
   * @return a string representing the list of ingredients
   */
  public String listIngredients(){
    // start with [
    String output = "[";
    // add each item followed by a comma and a space
    for (String oneIngredient : this.ingredients) {
      output = output.concat(oneIngredient + ", ");
    }
    // remove the extra comma and space
    output = output.substring(0, output.length()-2);
    // add closing ] and return
    return output + "]";
        
  }
  
  /**
   * addIngredient(String newIngredient)
   * 
   * Modifies the Cookie to include an additional ingredient
   * @param newIngredient
   */
  public void addIngredient(String newIngredient){
    int numIngredients = this.ingredients.length;
    String[] updatedIngredients = new String[1 + numIngredients];
    for (int index = 0; index < numIngredients; index++) {
      updatedIngredients[index] = this.ingredients[index];
    }
    updatedIngredients[numIngredients] = newIngredient;
    this.ingredients = updatedIngredients;
  }
  
  /********************************
   * Static Methods
   ********************************/
  public static int rightNumberOfCookies(){
    return Cookie.handfulOfCookies;
  }
  public static boolean isDeliciousCookieType(String type){
    return type.startsWith("Chocolate");
  } 
}