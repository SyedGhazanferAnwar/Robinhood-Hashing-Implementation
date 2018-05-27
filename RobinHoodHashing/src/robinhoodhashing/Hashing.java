package robinhoodhashing;
public class Hashing {
     bucket[] buckets;
     Hashing(int bucketSize) {
         buckets = new bucket[bucketSize];
         for(int i=0;i<bucketSize;i++)
        {
            buckets[i]=new bucket("0");
        }
     }
     
     public void insert(String x){
        String newElement=x;
            int arrayIndex=hashFunction(x);
            int disp=0;

            while(true) {
                if(buckets[arrayIndex].value=="0") {
                    buckets[arrayIndex].value=newElement;
                    buckets[arrayIndex].displacement=disp;
                    break;
                }
                if(disp>buckets[arrayIndex].displacement) {
                    //If is deleted logic should be here
                    if(buckets[arrayIndex].value.equals("-999")) {
                        buckets[arrayIndex].value=newElement;
                        buckets[arrayIndex].displacement=disp;
                        break;
                    }
                    
                    String temp=(String)buckets[arrayIndex].value;
                    buckets[arrayIndex].value=newElement;
                    newElement=temp;
                    System.out.println("Swapping   "+newElement+"   &   "+buckets[arrayIndex].value);
                    int temp2=disp;
                    disp=buckets[arrayIndex].displacement;
                    buckets[arrayIndex].displacement=temp2;
                }
                disp++;
                arrayIndex++;
                arrayIndex=arrayIndex%buckets.length;
            }
    }
      public int lookUp(String key) {
        int arrayIndex=hashFunction(key);
        int disp=0;
        while(true) {
            if(buckets[arrayIndex].value.equals("0"))return -1;//Does not exist
            if(disp>buckets[arrayIndex].displacement)return -1;//Does Not exist
            if(buckets[arrayIndex].value.equals(key))return arrayIndex;
            arrayIndex++;
            disp++;
            arrayIndex=arrayIndex%buckets.length;

        }
    }
      public void printHashTable() {
        System.out.println("\n\n");
        for(int i=0;i<buckets.length;i++)
        {
            System.out.println("index:->"+i+"   value:->"+buckets[i].value+"     displacement:->"+buckets[i].displacement +"    orig"+hashFunction((String)buckets[i].value));
        }
    }
      public boolean delete(String key) {
         int arrayIndex=lookUp(key);
         if(arrayIndex==-1)return false;
         buckets[arrayIndex].value="-999";
         return true;
                 
    }
    
    public float loadFactor() {
        float count=0;
        for(int i=0;i<buckets.length;i++)
        {
            if(buckets[i].value!="0") {
                if(buckets[i].value!="-1") count++;
            }
        }
        float loadfactor=count/buckets.length;
        return loadfactor;
    }
    //no limitations any hash function can be used
 
    public int hashFunction(String x) {
        try{
        Integer value = 0;
        for (int i = 0; i < x.length(); i++) {
            value = value*13 + x.charAt(i);//prime numbers are preferd:)
        }
        value=value%buckets.length;
        if(value<0)value=Math.abs(value);
        return value;
        }catch(Exception e)
        {
            return -1;
        }
    }

     public void insert(String[] x) {
        for(int i=0;i<x.length;i++) {
            String element=x[i];
            int key=hashFunction(x[i]);
            if(key==-1)continue;
            int displacement=0;

            while(true) {
                if(buckets[key].value=="0") {
                    buckets[key].value=element;
                    buckets[key].displacement=displacement;
                    break;
                }
                if(displacement>buckets[key].displacement) {
                    //If is deleted logic should be here
                    if(buckets[key].value.equals("-999")) {
                        buckets[key].value=element;
                        buckets[key].displacement=displacement;
                        break;
                    }
                    
                    String temp=(String)buckets[key].value;
                    buckets[key].value=element;
                    element=temp;
                    //System.out.println("Swapping   "+element+"   &   "+buckets[key].value);
                    int temp2=displacement;
                    displacement=buckets[key].displacement;
                    buckets[key].displacement=temp2;
                }
                displacement++;
                key++;
                key=key%buckets.length;
            }
        }
    }
}
