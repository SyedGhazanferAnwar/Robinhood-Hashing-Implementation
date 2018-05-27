package robinhoodhashing;
public class LinearProbingHashTable {
     bucket[] buckets;
     LinearProbingHashTable(int bucketSize) {
         buckets = new bucket[bucketSize];
         for(int i=0;i<bucketSize;i++)
        {
            buckets[i]=new bucket("0");
        }
     }
     
     public void insert(String x){
        int arrayIndex=hashFunction(x);
        int i = arrayIndex;
        do
        {
            if(i==-1)continue;
            if (buckets[i].value == "0")
            {
            buckets[i].value =x ;
            return;
            }
            i = (i + 1) % buckets.length;
        }while (i != arrayIndex);
    }
     public void insertArray(String x[])
     {
         for(int i=0;i<x.length;i++)
         {
             insert(x[i]);
         }
     }
      public int lookUp(String key) {
        int arrayIndex=hashFunction(key);
        int i = arrayIndex;
        do
        {
            if (buckets[i].value == key)
            {
                return 1;
            }

            i = (i + 1) % buckets.length;
        }while (i != arrayIndex);
        return -1;
    }
      public void printHashTable() {
        System.out.println("\n\n");
        for(int i=0;i<buckets.length;i++)
        {
            System.out.println("index:->"+i+"   value:->"+buckets[i].value+"+  orig"+hashFunction((String)buckets[i].value));
        }
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
}
