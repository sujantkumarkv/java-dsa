/*
 * FIND INDEX OF A NUMBER IN SORTED INFINITE ARRAY.
 * We can mimic it's behavior assuming we can't directly use it's length, we dont know its END.
 * 
 * We can find the target in chunks of (START, END) & double it every time just like we halved 
 * when searching in BS, it'll take log(N) steps only [FLIP THE BS logic]
 * 
* All we need to do is find START & END index and then just Binary Search, ashte :)
 */
public class indexInInfinite {
    
}
