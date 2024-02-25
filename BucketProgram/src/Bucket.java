public class Bucket {
	private int capacity, current;
	public Bucket(int capacity){//Ex1
		this.capacity = capacity;
		this.current = 0;
	}
	public String toString(){//Ex2
		return " The current state of the bucket: " + this.current + " of " + this.capacity + " liters ";
	}
	public boolean isEmpty(){//Ex3
		return this.current == 0;
	}
	public boolean isFull(){//Ex4
		return this.current == this.capacity;
	}
	public float percent(){//Ex5
		float percentBucket;
		float current = this.current;
		float capacity = this .capacity;
		percentBucket =   (current / capacity) * 100;
		return percentBucket;
	}
	public boolean addLiter(){//Ex6
		boolean result =false;
		if (!isFull()){
			this.current++;
			result = true;
		}
		return result;
	}
	public int addLiters(int amount){//Ex7
		int spaceAvailable = this.capacity - this.current ;//YETER
		if (amount <= spaceAvailable){
			this.current += amount;
			return 0;
		}else {
			this.current = this.capacity;
			return amount - spaceAvailable;
		}
	}
	public boolean spill(){//Ex8
		boolean result = false;
		if (!isEmpty()){
			this.current = 0;
			result =true;
		}
		return result;
	}
	public boolean spill(int amount){//Ex9
		boolean result = false;
		if (amount <= this.current){
			this.current -= amount;
			result = true;
		}
		return result;
	}
	public void fill(){//Ex10
		this.current = this.capacity;
	}
	public void fill(Bucket other){//Ex11
		int spaceAvailable = this.capacity - this.current;
		if (other.current <= spaceAvailable){
			this.current += other.current;
			other.spill();
		}else {
			other.current -= spaceAvailable;
			this.current = this.capacity;
		}
	}
	public void setCapacity(int capacity) {//Ex12
		if (capacity <= 0) {
			System.out.println("Capacity most by positive");
		} else {
			this.capacity = capacity;
		}
	}


}
