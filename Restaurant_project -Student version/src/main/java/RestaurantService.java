import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
        for (Restaurant rests : this.restaurants) {
            if (rests.getName().equals(restaurantName)) {
                return rests;
            }
        }
        throw new restaurantNotFoundException(restaurantName);
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        if(restaurantToBeRemoved != null) return restaurantToBeRemoved;
        throw new restaurantNotFoundException(restaurantName);
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
