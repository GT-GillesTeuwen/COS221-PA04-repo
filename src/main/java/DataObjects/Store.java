package DataObjects;

public class Store {
    private String store;
    private int id;

	public Store(String store, int id) {
		this.store = store;
		this.id = id;
	}

	public String getStore() {
		return store;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return store;
	}

   

}
