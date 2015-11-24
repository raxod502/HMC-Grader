
public class CookieBox {
  /********************************
   * Instance Variables 
   ********************************/
  private Cookie[] allTheCookies;
  
  /********************************
   * Constructors
   ********************************/
  public CookieBox(){
    // Start with no cookies!
    this.allTheCookies = new Cookie[0]; 
  }
  /********************************
   * Non-static Methods
   ********************************/
  /**
   * addCookie(Cookie cookieToAdd)
   * 
   * Adds a single Cookie to the CookieBox by expanding the array
   * @param cookieToAdd
   */
  public void addCookie(Cookie cookieToAdd){
    int numCookies = this.allTheCookies.length;
    Cookie[] updatedCookies = new Cookie[1 + numCookies];
    for (int index = 0; index < numCookies; index++) {
      updatedCookies[index] = this.allTheCookies[index];
    }
    updatedCookies[numCookies] = cookieToAdd;
    this.allTheCookies = updatedCookies;
  }

  /**
   * totalCaloriesInBox()
   * @return the total calorie count for all the Cookies in the box.
   */
  public int totalCaloriesInBox(){
    int totalCalories = 0;
    for (Cookie oneCookie : this.allTheCookies){
      totalCalories = totalCalories + oneCookie.getCalories();
    }
    return totalCalories;
  }
}