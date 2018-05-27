package robinhoodhashing;
public class bucket<T>{
    
     T value;
    int displacement;
    
    bucket(T value) {
        this.value=value;
        displacement=0;
    }
    bucket() {
    value=null;
    displacement=0;
    
    }
}
