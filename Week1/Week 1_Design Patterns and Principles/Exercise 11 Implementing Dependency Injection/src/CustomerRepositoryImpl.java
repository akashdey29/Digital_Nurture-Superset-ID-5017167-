
import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> customers = new HashMap<>();

    public CustomerRepositoryImpl() {

        customers.put("1", new Customer("1", "John Doe"));
        customers.put("2", new Customer("2", "Jane Smith"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return customers.get(id);
    }
}
