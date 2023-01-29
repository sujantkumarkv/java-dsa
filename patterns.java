public class patterns {
    public static void main(String[] args) {
        pattern28();
    }
    
    static void pattern28() {
        /**
        Pattern 28
         *
        * *
       * * *
      * * * *
     * * * * *
      * * * *
       * * *
        * *
         *
 
         */
        int n=5;
        for(int row=1; row< 2*n; row++){
            int spaceCount= row>n ? (row-n) : (n-row);
            for(int space=1; space<= spaceCount; space++)
                System.out.print(" ");
            
            int colsCount= row>n ? (2*n - row) : (row);
            for(int col=1; col<= colsCount; col++)
                System.out.print("* ");
            
            System.out.println();
        }
    }


    static void pattern31() {
        /**
        Pattern 31

         4 4 4 4 4 4 4  
         4 3 3 3 3 3 4   
         4 3 2 2 2 3 4   
         4 3 2 1 2 3 4   
         4 3 2 2 2 3 4   
         4 3 3 3 3 3 4   
         4 4 4 4 4 4 4   
 
         
        int n=4;
        for(int row=1; row<= 2*n-1; row++){
            
            for(int col= 2*n-1; col>= 1; col--)
                System.out.print(+ " ");
            
            System.out.println();
        }
        */
    }
}
