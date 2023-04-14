public class sqrootBS { 
    public static void main(String[] args) {
       System.out.printf("%.3f" , sqrootNetwonRaphson(40));
    }


    //APPROCH 1
    ///////////////////////////////////////////////////////////////////////////////////
    public static double sqroot(int n, int precision){
        /**
         * I tried the below method of directly doing it within BinarySearch with the searching 
         * itself being double but doesn't work giving output: 0.000. So, have to do for the integer part
         * of the solution first & then adding the precision in decimal places.
            double s= 0.0, e= n, root= 0.0;
            double precisionVal= Math.pow(10, -precision);
            System.out.println(precisionVal);
            while(s <= e){
                double mid = s+ (e-s)/2;
                if(mid*mid == n)
                    return mid;
                if(((n - (mid*mid)) >0) && ((n - (mid*mid)) <= precisionVal))
                    return mid;
                if(mid*mid > n)
                    e= mid-1;
                else 
                    s= mid+1;
            }
            return root;
        */
        int s= 0, e= n;
        double root= 0.0, increment= 0.1;//intial increment
        //Binary Search
        while(s <= e){
            int mid= s+ (e-s)/2;
            if(mid*mid == n)
                return mid;
            if(mid*mid > n)
                e= mid-1;
            else   
                s= mid+1;
        }// we got the integer part here
        root= e;

        int loopCount= 0;
        for (int i = 1; i <= precision; i++) {//runs the number of times for precision in each decimal place
            while(root*root <= n){
                loopCount++;
                root += increment;
            }
            root -= increment;
            increment /= 10;
        }
        System.out.println(loopCount);
        return root;
    }
    ///////////////////////////////////////////////////////////////////////////////////



    //APPROCH 2: Newton Raphson Method
    ///////////////////////////////////////////////////////////////////////////////////

    public static double sqrootNetwonRaphson(int N){
        /*
         * It works as the formula is root= 0.5 * (X + (N / X)); and
         * given X=root, root=root is the soln, so it shall works, basically
         * an iterative way to reduce the error to whatever precision we need.
         */
        double X= N, root=0.0;

        while(true){
            root= 0.5 * (X + (N / X));
            double error= Math.abs(root - X);
            if(error < 0.01)
                break;

            X= root;
        }
        return root;
    }

    ///////////////////////////////////////////////////////////////////////////////////
}